package Modelo;

public class Tarea {
	private String nombre;
	private int idTarea;
	private String descripcion;
	private float coste;
	private float beneficio;
	private MiembrodeEquipo miembro;
	private Estado estado;
	private int sprint=-1;
	// Usar patron compuesto una tarea formada por requisitos y tareas
	public Tarea(int idTarea) {
		this.idTarea=idTarea;
		this.estado = Estado.PENDIENTES;

	}

	public void asignarMiembro(MiembrodeEquipo miembro) {
		this.miembro = miembro;
	}
	public int getIdTarea() {
		return idTarea;
	}
	public void setSprint(int sprint){
		this.sprint=sprint;
	}
	public int getSprint() {
		return sprint;
	}
	public Estado getState() {
		return estado;

	}
	public void setState(Estado estado) {
		this.estado=estado;

	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCoste() {
		return this.coste;
	}

	public float getBeneficio() {
		return this.beneficio;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public void setBeneficio(float beneficio) {
		this.beneficio = beneficio;
	}

	public MiembrodeEquipo getMiembro() {
		return miembro;
	}

	public void eliminarMiembro() {
		this.miembro = null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tarea) {
			if (this.idTarea==((Tarea) obj).getIdTarea());
				return true;
		}
		return false;
	}
}
