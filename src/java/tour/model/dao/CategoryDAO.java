/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.model.dao;

import tour.model.dao.connection.ConnectionBD;

// EIF411 - Diseño y programación de plataformas móviles
// I Ciclo 2021
//
// Students:
//    - 117660980     María Fernanda González Arias
//    - 116980485     Scarleth Villarreal Jiménez
public class CategoryDAO extends ConnectionBD {

    private static CategoryDAO mInstance;

    public static CategoryDAO instance() {
        if (mInstance == null) {
            mInstance = new CategoryDAO();
        }
        return mInstance;
    }

    public CategoryDAO() {
    }

}
