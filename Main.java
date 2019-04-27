/**
 * @author Jennifer Sandoval,Andrea Paniagua
 * @Carne 18962,18733
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
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
         try{
                String dicc= null;
                String ingles= null;
                String espa= null;
                SplayBST<String,String> arbolsplay = null; 
                RedBlackTree<String,String> arbolRB = null; 
                Scanner scanner = new Scanner(System.in);
                
                /*******************************************************/
                //Lectura de las palabras encontradas en el archivo diccionario
                FileReader fileReader = new FileReader("diccionary.dic");
                BufferedReader doc = new BufferedReader(fileReader);
                StringBuilder separador = new StringBuilder();
                Association asociacion= new Association();
                int elegido=0;
                
                /***********************Menu************************/
                System.out.println("Elegir la forma en la que desea de guardar el diccionario");
                System.out.println("1.Splay Tree 2.Red Black Tree");
                int op = scanner.nextInt();
                scanner.nextLine();
                switch (op) {   //Factory para crear un arbol Splay Tree o Red Black Tree
                    case 1:
                        {
                            arbolsplay = new SplayBST<>();
                            elegido = 1;
                            break;
                        }
                    case 2:
                        {
                            arbolRB = new RedBlackTree<>();
                            elegido = 2;
                            break;
                        }
                    default:
                        System.out.println("Ha ingresado una opcion que no es valida");
                        break;
                }
                
               /*Separador de palabras en el diccionario */
               while((dicc = doc.readLine())!= null){
               separador.append(dicc);
               separador.append(System.lineSeparator());
               dicc += " ";
               String valor = "";
               for(int i=1;i<dicc.length();i++){
                   String temp = dicc.substring((i-1),i);  //Para verificar cada caracter de la linea
                   if(temp.equals("\t")){
                       ingles = dicc.substring(0,i-1).toLowerCase(); //Se obtiene la palabra en ingles
                       espa = dicc.substring(i,dicc.length()).toLowerCase();
                       for(int j=1;j<espa.length();j++){
                           String temp2 = espa.substring((j-1),j);
                           if(temp2.equals(" ")||temp2.equals(";")){
                               valor = espa.substring(0,j-1).toLowerCase();
                               break;
                           }else{
                               valor = espa;
                           }
                           if(elegido==1){
                            arbolsplay.put(ingles, espa); //Ingresar una pareja de Llave-valor al diccionario de splay
                           }else{
                            arbolRB.put(ingles, espa); //Ingresar una pareja de Llave-valor al diccionario de RBT
                           }
                       }
                    }
               }                
        }
                
              doc.close();
              
        /**************************************Traduccion***************************/
        File traduccion = new File("traduccion.text");
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
     
       //System.out.println (arbolsplay.size());
       //System.out.println (arbolRB.size());
       
       
       
        String[] wordsToTranslate = getWords();
        //Buscar los valores en el splay tree
        if (elegido==1){
             if (wordsToTranslate.length == 0){
            System.out.println("Intentar nuevamente");
        }
        else {
            StringBuilder finalS = new StringBuilder();
            
            for (String i : wordsToTranslate){
                if (arbolsplay.get(i)==(null)){
                    finalS.append("*");
                    finalS.append(i);
                    finalS.append("*");
                    finalS.append(" ");

                }else {
                    finalS.append(arbolsplay.get(i));
                    finalS.append(" ");
                }
            }
            finalS.append(".");
             System.out.println("-------------------------------------------------------------");
            System.out.println("Traducción:");
            System.out.println(finalS);
        }
        }
        //Buscar los valores en el RBT
        if (elegido==2){
             if (wordsToTranslate.length == 0){
            System.out.println("Intentar nuevamente");
        }
        else {
            StringBuilder finalS = new StringBuilder();
            
            for (String i : wordsToTranslate){
                if (arbolRB.get(i)==(null)){
                    finalS.append("*");
                    finalS.append(i);
                    finalS.append("*");
                    finalS.append(" ");

                }else {
                    finalS.append(arbolRB.get(i));
                    finalS.append(" ");
                }
            }
            finalS.append(".");
             System.out.println("-------------------------------------------------------------");
            System.out.println("Traducción:");
            System.out.println(finalS);
        }
        }
        
        
       
        // System.out.println(arbolRB.get("april")); 
         
        }
            catch(FileNotFoundException ex) {
                System.out.println("No es posible abrir" + "diccionario.txt" + "'");                
            } 
        
         
    
    }
    
     public static String[] getWords(){
        File fileTranslate = new File("traduccion.txt");

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
    