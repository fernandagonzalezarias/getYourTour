/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.Produces;
import tour.model.entities.Country;
import tour.model.entities.User;

/**
 *
 * @author ferna
 */
@Path("/countries")
public class CountryController {
    
    @GET 
    @Consumes(MediaType.APPLICATION_JSON)
    public Country get() {
        try {
            Country admin = new Country("CRC", "Costa Rica");
            return admin;
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
}
