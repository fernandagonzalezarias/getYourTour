
package tour.model;

import java.util.Date;
import java.util.List;
import tour.model.dao.CategoryDAO;
import tour.model.dao.CountryDAO;
import tour.model.dao.TourDAO;
import tour.model.dao.UserDAO;
import tour.model.dao.exceptions.GlobalException;
import tour.model.dao.exceptions.NoDataException;
import tour.model.entities.Tour;
import tour.model.entities.User;

public class Model {
    private static Model myInstance;
    private final UserDAO userDAO;
    private final TourDAO tourDAO;
    private final CategoryDAO categoryDAO;
    private final CountryDAO countryDAO;
    
    public static Model getInstance() {
        if (myInstance == null) {
            myInstance = new Model();

        }
        return myInstance;
    }

    public Model() {
        this.userDAO = UserDAO.getInstance();
        this.tourDAO = TourDAO.instance();
        this.categoryDAO = CategoryDAO.instance();
        this.countryDAO = CountryDAO.instance();
    }
    
    public void addNewUser(User user) throws NoDataException, GlobalException {
        userDAO.addNewUserTour(user);
    }
    
    public User getUser (String email, String password)throws NoDataException, GlobalException {
        return userDAO.getUser(email, password);
    }
    
    public void addNewTour(Tour PTour) throws GlobalException, NoDataException {
        tourDAO.addNewTour(PTour);
    }
    
    public List<Tour> ListTourByCity(String city){
        return tourDAO.ListTourByCity(city);
    }
    
    public List<Tour> ListTours( ){
        return tourDAO.ListTours();
    }
    
    public List<Tour> ListTourByDate(Date first){
        return tourDAO.ListTourByOneDate(first);
    }
    
    public List<Tour> ListTourByTwoDates(Date first, Date second){
        return tourDAO.ListTourByDates(first, second);
    }
}
