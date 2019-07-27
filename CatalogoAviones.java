class CatalogoAviones {
	Avion[] planes; //Dueño del catalogo
	String owner;//Nombre del catalogo
	String name;//Aviones del catalogo
	public CatalogoAviones(String[] _fabs, String[] _models, Double[] _reachs, String[] _owners , int[] _helices, String _name, String _catalogOwner) {
		planes = new Avion[3];
		planes[0] = new Avion(_fabs[0], _models[0], _reachs[0], _owners[0], _helices[0]);
		planes[1] = new Avion(_fabs[1], _models[1], _reachs[1], _owners[1], _helices[1]);
		planes[2] = new Avion(_fabs[2], _models[2], _reachs[2], _owners[2], _helices[2]);
		owner = _catalogOwner;
		name = _name;

	};

	public CatalogoAviones(String [] _owners, String _name, String _catalogOwner) {
		planes = new Avion[3];
		planes[0] = new Avion(_owners[0]);
		planes[1] = new Avion(_owners[1]);
		planes[2] = new Avion(_owners[2]);
		owner = _catalogOwner;
		name = _name;

	};

	public String getName(){
		return name;
	}

	public String getOwner(){
		return owner;
	}

	public void setOwner(String _owner){
		this.owner = _owner;
	}


	public Avion getPlane(int _plane){
		return planes[_plane];
	}

	public void showPlanes(){
		System.out.println("NOMBRE DEL CATALOGO: "+ name +"\n");
		System.out.println("DUENO DEL CATALOGO: "+ owner +"\n");

		for (int i = 0; i < 3; i++) { 
			System.out.println("Avion: "+ (i+1) +"\n");

			Avion plane = planes[i];
			plane.desplegar();
			System.out.println("\n");

		}
	}

	public void showAllPlanes(){
		System.out.println("NOMBRE DEL CATALOGO: "+ name +"\n");
		System.out.println("DUENO DEL CATALOGO: "+ owner +"\n");
		for (int i = 0; i < 3; i++) {
			System.out.println("Avion: "+ (i+1) +"\n");
			Avion plane = planes[i];

			System.out.println((i+1) + ") " + plane.getModel()  + ".\n");
			System.out.println("\n");
		}
	}

	public void choosePlane(int _plane){
		System.out.println("Avion numero " + (_plane + 1) + " .\n");
		Avion choosen = planes[_plane];
		choosen.desplegar();
	}	
	public void choosePlane(int _plane, int _times){
		System.out.println("Avion numero " + (_plane + 1) + " .\n");
		Avion choosen = planes[_plane];
		if (_times == -1) {
			choosen.girarHelices();
		}else{
			choosen.girarHelices(_times);
		}
	}
}