package com.example.xixi.pikabill;

public class Bill {
    private String L;
    private String B;
    private double money;
    private int time;
    public String getL() {
        return L;
    }
    public void setL(String L) {
        this.L = L;
    }
    public String getB() {
        return B;
    }
    public void setB(String B) {
        this.B = B;
    }
    public double getMoney(){
        return money;
    }
    public void setMoney(double money){
        this.money=money;
    }
    public int getTime(){
        return time;
    }
    public void setTime(int time){
        this.time=time;
    }
}
