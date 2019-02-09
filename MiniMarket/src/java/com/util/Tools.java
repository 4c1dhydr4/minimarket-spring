package com.util;

public class Tools {
    public static String getCode(String prevCode){
        int len = prevCode.length();
        char [] codeArray = prevCode.toCharArray();
        char initCode = codeArray[0];
        String number = "";
        for (int i=1; i<len; i++){
            number = number + codeArray[i];
        }
        int numberInt = Integer.valueOf(number);
        numberInt = numberInt+1;
        String code = initCode + getZeros(numberInt) + String.valueOf(numberInt);
        return code;
    }
    private static String getZeros(int nextCode){
        String code = "";
        if (nextCode <10 ){
            code = "000";
        }else if(nextCode < 100){
            code = "00";
        }else if(nextCode < 1000){
            code = "0";
        }else{
            code = "";
        }
        return code;
    }
}
