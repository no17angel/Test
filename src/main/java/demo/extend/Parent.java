package demo.extend;

public class Parent {
	
	public Parent(){
		System.out.println("Parent init");
	}
	static{
		System.out.println("Parent static");
	}
	{
		System.out.println("Parent{}");
	}
}
