package Modelo;



public class Defecto extends Requisito{
	private String informador;
	private Grado prioridad;
	private Grado severidad;
	
	public Defecto(int id) {
		super(id);
	}

	public String getInformador() {
		return informador;
	}

	public Grado getPrioridad() {
		return prioridad;
	}

	public Grado getSeveridad() {
		return severidad;
	}
	public void setInformador(String informador){
		this.informador=informador;
	}
	public void setPrioridad(Grado prioridad) {
		this.prioridad=prioridad;
	}
	public void setSeveridad(Grado severidad) {
		this.severidad=severidad;
	}

}
