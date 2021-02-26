package com.labyrinth.mryxlarkbot.scrapper;

import java.io.*;
import java.util.Random;

public class TextMixer {
//    public static void main(String[] args) {
//        try {
//            int indicator = 0;
//            BufferedReader readerEn = new BufferedReader(new FileReader(new File("src/main/resources/quote2.txt")));
//            BufferedReader readerCn = new BufferedReader(new FileReader(new File("src/main/resources/quotes.txt")));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/repository.txt"));
//            Random random = new Random();
//            String text = "";
//            while (text!=null){
//                int a = random.nextInt(100);
//                if(isEven(a)){
//                    bufferedWriter.write(text);
//                    bufferedWriter.newLine();
//                    text = readerCn.readLine();
//                    indicator = 0;
//                }else{
//                    bufferedWriter.write(text);
//                    bufferedWriter.newLine();
//                    text = readerEn.readLine();
//                    indicator = 1;
//                }
//            }
//            if(indicator==0){
//                while(text!=null){
//                text = readerEn.readLine();
//                bufferedWriter.write(text);
//                bufferedWriter.newLine();
//                }
//            }else {
//                while(text!=null){
//                    text = readerCn.readLine();
//                    bufferedWriter.write(text);
//                    bufferedWriter.newLine();
//                }
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


    static Boolean isEven(int i){
        if(i%2==0){
            return true;
        }
        return false;
    }

}
