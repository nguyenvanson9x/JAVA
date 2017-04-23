/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Deparment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author nambh
 */
public class DepartmentDAL extends DataAccessHelper{
    private final String GET_BY_ID = "select * from Department where depID =?";
    private final String GET_ALL = "select * from Department";
    
    public ArrayList<Deparment> getByID(int id){
        ArrayList<Deparment> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                Deparment item = new Deparment();
                item.setDepID(rs.getInt("depID"));
                item.setDepName(rs.getString("depName"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<Deparment> getAll(){
        ArrayList<Deparment> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while (rs.next()) {                    
                    Deparment item = new Deparment();
                    item.setDepID(rs.getInt("DepID"));
                    item.setDepName(rs.getString("DepName"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
   
}
