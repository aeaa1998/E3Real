public class Carro {
	private String fabricante; //Propiedades que describen al avion
	private String modelo; //Propiedades que describen al avion
	private FiguraAccion piloto; //Piloto de dicho avion
	private double alcance; //Propiedades que describen al avion
	private String numeroDeLlantas; //Propiedades que describen al avion
	private int numero; //Propiedades que describen al avion
	private Boolean aceptaPasajeros; //Propiedades indica si se puede subir o no un


	public Carro(String _dueno){
		fabricante = "";
		modelo = "";
		alcance = 0;
		dueno = _dueno;
		numeroDeLlantas = 0;
		aceptaPasajeros = false;
		piloto = null;
	}

	public Carro(String _fabricante, String  _modelo, double _alcance, String _dueno, int _numeroDeLlantas){
		fabricante = _fabricante;
		modelo = _modelo;
		alcance = _alcance;
		dueno = _dueno;
		numeroDeLlantas = _numeroDeLlantas;
		aceptaPasajeros = true;
		piloto = null;

	}
	public String getModel(){
		return modelo;
	}

	public void correr() {
		System.out.print("dueño -> (" + dueno + ")\n");
		System.out.print("fabricante -> (" + fabricante + ")\n");
		System.out.print("modelo -> (" + modelo + ")\n");
		System.out.print("alcance -> (" + alcance + ") Kms\n");
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

	public void setPiloto(FiguraAccion _pilot, FiguraAccion _pilot2){
		if (this.aceptaPasajeros == true) {	
			this.piloto = _pilot;
			System.out.println("Va con pasajero\n");
		}

	}
	public void girarLlantas(int _times){
		if (numeroDeLlantas > 0) {
			if (_times > 0) {
				for (int i = 0; i < _times; i++) {
					System.out.println("Giro las llantas\n");
				}
					System.out.println("Giro las llantas un numero de " + _times +"\n");
			} else{
					System.out.println("No giro las llantas ya que ingreso un numero menor o igual a 0.\n");
			}
		}else{
			System.out.println("No tiene llantas\n");
		}
	}
	public void girarLlantas(){
		if (numeroDeLlantas > 0) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Giro las llantas\n");
			}
				System.out.println("Giro las llantas un numero de 5 veces. \n");
		}else{
			System.out.println("No tiene llantas\n");
		}
	}
}