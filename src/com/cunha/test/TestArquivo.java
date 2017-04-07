package com.cunha.test;

import java.util.List;
import com.cunha.prob.Combinacao;
import com.cunha.util.Arquivo;

public class TestArquivo {

	public static void main(String args[]) throws Exception {

		Combinacao combinacao = new Combinacao();
		Arquivo arquivoCombinacao = new Arquivo();
		Arquivo arquivoResultado = new Arquivo();

		String fileInput = "C:\\temp\\Learning\\result.txt";
		String fileOutput = "C:\\temp\\Learning\\output.txt";

		String set = "1234567890";
		combinacao.setDadosCombinacao(set);
		List<String> listaCombinacoesTotais = combinacao.getCombinacoesGeradas();

		arquivoResultado.grava(fileInput, listaCombinacoesTotais, 'n');

		/*
		 * Processa os dados
		 */
		List<String> lines = arquivoCombinacao.le(fileInput);

		int count = 0;
		for (String line : lines) {
			if (line.length() == 5) {
				System.out.println(line);
				count++;
			}
		} // end for

		System.out.println("Total de possibilidades = " + count);
		arquivoResultado.grava(fileOutput, lines, 'n');

	}
}
