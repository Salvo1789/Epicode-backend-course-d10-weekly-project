package app.classes;

public class Libro extends Prodotto {
	private String autore;
	private String genere;

	public Libro(String isbn, String nome, Integer anno, Integer pagine, String autore, String gen) {
		super(isbn, nome, anno, pagine);
		this.autore = autore;
		this.genere = gen;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String gen) {
		this.genere = gen;
	}

	public static String toStringFile(Libro prod) {
		return Libro.class.getSimpleName() + "#" + prod.ISBN + "#" + prod.titolo + "#" + prod.annoPubblicazione + "#"
				+ prod.numPagine + "#" + prod.autore + "#" + prod.genere;
	}

	public static Prodotto fromStringFile(String subString) {
		String[] split = subString.split("#");

		return new Libro(split[0], split[1], Integer.valueOf(split[2]), Integer.valueOf(split[3]), split[4], split[5]);
	}

}
