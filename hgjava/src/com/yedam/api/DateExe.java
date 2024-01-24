package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime; 
import java.time.format.DateTimeFormatter;
import java.util.Date;
 

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		
		System.out.println(sdf.format(today)); //Date => String
		try {
		     today = sdf.parse("2020-01-05 12:12:12"); //String-> Date
		}catch (ParseException e){
			e.printStackTrace();
		}
		System.out.println(today);
		
		Date now = new Date();                  //변수 today 와 지금 시간 전이니깐 before이라 하면 true
		System.out.println(today.before(now));  //after라 하면 false가 나옵니다.
		                    
		//LocalDate, LocalTime, LocalDateTime
		LocalDate ld =LocalDate.now();
		System.out.println(ld.toString());
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt.toString());
	
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.toString());
		
		String result =ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(result);
	}//메인메소드 끝                              
}
