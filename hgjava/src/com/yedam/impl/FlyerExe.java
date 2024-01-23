package com.yedam.impl;

public class FlyerExe {
        public static void main(String[] args) {
			Flyer flyer = new Airplane();
			flyer.takeOff();                   //★다형성★
			
			flyer = new Helocopter();
			flyer.takeOff();
			
			flyer = new Seaplane();
			Driver driver = new Driver();
			driver.drive(flyer);                  
		}
}
