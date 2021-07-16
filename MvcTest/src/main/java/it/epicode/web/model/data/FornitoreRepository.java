package it.epicode.web.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.epicode.web.model.entities.Fornitore;

public class FornitoreRepository implements AbstractFornitoreRepository {

	public static final String QUERY_FORNITORE_PER_ID = "SELECT codice_fornitore, nome, indirizzo, citta FROM negozio.fornitore WHERE codice_fornitore = ?";
	public static final String QUERY_FORNITORI = "SELECT codice_fornitore, nome, indirizzo, citta FROM negozio.fornitore";
	public static final String INSERT_FORNITORE = "INSERT INTO negozio.fornitore (codice_fornitore, nome, indirizzo, citta) values (?,?,?,?)";
	public static final String UPDATE_FORNITORE = "UPDATE negozio.fornitore SET nome = ?, indirizzo = ?, citta = ? WHERE codice_fornitore = ?";
	public static final String DELETE_FORNITORE = "DELETE FROM negozio.fornitore WHERE id = ?";
	public static final String QUERY_FORNITORE_PER_CITTA = "SELECT codice_fornitore, nome, indirizzo FROM negozio.fornitore WHERE citta = ?";

	@Override
	public Fornitore searchFornitore(String codiceFornitore) throws DataException {
		Fornitore f = null;
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement st = con.prepareStatement(QUERY_FORNITORE_PER_ID);) {
			st.setString(1, codiceFornitore);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					f = fromResultSet(rs);
				}
				return f;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	@Override
	public List<Fornitore> leggi() throws DataException {
		List<Fornitore> all = new ArrayList<Fornitore>();
		try (Connection con = ConnectionHandler.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(QUERY_FORNITORI)) {
			while (rs.next()) {
				all.add(fromResultSet(rs));

			}
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public void insert(Fornitore forn) throws DataException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_FORNITORE)) {
			ps.setString(1, forn.getCodiceFornitore());
			ps.setString(2, forn.getNome());
			ps.setString(3, forn.getIndirizzo());
			ps.setString(4, forn.getCitta());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public void update(Fornitore updated) throws DataException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_FORNITORE)) {

			ps.setString(4, updated.getCodiceFornitore());
			ps.setString(1, updated.getNome());
			ps.setString(2, updated.getIndirizzo());
			ps.setString(3, updated.getCitta());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public void delete(String id) throws DataException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_FORNITORE)) {
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

	}

	public List<Fornitore> leggiPerCitta(String nomeCitta) throws DataException {
		List<Fornitore> all = new ArrayList<Fornitore>();
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement pst = con.prepareStatement(QUERY_FORNITORE_PER_CITTA);) {
			pst.setString(1, nomeCitta);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					all.add(fromResultSet(rs));

				}
				return all;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}
	
	private Fornitore fromResultSet (ResultSet rs) throws SQLException {
		return new Fornitore(rs.getString("codice_fornitore"), rs.getString("nome"), rs.getString("indirizzo"),
				rs.getString("citta"));
	}

}
