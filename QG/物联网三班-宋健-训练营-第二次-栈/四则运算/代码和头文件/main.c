#include<stdio.h>
#include<stdlib.h>
#include"operation.h"
#include"operation.c"
#include"windows.h"//���������� 


int main()
{
	char m;
	printf("�������㣬�����������"); 
	scanf("%d",&m);
	do{
		intSelection();
	}while(m != 'q'); 
	return 0;
	system("pause");//��ֹ�������� 
}
