package com.example.xixi.pikabill;

public class Tree {
    private static Tree treeLeft;
    private static Tree treeRight;//创建了树的两个分支，声明类型自己本身树，目的是每新建一个分支依旧为树的一个节点
    private static Bill data;

    Tree(){data=null;treeLeft = treeRight = null;  }
    Tree(Bill data){
        this.data = data;//data在这里是树节点（或分支）的值
        treeLeft = treeRight = null;
    }
    public static void add(Tree root,Bill data){
        if (root.data == null)
            root.data=data;
        else{
            if(data.getTime()<=root.data.getTime()){
                if (root.treeLeft==null)
                    treeLeft=new Tree();
                add(treeLeft,data);
            }
            else{
                if(root.treeRight==null)
                    treeRight=new Tree();
                add(treeRight,data);
            }
        }
    }
    //中序遍历，账单生成
    public static void inOrder(Tree root,Cline T){
        if(root == null) return;
        inOrder(root.treeLeft,T);//用递归的方法一直找到树的最左侧
        Cline p=new Cline();
        T.data=root.data;
        p.next=T;
        T=p;
        inOrder(root.treeRight,T);//查找右子树
    }
    //中序遍历，寻找t1-t2之间的数据
    public static void inOrder(Tree root,int t1,int t2,Cline T){
        if(root == null) return;
        if (root.treeLeft.data.getTime()>=t1)
            inOrder(root.treeLeft,t1,t2,T);//用递归的方法找到树的左侧符合条件的数据的界限
        Cline p=new Cline();
        T.data=root.data;
        p.next=T;
        T=p;
        if (root.treeRight.data.getTime()<=t2)
            inOrder(root.treeRight,t1,t2,T); //查找右子树
    }
    //中序遍历，账单按类型生成
    public static void LinOrder(Tree root,String L,Cline T){
        if(root == null) return ;
        LinOrder(root.treeLeft,L,T);//用递归的方法一直找到树的最左侧
        if(root.getdata().getL()==L)
        {
            Cline p=new Cline();
            T.data=root.data;
            p.next=T;
            T=p;
        }
        LinOrder(root.treeRight,L,T);//查找右子树
    }
    public static void setdata(Bill d) {
        data=d;
    }
    public static Bill getdata() {
        return data;
    }
    public static Tree getleft() {
        return treeLeft;
    }
    public static Tree getright() {
        return treeRight;
    }
}
