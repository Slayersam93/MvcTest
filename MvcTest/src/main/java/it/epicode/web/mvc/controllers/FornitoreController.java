package it.epicode.web.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.model.data.AbstractFornitoreRepository;
import it.epicode.web.model.data.DataException;
import it.epicode.web.model.entities.Fornitore;

public class FornitoreController {
	private AbstractFornitoreRepository rep;

	public FornitoreController(AbstractFornitoreRepository rep) {
		this.rep = rep;
	}

	public Destination listaFornitori(HttpServletRequest request, HttpServletResponse response) throws DataException {
		List<Fornitore> result = rep.leggi();
		request.setAttribute("listaFornitori", result);
		return new Destination("archivioFornitori.jsp", false);
	}

	public Destination inserisciFornitore(HttpServletRequest request, HttpServletResponse response)
			throws DataException {
		rep.insert(fornitoreFromRequestParameters(request));
		return new Destination("listaFornitori.do", true);
	}

	public Destination caricaFormUpdate(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String id = request.getParameter("id");
		Fornitore forn = rep.searchFornitore(id);
		request.setAttribute("toUpdate", forn);
		return new Destination("inserisciFornitore.jsp", false);
	}

	public Destination updateFornitore(HttpServletRequest request, HttpServletResponse response) throws DataException {
		rep.update(fornitoreFromRequestParameters(request));
		return new Destination("listaFornitori.do", true);
	}

	private Fornitore fornitoreFromRequestParameters(HttpServletRequest request) {
		String codice = request.getParameter("codiceFornitore");
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		Fornitore forn = new Fornitore(codice, nome, indirizzo, citta);
		return forn;

	}
}
