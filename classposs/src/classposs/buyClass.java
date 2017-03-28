package classposs;

import java.util.Arrays;
import java.util.Scanner;

public class buyClass {
	Scanner input = new Scanner(System.in);
	int selectP = 0; // 상품번호를 선택하기 위한 변수
	int selectC = 0; // 상품수량을 선택하기 위한 변수
	int exit = 0; // 구매를 계속할 것인지 선택하기 위한 변수
	int[] cartIno = new int[10];
	String[] cartI = new String[10];
	int[] cartC = new int[10];
	int[] cartPr = new int[10];
	int cnt = 0;
	
	public void buy(int ItemNo[], int price[], int stock[], String Item[]) {
		System.out.println("START MARKET!!");
		Arrays.fill(cartIno, 0);
		Arrays.fill(cartI, null);
		Arrays.fill(cartC, 0);
		Arrays.fill(cartPr, 0);
		cnt=0;
		
		do { // 한 명의 구매가 끝날 때까지 반복하는 반복문
			exit = 1; // 구매종료 index
			int index = 0; // 구매한 물품을 다시 구매할 때 수량을 더해주기 위한 index

			System.out.print("Please select a item number. ");
			selectP = input.nextInt();
			if (stock[selectP] == 0) {
				System.out.println("Out of stock");
				continue;
			}

			System.out.println("Item no." + selectP + "  ==>\t" + Item[selectP] + "  :  " + price[selectP] + " WON/EA\n"
					+ "Current Stock : " + stock[selectP]);

			System.out.print("Please enter quantity ");
			selectC = input.nextInt();
			while (selectC > stock[selectP]) {
				System.out.println("Out of stock.\t[Only " + stock[selectP] + " left in stock.]");
				System.out.print("Please re-enter quantity ");
				selectC = input.nextInt();
			}

			stock[selectP] -= selectC;
			for (int i = 0; i < cnt; i++) {
				if (Item[selectP].equals(cartI[i])) {
					cartC[i] += selectC;
					index = 1;
				}
			}
			if (index != 1) {
				cartIno[cnt] = ItemNo[selectP];
				cartI[cnt] = Item[selectP];
				cartPr[cnt] = price[selectP];
				cartC[cnt] = selectC;
				cnt++;
			}

			System.out.println("Continue buying?(1. yes 2. no)");
			exit = input.nextInt();
		} while (exit == 1);
	}
}
