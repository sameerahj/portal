package org.dhara.portal.web.airavataClient;

import org.apache.airavata.workflow.model.wf.Workflow;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/7/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AiravataClientAPIService {
    public List<Workflow> getAllWorkflows();
    public Workflow getWorkflow(String identifier);

}
