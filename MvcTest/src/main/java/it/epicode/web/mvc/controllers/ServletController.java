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


@WebServlet("*.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		int pos = path.lastIndexOf('/');
		String action = path.substring(pos+1, path.length()-3);
		Destination des = null;
		try{
			switch (action.toLowerCase()) {
			case "listafornitori": {
				FornitoreController forn = new FornitoreController(new FornitoreRepository());
				des = forn.listaFornitori(request, response);
			}
			break;
			case "inseriscifornitore":{
				FornitoreController forn = new FornitoreController(new FornitoreRepository());
				des = forn.inserisciFornitore(request, response);
				
			}
			break;
			case "mostraforminseriscifornitore":{
				des = new Destination("inserisciFornitore.jsp", false);
			}
			break;
			default:
				des = new Destination("noAction.jsp", false);
			}
			
			
			}
		catch (DataException e) {
			request.setAttribute("EXCEPTION",e);
			des = new Destination("erroreDb.jsp", false);
		}
		if(des.isRedirect()) {
			response.sendRedirect(des.getUrl());
		}else {
			RequestDispatcher rd =  request.getRequestDispatcher(des.getUrl());
			rd.forward(request, response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
