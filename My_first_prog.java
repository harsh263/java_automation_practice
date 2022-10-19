public class My_first_prog{
	
	public static void main(String[] args){
		
		// This is my comment
		/***********
		This is my multi line comment
		**********/
		
		/** Start of doc comments
		This is my end of doc comment*/
		
		// Keywords - JAVA uses this words internally to execute the programmes
		
		// integer, String, float, boolean, 
		//These keywords are reserved for internal use for JAVA
		
		// There are 8 types of variables in JAVA
		
		// Premitives data types
		/*****************
		boolean - 1/0 - true/false
		char - 'a' - 2Byte - 16bits - Covers ASCII table
		byte - 1 byte - 8bits signed -128 to 127 = 256
		
		int - 4 Byte
		short - 2 Byte
		long - 8 Byte
		
		float - 4 Byte
		double - 8 Byte
		
		
		******************/
		int int1 = 50;
		System.out.println("This is my first JAVA programme...");
		
		float x = 2.2222233456f;
		
		double y = 2.2222233456;
		
		System.out.printf("This is my float value:" + x + "\n");
		System.out.printf("This is my double value:" + y);
		
		// String is non primitive data type
		String s1 = new String("This is my String");
		System.out.println(s1);
		
	}
	
	
}