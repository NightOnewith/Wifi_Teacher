package com.zijin.wifi_teacher.common;

/**
 * Created by yin on 2017/4/13.
 */
public class Users {

    /*
    定义学生的构造器，创建学生对象时定义学生的信息。
     */
    private String name;
    private String number;
    private String ip;
    private int image;

    public Users() {
    }

    public Users(String name, String number, String ip, int image) {
        this.name = name;
        this.number = number;
        this.ip = ip;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", ip='" + ip + '\'' +
                ", image=" + image +
                '}';
    }
}
