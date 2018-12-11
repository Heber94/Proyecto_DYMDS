package Modelo;

public class MiembrodeEquipo {
	private String nombre=null;
	private String apellido=null;
	private int edad=-1;
	private int id;


	public MiembrodeEquipo(int id) {
		// Singleton 1 miembro por id
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public void setApellido(String apellido) {
		this.apellido=apellido;
	}

	public void setEdad(int edad) {
		this.edad=edad;
	}
}
