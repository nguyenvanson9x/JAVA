/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DepartmentDAL;
import Entity.Deparment;
import java.util.ArrayList;
/**
 *
 * @author nambh
 */
public class DeparmentDLL {
    DepartmentDAL dal = new DepartmentDAL();
    public ArrayList<Deparment> getByID(int id){
        return dal.getByID(id);
    }
    
    public ArrayList<Deparment> getALl(){
        return dal.getAll();
    }
    
    
  
}
