package it.epicode.web.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.epicode.web.model.entities.Fornitore;
import it.epicode.web.model.entities.Prodotto;

public class ProdottoRepository implements AbstractProdottoRepository {
	public static final String QUERY_PRODOTTI_PER_FORNITORE = "SELECT forn.codiceFornitore as codforn, forn.nome as nomeforn, forn.indirizzo as indforn , forn.citta as cittaforn,  pr.codiceProdotto as codprod, pr.nome as nomeprod, pr.descrizione as descrprod, "
			+ "pr.marca as marcaprod, pr.fornitore as fornitorefk, pr.prezzo as prezzoprod FROM negozio.prodotti pr JOIN negozio.fornitore forn ON pr.fornitore = forn.codiceFornitore WHERE fornitore = ?  ";

	@Override
	public List<Prodotto> prodottiPerFornitore(String codiceFornitore) throws DataException {
		List<Prodotto> all = new ArrayList<Prodotto>();
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement pst = con.prepareStatement(QUERY_PRODOTTI_PER_FORNITORE);) {
			pst.setString(1, codiceFornitore);
			Fornitore f = null;
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Prodotto p = fromResultSet(rs);
					if (f == null) {
						f = new Fornitore(rs.getString("codforn"), rs.getString("nomeforn"), rs.getString("indforn"),
								rs.getString("cittaforn"));
					}
					p.setFornitore(f);
					all.add(p);
				}
				return all;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	private Prodotto fromResultSet(ResultSet rs) throws SQLException {
		return new Prodotto(rs.getString("codprod"), rs.getString("nomeprod"), rs.getString("descrprod"),
				rs.getString("marcaprod"), null, rs.getDouble("prezzoprod"));
	}

}
