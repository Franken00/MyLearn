#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include "MyQUEUE.h"

void InitAQueue(AQueue *Q,size_t data_size)    //��ʼ��ѭ������
{
	//Q = (AQueue *)malloc(sizeof(AQueue) * MAXQUEUE);
	//Q->data = malloc(data_size *MAXQUEUE);
	//Q->data_size = data_size;
	
	Q->data[MAXQUEUE];
	Q->front = 0;
	Q->rear = 0;
	Q->data_size = data_size;
	printf("���д����ɹ���\n");
} 

void DestoryAQueue(AQueue *Q)    //����ѭ������
{
	if(Q == NULL)
	{
		printf("��������ʧ�ܣ�\n");
	}
	else
	{
			Q->front = Q->rear = 0;
			Q = NULL;
			printf("�������ٳɹ���\n");
	}
}

Status IsEmptyAQueue(AQueue *Q)    //�ж�ѭ�������Ƿ�Ϊ�� 
{
	//if(Q == NULL)
	//{
		//printf("���ܲ������У�\n");
		//return FLASE;
	//} 
	if(Q->front == Q->rear)    //(((Q->rear - Q->front + MAXQUEUE) % MAXQUEUE) == 0)   ���� 
	{
		printf("����Ϊ�գ�\n");
		return TRUE;
	}
	else 
	{
		printf("���в�Ϊ�գ�\n");
		return FLASE;
	}
}

Status EnAQueue(AQueue *Q, void *data)    //��ѭ������
{
	fflush(stdin);
	if((Q->rear+1) % MAXQUEUE == Q->front)
	{
		printf("�����Ѿ����ˣ�\n");
		return FLASE;
	}
	void *addTarget = (Q->data) + (Q->rear)%MAXQUEUE * (Q->data_size);
	memcpy(addTarget,data,Q->data_size);
	++(Q->rear);
	++(Q->len);
	printf("(����Ҳ���ַ���һ��)����ɹ���\n");
	
	return TRUE;
}

Status DeAQueue(AQueue *Q)    //��ѭ������
{
	if(Q->front == Q->rear)
	{
		printf("����Ϊ�գ�\n");
		return FLASE;
	}
	else
	{
		Q->front = (Q->front + 1) % MAXQUEUE;
		printf("����ͷԪ�س����гɹ���\n");
		return TRUE; 
	}
}

Status GetHeadAQueue(AQueue *Q, void *e)    //�õ�ѭ������ͷԪ��
{
	
	if(Q == NULL)
	{
		printf("���ܲ������У�\n");
		return FLASE;
	} 
	if(Q->front == Q->rear)    //�ж�ѭ�������Ƿ�Ϊ�� )
	{
		printf("����Ϊ�գ���ͷԪ�أ�\n");
		return FLASE;
	}
	else
	{
		void *target = (Q->data) + Q->front * (Q->data_size);
		memcpy(e,target,Q->data_size);
		if(Q->data_size == 1)
		{
			printf("ͷԪ��Ϊ%s",*((char *)e));
			return TRUE;
		}
		else if(Q->data_size == 4)
		{
			printf("ͷԪ��Ϊ%d",*((int *)e));
			return TRUE;
		}
	}
} 

int LengthAQueue(AQueue *Q)    //ȷ��ѭ�����г���
{
	return ((Q->rear - Q->front + MAXQUEUE) % MAXQUEUE);
} 

Status TraverseAQueue(AQueue *Q, void (*foo)(void *q,int a))    //����ѭ������
{
	int alen = Q->len;
	int afront = Q->front;
	while(alen)
	{
		void *target = (Q->data) + afront * (Q->data_size);
		foo(target,Q->data_size);
	}
	printf("\n");
	return TRUE;
}

void ClearAQueue(AQueue *Q)    //���ѭ������ 
{
	if(Q == NULL)
	{
		printf("���ʧ�ܣ�\n");
	}
	else
	{
		Q->front = 0;
		Q->rear = 0;
		printf("��ճɹ�!\n");
	}
} 

void APrint(void *q,size_t data_size)    //��ӡѭ������
{
	if(data_size == 1)
	{
		printf(" %c ",*((char *)q));
	}
	else if(data_size == 4)
	{
		printf(" %d ",*((int *)q));
	}
} 

void InitLQueue(LQueue *Q,size_t data_size)    //��ʼ������ 
{
	Q = malloc(sizeof(LQueue));
	Q->front = (Node *)malloc(data_size * sizeof(Node));
	Q->rear = (Node *)malloc(data_size * sizeof(Node));
	Q->front->next = NULL;
	printf("���д����ɹ���\n");
}

void DestoryLQueue(LQueue *Q)    //���ٶ��� 
{
	if(Q->front == NULL)
	{
		printf("���ٶ���ʧ�ܣ�\n");
		return ;
	}
	Node *temp = Q->front->next;
	while(temp)
	{
		Node *tmp = temp;
		temp = temp->next;
		free(tmp);
	}
	temp = Q->front;
	Q->front = Q->rear =NULL;
	free(temp);    //�ͷ�ͷ�ڵ� 
}

Status IsEmptyLQueue(LQueue *Q)    //�ж϶����Ƿ�Ϊ�� 
{
	if(Q->front == Q->rear)
	{
		return TRUE;
	}
	else
	{
		return FLASE;
	}
}

Status GetHeadLQueue(LQueue *Q, void *e)    //�õ�����ͷ�ڵ� 
{
	if(IsEmptyLQueue(Q))
	{
		return FLASE;
	}
	e = Q->front->data;
	printf("ͷԪ��Ϊ");
}

int LengthLQueue(LQueue *Q)    //�õ����� 
{
	int count;
	while(Q->front->next)
	{
		Q->front = Q->front->next;
		count++; 
	}
	return count;
}

Status EnLQueue(LQueue *Q, void *data)    //��� 
{
	Node *s = (Node *)malloc(sizeof(Node));
	if(!s)
	    return FLASE;
	s->data = data;
	s->next = NULL;
	Q->rear->next = s;
	
	Q->rear = s;
	printf("(����Ҳ���ַ���һ��)��ӳɹ���\n");
	return TRUE;
}

Status DeLQueue(LQueue *Q)    //���� 
{
	Node *s;
	if(Q->rear == Q->front)
	{
		printf("����Ϊ�գ�\n");
		return FLASE;
	}
	s = Q->front->next;
	Q->front->next = s->next;
	if(Q->rear == s)
	{
		Q->rear = Q->front;
	}
	free(s);
	printf("���ӳɹ���\n");
	return TRUE; 
}

void ClearLQueue(LQueue *Q)    //��� 
{
	if(Q->front == NULL)
	{
		printf("��ն���ʧ�ܣ�\n");
		return ;
	}
	Node *temp = Q->front->next;
	while(temp)
	{
		Node *tmp = temp;
		temp = temp->next;
		free(tmp);
	}
	Q->front = Q->rear =NULL;
	printf("��ճɹ���\n");
}

Status TraverseLQueue(LQueue *Q, void (*foo)(void *q,int a))    //���� 
{
	if(Q->front == Q->rear)
	{
		return FLASE;
	}
	Node *tmp = Q->front->next;
	while(tmp)
	{
		foo(Q->front->next,Q->data_size);
		tmp = tmp->next;
	}
}

void LPrint(void *q,size_t data_size)    //��ӡ����
{
	if(data_size == 1)
	{
		printf(" %c ",*((char *)q));
	}
	else if(data_size == 4)
	{
		printf(" %d ",*((int *)q));
	}
}
