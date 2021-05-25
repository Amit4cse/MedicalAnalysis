package com.amit.medicalanalysis.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class Users {

    @PrimaryKey
    @ColumnInfo(name = "mobile_no")
    @NonNull
    private String mobile_no;

    @ColumnInfo(name ="name")
    private String name;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "weight")
    private int weight;

    @ColumnInfo(name = "sex")
    private String sex;

    @ColumnInfo(name = "city")
    private String city;

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
