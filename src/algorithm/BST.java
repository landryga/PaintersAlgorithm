package algorithm;

/**
* Code taken from below site, however significantly changed for purpose of this project
* 
* @author Lukasz Guz
* www.algorytm.org
* 
*/

public class BST {
	public static Node root = null;      
	
	public class TreeException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		TreeException() {}
		TreeException(String msg) { super(msg); }
	}
	
	public class Node {
		Polygon polygon;
		Node left, right, parent = null;
		Node(Polygon polygon) {
			this.polygon = polygon;
		}
	}  
	
	public void insert(Polygon polygon) {       
		if(root == null)
			root = new Node(polygon);
		else {
			Node actual = root;
			Node parent = null;
			
			PolygonComparator comparator = new PolygonComparator();
			
			while(actual != null) {
				parent = actual;               
				actual = (comparator.compare(actual.polygon, polygon) == 1) ? actual.left : actual.right;                 
			}
			if(comparator.compare(parent.polygon, polygon) == 1) {
				parent.left = new Node(polygon);
				parent.left.parent = parent;
			}
			else {
				parent.right = new Node(polygon);
				parent.right.parent = parent;
			}
		}              
	}              
	
	
	public Node search(Polygon polygon) throws TreeException {
		Node actual = root;
		
		PolygonComparator comparator = new PolygonComparator();
		
		while(actual != null && !actual.polygon.equals(polygon))
			actual = (comparator.compare(actual.polygon, polygon) == 1) ? actual.left : actual.right;
		if(actual == null)
			throw new TreeException("Not Found Key");
		return actual;            
	}
	
	public Node min(Node node) {
		while(node.left != null)
			node = node.left;
		
		return node;
	}
	
	private Node max(Node node) {
		while(node.right != null)
			node = node.right;
		
		return node;
	}
	
	private Node successor(Polygon polygon) throws TreeException {
		
		Node node = this.search(polygon);  
		
		PolygonComparator comparator = new PolygonComparator();

		if(node.right != null) {           
			node = node.right;
		
			while(node.left != null)
				node = node.left;
			
			return node;
		}

		
		else if(node.right == null && node != root && node != this.max(root)) {
			Node parent = node.parent;
			while(parent != root && comparator.compare(parent.polygon, node.polygon) == 0)
				parent = parent.parent;
				
			return parent;
		}
		else
			throw new TreeException("Not Found Successor");
	}


	public Node remove(Polygon polygon) throws TreeException {
		Node node = this.search(polygon);
		Node parent = node.parent;
		Node tmp;
		
		if(node.left != null && node.right != null) {
			tmp = this.remove(this.successor(polygon).polygon);
			tmp.left = node.left;
			
			if(tmp.left != null)
				tmp.left.parent = tmp;
			tmp.right = node.right;
			
			if(tmp.right != null)
				tmp.right.parent = tmp;
		}
		else
		tmp = (node.left != null) ? node.left : node.right;
		
		if(tmp != null)
			tmp.parent = parent;
		
		if(parent == null)
			root = tmp;
		
		else if(parent.left == node)
			parent.left = tmp;
		
		else
			parent.right = tmp;
		
		return node;
	}

}
