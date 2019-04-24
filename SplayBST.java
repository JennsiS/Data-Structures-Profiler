
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

public class SplayBST {
    public Node root;   // root of the BST

    // BST helper node data type
    private class Node {
        private String key;            // key
        private String value;        // associated data
        private Node left, right;   // left and right subtrees

        public Node(String key, String value) {
            this.key   = key;
            this.value = value;
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

    public boolean contains(String key) {
        return get(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    
    
    public String get(String key) {
        String not="not found";
        root = splay(root, key);
        int num= stringCompare(root.key, key);
        if (num==0){
            return root.value;
        } else{
            return  not;
        }
    } 
   

   /***************************************************************************
    *  Splay tree insertion.
    ***************************************************************************/
    public void put( Association <String,String> association) {
        // splay key to root
        if (root == null) {
            root = new Node(association.getKey(), association.getValue());
            return;
        }
        
        root = splay(root, association.getKey());
        
        int num=stringCompare(root.key, association.getKey());
        
        // Insert new node at root
        if (num < 0) {
            Node n = new Node(association.getKey(), association.getValue());
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insert new node at root
        else if (num > 0) {
            Node n = new Node(association.getKey(), association.getValue());
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else {
            root.value = association.getValue();
        }

    }
    
 
    public void remove(String key) {
        if (root == null) return; // empty tree
        
        root = splay(root, key);

        int num=stringCompare(root.key, key);
        if (num == 0) {
            if (root.left == null) {
                root = root.right;
            } 
            else {
                Node x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }

        // else: it wasn't in the tree to remove
    }
    
   
    private Node splay(Node h, String key) {
        if (h == null) return null;

        int cmp1=stringCompare(h.key, key);
        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.left.key);
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

            int cmp2=stringCompare(h.right.key, key);
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