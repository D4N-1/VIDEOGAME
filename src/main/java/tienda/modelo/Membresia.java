package tienda.modelo;

public class Membresia {
    private int id;
    private String nombre;
    private String plataforma;
    private int periodo;
    private String descripcion;


    public Membresia(int id, String nombre, String plataforma, int periodo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.periodo = periodo;
        this.descripcion = descripcion;

        
    }

    public Membresia() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataformas(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}


