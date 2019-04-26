
/**
 * @author Jennifer Sandoval,Andrea Paniagua
 * @param <K>
 * @param <V>
 * @Carne 18962,18731
 * @date 16/04/19
 * @name SplayBST.java
 * <p></p>
 * Fuentes utilizadas:
 * Israel,J. (2017). Splay Tree. Extraido de: https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
 * */

public class SplayBST <Key extends Comparable<Key>,Value extends Comparable<Value>> {
    public Node root;   // root of the BST

    // BST helper node data type
    private class Node {
        private Association<Key,Value> asociacion;
        private Node left, right;   // left and right subtrees

        public Node(Key key, Value value) {
            asociacion = new Association(key,value);
}
    }
     public static int stringCompare(String str1, String str2) 
    {
        int l1 = str1.length();
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
         
        if (l1 != l2) { 
            return l1 - l2; 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    } 

    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    
    
    public Value get(Key key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.asociacion.key);
        if (cmp == 0) return root.asociacion.value;
        else return null;
    } 
   

   /***************************************************************************
    *  Splay tree insertion.
    ***************************************************************************/
    public void put( Key key, Value value) {
       if (root == null) {
            root = new Node(key, value);
            return;
        }
        
        root = splay(root, key);

        int cmp = key.compareTo(root.asociacion.key);
        
        // Insert new node at root
        if (cmp < 0) {
            Node n = new Node(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            Node n = new Node(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else {
            root.asociacion.value = value;
}
        }

        // else: it wasn't in the tree to remove
   
    
   private Node splay(Node h, Key key) {
        if (h == null) return null;

        int cmp1 = key.compareTo(h.asociacion.key);

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.left.asociacion.key);
            if (cmp2 < 0) {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null)
                    h.left = rotateLeft(h.left);
            }
            
            if (h.left == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) { 
            // key not in tree, so we're done
            if (h.right == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.right.asociacion.key);
            if (cmp2 < 0) {
                h.right.left  = splay(h.right.left, key);
                if (h.right.left != null)
                    h.right = rotateRight(h.right);
            }
            else if (cmp2 > 0) {
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }
            
            if (h.right == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
}


    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
}

    
   public int size() {
        return size(root);
}
    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    // right rotate
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    // left rotate
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
}
    

    
}