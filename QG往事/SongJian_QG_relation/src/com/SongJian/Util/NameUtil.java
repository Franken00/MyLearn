package com.SongJian.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class NameUtil {
	
	static String[] strcurrent;
	int c = 0;
	private static int count = 0;
	public String[] Name(String str)
	{
		String[] strfinally = {"a","b"};
		if(str.indexOf("��") < 0 || str.indexOf("��") < 0 )
		{
			JOptionPane.showMessageDialog(null,"���зǷ���䣬�����ļ���");
		}
		if(str.indexOf("�ְ�") < 0 && str.indexOf("����") < 0 && str.indexOf("����") < 0 && str.indexOf("үү") < 0 && str.indexOf("���") < 0 && str.indexOf("�ܵ�") < 0 && str.indexOf("�ֵ�") < 0 && str.indexOf("��ʦ") < 0 && str.indexOf("ѧ��") < 0 && str.indexOf("ͬѧ") < 0  )
		{
			JOptionPane.showMessageDialog(null,"���зǷ���䣬�����ļ���");
		}
		else
		{
			strcurrent = str.split("��");			
			for(int i = 0 , len = strcurrent.length ; i < len ; i++)
			{
				String strr[];
				strr = strcurrent[i].split("��");
				for(int k = 0 , lens = strr.length ; k < lens ; k++)
				{
					if(strr[k].equals("�ְ�") || strr[k].equals("����") || strr[k].equals("����") || strr[k].equals("үү") || strr[k].equals("���") || strr[k].equals("�ܵ�") || strr[k].equals("�ֵ�")|| strr[k].equals("��ʦ")|| strr[k].equals("ѧ��")|| strr[k].equals("ͬѧ"))
					{
						continue;
					}
					else
					{
							strfinally[c] = strr[k];
							c++;
							continue;
					}
				}
			}
		}
		return strfinally;
	}
	
				
	
	public int judgewho(String str)
	{
		strcurrent = str.split("��");
		for(int i = 0 , len = strcurrent.length ; i < len ; i++)
		{
			String strr[];
			strr = strcurrent[i].split("��");
			for(int k = 0 , lens = strr.length ; k < lens ; k++)
			{
				if(strr[k].equals("�ְ�"))
				{
					return 1;
				}
				else if(strr[k].equals("үү"))
				{
					return 2;
				}
				else if(strr[k].equals("����"))
				{
					return 3;
				}
				else if(strr[k].equals("���"))
				{
					return 4;
				}
				else if(strr[k].equals("�ܵ�"))
				{
					return 5;
				}
				else if(strr[k].equals("�ֵ�"))
				{
					return 6;
				}
				else if(strr[k].equals("��ʦ"))
				{
					return 7;
				}
				else if(strr[k].equals("ѧ��"))
				{
					return 8;
				}
				else if(strr[k].equals("ͬѧ"))
				{
					return 9;
				}
				else if(strr[k].equals("����"))
				{
					return 10;
				}
			}
		}
		return 10086;
	}
	
	public int judgefuction(String str)//�ж�����
	{
		int de;
		int shi;
		de = str.indexOf("��");
		shi = str.indexOf("��");
		Pattern p = Pattern.compile("��",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);       
        while(m.find()){
              count ++;
        }		
        System.out.println("�� �ĸ�����"+count);
		if(de > shi && count == 1)                  //ģʽ1��<����>��<����>��<��ϵ>
		{
			count = 0;
			return 1;
		}
		else if(de < shi && count == 1)                  //ģʽ2��<����>��<��ϵ>��<����>
		{
			count = 0;
			return 2;
		}
		else if(count == 2)                          //ģʽ3��<����>��<��ϵ>��<����>��<��ϵ>
		{
			count = 0;
			return 3;
		}
		count = 0;
		return 0;
	}
	
	/*public static void main(String args[])
	{
		String str = "С��İְ���С��";
		judgefuction(str);
	}*/
}

