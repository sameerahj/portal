package org.dhara.portal.web.codegen;

import org.dhara.portal.web.airavataClient.AiravataClientAPIService;

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
        return null;
    }

    private String generateClass() {
        String builder= new String();

    }
    public AiravataClientAPIService getAiravataClientAPIService() {
        return airavataClientAPIService;
    }

    public void setAiravataClientAPIService(AiravataClientAPIService airavataClientAPIService) {
        this.airavataClientAPIService = airavataClientAPIService;
    }
}
