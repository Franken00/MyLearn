#include <stdio.h>
#include <stdlib.h>
 
typedef int ElemType;            //ָ��Ԫ������Ϊ���� 
 
//���������� 
typedef struct Node {
    ElemType data;              //�������е������� 
    struct Node *next;          //�������ָ���� 
}Node,*LinkedList;


LinkedList LinkedListInit() 
{
    Node *L;
    L = (Node *)malloc(sizeof(Node));   //������ռ� 
    if(L == NULL)                       //�ж��Ƿ����㹻���ڴ�ռ� 
	{                    
        printf("�����ڴ�ռ�ʧ��\n");
    }
    L->next = NULL;                    //��next����ΪNULL,��ʼ����Ϊ0�ĵ����� 
 	return L;                          //����ͷָ���Ա�����ʹ�� 
}

//������Ľ���2��β�巨����������
 
void InsertList(PNode List, int pos, int val) {
    int position = 0;
    PNode P = List;    		//    ����ڵ�pָ��ͷ�ڵ�
                    		//    Ѱ��pos�ڵ��ǰ�����
    while (P != NULL && position<pos - 1)
    {
        P = P->Next;
        ++position;
    }
    PNode Tmp = (PNode)malloc(sizeof(Node));     // ����һ����ʱ�ڵ������洢Ҫ���������
    if (Tmp == NULL)
    {
        printf("�ڴ����ʧ�ܣ�");
        exit(-1);
    }
    //    ����ڵ�
    Tmp->Element = val;
    Tmp->Next = P->Next;
    P->Next = Tmp;
}


void DeleteTheList(PNode List) {
    PNode P, Tmp;
    P = List->Next;    //����ָ��Pָ������Ҫɾ��������List�ĵ�һ����ڵ�
    List->Next = NULL;
    while (P != NULL) {
        Tmp = P->Next;        //��ʱTmpָ��Ҫɾ���Ľڵ���¸��ڵ�
        free(P);    //�ͷ�ָ��Pָ��Ľڵ�
        P = Tmp;    //���¸�ֵ
    }
    printf("ɾ������ɹ���\n");
}


PNode FindList(PNode List) {
    PNode P = List->Next;    //    ������ʱָ��Pָ���׽ڵ�ĵ�ַ
    int num = 0;    //    ���ڼ�¼����ڵ�λ��
    int val = 0;    //    ���ڴ��Ҫ��ѯ��ֵ
    printf("������Ҫ��ѯ������");
    scanf_s("%d", &val);    //    ����Ҫ��ѯ����ֵ
    while (P != NULL&&P->Element != val) {
        P = P->Next;
        ++num;
    }
    if (P != NULL)
        printf("�ҵ��Ľڵ�Ϊ��%d", num + 1);
    else
        printf("�Ҳ����ýڵ�");
    printf("\n");
    return P;
}


void DeleteTheList(PNode List) {
    PNode P, Tmp;
    P = List->Next;    //����ָ��Pָ������Ҫɾ��������List�ĵ�һ����ڵ�
    List->Next = NULL;
    while (P != NULL) {
        Tmp = P->Next;        //��ʱTmpָ��Ҫɾ���Ľڵ���¸��ڵ�
        free(P);    //�ͷ�ָ��Pָ��Ľڵ�
        P = Tmp;    //���¸�ֵ
    }
    printf("ɾ������ɹ���\n");
}


