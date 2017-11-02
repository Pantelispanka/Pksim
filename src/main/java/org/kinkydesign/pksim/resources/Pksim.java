/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kinkydesign.pksim.resources;

import io.swagger.annotations.Api;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
    
    public Response getModel(){
        return Response.ok().build();
    }
    
    
    
}
