package org.dhara.portal.web.controllers;

import org.apache.airavata.workflow.model.wf.Workflow;
import org.dhara.portal.web.airavataClient.AiravataClientAPIServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nipuni
 * Date: 7/27/13
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkflowController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) throws Exception {

        ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        AiravataClientAPIServiceImpl airavataClientAPIService = new AiravataClientAPIServiceImpl();

        List<Workflow> workflowList = airavataClientAPIService.getAllWorkflows();

         return new ModelAndView("", "", workflowList);
    }
}
