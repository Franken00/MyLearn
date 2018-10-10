#ifndef OPERATION_H
#define OPERATION_H
#define MAXNUM 200

typedef char ElemType;            //ָ���ַ����� 

typedef enum Status              //ö�� 
{
    ERROR = 0,OK = 1
}Status;

typedef  struct StackNode       //��ջ��� 
{
	ElemType data;
	struct StackNode *next;
}StackNode, *LinkStackPtr;

typedef  struct  LinkStack{
	LinkStackPtr top;	 
	int	count;
}LinkStack;

int getTopLStack(LinkStack *s);                    	//��ȡջ��Ԫ�� 
int isEmptyStack(LinkStack *s);                     //�ж��Ƿ�Ϊ��ջ 
int popFuctionStack(LinkStack *s);                  //��ջ 
int pushFuctionStack(LinkStack *s,int datas);            //ѹջ 
int Priority(char s);                                //�ж����ȼ� 
#endif
