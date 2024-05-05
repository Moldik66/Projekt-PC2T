package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Scanner;

class SmazKnihu
{
    public static void deleteBook(Library library, Scanner scanner)
    {
        System.out.println("Zadejte název knihy, kterou chcete smazat:");
        String title = scanner.nextLine();

        library.deleteBook(title);
    }
}