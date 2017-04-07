package com.cunha.test;

import java.util.ArrayList;
import java.util.List;
import com.cunha.prob.Combinacao;

public class TestParseCombinacao {

	static Combinacao combinacao = new Combinacao();

	public static void main(String[] args) {

		String dadosCombinacao = "1234567890";
		List<String> linesOutput = parseCombinacao(dadosCombinacao);
		// System.out.println(linesOutput);
		for (String string : linesOutput) {
			System.out.println(string);
		}
	}

	public static List<String> parseCombinacao(String dadosCombinacao) {
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
