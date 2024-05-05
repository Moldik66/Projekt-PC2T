package PC_2T_projekt_Dominik_Molak_247830;

public class VypisUcebniceRoman
{
    public static void displayBorrowedBooksInfo(Library library)
    {
        System.out.println("Vypůjčené knihy:");

        boolean found = false;
        for (int i = 0; i < library.getBookCount(); i++)
        {
            Book book = library.getBookAtIndex(i);
            if (!book.isAvailable())
            {
                System.out.println("Název: " + book.getTitle());
                System.out.println("Typ knihy: " + getBookType(book));
                System.out.println("Autor: " + String.join(", ", book.getAuthors()));
                System.out.println("Žánr/Ročník: " + (Character.isDigit(book.getGenre().charAt(0)) ? "Vhodné pro ročník " : "") + book.getGenre());
                System.out.println("Rok publikace: " + book.getYear());
                System.out.println();
                
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("Žádné vypůjčené knihy nebyly nalezeny.");
        }
    }

    private static String getBookType(Book book)
    {
        if (book.getGenre().equalsIgnoreCase("Učebnice"))
        {
            return "Učebnice";
        } else {
            return "Román";
        }
    }
}