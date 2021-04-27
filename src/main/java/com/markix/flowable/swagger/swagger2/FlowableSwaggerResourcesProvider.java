package com.markix.flowable.swagger.swagger2;

import com.markix.flowable.swagger.Constants;
import com.markix.flowable.swagger.FlowableSwaggerProperties;
import org.flowable.spring.boot.FlowableServlet;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.flowable.spring.boot.app.FlowableAppProperties;
import org.flowable.spring.boot.cmmn.FlowableCmmnProperties;
import org.flowable.spring.boot.content.FlowableContentProperties;
import org.flowable.spring.boot.dmn.FlowableDmnProperties;
import org.flowable.spring.boot.eventregistry.FlowableEventRegistryProperties;
import org.flowable.spring.boot.form.FlowableFormProperties;
import org.flowable.spring.boot.idm.FlowableIdmProperties;
import org.flowable.spring.boot.process.FlowableProcessProperties;
import org.flowable.spring.boot.rest.BaseRestApiConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.util.ClassUtils;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger2.web.Swagger2Controller;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

/**
 * @author markix
 */
public class FlowableSwaggerResourcesProvider extends InMemorySwaggerResourcesProvider implements ApplicationContextAware {

    private final String swagger2Url;
    private ApplicationContext applicationContext;
    private FlowableSwaggerProperties swaggerProperties;

    @Autowired(required = false)
    private FlowableProcessProperties flowableProcessProperties;
    @Autowired(required = false)
    private FlowableEventRegistryProperties flowableEventRegistryProperties;
    @Autowired(required = false)
    private FlowableAppProperties flowableAppProperties;
    @Autowired(required = false)
    private FlowableIdmProperties flowableIdmProperties;
    @Autowired(required = false)
    private FlowableFormProperties flowableFormProperties;
    @Autowired(required = false)
    private FlowableDmnProperties flowableDmnProperties;
    @Autowired(required = false)
    private FlowableContentProperties flowableContentProperties;
    @Autowired(required = false)
    private FlowableCmmnProperties flowableCmmnProperties;

    public FlowableSwaggerResourcesProvider(Environment environment, DocumentationCache documentationCache, FlowableSwaggerProperties swaggerProperties) {
        super(environment, documentationCache);
        this.swagger2Url = environment.getProperty("springfox.documentation.swagger.v2.path", Swagger2Controller.DEFAULT_URL);
        this.swaggerProperties = swaggerProperties;
        addFlowableEngineSwaggerSwitchProperties((ConfigurableEnvironment) environment, swaggerProperties);
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = super.get();
        addFlowableResources(resources);
        return resources;
    }


    private void addFlowableEngineSwaggerSwitchProperties(ConfigurableEnvironment environment, FlowableSwaggerProperties swaggerProperties){
        //添加属性，flowable各个模块根据属性值判断是否开启Swagger
        Properties properties = new Properties();
        properties.put(Constants.Property.PROCESS, swaggerProperties.getProcess().isEnabled());
        properties.put(Constants.Property.APP, swaggerProperties.getApp().isEnabled());
        properties.put(Constants.Property.CMMN, swaggerProperties.getCmmn().isEnabled());
        properties.put(Constants.Property.CONTENT, swaggerProperties.getContent().isEnabled());
        properties.put(Constants.Property.DMN, swaggerProperties.getDmn().isEnabled());
        properties.put(Constants.Property.FORM, swaggerProperties.getForm().isEnabled());
        properties.put(Constants.Property.IDM, swaggerProperties.getIdm().isEnabled());
        properties.put(Constants.Property.EVENT_REGISTRY, swaggerProperties.getEventRegistry().isEnabled());
        properties.put(Constants.Property.EXTERNAL_JOB, swaggerProperties.getExternalJob().isEnabled());
        environment.getPropertySources().addLast(new PropertiesPropertySource(Constants.Property.NAME, properties));
    }

    private void addFlowableResources(List<SwaggerResource> resources) {
        Optional.ofNullable(flowableProcessProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getProcess(), resources, RestApiAutoConfiguration.ProcessEngineRestApiConfiguration.class, prop.getServlet()));
        Optional.ofNullable(flowableAppProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getApp(), resources, RestApiAutoConfiguration.AppEngineRestApiConfiguration.class, prop.getServlet()));
        Optional.ofNullable(flowableCmmnProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getCmmn(), resources, RestApiAutoConfiguration.CmmnEngineRestApiConfiguration.class, prop.getServlet()));
        Optional.ofNullable(flowableContentProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getContent(), resources, RestApiAutoConfiguration.ContentEngineRestApiConfiguration.class, prop.getServlet()));
        Optional.ofNullable(flowableDmnProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getDmn(), resources, RestApiAutoConfiguration.DmnEngineRestApiConfiguration.class, prop.getServlet()));
        Optional.ofNullable(flowableFormProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getForm(), resources, RestApiAutoConfiguration.FormEngineRestApiConfiguration.class, prop.getServlet()));
        Optional.ofNullable(flowableIdmProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getIdm(), resources, RestApiAutoConfiguration.IdmEngineRestApiConfiguration.class, prop.getServlet()));
        Optional.ofNullable(flowableEventRegistryProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getEventRegistry(), resources, RestApiAutoConfiguration.EventRegistryRestApiConfiguration.class, prop.getServlet()));

        addFlowable66AdditionalResource(resources);
    }

    private void addFlowable66AdditionalResource(List<SwaggerResource> resources) {
        boolean flag = ClassUtils.isPresent("org.flowable.spring.boot.RestApiAutoConfiguration.ExternalJobRestApiConfiguration", ClassUtils.getDefaultClassLoader());
        if(flag){
            Optional.ofNullable(flowableProcessProperties).ifPresent(prop -> addFlowableResource(swaggerProperties.getExternalJob(), resources, RestApiAutoConfiguration.ExternalJobRestApiConfiguration.class, Constants.EXTERNAL_JOB));
        }
    }

    private void addFlowableResource(FlowableSwaggerProperties.EngineSwagger engineSwagger, List<SwaggerResource> resources, Class<? extends BaseRestApiConfiguration> configurationClass, FlowableServlet servlet) {
        if (engineSwagger.isEnabled() && applicationContext.containsBean(configurationClass.getName())) {
            resources.add(buildSwaggerResource(servlet.getName(), servlet.getPath() + swagger2Url));
        }
    }

    private SwaggerResource buildSwaggerResource(String name, String url) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setUrl(url);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}