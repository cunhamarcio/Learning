package com.cunha.test;

import java.util.List;

import com.cunha.prob.Combinacao;

public class TestaGeraCombinacao {

	static Combinacao combinacao = new Combinacao();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Gera Combinações");

		String set = "abcd";
		combinacao.setDadosCombinacao(set);
		List<String> ListaCombinacaoes = combinacao.getCombinacoesGeradas();

		System.out.println(ListaCombinacaoes);
		System.out.println("Total de combinacoes e de : " + ListaCombinacaoes.size());

	}

}
