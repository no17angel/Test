package demo.extend;

public class Child extends Parent {
	
	public Child(){
		System.out.println("Child init");
	}
	static{
		System.out.println("Child static");
	}
	{
		System.out.println("Child{}");
	}
}
