package it.epicode.web.mvc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.model.data.DataException;
import it.epicode.web.model.data.FornitoreRepository;
import it.epicode.web.model.data.ProdottoRepository;
import it.epicode.web.model.services.AbstractMagazzinoService;
import it.epicode.web.model.services.MagazzinoService;

@WebServlet("*.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getRequestURI();
		int pos = path.lastIndexOf('/');
		String action = path.substring(pos + 1, path.length() - 3);
		Destination des = null;
		AbstractMagazzinoService serv = new MagazzinoService(new FornitoreRepository(), new ProdottoRepository());
		FornitoreController forn = new FornitoreController(serv);
		ProdottoController prod = new ProdottoController(serv);
		try {
			switch (action.toLowerCase()) {
			case "listafornitori": {
				des = forn.listaFornitori(request, response);
			}
				break;
			case "inseriscifornitore": {

				des = forn.inserisciFornitore(request, response);

			}
				break;
			case "mostraforminseriscifornitore": {
				des = new Destination("inserisciFornitore.jsp", false);
			}
				break;
			case "mostraformupdatefornitore": {

				des = forn.caricaFormUpdate(request, response);
			}
				break;
			case "updatefornitore": {

				des = forn.updateFornitore(request, response);
			}
				break;
			case "eliminafornitore": {

				des = forn.eliminaFornitore(request, response);
			}
				break;

			case "listaprodotti": {

				des = prod.listaProdotti(request, response);
			}
				break;
			case "mostraforminserisciprodotto": {
				des = prod.caricaFormInserimentoProdotto(request, response);
			}
			break; 
			case "inserisciprodotto" :{
				des = prod.inserisciProdotto(request, response); 
			}

				break;
			default:
				des = new Destination("noAction.jsp", false);
			}

		} catch (DataException e) {
			request.setAttribute("EXCEPTION", e);
			des = new Destination("erroreDb.jsp", false);
		}
		if (des.isRedirect()) {
			response.sendRedirect(des.getUrl());
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(des.getUrl());
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
