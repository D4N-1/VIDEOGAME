package tienda.modelo;

public class MetodoPago {
    private int id;
    private int usuarioId;
    private String tipo;
    private String numero;
    private String titular;
    private String vencimiento;
    private String codigoSeguridad;
    private boolean activo;

    public MetodoPago() {}

    public MetodoPago(int id, int usuarioId, String tipo, String numero, String titular, String vencimiento, String codigoSeguridad, boolean activo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.numero = numero;
        this.titular = titular;
        this.vencimiento = vencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.activo = activo;
    }

        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }

        public int getUsuarioId() {
            return usuarioId;
        }

        public void setUsuarioId(int usuarioId) {
            this.usuarioId = usuarioId;
        }
    
        public String getTipo() {
            return tipo;
        }
    
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getNumero() {
            return numero;
        }
    
        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getTitular() {
            return titular;
        }
    
        public void setTitular(String titular) {
            this.titular = titular;
        }

        public String getVencimiento() {
            return vencimiento;
        }

        public void setVencimiento(String vencimiento) {
            this.vencimiento = vencimiento;
        }

            
        public void setCodigoSeguridad(String codigoSeguridad) {
            this.codigoSeguridad = codigoSeguridad;
        }
    
        public String getCodigoSeguridad() {
            return codigoSeguridad;
        }
    
        public boolean isActivo() {
            return activo;
        }
    
        public void setActivo(boolean activo) {
            this.activo = activo;
        }
    
    

    

    

    


    

    }
    

