package com.yedam.api;

public class Member {
     String name;
     int age;
     
     Member(){}
     Member(String name, int age){
    	 this.name = name;
    	 this.age = age;
     }
     
     @Override
    public int hashCode() {

       return this.name.hashCode();
    }
     
     
     //name같으면 논리적으로 동일한 객체.
     @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Member) {
    	   Member target = (Member) obj;
    	   if(this.name.equals(target.name) && this.age == target.age) {
    		   return true;
    	   }
    	}
    	return false;
    }
     @Override
    public String toString() {

    	 return "이름은" +name + ", 나이는" +age;
    }
}
