/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tour.model.Model;
import tour.model.entities.City;
import tour.model.entities.Tour;

/**
 *
 * @author ferna
 */
@Path("/tours")
public class TourController {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Tour> getTours() {
        try {
            return Model.getInstance().ListTours();
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @POST
    @Path("/searchTours")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tour> searchTour(City city, Date initial, Date end) {
        List<Tour> tours = new ArrayList();
        try {
            if (initial != null && end != null) {
                tours = Model.getInstance().ListTourByTwoDates(initial, end);
            } else {
                if (initial != null && end == null) {
                    tours = Model.getInstance().ListTourByDate(initial);
                } else {
                    if (city.getName() != null) {
                        tours = Model.getInstance().ListTourByCity(city.getName());
                    }
                }
            }
            return tours;
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }
}
