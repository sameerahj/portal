package org.dhara.portal.web.airavataClientAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.airavata.workflow.model.wf.WorkflowData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nipuni
 * Date: 6/28/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/workflows")
public class sendWorkflows {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listWorkflows() {

        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        try {

        clientAPI_list_workflows list_workflows = new clientAPI_list_workflows();
        List<WorkflowData> workflows = list_workflows.displayWorkflows();


            for(WorkflowData data : workflows){

                JsonElement JsonElement = (new JsonParser()).parse(data.getName());
                jsonArray.add(JsonElement);
            }


            jsonObject.add("array",jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity(jsonObject.toString()).build();

    }



    }
