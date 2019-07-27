class CatalogoCarros {
	String owner; //Dueño del catalogo
	String name; //Nombre del catalogo
	Carro[] cars; //Carros del catalogo
	public CatalogoCarros(String[] _fabs, String[] _models, Double[] _reachs, String[] _owners , int[] _wheels, String _name, String _catalogOwner) {
		cars = new Carro[3];
		cars[0] = new Carro(_fabs[0], _models[0], _reachs[0], _owners[0], _wheels[0]);
		cars[1] = new Carro(_fabs[1], _models[1], _reachs[1], _owners[1], _wheels[1]);
		cars[2] = new Carro(_fabs[2], _models[2], _reachs[2], _owners[2], _wheels[2]);
		owner = _catalogOwner;
		name = _name;
	};

	public CatalogoCarros(String [] _owners, String _name, String _catalogOwner) {
		cars = new Carro[3];
		cars[0] = new Carro(_owners[0]);
		cars[1] = new Carro(_owners[1]);
		cars[2] = new Carro(_owners[2]);
		owner = _catalogOwner;
		name = _name;
	};

	public void showAllCars(){
		System.out.println("NOMBRE DEL CATALOGO: "+ name +"\n");
		System.out.println("DUENO DEL CATALOGO: "+ owner +"\n");
		for (int i = 0; i < 3; i++) {
			System.out.println("Carro: "+ (i+1) +"\n");
			Carro car = cars[i];
			System.out.println((i+1) + ") " + car.getModel()  + ".\n");
			System.out.println("\n");
		}
	}

	public String getName(){
		return name;
	}

	public String getOwner(){
		return owner;
	}

	public void setOwner(String _owner){
		this.owner = _owner;
	}

	public Carro getCar(int _car){
		return cars[_car];
	}

	public void setCar(int _car, Carro _carObject){
		cars[_car] = _carObject;
	}

	public void showCars(){
		System.out.println("NOMBRE DEL CATALOGO: "+ name +"\n");
		System.out.println("DUENO DEL CATALOGO: "+ owner +"\n");
		for (int i = 0; i < 3; i++) {
			System.out.println("Carro: "+ (i+1) +"\n");

			Carro car = cars[i];
			car.correr();
			System.out.println("\n");
		}
	}


	public void chooseCar(int _carNumber){
		System.out.println("Carro numero " + (_carNumber + 1) + " .\n");
		Carro choosen = cars[_carNumber];
		choosen.correr();
	}	
	public void chooseCar(int _carNumber, int _times){
		System.out.println("Carro numero " + (_carNumber + 1) + " .\n");
		Carro choosen = cars[_carNumber];
		if (_times == -1) {
			choosen.girarLlantas();
		}else{
			choosen.girarLlantas(_times);
		}
	}
}