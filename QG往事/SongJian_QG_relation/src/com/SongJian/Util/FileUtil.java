package com.SongJian.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import com.SongJian.Util.Linked.LinkedNode;

public class FileUtil 
{
	private static LinkedNode head;  //ͷ�ڵ�
	private static String name1;
	private static String name2;
	private static String rel;
	private static String result1;   //���1
	private static String result2;   //���
	private static Linked L = new Linked();
	private static String[] name;     //���淵�ص�����
	private static int judge;         //ѡ���ɫ
	private static int fuction;       //ѡ�񷽳�
	
	
	
	//1���½��ļ���FilesSave
	public static File CreatNewFile() {
	File myFilePath = new File("FilesSave\\relation.txt");     //ָ���ļ�·��
	try {   
	    if (!myFilePath.exists()) {   
	        myFilePath.createNewFile();           //�����ļ�
	    }   
	    /*FileWriter resultFile = new FileWriter(myFilePath);   
	    PrintWriter myFile = new PrintWriter(resultFile);   
	    myFile.println("12sss3");   
	    resultFile.close();*/
	    return myFilePath;
	}   
	catch (Exception e) {   
	    System.out.println("�½��ļ���������");   
	    e.printStackTrace();   
		}
	return myFilePath;
	}

	//2����ȡ�ļ�
	public static String readFileByLines(File file,String nameone , String nametwo) {
        //File file = new File(fileName);
		head = new Linked().init(head); 
        BufferedReader reader = null;
        try {
            //System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
            	name = null;
            	NameUtil n = new NameUtil();
        		fuction = n.judgefuction(tempString);//��ȡ��������
        		judge = n.judgewho(tempString);//��ȡ��ɫ       		
        		Linked L = new Linked();
        		Fuction3Util f= new Fuction3Util();
        		int job = f.job(tempString);           	
        		if(line == 1)//��һ�У�Ҫ��ʼ������
            	{          	
            			if(fuction == 1) //��������1
            			{
            				name = n.Name(tempString);
            				if(judge == 1)//�ְ�
            				{
            					LinkedNode father = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            				}
            				if(judge == 2)//үү
            				{
            					LinkedNode grandpa = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					grandpa.grandson = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            				}
            				if(judge == 3)//����
            				{
            					LinkedNode son = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					son.father = frist1;
            					frist1.son = son;
            					L.add(head, frist1);
            					L.add(head, son);  
            				}
            				if(judge == 4)//���
            				{
            					LinkedNode brother = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.bigbro = brother;
            					brother.littbro = frist1;
            					L.add(head, frist1);
            					L.add(head, brother);  
            				}
            				if(judge == 5)//�ܵ�
            				{
            					LinkedNode brother = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					brother.bigbro = frist1;
            					frist1.littbro = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 6)//�ֵ�
            				{
            					LinkedNode brother = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					brother.brother = frist1;
            					frist1.brother = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 7)
            				{
            					LinkedNode teacher = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					teacher.stu = frist1;
            					frist1.teacher = teacher;
            					L.add(head, frist1);
            					L.add(head, teacher);
            				}
            				if(judge == 8)
            				{
            					LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode tea = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					tea.stu = stu;
            					stu.teacher = tea;
            					L.add(head, tea);
            					L.add(head, stu);
            				}
            				if(judge == 9)
            				{
            					LinkedNode stu0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode stu1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					stu0.classmates = stu1;
            					stu1.classmates = stu0;
            					L.add(head, stu0);
            					L.add(head, stu1);
            				}
            				if(judge == 10)
            				{
            					LinkedNode sunzi = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode yeye = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					sunzi.grandpa = yeye;
            					L.add(head, sunzi);
            					L.add(head, yeye);
            				}
            				
            			}
            			if(fuction == 2) //��������2
            			{
            				name = n.Name(tempString);
            				if(judge == 1)//�ְ�
            				{
            					LinkedNode father = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            				}
            				if(judge == 2)//үү
            				{
            					LinkedNode grandpa = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					grandpa.grandson = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            				}
            				if(judge == 3)//����
            				{
            					LinkedNode son = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					son.father = frist1;
            					frist1.son = son;
            					L.add(head, frist1);
            					L.add(head, son);  
            				}
            				if(judge == 4)//���
            				{
            					LinkedNode brother = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.bigbro = brother;
            					brother.littbro = frist1;
            					L.add(head, frist1);
            					L.add(head, brother);  
            				}
            				if(judge == 5)//�ܵ�
            				{
            					LinkedNode brother = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					brother.bigbro = frist1;
            					frist1.littbro = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 6)//�ֵ�
            				{
            					LinkedNode brother = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					brother.brother = frist1;
            					frist1.brother = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 7)
            				{
            					LinkedNode teacher = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					teacher.stu = frist1;
            					frist1.teacher = teacher;
            					L.add(head, frist1);
            					L.add(head, teacher);
            				}
            				if(judge == 8)
            				{
            					LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode tea = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					tea.stu = stu;
            					stu.teacher = tea;
            					L.add(head, tea);
            					L.add(head, stu);
            				}
            				if(judge == 9)
            				{
            					LinkedNode stu0 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode stu1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					stu0.classmates = stu1;
            					stu1.classmates = stu0;
            					L.add(head, stu0);
            					L.add(head, stu1);
            				}
            				if(judge == 10)
            				{
            					LinkedNode sunzi = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode yeye = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					sunzi.grandpa = yeye;
            					L.add(head, sunzi);
            					L.add(head, yeye);
            				}
            				
            			}
            			if(fuction == 3)
            			{
            				name = n.Name(tempString);
            				if(job == 1)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k1.brother =k0;
            					//k1.brother = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1�ְֺͰְ�");
            				}
            				if(job == 2)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k0.son =k1;
            					k1.father = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1�ְֺ�үү");
            				}
            				if(job == 3)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k0.grandpa = k1;
            					k1.grandson = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1�ְֺͶ���");
            				}
            				if(job == 4)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.grandson = k2;
            					k2.grandpa = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1�ְֺ�����");
            				}
            				if(job == 5)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.bigbro = k2;
            					k2.littbro = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1�ְֺ͸��");          					
            				}
            				if(job == 6)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.littbro = k2;
            					k2.bigbro = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1�ְֺ͵ܵ�");
            				}
            				if(job == 7)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.stu = k2;
            					k2.teacher = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1�ְֺ�ѧ��");
            				}
            				if(job == 8) 
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.teacher = k2;
            					k2.stu = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1�ְֺ���ʦ");
            				}
            				if(job == 9)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.classmates = k2;
            					k2.classmates = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1�ְֺ�ͬѧ");
            				}
            				if(job == 10)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.brother = k2;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1�ְֺ��ֵ�");
            				}
            				if(job == 11)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k0.grandson = k1;
            					k1.grandpa = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1���ӺͰְ�");
            				}
            				if(job == 12)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode k2 = new LinkedNode("unknown",null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k2);
            					L.add(head, k0);
            					L.add(head, k1);
            					k0.son = k2;
            					k2.father = k0;
            					k1.grandpa = k2;
            					k2.grandson = k1;
            					System.out.println("1���Ӻ�үү");
            				}
            				if(job == 13)
            				{
            					JOptionPane.showMessageDialog(null,"�����ϵ����(���Ӷ�Ӧ����ְ�)�������ļ���");	
            				}
            				if(job == 14)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k1);
            					L.add(head, k0);
            					k0.father = k1;
            					k1.son = k0;
            					System.out.println("1���Ӻ�����");
            				}
            				if(job == 15)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode k2 = new LinkedNode("unknown",null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k2);
            					L.add(head, k0);
            					L.add(head, k1);
            					k0.son = k2;
            					k2.father = k0;
            					k1.bigbro = k2;
            					k2.littbro = k1;
            					System.out.println("1���Ӻ͸��");
            				}
            				if(job == 16)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode k2 = new LinkedNode("unknown",null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k2);
            					L.add(head, k0);
            					L.add(head, k1);
            					k0.son = k2;
            					k2.father = k0;
            					k1.littbro = k2;
            					k2.bigbro = k1;
            					System.out.println("1���Ӻ͵ܵ�");
            				}
            				if(job == 17)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.son = k2;
            					k2.father = k0;
            					k1.stu = k2;
            					k2.teacher = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1���Ӻ�ѧ��");
            				}
            				if(job == 18)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//�����߱�ʾδ֪���ֵ���
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.son = k2;
            					k2.father = k0;
            					k1.teacher = k2;
            					k2.stu = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1���Ӻ���ʦ");
            				}
            				else
            				{
            					System.out.println("wrong!");
            				}
            				
            			}
            	}
            	
            	//��ȥ��һ�У��Ͳ��ó�ʼ����
            	else
            	{
            		if(fuction == 1) //��������1
        			{
            			name = n.Name(tempString);
        				if(judge == 1)//�ְ�
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       	
        						if(L.isExist(head, name[1]).father.name.equals("unknown"))//�ְ���������
        						{
        							L.isExist(head, name[1]).father.name = name[0];
        						}
        						else if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
        						L.isExist(head, name[1]).father = L.isExist(head, name[0]);
        						System.out.println("��������������");
        					}
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//�ְ��Ѿ�����
        					{
        						if(L.isExist(head, name[1]).father.name.equals("unknown"))//�ְ���������
        						{
        							L.isExist(head, name[1]).father.name = name[0];
        						}
        						else
        						{
        							LinkedNode frist1 = new LinkedNode(name[1],null,null,null,null, null, null, null, null, null, null, null);
            						frist1.father = L.isExist(head, name[0]);
            						L.add(head, frist1);
            						System.out.println("�ְ��Ѿ�����");
        						}
        						
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
        					{
        						LinkedNode father = new LinkedNode(name[0],null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            					System.out.println("������û��");
        					}  
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)
        					{
        						while(L.isExist(head, name[1]).brother != null)
        						{
        							if(L.isExist(head, name[1]).brother.father != null)
        							{
        								JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        							}
        							L.isExist(head, name[1]).brother = L.isExist(head, name[1]).brother.brother;
        						}
        						if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
        						else
        						{
        							LinkedNode father = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[1]).father = father;
            						//father.son = L.isExist(head, name[1]);
            						L.add(head, father);
            						System.out.println("�����Ѿ�����");
        						}       						
        					}
        				}
        				if(judge == 2)//үү
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       		
        						if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						L.isExist(head, name[1]).grandpa = L.isExist(head, name[0]);
        						System.out.println("����������");
        					}
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//үү�Ѿ�����
        					{
        						LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
        						frist1.grandpa = L.isExist(head, name[0]);
        						L.add(head, frist1);
        						System.out.println("үү�Ѿ�����");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("������û��");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
        					{
        						if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						else
        						{
        							LinkedNode grandpa = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[1]).grandpa = grandpa;
            						//grandpa.grandson = L.isExist(head, name[1]);
            						L.add(head, grandpa);
            						System.out.println("�����Ѿ�����");
        						}				
        					}
        				}
        				if(judge == 3)//����
            			{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{
        						if(L.isExist(head, name[1]).son != null)
        						{
        							if(L.isExist(head, name[1]).son.name.equals("unknown"))
        							{
        								L.isExist(head, name[1]).son.name = name[0];
        							}
        						}
        						else if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
        						else
        						{
        							L.isExist(head, name[0]).father = L.isExist(head, name[1]);
            						System.out.println("����������");
        						}			
        					}
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//�����Ѿ�����
            				{
            					if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
            					else
            					{
            						LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            						frist1.son = L.isExist(head, name[0]);
            						L.add(head, frist1);
            						System.out.println("�����Ѿ�����");
            					}           					
            				}
            				else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
            				{
            					LinkedNode son = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				//frist1.son = son;
                				frist1.son = son; 
                				L.add(head, frist1);
                				L.add(head, son);  
                				System.out.println("������û��");
            				}
            				else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
            				{
            					if(L.isExist(head, name[1]).son != null)
        						{
        							if(L.isExist(head, name[1]).son.name.equals("unknown"))
        							{
        								L.isExist(head, name[1]).son.name = name[0];
        							}
        						}
            					else
            					{
            						LinkedNode son = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                					son.father = L.isExist(head, name[1]);
                					L.add(head, son);
                					System.out.println("�ְ��Ѿ�����");
            					}
            				}
            			}
            			if(judge == 4)//���
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       		
        						System.out.println("����������");
        						if(L.isExist(head, name[0]).bigbro == L.isExist(head, name[1]) || L.isExist(head, name[1]).littbro == L.isExist(head, name[0])) {
        							JOptionPane.showMessageDialog(null,"�����ϵ(���ܵ�)ì�ܣ������ļ���");
            						break;//���������Ļ���ѭ��
        						}
            					if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro == null)
            					{
            						L.isExist(head, name[0]).littbro =L.isExist(head, name[1]);
            					}
            					if(L.isExist(head, name[1]).bigbro == null && L.isExist(head, name[0]).littbro != null)
            					{
            						L.isExist(head, name[1]).bigbro =L.isExist(head, name[0]);
            					}
            					if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro != null)
            					{
            						LinkedNode bro = L.isExist(head, name[0]).littbro;
            						while(bro != null)
            						{
            							bro = bro.littbro;
            						}
            						bro = L.isExist(head, name[1]);
            					}
            					else
            					{
            						L.isExist(head, name[1]).bigbro =L.isExist(head, name[0]);
            					}						
        					}
            				
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//����Ѿ�����
                			{
                				LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				frist1.bigbro = L.isExist(head, name[0]);
                				L.add(head, frist1);
                				System.out.println("����Ѿ�����");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
                			{
                				LinkedNode bigbro = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.bigbro = bigbro; 
                    			L.add(head, frist1);
                    			L.add(head, bigbro);  
                    			System.out.println("������û��");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode litt = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				litt.littbro = L.isExist(head, name[1]);
                				L.add(head, litt);
                				System.out.println("�ܵ��Ѿ�����");
                			}
                		}
            			if(judge == 5)//�ܵ�
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{     
            					System.out.println("����������");
            					if(L.isExist(head, name[0]).littbro == L.isExist(head, name[1]) || L.isExist(head, name[1]).bigbro == L.isExist(head, name[0]))
            					{
            						JOptionPane.showMessageDialog(null,"�����ϵ(���ܵ�)ì�ܣ������ļ���");
            						break;//���������Ļ���ѭ��
            					}
        						if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro == null)
        						{
        							L.isExist(head, name[1]).littbro = L.isExist(head, name[0]);
        						}
        						if(L.isExist(head, name[0]).bigbro == null && L.isExist(head, name[1]).littbro != null)
        						{
        							L.isExist(head, name[0]).bigbro = L.isExist(head, name[1]);
        						}
        						if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro != null)
        						{
        							LinkedNode bro = L.isExist(head, name[0]).bigbro;
        							while(bro != null)
        							{
        								bro = bro.bigbro;
        							}
        							bro = L.isExist(head, name[1]);
        						}
        						else
        						{
        							L.isExist(head, name[0]).bigbro = L.isExist(head, name[1]);
        						}
        					}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//�ܵ��Ѿ�����
                			{
                				LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.littbro = L.isExist(head, name[0]);
                				L.add(head, frist1);
                				System.out.println("�ܵ��Ѿ�����");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
                			{
                				LinkedNode litt = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.littbro = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("������û��");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).bigbro = bigbro;
                				L.add(head, bigbro);
                				System.out.println("�ܵ��Ѿ�����");
                			}
                		}
            			if(judge == 6)//�ֵ�
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{      
            					System.out.println("����������");
        						if(L.isExist(head, name[0]).brother != null && L.isExist(head, name[1]).brother == null)
        						{
        							L.isExist(head, name[1]).brother = L.isExist(head, name[0]);
        							//System.out.println("11");
        						}
        						else if(L.isExist(head, name[0]).brother == null && L.isExist(head, name[1]).brother != null)
        						{
        							L.isExist(head, name[0]).brother = L.isExist(head, name[1]);
        							//System.out.println("22");
        						}
        						else if(L.isExist(head, name[0]).brother != null && L.isExist(head, name[1]).brother != null)
        						{
        							LinkedNode bro = L.isExist(head, name[0]).brother;
        							//System.out.println("33");
        							while(bro != null)
        							{
        								bro = bro.brother;
        							}
        							bro = L.isExist(head, name[1]);
        						}
        						else
        						{
        							L.isExist(head, name[1]).brother = L.isExist(head, name[0]);
        							//System.out.println("44");
        						}
        						
        					}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//�ֵ�0�Ѿ�����
                			{
                				LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.brother = L.isExist(head, name[0]);
                				L.add(head, frist1);
                				System.out.println("�ֵ�0�Ѿ�����");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
                			{
                				LinkedNode litt = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.brother = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("������û��");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).brother = bigbro;
                				L.add(head, bigbro);
                				System.out.println("�ֵ�1�Ѿ�����");
                			}                			
                		}
            			if(judge == 7)//��ʦ
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       
            					System.out.println("����������");
        						if(L.isExist(head, name[0]).stu != null && L.isExist(head, name[1]).teacher == null)
        						{
        							L.isExist(head, name[1]).teacher = L.isExist(head, name[0]);//ѧ��ָ��ʦ
        						}
        						if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu == null)
        						{
        							L.isExist(head, name[0]).stu = L.isExist(head, name[1]);//��ʦֵָѧ��
        						}
        						if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu != null)
        						{
        							LinkedNode classm = L.isExist(head, name[1]).classmates;
        							while(classm != null)//�ҵ��յ�ͬѧ
        							{
        								classm = classm.classmates;
        							}
        							classm = L.isExist(head, name[0]).stu;//ѧ��ָ��ʦ��ѧ��
        						}
        						else
        						{
        							L.isExist(head, name[0]).stu = L.isExist(head, name[1]);
        						}
        						System.out.println("����������");
        					}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//��ʦ�Ѿ�����
                			{
                				LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				stu.teacher = L.isExist(head, name[0]);
                				L.add(head, stu);
                				System.out.println("��ʦ�Ѿ�����");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
                			{
                				LinkedNode tea = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("������û��");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode tea = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).teacher = tea;
                				L.add(head, tea);
                				System.out.println("ѧ���Ѿ�����");
                			}                			
                		}
            			if(judge == 8)//ѧ��
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//��������
            				{
            					System.out.println("����������");
            					if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu == null)
        						{
        							L.isExist(head, name[1]).stu = L.isExist(head, name[0]);//��ʦָѧ��
        						}
            					if(L.isExist(head, name[0]).teacher == null && L.isExist(head, name[1]).stu != null)
        						{
        							L.isExist(head, name[0]).teacher = L.isExist(head, name[1]);//ѧ��ָ��ʦ
        						}
            					if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu != null)
        						{
            						//ѧ��ָ��ʦ��ѧ��
            						LinkedNode classm = L.isExist(head, name[0]).classmates;
            						while(classm != null)
            						{
            							classm = classm.classmates;
            						}
        							classm = L.isExist(head, name[0]).stu;
        						}
            					else
            					{
            						L.isExist(head, name[0]).teacher = L.isExist(head, name[1]);
            					}
            				}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//ѧ���Ѿ�����
                			{
                				LinkedNode tea = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				tea.stu = L.isExist(head, name[0]);
                				L.add(head, tea);
                				System.out.println("ѧ���Ѿ�����");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
                			{
                				LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode tea = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("������û��");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode stu = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).stu = stu;
                				L.add(head, stu);
                				System.out.println("��ʦ�Ѿ�����");
                			}                			
                		}
            			if(judge == 9)//ͬѧ
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)
            				{
            					System.out.println("����������");
            					//ͬѧ0��ͬѧָ��ͬѧ1
            					LinkedNode classm = L.isExist(head, name[0]).classmates;
            					while(classm != null)
            					{
            						classm = classm.classmates;
            					}
            					classm = L.isExist(head, name[1]);
            				}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//ͬѧ0�Ѿ�����
                			{
                				LinkedNode stu1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				stu1.classmates = L.isExist(head, name[0]);
                				L.add(head, stu1);
                				System.out.println("ͬѧ0�Ѿ�����");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
                			{
                				LinkedNode stu0 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			stu1.classmates = stu0;
                    			stu0.classmates = stu1; 
                    			L.add(head, stu1);
                    			L.add(head, stu0);  
                    			System.out.println("������û��");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode stu0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).classmates = stu0;
                				L.add(head, stu0);
                				System.out.println("ͬѧ1�Ѿ�����");
                			}                			
                		}
            			if(judge == 10)//����
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       		
        						if(L.isExist(head, name[0]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						L.isExist(head, name[0]).grandpa = L.isExist(head, name[1]);
        						System.out.println("����������");
        					}
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//�����Ѿ�����
        					{
        						LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
        						L.isExist(head, name[0]).grandpa = frist1;
        						L.add(head, frist1);
        						System.out.println("�����Ѿ�����");
        					}
        					else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//������û��
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("������û��");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
        					{
        						/*if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						else
        						{*/
        							LinkedNode grandson = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            						grandson.grandpa = L.isExist(head, name[1]);
            						L.add(head, grandson);
            						System.out.println("үү�Ѿ�����");
        						//}				
        					}
        				}
        			}//����1
            		if(fuction == 2)
            		{
            			name = n.Name(tempString);
            			if(judge == 1)//�ְ�
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{ 
        						if(L.isExist(head, name[0]).father.name.equals("unknown"))//����ְִ��ڵ�����δ֪��
        						{
        							L.isExist(head, name[0]).father.name = name[1];
        							System.out.println("unkown�ְ�");
        						}
        						else if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
        						L.isExist(head, name[0]).father = L.isExist(head, name[1]);
        						System.out.println("��������������2");
        					}
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//�ְ��Ѿ�����
        					{
        						if(L.isExist(head, name[0]).father.name.equals("unknown"))//����ְִ��ڵ�����δ֪��
        						{
        							L.isExist(head, name[0]).father.name = L.isExist(head, name[1]).name;
        						}
        						else
        						{
        							LinkedNode frist1 = new LinkedNode(name[0],null,null,null,null, null, null, null, null, null, null, null);
            						frist1.father = L.isExist(head, name[1]);
            						L.add(head, frist1);
        						}  					
        						System.out.println("�ְ��Ѿ�����2");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
        					{
        						LinkedNode father = new LinkedNode(name[1],null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            					System.out.println("������û��2");
        					}  
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)
        					{
        					
        						while(L.isExist(head, name[0]).brother != null)
        						{
        							if(L.isExist(head, name[0]).brother.father != null)
        							{
        								JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        							}
        							L.isExist(head, name[0]).brother = L.isExist(head, name[0]).brother.brother;
        						}
        						if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
        						else
        						{
        							LinkedNode father = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[0]).father = father;
            						father.son = L.isExist(head, name[0]);
            						L.add(head, father);
            						System.out.println("�����Ѿ�����2");
        						}       						
        					}
        				}
            			if(judge == 2)//үү
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       		
        						if(L.isExist(head, name[0]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						L.isExist(head, name[0]).grandpa = L.isExist(head, name[1]);
        						System.out.println("����������2");
        					}
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//үү�Ѿ�����
        					{
        						LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
        						frist1.grandpa = L.isExist(head, name[1]);
        						L.add(head, frist1);
        						System.out.println("үү�Ѿ�����2");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("������û��2");
        					}
        					else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
        					{
        						if(L.isExist(head, name[0]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						else
        						{
        							LinkedNode grandpa = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[0]).grandpa = grandpa;
            						L.add(head, grandpa);
            						System.out.println("�����Ѿ�����2");
        						}				
        					}
        				}
            			if(judge == 3)//����
            			{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{    
        						if(L.isExist(head, name[0]).son!= null)
            					{
            						if(L.isExist(head, name[0]).son.name.equals("unknown"))
            						{
            							L.isExist(head, name[0]).son.name = name[1];
            						}
            					}
        						else if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
        						else
        						{
        							L.isExist(head, name[1]).father = L.isExist(head, name[0]);
            						System.out.println("����������2");
        						}			
        					}
            				if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//�����Ѿ�����
            				{
            					if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(����)ì�ܣ������ļ���");
        						}
            					else
            					{
            						LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            						frist1.son = L.isExist(head, name[1]);
            						L.add(head, frist1);
            						System.out.println("�����Ѿ�����2");
            					}           					
            				}
            				else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
            				{
            					LinkedNode son = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				//frist1.son = son;
                				frist1.son = son; 
                				L.add(head, frist1);
                				L.add(head, son);  
                				System.out.println("������û��2");
            				}
            				else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
            				{
            					if(L.isExist(head, name[0]).son!= null)
            					{
            						if(L.isExist(head, name[0]).son.name.equals("unknown"))
            						{
            							L.isExist(head, name[0]).son.name = name[1];
            						}
            					}
            					else
            					{
            						LinkedNode son = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                					son.father = L.isExist(head, name[0]);
                					//L.isExist(head, name[0]).son = son;
                					L.add(head, son);
                					System.out.println("�ְ��Ѿ�����2");
                				}           					
            				}
            			}
            			if(judge == 4)//���
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       		
        						System.out.println("����������2");
            					if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro == null)
            					{
            						L.isExist(head, name[1]).littbro =L.isExist(head, name[0]);
            					}
            					if(L.isExist(head, name[0]).bigbro == null && L.isExist(head, name[1]).littbro != null)
            					{
            						L.isExist(head, name[0]).bigbro =L.isExist(head, name[1]);
            					}
            					if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro != null)
            					{
            						LinkedNode bro = L.isExist(head, name[1]).littbro;
            						while(bro != null)
            						{
            							bro = bro.littbro;
            						}
            						bro = L.isExist(head, name[0]);
            					}
            					else
            					{
            						L.isExist(head, name[0]).bigbro =L.isExist(head, name[1]);
            					}						
        					}
            				
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//����Ѿ�����
                			{
                				LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				frist1.bigbro = L.isExist(head, name[1]);
                				L.add(head, frist1);
                				System.out.println("����Ѿ�����2");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
                			{
                				LinkedNode bigbro = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.bigbro = bigbro; 
                    			L.add(head, frist1);
                    			L.add(head, bigbro);  
                    			System.out.println("������û��2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode litt = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				litt.littbro = L.isExist(head, name[0]);
                				L.isExist(head, name[0]).bigbro = litt;
                				L.add(head, litt);
                				System.out.println("�ܵ��Ѿ�����2");
                			}
                		}
            			if(judge == 5)//�ܵ�
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{     
            					System.out.println("����������2");
        						if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro == null)
        						{
        							L.isExist(head, name[0]).littbro = L.isExist(head, name[1]);
        						}
        						if(L.isExist(head, name[1]).bigbro == null && L.isExist(head, name[0]).littbro != null)
        						{
        							L.isExist(head, name[1]).bigbro = L.isExist(head, name[0]);
        						}
        						if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro != null)
        						{
        							LinkedNode bro = L.isExist(head, name[1]).bigbro;
        							while(bro != null)
        							{
        								bro = bro.bigbro;
        							}
        							bro = L.isExist(head, name[0]);
        						}
        						else
        						{
        							L.isExist(head, name[1]).bigbro = L.isExist(head, name[0]);
        						}
        					}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//�ܵ��Ѿ�����
                			{
                				LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.littbro = L.isExist(head, name[1]);
                				L.add(head, frist1);
                				System.out.println("�ܵ��Ѿ�����2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//������û��
                			{
                				LinkedNode litt = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.littbro = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("������û��2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				bigbro.bigbro = L.isExist(head, name[0]);
                				L.isExist(head, name[0]).littbro = bigbro;
                				L.add(head, bigbro);
                				System.out.println("����Ѿ�����2");
                			}
                		}
            			if(judge == 6)//�ֵ�
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{      
            					System.out.println("����������2");
        						if(L.isExist(head, name[1]).brother != null && L.isExist(head, name[0]).brother == null)
        						{
        							L.isExist(head, name[0]).brother = L.isExist(head, name[1]);
        							//System.out.println("11");
        						}
        						else if(L.isExist(head, name[1]).brother == null && L.isExist(head, name[0]).brother != null)
        						{
        							L.isExist(head, name[1]).brother = L.isExist(head, name[0]);
        							//System.out.println("22");
        						}
        						else if(L.isExist(head, name[1]).brother != null && L.isExist(head, name[0]).brother != null)
        						{
        							LinkedNode bro = L.isExist(head, name[1]).brother;
        							//System.out.println("33");
        							while(bro != null)
        							{
        								bro = bro.brother;
        							}
        							bro = L.isExist(head, name[0]);
        						}
        						else
        						{
        							L.isExist(head, name[0]).brother = L.isExist(head, name[1]);
        							//System.out.println("44");
        						}
        						
        					}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//�ֵ�0�Ѿ�����
                			{
                				LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.brother = L.isExist(head, name[1]);
                				L.add(head, frist1);
                				System.out.println("�ֵ�0�Ѿ�����2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//������û��
                			{
                				LinkedNode litt = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.brother = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("������û��2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).brother = bigbro;
                				L.add(head, bigbro);
                				System.out.println("�ֵ�1�Ѿ�����2");
                			}                			
                		}
            			if(judge == 7)//��ʦ
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       
            					System.out.println("����������2");
        						if(L.isExist(head, name[1]).stu != null && L.isExist(head, name[0]).teacher == null)
        						{
        							L.isExist(head, name[0]).teacher = L.isExist(head, name[1]);//ѧ��ָ��ʦ
        						}
        						if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu == null)
        						{
        							L.isExist(head, name[1]).stu = L.isExist(head, name[0]);//��ʦֵָѧ��
        						}
        						if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu != null)
        						{
        							LinkedNode classm = L.isExist(head, name[0]).classmates;
        							while(classm != null)//�ҵ��յ�ͬѧ
        							{
        								classm = classm.classmates;
        							}
        							classm = L.isExist(head, name[1]).stu;//ѧ��ָ��ʦ��ѧ��
        						}
        						else
        						{
        							L.isExist(head, name[1]).stu = L.isExist(head, name[0]);
        						}
        						System.out.println("����������2");
        					}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//��ʦ�Ѿ�����
                			{
                				LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				stu.teacher = L.isExist(head, name[1]);
                				L.add(head, stu);
                				System.out.println("��ʦ�Ѿ�����2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//������û��
                			{
                				LinkedNode tea = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("������û��2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode tea = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).teacher = tea;
                				L.add(head, tea);
                				System.out.println("ѧ���Ѿ�����2");
                			}                			
                		}
            			if(judge == 8)//ѧ��
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//��������
            				{
            					
            					
            					System.out.println("����������2");
            					if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu == null)
        						{
        							L.isExist(head, name[0]).stu = L.isExist(head, name[1]);//��ʦָѧ��
        						}
            					if(L.isExist(head, name[1]).teacher == null && L.isExist(head, name[0]).stu != null)
        						{
        							L.isExist(head, name[1]).teacher = L.isExist(head, name[0]);//ѧ��ָ��ʦ
        						}
            					if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu != null)
        						{
            						//ѧ��ָ��ʦ��ѧ��
            						LinkedNode classm = L.isExist(head, name[1]).classmates;
            						while(classm != null)
            						{
            							classm = classm.classmates;
            						}
        							classm = L.isExist(head, name[1]).stu;
        						}
            					else
            					{
            						L.isExist(head, name[1]).teacher = L.isExist(head, name[0]);
            					}
            				}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//ѧ���Ѿ�����
                			{
                				LinkedNode tea = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				tea.stu = L.isExist(head, name[1]);
                				L.add(head, tea);
                				System.out.println("ѧ���Ѿ�����2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//������û��
                			{
                				LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode tea = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("������û��2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode stu = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).stu = stu;
                				L.add(head, stu);
                				System.out.println("��ʦ�Ѿ�����2");
                			}                			
                		}
            			if(judge == 9)//ͬѧ
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)
            				{
            					System.out.println("����������2");
            					//ͬѧ0��ͬѧָ��ͬѧ1
            					LinkedNode classm = L.isExist(head, name[1]).classmates;
            					while(classm != null)
            					{
            						classm = classm.classmates;
            					}
            					classm = L.isExist(head, name[0]);
            				}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//ͬѧ0�Ѿ�����
                			{
                				LinkedNode stu1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				stu1.classmates = L.isExist(head, name[1]);
                				L.add(head, stu1);
                				System.out.println("ͬѧ0�Ѿ�����2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//������û��
                			{
                				LinkedNode stu0 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			stu1.classmates = stu0;
                    			stu0.classmates = stu1; 
                    			L.add(head, stu1);
                    			L.add(head, stu0);  
                    			System.out.println("������û��2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode stu0 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).classmates = stu0;
                				L.add(head, stu0);
                				System.out.println("ͬѧ1�Ѿ�����2");
                			}                			
                		}
            			if(judge == 10)//����
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//����������
        					{       		
        						if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						L.isExist(head, name[1]).grandpa = L.isExist(head, name[0]);
        						System.out.println("����������2");
        					}
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//�����Ѿ�����
        					{
        						LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
        						L.isExist(head, name[1]).grandpa = frist1;
        						L.add(head, frist1);
        						System.out.println("�����Ѿ�����2");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//������û��
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("������û��2");
        					}
        					else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
        					{
        						/*if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"�����ϵ(ү��)ì�ܣ������ļ���");
        						}
        						else
        						{*/
        							LinkedNode grandson = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            						grandson.grandpa = L.isExist(head, name[0]);
            						L.add(head, grandson);
            						System.out.println("үү�Ѿ�����2");
        						//}				
        					}
        				}
            		}//����2
            		
        		}
               line++; 
            }
            result1 = L.bianli(head, nameone,nametwo);
            result2 = L.bianli(head, nametwo,nameone);
            System.out.println(nameone);
            System.out.println(nametwo);
            System.out.println(result1);
            System.out.println(result2);
            reader.close();
            head = null;  //һ��Ҫ��head���¸�ֵ��null
            return result1 + "\n" + result2;   
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return result1 + "\n" + result2;
    }
	
	
	//3��д���ļ�
	public void Write(File f, String s) throws IOException
	{
		try {   
		    FileOutputStream fw = new FileOutputStream(f,true);   //��������д���ļ�
		    fw.write(s.getBytes());    //д�����
		    fw.flush();    //�ر���ǰҪ���
		    fw.close();    //�ر���
		} catch (IOException e) {   
		    e.printStackTrace();   
		}   
	}
}
