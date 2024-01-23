package com.yedam.impl;

public class Helocopter extends Airplane {
   @Override
   public void takeOff() {
	System.out.println("[Helocopter] - 이륙");
   }
   @Override
   public void fly() {
	System.out.println("[Helocopter] - 비행");
   }
   @Override
   public void land() {
	System.out.println("[Helocopter] - 이륙");      //@Override 써도 되고 안써도 되지만 @Override써야만 체크가 가능하다
   }                                               //예를들어 부모 메서드가 아님을 @Override가 알려준다

}
