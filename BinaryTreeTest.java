import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void stringCompare() {
    }

    @Test
    public void add() {
        Nodo parent= null;
        if (parent == null){
            assertNull(parent);
        } else {
            System.out.println("No es nulo");
        }
    }

    @Test
    public void findInOrder() {
        String found= "yes";
        Nodo node= null;
        assertNotSame(found,node);
    }

    @Test
    public void traverseInOrder() {
        Nodo node= null;
        if (node==null){
            boolean atras= true;
            boolean seguir=true;
            assertTrue(atras==seguir);
        }
    }
}