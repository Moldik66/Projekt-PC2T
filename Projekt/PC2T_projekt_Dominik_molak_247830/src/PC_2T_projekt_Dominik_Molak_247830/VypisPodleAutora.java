package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Arrays;
import java.util.Comparator;

public class VypisPodleAutora
{
    public static void displayBooksByAuthor(Book[] books, int bookCount, String authorName)
    {
        Book[] booksByAuthor = new Book[bookCount];
        int count = 0;

        for (int i = 0; i < bookCount; i++)
        {
            Book book = books[i];
            for (String author : book.getAuthors())
            {
                if (author.equalsIgnoreCase(authorName))
                {
                    booksByAuthor[count++] = book;
                    break;
                }
            }
        }

        Arrays.sort(booksByAuthor, 0, count, Comparator.comparing(Book::getYear));

        if (count > 0) {
            System.out.println("Knihy od " + authorName + " chronologicky:");
            for (int i = 0; i < count; i++)
            {
                Book book = booksByAuthor[i];
	            System.out.println("Název: " + book.getTitle());
                System.out.println("Autor: " + String.join(", ", book.getAuthors()));
                System.out.println("Žánr/Ročník: " + (Character.isDigit(book.getGenre().charAt(0)) ? "Vhodné pro ročník " : "") + book.getGenre());
                System.out.println("Rok publikace: " + book.getYear());
                System.out.println("Dostupnost: " + (book.isAvailable() ? "Dostupná" : "Nedostupná"));
                System.out.println();
            }
        } else
        {
            System.out.println("Nebyly nalezeny žádné knihy od autora " + authorName + ".");
        }
    }
}