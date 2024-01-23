package com.yedam.classes.abstracts;

public class AnimalExe {
 public static void main(String[] args) {
     //Animal animal =new Animal();  추상클래스는 인스턴스를 못만든다
	 Animal animal =null;
	 animal = new Bird("제비");
	 animal. eat();
	 animal.sleep();
	 
     Bird bird = new Bird("참새");
     bird.eat();
     bird.sleep();
     
     Dog dog = new Dog();
     
     Bird[]birds = new Bird[5];  //이렇게할시 버드는 받겠지만 도그는 못받음 
     //birds[0]=dog;
     
     Animal[] animals = new Animal[10];
     animals[0]= bird;
     animals[1]=dog;          //참조변수 Animal로 하면 dog도 bird도 받을 수 있다.  
     
 }
}
