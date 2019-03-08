package com.example.cedriclingom.blablacampus.routes.utils;


import java.util.Date;
import java.util.GregorianCalendar;

public class TimeHandler {

    private static Date date;




    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        TimeHandler.date = date;
    }


    public static void toDate(String date, String hour, String min){

        String[] tab = date.split(" ");

        GregorianCalendar gregorianCalendar = new GregorianCalendar(
                Integer.valueOf(tab[2]).intValue(),
                getMonthNumber(tab[1]),
                Integer.valueOf(tab[0]).intValue(),
                Integer.valueOf(hour).intValue(),
                Integer.valueOf(min).intValue());

        TimeHandler.date = gregorianCalendar.getTime();

    }


    private static int getMonthNumber(String month){

        int number = 0;

        switch(month){

            case "Janvier": number = 1;
                break;

            case "Février": number = 2;
                break;

            case "Mars": number = 3;
                break;

            case "Avril": number = 4;
                break;

            case "Mai": number = 5;
                break;

            case "Juin": number = 6;
                break;

            case "Juillet": number = 7;
                break;

            case "Aout": number = 8;
                break;

            case "Septembre": number = 9;
                break;

            case "Octobre": number = 10;
                break;

            case "Novembre": number = 11;
                break;

            default: number = 12;
        }

        return number;
    }
}
