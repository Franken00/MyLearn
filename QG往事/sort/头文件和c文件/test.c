#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "sort.h"

extern int A;

int testSortTime(void (foo)(int array[],int length),int length)
{

    int  i;
    time_t t;
    srand((unsigned)time(&t));

    int *test = (int *)malloc(length * sizeof(int));

    clock_t start;
    clock_t diff=0;
    clock_t diff1;

    if(A<18)
    {
        //����α�����
        for(i = 0;i < length; i++)
        {
            test[i] = rand()*1000 % 30000000;   //����30000�ڵ������
        }
        start = clock();
        foo(test, length);
        diff = clock() - start;
    }

    else
    {
        for(i=0;i<100000;i++)
        {
            for(i = 0;i < length; i++)
            {
                test[i] = rand()*1000 % 30000000;   //����30000�ڵ������ֵ

            }
            start = clock();
            foo(test, length);
            diff1 = clock()-start;
            diff+=diff1;
        }

    }
    A++;

    free(test);
    return diff;
}


void printTest(char *name)
{
    FILE *fp;

    int time1, time2, time3, time4,time5,time6;  //10000
    int time7, time8,time9, time10,time11,time12;  //50000
    int time13, time14,time15,time16,time17,time18;  //200000

    int time19,time20,time21,time22,time23,time24; //С��������
    int num=100;


    if ((fp = fopen(name, "a")) == NULL)
    {
            printf("���ļ�ʧ�ܣ�\n");
            exit(EXIT_FAILURE);
    }

    printf("�������ɲ���������ʱ��������ĵȴ���������\n\n");

    printf("------------------------------------------------------------------\n");
    printf("    |    �㷨    | 10000������ | 50000������  |  200000������ |\n");
    printf("------------------------------------------------------------------\n");

    time1=testSortTime(insertion_sort,DATAONE);
    time7=testSortTime(insertion_sort,DATATWO);
    time13=testSortTime(insertion_sort,DATATHREE);

    printf("    |    ����    |    %dms     |    %dms    |   %dms     |\n",time1,time7,time13);
    printf("------------------------------------------------------------------\n");

    time2=testSortTime(merge_sort,DATAONE);
    time8=testSortTime(merge_sort,DATATWO);
    time14=testSortTime(merge_sort,DATATHREE);

    printf("    |    �鲢    |     %dms     |     %dms      |     %dms      |\n",time2,time8,time14);
    printf("------------------------------------------------------------------\n");

    time3=testSortTime(counting_sort,DATAONE);
    time9=testSortTime(counting_sort,DATATWO);
    time15=testSortTime(counting_sort,DATATHREE);

    printf("    |    ����    |   %dms     |     %dms      |      %dms      |\n",time3,time9,time15);
    printf("------------------------------------------------------------------\n");

    time4=testSortTime(radix_sort,DATAONE);
    time10=testSortTime(radix_sort,DATATWO);
    time16=testSortTime(radix_sort,DATATHREE);

    printf("    |    ����    |     %dms     |     %dms      |      %dms     |\n",time4,time10,time16);
    printf("------------------------------------------------------------------\n");

    time5=testSortTime(quick_sort, DATAONE);
    time11=testSortTime(quick_sort, DATATWO);
    time17=testSortTime(quick_sort, DATATHREE);

    printf("    | ����(�ݹ�) |    %dms      |     %dms      |     %dms      |\n",time5,time11,time17);
    printf("------------------------------------------------------------------\n");

    time6=testSortTime(QuickSort_NO, DATAONE);
    time12=testSortTime(QuickSort_NO, DATATWO);
    time18=testSortTime(QuickSort_NO, DATATHREE);


    printf("    | ����(�ǵ�) |    %dms     |     %dms     |     %dms      |\n",time6,time12,time18);
    printf("------------------------------------------------------------------\n");

    printf("\n\n");
    printf("------------------------------------------------------------------\n");
    printf("----------------����100*100k��С��������--------------------\n");
    printf("------------------------------------------------------------------\n");
    printf("    |    �㷨    |  ��������  |  �鲢����  |   ��������  |   ��������  |   ���ŵݹ�  |   ���ŷǵݹ�  |\n");

    time19=testSortTime(insertion_sort,num);
    time20=testSortTime(merge_sort,num);
    time21=testSortTime(counting_sort,num);
    time22=testSortTime(radix_sort,num);
    time23=testSortTime(quick_sort, num);
    time24=testSortTime(QuickSort_NO, num);
    printf("    |            |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |\n",time19,time20,time21,time22,time23,time24);
    printf("------------------------------------------------------------------\n");


    fprintf(fp, "------------------------------------------------------------------\n");
    fprintf(fp, "    |    �㷨    | 10000������ | 50000������  |  200000������ |\n");
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    ����    |    %dms     |    %dms    |   %dms     |\n",time1,time7,time13);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    �鲢    |     %dms     |     %dms      |     %dms      |\n",time2,time8,time14);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    ����    |   %dms     |     %dms      |      %dms      |\n",time3,time9,time15);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    ����    |     %dms     |     %dms      |      %dms     |\n",time4,time10,time16);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    | ����(�ݹ�) |    %dms      |     %dms      |     %dms      |\n",time5,time11,time17);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    | ����(�ǵ�) |    %dms     |     %dms     |     %dms      |\n",time6,time12,time18);
    fprintf(fp,"------------------------------------------------------------------\n");

    fprintf(fp,"\n\n");
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp,"----------------����100*100k��С��������--------------------\n");
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp,"    |    �㷨    |  ��������  |  �鲢����  |   ��������  |   ��������  |   ���ŵݹ�  |   ���ŷǵݹ�  |\n");
    fprintf(fp,"    |            |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |\n",time19,time20,time21,time22,time23,time24);
    fprintf(fp,"------------------------------------------------------------------\n");

    fclose(fp);

}
