package classposs;

public class printClass {
	public void printList(int ItemNo[], String Item[], int price[], int stock[], int count) {
		System.out.println("================List================"); // 상품 리스트 출력
		System.out.println("Item No.\tItems\t\tPrice\t\tStock");
		for (int i = 1; i < count; i++) {
			System.out.print(ItemNo[i] + "\t\t");
			System.out.print(Item[i] + "\t\t");
			System.out.print(price[i] + "\t\t");
			System.out.println(stock[i]);
		}
	}

	public int printReceipt(int cartIno[], String cartI[], int cartPr[], int cartC[], int cnt, int sum) {
		System.out.println("============================Receipt============================");
		System.out.println("Item No.\tItem\t\tPrice\t\tEA\t\tTotal");
		for (int i = 0; i < cnt; i++) {
			System.out.print(cartIno[i] + "\t\t");
			System.out.print(cartI[i] + "\t\t");
			System.out.print(cartPr[i] + "\t\t");
			System.out.print(cartC[i] + "\t\t");
			System.out.println(cartPr[i] * cartC[i]);
			sum += cartPr[i] * cartC[i];
		}
		return sum;
	}

	public void printSales(int ItemNo[],String Item[],int price[],int stock[],int iniStock[],int count,int sum) {
		System.out.println("============================Today's sales============================");
		System.out.println("Item No\tItem\tPrice\tEA\tTotal");
		for (int i = 1; i < count; i++) {
			if ((iniStock[i] - stock[i]) == 0) {
				continue;
			}
			System.out.println(ItemNo[i] + "\t" + Item[i] + "\t" + price[i] + "\t" + (iniStock[i] - stock[i]) + "\t"
					+ (iniStock[i] - stock[i]) * price[i]);
		}
		System.out.println("Todays sales :" + sum);

	}
}
