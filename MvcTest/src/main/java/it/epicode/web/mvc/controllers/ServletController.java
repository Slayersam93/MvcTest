package it.epicode.web.mvc.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.model.data.DataException;


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
				
			}
			break;
			case "inseriscifornitore":{
				
			}
			break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + action.toLowerCase());
			}
			
			
			}
		catch (Exception e) {
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
