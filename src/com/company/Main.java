package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter NIP no. in xxx-xxx-xx-xx");
        Scanner sc= new Scanner(System.in);
        String nipString=sc.next();
        if(nipString.length=10){
        char[] nipChar=nipString.toCharArray();
        System.out.println(toCheckNIP(nipChar));}
        else{
        System.out.println("Input is less than or equal to 10..");
            
        }
    }

    private static boolean toCheckNIP(char[] nipChar) {
        char[] reducedNip = new char[10];
        reducedNip[0] = nipChar[0];
        reducedNip[1] = nipChar[1];
        reducedNip[2] = nipChar[2];
        reducedNip[3] = nipChar[4];
        reducedNip[4] = nipChar[5];
        reducedNip[5] = nipChar[6];
        reducedNip[6] = nipChar[8];
        reducedNip[7] = nipChar[9];
        reducedNip[8] = nipChar[11];
        reducedNip[9] = nipChar[12];
        int[] nipInt = toIntArray(reducedNip);
        int[] weights = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        int[] finalKey = new int[10];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            finalKey[i] = nipInt[i] * weights[i];
            sum += finalKey[i];
        }
        System.out.println(sum%11);
        System.out.println(reducedNip[reducedNip.length-1] );
        int lastNip=reducedNip[reducedNip.length-1];
        int sum11=sum%11;
        if(sum11==lastNip){
            return false;

        }
        else
            return true;


    }
    private static int[] toIntArray(char[] reducedNip) {
        int[] result=new int[reducedNip.length];
        for (int i=0; i<reducedNip.length;i++){
            result[i]= Integer.parseInt(String.valueOf(reducedNip[i]));
        }


        return result;
    }


}
