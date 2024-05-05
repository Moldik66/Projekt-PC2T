package PC_2T_projekt_Dominik_Molak_247830;

class VypisPodleZanru
{
	 public static void displayBooksByGenre(Book[] books, int bookCount, String genre)
	 {
	        boolean found = false;
	        System.out.println("Knihy patřící do žánru \"" + genre + "\":");
	        for (int i = 0; i < bookCount; i++)
	        {
	            if (books[i].getGenre().equalsIgnoreCase(genre))
	            {
	                System.out.println("Název: " + books[i].getTitle());
	                System.out.print("Autor: ");
	                for (int j = 0; j < books[i].getAuthors().length; j++)
	                {
	                    System.out.print(books[i].getAuthors()[j]);
	                    if (j < books[i].getAuthors().length - 1)
	                    {
	                        System.out.print(", ");
	                    }
	                }
	                System.out.println();
	                System.out.println("Rok publikace: " + books[i].getYear());
	                System.out.println("Dostupná: " + (books[i].isAvailable() ? "Ano" : "Ne"));
	                found = true;
	            }
	        }
	        if (!found)
	        {
	            System.out.println("Žádné knihy v tomto žánru nebyly nalezeny.");
	        }
	    }
	}