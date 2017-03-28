package classposs;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) throws Exception {
		AccessFileClass accessFile = new AccessFileClass();
		replenishClass repl = new replenishClass();
		buyClass buy = new buyClass();
		printClass rec = new printClass();

		try {
			Scanner input = new Scanner(System.in);

			accessFile.getFileData("C:\\java\\goodss.csv");

			int[] ItemNo = new int[100]; // 상품번호를 저장할 배열
			String[] Item = new String[100]; // 상품이름을 저장할 배열
			int[] price = new int[100]; // 상품가격을 저장할 배열
			int[] stock = new int[100]; // 상품재고를 저장할 배열
			int[] iniStock = new int[100]; // 초기재고를 저장할 배열

			int count = 0; // 파일을 불러오면서 상품의 수를 카운트
			int close = 0; // 영업종료 index
			int sum = 0; // 총 매출액을 저장할 변수

			ItemNo = accessFile.ItemNo;
			Item = accessFile.Item;
			price = accessFile.price;
			stock = accessFile.stock;
			iniStock = accessFile.iniStock;
			count = accessFile.count;

			do { // 영업종료시 까지 반복하는 반복문
				rec.printList(ItemNo, Item, price, stock, count);
				repl.replenish(Item, stock, iniStock);
				buy.buy(ItemNo, price, stock, Item);

				int[] cartIno = new int[10];
				String[] cartI = new String[10];
				int[] cartC = new int[10];
				int[] cartPr = new int[10];
				int cnt = 0;

				cartIno = buy.cartIno;
				cartI = buy.cartI;
				cartC = buy.cartC;
				cartPr = buy.cartPr;
				cnt = buy.cnt;

				sum = rec.printReceipt(cartIno, cartI, cartC, cartPr, cnt, sum);

				System.out.println("End your sales?(1. no 2. yes)");
				close = input.nextInt();

			} while (close == 1);

			rec.printSales(ItemNo, Item, price, stock, iniStock, count, sum);
			accessFile.outFileData("c:\\java\\receipts.csv", stock, sum);

		} catch (Exception e) {
			System.out.println("오류발생"); // 오류발생시 예외처리
		}
	}
}