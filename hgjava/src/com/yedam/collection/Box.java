package com.yedam.collection;

public class Box<T>{
    T obj;                   //아직 타입 값이 정해지지 않았으니 제네릭으로 받고 그다음에
                             //옮긴다
    void setObj(T obj) {
    	this.obj = obj;
    }
    T getObj() {
    	return obj;
    }
}
