package com.cunha.loto;

import java.util.Arrays;
import java.util.BitSet;

public class Loto {
	private static final int MaxIndex = 100;
	private int ConcursoID;
	private String linesCSV;
	private String linesBinary;

	BitSet D0 = new BitSet();
	BitSet D1 = new BitSet();
	BitSet D2 = new BitSet();
	BitSet D3 = new BitSet();
	BitSet D4 = new BitSet();
	BitSet D5 = new BitSet();
	BitSet D6 = new BitSet();
	BitSet D7 = new BitSet();
	BitSet D8 = new BitSet();
	BitSet D9 = new BitSet();

	public int getConcursoID() {
		return ConcursoID;
	}

	public void setConcursoID() {
		String[] strParsed = this.linesCSV.split(";");
		ConcursoID = Integer.valueOf(strParsed[0]);
	}

	public String getLinesCSV() {
		return linesCSV;
	}

	public void setLinesCSV(String linesCSV) {
		this.linesCSV = linesCSV;
	}

	public String getLinesBinary() {
		return linesBinary;
	}

	public void setLinesBinary() {

		// String[] str = new String[MaxIndex];
		char[] str = new char[MaxIndex];

		String[] strParsed = this.linesCSV.split(";");
		// String jogoParsed = "";

		for (int i = 0; i < str.length; i++) {
			str[i] = '0';
		}

		for (int i = 1; i < strParsed.length; i++) {
			String string = strParsed[i];
			int index = Integer.parseUnsignedInt(string);
			if (index == 0) {
				index = 100;
			}
			str[index - 1] = '1';
		}

		String text = String.copyValueOf(str);
		System.out.println("text " + text);
		this.linesBinary = text;
	}

	public void setDezena() {
		String strD0 = linesBinary.substring(0, 10);
		D0 = fromString(strD0);

		String strD1 = linesBinary.substring(10, 20);
		D1 = fromString(strD1);

		String strD2 = linesBinary.substring(20, 30);
		D2 = fromString(strD2);

		String strD3 = linesBinary.substring(30, 40);
		D3 = fromString(strD3);

		String strD4 = linesBinary.substring(40, 50);
		D4 = fromString(strD4);

		String strD5 = linesBinary.substring(50, 60);
		D5 = fromString(strD5);

		String strD6 = linesBinary.substring(60, 70);
		D6 = fromString(strD6);

		String strD7 = linesBinary.substring(70, 80);
		D7 = fromString(strD7);

		String strD8 = linesBinary.substring(80, 90);
		D8 = fromString(strD8);

		String strD9 = linesBinary.substring(90, 100);
		D9 = fromString(strD9);

		// Dezenaconcurso dez = new Dezenaconcurso();
		// D0 = dez.setDezena(strD0);
		// D0 = dez.getDezena().clone();

		// BitSet bits1 = fromString("1000001000111111");
		// System.out.println("srF " + strD0);

		// BitSet bits2 = fromString("1111111111111111");

		// System.out.println(toString(bits1)); // prints 1000001
		// System.out.println(toString(bits2)); // prints 1111111

		// bits2.and(bits1);

		// System.out.println(toString(bits2)); // prints 1000001
	}

	public static BitSet fromString(final String s) {
		return BitSet.valueOf(new long[] { Long.parseLong(s, 2) });
	}

	public static String toString(BitSet bs) {
		if (bs.length() == 0) {
			bs.set(0);
		}
		return Long.toString(bs.toLongArray()[0], 2);
	}

	public BitSet getD0() {
		return D0;
	}

	public BitSet getD1() {
		return D1;
	}

	public BitSet getD2() {
		return D2;
	}

	public BitSet getD3() {
		return D3;
	}

	public BitSet getD4() {
		return D4;
	}

	public BitSet getD5() {
		return D5;
	}

	public BitSet getD6() {
		return D6;
	}

	public BitSet getD7() {
		return D7;
	}

	public BitSet getD8() {
		return D8;
	}

	public BitSet getD9() {
		return D9;
	}

	@Override
	public String toString() {
		return "Loto [ConcursoID=" + ConcursoID + ", linesCSV=" + linesCSV + ", linesBinary=" + linesBinary + "]";
	}

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
		return jogoParsed;
	}
} // end class
