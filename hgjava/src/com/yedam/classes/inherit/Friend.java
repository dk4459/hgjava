package com.yedam.classes.inherit;

import lombok.Data;

//이름, 연락처             (Friend)
//이름, 연락처, 학교, 전공   (UnivFriend)
//이름, 연락처, 회사, 부서   (CompFriend)
@Data
public class Friend extends Object{   //명시는 안되어있지만 object클래스의것을 상속받는다
      private String name;
      private String phone;
      
      public void changeInfo(String info1, String info2) {
    	  return;
      }
      
      @Override   //오버라이드 재정의 실행
      public String toString() {
    	  return "이름은"+name+",연락처는"+phone;
      }
      
}
