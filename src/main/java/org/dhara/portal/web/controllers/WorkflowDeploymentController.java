package org.dhara.portal.web.controllers;

import org.dhara.portal.web.airavataClient.AiravataClientAPIService;
import org.dhara.portal.web.codegen.CodeGenService;
import org.dhara.portal.web.springHibernateSample.entity.Customer;
import org.dhara.portal.web.springHibernateSample.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/29/13
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class WorkflowDeploymentController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        AiravataClientAPIService airavataClientAPIService= (AiravataClientAPIService) context.getBean("airavataAPIService");
        CodeGenService codeGenService=(CodeGenService) context.getBean("codeGenService");
        String s=codeGenService.getGeneratedClass("EchoWorkflow");
        return new ModelAndView("helloworld", "now", s);
    }
}
