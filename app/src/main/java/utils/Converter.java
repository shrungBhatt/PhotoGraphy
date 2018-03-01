package utils;

import java.text.DecimalFormat;

/**
 * Created by ss-51 on 1/5/2018.
 */


//TODO The converter is not working properly. 62.02 Lakh is showing 62.2 Cr after converting.

public class Converter {
    public static String convert(final float Prices) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (Prices <= 999) {
            return String.valueOf(Prices);
        } else if (Prices >= 1000 && Prices <= 99999) {
            return (df.format(Prices / 1000)) + " K";

        } else if ((Prices >= 100000) && (Prices <= 9999999)) {
            return (df.format(Prices / 100000)) + " Lakh";
        } else if (Prices >= 10000000) {
            return (df.format(Prices / 10000000)) + " Cr.";
        } else {
            return String.valueOf(Prices);
        }
    }

    public static String converttoInt(final String Prices) {

        String unit = Prices.replaceAll("[^A-Z]", "");
        String number = Prices.replaceAll("[^0-9.]", "");
        if(number.lastIndexOf(".") == number.length()-1){
            int lastCharIndex = number.lastIndexOf(".");
            number = number.substring(0,lastCharIndex);
        }

        if (unit.equalsIgnoreCase("K")) {

            return (Integer.parseInt(number) * 1000) + "";
        } else if (unit.equalsIgnoreCase("L")) {
            return (Float.valueOf(number) * 100000) + "";
        } else if (unit.equalsIgnoreCase("C")) {
            return (Float.valueOf(number) * 10000000) + "";
        } else {
            return Float.valueOf(number) + "";
        }
    }


    public static String localeConverter(Integer amount){

        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String numberAsString = decimalFormat.format(amount);
        return numberAsString;
    }




}
