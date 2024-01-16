package todo;

import java.util.Scanner;

public class Todo0116 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(true) {
		System.out.println("값을 입력>>>");
		String input = scn.nextLine();
		//input.equals("quit")
		//입력값은 홍길동입니다.
		
		//"quit" 값이 들어오면 <<end of prog>>
		if(input.equals ("quit")) {
			break;
			
		}
	}

}
}