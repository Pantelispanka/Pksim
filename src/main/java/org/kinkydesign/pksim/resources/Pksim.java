/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kinkydesign.pksim.resources;

import com.google.gson.JsonParser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kinkydesign.pksim.Utils;
import org.kinkydesign.pksim.dto.ErrorReport;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * @author pantelispanka
 */
@Path("/services")
@Consumes("application/json")
@Produces("application/json")
@Api(value = "/services", tags = "services")
public class Pksim {

    @Inject
    Utils utils;

    String rTrainModelPath;

    @POST
    @Path("train")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value="creates and returns the model")
    @ApiResponses( value = {@ApiResponse(code = 200 , message = "", response = JsonObject.class),
            @ApiResponse(code = 500, message = "Unkown Error", response = ErrorReport.class)})
    public Response trainModel(JsonObject json) {
    String jsonFileName = UUID.randomUUID().toString();
    try {
        utils.createFileWithJsonObject(json, jsonFileName);
    } catch (IOException e) {
        e.printStackTrace();
    }

    String result = utils.runRScript(rTrainModelPath, jsonFileName);
    JsonParser parser = new JsonParser();
    parser.parse(result);
    System.out.println(result);
    return Response.ok().build();
}


    @POST
    @Path("predict")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value="creates a prediction")
    @ApiResponses( value = {@ApiResponse(code = 200 , message = "", response = JsonObject.class),
            @ApiResponse(code = 500, message = "Unkown Error", response = ErrorReport.class)})
    public Response getPrediction(JsonObject json){
        return Response.ok().build();
    }




}
