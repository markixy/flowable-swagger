package io.github.markixy.flowable.ui;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author markix
 */
@ConfigurationProperties(prefix = "flowable-ui.swagger")
public class FlowableUiSwaggerProperties {

    private boolean enabled = true;

    private AppSwagger task = new AppSwagger();
    private AppSwagger admin = new AppSwagger();
    private AppSwagger idm = new AppSwagger();
    private AppSwagger idmApi = new AppSwagger();
    private AppSwagger modeler = new AppSwagger();
    private AppSwagger modelerApi = new AppSwagger();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public AppSwagger getTask() {
        return task;
    }

    public void setTask(AppSwagger task) {
        this.task = task;
    }

    public AppSwagger getAdmin() {
        return admin;
    }

    public void setAdmin(AppSwagger admin) {
        this.admin = admin;
    }

    public AppSwagger getIdm() {
        return idm;
    }

    public void setIdm(AppSwagger idm) {
        this.idm = idm;
    }

    public AppSwagger getIdmApi() {
        return idmApi;
    }

    public void setIdmApi(AppSwagger idmApi) {
        this.idmApi = idmApi;
    }

    public AppSwagger getModeler() {
        return modeler;
    }

    public void setModeler(AppSwagger modeler) {
        this.modeler = modeler;
    }

    public AppSwagger getModelerApi() {
        return modelerApi;
    }

    public void setModelerApi(AppSwagger modelerApi) {
        this.modelerApi = modelerApi;
    }

    public static class AppSwagger {

        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
