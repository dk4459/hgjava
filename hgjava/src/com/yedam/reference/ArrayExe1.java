package com.yedam.reference;

public class ArrayExe1 {

	public static void main(String[] args) {
		  //선언.
		int[] intAry = {10, 20, 30}; //intAry(참조변수)와 int(기본형변수)는 다름 하지만 intAry[0] === int
		int[][] intArray={ {10,20},{30,40},{50}};//배열안에 또 배열이 들어가있는것 
		//intArray[0] !== int[] 정수가 아님 배열임     intAraay[0][0]===int 0번방에 0번방을 찾으면 정수
		
		String[] strAry = new String[5];    //크기선언
		strAry = new String[] {"Hello","world","nice"};
		
		for(String elem: strAry) {
			System.out.println(elem);  //elementry 요소값을 갖고 나옴
		}
	}

}
