package org.dhara.portal.web.airavataClientAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.airavata.workflow.model.wf.WorkflowData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nipuni
 * Date: 6/28/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/workflows")
public class sendWorkflows extends HttpServlet {



    public  void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        clientAPI_list_workflows list_workflows = new clientAPI_list_workflows();
        List<WorkflowData> workflows = list_workflows.displayWorkflows();
        for(WorkflowData data : workflows){

            JsonElement JsonElement = (new JsonParser()).parse(data.getName());
            jsonArray.add(JsonElement);
        }
        jsonObject.add("array",jsonArray);
        PrintWriter out = response.getWriter();
        out.write("ok");

    }



}
