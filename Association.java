import java.util.*;
/**
 * @author Jennifer Sandoval,Andrea Paniagua
 * @param <K>
 * @param <V>
 * @Carne 18962,18733
 * @date 16/04/19
 * @name Association.java
 * <p>Clase que permite la asociacion de palabras por medio de HashMaps</p>
 * */

public class Association<K,V> implements Map.Entry<K,V> {

    K key; 
    V value;
    private HashMap<K,V> association;

    /**
     *
     * @param key
     * @param value
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }
	
    /**
     *Constructor
     */
    public Association() {
		association = new HashMap<K,V>();
    }
    
    public V getValue(){
        return value;
    }

    public K getKey() {
        return key;
    }

    public V setValue(V val) {
        V prevValue = value;
        value = val;
        return prevValue;
    }
    
    /**
     *Metodo que permite ingresar la llave y el valor al map
     * @param key, de tipo generico. Se refiere a la llave en un map
     * @param value, de tipo generico.Se refiere al valor de la llave mencionada
     */
    public void put(K key, V value){
            this.key = key;
            this.value = value;
            association.put(key,value);
            
        
	}
	
    /**
     *Metodo que permite obtener la clave del map
     * @param key, de tipo objeto
     * @return devuelve lo que se encuentra en la key del map
     */
    public V get(Object key){
		return association.get(key);
	}
}
