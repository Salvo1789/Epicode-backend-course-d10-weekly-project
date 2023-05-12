package app.classes;

public abstract class Prodotto {
	protected String ISBN;
	protected String titolo;
	protected Integer annoPubblicazione;
	protected Integer numPagine;

	public Prodotto(String isbn, String nome, Integer anno, Integer pagine) {
		this.ISBN = isbn;
		this.titolo = nome;
		this.annoPubblicazione = anno;
		this.numPagine = pagine;
	}

	public String getIsbn() {
		return ISBN;
	}

	public void setIsbn(String isbn) {
		this.ISBN = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String nome) {
		this.titolo = nome;
	}

	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Integer anno) {
		this.annoPubblicazione = anno;
	}

	public Integer getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(Integer pagine) {
		this.numPagine = pagine;
	}
}
