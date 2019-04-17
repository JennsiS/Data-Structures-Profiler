
/**
 * @author Jennifer Sandoval,Andrea Paniagua
 * @param <K>
 * @param <V>
 * @Carne 18962,18731
 * @date 16/04/19
 * @name RedBlackNode.java
 * <p></p>
 * Siddiqi, Z. (2012). A Red Black Tree Implementation in Java . Extraido de:https://github.com/Arsenalist/Red-Black-Tree-Java-Implementation
 * */


class RedBlackNode<T extends Comparable<T>> {

    /** Possible color for this node */
    public static final int BLACK = 0;
    /** Possible color for this node */
    public static final int RED = 1;
	// the key of each node
	public T key;

    /** Parent of node */
    RedBlackNode<T> parent;
    /** Left child */
    RedBlackNode<T> left;
    /** Right child */
    RedBlackNode<T> right;
    // the number of elements to the left of each node
    public int numLeft = 0;
    // the number of elements to the right of each node
    public int numRight = 0;
    // the color of a node
    public int color;

    RedBlackNode(){
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }

	// Constructor which sets key to the argument.
	RedBlackNode(T key){
        this();
        this.key = key;
	}
}