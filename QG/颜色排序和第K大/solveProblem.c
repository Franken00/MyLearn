#include <stdio.h>
#include <windows.h>

void swap1(int *a, int *b)    
{  
    int temp;  
  
    temp = *a;  
    *a = *b;  
    *b = temp;  
  
    return ;  
}
int helper(int *num,int left,int right,int k)
{
	if(left == right)
	{
		return num[left];
	}
	
	int i = left,j = right;
	int pivot = num[(i + j) / 2];    //�м�ֵ 
	while(i < j)    //ʹС��pivot��������ߣ����ڵķ��ұ� 
	{
		while(i <= j && num[i] < pivot)    //������ҵ���һ�����м�ֵ����� 
		{
			i++;
		}
		while(i <= j && num[j] > pivot)    //���ұ��ҵ���һ�����м�ֵС���� 
		{
			j--;
		} 
		if(i <= j)
		{
			swap1(&num[i],&num[j]);
			i++;
			j--;
		}
	}
	if(left + k - 1 <= j)
	{
		return helper(num,left,j,k);
	}
	if(left + k - 1 <  i)
	{
		return num[left + k - 1]; 
	}
	return helper(num,i,right,k - (i - left));
}

int kthLargestElement(int k,int *num,int n)
{
	return helper(num,0,n - 1,n-k+1);
}



void colorSelect(int num[],int length)
{
    int begin = 0;
    int end = length-1;
    int cur;
    int temp,i;

    for(cur=0;cur<end;)
    {
        if(1==num[cur])
        {
            cur++;
            continue;
        }

        else if(0==num[cur])
        {
            temp=num[cur];
            num[cur]=num[begin];
            num[begin]=temp;
            begin++;
            cur++;
        }
        else
        {
            temp=num[cur];
            num[cur]=num[end];
            num[end]=temp;
            end--;
        }
    }

}
int main()
{
    int i,k,l,num,tp;
    int num1,num2;
	printf("|************menu************|\n");
	printf("|1����ɫ����                 |\n");	
	printf("|2����k������                |\n");	
	printf("|****************************|\n");
	
	while(num != 8)
	{	
		printf("������ѡ�񣺣�����8������");
		scanf("%d",&num);
		if(num == 1)
		{
			printf("���������������");
	    	scanf("%d",&k);
	    	int num[k];
	    	printf("����������(��Ϊ��ɫ������0 1 2)��");
	    	for(i = 0; i < k;i ++)
	    	{
	    		scanf("%d",&tp);
	    		num[i] = tp;
	    		
			}
			int length1 = sizeof(num)/sizeof(num[0]);
			colorSelect(num,length1);
			for(i=0;i<length1;i++)
	    	{
	    		printf("%d ",num[i]);
	    	}
	   		printf("\n");
	   		continue;
	   	}
	   	if(num == 2)
	   	{
	   		printf("���������������");
	    	scanf("%d",&k);
	    	int num[k];
	    	printf("����������(��Ϊ��ɫ������0 1 2)��");
	    	for(i = 0; i < k;i ++)
	    	{
	    		scanf("%d",&tp);
	    		num[i] = tp;	    		
			}
			printf("����õ��ڼ���Ԫ��?:\n");
			int k;
			scanf("%d",&k); 
			int x= kthLargestElement(k,num,tp);
			printf("��%d��Ϊ%d\n",k,x);
			continue;
		}
	}
	return 0; 
	system("pause");	
}

