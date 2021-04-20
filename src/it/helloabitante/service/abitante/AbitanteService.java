package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);

	public List<Abitante> cercaPerNomeECognome(String nome, String cognome);
	
	public List<Abitante> listAll() throws Exception;
	
	public Abitante caricaSingoloElemento(Long id) throws Exception;
	
	public int aggiorna(Abitante input) throws Exception;
	
	public int inserisci(Abitante input) throws Exception;
	
	public int rimuovi(Abitante input) throws Exception;
	
}
