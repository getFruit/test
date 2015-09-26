/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

*//**
 *
 * @author User
 *//*

class Weiz implements Serializable{//对象序列化，要实现这个接口
  private static final long serialVersionUID=123L;//序列化版本
  double x;
  public Weiz(double a){
    x=a;
  }
}

public class Test_copy {

    *//**
     * @param args the command line arguments
     *//*
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        List lst=new ArrayList();
        lst.add(new Weiz(1.1));
        lst.add(new Weiz(1.2));
        lst.add(new Weiz(1.3));
        System.out.println("复制前，原始lst：");
        for(int i=0;lst2=new ArrayList(lst);
        //lst2.set(1, new Weiz(2.1));
        lst2.get(0).x=2.1;
        System.out.println("构造函数复制且修改后，新的lst2：");
        for(int i=0;i lst3=deepCopy(lst);
        lst3.get(0).x=3.1;
        System.out.println("对象序列化复制且修改后，新的lst3：");
        for(int i=0;i lst4=deepCopy(lst);
        lst4.get(0).x=4.1;
        System.out.println("对象序列化复制且修改后，新的lst4：");
        for(int i=0;i List deepCopy(List src) throws IOException, ClassNotFoundException {  
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
        ObjectOutputStream out = new ObjectOutputStream(byteOut);  
        out.writeObject(src);  
  
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());  
        ObjectInputStream in = new ObjectInputStream(byteIn);  
        @SuppressWarnings("unchecked")  
        List dest = (List) in.readObject();  
        return dest;  
    }  
      
       //关键代码 执行序列化和反序列化  进行深度拷贝，写法不同而已，作用一样  
       //个人习惯 怎么喜欢怎么来！  
    public List deepCopy2(List src) throws IOException, ClassNotFoundException{             
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();             
        ObjectOutputStream out = new ObjectOutputStream(byteOut);             
        out.writeObject(src);                    
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());             
        ObjectInputStream in =new ObjectInputStream(byteIn);             
        List dest = (List)in.readObject();             
        return dest;         
    }   
}*/