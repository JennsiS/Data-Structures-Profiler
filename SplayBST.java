
/**
 * @author Jennifer Sandoval,Andrea Paniagua
 * @param <Key>
 * @param <Value>
 * @Carne 18962,18733
 * @date 16/04/19
 * @name SplayBST.java
 * <p>Implementacion de splay tree</p>
 * Fuentes utilizadas:
 * Israel,J. (2017). Splay Tree. Extraido de: https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
 * */

public class SplayBST<Key extends Comparable<Key>,Value extends Comparable<Value>>  {

    private Node root;   // root of the BST

    // BST helper node data type
    private class Node {
        private Association<Key,Value> asociacion;
        private Node left, right;   // left and right subtrees

        public Node(Key key, Value value) {
            asociacion = new Association(key,value);
        }
    }

    /**
     *
     * @param key
     * @return un valor true o false para saber si contiene la llave indicada
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null

    /**
     *
     * @param key
     * @return un valor de tipo Value, si no lo encuentra devuelve null
     */
    public Value get(Key key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.asociacion.key);
        if (cmp == 0) return root.asociacion.value;
        else          return null;
    }    

   /***************************************************************************
    *  Splay tree insertion.
     * @param key
     * @param value
    ***************************************************************************/
    public void put(Key key, Value value) {
        // splay key a la raiz
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        
        root = splay(root, key);

        int cmp = key.compareTo(root.asociacion.key);
        
        // Insertar un nuevo nodo a la raiz
        if (cmp < 0) {
            Node n = new Node(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insertar un nuevo nodo a la raiz
        else if (cmp > 0) {
            Node n = new Node(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // Si es un valor duplicado solo reemplazar el valor
        else {
            root.asociacion.value = value;
        }

    }
    
   /***************************************************************************
    *  Splay tree deletion.
     * @param key
    ***************************************************************************/
  
    public void remove(Key key) {
        if (root == null) return; // empty tree
        
        root = splay(root, key);

        int cmp = key.compareTo(root.asociacion.key);
        
        if (cmp == 0) {
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

        // else: no se encontraba en el arbol para removerlo
    }
    
    
   /***************************************************************************
    * Splay tree function.
    * **********************************************************************/
  /*metodo splay interno*/
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


   /***************************************************************************
    *  Helper functions.
     * @return retorna un valor de tipo int con la altura del arbol 
    ***************************************************************************/

    // height of tree (1-node tree has height 0)
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     *
     * @return devuelve un valor de tipo int con el tamaño del arbol
     */
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