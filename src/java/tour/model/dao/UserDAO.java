/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.model.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import tour.model.dao.connection.ConnectionBD;
import tour.model.dao.exceptions.GlobalException;
import tour.model.dao.exceptions.NoDataException;
import tour.model.entities.Country;
import tour.model.entities.User;

/**
 *
 * @author ferna
 */
public class UserDAO extends ConnectionBD {

    private static UserDAO mInstance;
    private static final String ADDUSER = "{call prc_ins_user (?,?,?,?,?,?,?)}";
    private static final String GETUSER = "SELECT NAME, LASTNAME, EMAIL, PASSWORD, ROLE, BIRTHDAY, COUNTRY FROM USERTOUR WHERE EMAIL=? AND PASSWORD=?";

    public UserDAO() {
    }

    public static UserDAO getInstance() {
        if (mInstance == null) {
            mInstance = new UserDAO();
        }
        return mInstance;
    }
    
    public void addNewUserTour(User PuserTour) throws GlobalException, NoDataException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = connectionAux.prepareCall(ADDUSER);
            pstmt.setString(1, PuserTour.getName());
            pstmt.setString(2, PuserTour.getLastName());
            pstmt.setString(3, PuserTour.getEmail());
            pstmt.setString(4, PuserTour.getPassword());
            pstmt.setString(5, PuserTour.getRole());
            pstmt.setString(6, formatter.format(PuserTour.getBirthDay()));
            pstmt.setString(7, PuserTour.getCountry().getCode());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la insercion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                disconnect();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }
    
    public User getUser(String email, String password) throws GlobalException, NoDataException {
       User user = new User();
       try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(GETUSER);
            stm.clearParameters();
            stm.setString(1, email);
            stm.setString(2, password);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                  user = new User(rs.getString("NAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("ROLE"), rs.getDate("BIRTHDAY"), new Country(rs.getString("COUNTRY"),""));  
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return user;
    }
    
        public static void main(String[] args) {
        //User u = new User("Maria", "Gonzalez", "fer@gmail.com", "crp525.", "user", );
        UserDAO us = UserDAO.getInstance();
        try {
            //us.addNewUserTour(u);
            System.out.println("fue");
            System.out.println(us.getUser("fer@gmail.com", "Crp.1701!"));
            System.out.println(us.toString());
        } catch (GlobalException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
