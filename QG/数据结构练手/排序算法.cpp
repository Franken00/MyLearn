
#include<iostream>
using namespace std;
/*
void BubbleSorting(int a[] , int n)ð�� 
{
	for(int i = 0; i < n-1; i++)
	{
		for(int j = 0; j < n-1-i; j++)
		{
			if(a[j] > a[j+1])
			{
				int tmp = a[j];
				a[j] = a[j+1];
				a[j+1] = tmp;
			}
		}
	}	
}*/


/*
void QuickSort(int a[] , int left ,int right)
{
	if(left > right)
	{
		return;
	}
	int i , j ,tmp;
	i = left;
	j = right;	
	tmp = a[left]; //�ڱ�
	6
	while(i != j) //�ڱ��������� 
	{
		while(a[j] <= tmp && i < j) //���ƶ��ұߵ��ڱ� 
		{
			j--;
		}
		while(a[i] >= tmp && i < j)
		{
			i++;
		}
		if(i < j)
		{
			int k = a[i];
			a[i] = a[j];
			a[j] = k;
		}
	}
	
	a[left] = a[j];
	a[j] = tmp;
	
	QuickSort(a ,left,i-1);
	QuickSort(a ,i+1,right);
} 
 */
/*void quickSort(int array[], int left, int right){
	if (left > right){
		return;
	}
	int i, j, temp;
	i = left;
	j = right;
	//������ߵ�����Ϊ��׼��
	temp = array[left];
	while (i != j){
		//�ȴ��ұ߿�ʼ��С��temp��Ԫ��  ע��Ⱥ�
		while (array[j] >= temp && i < j) {
			j--;
		}
		//�ٴ���߿�ʼ�Ҵ���temp��Ԫ��
		while (array[i] <= temp && i < j){
			i++;
		}
		//�����ڱ����ҵ�����Ҫ������󣬽�����������
		if (i < j){
			int change = array[i];
			array[i] = array[j];
			array[j] = change;
		}
	}
	//i==j  ����׼����λ����ʱ��׼����ߵ�����С�ڻ�׼�����ұߵ��������ڻ�׼��
	array[left] = array[j];
	array[j] = temp;
	
	//Ȼ��ݹ鴦���׼���δ����������ͻ�׼�ұߵ���
	quickSort(array, left, i-1);
	quickSort(array, i + 1, right);
 
}
*/

/*void ChoiceSort(int a[] , int N)
{
	for (int i = 0; i < N; i++)
	{
		int k = i;
		for (int j = k + 1; j < N; j++)
		{
			if (a[j] < a[k])
			{
				k = j;
			}
		}
		//�ҵ�����С��ֵ�ٽ���
		int temp = a[i];
		a[i] = a[k];
		a[k] = temp;
	}
}
*/
/*
void InsertSort(int a[] ,int N)
{
	//�ӵڶ���Ԫ�ؿ�ʼ�������һ��Ԫ��������������
	for (int i = 1; i < N; i++){
		//������Ԫ�� array[i]
		if (a[i] < a[i - 1]){
			int wait = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > wait){
				//�Ӻ���ǰ�������������飬��������Ԫ��С�ڱ�����Ԫ�أ������Ԫ�����Ųλ��
				a[j] = a[j - 1];
				j--;
			}
			a[j] = wait;
		}
	}
}*/

void Merge(int *arr, int n)
{
    int temp[n];    // ��������
    int b = 0;  // �����������ʼλ��
    int mid = n / 2;    // mid��������м仮�֣�ǰһ�����򣬺�һ������
    int first = 0, second = mid;    // �����������е���ʼλ��
 
    while (first < mid && second < n)
    {
        if (arr[first] <= arr[second])   // �Ƚ���������
            temp[b++] = arr[first++];
        else
            temp[b++] = arr[second++];
    }
 
    while(first < mid)               // ��ʣ�������и��Ƶ�����������
            temp[b++] = arr[first++];
    while(second < n)
            temp[b++] = arr[second++];
    for (int i = 0; i < n; ++i)    // �������и��Ƶ�ԭ����
        arr[i] = temp[i];
}

void MergeSort(int* s, int Num) 
{
	if(n <= 1) //�ݹ鷨�ĳ��� 
		return;
	if(n > 1)
	{
		MergeSort(a ,n/2);
		MergeSort(a + n/2 ,n - n/2);
		Merge(a , n);  //�鲢������ 
	}
}


int main()
{
	int a[10] = {3,32,2,5,5,6,46,6,2,1};
	//BubbleSorting(a,10);
	//QuickSort(a,0,9);
	//ChoiceSort(a,10); 
	//InsertSort(a ,10);
	for(int i = 0;i < 10;i++)
	{
		cout<<a[i]<<" ";
	}
	return 0;
}
