package app.classes;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catalogo {
	private Map<String, Prodotto> archivio;

	private static final Logger logger = LoggerFactory.getLogger(Catalogo.class);

	public Catalogo() {
		this.archivio = new HashMap<String, Prodotto>();
	}

	public void aggiungi(Prodotto prod) {
		archivio.put(prod.getIsbn(), prod);
	}

	public void cancella(String isbn) {
		archivio.remove(isbn);
	}

	public Prodotto ricercaIsbn(String isbn) {
		return archivio.get(isbn);
	}

	public List<Prodotto> ricercaAnnoPubblicazione(Integer anno) {
		return archivio.values().stream().filter(prod -> anno.equals(prod.getAnnoPubblicazione()))
				.collect(Collectors.toList());
	}

	public List<Libro> ricercaAutore(String nome) {
		return archivio.values().stream().filter(prod -> prod instanceof Libro).map(prod -> (Libro) prod)
				.filter(prod -> nome.equals(prod.getAutore())).collect(Collectors.toList());
	}

	// metodo extra
	public List<Libro> ricercaGenere(String gen) {
		return archivio.values().stream().filter(prod -> prod instanceof Libro).map(prod -> (Libro) prod)
				.filter(prod -> gen.equals(prod.getGenere())).collect(Collectors.toList());
	}

	public void salvaCatalogo() throws IOException {
		String fileString = "";

		for (Prodotto prod : archivio.values()) {
			if (fileString.length() != 0) {
				fileString += "#";
			}
			if (prod instanceof Libro) {
				fileString += Libro.toStringFile((Libro) prod);
			} else if (prod instanceof Rivista) {
				fileString += Rivista.toStringFile((Rivista) prod);
			}
		}

		File file = new File("c://Epicode//catalogobibliotecario.txt");
		FileUtils.writeStringToFile(file, fileString, "UTF-8");
		logger.info("Il catalogo bibliotecario è stato salvato con successo");
	}

	public void caricaCatalogo() throws IOException {
		this.archivio.clear();

		File file = new File("c://Epicode//catalogobibliotecario.txt");
		String fileString = FileUtils.readFileToString(file, "UTF-8");

		List<String> listaProd = Arrays.asList(fileString.split("#"));

		for (String subString : listaProd) {
			Prodotto prod = null;
			if (subString.startsWith(Libro.class.getSimpleName())) {
				prod = Libro.fromStringFile(subString);
			} else if (subString.startsWith(Rivista.class.getSimpleName())) {
				prod = Rivista.fromStringFile(subString);
			}
			this.archivio.put(prod.getIsbn(), prod);
		}
	}
}
