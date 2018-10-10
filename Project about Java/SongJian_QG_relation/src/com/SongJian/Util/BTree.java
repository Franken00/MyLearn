package com.SongJian.Util;

public class BTree {
	 public  class TreeNode
	{
		String name;
		//TreeNode grandfather;
		TreeNode father;
		TreeNode son;
		TreeNode brother;
		int grade;
		int bro;
		
		public TreeNode(String name, TreeNode father, TreeNode son,TreeNode brother,int grade,int bro) 
		{
	          this.name = name;
	          //this.grandfather = grandfather;
	          this.father = father;
	          this.son = son;
	          this.brother = brother;
	          this.grade = grade;
	          this.bro = bro;
	      }
	    //��ʼ����
		public TreeNode initTree()
		{
			TreeNode t = new TreeNode( null, null, null, null, 0, 0);
			return t;
		}
		//��Ӷ���
		public void addson(String name , TreeNode father)
		{
			TreeNode son = new TreeNode(name , null , null ,null ,father.grade++ ,0);
			father.son = son;
		}
		//��Ӹ���
		public void addfather(String name , TreeNode son)
		{
			TreeNode dad = new TreeNode(name , null , null ,null ,son.grade-- ,0);
			son.father = dad;
		}
		
		//��Ӵ��ֵ�
		public void addbigbro(String name , TreeNode brother)
		{
			TreeNode bbr = new TreeNode(name , null , null ,null ,0 , brother.bro + 1);
			brother.brother = bbr;
		}
		//���С�ֵ�
		public void addlittlebro(String name , TreeNode brother)
		{
			TreeNode bbr = new TreeNode(name , null , null ,null ,0 ,brother.bro - 1);
			brother.brother = bbr;
		}
		//��Ӳ�֪��С���ֵ�
		public void addbro(String name , TreeNode brother)
		{
			TreeNode bbr = new TreeNode(name , null , null ,null ,0 ,0);
			brother.brother = bbr;
		}
		//���үү
		public void addgrandpa(String name , TreeNode grandson)
		{
			TreeNode grandpa = new TreeNode(name , null , null ,null ,grandson.grade-2 ,0);
			grandson.father.father = grandpa;
		}
		//�������
		public void addgrandson(String name , TreeNode grandpa)
		{
			TreeNode grandson = new TreeNode(name , null , null ,null ,grandpa.grade+2 ,0);
			grandpa.son.son = grandson;
		}
		
		
	}
	 

}
