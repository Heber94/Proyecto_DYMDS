package Tarea;
import Requisitos.Requisito;
import MiembroDeEquipo.MiembrodeEquipo;;
public class Tarea {
	private String nombre;
	private char descripcion;
	private float coste;
	private float beneficio;
	private Requisito requisito;
	private MiembrodeEquipo miembro;
	private String estado;
	public Tarea(Requisito requisito) {
		
	}
	public void asignarMiembro(MiembrodeEquipo miembro,Requisito requisito) {
		
	}
	public String getState() {
		return estado;
		
	}
	
	public String getNombre() {
		return nombre;
	}
}
