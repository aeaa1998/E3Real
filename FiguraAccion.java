public class FiguraAccion {
	private String nombre; //nombre del piloto
	private String apellido; //apellido del piloto
	public String dpi; //dpi del piloto

	public FiguraAccion(String nombre, String  apellido, String dpi){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dpi = dpi;
	}

	public String getName(){
		return nombre;
	}

	public String getApellido(){
		return apellido;
	}

}