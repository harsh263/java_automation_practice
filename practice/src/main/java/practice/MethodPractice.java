package practice;

import java.util.Scanner;

import com.google.common.hash.HashCode;

public class MethodPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This is my start of Main method.");
		
		MethodPractice obj = new MethodPractice();
		
		Scanner input = new Scanner(System.in);
		obj.addition();
		
		obj.sci_calc();
		
		input.nextInt();
		
		obj.addition();
		
		// == and isequal
		// stack memory
		String s1 = "ABC"; // same as s2 object and value
		String s2 = "ABC"; // same as s1 object and value
		String s3 = "XYZ";

		// heap memory
		String s4 = new String("ABC");
		
		System.out.printf("with == operator s1 and s2: %b \n", s1 == s2);
		System.out.println("with equal operator s1 and s2: " + s1.equals(s2));
		System.out.println("================================================");
		
		// == operator compares referance memory of two objects or variables. 
		System.out.printf("with == operator s1 and s4: %b \n", s1 == s4);
		
		// equal() only checks value of variable
		System.out.println("with equal operator s1 and s4: " + s1.equals(s4));

		
		String name = "String";
		
		String obj_string = new String("Stringnsdfklasjdfkl");
		
		char char1 = name.charAt(1);
		
		System.out.println("s1 location: " + s1.hashCode());
		System.out.println("s2 location: " + s2.hashCode());
		System.out.println("s3 location: " + s3.hashCode());
		System.out.println("s4 location: " + s4.hashCode());
		
		System.out.print(char1);
		System.out.println("\n==================");
		
		System.out.println("concat " + name.concat(obj_string));
		
		
		

	}

	public void addition() {
		
	System.out.println("THis is my addition method 1");
	
	System.out.println("THis is my addition method 2");
	
	System.out.println("THis is my addition method 3");
	
	System.out.println("THis is my addition method 4");
	
	
	}
	
	public void sci_calc() {
		
	System.out.println("THis is my sci_cal 1");
	
	System.out.println("THis is my sci_cal 2");
	
	System.out.println("THis is my sci_cal 3");
	
	System.out.println("THis is my sci_cal 4");
	
	
	}
	
	
}
