package com.cunha.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

	private static final int MaxIndex = 1800;

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

	/* Fatorial de um numero */
	private static int fact(int b) {
		if (b <= 1)
			// if the number is 1 then return 1
			return 1;
		else
			// else call the same function with the value - 1
			return b * fact(b - 1);
	}

	/*
	 * Converte o resultado dos jogos em um Array Binario
	 */

	public String toBinaryString(String concurso) {
		String[] str = new String[MaxIndex];
		String[] strParsed = concurso.split(";");
		String jogoParsed = "";

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
			jogoParsed += string;
		}

		return jogoParsed;
	}

} // end class
