package com.SongJian.Util;

public class Fuction3Util {
	public int job(String src)
	{
		int father = src.indexOf("�ְ�");
		int grandpa = src.indexOf("үү");
		int grandson = src.indexOf("����");
		int son = src.indexOf("����");
		int bigbrother = src.indexOf("���");
		int littlebrother = src.indexOf("�ܵ�");
		int brother = src.indexOf("�ֵ�");
		int teacher = src.indexOf("��ʦ");
		int student = src.indexOf("ѧ��");
		int classmate = src.indexOf("ͬѧ");
		
		
		//�ְ�
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("�ְ�")>0 && grandpa<0 && grandson<0 && son<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			//System.out.println("�ְֺͰְ�1");
			return 1;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("үү")>0 && grandson<0 && son<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			//System.out.println("�ְֺ�үү");
			return 2;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("����")>0 &&src.indexOf("�ְ�")<src.indexOf("����") && grandpa<0 && grandson<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			//System.out.println("�ְֺͶ���");
			return 3;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("����")>0 )
		{
			//System.out.println("�ְֺ�����");
			return 4;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("���")>0)
		{
			//System.out.println("�ְֺ͸��");
			return 5;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			//System.out.println("�ְֺ͵ܵ�");
			return 6;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("ѧ��")>0)
		{
			//System.out.println("�ְֺ�ѧ��");
			return 7;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("��ʦ")>0)
		{
			//System.out.println("�ְֺ���ʦ");
			return 8;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			//System.out.println("�ְֺ�ͬѧ");
			return 9;
		}
		if(src.indexOf("�ְ�")>0 && src.lastIndexOf("�ֵ�")>0)
		{
			//System.out.println("�ְֺ��ֵ�");
			return 10;
		}
		
		//����
		if(src.indexOf("����")>0 && src.lastIndexOf("�ְ�")>0 && src.indexOf("����")<src.lastIndexOf("�ְ�"))
		{
			return 11;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("үү")>0&& father <0 && grandson<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			return 12;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0 && father <0&& grandpa<0 && grandson<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			return 13;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0 && father <0&& grandpa<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			return 14;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("���")>0)
		{
			return 15;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 16;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 17;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 18;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 19;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0)
		{
			return 20;
		}
		
		
		//үү
		if(src.indexOf("үү")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 31;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("үү")>0)
		{
			return 32;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("����")>0)
		{
			return 33;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("����")>0)
		{
			return 34;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("���")>0)
		{
			return 35;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 36;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 37;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 38;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 39;
		}
		if(src.indexOf("үү")>0 && src.lastIndexOf("����")>0)
		{
			return 40;
		}
		
		//����
		if(src.indexOf("����")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 41;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("үү")>0)
		{
			return 42;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0)
		{
			return 43;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0)
		{
			return 44;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("���")>0)
		{
			return 45;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 46;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 47;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 48;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 49;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0)
		{
			return 50;
		}
		
		//���
		if(src.indexOf("���")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 51;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("үү")>0)
		{
			return 52;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("����")>0)
		{
			return 53;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("����")>0)
		{
			return 54;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("���")>0)
		{
			return 55;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 56;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 57;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 58;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 59;
		}
		if(src.indexOf("���")>0 && src.lastIndexOf("����")>0)
		{
			return 60;
		}
		
		//�ܵ�
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 51;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("үү")>0)
		{
			return 52;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("����")>0)
		{
			return 53;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("����")>0)
		{
			return 54;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("���")>0)
		{
			return 55;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 56;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 57;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 58;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 59;
		}
		if(src.indexOf("�ܵ�")>0 && src.lastIndexOf("����")>0)
		{
			return 60;
		}
		
		
		//�ֵ�
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 61;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("үү")>0)
		{
			return 62;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("����")>0)
		{
			return 63;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("����")>0)
		{
			return 64;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("���")>0)
		{
			return 65;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 66;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 67;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 68;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 69;
		}
		if(src.indexOf("�ֵ�")>0 && src.lastIndexOf("����")>0)
		{
			return 70;
		}
		
		//����
		if(src.indexOf("����")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 71;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("үү")>0)
		{
			return 72;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0)
		{
			return 73;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0)
		{
			return 74;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("���")>0)
		{
			return 75;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 76;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 77;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 78;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 79;
		}
		if(src.indexOf("����")>0 && src.lastIndexOf("����")>0)
		{
			return 80;
		}
		
		//��ʦ
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 81;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("үү")>0)
		{
			return 82;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("����")>0)
		{
			return 83;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("����")>0)
		{
			return 84;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("���")>0)
		{
			return 85;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 86;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 87;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 88;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 89;
		}
		if(src.indexOf("��ʦ")>0 && src.lastIndexOf("����")>0)
		{
			return 90;
		}
		
		//ͬѧ
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("�ְ�")>0)
		{
			return 91;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("үү")>0)
		{
			return 92;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("����")>0)
		{
			return 93;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("����")>0)
		{
			return 94;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("���")>0)
		{
			return 95;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("�ܵ�")>0)
		{
			return 96;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("ѧ��")>0)
		{
			return 97;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("��ʦ")>0)
		{
			return 98;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("ͬѧ")>0)
		{
			return 99;
		}
		if(src.indexOf("ͬѧ")>0 && src.lastIndexOf("����")>0)
		{
			return 100;
		}
		return 0;
	}

}

