#include<stdio.h>
#include<stdlib.h>
#include"stack.h"
#include"stack.c"
#include"windows.h"//����������  

Status printStack()
{
	printf("*|*****************************|*\n");
	printf("*|------------menue------------|*\n");
	printf("*| 1.��ʼ��˳��ջ              |*\n");
	printf("*| 2.ѹջ                      |*\n");
	printf("*| 3.��ջ                      |*\n");
	printf("*| 4.���ջ                    |*\n");
	printf("*| 5.ɾ��ջ                    |*\n");
	printf("*| 6.�鿴ջ����                |*\n");
	printf("*| 7.�鿴ջ��Ԫ��              |*\n");
	printf("*| 8.�Ƿ�Ϊ��ջ                |*\n");
	printf("*| 9.�˳�                      |*\n");
	printf("*|*****************************|*\n");
	printf("�������Ӧ�����ɲ�����");
	
	int sc;  
	
	SqStack *s = (SqStack *)malloc(sizeof(SqStack));
	s->size = -1;
	
	while(scanf("%d",&sc) != 9)
	{
		switch(sc)
		{
			case 1:
			{
				int sizes;
				printf("������ջ�Ĵ�С��");
				scanf("%d",&sizes);
				initStack(s,sizes);
				printf("�ɹ���ʼ����СΪ%d��ջ!\n",sizes);
				printf("\n��������һ��������\n");
				break;
			}
			
			case 2:
			{
				if(isEmptyStack(s))
				{	ElemType datas;
					printf("������datas:");
					scanf("%d",&datas);
					pushStack(s,datas);
				}
				printf("\n��������һ��������\n");
				break;
			}
			
			case 3:
			{
				if(isEmptyStack(s))
				{
					ElemType *datas;
					popStack(s,datas);
				}
				printf("\n��������һ��������\n");
				break;
			}
			
			case 4:
			{
				if(isEmptyStack(s))
				{	
					clearStack(s);
				}
				printf("\n��������һ��������\n");
				break;
			}
			
			case 5:
			{
				if(isEmptyStack(s))
				{
					destoryStack(s);
				}
				printf("\n��������һ��������\n");
				break;
			}
			
			case 6:
			{
				if(isEmptyStack(s))
				{
					int length;
					stackLength(s,length);
				}
				printf("\n��������һ��������\n");
				break;
			}
			
			case 7:
			{
				if(isEmptyStack(s))
				{
					ElemType e;
					getTopStack(s,&e);
				}
				printf("\n��������һ��������\n");
				break;
			}
			
			case 8:
			{
				if(isEmptyStack(s))
				{
					isEmptyStack(s);
				}
				printf("\n��������һ��������\n");
				break;
			}
			 
			case 9: printf("\n������\n");return 0; 
		}
	}
   return 0;
	
}

Status printLStack()
{
	printf("*|*****************************|*\n");
	printf("*|------------menue------------|*\n");
	printf("*| 1.��ʼ����ջ                |*\n");
	printf("*| 2.ѹջ                      |*\n");
	printf("*| 3.��ջ                      |*\n");
	printf("*| 4.���ջ                    |*\n");
	printf("*| 5.ɾ��ջ                    |*\n");
	printf("*| 6.�鿴ջ����                |*\n");
	printf("*| 7.�鿴ջ��Ԫ��              |*\n");
	printf("*| 8.�Ƿ�Ϊ��ջ                |*\n");
	printf("*| 9.�˳�                      |*\n");
	printf("*|*****************************|*\n");

	 
	int sc; 
	LinkStack *s = (LinkStack*)malloc(sizeof(StackNode));
	s->count = 0;
	s->top = NULL;
	printf("��ʼ����ѡ��ǰ����ɣ�\n");
	printf("�������Ӧ�����ɲ�����");
	while(scanf("%d",&sc))
	{
		switch(sc)
		{
			case 1:
			{
				initLStack(s);
				printf("\n��������һ��������\n");
				break;
			}
			
			case 2:
			{
				
				ElemType datas;
				printf("������datas:");
				scanf("%d",&datas); 
				pushLStack(s,datas);
				printf("\n��������һ��������\n");
				break;
			}
			
			case 3:
			{
				ElemType *datas;
				popLStack(s,datas);
				printf("\n��������һ��������\n");
				break;
			}
			
			case 4:
			{
				clearLStack(s);
				printf("\n��������һ��������\n");
				break;
			}
			
			case 5:
			{
				destoryLStack(s);
				printf("\n��������һ��������\n");
				break;
			}
			
			case 6:
			{
				int length;
				LStackLength(s,length);
				printf("\n��������һ��������\n");
				break;
			}
			
			case 7:
			{
				ElemType e;
				getTopLStack(s,&e);
				printf("\n��������һ��������\n");
				break;
			}
		
			case 8:
			{
				isEmptyLStack(s);
				printf("\n��������һ��������\n");
				break;
			}
			 
			case 9: printf("\n������\n");return 0;
		}
	}
}


int main()
{
	int num;
	printf("*|*****************************|*\n");
	printf("*|------------menue------------|*\n");
	printf("*| 1.˳��ջ�Ĳ���              |*\n");
	printf("*| 2.��ջ�Ĳ���                |*\n");
	printf("*|-----------------------------|*\n");
	printf("*|*****************************|*\n");
	printf("ѡ��ջ�����ͣ�������ţ�");
	printf("\n");
	printf("\n");
	scanf("%d",&num);
	if(num == 1) {
		printf("*|********��ǰѡ�����*********|*\n");
		printf("*|           ˳��ջ            |*\n");
		printStack();
		
	}
	else if(num == 2) 
	{
		printf("*|********��ǰѡ�����*********|*\n");
		printf("*|            ��ջ             |*\n");
		printLStack();
	} 
	else printf("�������");
    return 0;
    system("pause");//��ֹ�������� 
}


 








