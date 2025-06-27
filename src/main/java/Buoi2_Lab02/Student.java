/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi2_Lab02;

/**
 *
 * @author nguye
 */
public class Student {
    //1.Khai báo dữ liệu
    public String name;
    public double marks; // điểm
    public String course; //khóa học
    
    //2. Khai báo contructor
    //k có tham số
    public Student() {
    }
    //có tham số
    public Student(String name, double marks, String course) {
        this.name = name;
        this.marks = marks;
        this.course = course;
    }
    //3. getter và setter tuy nhiên với dạng bài này có thể bỏ qua
    //4. Hàm lấy ra học lực 
    public String getGrade(){
        if(this.marks<3){
            return "Kém";
        }
        if(this.marks <5){
            return "Yếu";
        }
        if(this.marks <6.5){
            return "Trung Bình";
        }
        if(this.marks <7.5){
            return "Khá";
        }
        if(this.marks <9){
            return "Giỏi";
        }
        return "Xuất sắc";
    }
    
    //4.Hàm tính thưởng
    //- trả về true => có thưởng
    //trả về false => k có thưởng
    public boolean isBonus(){
        return this.marks >=7.5;
    }
    
}
