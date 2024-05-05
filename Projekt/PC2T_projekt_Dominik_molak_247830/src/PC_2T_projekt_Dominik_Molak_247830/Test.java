package PC_2T_projekt_Dominik_Molak_247830;
import java.util.Scanner;

class Book
{
    private String title;
    private String[] authors;
    private int year;
    private boolean available;
    private String genre;

    public Book(String title, String[] authors, int year, boolean available, String genre)
    {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.available = available;
        this.genre = genre;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String[] getAuthors()
    {
        return authors;
    }

    public void setAuthors(String[] authors)
    {
        this.authors = authors;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }
    
    public String getGenre()
    {
        return genre;
    }
}

class Library
{
    private Book[] books;
    private int bookCount;

    public Library(int size)
    {
        books = new Book[size];
        bookCount = 0;
    }

    public void addBook(Book book)
    {
        if (bookCount < books.length)
        {
            books[bookCount] = book;
            bookCount++;
        } else
        {
            System.out.println("Knihovna je plná.");
        }
    }

    public void displayBooks()
    {
        VypisKnih.displayBooks(books, bookCount);
    }
    
    public void searchBookByName(Scanner scanner)
    {
        VyhledejKnihu.searchBookByName(books, bookCount, scanner);
    }
    
    public void displayBooksByAuthor(Scanner scanner)
    {
        System.out.println("Zadej jméno autora:");
        String authorName = scanner.nextLine();
        VypisPodleAutora.displayBooksByAuthor(books, bookCount, authorName);
    }
    
    public Book findBook(String title)
    {
        for (int i = 0; i < bookCount; i++)
        {
            if (books[i].getTitle().equalsIgnoreCase(title))
            {
                return books[i];
            }
        }
        return null;
    }
    
    public void displayBooksByGenre(Scanner scanner)
    {
        System.out.println("Zadej žánr knihy:");
        String genre = scanner.nextLine();
        VypisPodleZanru.displayBooksByGenre(books, bookCount, genre);
    }

    public void deleteBook(String title)
    {
        for (int i = 0; i < bookCount; i++)
        {
            if (books[i].getTitle().equalsIgnoreCase(title))
            {
                for (int j = i; j < bookCount - 1; j++)
                {
                    books[j] = books[j + 1];
                }
                bookCount--;
                System.out.println("Kniha byla odstraněna.");
                return;
            }
        }
        System.out.println("Kniha nebyla nalezena.");
    }
    
    public int getBookCount()
    {
        return bookCount;
    }
    
    public Book getBookAtIndex(int index)
    {
        if (index >= 0 && index < bookCount)
        {
            return books[index];
        } else {
            return null;
        }
    }

	public Book[] getBooks()
	{
        return books;
	}
}

class Správce
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Správa knihovny");
        System.out.println();                
        Library library = new Library(100);
        sqlDB.loadDataFromDatabase(library);
        char choice;
        do
        {
            System.out.println("Vyberte úkon:");
            System.out.println("a) Přidat knihu");
            System.out.println("b) Upravit knihu");
            System.out.println("c) Odstranit knihu");
            System.out.println("d) Vypůjčit knihu");
            System.out.println("e) Vrátit knihu");
            System.out.println("f) Výpis knih");
            System.out.println("g) Vyhledat knihu podle názvu");
            System.out.println("h) Vyhledat knihu podle autora");
            System.out.println("i) Vyhledat knihu podle žánru");
            System.out.println("j) Vypsat půjčené knihy s informací román/učebnice");
            System.out.println("k) Uložit informace o knize do souboru");
            System.out.println("l) Načíst informace o knize ze souboru");
            System.out.println("m) Konec.");

            choice = scanner.next().charAt(0);
            scanner.nextLine();

            switch (choice)
            {
                case 'a':
                    PridejKnihu.addBook(library, scanner);
                    break;
                case 'b':
                    UpravKnihu.updateBook(library, scanner);
                    break;
                case 'c':
                    SmazKnihu.deleteBook(library, scanner);
                    break;
                case 'd':
                    VypujceneDostupne.markBookAsBorrowed(library, scanner);
                    break;
                case 'e':
                	VypujceneDostupne.markBookAsReturned(library, scanner);
                    break;
                case 'f':
                    library.displayBooks();
                    break;
                case 'g':
                    library.searchBookByName(scanner);
                    break;
                case 'h':
                    library.displayBooksByAuthor(scanner);
                    break;
                case 'i':
            	    library.displayBooksByGenre(scanner);
                    break;
                case 'j':
                	VypisUcebniceRoman.displayBorrowedBooksInfo(library);
                	break;
                case 'k':
                    UlozDoSouboru.saveBookToFile(library, scanner);
                    break;
                case 'l':
                    NactiZeSouboru.loadBookFromFile(scanner);
                    break;
                case 'm':
                	sqlDB.saveDataToDatabase(library);
                	System.out.println("Konec");
                    break;
                default:
                    System.out.println("Chyba zadání.");
            }
        } while (choice != 'm');
        scanner.close();
    }
}