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
    String INSERT_SQL = "INSERT INTO SANPHAM (MASANPHAM, TENSANPHAM, DONGIA, SOLUONG, MALOAI) VALUES (?, ?, ?, ?, ?)";
    
    DbContext db = new DbContext();
    
    //1.LẤY TOÀN BỘ DỮ LIỆU CỦA BẢNG SẢN PHẨM
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
           conn.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    //2. THÊM DỮ LIỆU CHO BẢNG SẢN PHẨM
    //=> do mình thêm 1 đối tượng sản phẩm => vì vậy tham số truyền sẽ là 1 đối tượng
    public int insert(SanPham sp){
        int rs = 0; // đại diện cho số lượng dòng được add thành công
        try{
            Connection conn = db.getConnection();
            PreparedStatement st = conn.prepareStatement(INSERT_SQL);
            st.setString(1,sp.getMaSanPham());
            st.setString(2, sp.getTenSP());
            st.setDouble(3, sp.getDonGia());
            st.setInt(4, sp.getSoLuong());
            st.setInt(5, sp.getLoaiSanPham().getMaLoai());
            rs= st.executeUpdate();
            conn.close();
        }
        catch( Exception e){
            System.out.println(e);
        }
        return rs;
    }
}
