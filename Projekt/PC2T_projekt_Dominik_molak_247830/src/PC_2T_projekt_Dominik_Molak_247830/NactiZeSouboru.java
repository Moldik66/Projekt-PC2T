package PC_2T_projekt_Dominik_Molak_247830;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NactiZeSouboru
{
	public static void loadBookFromFile(Scanner scanner)
	{
        System.out.println("Zadej název knihy, o které chceš získat informace:");
        String bookTitle = scanner.nextLine();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Informace_knihy.txt"));
            String line;
            boolean foundBook = false;

            while ((line = reader.readLine()) != null)
            {
                if (line.contains("Název knihy: " + bookTitle))
                {
                    foundBook = true;
                    System.out.println(line);
                    while ((line = reader.readLine()) != null && !line.equals("-----------------------------------"))
                    {
                        System.out.println(line);
                    }
                    break;
                }
            }
            
            if (!foundBook)
            {
                System.out.println("Kniha s názvem '" + bookTitle + "' nebyla nalezena.");
            }

            reader.close();
        } catch (IOException e)
        {
            System.out.println("Nastala chyba při čtení souboru.");
            e.printStackTrace();
        }
    }
}