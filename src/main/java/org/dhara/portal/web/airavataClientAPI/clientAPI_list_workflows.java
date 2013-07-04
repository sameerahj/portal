package org.dhara.portal.web.airavataClientAPI;

import org.apache.airavata.client.AiravataAPIFactory;
import org.apache.airavata.client.api.AiravataAPI;
import org.apache.airavata.client.api.WorkflowManager;
import org.apache.airavata.client.api.exception.AiravataAPIInvocationException;
import org.apache.airavata.registry.api.PasswordCallback;
import org.apache.airavata.rest.client.PasswordCallbackImpl;
import org.apache.airavata.workflow.model.wf.WorkflowData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URI;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: nipuni
 * Date: 6/20/13
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class clientAPI_list_workflows {

    private static final Logger log = LoggerFactory.getLogger(clientAPI_list_workflows.class);

    private static int port;
    private static String serverUrl;
    private static String serverContextName;

    private static String registryURL;

    private static String gatewayName = "default";
    private static String userName = "admin";
    private static String password = "admin";

    private static AiravataAPI airavataAPI;

    private static List<WorkflowData> workflowDataList;

    /*public static void main(String[] args) throws URISyntaxException, AiravataAPIInvocationException {

        clientAPI_list_workflows client= new clientAPI_list_workflows();
        workflowDataList = client.displayWorkflows();
        for (WorkflowData next : workflowDataList) {
            System.out.println(next.getName());
        }



    }*/

    public static List<WorkflowData> displayWorkflows() {
        // creating airavata client object //
        port = Integer.parseInt("8080");
        serverUrl = "localhost";
        serverContextName = "airavata-registry";
        System.out.println((new File(".")).getAbsolutePath());
        log.info("Configurations - port : " + port);
        log.info("Configurations - serverUrl : " + serverUrl);
        log.info("Configurations - serverContext : " + serverContextName);

        registryURL = "http://" + serverUrl + ":" + port + "/" + serverContextName + "/api";

        log.info("Configurations - Registry URL : " + registryURL);
        try{
            PasswordCallback passwordCallback = new PasswordCallbackImpl(getUserName(), getPassword());
            airavataAPI = AiravataAPIFactory.getAPI(new URI(getRegistryURL()), getGatewayName(), getUserName(),passwordCallback);
            WorkflowManager workflowManager=airavataAPI.getWorkflowManager();
            workflowDataList=workflowManager.getAllWorkflows();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return workflowDataList;
    }

    public static int getPort() {
        return port;
    }

    public static String getServerUrl() {
        return serverUrl;
    }

    public static String getServerContextName() {
        return serverContextName;
    }

    public static String getRegistryURL() {
        return registryURL;
    }

    public static String getGatewayName() {
        return gatewayName;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

}
