package com.SongJian.Util;

import javax.swing.JOptionPane;

public class Linked {
	
	static class LinkedNode
	{
		String name;
		LinkedNode father;
		LinkedNode son;
		LinkedNode brother;
		LinkedNode grandpa;
		LinkedNode grandson;
		LinkedNode next;
		LinkedNode bigbro;
		LinkedNode littbro;
		LinkedNode teacher;
		LinkedNode classmates;
		LinkedNode stu;
		public LinkedNode(String name,LinkedNode stu,LinkedNode teacher,LinkedNode classmates,LinkedNode father,LinkedNode son,LinkedNode grandson,LinkedNode brother,LinkedNode grandpa,LinkedNode next,LinkedNode bigbro,LinkedNode littbro)
		{
			this.name = name;
			this.father = father;
			this.son = son;
			this.brother = brother;
			this.grandpa = grandpa;
			this.next = next;
			this.bigbro = bigbro;
			this.littbro = littbro;		
			this.grandson = grandson;
			this.teacher = teacher;
			this.classmates = classmates;
			this.stu = stu;
		}
		
	}
	
	public LinkedNode init(LinkedNode frist)
	{
		LinkedNode head = new LinkedNode("head" ,null,null,null,null,null,null,null,null,null,null,null);
		head.next = frist;
		return head;		
	}
	public void add(LinkedNode head ,  LinkedNode next)
	{
		while(head.next != null)
		{
			head = head.next;
		}
		head.next = next;
		next.next = null;
	}
	public String bianli(LinkedNode head , String name1 ,String name2)//����
	{
		//����˳��
		String ans1 = "*";
		String ans2 = "*";
		String ans3 = "*";
		String ans4 = "*";
		String ans5 = "*";
		String ans6 = "*";
		String ans7 = "*";
		String ans8 = "*";
		String ans9 = "*";
		String ans10 = "*";
		String ans11 = "*";
		String ans12 = "*";
		String ans13 = "*";
		String ans14 = "*";
		String ans15 = "*";
		String ans16 = "*";
		String ans17 = "*";
		LinkedNode name11 = head;
		LinkedNode name22 = head;
		while(name11 != null)//name11�ҵ�name1��λ��
		{
			if(name11.name.equals(name1)) {
				break;
			}
			name11 = name11.next;	
		}
		while(name22 != null)//name22�ҵ�name2��λ��
		{
			if(name22.name.equals(name2))
			{
				break;
			}
			name22 = name22.next;		
		}
		if(name11 == null || name22 == null)
		{
			JOptionPane.showMessageDialog(null,"���ڹ�ϵ�ı���");
			return "����";
		}
		//���׸�磬���׵ܵܣ������ֵ�ѭ��
		if(name11.brother!=null || name11.littbro!=null || name11.bigbro!=null || name11.father != null)
		{
			if((name11.father == name22 && name11.brother == name22) || (name11.father == name22 && name11.littbro == name22) || (name11.father == name22 && name11.bigbro == name22))
			{
				JOptionPane.showMessageDialog(null,"�����ϵ(�ְ����ֵܣ���磬�ܵ�)ì�ܣ������ļ���");	
				return "����";
			}
			else if((name11.father == name22 && name22.bigbro == name11) || (name11.father == name22 && name22.littbro == name11) || (name11.father == name22 && name22.brother == name11))
			{
				JOptionPane.showMessageDialog(null,"�����ϵ(�ְ����ֵܣ���磬�ܵ�)ì�ܣ������ļ���");	
				return "����";
			}
			else if((name11.bigbro == name22 && name22.father == name11) || (name11.littbro == name22 && name22.father == name11) || (name11.brother == name22 && name22.father == name11))
			{
				JOptionPane.showMessageDialog(null,"�����ϵ(�ְ����ֵܣ���磬�ܵ�)ì�ܣ������ļ���");	
				return "����";
			}
		}
		if((name11.father == name22 && name11.grandpa == name22) || (name11.grandpa == name22 && name22.father == name11))
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(�ְ�үү)ì�ܣ������ļ���");
			return "����";
		}
		if(name11.father == name22 && name11.grandson == name22)
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(�ְ�����)ì�ܣ������ļ���");
			return "����";
		}
		if(name11.father == name22 && name11.son == name22)
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(�ְֶ���)ì�ܣ������ļ���");
			return "����";
		}
		if(name11.stu == name22 && name22.stu == name11)  // ѧ��ѭ��
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(ʦ��)ì�ܣ������ļ���");
			return "����";
		}
		if(name11.teacher == name22 && name22.teacher == name11)  //��ʦѭ��
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(ʦ��)ì�ܣ������ļ���");
			return "����";
		}
		//үү
		if(name11.grandpa == name22 && name11.grandson == name22)
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(үү����)ì�ܣ������ļ���");
			return "����";
		}
		if((name11.grandpa == name22 && name11.brother == name22) || (name11.grandpa == name22 && name11.littbro == name22) || (name11.grandpa == name22 && name11.bigbro == name22))
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(үү���ֵܣ���磬�ܵ�)ì�ܣ������ļ���");
			return "����";
		}
		/*if(name11.bigbro == name22 && name11.littbro == name22)
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(�ֵ�)ì�ܣ������ļ���");
			return "����";
		}*/
		if(name11 == name22 && name11 != null && name22 != null) //�Լ����Լ�
		{
			return "�Լ������Լ�����";
		}
		
		if(name11 != null && name22 != null)
		{
			while(name11.littbro != null)
			{
				if(name11.littbro == name22)//�ܵ�
				{
					ans1 = name1+"�ĵܵ���"+name2;
				}
				if(name11.littbro.father == name22)
				{
					ans4 = name1+"�İְ���"+name2;
				}
				if(name11.littbro.grandpa == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
				name11.littbro = name11.littbro.littbro;
			}
			
			while(name11.bigbro != null)
			{
				if(name11.bigbro == name22)//���
				{
					ans2 = name1+"�ĸ����"+name2;
				}
				if(name11.bigbro.father == name22)
				{
					ans4 = name1+"�İְ���"+name2;
				}
				if(name11.bigbro.grandpa == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
				name11.bigbro = name11.bigbro.bigbro;
			}
			while(name11.brother != null)
			{
				if(name11.brother == name22)//���
				{
					ans2 = name1+"���ֵ���"+name2;
				}
				if(name11.brother.father == name22)
				{
					ans4 = name1+"�İְ���"+name2;
				}
				if(name11.brother.grandpa == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
				name11.brother = name11.brother.brother;
			}
			
			if(name11.son == name22)//����
			{
				ans3 = name1+"�Ķ�����"+name2;
			}
			
			
			/*while(name11.brother != null)//�ֵܵİְ� үү��һ����
			{
				System.out.println("a");
				if(name11.brother.father == name22)
				{
					ans4 = name1+"�İְ���"+name2;
				}
				else if(name11.brother.grandpa == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
				name11 = name11.brother;
			}
			while(name11.bigbro != null)
			{
				System.out.println("b");
				if(name11.bigbro.father == name22)
				{
					ans4 = name1+"�İְ���"+name2;
				}
				else if(name11.bigbro.grandpa == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
				name11 = name11.bigbro;
			}
			while(name11.littbro != null)
			{
				System.out.println("c");
				if(name11.littbro.father == name22)
				{
					ans4 = name1+"�İְ���"+name2;
				}
				if(name11.littbro.grandpa == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
				name11 = name11.littbro;
			}*/
			if(name11.grandson != null && name11.grandson.father != null)//үү�����ӵİְ���үү�Ķ���
			{
				if(name11.grandson.father == name22)
				{
					ans4 = name1+"�İְ���"+name2;
				}
			}
			if(name11.father != null && name11.father.father != null )//�ְֵİְ���үү
			{
				if(name11.father.father == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
			}
			if(name11.father == name22)//�ְ�
			{
				ans4 = name1+"�İְ���"+name2;
			}
			if(name11.grandpa == name22)//yeye
			{
				ans5 = name1+"��үү��"+name2;
			}
			if(name11.grandson == name22)//sunzi
			{
				ans6 = name1+"��������"+name2;
			}
			if(name11.brother == name22)//xiongdi
			{
				ans7 = name1+"���ֵ���"+name2;
			}
			if(name11.teacher == name22)
			{
				ans8 = name1 + "����ʦ��" +name2;
			}
			if(name11.stu == name22)
			{
				ans9 = name1 + "��ѧ����" + name2;
			}
			if(name11.classmates == name22)
			{
				ans10 = name1 + "��ͬѧ��" + name2;
			}
			//ͬһ���ְ֣�үү�����ӣ��ֵܶ����ֵ�
			if(name11.father != null && name22.father != null)
			{
				if(name11.father.name == name22.father.name)
				{
					ans11 = name1+"���ֵ���"+name2;
				}
			}
			if(name11.grandpa != null && name22.grandpa != null)
			{
				if(name11.grandpa.name == name22.grandpa.name)
				{
					ans12 = name1+"���ֵ���"+name2;
				}
			}
			if(name11.grandson != null && name22.grandson != null)
			{
				if(name11.grandson.name == name22.grandson.name )
				{
					ans13 = name1+"���ֵ���"+name2;
				}
			}
			if(name11.brother != null && name22.brother != null)
			{
				if(name11.brother.name == name22.brother.name )
				{
					ans14 = name1+"���ֵ���"+name2;
				}
			}
			//ͬһ����ʦ��ѧ�� ,ͬѧ��ͬѧ ��ͬѧ
			if(name11.teacher != null && name22.teacher != null)
			{
				if(name11.teacher.name == name22.teacher.name )
				{
					ans15 = name1+"��ͬѧ��"+name2;
				}
			}
			if(name11.classmates != null && name22.classmates != null)
			{
				if(name11.classmates.name == name22.classmates.name )
				{
					ans16 = name1+"��ͬѧ��"+name2;
				}
			}
			if(name11.grandson != null && name11.son != null ) //үү������  ��   үү�Ķ��ӵ�    ����
			{
				if(name11.grandson.father == name11.son)
				{
					ans4 = name1+"�İְ���"+name2;
				}				
			}
			if(name11.teacher != null && name11.teacher.stu != null)//ѧ������ʦ��ѧ�� �� ͬѧ
			{
				if(name11.teacher.stu == name22)
				{
					ans10 = name1 + "��ͬѧ��" + name2;
				}
			}
			if(name11.father != null && name11.father.grandson != null) //�ְֵ����� �Ƕ���
			{
				if(name11.father.grandson == name22)
				{
					ans3 = name1+"�Ķ�����"+name2;
				}				
			}
			if(name11.father!=null && name11.father.father != null) //�ְֵİְ���үү
			{
				if(name11.father.father == name22)
				{
					ans5 = name1+"��үү��"+name2;
				}
			}
		}
		else
		{
			ans17 = name1+"��"+name2+"û�й�ϵ";	
		}
		if(ans1 !="*" && ans2 != "*")
		{
			JOptionPane.showMessageDialog(null,"�����ϵ(���ܵ�)ì�ܣ������ļ���");
			return "����";
		}
		return ans1+"-*"+ans2+"-*"+ans3+"-*"+ans4+"-*"+ans5+"-*"+ans6+"-*"+ans7+"-*"+ans8+"-*"+ans9+"-*"+ans10+"-*"+ans11+"-*"+ans12+"-*"+ans13+"-*"+ans14+"-*"+ans15+"-*"+ans16+"-*"+ans17;
	}
	
	public LinkedNode isExist(LinkedNode head, String objname)  //���������Ƿ����
	{
		LinkedNode current = head;
		while(current.next != null)
		{
			if(current.name.equals(objname))
			{
				break;
			}
			current = current.next;
		}
		if(current.name.equals("unknown"))
		{
			return current;
		}
		else if(current.name.equals(objname))
		{
			return current;
		}
		else
		{
			return head;
		}
	}

}
