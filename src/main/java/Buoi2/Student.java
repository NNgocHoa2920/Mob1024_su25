/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi2;

/**
 *
 * @author nguye
 */
public class Student {

    //1. Khai báo dữ liệu
    public String name;
    public double marks;
    public String course;
    //2. Khai báo contructor
    public Student() {
    }

    public Student(String name, double marks, String course) {
        this.name = name;
        this.marks = marks;
        this.course = course;
    }
    
//3. Hàm lấy ra học lực
    //getter, setter
    public String getGrade() {
        if (this.marks < 3) {
            return "Kém";
        }
        if (this.marks < 5) {
            return "Yếu";
        }
        if (this.marks < 6.5) {
            return "Trung bình";
        }
        if (this.marks < 7.5) {
            return "Khá";
        }
        if (this.marks < 9) {
            return "Giỏi";
        }
        return "Xuất sắc";
    }
/*4. Hàm tính thưởng
   -Trả về true: có phần thưởng
    - trả về false: k có phần thưởng
    */
   
    public boolean isBonus() {
        return this.marks >= 7.5;
    }

}
