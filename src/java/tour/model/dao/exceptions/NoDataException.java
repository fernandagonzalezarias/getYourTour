package tour.model.dao.exceptions;

// EIF411 - Diseño y programación de plataformas móviles 
// I Ciclo 2021
//
// Autores:
//    - 117660980     María Fernanda González Arias
//    - 116980485     Scarleth Villarreal Jiménez
public class NoDataException extends java.lang.Exception {

    public NoDataException() {
    }

    public NoDataException(String msg) {
        super(msg);
    }
}
