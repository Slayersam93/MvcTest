package it.epicode.web.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.epicode.web.model.entities.Fornitore;
import it.epicode.web.model.entities.Prodotto;

public class ProdottoRepository implements AbstractProdottoRepository {
	public static final String QUERY_PRODOTTI_PER_FORNITORE = "SELECT forn.codice_fornitore as codforn, forn.nome as nomeforn, forn.indirizzo as indforn , forn.citta as cittaforn,  pr.codice_prodotto as codprod, pr.nome as nomeprod, pr.descrizione as descrprod, "
			+ "pr.marca as marcaprod, pr.fornitore as fornitorefk, pr.prezzo as prezzoprod FROM negozio.prodotto pr JOIN negozio.fornitore forn ON pr.fornitore = forn.codice_fornitore WHERE fornitore = ?  ";
	public static final String QUERY_PRODOTTI = "SELECT forn.codice_fornitore as codforn, forn.nome as nomeforn, forn.indirizzo as indforn , forn.citta as cittaforn,  pr.codice_prodotto as codprod, pr.nome as nomeprod, pr.descrizione as descrprod, "
			+ "pr.marca as marcaprod, pr.fornitore as fornitorefk, pr.prezzo as prezzoprod FROM negozio.prodotto pr JOIN negozio.fornitore forn ON pr.fornitore = forn.codice_fornitore";
	public static final String INSERT_PRODOTTO = "INSERT INTO negozio.prodotto (codice_prodotto , nome , descrizione , marca , fornitore , prezzo) values (?,?,?,?,?,?) ";
	@Override
	public List<Prodotto> prodottiPerFornitore(String codiceFornitore) throws DataException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement pst = con.prepareStatement(QUERY_PRODOTTI_PER_FORNITORE);) {
			pst.setString(1, codiceFornitore);
			try (ResultSet rs = pst.executeQuery();) {
				return prodottiFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	@Override
	public List<Prodotto> leggi() throws DataException {
		try (Connection con = ConnectionHandler.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(QUERY_PRODOTTI)) {
			return prodottiFromResultSet(rs);

		} catch (

		SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	private Prodotto fromResultSet(ResultSet rs) throws SQLException {
		return new Prodotto(rs.getString("codprod"), rs.getString("nomeprod"), rs.getString("descrprod"),
				rs.getString("marcaprod"), null, rs.getDouble("prezzoprod"));
	}

	private List<Prodotto> prodottiFromResultSet(ResultSet rs) throws SQLException {
		List<Prodotto> all = new ArrayList<Prodotto>();
		Fornitore f = null;
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

	@Override
	public void inserisci(Prodotto prod) throws DataException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_PRODOTTO)) {
			ps.setString(1, prod.getCodiceProdotto());
			ps.setString(2, prod.getNome());
			ps.setString(3, prod.getDescrizione());
			ps.setString(4, prod.getMarca());
			ps.setString(5, prod.getFornitore().getCodiceFornitore());
			ps.setDouble(6, prod.getPrezzo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
		
	}

}
