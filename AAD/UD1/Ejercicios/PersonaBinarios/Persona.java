import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	private String usuario;
	private String correo;
	private String contrasena;

	public Persona(String usuario, String correo, String contrasena) {
		this.usuario = usuario;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	@Override
	public String toString() {
		return "Usuario: " + usuario + ", correo: " + correo;
	}
}
