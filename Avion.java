public class Avion {
	private String fabricante; //Propiedades que describen al avion
	private String modelo; //Propiedades que describen al avion
	private FiguraAccion piloto; //Piloto de dicho avion
	private double alcance; //Propiedades que describen al avion
	private String dueno; //Propiedades que describen al avion
	private int numeroDeHelices; //Propiedades que describen al avion
	private Boolean aceptaPasajeros; //Propiedades indica si se puede subir o no un

public Avion(String _dueno){
		fabricante = null;
		modelo = null;
		alcance = 0;
		dueno = _dueno;
		numeroDeHelices = 0;
	}

	public Avion(String _fabricante, String  _modelo, double _alcance, String _dueno, int _numeroDeHelices){
		fabricante = _fabricante;
		modelo = _modelo;
		alcance = _alcance;
		dueno = _dueno;
		numeroDeHelices = _numeroDeHelices;
	}
	public String getModel(){
		return modelo;
	}
	public Boolean getAcceptPassenger(){
		return aceptaPasajeros;
	}
	public void setAcceptPassenger(Boolean _bool){
		this.aceptaPasajeros = _bool;
	}
	public FiguraAccion getPiloto(){
		return piloto;
	}
	public void setPiloto(FiguraAccion _pilot){
		this.piloto = _pilot;
		System.out.println("Se seteo el piloto\n");
	}
	public void desplegar() {
		System.out.print("dueño -> (" + dueno + ")\n");
		System.out.print("fabricante -> (" + fabricante + ")\n");
		System.out.print("modelo -> (" + modelo + ")\n");
		System.out.print("alcance -> (" + alcance + ") Kms\n");
	}

	public void girarHelices(int _times){
		if (numeroDeHelices > 0) {
			if (_times > 0) {
				for (int i = 0; i < _times; i++) {
					System.out.println("Giro las helices\n");
				}
					System.out.println("Giro las helices un numero de " + _times +"\n");
			} else{
					System.out.println("No giro las helices ya que ingreso un numero menor o igual a 0.\n");
			}
		}else{
			System.out.println("No tiene helices\n");
		}
	}
	public void girarHelices(){
		if (numeroDeHelices > 0) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Giro las helices\n");
			}
				System.out.println("Giro las helices un numero de 5 veces. \n");
		}else{
			System.out.println("No tiene helices\n");
		}
	}
}