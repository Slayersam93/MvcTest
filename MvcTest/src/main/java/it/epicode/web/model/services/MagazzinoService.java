package it.epicode.web.model.services;

import java.util.List;

import it.epicode.web.model.data.AbstractFornitoreRepository;
import it.epicode.web.model.data.AbstractProdottoRepository;
import it.epicode.web.model.data.DataException;
import it.epicode.web.model.entities.Fornitore;
import it.epicode.web.model.entities.Prodotto;

public class MagazzinoService implements AbstractMagazzinoService {
	private AbstractFornitoreRepository fornitoreRepo;
	private AbstractProdottoRepository prodottoRepo;

	public MagazzinoService(AbstractFornitoreRepository fornitoreRepo, AbstractProdottoRepository prodottoRepo) {
		this.fornitoreRepo = fornitoreRepo;
		this.prodottoRepo = prodottoRepo;
	}

	@Override
	public void insert(Fornitore forn) throws DataException {
		fornitoreRepo.insert(forn);
	}

	@Override
	public void update(Fornitore updated) throws DataException {
		fornitoreRepo.update(updated);

	}

	@Override
	public List<Fornitore> leggiFornitori() throws DataException {
		return fornitoreRepo.leggi();
	}

	@Override
	public void deleteFornitore(String id) throws DataException {
		fornitoreRepo.delete(id);
	}

	@Override
	public Fornitore searchFornitore(String id) throws DataException {
		return fornitoreRepo.searchFornitore(id);
	}

	@Override
	public List<Fornitore> leggiPerCitta(String nomeCitta) throws DataException {
		return fornitoreRepo.leggiPerCitta(nomeCitta);
	}

	@Override
	public List<Prodotto> prodottiPerFornitore(String codiceFornitore) throws DataException {
		return prodottoRepo.prodottiPerFornitore(codiceFornitore);
	}

	@Override
	public List<Prodotto> leggiProdotti() throws DataException {
		return prodottoRepo.leggi();
	}

	@Override
	public void insert(Prodotto prod) throws DataException {
		prodottoRepo.inserisci(prod);
		
	}

}
