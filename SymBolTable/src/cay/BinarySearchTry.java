package cay;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTry<Key extends Comparable<Key>, Value> extends AbstractSymBolTable<Key, Value> {
	class Node {
		Node left;
		Node right;
		Key keys;
		Value values;

		public Node(Key keys, Value values) {
			super();
			this.keys = keys;
			this.values = values;
		}
	}

	private Node root;
	private int count;

	@Override
	public void put(Key k, Value v) {
		root = put(root, k, v);
		count++;
		// TODO Auto-generated method stub

	}

	private Node put(Node root, Key k, Value v) {
		// TODO Auto-generated method stub
		if (root == null)
			return new Node(k, v);
		int c = k.compareTo(root.keys);
		if (c > 0) {
			root.right = put(root.right, k, v);
		} else if (c < 0) {
			root.left = put(root.left, k, v);
		} else {
			root.values = v;
		}

		return root;

	}

	@Override
	public Value get(Key k) {
		return get(root, k);
	}

	private Value get(Node root, Key k) {
		if (root == null)
			return null;
		int c = k.compareTo(root.keys);
		if (c < 0)
			return get(root.left, k);
		else if (c > 0)
			return get(root.right, k);
		else
			return root.values;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	private int chieucao(Node node) {
		if (node == null) {
			return 0;
		} else {
			int h_left = chieucao(node.left);
			int h_right = chieucao(node.right);
			// return ((h_left > h_right) ? h_left : h_right) + 1;
			if (h_left > h_right)
				return h_left + 1;

			return h_right + 1;

		}
	}

	private int sum(Node node, int k) {
		if (node != null) {
			int sum_left = sum(node.left, k);

			int sum_right = sum(node.right, k);
			if ((int) node.keys < k) {
				return (int) node.keys + sum_left + sum_right;
			}
			return sum_left + sum_right;
		}
		return 0;
	}

	public int sum(int k) {
		return sum(root, k);
	}

	public int chieucao() {
		// TODO Auto-generated method stub
		return chieucao(root);
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return keys(root);
	}

	private Iterable<Key> keys(Node n) {
		// TODO Auto-generated method stub
		List<Key> list = new ArrayList<>();
		Node node = n;
		if (node != null) {
			List<Key> l1 = (List<Key>) keys(node.left);
			list.addAll(l1);
			list.add(node.keys);
			List<Key> l2 = (List<Key>) keys(node.right);
			list.addAll(l2);

		}
		return list;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
