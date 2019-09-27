package com.codegym.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Rarest bytes

*/

public class Solution {

    public static void main(String[] args) throws Exception {
        // new HashMap<Data, Count>
        HashMap<Integer, Integer> bytes = new HashMap<>();

        int minNumberOfRepetitions = 2;

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        int count;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (!bytes.containsKey(data)) {
                bytes.put(data, 1);
            } else {
                count = bytes.get(data) + 1;
                bytes.replace(data, count);
            }
        }
        inputStream.close();

        for (Integer key : bytes.keySet()) {
            if (bytes.get(key) < minNumberOfRepetitions) {
                System.out.print(key + " ");
            }
        }

    }
}
