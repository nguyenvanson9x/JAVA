package object;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class studentTest {
	public static void main(String[] args) throws FileNotFoundException,
			ClassNotFoundException, IOException {
		HocSinh[] hocsinh = new HocSinh[3];

		hocsinh[0] = new HocSinh("HS01", "Tran Anh Duy", 5,
				"hoc luc trung binh");
		hocsinh[1] = new HocSinh("HS02", "Pham Van Khai", 7, "hoc luc kha");
		hocsinh[2] = new HocSinh("HS03", "Le Phuoc Tho", 9, "hoc luc gioi");

		// Ghi vào File
		fileprocess xuly = new fileprocess();

		// xuly.saveToFilebyData(hocsinh,"HocSinhData.txt");
		xuly.saveToFilebyObject(hocsinh, "HocSinhObject.txt");
		// xuly.saveToFilebyPrint(hocsinh,"HocSinhBuffer.txt");

		// Đọc từ File
		HocSinh[] hsLoad = null;
		ArrayList<HocSinh> arr = null;

		// hsLoad = xuly.loadFromFilebyData("HocSinhData.txt");
		// for(HocSinh hs : hsLoad){ // Duyệt mảng đối tượng
		// System.out.println(hs.getMaHS() + "  ,  " + hs.getTenHS() + "  ,  " +
		// hs.getDiem() + "  ,  " + hs.getGhiChu());
		// }

		System.out.println("---------------------");

		// hsLoad = xuly.loadFromFilebyObject("HocSinhObject.TXT");
		arr = xuly.loadFromFile("HocSinhObject.TXT");
		// for (HocSinh hs : hsLoad) {
		// System.out.println(hs.getMahs() + "  ,  " + hs.getTenhs() + "  ,  "
		// + hs.getDiem() + "  ,  " + hs.getGhichu());
		// }
		// System.out.println("---------------------");
		System.out.printf("%-4s\t%-15s%-7.1s%-15s\n", "Ma HS","Ten HS","Diem","Ghi chu");
		
		for (int i = 0; i < arr.size(); i++) {
			// System.out.println(arr.get(i).getMahs() + "  ,  " +
			// arr.get(i).getTenhs() + "  ,  "
			// + arr.get(i).getDiem() + "  ,  " + arr.get(i).getGhichu());
			// System.out.println(arr.get(i));
			System.out.printf("%-7s\t%-15s%-7.1f%-15s\n", 
					arr.get(i).getMahs(),
					arr.get(i).getTenhs(), 
					arr.get(i).getDiem(), arr.get(i).getGhichu());
		}

		// hsLoad = xuly.loadFromFilebyBuffer("HocSinhBuffer.TXT");
		// for(HocSinh hs : hsLoad){
		// System.out.println(hs.getMahs() + "  ,  " + hs.getTenhs() + "  ,  " +
		// hs.getDiem() + "  ,  " + hs.getGhichu());
		// }
	}
}
