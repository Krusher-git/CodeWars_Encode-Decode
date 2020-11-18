package com.codewars.Krusher;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        System.out.println(encode("hey"));

    }

    public static String encode(String text) {

        String[] binaryValue = new String[text.length()];
        for (int i = 0; i < text.length(); i++) {
            int tmp = text.charAt(i);
            if (Integer.toBinaryString(tmp).length() != 8) {
                binaryValue[i] = ('0' + Integer.toBinaryString(tmp));
                System.out.println(binaryValue[i]);
            } else binaryValue[i] = Integer.toBinaryString(tmp);

        }
        StringBuilder tripledValue = new StringBuilder();
        for (int i = 0; i < binaryValue.length; i++) {
            for (int j = 0; j < binaryValue[i].length(); j++) {
                for (int k = 0; k < 3; k++) {
                    tripledValue.append(binaryValue[i].charAt(j));
                }
            }
        }
        return tripledValue.toString();
    }

    public static String decode(String bits) {
        String[] converter = new String[bits.length() / 3];
        for (int i = 0; i < converter.length; i += 3) {
            converter[i] = bits.substring(i, i + 2);
            int check = 0;
            for (int j = 0; j < converter[i].length(); j++) {
                if (converter[i].charAt(j) == '1') {
                    check++;
                } else check--;
            }
            if (check == 0) {
                throw new IllegalArgumentException("Something goes wrong!");
            } else if (check > 0) {
                converter[i] = "1";
            } else converter[i] = "0";
        }
        String[] number = new String[converter.length / 8];
        char[] almostDone = new char[number.length];
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < 8; j++) {
                number[i] += converter[j];
            }
            almostDone[i] = (char) Integer.parseInt(number[i], 2);
        }
        return String.valueOf(almostDone);
    }
}

