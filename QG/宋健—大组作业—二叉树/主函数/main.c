#include<stdio.h>
#include"BinaryTree.h"
#include"BiTree.c"
char fuction[1000];
char op[1000];
int lch[1000], rch[1000];
int main() 
{
	char src[100];
	BiTree L;
    InitBiTree(L); //��ʼ��     
	int i;
    printf("������������ʽ��"); 
    while(scanf("%[^\n]", fuction) != EOF )//�����ո���� 
	{
        getchar();
        memset(op, 0, sizeof(op));
        no = 0;
        build_tree(fuction, 0, strlen(fuction));
        printf("%.2f\n", calculate(op, 1));
        memset(fuction, 0, sizeof(fuction));
    }
	return 0;
}
