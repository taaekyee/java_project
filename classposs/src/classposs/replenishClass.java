package classposs;

import java.util.Scanner;

public class replenishClass {
	Scanner input = new Scanner(System.in);

	public void replenish(String[] item,int stock[], int iniStock[]) {
		int rep = 1;
		
		System.out.println("Do you want to replenish stock?(1. yes 2. no)");
		rep = input.nextInt();

		while (rep == 1) {
			
			int chNo = 0; // 보충할 상품번호
			int chQ = 0; // 보충할 상품량
			System.out.println("Please select a item number to replenish");																			
			chNo = input.nextInt();
			
			System.out.println("Item no." + chNo + "  ==>\t" + item[chNo] + "\tCurrent Stock : " + stock[chNo]);
			System.out.println("Please enter quantity");
			chQ = input.nextInt();
			stock[chNo] += chQ;
			iniStock[chNo]+=chQ;
			
			System.out.println("Item no." + chNo + "  ==>\t" + item[chNo] + "\tCurrent Stock : " + stock[chNo]);
			
			System.out.println("Do you want to replenish another item? (1. yes 2. no)");
			rep = input.nextInt();
		}

	}

}