/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.drivers.asdfasdf;
import domain.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Raakhuga
 */
public class testRandom {
    public static void main(String[] args) throws Exception{
        /*Group a = new Group(0, 5, 8, 20, 10, 80);
        subGroup b = new subGroup(a, 11, 20);
        
        ClassSubject aux2[][] = a.getTimetable().getCS();
        
        aux2[2][11].setEmpty(false);
        
        Group aux = b;
        System.out.println(aux.isSubGroup());
        System.out.println(aux.getNum());
        System.out.println(((subGroup)aux).isSuperEmpty(2,11));
        System.out.println("Group: " + a.getEnrolled() + " subGroup: " + aux.getEnrolled());*/
        /*Date date = new Date();
        String strDateFormat = "hh:mm";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);*/
        /*
        String s = "That's a good question";
        String[] words = s.split("[\\s']");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
            System.out.println(words[i]);
        }*/
        
        int indexOfSpace = 0;
        int nextIndexOfSpace = 0;

        String sentence  = "This is a sentence";
        
        nextIndexOfSpace = sentence.indexOf(" ",indexOfSpace+1);
        
        while(indexOfSpace != nextIndexOfSpace){
            String word = sentence.substring(indexOfSpace,nextIndexOfSpace);
            System.out.println("Word: " + word + " Length: " + word.length());
            indexOfSpace = nextIndexOfSpace;
            if (sentence.indexOf(" ", indexOfSpace+1) >= 0)nextIndexOfSpace = sentence.indexOf(" ",indexOfSpace+1);
            else nextIndexOfSpace = sentence.length();
        }
    }
}
