import java.io.*;
 
public class XuLyFile{
 
    //Dùng DataOutputStream để ghi File
    public void saveToFilebyData(HocSinh[] hocsinh,String filename) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new FileOutputStream(filename));
            dos.writeInt(hocsinh.length);
            for(HocSinh hs : hocsinh){// Duyệt 1 mảng đối tượng
                dos.writeUTF(hs.getMaHS());
                dos.writeUTF(hs.getTenHS());
                dos.writeFloat(hs.getDiem());
                dos.writeUTF(hs.getGhiChu());
            }
            dos.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
 
    //Dùng DataInputStream để đọc File
    public HocSinh[] loadFromFilebyData(String filename) {
        HocSinh[] hocsinh = null;
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new FileInputStream(filename));
            int count = dis.readInt();
            HocSinh[] emps = new HocSinh[count];
            for(int i=0; i<count; i++){
                String mahs = dis.readUTF();
                String tenhs  = dis.readUTF();
                Float diem = dis.readFloat();
                String ghichu = dis.readUTF();
                hocsinh[i] = new HocSinh(mahs, tenhs, diem, ghichu);
            }
            dis.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return hocsinh;
    }
 
    // Lưu theo kiểu đối tượng
    public void saveToFilebyObject(HocSinh[] hocsinh,String filename) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                                        new FileOutputStream(filename));
            oos.writeInt(hocsinh.length);
            for(int i=0; i<hocsinh.length; i++) {
               oos.writeObject(hocsinh[i]);
            }
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    // Đọc theo kiểu đối tượng
    public HocSinh[] loadFromFilebyObject(String filename) {
        HocSinh[] hocsinh = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(
                                        new FileInputStream(filename));
            int count = ois.readInt();
            hocsinh = new HocSinh[count];
            for(int i=0; i<count; i++){
               hocsinh[i] = (HocSinh) ois.readObject();
            }
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace(); // Bắt lỗi hocsinh[i] = (HocSinh)ois.readObject();
        }
        return hocsinh;
    }
 
    //Dùng PrintWriter để ghi vào File
    public void saveToFilebyPrint(HocSinh[] hocsinh,String filename) {
        try {
            PrintWriter pw = new PrintWriter(filename);
            pw.println(hocsinh.length);
            for(HocSinh hs : hocsinh){
                pw.println(hs.getMaHS() + "\t" + hs.getTenHS() + "\t" + hs.getDiem() + "\t" + hs.getGhiChu() + "\t");
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
 
    //Dùng BufferedReader để đọc từ file
    public HocSinh[] loadFromFilebyBuffer(String filename) {
        HocSinh[] hocsinh = null;
        try {
            BufferedReader br = new BufferedReader(
                                    new FileReader(filename));
            int count = Integer.parseInt(br.readLine());
            hocsinh = new HocSinh[count];
            for (int i=0; i<count; i++){
                String[] tempHS = br.readLine().split("\t"); //đọc 1 dòng, gặp ký tự '\t' thì cắt xâu, tạo thành 1 mảng xâu
                hocsinh[i]=new HocSinh(tempHS[0], tempHS[1],Float.parseFloat(tempHS[2]), tempHS[3]);
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
 
        return hocsinh;
    }
}