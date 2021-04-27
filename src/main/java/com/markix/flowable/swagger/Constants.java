package com.markix.flowable.swagger;

import org.flowable.spring.boot.FlowableServlet;

/**
 * @author markix
 */
public interface Constants {

    FlowableServlet EXTERNAL_JOB = new FlowableServlet("/external-job-api", "Flowable External Job Rest API");

}
