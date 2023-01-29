
package db4o;

/**
 *
 * @author Juan Dario
 */
public class Persona {
    
    //Variables
    private String Nombres,Apellidos;
    private int Cedula, Telefono;
    
    //Constructor

    public Persona(String Nombres, String Apellidos, int Cedula, int Telefono ) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Cedula = Cedula;
        this.Telefono = Telefono;
    }
    //Setters

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    //Getters 

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public int getCedula() {
        return Cedula;
    }

    public int getTelefono() {
        return Telefono;
    }
    @Override
    public String toString(){
       return "El nombre de la persona es: "+Nombres +" "+Apellidos;
   }
}
