#ifndef SORT_H_INCLUDED
#define SORT_H_INCLUDED


#define DATAONE  10000
#define DATATWO  50000
#define DATATHREE  200000


typedef struct stackNode{  //���ŷǵݹ��㷨��Ҫʹ�õ�ջ�ڵ�
    int low;
    int high;
}stackNode;

//����
void insertion_sort(int array[], int length);

//����
void quick_sort(int array[], int length);
void quick_sortRe(int array[], int left, int right);

//���ŷǵݹ�
void QuickSort_NO(int array[],int length);
void QuickSort_Nore(int array[],int aLow,int aHigh,int length);
int split(int array[],int low,int high);


//�鲢
void merge_sort(int array[], int length);//����
void merge_sort_recursive(int array[], int reg[], int start, int end);

//��������
void counting_sort(int array[], int length);

int maxbit(int data[], int n);//������������ݵ�λ��
void radix_sort(int data[], int n);   //��������

int testSortTime(void (foo)(int array[],int length),int length);
void printTest(char *name);


#endif // SORT_H_INCLUDED
