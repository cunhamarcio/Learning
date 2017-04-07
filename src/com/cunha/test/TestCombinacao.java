package com.cunha.test;

import java.io.IOException;
import java.util.List;

import com.cunha.prob.Combinacao;

public class TestCombinacao {

	static Combinacao combinacao = new Combinacao();

	public static void main(String[] args) throws NumberFormatException, IOException {

		String set = "1234567890";
		combinacao.setDadosCombinacao(set);
		List<String> combinacaoes = combinacao.getCombinacoesGeradas();

		int count = 0;
		System.out.println("Gerando combinações....");
		for (String string : combinacaoes) {
			if (string.length() == 7) {

				System.out.println(string);
				count++;
			}
		}

		System.out.println("Total de possibilidades = " + count);
		System.out.println(combinacaoes);
		System.out.println("Total Geral : " + combinacao.getTotalDeConbinacoes());

	} // main

	public void BitDemo() {
		int bitmask = 0x000f;
		int val = 0x0002;
		System.out.println(val & bitmask);
		System.out.println(val | bitmask);
		System.out.println("<< .....");
		System.out.println(bitmask << 0);
		System.out.println(bitmask << 1);
		System.out.println(bitmask << 2);
		System.out.println(bitmask << 3);
		System.out.println(bitmask << 4);
		System.out.println(">> .....");
		System.out.println(bitmask >> 0);
		System.out.println(bitmask >> 1);
		System.out.println(bitmask >> 2);
		System.out.println(bitmask >> 3);
		System.out.println(bitmask >> 4);
	}



public void parseCombinacao() {
	
}

} // end class
