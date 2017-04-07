package com.cunha.test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import com.cunha.loto.Loto;
import com.cunha.prob.Combinacao;
import com.cunha.util.Arquivo;

public class TestLotoParse {

	static Combinacao combinacao = new Combinacao();
	static List<String> ListaCombinacaoes = new ArrayList<>();

	public static void main(String[] args) {

		String fileInput = "C:\\temp\\Learning\\lotoma\\DadosJogos.csv";
		String fileOutput = "C:\\temp\\Learning\\lotoma\\outputParseJogo.txt";

		Arquivo dados = new Arquivo();
		/// List<String> linesOutput = loto.parseConcurso(fileInput,
		/// fileOutput);
		List<String> linesOutput = dados.le(fileInput);

		List<Loto> jogos = new ArrayList<Loto>();

		// Mostra Resultado a ser gravado
		for (String linesCSV : linesOutput) {
			Loto loto = new Loto();
			loto.setLinesCSV(linesCSV);
			loto.setConcursoID();
			loto.setLinesBinary();
			loto.setDezena();
			jogos.add(loto);
		}

		int BinMAX = 50;
		for (int i = 1; i < BinMAX; i++) {

			for (Loto jogo : jogos) {

				BitSet[] bits = new BitSet[10];
				// BitSet bits0 = jogo.getD0();
				// BitSet bits1 = jogo.getD1();
				// BitSet bits2 = jogo.getD2();
				// BitSet bits3 = jogo.getD3();
				// BitSet bits4 = jogo.getD4();
				// BitSet bits5 = jogo.getD5();
				// BitSet bits6 = jogo.getD6();
				// BitSet bits7 = jogo.getD7();
				// BitSet bits8 = jogo.getD8();
				// BitSet bits9 = jogo.getD9();

				bits[0] = jogo.getD0();
				bits[1] = jogo.getD1();
				bits[2] = jogo.getD2();
				bits[3] = jogo.getD3();
				bits[4] = jogo.getD4();
				bits[5] = jogo.getD5();
				bits[6] = jogo.getD6();
				bits[7] = jogo.getD7();
				bits[8] = jogo.getD8();
				bits[9] = jogo.getD9();

				// System.out.format("%10d%n",
				// Integer.parseInt(Loto.toString(bits0), 2));

				Loto jogosCombina = new Loto();
				String bin = binario(i);
				BitSet bitsCombina = jogosCombina.fromString(bin);

				// System.out.println("\ninteracao " + i);
				// System.out.println("bits0 " + bits0);
				// System.out.println("bitsCombina" + bitsCombina);

				// System.out.println("bits1 " + bits1);
				// System.out.println("bitsCombina" + bitsCombina);

				// int MASK1 = Integer.parseInt("1101000011", 2);
				// int MASK2 = Integer.parseInt("1101000001", 2);

				for (int j = 0; j < bits.length; j++) {
					bitsCombina.and(bits[j]);
					if (bitsCombina.intersects(bits[j])) {
						System.out.println("D" + j + " i= " + i + " bin= " + bin + " match2 " + bitsCombina);
					}
				}
				// bitsCombina.and(bits1);
				// if (bitsCombina.intersects(bits1)) {
				// System.out.println("D1 i= "+i + " bin= " + bin + " match2 " +
				// bitsCombina);
				// }

			}
		}

	}

	public static String binario(int numero) {
		int d = numero;
		StringBuffer binario = new StringBuffer(); // guarda os dados
		while (d > 0) {
			int b = d % 2;
			binario.append(b);
			d = d >> 1; // é a divisão que você deseja
		}
		String bin = binario.reverse().toString(); // inverte a ordem
		return bin;
	}

} // end class
