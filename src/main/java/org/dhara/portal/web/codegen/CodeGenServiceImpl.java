package org.dhara.portal.web.codegen;

import org.apache.airavata.workflow.model.wf.Workflow;
import org.dhara.portal.web.airavataClient.AiravataClientAPIService;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/26/13
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodeGenServiceImpl implements CodeGenService{
    private AiravataClientAPIService airavataClientAPIService;

    public String getGeneratedClass(String workflowId)  {
        Workflow workflow=airavataClientAPIService.getWorkflow(workflowId);

        return null;
    }

    public String getGeneratedClassForCustomDeployment(String worklfowId, Map<String, String> inputsMapping, Map<String, String> outputsMapping, String extendingAlgorithm) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private String generateClassFromTemplate() {
        return null;
    }
    public AiravataClientAPIService getAiravataClientAPIService() {
        return airavataClientAPIService;
    }

    public void setAiravataClientAPIService(AiravataClientAPIService airavataClientAPIService) {
        this.airavataClientAPIService = airavataClientAPIService;
    }
}
