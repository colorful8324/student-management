package model;

import java.time.LocalDate;

public class People {
    //    + Id - số dương - không trùng, tự động tăng
//    + Tên - chuỗi < 100 ký tự, không rỗng
//    + Ngày sinh - ngày giờ từ năm 1900, không null
//    + Địa chỉ - chuỗi < 300 kí tự
//    + Chiều cao (đơn vị cm): từ 50.0 - 300.0
//    + Cân nặng (đơn vị kg): từ 5.0 - 1000.0
    private static Integer count = 0;
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private Double height;
    private Double weight;

    public People(String name, LocalDate dateOfBirth, String address, Double height, Double weight) {
        count++;
        this.id = count;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        People.count = count;
    }

    @Override
    public String toString() {
        return "People [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
                + ", height=" + height + ", weight=" + weight + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


}
