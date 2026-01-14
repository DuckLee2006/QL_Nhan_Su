
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class QLNS {
    private ArrayList<NhanSu> cty = new ArrayList<>();
    
    public void add(NhanSu nva){
        cty.add(nva);
    }
    
    public void show(){
        if(cty.isEmpty()) System.out.println("danh sach trong.");
        else{
            cty.forEach(a -> a.output());
        }
    }
    
    public void xemLuong(double ngayCong, int index){
        cty.get(index).salary(ngayCong);
    }
}
