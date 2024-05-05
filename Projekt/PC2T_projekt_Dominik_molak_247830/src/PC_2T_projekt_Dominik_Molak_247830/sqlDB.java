package PC_2T_projekt_Dominik_Molak_247830;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlDB
{
    private static final String DATABASE_URL = "jdbc:mysql://sql.endora.cz:3312/dbprg2tvut";
    private static final String USERNAME = "moldik";
    private static final String PASSWORD = "heslo";

    public static void saveDataToDatabase(Library library)
    {
        Book[] books = library.getBooks();
        int bookCount = library.getBookCount();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD))
        {
            String deleteQuery = "DELETE FROM knihy";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery))
            {
                deleteStatement.executeUpdate();
            }

            String insertQuery = "INSERT INTO knihy (nazev, autor, publikace, dostupnost, zanr) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery))
            {
                for (int i = 0; i < bookCount; i++)
                {
                    Book book = books[i];
                    insertStatement.setString(1, book.getTitle());
                    insertStatement.setString(2, String.join(", ", book.getAuthors()));
                    insertStatement.setInt(3, book.getYear());
                    insertStatement.setBoolean(4, book.isAvailable());
                    insertStatement.setString(5, book.getGenre());
                    insertStatement.executeUpdate();
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void loadDataFromDatabase(Library library) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM knihy";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String title = resultSet.getString("nazev");
                    String[] authors = resultSet.getString("autor").split(", ");
                    int year = resultSet.getInt("publikace");
                    boolean available = resultSet.getBoolean("dostupnost");
                    String genre = resultSet.getString("zanr");

                    Book book = new Book(title, authors, year, available, genre);
                    library.addBook(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}