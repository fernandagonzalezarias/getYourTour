/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import tour.model.Model;
import tour.model.entities.User;

/**
 *
 * @author ferna
 */

@Path("/users")
public class UserController {

    @Context
    HttpServletRequest request;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    private User LoginUser(User user) {
        User logged = null;
        try {
            logged = Model.getInstance().getUser(user.getEmail(), user.getPassword());
            return logged;
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }

}
