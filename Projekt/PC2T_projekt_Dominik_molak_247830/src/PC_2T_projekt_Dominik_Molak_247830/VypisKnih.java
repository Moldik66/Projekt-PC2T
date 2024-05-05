package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Arrays;
import java.util.Comparator;

public class VypisKnih
{
	 public static void displayBooks(Book[] books, int bookCount)
	 {
	        Arrays.sort(books, 0, bookCount, Comparator.comparing(Book::getTitle));

	        System.out.println("Knihy v Knihovně:");
	        for (int i = 0; i < bookCount; i++)
	        {
	            Book book = books[i];
	            System.out.println("Název: " + book.getTitle());
                System.out.println("Autor: " + String.join(", ", book.getAuthors()));
                System.out.println("Žánr/Ročník: " + (Character.isDigit(book.getGenre().charAt(0)) ? "Vhodné pro ročník " : "") + book.getGenre());
                System.out.println("Rok publikace: " + book.getYear());
                System.out.println("Dostupnost: " + (book.isAvailable() ? "Dostupná" : "Nedostupná"));
                System.out.println();
	        }
	  }
}