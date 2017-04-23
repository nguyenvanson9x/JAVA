public class Process {
 
    public static void main(String[] args) {
        HocSinh[] hocsinh = new HocSinh[3];
 
        hocsinh[0] = new HocSinh("HS01", "Tran Anh Duy", 5, "hoc luc trung binh");
        hocsinh[1] = new HocSinh("HS02", "Pham Van Khai", 7, "hoc luc kha");
        hocsinh[2] = new HocSinh("HS03", "Le Phuoc Tho", 9, "hoc luc gioi");
 
        //Ghi vào File
        XuLyFile xuly = new XuLyFile();
 
        xuly.saveToFilebyData(hocsinh,"HocSinhData.txt");
        xuly.saveToFilebyObject(hocsinh,"HocSinhObject.txt");
        xuly.saveToFilebyPrint(hocsinh,"HocSinhBuffer.txt");
 
        //Đọc từ File
        HocSinh[] hsLoad = null;
 
        hsLoad = xuly.loadFromFilebyData("HocSinhData.txt");
        for(HocSinh hs : hsLoad){ // Duyệt mảng đối tượng
            System.out.println(hs.getMaHS() + "  ,  " + hs.getTenHS() + "  ,  " + hs.getDiem() + "  ,  " + hs.getGhiChu());
        }
 
        System.out.println("---------------------");
 
        hsLoad = xuly.loadFromFilebyObject("HocSinhObject.TXT");
        for(HocSinh hs : hsLoad){
            System.out.println(hs.getMaHS() + "  ,  " + hs.getTenHS() + "  ,  " + hs.getDiem() + "  ,  " + hs.getGhiChu());
        }
        System.out.println("---------------------");
 
        hsLoad = xuly.loadFromFilebyBuffer("HocSinhBuffer.TXT");
        for(HocSinh hs : hsLoad){
            System.out.println(hs.getMaHS() + "  ,  " + hs.getTenHS() + "  ,  " + hs.getDiem() + "  ,  " + hs.getGhiChu());
        }
    }
}