
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        QLNS cty1 = new QLNS();
        Scanner sc = new Scanner(System.in);
        //build chuc nang 
        Map <Integer, Runnable> menu = new HashMap<>();
        menu.put(1, () -> add(cty1, sc));
        menu.put(2, () -> cty1.show());
        menu.put(3, ()-> showSalary(cty1, sc));
        menu.put(0, () -> {
            System.out.println("Exit....");
            System.exit(0);
                });
       //runnable
       while(true){
           menu();
           int choice;
           try{
            choice = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
               System.out.println("error....");
               return;
               }
           if(menu.containsKey(choice)){
               menu.get(choice).run();
                
           }else{
               System.out.println("enter agian pls!");
           }
       }
    }
    
    //checker
    public static boolean MailCheck(String email){
        String ex = "\\w+@covan\\.vn";
        return email.matches(ex);
    }
    public static boolean PhoneCheck (String PhoneNum){
        String ex = "\\d{3}\\.\\d{3}\\.\\d{3}";
        return PhoneNum.matches(ex);
    }
    public static boolean NameCheck (String Name){
        String ex = "^[a-zA-z\\s]+$";
        if (Name.isEmpty()) return false;
        else {
            if(Name.matches(ex)) return true;
            else return false;
        }
        
    }
    //filler 
    public static String setName( String name){
        if (name.isEmpty()) return name;
        name = name.trim();
        String[] word = name.split("\\s+");
        StringBuilder sb = new StringBuilder();
        
        for(String w : word){
            if(!w.isEmpty()){
                sb.append(Character.toUpperCase(w.charAt(0)));
                sb.append(w.substring(1));
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
    //menu
    public static void showSalary(QLNS cty, Scanner sc){
        System.out.println("enter the index of employee.");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Attendant day: ");
        double day = Double.parseDouble(sc.nextLine());
        cty.xemLuong(day, n);
        
    }
//    public static void show(ArrayList<NhanSu> cty){
//        for (NhanSu nva : cty){
//            nva.output();
//        }
//    }
    public static void add(QLNS cty, Scanner sc){
        System.out.println("enter the number of employee.");
        int n = Integer.parseInt(sc.nextLine());
        for(int i =0;i<n;i++){
            NhanSu nvA = new NhanSu();
            InputIn4(nvA);
            cty.add(nvA);
        }
    }
    public static void InputIn4(NhanSu nvA){
        Scanner sc = new Scanner(System.in);
        //nhap thong tin
        //id
        System.out.print("ID :");
        String ID = sc.nextLine();
        
        //name
        String name;
        System.out.print("name: ");
        while(true){
            name = sc.nextLine();
            name = setName(name);
            if(NameCheck(name)) break;
            else System.out.println("Enter angain pls!");
        }
        
        //mail
        System.out.print("Email(....@covan.vn): ");
        String email;
        do{
            email = sc.nextLine();
            if(!MailCheck(email)) System.out.println("enter again pls!");
        }while(!MailCheck(email));
        
        //salary
        System.out.print("Base salary(>=0): ");
        double BaseSalary;
        while(true){
            BaseSalary = Double.parseDouble(sc.nextLine());
            if(BaseSalary >= 0 ) break;
        }
        
        //phone
        System.out.print("Phone number(xxx.xxx.xxx): ");
        String PhoneNum;
        while(true){
            PhoneNum = sc.nextLine();
            if(PhoneCheck(PhoneNum)) break;
            else System.out.println("pls! enter again.");
        }
        
        
        nvA.input(ID, name, email, BaseSalary, PhoneNum);
        
        
    }
    public static void OutputIn4(NhanSu nva){
        nva.output();
    }
    public static void menu(){
        System.out.println("-----MENU-----");
        System.out.println("1. Add employee.");
        System.out.println("2. Employee Ìnormation");
        System.out.println("3. Salary Of Month.");
        System.out.println("0. Exit.");
    }
    public static void MothSalary(double attendentday, NhanSu nva){
        nva.salary(attendentday);
    }
}
