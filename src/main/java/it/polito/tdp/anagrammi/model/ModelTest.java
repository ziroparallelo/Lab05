package it.polito.tdp.anagrammi.model;

public class ModelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "c";
		System.out.println(s.length()+"\n");
		for(int i=0; i<s.length(); i++)
		System.out.println(s.charAt(i)+"\n");
		
		s = (String) s.subSequence(0, s.length()-1);
		System.out.println(s+"\n");
	}

}
