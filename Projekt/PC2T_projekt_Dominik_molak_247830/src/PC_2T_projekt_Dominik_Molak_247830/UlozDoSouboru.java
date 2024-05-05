package PC_2T_projekt_Dominik_Molak_247830;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UlozDoSouboru
{
	public static void saveBookToFile(Library library, Scanner scanner)
	{
        System.out.println("Zadej název knihy, kterou chceš uložit do souboru:");
        String bookTitle = scanner.nextLine();

        Book bookToSave = library.findBook(bookTitle);
        if (bookToSave != null)
        {
            try {
                FileWriter writer = new FileWriter("Informace_knihy.txt", true);
                writer.write("\n-----------------------------------\n");
                writer.write("Název knihy: " + bookToSave.getTitle() + "\n");
                writer.write("Autor: ");
                for (String author : bookToSave.getAuthors())
                {
                    writer.write(author + ", ");
                }
                writer.write("\nRok publikace: " + bookToSave.getYear() + "\n");
                writer.write("Dostupnost: " + (bookToSave.isAvailable() ? "Dostupná" : "Nedostupná") + "\n");
                writer.write("Žánr/Ročník: " + (Character.isDigit(bookToSave.getGenre().charAt(0)) ? "Vhodné pro ročník " : "") + bookToSave.getGenre());
                writer.close();
                System.out.println("Informace o knize byly úspěšně uloženy do souboru 'Informace_knihy.txt'.");
            } catch (IOException e)
            {
                System.out.println("Nastala chyba při ukládání informací o knize do souboru.");
                e.printStackTrace();
            }
        } else
        {
            System.out.println("Kniha s názvem '" + bookTitle + "' nebyla nalezena.");
        }
    }
}