public class Persona {
    private String nombre;
    private String nacimiento;
    private char sexo;

    public Persona(String nombre, String nacimiento, char sexo) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
    }

    public Persona(String nombre, String nacimiento) {
        this(nombre, nacimiento, 'X');
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String sexoString() {
        if (sexo == 'M') return "Masculino";
        if (sexo == 'F') return "Femenino";
        return "No especificado";
    }

    public String datos() {
        return nombre + " (" + sexoString() + ") - " + nacimiento;
    }

    public String soloNombre() {
        return nombre;
    }

    public String toString() {
        return datos();
    }
}