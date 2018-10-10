#ifndef BinaryTREE_H
#define BinaryTREE_H 

typedef char TElemType;     // �������������Ԫ������Ϊ�ַ�

typedef struct 
{
   TElemType *elem;     // 0�ŵ�Ԫ����
   int lastIndex;              // ���������һ�����ı��
} SqBiTree;    // ˳��洢�Ķ�����

typedef struct  BiTNode 
{
    TElemType      data;     // ������
    struct BiTNode  *lchild,*rchild;  // ���Һ���ָ��
} BiTNode,*BiTree;   // ��������

typedef enum Status
{
    SUCCESS,ERROR
}Status;

void InitBiTree(BiTree T);
//�������������ն�����T
Status DestroyBiTree(BiTree T);
//��ʼ������������T����
//����������ݻٶ�����T
BiTree CreateBiTree(BiTree T);
//��ʼ������ definition�����������Ķ���
//�����������definition���������T


//���²��ֺ�������δָ����������
void PreOrderTraverse(BiTree T);
//��ʼ������������T���ڣ�visitΪ�Խ��Ĳ�����Ӧ�ú���
//����������������T����ÿ��������visit����һ���ҽ�һ�Σ�һ��visitʧ�ܣ������ʧ��
void InOrderTraverse(BiTree T);	//�������
void PostOrderTraverse(BiTree  T);	//�������
void LevelOrderTraverse(BiTree  T);	//�������
int Value(BiTNode T);			//������Ķ�������ֵ

//��ʾ�����ڽ��ṹ�������ø�Tagֵ��־������������������������
//�ɸ�����Ҫ�������Ӳ���.

BiTree CreateBiTree(BiTree T); 

int zhuanhua(char c);

int build_tree(char *st, int beg, int end);
float calculate(char *st, int beg); 

#endif
