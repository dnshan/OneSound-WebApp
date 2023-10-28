package lk.oneSound.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Model.Admin;
import lk.oneSound.dao.AdminDAO;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;

    public void init() {
        adminDAO = new AdminDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/AdminServlet/new":
                    showNewForm(request, response);
                    break;
                case "/AdminServlet/insert":
                    insertSong(request, response);
                    break;
                case "/AdminServlet/delete":
                    deleteSong(request, response);
                    break;
                case "/AdminServlet/edit":
                    showEditForm(request, response);
                    break;
                case "/AdminServlet/update":
                    updateSong(request, response);
                    break;
                default:
                    listSongs(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listSongs(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<Admin> listSongs = adminDAO.selectAllSongs();
        System.out.println("listSongs: " + listSongs.size());
        request.setAttribute("listSongs", adminDAO.selectAllSongs());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminaddSong.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
    	System.out.println("test showEditForm");
        int artistid = Integer.parseInt(request.getParameter("artistid"));
        Admin existingSong = adminDAO.selectSong(artistid);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Adminupdatesong.jsp");
        request.setAttribute("song", existingSong);
        dispatcher.forward(request, response);
    }

    private void insertSong(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	System.out.println("test insert song");
        int artistid = Integer.parseInt(request.getParameter("artistid"));
        String songname = request.getParameter("songname");
        String duration = request.getParameter("duration");
        String category = request.getParameter("category");
        Admin newSong = new Admin(artistid, songname, duration, category);
        //using admin dao to insert song
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.insertSong(newSong);
        response.sendRedirect("/OneSound");
    }

    private void updateSong(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int artistid = Integer.parseInt(request.getParameter("artistid"));
        String songname = request.getParameter("songname");
        String duration = request.getParameter("duration");
        String category = request.getParameter("category");

        Admin song = new Admin(artistid, songname, duration, category);
        adminDAO.updateSong(song);
        response.sendRedirect("/OneSound");
    }

    private void deleteSong(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int artistid = Integer.parseInt(request.getParameter("artistid"));
        adminDAO.deleteSong(artistid);
        response.sendRedirect("/OneSound");
    }
}
