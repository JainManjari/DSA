package BST;



class Triplet<Integer,Boolean>
{
	int max;
	int min;
	boolean isBST;
	
}

class BTNode<T>
{
	public T data;
	public BTNode<T> left;
	public BTNode<T> right;
	
	public BTNode(T data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}

public class BST {
	
	public static boolean isBSTout(BTNode<Integer> root)
	{
		return isBST(root).isBST;
	}
	
	public static Triplet<Integer,Boolean> isBST(BTNode<Integer> root)
	{
		if(root==null)
		{
			Triplet<Integer,Boolean> t=new Triplet();
			t.max=Integer.MIN_VALUE;
			t.min=Integer.MAX_VALUE;
			t.isBST=true;
			return t;
		}
		Triplet<Integer,Boolean> l=isBST(root.left);
		Triplet<Integer,Boolean> r=isBST(root.right);
		Triplet<Integer,Boolean> t=new Triplet();
		t.max=Math.max(root.data,Math.max(l.max, r.max));
		t.min=Math.min(root.data,Math.min(l.min, r.min));
		t.isBST=(l.isBST && r.isBST && (l.max<root.data) && (r.min>=root.data));
		return t;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
