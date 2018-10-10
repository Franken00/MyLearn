#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include "MyQUEUE.h"

#define MAXQUEUE 10
#define queue_entry(ptr, type, member) \
        ((type *)((char *)(ptr)-(unsigned long)(&((type *)0)->member)))

int CycleQueue(size_t data_size)    //ѭ������ 
{
	int x;
	AQueue *Q;
	Q = malloc(sizeof(AQueue));    //�����ڴ� 
	printf("��ʼ��һ�����У�\n");
	InitAQueue(Q,data_size);
	
	int length;    //�õ����г��� 
	
	void *data;    //�û��������ӵ�Ԫ�ص�ָ�� 
	
	void (*foo)(void *q,int a);    //���ڱ���ʱʹ�õĺ���ָ�� 
	
	void *e;    //���ڱ���õ���ͷԪ�� 
	
	printf("|***************Caozuo Menue**************|\n");
	printf("|1.���ٶ���                               |\n");
	printf("|2.����                                   |\n");
	printf("|3.���                                   |\n");
	printf("|4.��ն���                               |\n");
	printf("|5.�ж϶����Ƿ�Ϊ��                       |\n");
	printf("|6.�������                               |\n");
	printf("|7.�õ�ͷԪ��                             |\n");
	printf("|8.�õ����г���                           |\n");
	printf("|9.��������                               |\n");
	printf("|*****************************************|\n");
	printf("���룺");
	
	int k;    //���û�����ѡ����� 
	while(1)
	{
    	fflush(stdin);
	    scanf("%d",&k);
	    switch(k)
	    {
	    	case 1:
	    		DestoryAQueue(Q);
	    		break;
	    	case 2:
	    		DeAQueue(Q);
	    		break;
	    	case 3:
	    		printf("������ӵ�Ԫ�أ�");
	    		if(data_size == 1)
	    		{
	    			char ch;
	    			while(1 != scanf("%s",&ch))
	    			{
	    				printf("�����������������\n");
	    				fflush(stdin);
					}
	    			data = &ch;
				}
				else if(data_size == 4) 
				{
					int ih;
					while(1 != scanf("%d",&ih))
	    			{
	    				printf("�����������������\n");
	    				fflush(stdin);
					}
					data = &ih;
				}
				else if(data_size == 8)
				{
					double dh;
					while(1 != scanf("%lf",&dh))
	    			{
	    				printf("�����������������\n");
	    				fflush(stdin);
					}
					data = &dh;
				}
	    		EnAQueue(Q, data);
	    		break;
	    	case 4:
	    		ClearAQueue(Q);
	    		break;
	    	case 5:
	    		IsEmptyAQueue(Q);
	    		break;
	    	case 6:
	    		foo = APrint;
	    		TraverseAQueue(Q, foo);
	    		break;
	    	case 7:
	    		x = GetHeadAQueue(Q, e);
	    		foo = APrint;
	    		TraverseAQueue(Q, foo);
	    		break;
	    	case 8:
	    		length = LengthAQueue(Q);
	    		printf("���г���Ϊ%d \n",length);
	    		break;
	    	case 9:
	    		return 0;
	    		break;
	    	default:
	    		printf("������Ч����������\n");
	    		break;
		}
	    printf("��������Ҫ����: ");
	}
	return 0;
}

int LinkQueue(size_t data_size)    //��ʽ���� 
{
	int x;
	LQueue *Q;
	Q = malloc(sizeof(LQueue));    //�����ڴ� 
	printf("�õģ������ȳ�ʼ��һ�����У�\n");
	InitLQueue(Q,data_size);
	
	int length;    //�õ����г��� 
	
	void *data;    //�û��������ӵ�Ԫ�ص�ָ�� 
	
	void (*foo)(void *q,int a);    //���ڱ���ʱʹ�õĺ���ָ�� 
	
	void *e;    //���ڱ���õ���ͷԪ�� 
	
	printf("|***************Caozuo Menue**************|\n");
	printf("|1.���ٶ���                               |\n");
	printf("|2.����                                   |\n");
	printf("|3.���                                   |\n");
	printf("|4.��ն���                               |\n");
	printf("|5.�ж϶����Ƿ�Ϊ��                       |\n");
	printf("|6.�������                               |\n");
	printf("|7.�õ�ͷԪ��                             |\n");
	printf("|8.�õ����г���                           |\n");
	printf("|9.��������                               |\n");
	printf("|*****************************************|\n");
	printf("���룺");
	
	int k;    //���û�����ѡ����� 
	while(1)
	{
    	fflush(stdin);
	    scanf("%d",&k);
	    switch(k)
	    {
	    	case 1:
	    		DestoryLQueue(Q);
	    		break;
	    	case 2:
	    		DeLQueue(Q);
	    		break;
	    	case 3:
	    		printf("��������Ҫ��ӵ�Ԫ�أ�");
	    		if(data_size == 1)
	    		{
	    			char ch;
	    			scanf("%s",&ch);
	    			data = &ch;
				}
				else
				{
					int ih;
					scanf("%d",&ih);
					data = &ih;
				}
	    		EnLQueue(Q, data);
	    		break;
	    	case 4:
	    		ClearLQueue(Q);
	    		break;
	    	case 5:
	    		IsEmptyLQueue(Q);
	    		break;
	    	case 6:
	    		foo = LPrint;
	    		TraverseLQueue(Q, foo);
	    		break;
	    	case 7:
	    		x = GetHeadLQueue(Q, e);
	    		foo = LPrint;
	    		TraverseLQueue(Q, foo);
	    		break;
	    	case 8:
	    		length = LengthLQueue(Q);
	    		printf("���г���Ϊ%d \n",length);
	    		break;
	    	case 9:
	    		return 0;
	    		break;
	    	default:
	    		printf("������Ч����������\n");
	    		break;
		}
	    printf("���Լ�������Ҫ����������: ");
	}
	return 0;
}

int main(int argc, char *argv[]) 
{
	//while(1)
	//{
	    printf("|***************Type Menue***************|\n");
	    printf("|1:char�ַ����ַ���                      |\n");
	    printf("|4:int                                   |\n");
	    printf("|8:double                               |\n");
	    printf("|****************************************|\n\n");
	    size_t data_size;
	    while(scanf("%d",&data_size) != 1)
	    {
	    	printf("������Ч������������\n");
	    	fflush(stdin);
		}
		fflush(stdin);
		printf("|***************Queue Menue***************|\n");
		printf("|a.ѭ������                               |\n");
		printf("|b.��ʽ����                               |\n");
		printf("|*****************************************|\n");
	    char ch;
	    ch=getchar();
	    if(ch == 'a')
	    {
	    	CycleQueue(data_size); 
		}
	    else if(ch == 'b')
	        LinkQueue(data_size);
	    else
	        printf("������Ч��");
	    getch();
	//}
	return 0;
}
