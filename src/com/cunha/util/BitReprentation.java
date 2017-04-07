package com.cunha.util;

public class BitReprentation {

	// exibe a representa��o de bits do valor inteiro especificado
	public static void display(int value) {
		System.out.printf("\nBit representation of %d is: \n" + value);

		// cria um valor inteiro com 1 no bit mais � esquerda e 0s em outros
		// locais
		int displayMask = 1 << 31;

		// para cada bit exibe 0 ou 1
		for (int bit = 1; bit <= 32; bit++) {
			// utiliza displayMask para isolar o bit
			System.out.print((value & displayMask) == 0 ? '0' : '1');

			value <<= 1; // desloca o valor uma posi��o para a esquerda

			if (bit % 8 == 0)
				System.out.print(' '); // exibe espa�o a cada 8 bits
		} // fim do for
	} // fim do m�todo display
} // fim da classe BitRepresentation
