package com.iz.pr01.service;

import com.iz.pr01.model.DropDownEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Stream;

public class Test {
    @Autowired
    Scheduler scheduler;

    public static void main(String[] args) {
//        Date currentDate = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String date  = simpleDateFormat.format(currentDate);
//        LocalDate localDate = LocalDate.parse(date);
//        Month m = localDate.getMonth().plus(1);
//        System.out.println(String.valueOf(m));

//        String s = "Velu,Mass";
//
//        String[] str = s.split(",");
//        String finalWord = "";
//        for (int i=0;i<str.length;i++){
//            finalWord = finalWord+"'"+str[i]+"'";
//            if (i!=str.length-1){
//                finalWord = finalWord+",";
//            }
//        }
//        System.out.println(finalWord);
//        String s2 = "test.xlsx";
//          String s1=  s2.replace("."," ");
//         String s3 =  s2.substring(0,s2.indexOf("."));
//
//        System.out.println("-------"+s3);

        String mail1 = "velusami.a@gmail.com";
        String mail2 = "velu@gmail.com,mass@gmail.com";
        List<String> email = new ArrayList<>();
        email.add(mail1);
        email.add(mail2);

        List<String> email2 = new ArrayList<>();
        for (String s : email) {
            List<String> emails = Arrays.asList(s.split(","));
            for (String email1 : emails) {
                email2.add(email1);
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        List<String> finalMails = email2;
        String to = null;
        for (String finalMail : finalMails) {
            stringBuilder.append(finalMail);
            stringBuilder.append(",");
        }
        if (stringBuilder.length()>0){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        String s = "ASN-0000000102";

        String sub = s.substring(4);
        System.out.println(sub);
        String docNum = s;
        if (!sub.contains("-")){
           docNum = docNum+"-1";
        }
        System.out.println(docNum);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date date1 = sdf.parse("31-01-2020")
//        Date date2 = sdf.parse("31-01-2020");

        String sDate5 = "Thu, Dec 31 1998 23:37:50";
        SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

        BigDecimal value = new BigDecimal(40.234);
        System.out.println(value.setScale(2, RoundingMode.FLOOR) +"----------");

        List<DropDownEnum> getAllEnum = new ArrayList<>();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date+"Dateeeeeee");


        String saNo = "57000085";

        boolean isMatched = false;
                if (saNo.matches(".*[A-Z].*")){
                    isMatched = true;
                }

        String newString = "Velu";
        newString.concat("Sami");

        System.out.println(newString);


    }

}
