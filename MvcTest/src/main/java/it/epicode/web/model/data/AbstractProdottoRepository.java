package it.epicode.web.model.data;

import java.util.List;

import it.epicode.web.model.entities.Prodotto;

public interface AbstractProdottoRepository {
	List<Prodotto> prodottiPerFornitore(String codiceFornitore) throws DataException;
	List<Prodotto> leggi() throws DataException;
	void inserisci (Prodotto prod) throws DataException;

}
