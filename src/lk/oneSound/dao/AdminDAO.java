package lk.oneSound.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import lk.oneSound.Model.Admin;
import lk.oneSound.Utility.DBConnection;

public class AdminDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/onlinemusicstore";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_SONGS_SQL = "INSERT INTO song (artistid, songname, duration, category) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SONG_BY_ID = "SELECT artistid, songname, duration, category FROM song WHERE artistid = ?";
    private static final String SELECT_ALL_SONGS = "SELECT artistid, songname, duration, category FROM song";
    private static final String DELETE_SONG_SQL = "DELETE FROM song WHERE artistid = ?";
    private static final String UPDATE_SONG_SQL = "UPDATE song SET songname = ?, duration = ? WHERE artistid = ?";

    public AdminDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    

    public void insertSong(Admin admin) throws SQLException {
        System.out.println(INSERT_SONGS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_SONGS_SQL)) {
            preparedStatement.setInt(1, admin.getartistid());
            preparedStatement.setString(2, admin.getsongname());
            preparedStatement.setString(3, admin.getduration());
            preparedStatement.setString(4, admin.getcategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Admin selectSong(int artistid) {
        Admin admin = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONG_BY_ID)) {
            preparedStatement.setInt(1, artistid);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("artistid");
                String name = rs.getString("songname");
                String songDuration = rs.getString("duration");
                String songCategory = rs.getString("category");
                admin = new Admin(id, name, songDuration, songCategory);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return admin;
    }

    public List<Admin> selectAllSongs() {
        List<Admin> songs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SONGS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("artistid");
                String name = rs.getString("songname");
                String songDuration = rs.getString("duration");
                String songCategory = rs.getString("category");
                Admin admin = new Admin(id, name, songDuration, songCategory);
                songs.add(admin);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return songs;
    }

    public boolean deleteSong(int artistid) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SONG_SQL)) {
            preparedStatement.setInt(1, artistid);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateSong(Admin admin) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SONG_SQL)) {
            preparedStatement.setString(1, admin.getsongname());
            preparedStatement.setString(2, admin.getduration());
            preparedStatement.setInt(3, admin.getartistid());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
