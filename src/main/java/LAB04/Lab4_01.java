/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB04;

/**
 *
 * @author nguye
 */
import java.sql.*;  //đã import tất cả thư viện của sql

public class Lab4_01 {
    public static void main(String[] args) {
        try{
            String userName = "sa";
            String passWord="123456789";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //1.Tạo chuỗi kết nối
            String url = "jdbc:sqlserver://localhost:1433;database=QLSinhVien;encrypt=false;trustServerCertificate=true";
            //2.Tạo đối tượng connection để kết nối
            //Connection sẽ có 2 trạng thái là close và open=> dùng xong nhớ close lại
            Connection con =  DriverManager.getConnection(url,userName,passWord);
            //3.Tạo đối tượng Statment
            Statement stm = con.createStatement(); // dùng để thực thi các câu lênh select, insert, update, delete
            //4.Câu lệnh sql
            String sql ="Select * from Students";
            //5.Thực thi câu lệnh
            ResultSet rs= stm.executeQuery(sql); //Bắt buộc dùng nếu muốn đọc dữ liệu
            //6.Dùng vòng lặp để xuất ra
            while(rs.next())
            {
                System.out.print(rs.getString("MaSV")+ ",");
                System.out.print(rs.getString("Hoten")+ ",");
                System.out.print(rs.getString("Email")+ ",");
                System.out.print(rs.getString("SoDT")+ ",");
                System.out.println(rs.getString("GioiTinh"));
            }
            //7. Xong thì nhớ đóng connection
            con.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
