package practice;

class Test<T, U>{
	T obj1;
	U obj2;
	
	Test(T obj1, U obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void print() {
		System.out.println(obj1);
		System.out.println(obj2);
	}
}

public class Generic_practice {

	public static void main(String[] args) {
		
		Test <Integer, String> test  = new Test<Integer, String>(10, "Harsh");		
		test.print();
		
		Test<Boolean, String> obj2 = new Test<Boolean, String>(true, "Shah");
		obj2.print();

	}

}
