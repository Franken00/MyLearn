
class BinaryTreeNode {
	BinaryTreeNode(){
		left = right = null;
	}
	BinaryTreeNode(int el){
		element = el;
		left = right = null;
	}
	int element;
	BinaryTreeNode left,right;
}

public class BinaryTree {
	//���ڵ�
	BinaryTreeNode root;
	//���Ĵ�С
	int size = 0;
	//���췽��
	BinaryTree(){
		root = null;
	}
	BinaryTree(BinaryTreeNode root){
		this.root = root;
	}
	
	//����ڵ�
	public void insertTree(int key, BinaryTreeNode root) {
		BinaryTreeNode p = root, pre = null;
		//�ҵ�����ڵ�λ��
		while(p != null) {
			pre = p;
			if(key < p.element) {
				p = p.left;
			}else p = p.right;
		}
		//1������ǿ��������൱�봴���½ڵ�
		if(root == null) {
			root = new BinaryTreeNode(key);
		}
		//2������
		else if(key < pre.element) {
			pre.left = new BinaryTreeNode(key); 
		}
		else  pre.right = new BinaryTreeNode(key); 
	}
	
	//���ҽڵ�
	public BinaryTreeNode searchTree(int key,BinaryTreeNode root) {
		BinaryTreeNode p = root;
		while(p != null) {
			//����ֱ�ӷ���p
			if(key == p.element) {
				return p;
			}
			//����p�����ߣ�С��p������
			else if(key < p.element) {
				p = p.left;
			}else p = p.right;
		}
		return null;
	}
	
	//����
	//visit�������ʽڵ�
	public void visit(BinaryTreeNode node) {
		System.out.println(node.element);
	}
	//ǰ�����
	public void preorder(BinaryTreeNode node) {
		if(node != null) {
			visit(node);
			preorder(node.left);
			preorder(node.right);		
		}
	}
	//�������
	public void inorder(BinaryTreeNode node) {
		if(node != null) {
			inorder(node.left);
			visit(node);
			inorder(node.right);				
		}
	}
	//�������
	public void postorder(BinaryTreeNode node) {
		 if(node != null) {
			 postorder(node.left);
			 postorder(node.right);
			 visit(node);			
		 }
	}
	
	//ɾ���ڵ�
	//�ϲ�ɾ�� 1
	public void deleteByMerging(BinaryTreeNode node) {
		BinaryTreeNode p = node;
		if(node != null) {
			if(node.right == null) {		//����������������������ӵ����ڵ�
				node = node.left;
			}
			else if(node.left == null) {
				node = node.right;
			}
			else {
				p = node.left;
				while(p.right != null) {
					p = p.right;
				}
				p.right = node.right;
				p = node;
				node = node.left;
			}
		}
	}
	//�ϲ�ɾ�� 2
	public void findAndDeleteByMerging(int key) {
		BinaryTreeNode p = root, pre = null;
		//�Ȳ��ҵ��ڵ�λ��
		while(p != null) {
			if(p.element == key) {
				break;
			}
			pre = p;
			if(p.element < key) {
				p = p.right;
			}else p = p.left;
		}
		//�ڽ�������ɾ��
		if(p != null && p.element == key) {
			if(p == root) {
				deleteByMerging(root);
			}
			else if(pre.left == p) {
				deleteByMerging(pre.left);
			}
			else if(pre.right == p) {
				deleteByMerging(pre.right);
			}
		}
		else if(root != null) {
			System.out.println("key = "+key+"is not in the tree");
		}
	}
	
	//����ɾ��
	public void deleteByCopying(BinaryTreeNode node) {
		BinaryTreeNode pre, tmp;
		if(node.right == null) {
			node = node.left;
		}
		else if(node.left == null) {
			node = node.right;
		}
		else {
			tmp = node.left;
			pre = node;
			while(tmp.right != null) {
				pre = tmp;
				tmp = tmp.right;
			}
			node.element = tmp.element;
			if(pre == node) {
				pre.left = tmp.left;
			}
			else pre.right = tmp.right;
		}
	}
}
