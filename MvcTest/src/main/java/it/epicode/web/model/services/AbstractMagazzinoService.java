package it.epicode.web.model.services;

import java.util.List;

import it.epicode.web.model.data.DataException;
import it.epicode.web.model.entities.Fornitore;
import it.epicode.web.model.entities.Prodotto;

public interface AbstractMagazzinoService {
	void insert(Fornitore forn)throws DataException;
	void update(Fornitore updated)throws DataException;
	List<Fornitore> leggiFornitori()throws DataException;
	void deleteFornitore(String id)throws DataException;
	Fornitore searchFornitore(String id)throws DataException;
	List<Fornitore> leggiPerCitta(String nomeCitta) throws DataException;
	List<Prodotto> prodottiPerFornitore(String codiceFornitore) throws DataException;
	List<Prodotto> leggiProdotti() throws DataException;
	void insert(Prodotto prod) throws DataException;


}
