package com.cunha.test;

import java.util.ArrayList;
import java.util.List;

import com.cunha.loto.Dezenaconcurso;
import com.cunha.loto.Loto;
import com.cunha.util.Arquivo;

public class TestDezena {

	//public static final int D0 = 0;
	
	public static void main(String[] args) {

		ArrayList<Loto> loto = new ArrayList<>();

		// Arquivo com os resultados dos jogos
		Arquivo DadosJogos = new Arquivo();
		String fileInput = "C:\\temp\\Learning\\lotoma\\DadosJogos.csv";
		List<String> linesInput = DadosJogos.le(fileInput);

		int concursoID = 1;
		for (String string : linesInput) {
			Loto jogo = new Loto();
			jogo.setLinesCSV(string);

			// para converter em binario
			String str = DadosJogos.toBinaryString(string);
			loto.add(jogo);
			concursoID++;
		}
	
		
		Dezenaconcurso d = new Dezenaconcurso();
		for (Loto j : loto) {
			String str = j.getLinesBinary();
			//String sub = str.substring(0, 11);
			d.setDezena(str);
		}

	} // end maiun

} // class
