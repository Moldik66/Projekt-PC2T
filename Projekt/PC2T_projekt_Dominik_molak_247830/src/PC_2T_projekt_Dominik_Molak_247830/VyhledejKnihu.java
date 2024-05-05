package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Scanner;

public class VyhledejKnihu
{
	public static void searchBookByName(Book[] books, int bookCount, Scanner scanner)
	{
        System.out.println("Zadejte název knihy, kterou hledáte:");
        String title = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < bookCount; i++)
        {
            if (books[i].getTitle().equalsIgnoreCase(title))
            {
                displayBookDetails(books[i]);
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("Kniha nebyla nalezena.");
        }
    }
    
    private static void displayBookDetails(Book book)
    {
        System.out.println("Název: " + book.getTitle());
        System.out.println("Autor: " + String.join(", ", book.getAuthors()));
        System.out.println("Žánr/Ročník: " + (Character.isDigit(book.getGenre().charAt(0)) ? "Vhodné pro ročník " : "") + book.getGenre());
        System.out.println("Rok publikace: " + book.getYear());
        System.out.println("Dostupnost: " + (book.isAvailable() ? "Dostupná" : "Nedostupná"));
        System.out.println();
    }
}