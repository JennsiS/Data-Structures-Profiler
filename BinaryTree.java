import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Jennifer Sandoval,Andrea Paniagua
 * @Carne 18962,18731
 * @date 19/03/19
 * @name BinaryTree.java
 * <p>Clase que permite la implementacion de un binary tree, en el tiene metodos de insercion y de busquedad </p>
 * Fuentes utilizada:
 * baeldung. (20 de diciembre del 2018). Implementing a Binary Tree in Java. Extraido de: https://www.baeldung.com/java-binary-tree
 * GeeksforGeeks. (2019). Compare two Strings in Java. Extraido de: https://www.geeksforgeeks.org/compare-two-strings-in-java/
 * */

class Nodo{
    Association <String,String> value;
    Nodo left;
    Nodo right;
    public Nodo(Association <String,String>  value){
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinaryTree
{

    /**
     *
     */
    public static  Nodo root;

    /**
     *Constructor de la clase
     */
    public BinaryTree(){
        this.root = null;
    }

    /**
     * Metodo que compara dos Strings para ordenarlos en orden alfabetico
     * @param str1, de tipo String
     * @param str2, de tipo String
     * @return Devuelve -1 si el primer string va antes que el primero, 1 si estan bien ordenados y 0 si son iguales
     */
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

    /**
     *Metodo que permite insertar una asociacion de palabras al arbol
     * @param value, es de tipo palabras, es decir la asociacion de dos palabras e ingles y español
     */
    public void add(Association <String,String> value)
    {
        Nodo newNodo = new Nodo(value);
        if(root==null)
        {
            root = newNodo;
            return;
        }
        Nodo current = root;
        Nodo parent = null;
        while(true)
        {
            parent = current;
            int num=stringCompare(current.value.getKey(), value.getKey());
            if(num<0){
                current = current.left;
                if(current==null){
                    parent.left = newNodo;
                    return;
                }
            }else if (num>0)
            {
                current = current.right;
                if(current==null)
                {
                    parent.right = newNodo;
                    return;
                }
            }
        }
    }


    /**
     *
     * @param node, de tipo Nodo. Es un nodo del arbol
     * @param toLookFor, de tipo String y es la variable que se desea buscar en el arbol
     * @return devuelve lo que encontro, y si no encontro nada devuelve el mismo string ingresado
     */
    public String findInOrder(Nodo node, String toLookFor) {
        String found= "not found";

        if (node != null) {
            if (node.value.getKey().compareTo(toLookFor) == 0){
                return node.value.getValue();
            }else {
                found = findInOrder(node.left, toLookFor);
                if (found.compareTo("not found") == 0){
                    found = findInOrder(node.right, toLookFor);
                }
            }
        }
        return found;
    }

    /**
     *
     * @param node, tipo Nodo
     */
    public void traverseInOrder(Nodo node){
        if (node != null){
            traverseInOrder(node.left);
            System.out.println(node.value.getKey());
            traverseInOrder(node.right);
        }

    }

}