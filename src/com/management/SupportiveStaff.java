package com.management;
 
public class SupportiveStaff extends Person {

	int id;
	String domain;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public SupportiveStaff(String name,int age,String address,int id,String domain)
	{
		super(name,age,address);
		this.id=id;
		this.domain=domain;
		
	}

		
	
	@Override
	public String toString() {
	System.out.println(super.toString());
		return "SupportiveStaff [id=" + id + ", domain=" + domain + "]";
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Work as SupportiveStaff.......");
	}
}
