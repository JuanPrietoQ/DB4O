
package db4o;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Dario
 */
public class Controlador extends Conexion {
    
    //Metodo Insertar Persona
    public boolean InsertarPersonas(String Nombres, String Apellidos, int Cedula, int Telefono){
        Persona persona = new Persona(Nombres, Apellidos, Cedula, Telefono);
        return this.Insertar(persona);
    }
    //Array ordenamiento
    public DefaultTableModel personas(){
        String titulos[] = {"CEDULA", "NOMBRES", "APELLIDOS", "TELEFONO"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Persona persona = null;
        Persona[] p = this.Consultar(persona);
        if(p!= null){
            for (Persona per : p){
                Object[] cli = new Object[4];
                cli[0] = per.getCedula();
                cli[1] = per.getNombres();
                cli[2] = per.getApellidos();
                cli[3] = per.getTelefono();
                dtm.addRow(cli);        
            }
        }
        return dtm;        
    }
    //Metodo Eliminar Persona
    public boolean EliminarPersona(int Cedula){
        if(Cedula>0){
            Persona persona = new Persona(null, null, Cedula, 0);
            return this.Eliminar(persona);
        }else{
            return false;
        }
    }
    
}
