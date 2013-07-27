package org.dhara.portal.web.airavataClient;

import org.apache.airavata.client.AiravataAPIFactory;
import org.apache.airavata.client.api.AiravataAPI;
import org.apache.airavata.client.api.AiravataAPIInvocationException;
import org.apache.airavata.client.api.WorkflowManager;
import org.apache.airavata.registry.api.PasswordCallback;
import org.apache.airavata.rest.client.PasswordCallbackImpl;
import org.apache.airavata.workflow.model.wf.Workflow;
import org.dhara.portal.web.exception.PortalException;

import java.net.URI;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/7/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class AiravataClientAPIServiceImpl implements AiravataClientAPIService{

    private AiravataConfig airavataConfig;
    private static AiravataAPI airavataClientAPI;



    public AiravataClientAPIServiceImpl() throws PortalException {
        airavataConfig = new AiravataConfig();
        airavataClientAPI = this.setAiravataApi();
    }

    public static AiravataAPI getAiravataClientAPI() {
        return airavataClientAPI;
    }

    private AiravataAPI setAiravataApi() {
        int port = airavataConfig.getPort();
        String serverUrl = airavataConfig.getServerUrl();
        String serverContextName = airavataConfig.getServerContextName();
        String username = airavataConfig.getUserName();
        String password = airavataConfig.getPassword();
        String gatewayName = airavataConfig.getGatewayName();

        String registryURL = "http://" + serverUrl + ":" + port + "/" + serverContextName + "/api";
        AiravataAPI airavataAPI = null;

        try{
            PasswordCallback passwordCallback = new PasswordCallbackImpl(username, password);
            airavataAPI = AiravataAPIFactory.getAPI(new URI(registryURL), gatewayName, username, passwordCallback);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return airavataAPI;
    }

    public void setAiravataConfig(AiravataConfig airavataConfairavataAPIig) {
        this.airavataConfig = airavataConfairavataAPIig;
    }

    public List<Workflow> getAllWorkflows() {
        List<Workflow> workflows = null;
        WorkflowManager workflowManager=getAiravataClientAPI().getWorkflowManager();
        try {
            workflows=workflowManager.getWorkflows();
        } catch (AiravataAPIInvocationException e) {
            e.printStackTrace();
        }
        return workflows;
    }

    public Workflow getWorkflow(String identifier) {
        Workflow workflow = null;
        WorkflowManager workflowManager=getAiravataClientAPI().getWorkflowManager();
        try {
            workflow=workflowManager.getWorkflow(identifier);
        } catch (AiravataAPIInvocationException e) {
            e.printStackTrace();
        }
        return workflow;
    }

    public AiravataConfig getAiravataConfig() {
        return airavataConfig;
    }
}
