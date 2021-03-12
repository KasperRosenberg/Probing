//Kasper Rosenberg karo5568
/*
 * Denna klass ska förberedas för att kunna användas som nyckel i en hashtabell. 
 * Du får göra nödvändiga ändringar även i klasserna MyString och ISBN10.
 * 
 * Hashkoden ska räknas ut på ett effektivt sätt och följa de regler och 
 * rekommendationer som finns för hur en hashkod ska konstrueras. Notera i en 
 * kommentar i koden hur du har tänkt när du konstruerat din hashkod.
 */
public class Book {
	private MyString title;
	private MyString author;
	private ISBN10 isbn;
	private MyString content;
	private int price;

	public Book(String title, String author, String isbn, String content, int price) {
		this.title = new MyString(title);
		this.author = new MyString(author);
		this.isbn = new ISBN10(isbn);
		this.content = new MyString(content);
		this.price = price;
	}

	public MyString getTitle() {
		return title;
	}

	public MyString getAuthor() {
		return author;
	}

	public ISBN10 getIsbn() {
		return isbn;
	}

	public MyString getContent() {
		return content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Book) {
			Book b = (Book) other;
			return this.title.equals(b.getTitle()) && this.author.equals(b.getAuthor()) && this.isbn.equals(b.getIsbn())
					&& this.content.equals(b.getContent());
		} else {
			return false;
		}
	}

/*N�r jag skrev min hashkod s� funderade jag p� att f�rst anv�nda str�ngens inbyggda .hashCode() 
 * f�r att den �r s� pass bra s� varf�r skriva en egen. Jag fick ocks� alla testfall godk�nda med
 * den metoden, men efter att ha l�st ytterligare i boken s� f�rstod jag att det var en mycket l�ngsammare 
 * metod att anv�nda den inbyggda hashcoden �n att implementera nedanst�ende egen metod. Anledningen till 
 * att jag valde att anv�nda isbn f�r att g�ra min hashcode �r f�r att den �r unik f�r alla b�cker och d�rf�r 
 * resulterar i unika hashcodes. Eventuellt kan spridningen bli b�ttre genom att inkludera fler variabler som
 * titel, f�rfattare etc, beroende p� hur ISBN nummrena ser ut. Men jag valde att i detta fall n�ja mig med bara isbn. 
*/ 	
	@Override
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < isbn.toString().length(); i++) {
			hash = 37 * hash + isbn.toString().charAt(i);
		}
		return hash;
	}

	@Override
	public String toString() {
		return String.format("\"%s\" by %s Price: %d ISBN: %s lenght: %s", title, author, price, isbn,
				content.length());
	}

}
