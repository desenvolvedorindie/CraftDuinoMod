package br.com.wfcreations.arduino.utils;

import java.util.Arrays;

public class ByteUtils {

	public static byte[] addElement(byte[] arr, byte element) {
		byte[] result = Arrays.copyOf(arr, arr.length + 1);
		result[arr.length] = element;
		return result;
	}

	public static byte[] concat(byte[] A, byte[] B) {
		int aLen = A.length;
		int bLen = B.length;
		byte[] C = new byte[aLen + bLen];
		System.arraycopy(A, 0, C, 0, aLen);
		System.arraycopy(B, 0, C, aLen, bLen);
		return C;
	}
}
