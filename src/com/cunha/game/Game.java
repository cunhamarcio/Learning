package com.cunha.game;

import java.util.Arrays;

public class Game {

	int id;
	int[][] D = new int[10][1024];
	int[] D0;
	int[] D1;
	int[] D2;
	int[] D3;
	int[] D4;
	int[] D5;
	int[] D6;
	int[] D7;
	int[] D8;
	int[] D9;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[][] getD() {
		return D;
	}

	public void setD(int[][] d) {
		D = d;
	}

	public int[] getD0() {
		return D0;
	}

	public void setD0(int[] d0) {
		D0 = d0;
	}

	public int[] getD1() {
		return D1;
	}

	public void setD1(int[] d1) {
		D1 = d1;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", D=" + Arrays.deepToString(D) + "]";
	}
	
	

	//@Override
	//public String toString() {
	//	return "Game [id=" + id + ", D0=" + Arrays.toString(D0) + "]";
//	}
	
	

} // end class
