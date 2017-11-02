/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kinkydesign.pksim;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.kinkydesign.pksim.resources.Pksim;

/**
 *
 * @author pantelispanka
 */
@ApplicationPath("/services")
public class PKsimApplication extends Application{
    
    public PKsimApplication(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setDescription("Pksim Services");
        beanConfig.setVersion("1.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("192.168.0.112:8080");
        beanConfig.setBasePath("/pksim/services");
        beanConfig.setResourcePackage("org.kinkydesign.pksim.resources");
        beanConfig.setScan(true);
    }
    
     @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(Pksim.class);
        resources.add(SwaggerSerializers.class);
        resources.add(ApiListingResource.class);

        return resources;
    }
    
    
    
}
