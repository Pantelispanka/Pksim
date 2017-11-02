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
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.kinkydesign.pksim.dto.ErrorReport;
import org.kinkydesign.pksim.dto.TrainingResponse;

/**
 *
 * @author pantelispanka
 */

@Consumes("application/json")
@Produces("application/json")
@Api(value = "/Cas", tags = "Cas")
public class Pksim {
    
    
    @POST
    @Path("train")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value="converts cas to smiles",extensions={
            @Extension(name="openrisknet",properties={
                    @ExtensionProperty(name="register_service", value="false")
            })
    })
    @ApiResponses( value = {@ApiResponse(code = 200 , message = "", response = JsonObject.class),
            @ApiResponse(code = 500, message = "Unkown Error", response = ErrorReport.class)})
    public Response trainModel(JsonObject json){
        return Response.ok().build();
    }
    
    
    @POST
    @Path("train")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value="converts cas to smiles",extensions={
            @Extension(name="openrisknet",properties={
                    @ExtensionProperty(name="register_service", value="false")
            })
    })
    @ApiResponses( value = {@ApiResponse(code = 200 , message = "", response = JsonObject.class),
            @ApiResponse(code = 500, message = "Unkown Error", response = ErrorReport.class)})
    public Response getPrediction(JsonObject json){
        return Response.ok().build();
    }
    
    
    
}
