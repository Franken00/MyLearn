#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int pushFuctionStack(LinkStack *s,int datas)  //��ջ
{
	LinkStackPtr current = (LinkStackPtr)malloc(sizeof(StackNode));
	current->data = datas;
	current->next = s->top;
	s->top = current;
	s->count++;
	return OK;
}

int popFuctionStack(LinkStack *s)   //��ջ
{	
	int num;
	LinkStackPtr current;
	current = s->top;
	num = current->data;
	s->top = current->next;
	free(current);
	s->count--;
	return num;
}

int isEmptyStack(LinkStack *s)             //�ж�ջ�Ƿ�Ϊ��
{
    return (s->count == 0) ? OK : ERROR;  
}

int getTopLStack(LinkStack *s)               //�õ���ջͷԪ��
{
	if(NULL == s->top)  return ERROR;  
    return (s->top->data); 
}

int Priority(char s)                         /*�ж����ȼ�   ��������ο������ϵĴ���  0.0*/ 
{                                            /*ʵ���벻����ô������ȼ����ж�*/ 
    switch(s)  
    {  
        case '(':  
            return 3;  
        case '*':  
        case '/':  
            return 2;  
        case '+':  
        case '-':  
            return 1;  
        default:  
            return 0;  
    }  
}  

int intSelection()
{
	int tmp = 0; int j; int i = 0; int temp;
	
	
	char fuction[100]={0};
	LinkStack *num ,*fuhao;
	num = (LinkStack *)malloc(sizeof(StackNode));
	num->top = NULL;
    num->count = 0;
   
    fuhao = (LinkStack *)malloc(sizeof(StackNode));
	fuhao->top = NULL;
    fuhao->count = 0;
	
	printf("����Ҫ�ڷ������������ţ�����ʹ�����ĵ����ţ���'����'��\n");
	printf("�����뺯����");
	scanf("%s",fuction);
	
	while(fuction[i] != '\0' || isEmptyStack(fuhao) != OK)
	{
		if(fuction[0] == '+' || fuction[0] == '-' || fuction[0] == '*' ||fuction[0] == '/' )
		{
			printf("����������Ϊ���̵Ŀ�ͷ��");
			return 0;
		}
		if(getTopLStack(fuhao) == '(' && fuction[i] != ')')
		{
			if(fuction[++i] == '+' || fuction[++i] =='-' || fuction[++i] == '*' ||fuction[++i] == '/')
			{
			 	printf("��ʽ����");
				return 0;
			} 
		}
		
		if(fuction[i] >= '1' && fuction[i] <= '9')          //����ѹ������ջ 
		{
			tmp = tmp * 10 + fuction[i] - '0';
			i++;
			if(fuction[i] < '1' || fuction[i] > '9')
			{
				pushFuctionStack(num,tmp);
				tmp = 0;
			}
		}
		else 
		{
			if((isEmptyStack(fuhao) == OK) || (getTopLStack(fuhao) == '(' && fuction[i] != ')') || Priority(fuction[i]) > Priority(getTopLStack(fuhao)))
			{
				pushFuctionStack(fuhao,fuction[i]);
				i++;
				continue;
			}
			if(getTopLStack(fuhao) == '(' && fuction[i] == ')')
			{
				popFuctionStack(fuhao);
				i++;
				continue;
			}
			if((fuction[i] == '\0' && isEmptyStack(fuhao) != OK) || (fuction[i] == ')' && getTopLStack(fuhao) != '(') || Priority(fuction[i]) <= Priority(getTopLStack(fuhao)))
			{
				switch(popFuctionStack(fuhao))
				{
					case '+':
						pushFuctionStack(num, popFuctionStack(num) + popFuctionStack(num));
						break;
					case '-':
						j = popFuctionStack(num);
						pushFuctionStack(num, popFuctionStack(num) - j);
						break;
					case '*':
						pushFuctionStack(num, popFuctionStack(num) * popFuctionStack(num));
						break;
					case '/':
						j = popFuctionStack(num);
						if(j == 0) {printf("��������Ϊ0��"); return 0;}
						pushFuctionStack(num, popFuctionStack(num) / j);
						break; 
				}
				continue;
			}				
		}
	}
	printf("���̽��Ϊ��%d",popFuctionStack(num));
        printf("\n"); 
	return 0; 
} 

