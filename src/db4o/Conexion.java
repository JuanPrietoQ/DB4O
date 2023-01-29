
package db4o;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

/**
 *
 * @author Juan Dario
 */
public class Conexion {
    
    private  ObjectContainer oc;
   
   private void open(){
       
       //Creacion de la base de datos 
       this.oc=Db4o.openFile("DB4O.yap");
   }
   //Metodo Insertar
   public boolean Insertar(Persona objeto){
       try{
           //Buscar si el objeto existte
           this.open();
           oc.set(objeto);
           this.oc.close();
           return true;
       }catch(DatabaseClosedException | DatabaseReadOnlyException e){
           System.out.println("bdoo.Controlador.InsertarPersona() : " +e);
           return false;
       }
   }
   
   //Metodo Consutar DB4O
   public Persona [] Consultar(Persona objeto){
       try{
           //Consulta a la base de datos y array
           Persona [] personas = null;
           this.open();
           ObjectSet resultados = this.oc.get(objeto);
           int i = 0;
           if(resultados.hasNext()){
               personas = new Persona [resultados.size()];
               while(resultados.hasNext()){
                   personas[i] = (Persona) resultados.next();
                   i++;
               }
           }
           this.oc.close();
           return personas;
       }catch(DatabaseClosedException | DatabaseReadOnlyException e){
           System.out.println("bdoo.Controlador.insertarPersona() : " +e);
           return null;
       }
   }
   
   //Metodo Eliminar
   public boolean Eliminar(Persona objeto) {
       try{
           //Busca coincidencia en la base y la elimina
           this.open();
           ObjectSet resultados = this.oc.get(objeto);
           if(resultados.size()>0){
               Persona persona = (Persona) resultados.next();
               this.oc.delete(persona);
               this.oc.close();;
               return true;
           }else{
               this.oc.close();
               return false;
           }
       }catch (DatabaseClosedException | DatabaseReadOnlyException e){
           System.out.println("bdoo.controlador.InserarPersona() : " +e);
           return false;
       }
   }
}

