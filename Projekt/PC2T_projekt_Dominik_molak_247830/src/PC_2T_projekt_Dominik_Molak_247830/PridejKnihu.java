package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Scanner;

class PridejKnihu {
    public static void addBook(Library library, Scanner scanner)
    {
        int bookType;

        do
        {
            bookType = getBookTypeInput(scanner);
        } while (bookType < 1 || bookType > 2);
        scanner.nextLine();

        System.out.println("Zadejte název knihy:");
        String title = scanner.nextLine();

        System.out.println("Zadejte jméno autora:");
        String[] authors = scanner.nextLine().split(",");

        int year;
        
        do
        {
            year = getYearInput(scanner);
        } while (year <= 0);
        scanner.nextLine();

        System.out.println("Je kniha dostupná? (true/false):");

        boolean available;
        available = getAvailabilityInput(scanner);
        scanner.nextLine();

        if (bookType == 1)
        {
            System.out.println("Zadejte žánr Románu:");
            String genre = scanner.nextLine();

            Book roman = new Book(title, authors, year, available, genre);
            System.out.println("Kniha úspěšně přidána.");
            library.addBook(roman);
        } else if (bookType == 2)
        {
            int suitableForYear;

            do
            {
                suitableForYear = getSuitableForYearInput(scanner);
            } while (suitableForYear <= 0);
            scanner.nextLine();
            
            Book textbook = new Book(title, authors, year, available, String.valueOf(suitableForYear));
            System.out.println("Kniha úspěšně přidána.");
            library.addBook(textbook);
        } else
        {
            System.out.println("Nastala chyba.");
        }
    }

    private static int getBookTypeInput(Scanner scanner)
    {
        System.out.println("Jakou knihu chcete přidat? (1 - Román, 2 - Učebnice):");
        while (!scanner.hasNextInt())
        {
            System.out.println("Nesprávný vstup. Zadejte 1 pro Román nebo 2 pro Učebnice:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int getYearInput(Scanner scanner)
    {
        System.out.println("Zadejte rok publikace:");
        while (!scanner.hasNextInt()) {
            System.out.println("Nesprávný vstup pro rok publikace. Zadejte prosím celé číslo:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean getAvailabilityInput(Scanner scanner)
    {
        while (!scanner.hasNextBoolean())
        {
            System.out.println("Nesprávný vstup pro dostupnost knihy. Zadejte 'true' nebo 'false':");
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    private static int getSuitableForYearInput(Scanner scanner)
    {
        System.out.println("Pro jaký ročník je kniha vhodná?");
        while (!scanner.hasNextInt())
        {
            System.out.println("Nesprávný vstup pro ročník. Zadejte prosím celé číslo:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}