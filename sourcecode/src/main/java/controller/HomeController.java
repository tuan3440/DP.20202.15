package controller;

import java.sql.SQLException;
import java.util.List;

import dao.media.MediaDAO;

/**
 * This class controls the flow of events in homescreen
 * @author nguyenlm
 */
public class HomeController extends CartController {


    /**
     * this method gets all Media in DB and return back to home to display
     * @return List[Media]
     * @throws SQLException
     */
	//Data coupling
	//Functional Conhesion
    public static List getAllMedia() throws SQLException{
        return new MediaDAO().getAllMedia();
    }
}