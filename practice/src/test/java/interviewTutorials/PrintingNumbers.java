package interviewTutorials;

public class PrintingNumbers {
	
	private void print_1_to_10_num() {
		System.out.println("======== Print 1 to 10===========");
		for (int i=0; i<10; i++) {
			System.out.print(i + ",");
		}
	}
	
	private void print_10_t0_1_num() {
		System.out.println("\n======== Print 10 to 1 ============");
		for (int i=10; i > 0; i--) {
			System.out.print(i + ",");
		}
	}
	
	private void print_even_numbers() {
		System.out.println("\n======== Print event numbers =========");
		for (int i=0; i < 50; i++) {
			if (i % 2 == 0) {
				System.out.print(i + ",");
			}
		}
	}
	
	private void print_number_divisible_by_3() {
		System.out.println("\n======= Print number divisible by 3 =========");
		for (int i = 99; i >=0; i--) {
			if(i % 3 == 0) {
				System.out.print(i + ",");
			}
		}
	}
	
	private void print_squeres() {
		System.out.println("\n======== Print squeres ========");
		for(int i = 0; i < 10; i++) {
			
			if (i != 0) {
				int temp = 1;
				for(int j = i; j > 1; j--) {
					temp = temp*  2;
				}
			System.out.print(temp + ",");
			}
			else {
				System.out.print(i + ",");
			}
		}
	}

	public static void main(String[] args) {
		PrintingNumbers print = new PrintingNumbers();
		print.print_1_to_10_num();
		print.print_10_t0_1_num();
		print.print_even_numbers();
		print.print_number_divisible_by_3();
		print.print_squeres();

	}

}
