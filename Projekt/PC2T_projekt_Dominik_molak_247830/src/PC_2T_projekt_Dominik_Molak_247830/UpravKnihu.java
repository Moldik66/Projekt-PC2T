package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Scanner;

class UpravKnihu {
    public static void updateBook(Library library, Scanner scanner)
    {
        System.out.println("Zadejte název knihy, kterou chcete upravit:");
        String title = scanner.nextLine();

        Book book = library.findBook(title);
        if (book != null)
        {
            System.out.println("Kniha nalezena. Co chcete upravit? (1 - Autor, 2 - Rok, 3 - Dostupnost):");

            int choice = getUpdateChoice(scanner);

            switch (choice)
            {
                case 1:
                    updateAuthors(book, scanner);
                    break;
                case 2:
                    updateYear(book, scanner);
                    break;
                case 3:
                    updateAvailability(book, scanner);
                    break;
                default:
                    System.out.println("Nastala chyba.");
            }
        } else
        {
            System.out.println("Kniha nenalezena.");
        }
    }

    private static int getUpdateChoice(Scanner scanner)
    {
        int choice;
        while (true)
        {
            System.out.println("Zadejte číslo volby (1 - Autor, 2 - Rok, 3 - Dostupnost):");
            while (!scanner.hasNextInt()) {
                System.out.println("Nesprávný vstup. Zadejte číslo volby (1 - Autor, 2 - Rok, 3 - Dostupnost):");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 3)
            {
                break;
            } else
            {
                System.out.println("Nesprávný vstup. Zadejte číslo volby (1 - Autor, 2 - Rok, 3 - Dostupnost):");
            }
        }
        scanner.nextLine();
        return choice;
    }

    private static void updateAuthors(Book book, Scanner scanner)
    {
        System.out.println("Zadejte nové jméno autora:");
        String[] authors = scanner.nextLine().split(",");
        book.setAuthors(authors);
        System.out.println("Autor knihy upraven.");
    }

    private static void updateYear(Book book, Scanner scanner)
    {
        int year;
        do
        {
            System.out.println("Zadejte nový rok publikace:");
            while (!scanner.hasNextInt())
            {
                System.out.println("Nesprávný vstup pro rok publikace. Zadejte prosím celé číslo:");
                scanner.next();
            }
            year = scanner.nextInt();
        } while (year <= 0);
        scanner.nextLine();
        book.setYear(year);
        System.out.println("Rok publikace knihy upraven.");
    }

    private static void updateAvailability(Book book, Scanner scanner)
    {
        System.out.println("Zadejte novou dostupnost knihy (true/false):");
        boolean available;
        while (!scanner.hasNextBoolean())
        {
            System.out.println("Nesprávný vstup pro dostupnost knihy. Zadejte 'true' nebo 'false':");
            scanner.next();
        }
        available = scanner.nextBoolean();
        scanner.nextLine();
        book.setAvailable(available);
        System.out.println("Dostupnost knihy upravena.");
    }
}