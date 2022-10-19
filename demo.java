public class demo {
	
	public static void main(String[] args) {
		int abc = 23;
		System.out.println("This is the demo program");
		childclass obj = new childclass();
		
		System.out.println("This is the childclass variable: " + obj.p2);
		System.out.println("This is the parentclass variable: " + obj.p1);
		
		System.out.println("Polymorphism with 2 args: " + obj.sum1(100, 200));
		System.out.println("Polymorphism with 3 args: " + obj.sum1(1, 2, 3));
		System.out.println(" Overriding with 4 args: " + obj.sum1(10, 20, 30, 40));
		
		absclass obj1 = new impclass();
		obj1.substract();
		
		interface1 driver = new interface2();
		
		childclass obj123 = new childclass(abc);
		
	}	
}

abstract class absclass {
	
	abstract void substract();
	
}



interface interface1 {
	
	void interface_method1();
	void interface_method2();
	
}

class interface2 implements interface1 {
	
	public void interface_method1() {		
		System.out.println("We are inside interface method1");		
	}
	
	public void interface_method2() {
		System.out.println("We are inside interface method1");		
	}
	
}

class impclass extends absclass {
	
	public void substract() {
		
		System.out.println("This is my abstract method implemented in child class.");
		
	}
}

class parentclass {
	
	int p1 = 12;
	
	public int sum1(int x, int y, int z, int a) {
		
		int xy = x + y + z + a;
		return xy;
	}
}

class childclass extends parentclass {
	
	int p2 = 2223412;
	// Default Constructor 
	childclass() {
		
		System.out.println("This is default constructor");
	}
	
	childclass(int x){
		System.out.println("This is parameterized constructor");
		System.out.println("This is parameterized constructor argument is: " + this.p2);
		this.p2 = x;
		System.out.println("This is parameterized constructor argument is: " + this.p2);
	}
	
	public int sum1(int x, int y) {
		
		int xy = x + y;
		return xy;
	}
	
	public int sum1(int x, int y, int z) {
		
		int xyz = x + y + z;
		return xyz;
	}
}
