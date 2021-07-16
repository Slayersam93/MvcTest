package it.epicode.web.model.data;

import java.util.List;

import it.epicode.web.model.entities.Fornitore;

public interface AbstractFornitoreRepository {
	void insert(Fornitore forn)throws DataException;
	void update(Fornitore updated)throws DataException;
	List<Fornitore> leggi()throws DataException;
	void delete(String id)throws DataException;
	Fornitore searchFornitore(String id)throws DataException;
	List<Fornitore> leggiPerCitta(String nomeCitta) throws DataException;
	 

}
