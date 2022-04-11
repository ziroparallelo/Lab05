package it.polito.tdp.anagrammi.model;

import java.util.HashSet;


import java.util.Set;

import it.polito.tdp.anagrammi.DB.AnagrammiCorrettiDAO;

public class Model {
	
	AnagrammiCorrettiDAO anagrammiCorrettiDAO;
	
	public Model() 
	{
		this.anagrammiCorrettiDAO = new AnagrammiCorrettiDAO();
	}

	public boolean isCorrect(String parola)
	{
		return this.anagrammiCorrettiDAO.isCorrect(parola);
	}
	
	public Set<String> calcolaAnagrammi(String parola)
	{
		Set<String> anagrammi = new HashSet<String>();
		anagrammiRicorsivo(anagrammi, "", 0, parola);
		return anagrammi;
	}

	private void anagrammiRicorsivo(Set<String> anagrammi, String parziale, int l, String rimanenti) {
		
		//Caso terminale
		if(rimanenti.length() == 0)
		{
			anagrammi.add(new String (parziale));
			System.out.println(parziale);
			return;
		}
		//Caso reale
		for(int i=0; i<rimanenti.length(); i++)
		{
			parziale = parziale + rimanenti.charAt(i);
			String rimanentiRicorsivo = rimanenti.substring(0, i) + rimanenti.substring(i+1);
			anagrammiRicorsivo(anagrammi, parziale, l++, rimanentiRicorsivo);
			parziale = (String) parziale.subSequence(0, parziale.length()-1);
			
		}
		
	}
	
	
}
