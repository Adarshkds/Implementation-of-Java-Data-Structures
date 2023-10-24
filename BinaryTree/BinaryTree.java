package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTree.BinaryTree.node;

public class BinaryTree {
	Scanner sc = new Scanner(System.in);

	public class node {
		int val;
		node left;
		node right;
	}

	node root;

	public BinaryTree() {
		root = createTree();
	}

	private node createTree() {
		node nn = new node();
		nn.val = sc.nextInt();
		boolean left = sc.nextBoolean();
		if (left) {
			nn.left = createTree();
		}
		boolean right = sc.nextBoolean();
		if (right) {
			nn.right = createTree();
		}

		return nn;
	}

	public void display() {
		display(root);
	}

	private void display(node nn) {
		if (nn == null) {
			return;
		}

		String str = "<--" + nn.val + "-->";
		if (nn.left != null) {
			str = nn.left.val + str;
		} else {
			str = "." + str;
		}

		if (nn.right != null) {
			str += nn.right.val;
		} else {
			str += ".";
		}

		System.out.println(str);
		display(nn.left);
		display(nn.right);
	}

	public boolean find(int n) {
		return find(n, root);
	}

	private boolean find(int n, node nn) {
		if (nn == null) {
			return false;
		}

		if (nn.val == n) {
			return true;
		}

		return find(n, nn.left) || find(n, nn.right);
	}

	public int max() {
		return max(root);
	}

	private int max(node nn) {
		if (nn == null) {
			return Integer.MIN_VALUE;
		}

		return Math.max(max(nn.left), Math.max(max(nn.right), nn.val));

	}

	public int ht() {
		return ht(root);
	}

	private int ht(node nn) {
		if (nn == null) {
			return -1;
		}

		return Math.max(ht(nn.left), ht(nn.right)) + 1;
	}

	public void preOrder() {
		pre(root);
	}

	private void pre(node nn) {
		if (nn == null) {
			return;
		}

		System.out.print(nn.val + " ");

		pre(nn.left);
		pre(nn.right);
	}

	public void postOrder() {
		post(root);
	}

	private void post(node nn) {
		if (nn == null) {
			return;
		}

		post(nn.left);
		post(nn.right);
		System.out.print(nn.val + " ");
	}

	public void inOrder() {
		in(root);
	}

	private void in(node nn) {
		if (nn == null) {
			return;
		}

		in(nn.left);
		System.out.print(nn.val + " ");
		in(nn.right);
	}

	public void levelOrder() {
		level(root);
	}

	private void level(node nn) {
		Queue<node> q = new LinkedList<node>();
		q.add(nn);
		while (!q.isEmpty()) {
			node rv = q.poll();
			System.out.print(rv.val + " ");
			if (rv.left != null) {
				q.add(rv.left);
			}
			if (rv.right != null) {
				q.add(rv.right);
			}
		}
	}

	public static void main(String[] args) {
		// 10 true 20 true 40 false false true 150 false false true 30 false true 60
		// true 70 false false false
		BinaryTree bt = new BinaryTree();
		bt.display();
		System.out.println(bt.find(70));
		System.out.println(bt.max());
		System.out.println(bt.ht());
		bt.preOrder();
		System.out.println();
		bt.postOrder();
		System.out.println();
		bt.inOrder();
		System.out.println();
		bt.levelOrder();
	}
}
