package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Answeer {

	public static void main(String[] args) {
		
		double value = 'A';
		System.out.println("Ascii value is :" + (int)value);
		
		System.out.println(Math.pow(7,5));
		
		// SWAP the two values without using the third variable
		int a = 50;
		int b = 60;
		b = b - a;
		a = b + a;
		b = -(b - a);
		System.out.println("a : " + a + "| b :" + b);
		
		// Scanner or user input data
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
//		String z = scan.next();
		System.out.println(x + y);
		
		// Dividable by 2 or not.
		if(x%2 == 0) {
			System.out.println("x is devidable by 2");			
		}
		else {
			System.out.println("x is not devidable by 2.");
		}
		
		
		//Write a method which will count occurrences of ints in a list and put it into map
		//(eg, List.of(1,1,5,5,3) -> Map.of({1,2},{5,2},{3,1})
		List<Integer> int_list = new ArrayList<Integer>();
		int_list = Arrays.asList(1, 1, 2, 4, 3, 2, 5, 3, 1, 2, 4, 2, 5, 1, 5, 3);
		Map<Integer, Integer> out_put = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < int_list.size(); i++) {
			int match = 1;
			if(!out_put.containsKey(int_list.get(i))){
			
				for(int j = i + 1; j < int_list.size(); j++) {
					
					if(int_list.get(i) == int_list.get(j)){
					match = match + 1;
					}
				}
			out_put.put(int_list.get(i), match);
			}
		}
		System.out.println(Arrays.asList(out_put));
		
		// Arrange the string in ascending order
		List<Integer> sort_list = new ArrayList<Integer>();
		sort_list = Arrays.asList(2, 6, 8, 3, 7, 0, 1, 9, 4, 5);
		for(int i = 0; i < sort_list.size(); i++){
				
			for(int j = i + 1; j < sort_list.size(); j++) {
				if(sort_list.get(i) > sort_list.get(j)) {					
					int temp = sort_list.get(i);
					sort_list.set(i, sort_list.get(j));
					sort_list.set(j, temp);
				}	
			}	
		}
		System.out.println(Arrays.asList(sort_list));
	}
}
		



