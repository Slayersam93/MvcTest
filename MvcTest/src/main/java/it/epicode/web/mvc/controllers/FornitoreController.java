package it.epicode.web.mvc.controllers;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.epicode.web.model.data.DataException;
import it.epicode.web.model.entities.Fornitore;
import it.epicode.web.model.services.AbstractMagazzinoService;

public class FornitoreController {
	private AbstractMagazzinoService service;

	public FornitoreController(AbstractMagazzinoService service) {
		this.service = service;
	}

	public Destination listaFornitori(HttpServletRequest request, HttpServletResponse response) throws DataException {
		List<Fornitore> result = service.leggiFornitori();
		request.setAttribute("listaFornitori", result);
		return new Destination("archivioFornitori.jsp", false);
	}

	public Destination inserisciFornitore(HttpServletRequest request, HttpServletResponse response)
			throws DataException {
		service.insert(fornitoreFromRequestParameters(request));
		return new Destination("listaFornitori.do", true);
	}

	public Destination caricaFormUpdate(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String id = request.getParameter("id");
		Fornitore forn = service.searchFornitore(id);
		request.setAttribute("toUpdate", forn);
		return new Destination("inserisciFornitore.jsp", false);
	}

	public Destination updateFornitore(HttpServletRequest request, HttpServletResponse response) throws DataException {
		service.update(fornitoreFromRequestParameters(request));
		return new Destination("listaFornitori.do", true);
	}

	public Destination eliminaFornitore(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String id = request.getParameter("id");
		service.deleteFornitore(id);
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
