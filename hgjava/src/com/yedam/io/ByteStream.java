package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
	public static void main(String[] args) {
		//입력출력 => 복사.
		try {
			FileInputStream fis = new FileInputStream("c:/temp/npp.exe");
			FileOutputStream fos = new FileOutputStream("c:/temp/copy.exe");
			//byte[] byteAry = new byte[100];
			
			//보조스트림. Buffered...
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			
			while(true) {
				int buf = bis.read();          //fis.read(byteAry);   //하나씩 쓰면 늦어지니깐 배열단위 100개로 설정하여 실행한다.
				if(buf == -1) {
					break; //종료
				}
				//fos.write(byteAry); 배열로한 정보처리
				bos.write(buf);    //보조스크림으로 한 배열처리
			}
			bos.flush(); bos.close();
			fos.flush(); fos.close();
			fis.close(); 
			bis.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("end of file");
	}
	
	static void wirte() {
		//바이트 출력 스트림.(input,output)
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/sample.dat");
			fos.write(10);
			fos.write(20);
			fos.write(30);
			fos.flush();
			fos.close();      //자원환원.
			
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void read() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/sample.dat");
			while(true) {
		    int bytes = fis.read(); // eof => -1반환
		    if(bytes == -1) {
		    	break;
		    }
		    System.out.println(bytes);
			}
			fis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}	
			System.out.println("end of file");
	}
}
