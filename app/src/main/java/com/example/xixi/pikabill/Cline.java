package com.example.xixi.pikabill;

public class Cline {
    Bill data;
    Cline next;//创建链表类型，用来储存搜索之后的数据
    Cline(){
        data=null;
        next=null;
    }
    Cline(Bill data){
        this.data=data;
        next=null;
    }
}