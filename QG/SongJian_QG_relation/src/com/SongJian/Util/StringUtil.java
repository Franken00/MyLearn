package com.SongJian.Util;

public class StringUtil {
	public static boolean isEmpty(String str) //����û�������
	{
		if(null == str || "".equals(str))
		{
			return true;
		}
		else 
			return false;
	}

}
