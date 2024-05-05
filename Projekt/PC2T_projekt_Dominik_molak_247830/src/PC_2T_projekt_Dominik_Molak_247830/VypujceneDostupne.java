package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Scanner;

public class VypujceneDostupne
{
	public static void markBookAsBorrowed(Library library, Scanner scanner)
	{
        System.out.println("Zadejte název knihy, kterou si chcete vypůjčit:");
        String title = scanner.nextLine();
        Book book = library.findBook(title);
        if (book != null)
        {
            if (book.isAvailable())
            {
                book.setAvailable(false);
                System.out.println("Kniha je právě vypůjčená.");
            } else
            {
                System.out.println("Kniha už byla vypůjčená.");
            }
        } else
        {
            System.out.println("Kniha nebyla nalezena.");
        }
    }

    public static void markBookAsReturned(Library library, Scanner scanner)
    {
        System.out.println("Zadej název knihy, kterou chceš vrátit:");
        String title = scanner.nextLine();
        Book book = library.findBook(title);
        if (book != null)
        {
            if (!book.isAvailable())
            {
                book.setAvailable(true);
                System.out.println("Kniha je právě vrácená.");
            } else
            {
                System.out.println("Kniha už byla vrácená.");
            }
        } else
        {
            System.out.println("Kniha nebyla nalezena.");
        }
    }
}