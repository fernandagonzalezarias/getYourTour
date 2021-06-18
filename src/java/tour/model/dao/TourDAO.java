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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tour.model.dao.connection.ConnectionBD;
import tour.model.dao.exceptions.GlobalException;
import tour.model.dao.exceptions.NoDataException;
import tour.model.entities.CategoryActivity;
import tour.model.entities.City;
import tour.model.entities.Tour;

// EIF411 - Diseño y programación de plataformas móviles
// I Ciclo 2021
//
// Students:
//    - 117660980     María Fernanda González Arias
//    - 116980485     Scarleth Villarreal Jiménez
public class TourDAO extends ConnectionBD {

    private static TourDAO mInstance;
    private static final String ADDTOUR = "{call prc_ins_tour(?,?,?,?,?,?,?,?,?)}";
    private static final String LISTTOURBYCITY = "select t.id ID, t.name NAME, t.description DESCRIPTION, t.duration DURATION, t.Initialdate INITIALDATE, t.price PRICE, t.maxCant MAXCANT, t.guidance GUIDANCE, c.name CITY "
            + "from tour t, city c, country co "
            + "where t.CITY_CODE= c.CODE and c.COUNTRY_CODE=co.CODE and c.name = ?";
    private static final String LISTTOURBYDATES = "select t.id ID, t.name NAME, t.description DESCRIPTION, t.duration DURATION, t.Initialdate INITIALDATE, t.price PRICE, t.maxCant MAXCANT, t.guidance GUIDANCE, c.name CITY "
            + "from tour t, city c, country co "
            + "where t.CITY_CODE= c.CODE and c.COUNTRY_CODE=co.CODE and t.Initialdate between to_date(?, 'dd/mm/YYYY') and to_date(?, 'dd/mm/YYYY')";
    private static final String LISTTOURBYDATE = "select t.id ID, t.name NAME, t.description DESCRIPTION, t.duration DURATION, t.Initialdate INITIALDATE, t.price PRICE, t.maxCant MAXCANT, t.guidance GUIDANCE, c.name CITY "
            + "from tour t, city c, country co "
            + "where t.CITY_CODE= c.CODE and c.COUNTRY_CODE=co.CODE and t.Initialdate = to_date(?, 'dd/mm/YYYY')";
    private static final String LISTIMAGESBYTOUR = "select i.path ||'' ||i.name image from images i, tourImages ti, tour t where ti.ID_IMAGES=i.ID and ti.TOUR_ID=?";
    private static final String LISTACTIVITIESBYTOUR = "select a.DESCRIPTION DESCRIPTION from ACTIVITIY a, TOURACTIVITIES ti, tour t where a.ID=ti.ID_ACTIVITY and t.ID=?";
    private static final String LISTTOURS = "select t.id ID, t.name NAME, t.description DESCRIPTION, t.duration DURATION, t.Initialdate INITIALDATE, t.price PRICE, t.maxCant MAXCANT, t.guidance GUIDANCE, c.name CITY "
            + "from tour t, city c, country co "
            + "where t.CITY_CODE= c.CODE and c.COUNTRY_CODE=co.CODE";
    
    public static TourDAO instance() {
        if (mInstance == null) {
            mInstance = new TourDAO();
        }
        return mInstance;
    }

    public TourDAO() {
    }

    public void addNewTour(Tour PTour) throws GlobalException, NoDataException {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            pstmt = connectionAux.prepareCall(ADDTOUR);
            pstmt.setString(1, PTour.getName());
            pstmt.setString(2, PTour.getDescription());
            pstmt.setFloat(3, PTour.getDuration());
            pstmt.setString(4, formatter.format(PTour.getInicitalDate()));
            pstmt.setFloat(5, PTour.getPrice());
            pstmt.setInt(6, PTour.getCategory().getId());
            pstmt.setInt(7, PTour.getMaxCant());
            pstmt.setString(8, PTour.getGuidance());
            pstmt.setString(9, PTour.getCity().getCode());
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
    
    public List<Tour> ListTours() {
        List<Tour> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTTOURS);
            stm.clearParameters();
            //stm.setString(1, city);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(new Tour(rs.getInt("ID"), rs.getInt("MAXCANT"), rs.getString("NAME"), rs.getString("DESCRIPTION"), rs.getString("GUIDANCE"), rs.getFloat("DURATION"), rs.getFloat("PRICE"), rs.getDate("INITIALDATE"), new City(null, rs.getString("CITY"), null), new CategoryActivity(rs.getInt("ID_CATEGORY"), null)));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<Tour> ListTourByCity(String city) {
        List<Tour> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTTOURBYCITY);
            stm.clearParameters();
            stm.setString(1, city);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(new Tour(rs.getInt("ID"), rs.getInt("MAXCANT"), rs.getString("NAME"), rs.getString("DESCRIPTION"), rs.getString("GUIDANCE"), rs.getFloat("DURATION"), rs.getFloat("PRICE"), rs.getDate("INITIALDATE"), new City(null, rs.getString("CITY"), null), new CategoryActivity(rs.getInt("ID_CATEGORY"), null)));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<Tour> ListTourByDates(Date initial, Date back) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        List<Tour> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTTOURBYDATES);
            stm.clearParameters();
            stm.setString(1, formatter.format(initial));
            stm.setString(1, formatter.format(back));
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(new Tour(rs.getInt("ID"), rs.getInt("MAXCANT"), rs.getString("NAME"), rs.getString("DESCRIPTION"), rs.getString("GUIDANCE"), rs.getFloat("DURATION"), rs.getFloat("PRICE"), rs.getDate("INITIALDATE"), new City(null, rs.getString("CITY"), null), new CategoryActivity(rs.getInt("ID_CATEGORY"), null)));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<Tour> ListTourByOneDate(Date initial) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        List<Tour> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTTOURBYDATE);
            stm.clearParameters();
            stm.setString(1, formatter.format(initial));
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(new Tour(rs.getInt("ID"), rs.getInt("MAXCANT"), rs.getString("NAME"), rs.getString("DESCRIPTION"), rs.getString("GUIDANCE"), rs.getFloat("DURATION"), rs.getFloat("PRICE"), rs.getDate("INITIALDATE"), new City(null, rs.getString("CITY"), null), new CategoryActivity(rs.getInt("ID_CATEGORY"), null)));
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<String> ListImagesByTour(int idTour) {
        List<String> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTIMAGESBYTOUR);
            stm.clearParameters();
            stm.setInt(1, idTour);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    String relativePath = rs.getString("IMAGE");
                    r.add(relativePath);
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<String> ListActivitiesByTour(int idTour) {
        List<String> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTACTIVITIESBYTOUR);
            stm.clearParameters();
            stm.setInt(1, idTour);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    String relativePath = rs.getString("DESCRIPTION");
                    r.add(relativePath);
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
