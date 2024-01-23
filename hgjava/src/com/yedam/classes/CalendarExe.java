package com.yedam.classes;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		 final int num =10;    //상수
         Calendar cal = Calendar.getInstance();
//         Calendar cal2 = Calendar.getInstance();
//       System.out.println(cal1 == cal2);  //싱글턴이 아니라 갑이 false가나온다  캘리더클래스는 상수로 반역한다
         System.out.println(Calendar.YEAR);
         cal.set(2024,1,1);       //set 값을 변경
         System.out.println("year:"+ cal.get(Calendar.DAY_OF_WEEK));  //1. 년(Calendar.YEAR)  2. 월(Calendar.MONTH) 3.
                                                                      //3. 요일(Calendar.DATE)
	     System.out.println("last Date:"+ cal.getActualMaximum(Calendar.DATE)); // getActualMaximum()그달의 마지막날 
	     
//	     drawCalendar(2024,4);
	     //Date date = new Date();   //1900년부터 시작 Date클래스는 곧 없어짐
	     //System.out.println(date.getYear()+1900);
	     //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
	     //try{
	       //date =sdf.parse("2024-01-01");
	     //}catch(Exception e)
	     //e.prinStackTrace();
	}
	      //drawCalendar(date);
//	static void draCalendar(Date date) {
		
//	}
	
	static void drawCalendar(int year, int month) {
		// (2024, 1)
		Calendar cal = Calendar.getInstance();
		cal.set(year,month-1,1);
		
		int pos = cal.get(Calendar.DAY_OF_WEEK) -1 ;
		int lastDate =cal.getActualMaximum(Calendar.DATE);  
		//수정... 월의 변경될때마다 마지막날 계산.
		String[] days = {"sun","mon","tue","wed","Thr","Fri","Str"};
		for(int i=0; i < 7; i++) {
		System.out.printf("%3s",days[i],"\n");}
		System.out.println("");//1일의 요일지정
		for(int i=0; i < pos; i++) {
			System.out.printf("%3s"," "); 
		}
		for(int d =1; d<= lastDate; d++) {
			System.out.printf("%3d", d);
			if(d%7 == 7-pos) {
				System.out.printf("\n");
			}
		}
	}
}
