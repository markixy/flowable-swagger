package com.markix.flowable.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author markix
 */
@ConfigurationProperties(prefix = "flowable.swagger")
public class FlowableSwaggerProperties {

    private boolean enabled = true;

    private EngineSwagger process = new EngineSwagger();
    private EngineSwagger app = new EngineSwagger();
    private EngineSwagger cmmn = new EngineSwagger();
    private EngineSwagger content = new EngineSwagger();
    private EngineSwagger dmn = new EngineSwagger();
    private EngineSwagger eventRegistry = new EngineSwagger();
    private EngineSwagger form = new EngineSwagger();
    private EngineSwagger idm = new EngineSwagger();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public EngineSwagger getProcess() {
        return process;
    }

    public void setProcess(EngineSwagger process) {
        this.process = process;
    }

    public EngineSwagger getApp() {
        return app;
    }

    public void setApp(EngineSwagger app) {
        this.app = app;
    }

    public EngineSwagger getCmmn() {
        return cmmn;
    }

    public void setCmmn(EngineSwagger cmmn) {
        this.cmmn = cmmn;
    }

    public EngineSwagger getContent() {
        return content;
    }

    public void setContent(EngineSwagger content) {
        this.content = content;
    }

    public EngineSwagger getDmn() {
        return dmn;
    }

    public void setDmn(EngineSwagger dmn) {
        this.dmn = dmn;
    }

    public EngineSwagger getEventRegistry() {
        return eventRegistry;
    }

    public void setEventRegistry(EngineSwagger eventRegistry) {
        this.eventRegistry = eventRegistry;
    }

    public EngineSwagger getForm() {
        return form;
    }

    public void setForm(EngineSwagger form) {
        this.form = form;
    }

    public EngineSwagger getIdm() {
        return idm;
    }

    public void setIdm(EngineSwagger idm) {
        this.idm = idm;
    }

    public static class EngineSwagger {

        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
