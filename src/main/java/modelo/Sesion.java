package main.java.modelo;

import java.time.LocalDateTime;


public class Sesion {
    private int id;
    private int usuarioId;
    private String token;
    private LocalDateTime inicioSesion;
    private LocalDateTime expiracion;
    private String ip;
    private String dispositivo;
    private boolean activa;


    public Sesion() {}

    public Sesion(int id, int usuarioId, String token, LocalDateTime inicioSesion, LocalDateTime expiracion, String ip, String dispositivo, boolean activa) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.token = token;
        this.inicioSesion = inicioSesion;
        this.expiracion = expiracion;
        this.ip = ip;
        this.dispositivo = dispositivo;
        this.activa = activa;
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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    
        public LocalDateTime getInicioSesion() {
            return inicioSesion;
        }

        public void setInicioSesion(LocalDateTime inicioSesion) {
            this.inicioSesion = inicioSesion;
        }
    
        public LocalDateTime getExpiracion() {
            return expiracion;
        }
    
        public void setExpiracion(LocalDateTime expiracion) {
            this.expiracion = expiracion;
        }
    

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    
        public String getDispositivo() {
            return dispositivo;
        }

        public void setDispositivo(String dispositivo) {
            this.dispositivo = dispositivo;
        }
    
        public boolean isActiva() {
            return activa;
        }

        public void setActiva(boolean activa) {
            this.activa = activa;
        }
    }
    
    

