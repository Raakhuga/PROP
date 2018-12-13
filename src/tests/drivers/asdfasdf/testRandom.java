/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.drivers.asdfasdf;
import domain.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
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
        
        File file = new File("src/tests/drivers/asdfasdf/state.txt");
        Scanner input = new Scanner(file);
        System.out.println(input.nextInt());
        while (input.hasNext()) {
          String word  = input.next();
          System.out.println(word);
        }
        
    }
}
