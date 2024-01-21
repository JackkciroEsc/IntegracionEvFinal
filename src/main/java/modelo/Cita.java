package modelo;

public class Cita {
	
	private int idMascota;
    private String rutDueno;
    private String nombreMascota;
    private String hora;
    private String fecha;
	
	public Cita(int idMascota,
    		String rutDueno,
    		String nombreMascota,
    		String hora,
    		String fecha) {
        this.idMascota = idMascota;
        this.rutDueno = rutDueno;
        this.nombreMascota = nombreMascota;
        this.hora = hora;
        this.fecha = fecha;
    }
    
    public Cita() {
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    
    public String getRutDueno() {
        return rutDueno;
    }

    public void setRutDueno(String rutDueno) {
        this.rutDueno = rutDueno;
    }

    
    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    @Override
    public String toString() {
        return "Cita{" +
                "idMascota=" + idMascota +
                ", rutDueno='" + rutDueno + '\'' +
                ", nombreMascota='" + nombreMascota + '\'' +
                ", hora='" + hora + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
