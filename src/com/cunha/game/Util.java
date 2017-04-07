package com.cunha.game;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Util {

	public static final int MaxCombinacoes = 1023;

	public static final int D0 = 0;
	public static final int D1 = 1;
	public static final int D2 = 2;
	public static final int D3 = 3;
	public static final int D4 = 4;
	public static final int D5 = 5;
	public static final int D6 = 6;
	public static final int D7 = 7;
	public static final int D8 = 8;
	public static final int D9 = 9;

	public static final String fileInput = "C:\\temp\\Learning\\lotoma\\DadosJogos.csv";
	public static final String fileOutput = "C:\\temp\\Learning\\lotoma\\outputParseJogo.txt";

	private static final int MaxIndex = 100;

	public String toBinaryString(String concurso) {
		String[] str = new String[MaxIndex];
		StringBuilder strJogo = new StringBuilder();
		String[] strParsed = concurso.split(";");
		// String jogoParsed = "";

		for (int i = 0; i < str.length; i++) {
			str[i] = "0";
		}

		for (String string : strParsed) {
			int index = Integer.parseUnsignedInt(string);
			if (index == 0) {
				index = 100;
			}
			str[index - 1] = "1";
		}

		for (String string : str) {
			strJogo.append(string);
		}
		// System.out.println("strJogo " + strJogo);
		return strJogo.toString();
	}

	public String[] subStrDezena(String linhaJogo) {
		String Dez[] = new String[10];
		Dez[0] = linhaJogo.substring(Util.D0, Util.D0 + 10);
		Dez[1] = linhaJogo.substring(Util.D1, Util.D1 + 10);
		Dez[2] = linhaJogo.substring(Util.D2, Util.D2 + 10);
		Dez[3] = linhaJogo.substring(Util.D3, Util.D3 + 10);
		Dez[4] = linhaJogo.substring(Util.D4, Util.D4 + 10);
		Dez[5] = linhaJogo.substring(Util.D5, Util.D5 + 10);
		Dez[6] = linhaJogo.substring(Util.D6, Util.D6 + 10);
		Dez[7] = linhaJogo.substring(Util.D7, Util.D7 + 10);
		Dez[8] = linhaJogo.substring(Util.D8, Util.D8 + 10);
		Dez[9] = linhaJogo.substring(Util.D9, Util.D9 + 10);
		return Dez;

	}

	public List<String> le(String fileInput) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(fileInput), Charset.forName("UTF-8"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;

	}

	public void grava(String fileOutput, List<String> linesInMemory, char ch) throws Exception {
		Path output = Paths.get(fileOutput);

		if (ch == 'A') {
			Files.write(output, linesInMemory, Charset.forName("UTF-8"), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND, StandardOpenOption.WRITE);
		} else {
			Files.write(output, linesInMemory, StandardCharsets.UTF_8);
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
