package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
        Map<Member, Integer> map = new HashMap<>();
        map.put(new Member(1,"홍길동"), 900);
        map.put(new Member(2,"박길동"), 1200);
        map.put(new Member(3,"최길동"), 500);
        map.put(new Member(1,"홍길동"), 800);
        map.put(new Member(4,"김길동"), 1500);
        
        System.out.println("크기:"+map.size());
        System.out.println("키 :"+new Member(1,"홍길동"));
        System.out.println("값 :"+ map.get(new Member(1,"홍길동")));
        
        System.out.println("키의 존재유무: "+map.containsKey(new Member(2,"박길동")));
        System.out.println("키의 존재유무: "+map.containsValue(1200));
        
        //포인트가 1000점 이상인 사람의 이름 출력
       Set<Entry<Member, Integer>> eset= map.entrySet();
       Iterator<Entry<Member, Integer>> iter=eset.iterator(); 
       
       while(iter.hasNext()) {
    	   Entry<Member, Integer> ent= iter.next();
    	   if(ent.getValue()>1000) {
    		   System.out.printf("이름:%s, 포인트%d \n",ent.getKey().getName(),ent.getValue());
    	   }
       }
	}
}
