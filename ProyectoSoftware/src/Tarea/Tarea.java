package Tarea;
import Requisitos.Requisito;

import java.util.ArrayList;
import java.util.List;

import MiembroDeEquipo.MiembrodeEquipo;;
public class Tarea {
	private String nombre;
	private String descripcion;
	private float coste;
	private float beneficio;
	private List<Requisito> requisitos;
	private MiembrodeEquipo miembro;
	private Estado estado;
	//Usar patron compuesto una tarea formada por requisitos y tareas
	public Tarea(String nombre) {
		this.nombre=nombre;
		this.estado=Estado.PENDIENTES;
		requisitos=new ArrayList<Requisito>();
		
	}
	public void asignarMiembro(MiembrodeEquipo miembro) {
		this.miembro=miembro;
	}
	public Estado getState() {
		return estado;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	public float getCoste() {
		return this.coste;
	}
	public float getBeneficio() {
		return this.beneficio;
	}
	public void setCoste(float coste) {
		this.coste=coste;
	}
	public void setBeneficio(float beneficio) {
		this.beneficio=beneficio;
	}
	public MiembrodeEquipo getMiembro() {
		return miembro;
	}
	public void eliminarMiembro() {
		this.miembro=null;
	}
	
	public void añadirRequisito(Requisito requisito) {
		this.requisitos.add(requisito);
	}
	public void eliminarRequisito(Requisito requisito) {
		for(int i =0;i<requisitos.size();i++) {
			if(requisitos.get(i).equals(requisito)) {
				requisitos.remove(i);
			}
		}
	}
	public List<Requisito> consultarRequisitos(){
		return requisitos;
	}
	public boolean equals(Tarea tarea) {
		if (this.nombre.equals(tarea.getNombre())){
			return true;
		}else return false;
		
	}
}
