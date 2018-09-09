package com.example.mansour.annoythem_textrepeater;

/**
 * Created by Mansour on 7/23/2018.
 */

public class StringUtils {

    public static String repeat(String text, int numberOfIterations){
        StringBuilder buffer = new StringBuilder(text.length()*numberOfIterations);
        while(numberOfIterations-- > 0){
            if(!MainActivity.setNewLine){
                buffer.append(text);
            }else
            {
                buffer.append(text);
                //buffer.append("\n");
                buffer.append(System.getProperty("line.separator"));
            }

        }
        return buffer.toString();
    }
}
