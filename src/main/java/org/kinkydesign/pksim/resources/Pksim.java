/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kinkydesign.pksim.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.kinkydesign.pksim.Utils;
import org.kinkydesign.pksim.dto.ErrorReport;
import org.kinkydesign.pksim.dto.TrainingResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    @POST
    @Path("train")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value="creates and returns the model")
    @ApiResponses( value = {@ApiResponse(code = 200 , message = "", response = JsonObject.class),
            @ApiResponse(code = 500, message = "Unkown Error", response = ErrorReport.class)})
    public Response trainModel(JsonObject json) {

            try {
                utils.createFileWithJsonObject(json, UUID.randomUUID().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // set up the command and parameter
            String pythonScriptPath = "C:\\Users\\Angelos\\Desktop\\wildfly-10.1.0.Final\\pythonHello.py";
            String[] cmd = new String[2];
            cmd[0] = "python"; // check version of installed python: python -V
            cmd[1] = pythonScriptPath;

            // create runtime to execute external command
            Runtime rt = Runtime.getRuntime();
            Process pr = null;
            try {
                pr = rt.exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // retrieve output from python script
            BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            try {
                while ((line = bfr.readLine()) != null) {
                    // display each output line form python script
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
