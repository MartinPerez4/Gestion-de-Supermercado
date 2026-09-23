public class Cliente {
    private String nombre;
    private String documentoIdentidad;
    private String telefono;
    private String email;
    private String comprasRealizadas;

    public Cliente (String nombre, String documentoIdentidad, String telefono, String email, String comprasRealizadas){
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.email = email;
        this.comprasRealizadas = comprasRealizadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(String comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }
}
