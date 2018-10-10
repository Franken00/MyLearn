#include<stdio.h>
#include"BinaryTree.h"
#include<stdlib.h>
#include<string.h>
char fuction[1000];
char op[1000];
int lch[1000], rch[1000];
int no = 0;


void InitBiTree(BiTree T)          //��ʼ���� 
{
	T = NULL;
	printf("��ʼ����ɣ�\n");
}

Status DestroyBiTree(BiTree T)       //ɾ���� 
{
	if(T)
	{
		DestroyBiTree(T->lchild);
		DestroyBiTree(T->rchild);
		free(T);
		printf("�ڵ�ɾ���ɹ���\n");
		return SUCCESS;
	}
}
/*
BiTree CreateBiTree(BiTree T)          //������ 
{
    char ch =NULL;
    scanf("%c",&ch);
    if(ch=='#')T=NULL;
    else{
        T = (BiTree)malloc(sizeof(BiTNode));
        T->data = ch;
        T->lchild = CreateBiTree(T->lchild);
        T->rchild = CreateBiTree(T->rchild);
    }
    return T;
}
*/
void PreOrderTraverse(BiTree T)          //ǰ����� 
{
    if(T)
	{
       printf("%c",T->data);
       PreOrderTraverse(T->lchild);
       PreOrderTraverse(T->rchild);
    }
}

void InOrderTraverse(BiTree T)
{
    if(T)
	{
       InOrderTraverse(T->lchild);
       printf("%c",T->data);
       InOrderTraverse(T->rchild);
    }
}

void PostOrderTraverse(BiTree T)
{
	if(T)
	{
       PostOrderTraverse(T->lchild);
       PostOrderTraverse(T->rchild);
       printf("%c",T->data);
    }
}
/*
//����
int cacul(int a, char op, int b) 
{
    switch (op) 
	{
    	case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;    
    }
}
*/ 

/*bool Isoperator(String s)
{
	if(s == '-' || s == '+' || s == '*' || s == '/') return true;
	else return false;
}

bool Isoperator(char ops)
{
	if(ops == '-' || ops == '+' || ops == '*' || ops == '/') return true;
	else return false;
}

bool Isnum(char ch)
{
	if(ch >= '0' && cj <= '9') return true;
	else return false;
}

*/
/*
//��ֵ����
int val(TNode* cur) 
{
    if (cur->left == NULL && cur->right == NULL)
        return cur->opnd;
    else
        return cacul(val(cur->left), cur->optr, val(cur->right));
}
*/


int cal(BiTree T)
{
	int num1,num2;
	if(T->data == '*' || T->data == '+' || T->data == '/' || T->data == '-')
	{
		num2 = cal(T->rchild);//�����ұ� 
		num2 = zhuanhua(num2);
		printf("%d\n",num2);
		
		num1 = cal(T->lchild);//������� 
		num1 = zhuanhua(num1);
		printf("%d\n",num1);
		
		char optr = (char)T->data;
		printf("%c\n",optr); 
		
		switch(optr)
		{
			case '+':
				return num1 + num2;//  i-��Ҫת�����ַ��������֣�num-ת���󱣴��ַ����ı���  0-ת�����ֵĻ����������ƣ� 
			case '-':
				return num1 - num2;
			case '*':
				return num1 * num2;
			case '/':
				return num1 / num2;
		}
	}
}



int zhuanhua(char c)
{
	int i;
	switch(c)
	{
		case '0':   i = 0;break;
		case '1':   i = 1;break;
		case '2':   i = 2;break;
		case '3':   i = 3;break;
		case '4':   i = 4;break;
		case '5':   i = 5;break;
		case '6':   i = 6;break;
		case '7':   i = 7;break;
		case '8':   i = 8;break;
		case '9':   i = 9;break;
	}
	return i;
}

//�������� 
int build_tree(char *st, int beg, int end)
{
    int i, j, k, p;
    int u;
    int sum = 0;
    int flag = 1;
    for(i = beg; i < end; i ++)//�ҵ���һ������
	{
        if(!(st[i] <= '9' && st[i] >= '0'))
		{
            flag = 0;//����Ϊ0 
            break;
        }
    }
    if(flag)//��������� 
	{
        j = 1;
        for(i = end - 1; i >= beg; i --)
		{
            sum += ((int)st[i] - '0') * j;
            j *= 10;
        }
        u= ++no;
        lch[u] = 0;
        rch[u] = 0;
        op[u] = sum;
        return u;
    }
    int c1 = -1;//����Ƿ��� 
    int c2 = -1;
    p = 0;
    for(i = beg; i < end; i ++)
	{
        switch(st[i])
		{
            case '(': p ++; break;
            case ')': p --; break;
            case '+': case '-': if(!p) c1 = i; break;
            case '*': case '/': if(!p) c2 = i; break;
        }
    }
    if(c1 < 0) c1 = c2;
    if(c1 < 0) return build_tree(fuction, beg + 1, end - 1 );
    u = ++no;
    lch[u] = build_tree(st, beg, c1);
    rch[u] = build_tree(st, c1+1, end);
    op[u] = st[c1];
    return u;
}

float calculate(char *st, int beg)
{
    if(lch[beg] == 0 && rch[beg] == 0)// 
        return (float)st[beg];
    else switch (st[beg])
	{
        case '+': return calculate(op, lch[beg]) + calculate(op, rch[beg]); break;
        case '-': return calculate(op, lch[beg]) - calculate(op, rch[beg]); break;
        case '*': return calculate(op, lch[beg]) * calculate(op, rch[beg]); break;
        case '/': return calculate(op, lch[beg]) / calculate(op, rch[beg]); break;
    }
    return 0;
}































