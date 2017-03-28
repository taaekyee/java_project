package classposs;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class AccessFileClass {
	InputStream in = null;
	DataInputStream din = null;
	OutputStream out = null;
	DataOutputStream dout = null;

	int[] ItemNo = new int[100]; // 상품번호를 저장할 배열
	String[] Item = new String[100]; // 상품이름을 저장할 배열
	int[] price = new int[100]; // 상품가격을 저장할 배열
	int[] stock = new int[100]; // 상품재고를 저장할 배열
	int[] iniStock = new int[100]; // 초기재고를 저장할 배열
	int count = 0;

	public void getFileData(String fileName) {
		try {
			in = new FileInputStream(fileName);
			din = new DataInputStream(in);
			while (din.available() > 0) {
				String str;
				String strArr[] = new String[4];
				str = din.readLine();
				strArr = str.split(",");

				if (count == 0) {
					count++;
					continue;
				}

				this.ItemNo[count] = Integer.parseInt(strArr[0]);
				this.Item[count] = strArr[1]; 
				this.price[count] = Integer.parseInt(strArr[2]); 				
				this.stock[count] = Integer.parseInt(strArr[3]);
				this.iniStock[count] = Integer.parseInt(strArr[3]);
				count++;
			}

		} catch (Exception e) {
		}
	}

	public void outFileData(String fileName, int stock[], int sum) {
		try {
			out = new FileOutputStream(fileName);
			dout = new DataOutputStream(out);
			dout.writeBytes("============================Today's sales============================\n");
			dout.writeBytes("Item No.,Item,Price,EA,Total\r\n");
			for (int i = 1; i < count; i++) {
				if ((iniStock[i] - stock[i]) == 0) {
					continue;
				}
				dout.writeBytes(ItemNo[i] + ",");
				dout.writeBytes(Item[i] + ",");
				dout.writeBytes(price[i] + ",");
				dout.writeBytes(iniStock[i] - stock[i] + ",");
				dout.writeBytes((iniStock[i] - stock[i]) * price[i] + "\r\n");
			}

			dout.writeBytes("\r\nTodays sales," + sum);										
		} catch (Exception e) {
		}
	}
}
