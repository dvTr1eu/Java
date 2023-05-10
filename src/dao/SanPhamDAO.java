/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
/**
 *
 * @author uesr
 */
public class SanPhamDAO {
    connect connect = new connect();
    Connection conn = connect.getConnection();
    PreparedStatement ps =null;
    ResultSet rs = null;
    public List<SanPham> getList(){
        List<SanPham> list = new ArrayList<>();
        String sql = "Select * from SanPham";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                SanPham sanPham = new SanPham();
                sanPham.setMasp(rs.getString("MaSP"));
                sanPham.setTensp(rs.getString("TenSP"));
                sanPham.setDonvitinh(rs.getString("DonViTinh"));
                sanPham.setSoluong(rs.getInt("SoLuong"));                
                list.add(sanPham);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
//    public List<SanPham> getBySearch(String text){
//        String query ="select* from SanPham where TenHG like N'%"+text+"%'";
//        List<SanPham> list = new ArrayList<>(); 
//        try {
//            conn = new connect().getConnection();
//            ps = conn.prepareStatement(query);
////            ps.setString(1, text);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                list.add(new SanPham(rs.getString("MaHG"), 
//                        rs.getString("TenHG"), 
//                        rs.getString("DonViTinh"),
//                        rs.getInt("SoLuong"))
//                );
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
    public boolean them(String Ma, String Ten,String DVT,int Sl){
        String query = "insert into SanPham values(N'"+Ma+"',N'"+Ten+"',N'"+DVT+"',"+Sl+")";
        try {
                ps = conn.prepareStatement(query);
                return ps.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean sua(String Ma, String Ten,String DVT,int Sl){
        String query = "Update SanPham set TenSP = N'"+Ten+"', DonViTinh = N'"+DVT+"',SoLuong = "+Sl+" where MaSP = N'"+Ma+"'";
        try {
            ps = conn.prepareStatement(query);
            return ps.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean xoa(String DelMa){
        String query = "delete from SanPham where MaSP = ?";
            List<SanPham> list = new ArrayList<>(); 
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, DelMa);
            ps.executeUpdate();
            return ps.executeUpdate() >0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
