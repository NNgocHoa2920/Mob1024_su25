/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB05;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class LoaiSanPhamDao {
    //KHI VIẾT CÂU LỆNH SQL LƯU Ý PHẢI VIẾT TÊN BẢNG, TÊN THUỘC TÍNH Y CHANG NHƯ TRONG SQL SERVER
    String SELECT_ALL_LOAISANPHAM = "SELECT * FROM LOAISANPHAM";
    String SELECT_LOAISANPHAM_BY_ID = "SELECT * FROM LOAISANPHAM WHERE MALOAI=?";
    
    //VÌ DÙNG CHUNG NÊN KHAI BÁO Ở TRÊN NÀY
    DbContext db = new DbContext();
     //lấy ra toàn bộ danh sách loại sản phẩm
    public List<LoaiSanPham> getAllLoaiSanPham(){
        //khai báo list loaisanpham
        List<LoaiSanPham> list = new ArrayList();// list này để hiển thị toàn bộ danh sách loại sản phẩm
        try{
            //connect vs csdl thông qua class dbcontext
            Connection conn= db.getConnection();
            String sql = SELECT_ALL_LOAISANPHAM;
            Statement stm = conn.createStatement(); // tạo 1 đối tượng sttament từ kết nối csdl để gửi các câu lệnh sql
            //Thực thi câu lệnh SQL
            ResultSet rs= stm.executeQuery(sql);
            while(rs.next()) // di chuyển đến dòng dữ liệu tiếp theo
            {
                LoaiSanPham lsp = new LoaiSanPham();// lsp là đối tượng mình lấy ra
                lsp.setMaLoai(rs.getInt("maLoai"));// lưu ý get cho đúng tên, đúng key
                lsp.setTenLoai(rs.getString("tenLoai"));
                list.add(lsp); // add đối tượng lsp vào list ban đầu
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return list;
    }
    
    //LẤY LOẠI SẢN PHẨM THEO MA
    public LoaiSanPham getLoaiSanPhamByMaLoai(int maLoai){
        LoaiSanPham loaiSanPham = new LoaiSanPham();// dùng để hiển thị
        try{
            //connect vs csdl thông qua class dbcontext
            Connection conn= db.getConnection();
            String sql = SELECT_LOAISANPHAM_BY_ID;
            //Statement stm = conn.createStatement(); // tạo 1 đối tượng sttament từ kết nối csdl để gửi các câu lệnh sql
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, maLoai);// 1 ở đâu là vị trí của dấu ? trong câu SQL còn maLoai là giá tị sẽ gán vào dấu ?
            //thực thi câu lệnh
            ResultSet rs = stm.executeQuery();
            while(rs.next()) // di chuyển đến dòng dữ liệu tiếp theo
            {
                loaiSanPham.setMaLoai(rs.getInt("maLoai"));// lưu ý get cho đúng tên, đúng key
                loaiSanPham.setTenLoai(rs.getString("tenLoai"));
               
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return loaiSanPham;
    }
        
    }

