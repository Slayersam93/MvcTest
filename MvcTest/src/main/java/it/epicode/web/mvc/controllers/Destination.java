package it.epicode.web.mvc.controllers;

public class Destination {
	private String url;
	private boolean redirect;

	public Destination(String url, boolean redirect) {
		this.url = url;
		this.redirect = redirect;
	}

	public String getUrl() {
		return url;
	}

	public boolean isRedirect() {
		return redirect;
	}
}
