package lk.oneSound.Controller;

import lk.oneSound.Model.Review;
import lk.oneSound.dao.ReviewDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ArtistReadSongController {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public ArtistReadSongController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void getAndSetSongs() {
        ReviewDao reviewDao = new ReviewDao();
        List<Review> songs = reviewDao.getAllSongs();
        // Set the list of songs as an attribute in the request object
        request.setAttribute("songs", songs);

        // Forward the request to the JSP page where you want to display the songs
        // For example, assuming your JSP page is named "songs.jsp"
        try {
            request.getRequestDispatcher("Songs.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly (log it, throw a custom exception, etc.)
        }
    }
}
