package com.codewars.Krusher;

import java.util.List;

public class Main {
//    public static void main(String[] args) {
//
//
//        System.out.println(encode("hey"));
//
//    }

    public String encode(String text) {

        String[] binaryValue = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
            int tmp = text.charAt(i);
            if (Integer.toBinaryString(tmp).length() < 8) {
                StringBuilder addSomeValues = new StringBuilder();
                for (int j = 0; j < (8 - Integer.toBinaryString(tmp).length()); j++) {
                    addSomeValues.append('0');
                }
                binaryValue[i] = addSomeValues.toString() + Integer.toBinaryString(tmp);
            } else binaryValue[i] = Integer.toBinaryString(tmp);
        }
        StringBuilder tripledValue = new StringBuilder();
        for (int i = 0; i < binaryValue.length; i++) {
            for (int j = 0; j < binaryValue[i].length(); j++) {
                tripledValue.append(binaryValue[i].charAt(j))
                        .append(binaryValue[i].charAt(j))
                        .append(binaryValue[i].charAt(j));
            }
        }
        return tripledValue.toString();
    }

    public String decode(String bits) {
        String[] converter = new String[bits.length() / 3];
        for (int i = 0; i < bits.length(); i += 3) {
            converter[i / 3] = bits.substring(i, i + 3);
            System.out.println(converter[i / 3]);
            int check = 0;
            for (int j = 0; j < converter[i / 3].length(); j++) {
                if (converter[i / 3].charAt(j) == '1') {
                    check++;
                } else check--;
            }
            if (check == 0) {
                System.out.println("дичь");
            } else if (check > 0) {
                converter[i / 3] = "1";
            } else converter[i / 3] = "0";
        }

        char[] almostDone = new char[converter.length / 8];

        for (int i = 0, k = 0; i < almostDone.length; i++) {
            StringBuilder checker = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                checker.append(converter[k + j]);
            }
            almostDone[i] = (char) Integer.parseInt(checker.toString(), 2);
            k += 8;
        }
        return String.valueOf(almostDone);
    }
}

