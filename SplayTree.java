public class SplayTree<E extends Comparable<E>>
        extends BinarySearchTree<E> implements OrderedStructure<E>
{
    public SplayTree()
    // post: construct a new splay tree
    public SplayTree(Comparator<E> alternateOrder)
    // post: construct a new splay tree
    public void add(E val)
    // post: adds a value to the binary search tree
    public boolean contains(E val)
    // post: returns true iff val is a value found within the tree
    public E get(E val)
    // post: returns object found in tree, or null
    public E remove(E val)
    // post: removes one instance of val, if found
    protected void splay(BinaryTree<E> splayedNode)
    public Iterator<E> iterator()
// post: returns iterator that traverses tree nodes in order
}

