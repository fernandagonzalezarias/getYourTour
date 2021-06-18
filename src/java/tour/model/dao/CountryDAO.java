/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tour.model.dao.connection.ConnectionBD;
import tour.model.entities.City;
import tour.model.entities.Country;

public class CountryDAO extends ConnectionBD {

    private static CountryDAO mInstance;
    private static final String LISTCOUNTRY = "SELECT CODE, NAME FROM COUNTRY";
    private static final String LISTCITY = "SELECT CODE, NAME FROM CITY";

    public static CountryDAO instance() {
        if (mInstance == null) {
            mInstance = new CountryDAO();
        }
        return mInstance;
    }

    public CountryDAO() {
    }

    public List<Country> ListCountry() {
        List<Country> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTCOUNTRY);
            stm.clearParameters();
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(new Country(rs.getString("CODE"), rs.getString("NAME"))
                    );
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CountryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<City> ListCity() {
        List<City> r = new ArrayList<>();
        try {
            connect();
            PreparedStatement stm = connectionAux.prepareStatement(LISTCITY);
            stm.clearParameters();
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    r.add(new City(rs.getString("CODE"), rs.getString("NAME"), null)
                    );
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CountryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public static void main(String[] args) {
        CountryDAO country = CountryDAO.instance();
        List<City> coun = country.ListCity();
        coun.forEach((c) -> {
            System.out.println(c.toString());
        });
    }
}
