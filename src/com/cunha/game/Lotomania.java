package com.cunha.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotomania {

	public static void main(String[] args) {
		Util dados = new Util();

		// Le arquivo com os resultados dos jogos
		List<String> linesOutput = dados.le(Util.fileInput);

		List<String> linesBinary = new ArrayList<String>();
		List<Game> game = new ArrayList<Game>();

		for (String concurso : linesOutput) {
			linesBinary.add(dados.toBinaryString(concurso));
		}

		int[] jogos = new int[1024];
		int linha = 1;

		for (String linhaJogo : linesBinary) {

			Game g = new Game();
			g.id = linha;

			for (int i = 1; i < Util.MaxCombinacoes; i++) {
				Util D = new Util();
				String[] Dez = D.subStrDezena(linhaJogo);
				String combinacao = Util.binario(i);

				int indexD0 = compara(Dez[0], combinacao);

				if (indexD0 != 0) {
					jogos[indexD0] += 1;
					g.setD0(jogos);
				}
				// g.D[j] = jogos;
				//System.out.println(Arrays.toString(jogos));

			} // end for 2

			game.add(g);
			linha++;
		}
		System.out.println(Arrays.toString(jogos));
		for (Game i : game) {
			//System.out.println(i.toString());
		}
	} // end main

	private static int compara(String Dezena, String combinacao) {
		int MASK2 = Integer.parseInt(Dezena, 2);

		int MaskCombinacao = Integer.parseInt(combinacao, 2);
		if ((MaskCombinacao & MASK2) == MaskCombinacao) {
			return MaskCombinacao;
		}

		return 0;
	}

} // end class
