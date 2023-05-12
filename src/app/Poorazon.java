package app;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.classes.Catalogo;
import app.classes.Libro;
import app.classes.Periodicita;
import app.classes.Rivista;

public class Poorazon {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(Catalogo.class);
		Catalogo catalogo = new Catalogo();

		Libro l1 = new Libro("848022", "Il volo", 1992, 300, "Laura Sartori", "Romanzo");
		Libro l2 = new Libro("23456", "Amici", 2018, 215, "Mauro De Mauri", "Autobiografia");
		Rivista r1 = new Rivista("767358", "Piscine di lusso", 2020, 18, Periodicita.MENSILE);
		Rivista r2 = new Rivista("52846", "Manuale di bighellonaggio", 2023, 30, Periodicita.MENSILE);

		catalogo.aggiungi(r1);
		catalogo.aggiungi(r2);
		catalogo.aggiungi(l1);
		catalogo.aggiungi(l2);
		;

		try {
			catalogo.salvaCatalogo();

			catalogo.caricaCatalogo();

			List<Libro> ricercaPerAutore = catalogo.ricercaAutore("Lev Tolstoj");

			ricercaPerAutore.forEach(prod -> System.out.println("Titolo: " + prod.getTitolo()));

		} catch (IOException e) {
			logger.error("Errore durante la lettura/scrittura", e);
		}

	}

}
