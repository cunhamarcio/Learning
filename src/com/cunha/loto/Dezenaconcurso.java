package com.cunha.loto;

import java.util.Arrays;
import java.util.BitSet;

public class Dezenaconcurso {

	BitSet[] Dezena = new BitSet[10];

	public BitSet[] getDezena() {
		return Dezena;
	}

	public BitSet setDezena(String bits) {
		int index;
		BitSet d1 = new BitSet(1024);

		char[] str = bits.toCharArray();

		d1 = (BitSet) setOne(str).clone();
		return d1;
		// d1.clone();

	} // end setDEzena

	private BitSet setOne(char[] str) {
		BitSet dez = new BitSet(1024);
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '1') {
				dez.set(i);
			}
		}
		return dez;
	}

	@Override
	public String toString() {
		return "Dezenaconcurso [Dezena=" + Arrays.toString(Dezena) + "]";
	}

}
