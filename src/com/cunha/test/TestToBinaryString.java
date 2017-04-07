package com.cunha.test;

import java.util.ArrayList;
import java.util.List;

import com.cunha.loto.Loto;
import com.cunha.util.Arquivo;

public class TestToBinaryString {

	public static void main(String[] args) {

		ArrayList<Loto> loto = new ArrayList<>();

		// Arquivo com os resultados dos jogos
		Arquivo DadosJogos = new Arquivo();
		String fileInput = "C:\\temp\\Learning\\lotoma\\DadosJogos.csv";
		List<String> linesInput = DadosJogos.le(fileInput);

		// Arquivo com os dados dos jogos convertidos em Formato binario
		Arquivo arquivoResultado = new Arquivo();
		String fileOutput = "C:\\temp\\Learning\\lotoma\\outputParseJogo.txt";
		List<String> linesOutput = new ArrayList<String>();

		int concursoID=1;
		for (String string : linesInput) {
			Loto jogo = new Loto();
			jogo.setLinesCSV(string);

			// para converter em binario
			String str = DadosJogos.toBinaryString(string);
			loto.add(jogo);
			concursoID++;

			// Para gragar no arquivo
			linesOutput.add(str);
		}

		try {
			arquivoResultado.grava(fileOutput, linesOutput, 'n');
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Loto j : loto) {
			//System.out.println(j.toString());
			System.out.println(j.getLinesBinary());
		}

	} // end maiun

} // class
