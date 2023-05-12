package app.classes;

public class Rivista extends Prodotto {
	private Periodicita periodicita;

	public Rivista(String isbn, String nome, Integer anno, Integer pagine, Periodicita periodo) {
		super(isbn, nome, anno, pagine);
		this.setPeriodicita(periodo);
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodo) {
		this.periodicita = periodo;
	}

	public static String toStringFile(Rivista prod) {
		return Rivista.class.getSimpleName() + "#" + prod.ISBN + "#" + prod.titolo + "#" + prod.annoPubblicazione + "#"
				+ prod.numPagine + "#" + prod.periodicita;
	}

	public static Prodotto fromStringFile(String subString) {
		String[] split = subString.split("#");
		Periodicita periodicita = Periodicita.valueOf(split[5]);

		return new Rivista(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), periodicita);
	}
}
