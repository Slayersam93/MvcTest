package it.epicode.web.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.model.data.DataException;
import it.epicode.web.model.entities.Fornitore;
import it.epicode.web.model.entities.Prodotto;
import it.epicode.web.model.services.AbstractMagazzinoService;

public class ProdottoController {
	private AbstractMagazzinoService service;

	public ProdottoController(AbstractMagazzinoService service) {
		this.service = service;
	}

	public Destination listaProdotti(HttpServletRequest request, HttpServletResponse response) throws DataException {
		List<Prodotto> result = service.leggiProdotti();
		request.setAttribute("listaProdotti", result);
		return new Destination("archivioprodotti.jsp", false);
	}

	public Destination caricaFormInserimentoProdotto(HttpServletRequest request, HttpServletResponse response) throws DataException {
		List<Fornitore> fornitori = service.leggiFornitori();
		request.setAttribute("listaFornitori", fornitori);
		return new Destination("inserisciProdotto.jsp", false);
	}

	public Destination inserisciProdotto(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String codiceProdotto = request.getParameter("codice");
		String nomeProdotto = request.getParameter("nome");
		String descrizioneProdotto = request.getParameter("descrizione");
		String marcaProdotto = request.getParameter("marca");
		double prezzoProdotto = Double.parseDouble(request.getParameter("prezzo"));
		Prodotto p = new Prodotto(codiceProdotto, nomeProdotto, descrizioneProdotto, marcaProdotto, null,prezzoProdotto);
		Fornitore f = new Fornitore(request.getParameter("fornitore"));
		p.setFornitore(f);
		service.insert(p);
		return new Destination("listaProdotti.do", true);
	}

}
