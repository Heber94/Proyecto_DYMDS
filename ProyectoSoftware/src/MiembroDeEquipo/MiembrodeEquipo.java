package MiembroDeEquipo;

public class MiembrodeEquipo {
	private String nombre;
	private String apellido;
	private int edad;
	private int id;


	public MiembrodeEquipo(String nombre, String apellido, int edad, int id) {
		// Singleton 1 miembro por id
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
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

}
