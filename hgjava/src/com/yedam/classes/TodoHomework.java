package com.yedam.classes;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoHomework {
    public static void main(String[] args) {
        Date date = new Date(); 
        System.out.println(date.getYear() + 1900); //1900년부터 시작 Date클래스는 곧 없어짐
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse("2024-02-04");
        } catch (Exception e) {
            e.printStackTrace();
        }
       System.out.println(date.getYear());
       System.out.println(date.getMonth());
       System.out.println(date.getDay());
     	System.out.println(date.getDate());
        drawCalendar(date.getYear(),date.getMonth());
    }

    static void drawCalendar(int year, int month) {
    	Calendar cal = Calendar.getInstance();
    	cal.set(year+1900,month,1);
    	int pos = cal.get(Calendar.DAY_OF_WEEK) -1 ;
		int lastDate =cal.getActualMaximum(Calendar.DATE);
		String[] days = {"sun","mon","tue","wed","Thr","Fri","Str"};
		for(int i=0; i < 7; i++) {
		System.out.printf("%3s",days[i],"\n");
		}
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