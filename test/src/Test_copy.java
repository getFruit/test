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

class Weiz implements Serializable{//�������л���Ҫʵ������ӿ�
  private static final long serialVersionUID=123L;//���л��汾
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
        System.out.println("����ǰ��ԭʼlst��");
        for(int i=0;lst2=new ArrayList(lst);
        //lst2.set(1, new Weiz(2.1));
        lst2.get(0).x=2.1;
        System.out.println("���캯���������޸ĺ��µ�lst2��");
        for(int i=0;i lst3=deepCopy(lst);
        lst3.get(0).x=3.1;
        System.out.println("�������л��������޸ĺ��µ�lst3��");
        for(int i=0;i lst4=deepCopy(lst);
        lst4.get(0).x=4.1;
        System.out.println("�������л��������޸ĺ��µ�lst4��");
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
      
       //�ؼ����� ִ�����л��ͷ����л�  ������ȿ�����д����ͬ���ѣ�����һ��  
       //����ϰ�� ��ôϲ����ô����  
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