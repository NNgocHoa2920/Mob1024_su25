/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB05;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author nguye
 */
public class SanPhamDao {
    String SELECT_ALL_SANPHAM = "SELECT * FROM SANPHAM";
    
    DbContext db = new DbContext();
    
    public List<SanPham> getAllSanPham(){
        List<SanPham> list = new ArrayList<>();
        try{
            Connection conn = db.getConnection();
            String sql = SELECT_ALL_SANPHAM;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MASANPHAM"));
                sp.setTenSP(rs.getString("TENSANPHAM"));
                sp.setSoLuong(rs.getInt("SOLUONG"));
                sp.setDonGia(rs.getDouble("DONGIA"));
                int maLoai = rs.getInt("MALOAI");
                LoaiSanPhamDao lspDao = new LoaiSanPhamDao();
                sp.setLoaiSanPham(lspDao.getLoaiSanPhamByMaLoai(maLoai));// truy vấn thêm thông tin loai sản phâm
                list.add(sp);
            }
     
            
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
}
