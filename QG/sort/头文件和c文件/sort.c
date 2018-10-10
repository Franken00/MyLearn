#include <stdio.h>
#include <stdlib.h>
#include "sort.h"

void insertion_sort(int array[], int length)
{
        int i, j, temp;

        for (i = 1; i < length; i++)
        {
                temp = array[i];
                j = i - 1;
                for ( ; j >= 0 && array[j] > temp; j--)
                {
                        array[j+1] = array[j];
                }
                array[j+1] = temp;
        }
}




void quick_sortRe(int array[], int left, int right)
{
        int i = left, j = right;
        int temp;
        int pivot;

        // ��׼������Ϊ�м�Ԫ�أ���ȻҲ����ѡ������Ԫ����Ϊ��׼��
        pivot = array[(left + right) / 2];

        while (i <= j)
        {
                // �ҵ���ߴ��ڵ��ڻ�׼���Ԫ��
                while (array[i] < pivot)
                {
                        i++;
                }
                // �ҵ��ұ�С�ڵ��ڻ�׼���Ԫ��
                while (array[j] > pivot)
                {
                        j--;
                }
                // �������±�С���ұߣ��򻥻�Ԫ��
                if (i <= j)
                {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        i++;
                        j--;
                }
        }

        //�ݹ�
        if (left < j)
        {
                quick_sortRe(array, left, j);
        }

        if (i < right)
        {
                quick_sortRe(array, i, right);
        }
}

void quick_sort(int array[],int length)
{
    quick_sortRe(array, 0, length-1);
}



//���ŷǵݹ�
int split(int array[],int low,int high)
{
    int i=low,j;
    int x=array[low];
    int tmp = 0;
    for(j = low+1;j <= high;j++)
    {
        if(array[j] > x)
        {
            i++;
            if(i!=j)
            {
                tmp = array[j];
                array[j]=array[i];
                array[i]=tmp;
            }
        }
    }
    tmp = array[low];
    array[low] = array[i];
    array[i] = tmp;
    return i;
}

void QuickSort_Nore(int array[],int aLow,int aHigh,int length)
{
    int i,w;
    stackNode *st = (stackNode*) malloc(sizeof(stackNode)*length);

    if( !st ){
        printf("�ڴ������ϣ�");
        exit(0);
    }

    int top= -1,low,high;
    top++;
    st[top].low=aLow;
    st[top].high=aHigh;
    while(top>-1)
    {
        low=st[top].low;high=st[top].high;
        top--;

        if(low<high)
        {
            w=split(array,low,high);

            st[++top].low=low;
            st[top].high=w-1;

            st[++top].low=w+1;
            st[top].high=high;
        }
    }

    free(st);
}

void QuickSort_NO(int array[],int length)
{
    QuickSort_Nore(array,0,length-1,length);
}


void merge_sort_recursive(int array[], int reg[], int start, int end)
{
        if (start >= end)
        {
                return;
        }

        int k = start;
        int length = end - start;
        int mid = (length / 2) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        merge_sort_recursive(array, reg, start1, end1);
        merge_sort_recursive(array, reg, start2, end2);

        while (start1 <= end1 && start2 <= end2)
        {
                reg[k++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        }

        while (start1 <= end1)
        {
                reg[k++] = array[start1++];
        }

        while (start2 <= end2)
        {
                reg[k++] = array[start2++];
        }

        for (k = start; k <= end; k++)
        {
                array[k] = reg[k];
        }
}

void merge_sort(int array[], int length)
{
        int reg[length];
        merge_sort_recursive(array, reg, 0, length-1);
}

//��������
void counting_sort(int array[], int length)
{
        int i, max;
        int *buffer = NULL;
        int *sorted = NULL;

        max = array[0];
        for (i = 1; i < length; i++)
        {
                if (array[i] > max)
                {
                        max = array[i];
                }
        }

        buffer = (int *)malloc((max + 1) * sizeof(int));
        for (i = 0; i < max + 1; i++)
        {
                buffer[i] = 0;
        }

        for (i = 0; i < length; i++)
        {
                buffer[array[i]]++;
        }

        for (i = 1; i < max+1; i++)
        {
                buffer[i] += buffer[i-1];
        }

        sorted = (int *)malloc(length * sizeof(int));
        for (i = length; i > 0; i--)
        {
                sorted[--buffer[array[i-1]]] = array[i-1];
        }

        for (i = 0; i < length; i++)
        {
                array[i] = sorted[i];
        }

        free(buffer);
        free(sorted);
}



//��������
int maxbit(int data[], int n) //���������������ݵ����λ��
{
    int max = 1,i; //��������λ��
    int p = 10;
    for(i = 0; i < n; ++i)
    {
        while(data[i] >= p)
        {
            p *= 10;
            ++max;
        }
    }
    return max;
}
void radix_sort(int data[], int n)   //��������
{
    int max = maxbit(data, n);   //�����е�Ԫ�ص����λ��
    int *tmp = (int *)malloc(n * sizeof(int));
    int *count = (int *)malloc(10 * sizeof(int));   //������
    int i, j, k;
    int radix = 1;

    for(i = 1; i <= max; i++)//����d������
    {
        for(j = 0; j < 10; j++)
        {
            count[j] = 0;      //ÿ�η���ǰ��ռ�����

        }

        for(j = 0; j < n; j++)
        {
            k = (data[j] / radix) % 10;   //����ÿ��ѭ��ĳһλ������
            count[k]++;    //ͳ��ÿ��Ͱ�еļ�¼��
        }

        for(j = 1; j < 10; j++)//��j��Ͱ�Լ�֮ǰ����Ͱ��Ԫ�ص�����
        {
            count[j] = count[j - 1] + count[j];
        }

        for(j = n - 1; j >= 0; j--) //������Ͱ�м�¼�����ռ���tmp��
        {
            k = (data[j] / radix) % 10;
            tmp[count[k] - 1] = data[j];
            count[k]--;
        }

        for(j = 0; j < n; j++)   //����ʱ��������ݸ��Ƶ�data��
        {
            data[j] = tmp[j];
        }
        radix = radix * 10;
    }
    free(tmp);
    free(count);
}
