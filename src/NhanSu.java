
import java.util.Calendar;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class NhanSu {
    protected String ID;
    protected String name;
    protected String email;
    private double BaseSalary;
    protected String PhoneNum;
    
   public NhanSu(){
       ID = "????";
       name = "???";
       email = "???";
       BaseSalary = 0;
       PhoneNum = "???";
   }
   
   
    public void input(String ID, String name, String email, double BaseSalary,String PhoneNum ){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.BaseSalary = BaseSalary;
        this.PhoneNum = PhoneNum;
    }
    
    public void output(){
        System.out.println("----employee information----");
        System.out.println("ID: "+ ID);
        System.out.println("Full Name: "+ name);
        System.out.println("Email: "+email);
        System.out.printf("Base Salary: %.2f\n", BaseSalary);
    }
    
    
    public void salary(double attendantDay){
       Calendar cal = Calendar.getInstance();
       int month = cal.get(Calendar.MONTH) +1;
       int year = cal.get(Calendar.YEAR);
       double TN = BaseSalary*attendantDay;
       double BHXH = TN*0.12;
       double BHTN = TN*0.05;
       double BHYT = TN*0.07;
       double Thue = ThueTNCT(TN);
       double TNTT = TN - BHXH-BHTN-BHYT;
       double money = TNTT - Thue;
       
        System.out.println("----salary for "+month+"/"+year+"----");
        System.out.println("ID: "+ID);
        System.out.println("Name: "+ name);
        System.out.println("Base Salary: "+ BaseSalary+"/day");
        System.out.println("Email: "+ email);
        System.out.println("---------------------------------------------------");
        System.out.println("Attendant: "+attendantDay);
        System.out.println("Salary: " + TN);
        System.out.println("Social Insurance: "+ BHXH);
        System.out.println("Heath Insurance: "+ BHYT);
        System.out.println("Unemployment Insurance: "+ BHTN);
        System.out.println("Before tax: "+ TNTT);
        System.out.println("Tax : " +Thue);
        System.out.println("Real Income: "+ money);
        System.out.println("---------------------------------------------------");
        
        
       
       
       
    }
    private double ThueTNCT(double luong){
        if(luong >= 30000000) return (4500000*0.1 + 10000000*0.2 + (luong - 30000000)*0.35 );
        else if(luong > 20000000) return (4500000*0.1 + (luong - 20000000)*0.2);
        else if( luong > 15500000) return (luong - 15500000)*0.1;
        else return 0;
    }
}
