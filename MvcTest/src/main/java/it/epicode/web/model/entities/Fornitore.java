package it.epicode.web.model.entities;

public class Fornitore {
	private String codiceFornitore;
	private String nome;
	private String indirizzo;
	private String citta;

	public Fornitore(String codiceFornitore, String nome, String indirizzo, String citta) {
		this.codiceFornitore = codiceFornitore;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	public String getCodiceFornitore() {
		return codiceFornitore;
	}

	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}
}
