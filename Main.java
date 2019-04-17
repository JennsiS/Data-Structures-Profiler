/**
 * @author Jennifer Sandoval,Andrea Paniagua
 * @Carne 18962,18731
 * @date 16/04/19
 * @name Main.java
 * <p>Clase principal que interactua con el usuario </p>
 * Fuentes utilizadas:
 * * GeeksforGeeks. (2019). Binary  Tree. Extraido de: https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
       //Ingreso de palabras al diccionario
       
         try{
                String dicc= null;
                String ingles= null;
                String espa= null;
                String nombre= "";
                String temp="";
                int cont=0;
                //Se crea un nuevo arbol binario
                //BinaryTree arbol= new BinaryTree();
                //Lectura de las palabras encontradas en el archivo diccionario
                FileReader fileReader = new FileReader("C:\\Users\\bff_n_000\\Desktop\\diccionario.txt");
                BufferedReader doc = new BufferedReader(fileReader);
                while((dicc = doc.readLine()) != null) {
                //Se crea una asociacion por cada par de palabras encontradas
                Association asociacion= new Association();
                //Se obtiene la palabra en ingles
                ingles= dicc.substring(dicc.indexOf("(")+1, dicc.indexOf(","));
                //Se obtiene la palabra en español
                espa=dicc.substring(dicc.indexOf(",")+1, dicc.indexOf(")"));
                //Se ingresa la palabra en ingles como key a la asociacion y la palabra en español como valor 
                asociacion.put(ingles,espa);
               // System.out.println(ingles);
               // System.out.println(espa);
                
                    if (cont==0){
                     arbol.add(asociacion);
                    }else{
                      arbol.add(asociacion);
                    }
                
                temp = temp + dicc + "\n";
                cont++;
                }
                 doc.close();
           //arbol.traverseInOrder(arbol.root);     
             
//--------------------------------------------------------------------------------------
//Traduccion de un archivo en ingles 
       File traduccion = new File("C:\\Users\\bff_n_000\\Desktop\\traduccion.text");
        String String1 = "";
        String String2 = "";
        String String3 = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(traduccion));

            String st;
            while ((st = br.readLine()) != null){
               String1 = st.replaceFirst("\\(", "");
               String2 = String1.replace(")","");
                String3 = String2.replace(" ","");
                String [] twoParts = String3.split(",");
               
            }

        }catch (FileNotFoundException e){
            //System.out.println("Archivo no encontrado");

        }catch (IOException e){

        }
        
         System.out.println("Palabras ordenadas in Order:");
         arbol.traverseInOrder(arbol.root);
        String[] wordsToTranslate = getWords();
        
        if (wordsToTranslate.length == 0){
            System.out.println("Intentar nuevamente");
        }
        else {
            StringBuilder finalS = new StringBuilder();
            for (String i : wordsToTranslate){
                if (arbol.findInOrder(arbol.root,i).equals("not found")){
                    finalS.append("*");
                    finalS.append(i);
                    finalS.append("*");
                    finalS.append(" ");

                }else {
                    finalS.append(arbol.findInOrder(arbol.root, i));
                    finalS.append(" ");
                }
            }
            finalS.append(".");
             System.out.println("-------------------------------------------------------------");
            System.out.println("Traducción:");
            System.out.println(finalS);
        }
           
        }
            catch(FileNotFoundException ex) {
                System.out.println("No es posible abrir" + "diccionario.txt" + "'");                
            }
        
         
    
    }
    
     public static String[] getWords(){
        File fileTranslate = new File("C:\\Users\\bff_n_000\\Desktop\\traduccion.txt");

        String[] words = new String[0];
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileTranslate));

            String st;
            while ((st = br.readLine()) != null){
                
                words = st.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                return words;
            }

        }catch (FileNotFoundException e){
            System.out.println("No se encuentra el archivo");
            return words;

        }catch (IOException e){

        }
        return words;
    }
}   
  
    