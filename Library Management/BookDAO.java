import java.sql.*;
import java.util.*;

public class BookDAO {
    public void addBook(String title, String author) {
        String sql = "INSERT INTO books (title, author, available) VALUES (?, ?, true)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBooks() {
        List<String> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                books.add(rs.getInt("id") + " - " +
                          rs.getString("title") + " by " +
                          rs.getString("author") +
                          " [Available: " + rs.getBoolean("available") + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
