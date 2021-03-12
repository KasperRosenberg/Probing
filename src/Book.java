//Kasper Rosenberg karo5568
/*
 * Denna klass ska fÃ¶rberedas fÃ¶r att kunna anvÃ¤ndas som nyckel i en hashtabell. 
 * Du fÃ¥r gÃ¶ra nÃ¶dvÃ¤ndiga Ã¤ndringar Ã¤ven i klasserna MyString och ISBN10.
 * 
 * Hashkoden ska rÃ¤knas ut pÃ¥ ett effektivt sÃ¤tt och fÃ¶lja de regler och 
 * rekommendationer som finns fÃ¶r hur en hashkod ska konstrueras. Notera i en 
 * kommentar i koden hur du har tÃ¤nkt nÃ¤r du konstruerat din hashkod.
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

/*När jag skrev min hashkod så funderade jag på att först använda strängens inbyggda .hashCode() 
 * för att den är så pass bra så varför skriva en egen. Jag fick också alla testfall godkända med
 * den metoden, men efter att ha läst ytterligare i boken så förstod jag att det var en mycket långsammare 
 * metod att använda den inbyggda hashcoden än att implementera nedanstående egen metod. Anledningen till 
 * att jag valde att använda isbn för att göra min hashcode är för att den är unik för alla böcker och därför 
 * resulterar i unika hashcodes. Eventuellt kan spridningen bli bättre genom att inkludera fler variabler som
 * titel, författare etc, beroende på hur ISBN nummrena ser ut. Men jag valde att i detta fall nöja mig med bara isbn. 
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
