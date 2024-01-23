package com.yedam.classes.inherit;





public class ComFriend extends Friend{
    private String company;
    private String dept;
    
    @Override
    public void changeInfo(String info1, String info2) {
    	this.company = info1;
    	this.dept = info2;
    	super.changeInfo(info1, info2);
    }
    @Override
    public String toString() {
        return super.toString()+",회사는" + company +"부서는" + dept;
    }
    public void setCompany(String company) {
  		this.company= company;
  		
  	}
  	public String getCompany() {
  		return this.company;
      
    }
  	public void setDept(String dept) {
  		this.dept = dept;
  		
  	}
  	public String getDept() {
  		return this.dept;
      
    }
}
