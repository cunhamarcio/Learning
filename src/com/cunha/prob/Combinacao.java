package com.cunha.prob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cunha.util.Arquivo;

public class Combinacao {

	private String Combinacao;
	private String DadosCombinacao;
	private List<String> CombinacoesGeradas;
	private int TotalDeConbinacoes;
	private String CombinacaoParsed;
	private List<String> CombinacoesGeradasCSV;

	
	public List<String> getCombinacoesGeradasCSV() {
		return CombinacoesGeradasCSV;
	}

	public String getCombinacaoParsed() {
		return CombinacaoParsed;
	}

	public int getTotalDeConbinacoes() {
		return TotalDeConbinacoes;
	}

	public List<String> getCombinacoesGeradas() {
		return CombinacoesGeradas;
	}

	public void setDadosCombinacao(String dadosCombinacao) {
		DadosCombinacao = dadosCombinacao;
		powerSet();
		this.CombinacoesGeradasCSV = limpaString();
	}

	/****************************************************************************
	 * Author: Isai Damier Title: Power Set Project: geekviewpoint Package:
	 * algorithms
	 *
	 * Statement: Given a set of objects (here a string representing a set of
	 * characters), find the power set.
	 *
	 * Sample Input: {a,b,c} Sample Output:
	 * {{a,b,c},{a,b},{a,c},{a},{b,c},{b},{c},{}}
	 *
	 * Technical Details: This solution is one of the most powerful and most
	 * elegant results of bitwise operations. To find the powerset of any set of
	 * size n, simply start with an ALL_BITS number of size n and count down:
	 * {a,b,c},{a,b }, {a, c},{a },{ b,c},{ b },{ c},{ } 1 1 1 , 1 1 0 , 1 0 1 ,
	 * 1 0 0 , 0 1 1 , 0 1 0 , 0 0 1 , 0 0 0.
	 *
	 * This solution is important, for example, because all problems whose
	 * solutions depend on finding the combination C(n,k) of a set can be solved
	 * by finding the power set of said set. The power set, of course, is the
	 * general solution, and thus maybe an inefficient approach for solving
	 * particular instances.
	 ***************************************************************************/
	private void powerSet() {
		// public List<String> powerSet() {
		String set = this.DadosCombinacao;
		// return null if set is null or empty
		if (null == set || set.trim().equals("")) {
			return;
		}

		// create structure to hold power set, subset, etc. And create
		// a bit string the same size as set and fill it with 1s
		List<String> powset = new ArrayList<String>();
		int s = set.length();
		String subset, bits = "";
		for (int i = 0; i < s; i++) {
			bits += 1;
		}

		// extract power set by counting down in 'binary'
		for (int i = Integer.parseInt(bits, 2), b; i >= 0; i--) {
			// get bit representation of new subset
			bits = Integer.toString(i, 2);
			b = bits.length();
			subset = "";// empty subset holder
			for (int k = b - 1; k >= 0; k--)// assemble subset from bits
			{
				if ('1' == bits.charAt(k)) {
					subset += set.charAt(s - 1 - (b - 1 - k));
				}
			}
			powset.add(subset);// add subset to power set
		} // for
		this.CombinacoesGeradas = powset;
		this.TotalDeConbinacoes = powset.size();
	}

	@Override
	public String toString() {
		return "[CombinacoesGeradas=" + CombinacoesGeradas + "]";
	}

	public void parseCombinacao(String listaCSV) {
		// List<String> linesOutput = limpaString(CombinacoesGeradas);

		String[] str = new String[10];

		String[] strParsed = listaCSV.split(";");

		for (int i = 0; i < str.length; i++) {
			str[i] = "0";
		}

		for (String string : strParsed) {
			int index = Integer.parseUnsignedInt(string);
			if (index == 0) {
				index = 10;
			}
			str[index - 1] = "1";
		}

		this.CombinacaoParsed = "";
		for (String string : str) {
			this.CombinacaoParsed += string;
		}

	} // end meth

	public List<String> limpaString() {
		List<String> linesOutput1 = new ArrayList<String>();
		for (String string : this.CombinacoesGeradas) {
			if (string != "") {
				linesOutput1.add(string);
			}
		}

		List<String> linesOutput2 = new ArrayList<String>();
		for (String string : linesOutput1) {
			char[] arrayChar = string.toCharArray();

			String str = "";
			for (int i = 0; i < arrayChar.length; i++) {
				char c = arrayChar[i];

				str += c;
				if (i < arrayChar.length - 1) {

					str += ";";
				}

			}
			// System.out.println(str);
			linesOutput2.add(str);

		}
		return linesOutput2;
	} // end limpa String

	public void gravaCombCSV(List<String> linesInput) {

		Arquivo arquivoCombinacaoCSV = new Arquivo();

		String fileOutput = "C:\\temp\\Learning\\lotoma\\DadosCombinacaoCSV.csv";
		// List<String> linesOutput = new ArrayList<String>();

		try {
			arquivoCombinacaoCSV.grava(fileOutput, linesInput, 'n');
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
} // end class
