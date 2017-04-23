/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.EmployeesDAL;
import Entity.Employees;
import java.util.ArrayList;


/**
 *
 * @author nambh
 */
public class EmployeesDLL {
    EmployeesDAL dal = new EmployeesDAL();
    public boolean  getLogin(String u,String p){
       return  dal.getLogin(u, p);
    }
    public ArrayList<Employees> getALL(){
        return dal.getALL();
    }
    public boolean AddData(Employees emp){
        return dal.AddData(emp);
    }
   
   public boolean  delete(String u){
       return dal.DeleteData(u);
    }
   public boolean  update(Employees emp)
   {
       return dal.Update(emp);
   }
}
