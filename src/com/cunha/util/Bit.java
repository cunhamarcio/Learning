package com.cunha.util;

import java.util.BitSet;

public class Bit {

	String bits;

	public String getBits() {
		BitSet d1 = new BitSet(1024);

		return bits;
	}

	public BitSet setBits(String bits) {
		BitSet d1 = new BitSet(1024);

		char[] str = bits.toCharArray();

		for (int i = 0; i < str.length; i++) {
			if (str[i] == '1') {
				d1.set(i);

			}
		}
		return d1;
	}
}
