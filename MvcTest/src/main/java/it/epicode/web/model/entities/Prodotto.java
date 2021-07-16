package it.epicode.web.model.entities;

public class Prodotto {
	private String codiceProdotto;
	private String nome;
	private String descrizione;
	private String marca;
	private Fornitore fornitore;
	
	private double prezzo;
	public Prodotto(String codiceProdotto, String nome, String descrizione, String marca, Fornitore fornitore,
			double prezzo) {
		this.codiceProdotto = codiceProdotto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.marca = marca;
		this.fornitore = fornitore;
		this.prezzo = prezzo;
	}
	public String getCodiceProdotto() {
		return codiceProdotto;
	}
	public String getNome() {
		return nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public String getMarca() {
		return marca;
	}
	public Fornitore getFornitore() {
		return fornitore;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}
	
	

}
