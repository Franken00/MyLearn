#include <stdio.h>
#include"stack.h"
#include<stdlib.h>
//˳��ջ(���������)

Status initStack(SqStack *s,int sizes)  //��ʼ��ջ
{
	s->elem = (ElemType *)malloc(sizes * sizeof(ElemType));
	if(s->elem == NULL) return 0;		
	s->top = -1;
	s->size = sizes;
	printf("��ʼ����ɣ�\n");

}


Status isEmptyStack(SqStack *s)   //�ж�ջ�Ƿ�Ϊ��
{
	if(s->size == -1) {printf("���ȳ�ʼ����\n"); return ERROR;}
	else if(s->top == -1) {printf("��ʱΪ��ջ��\n"); return OK;}
	else {printf("��ʱΪ�ǿ�ջ��\n"); return OK;}
	return OK; 
}



Status destoryStack(SqStack *s)  //����ջ
{
	if(s == NULL || s->top == -1) return ERROR;
	free(s->elem);
	s->size = 0;
	s->top = -1;
	printf("ɾ���ɹ���\n");
	return OK;
}


Status pushStack(SqStack *s,ElemType datas)  //��ջ
{
	if(s->top == s->size-1) {printf("ջ�������޷���ջ��\n"); return ERROR;}
	else 
	{	s->top++;
		s->elem[s->top] = datas;
		printf("����ɹ���\n");
	}
	return OK;
	
}

Status popStack(SqStack *s,ElemType *datas)   //��ջ
{	
	if(s->top == -1) { return 0;}
	*datas = s->elem[s->top];
	s->top--;
	printf("��ջԪ��Ϊ��%d\n",*datas);
	return OK;

}

Status stackLength(SqStack *s,int length)   //���ջ����
{
	length = s->top + 1;
	printf("ջ�ĳ���Ϊ��%d\n",length);	
}

Status getTopStack(SqStack *s,ElemType *e)   //�õ�ջͷԪ��
{
	if(s == NULL || s->top == -1) return ERROR;
	*e = s->elem[s->top];
	printf("ջ��ͷԪ��Ϊ:%d\n",*e);
	return OK;
}

Status clearStack(SqStack *s)   //���ջ
{
	s->top = -1;
	printf("��ճɹ���\n");	
}



//��ջ(���������)
Status initLStack(LinkStack *s)   //��ʼ��
{
	s = (LinkStack*)malloc(sizeof(LinkStack));
    s->top = NULL;
    s->count = 0;
    printf("�ɹ���ʼ����ջ!\n");
    return OK;
}

Status pushLStack(LinkStack *s,ElemType datas)   //��ջ
{
	if(s == NULL) {printf("���ʼ����ջ!\n"); return ERROR;}
	LinkStackPtr current = (LinkStackPtr)malloc(sizeof(StackNode));
	current->data = datas;
	current->next = s->top;
	s->top = current;
	s->count++;
	return OK;
}

Status popLStack(LinkStack *s,ElemType *datas)   //��ջ
{
	if(s->top == NULL) {printf("����ջ��ִ�У�\n"); return ERROR;}
	
	LinkStackPtr current;
	*datas = s->top->data;
	current = s->top;
	s->top = s->top->next;
	free(current);
	s->count--;
	printf("��ջԪ��Ϊ��%d\n",*datas);
	return OK;
}


Status destoryLStack(LinkStack *s)   //������zhan 
{
	clearLStack(s);
	free(s);
	printf("ɾ����ɣ�\n");
	printf("ע�⣡��ʱsָ��δ֪��������������������ȳ�ʼ������������쳣��");
	return OK;
}


Status isEmptyLStack(LinkStack *s)  //�ж������Ƿ�Ϊ��
{
	if(NULL == s->top) {printf("��ʱΪ����ջ��\n"); return OK;} 
	else {printf("��ʱΪ�ǿ���ջ��\n"); return OK;} 
}

Status getTopLStack(LinkStack *s,ElemType *e)  //�õ�����ͷԪ��
{
	if(s->top == NULL) {printf("����ջ��ִ�У�\n"); return ERROR;}
	*e = s->top->data;
	printf("��ջ��ͷԪ��Ϊ��%d\n",*e);
	return OK;
}


Status clearLStack(LinkStack *s)   //�������
{
	if(s->top == NULL) {printf("����ջ��ִ�У�\n"); return ERROR;}
	LinkStackPtr current;
	while(s->count)
	{
		s->count--;
		current = s->top->next;
		free(s->top);
		s->top = current;
	}
	printf("��ճɹ���\n");
	return OK;
}


Status LStackLength(LinkStack *s,int length)    //�����zhan����
{
	length = s->count;
	printf("��ջ����Ϊ��%d\n",length);
	return OK;
}
