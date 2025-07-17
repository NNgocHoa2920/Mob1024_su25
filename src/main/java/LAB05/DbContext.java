/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB05;

import java.sql.*;



/**
 *
 * @author nguye
 */
public class DbContext {
    //lưu ý: điền đúng pass
    private static final String userName = "sa";
    private static final String password = "123";
    private static final String url = "jdbc:sqlserver://localhost:1433;database=QLSP_lab05;encrypt=false;trustServerCertificate=true";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, userName, password);
    }
    
    //hàm test xem có kết nối được csdl không
    //ĐI THI K CẦN CAI NÀY, CÔ VIẾT ĐỂ TEST THỬ CHO CÁC BẠN THẤY
    public static void main(String[] args) {
        try{
            Connection conn = getConnection();
            if(conn!=null){
                System.out.println("Kết nối csdl thành công");
                System.out.println("Đang dùng csdl: "+ conn.getCatalog());
                conn.close();
            }
        }
        catch(Exception e){
            System.out.println("Kết nối thất bại"+ e.getMessage());
        }
    }
}