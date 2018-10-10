#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>

#define MAXQUEUE 10
#define queue_entry(ptr, type, member) \
        ((type *)((char *)(ptr)-(unsigned long)(&((type *)0)->member)))

typedef struct Aqueue        	
{
    void *data[MAXQUEUE];  	//������
    int front;
    int rear;
	size_t data_size;		//�������ڴ��С
	int len;
} AQueue;

//��ʽ���нṹ
typedef struct node     	  	
{
    void* data;       			//������ָ��
    struct node *next;			//ָ��ǰ������һ���
} Node;

typedef struct Lqueue
{
    Node *front;       			//��ͷ
    Node *rear;        			//��β
	size_t data_size;			//�������ڴ��С
} LQueue;

typedef enum
{
    FLASE=0, TRUE=1
} Status;

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

int CycleQueue(size_t data_size)    //ѭ������ 
{
	int x;
	AQueue *Q;
	Q = malloc(sizeof(AQueue));    //�����ڴ� 
	printf("�õģ������ȳ�ʼ��һ�����У�\n");
	InitAQueue(Q,data_size);
	
	int length;    //�õ����г��� 
	
	void *data;    //�û��������ӵ�Ԫ�ص�ָ�� 
	
	void (*foo)(void *q,int a);    //���ڱ���ʱʹ�õĺ���ָ�� 
	
	void *e;    //���ڱ���õ���ͷԪ�� 
	
	printf("\n��������Ҫ�Ĳ����Ĵ��������:\n");
	printf("    1.���ٶ���\n");
	printf("    2.����\n");
	printf("    3.���\n");
	printf("    4.��ն���\n");
	printf("    5.�ж϶����Ƿ�Ϊ��\n");
	printf("    6.�������\n");
	printf("    7.�õ�ͷԪ��(bug)\n");
	printf("    8.�õ����г���\n");
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
	    		printf("��������Ҫ��ӵ�Ԫ�أ�");
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
	    	default:
	    		printf("������Ч����������\n");
	    		break;
		}
	    printf("���Լ�������Ҫ����������: ");
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
	
	printf("\n��������Ҫ�Ĳ����Ĵ��������:\n");
	printf("    1.���ٶ���\n");
	printf("    2.����\n");
	printf("    3.���\n");
	printf("    4.��ն���\n");
	printf("    5.�ж϶����Ƿ�Ϊ��\n");
	printf("    6.�������\n");
	printf("    7.�õ�ͷԪ��\n");
	printf("    8.�õ����г���\n");
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
	    		//TraverseLQueue(AQueue *Q, void (*foo)(void *q));
	    		break;
	    	case 7:
	    		//GetHeadLQueue(AQueue *Q, void *e,size_t data_size);
	    		break;
	    	case 8:
	    		length = LengthLQueue(Q);
	    		printf("���г���Ϊ%d \n",length);
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
	    printf("\t\t  ϣ������е������ǣ�������������Ӧ�ֽڵ����֣�1:char�ַ����ַ���,4:int��8��double��");
	    size_t data_size;
	    while(scanf("%d",&data_size) != 1)
	    {
	    	printf("������Ч������������\n");
	    	fflush(stdin);
		}
		fflush(stdin);
		printf("\t\t   ��Ҫ����ѭ�����л�����ʽ���еĲ����أ� a.ѭ������(bug��һ��)   b.��ʽ����(bug��)  ");
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
