package com.cunha.main;

import java.util.ArrayList;
import java.util.List;

import com.cunha.loto.Loto;
import com.cunha.prob.Combinacao;
import com.cunha.util.Arquivo;

public class WinMoney {

	public static void main(String[] args) {

		List<String> linesOutputConcurso = parseConcurso();
		// Mostra Resultado a ser gravado
		for (String string : linesOutputConcurso) {
			System.out.println(string);
		}

		String dadosCombinacao = "1234567890";
		List<String> linesOutputCombinacao = parseCombinacao(dadosCombinacao);
		// System.out.println(linesOutput);
		for (String string : linesOutputCombinacao) {
			System.out.println(string);
		}

	} // main

	/*
	 * Meth LotoParse
	 */
	public static List<String> parseConcurso() {
		Loto consurso = new Loto();
		Arquivo arquivoConcurso = new Arquivo();
		Arquivo arquivoResultado = new Arquivo();

		String fileInput = "C:\\temp\\Learning\\lotoma\\DadosJogos.csv";
		String fileOutput = "C:\\temp\\Learning\\lotoma\\outputParseJogo.txt";

		List<String> linesInput = arquivoConcurso.le(fileInput);
		List<String> linesOutput = new ArrayList<String>();

		for (String string : linesInput) {
			//consurso.setConcurso(string);
			//consurso.parseLoto2();
			//String jogoParsed = consurso.getJogoParsed();
			//linesOutput.add(jogoParsed);
		}

		try {
			arquivoResultado.grava(fileOutput, linesOutput, 'n');
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linesOutput;
	} // end meth parseConcurso

	public static List<String> parseCombinacao(String dadosCombinacao) {
		Combinacao combinacao = new Combinacao();
		combinacao.setDadosCombinacao(dadosCombinacao);
		List<String> linesInput = combinacao.getCombinacoesGeradasCSV();
		combinacao.gravaCombCSV(linesInput);

		// System.out.println(linesInput);
		List<String> linesOutput = new ArrayList<String>();

		for (String string : linesInput) {
			combinacao.parseCombinacao(string);
			String CombParsed = combinacao.getCombinacaoParsed();
			linesOutput.add(CombParsed);
		}
		return linesOutput;
	}

} // end calss
