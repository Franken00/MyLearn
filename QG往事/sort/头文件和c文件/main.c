#include <stdio.h>
#include <string.h>
#include "sort.h"

int A;

int main()
{
    char name[40],name2[40];
    char houzui[]=".txt";

    printf("��������Ҫ�������ݲ�����ʱ���ļ����ļ�����");
    scanf("%s",name);
    fflush(stdin);

    strcat(name,houzui);
    printTest(name);

    printf("���Գɹ���\n\n");


    return 0;
}
