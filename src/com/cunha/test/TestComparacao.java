package com.cunha.test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.cunha.loto.Loto;
import com.cunha.prob.Combinacao;
import com.cunha.util.Arquivo;
import com.cunha.util.Bit;

public class TestComparacao {

	public static void main(String[] args) {

		List<String> linesResult = new ArrayList<String>();

		List<String> linesOutputConcurso = parseConcurso();
		String dadosCombinacao = "1234567890";
		List<String> linesOutputCombinacao = parseCombinacao(dadosCombinacao);

		Bit bit = new Bit();

		int combinacaoID = 0;
		for (String combinacao : linesOutputCombinacao) {
			combinacaoID++;
			BitSet comb = new BitSet(1024);
			comb = bit.setBits(combinacao);

			int linhasDezena = 10;
			int concursoID = 0;
			for (String concurso : linesOutputConcurso) {
				concursoID++;

				for (int j = 0; j < concurso.length() / linhasDezena; j++) {

					int index = j * 10;
					String str = concurso.substring(index, (index + 10));

					BitSet temp = new BitSet(1024);
					temp = bit.setBits(str);

					temp.and(comb);
					if (temp.cardinality() == 4) {
						String result = ("ConcursoID= " + concursoID + " CombinacaoID= " + combinacaoID + " Dezena= "
								+ index + " AND4= " + temp);
						linesResult.add(result);
					} else {
						// System.out.println(
						// "Concurso= " + concursoID + " CombinacaoID= " +
						// combinacaoID);

					}

				} // end for
			}
		}

		for (String string : linesResult) {
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
