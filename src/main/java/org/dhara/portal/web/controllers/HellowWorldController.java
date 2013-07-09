package org.dhara.portal.web.controllers;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/8/13
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.Date;

public class HellowWorldController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        return new ModelAndView("helloworld", "now", now);
    }
}
