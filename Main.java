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
import java.util.StringTokenizer;

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
                String s2="";
                //Se crea un nuevo arbol binario
                SplayBST arbol= new SplayBST();
                //Lectura de las palabras encontradas en el archivo diccionario
                FileReader fileReader = new FileReader("C:\\Users\\bff_n_000\\Desktop\\diccionary.dic");
                BufferedReader doc = new BufferedReader(fileReader);
                StringBuilder separador = new StringBuilder();
                Association asociacion= new Association();
                /*
                while((dicc = doc.readLine()) != null) {
                    //Se crea una asociacion por cada par de palabras encontradas
                    
                    //Se obtiene la palabra en ingles
                    StringTokenizer st = new StringTokenizer (dicc);
                    while (st.hasMoreTokens()){
                          s2 = st.nextToken();
                         numTokens= numTokens+1;
                            if (numTokens==1){
                                ingles=s2;
                                System.out.println (ingles);
                            } else if(numTokens==2){
                                espa=s2;
                                System.out.println (espa);
                            }
                           asociacion.put(ingles,espa);
                           arbol.put(asociacion);
                          
                           }  
              }
     */
                     while((dicc = doc.readLine())!= null){
               separador.append(dicc);
               separador.append(System.lineSeparator());
               dicc += " ";
                String valor = "";
               for(int i=1;i<dicc.length();i++){
                   String temp = dicc.substring((i-1),i);  //Para verificar cada caracter de la linea
                   if(temp.equals("\t")){
                       ingles = dicc.substring(0,i-1).toUpperCase(); //Se obtiene la palabra en ingles
                       espa = dicc.substring(i,dicc.length()).toUpperCase();
                       for(int j=1;j<espa.length();j++){
                           String temp2 = espa.substring((j-1),j);
                           if(temp2.equals(" ")||temp2.equals(";")){
                               valor = espa.substring(0,j-1).toUpperCase();
                               break;
                           }else{
                               valor = espa;
                           }
                           asociacion.put(ingles,espa);
                           arbol.put(asociacion);
                       }
                       
                             
                   }
               }
                     
}
                
              doc.close();
         
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
     
        System.out.println (arbol.size());
        String[] wordsToTranslate = getWords();
        
        if (wordsToTranslate.length == 0){
            System.out.println("Intentar nuevamente");
        }
        else {
            StringBuilder finalS = new StringBuilder();
            
            for (String i : wordsToTranslate){
                if (arbol.get(i).equals("not found")){
                    finalS.append("*");
                    finalS.append(i);
                    finalS.append("*");
                    finalS.append(" ");

                }else {
                    finalS.append(arbol.get(i));
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
  
    
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
                
    

                