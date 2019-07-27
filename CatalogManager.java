import java.util.ArrayList;
import java.util.Scanner; 

class CatalogManager {
	ArrayList <CatalogoCarros>  carCatalogs = new ArrayList<CatalogoCarros>();
	ArrayList <FiguraAccion>  pilots = new ArrayList<FiguraAccion>();
	ArrayList <CatalogoAviones>  planesCatalogs = new ArrayList<CatalogoAviones>();
	CatalogoCarros currentCatalogCar;
	CatalogoAviones currentCatalogPlane;
	public CatalogManager() {

	};


	public void setCurrentCatalogCar(Scanner scanner){
		if (!carCatalogs.isEmpty()) {
			int index = this.getCatalogIndex(scanner, "carro");
			currentCatalogCar = carCatalogs.get(index);
			currentCatalogCar.showCars();
		}else {
			System.out.println("No hay catalogos");
		}
	}

	public void setCurrentCatalogPlane(Scanner scanner){
		if (!planesCatalogs.isEmpty()) {
			int index = this.getCatalogIndex(scanner, "avion");
			currentCatalogPlane = planesCatalogs.get(index);
		}else{
			System.out.println("No hay catalogos");
		}
	}

	public void showCatalogPlane(){
		if (!planesCatalogs.isEmpty()) {
			currentCatalogPlane.showPlanes();
		}
	}
	public void showCatalogCar(){
		if (!carCatalogs.isEmpty()) {
			currentCatalogCar.showCars();
		}
	}

	public void setPiloto(Scanner scanner, String currentCatalog){
		if (currentCatalog == "carro" && !carCatalogs.isEmpty() && !pilots.isEmpty()) {
			int pilotIndex = this.getCatalogIndex(scanner, "piloto");
			int carCatalogIndex = this.getCatalogIndex(scanner, "carro");
			carCatalogs.get(carCatalogIndex).showAllCars();
			int carInt = Helpers.intPositiveInput(scanner, "Escoja un numero valido", "Escoja un carro válido", 3);
			Carro carc = carCatalogs.get(carCatalogIndex).getCar(carInt - 1);
			this.changePilot(carc, pilots.get(pilotIndex));
		}else if(!planesCatalogs.isEmpty() && !pilots.isEmpty()){
			int pilotIndex = this.getCatalogIndex(scanner, "piloto");
			int planesCatalogIndex = this.getCatalogIndex(scanner, "avion");
			planesCatalogs.get(planesCatalogIndex).showAllPlanes();
			int planeInt = Helpers.intPositiveInput(scanner, "Escoja un numero valido", "Escoja un avion válido", 3);
			Avion planec = planesCatalogs.get(planesCatalogIndex).getPlane(planeInt -1);
			this.changePilot(planec, pilots.get(pilotIndex));
		}else{
			System.out.println("El catalogo seleccionado esta vacio o no hay pilotos para mover");
		}
	}

	public void setPilotoWithPilot(Scanner scanner, String currentCatalog){
		int pilotIndex = this.getCatalogIndex(scanner, "piloto");
		if (currentCatalog == "carro") {
			int carCatalogIndex = this.getCatalogIndex(scanner, "carro");
			carCatalogs.get(carCatalogIndex).showAllCars();
			int carInt = Helpers.intPositiveInput(scanner, "Escoja un numero valido", "Escoja un carro válido", 3);
			Carro carc = carCatalogs.get(carCatalogIndex).getCar(carInt-1);
			this.changePilot(carc, pilots.get(pilotIndex), pilots.get(pilotIndex));
		}else{
			int planesCatalogIndex = this.getCatalogIndex(scanner, "avion");
			planesCatalogs.get(planesCatalogIndex).showAllPlanes();
			int planeInt = Helpers.intPositiveInput(scanner, "Escoja un numero valido", "Escoja un avion válido", 3);
			Avion planec = planesCatalogs.get(planesCatalogIndex).getPlane(planeInt-1);
			this.changePilot(planec, pilots.get(pilotIndex), pilots.get(pilotIndex));
		}
	}

	private void changePilot(Carro car, FiguraAccion actionFigure){
		car.setPiloto(actionFigure);
	}
	private void changePilot(Avion plane, FiguraAccion actionFigure){
		plane.setPiloto(actionFigure);
	}
	public void changePilot(Carro car, FiguraAccion actionFigure, FiguraAccion actionFigure2){
		if (car.getAcceptPassenger()) {
			car.setPiloto(actionFigure);
			System.out.println("Tiene Pasajero.");
		}
			System.out.println("No puede llevar Pasajero.");
	}
	public void changePilot(Avion plane, FiguraAccion actionFigure, FiguraAccion actionFigure2){
		if (plane.getAcceptPassenger()) {
			plane.setPiloto(actionFigure);
			System.out.println("Tiene Pasajero.");
		}
			System.out.println("No puede llevar Pasajero.");
	}
	public void changePilot(Carro car, Carro car2, FiguraAccion actionFigure){
		
	}
	public void changePilot(Avion plane, Avion plane2, FiguraAccion actionFigure){
		
	}
	private int getCatalogIndex(Scanner scanner, String _string){
		this.showCatalog(_string);
		int length = 0;
		if (_string != "piloto") {
			length = (_string == "carro") ? carCatalogs.size() : planesCatalogs.size();
		}else{
			length = pilots.size();
		}
		return Helpers.intPositiveInput(scanner, "Ingrese el numero de " + _string, "Escoja un numero valido", length) - 1;
	}

	private void showCatalog(String _catalog){
		if (_catalog == "carro") {
			if (!carCatalogs.isEmpty()) {
				System.out.println("Escoja el numero.");
				for (int i = 0; i < carCatalogs.size(); i ++) {
					System.out.println((i+1) + ") " + carCatalogs.get(i).getName() + "\n");
				}
			}else{
				System.out.println("No hay catalogos de carros.");
			}
		}else if (_catalog == "avion"){
			if (!planesCatalogs.isEmpty()) {
				System.out.println("Escoja el numero.");
				for (int i = 0; i < planesCatalogs.size(); i ++) {
					System.out.println((i+1) + ") " + planesCatalogs.get(i).getName() + "\n");
				}
			}else{
				System.out.println("No hay catalogos de aviones.");
			}
		}else{
			if (!pilots.isEmpty()) {
				System.out.println("Escoja el numero.");
				for (int i = 0; i < pilots.size(); i ++) {
					FiguraAccion pilotoC = pilots.get(i);
					System.out.println((i+1) + ") " + pilotoC.getName() + " " + pilotoC.getApellido() + "\n");
				}
			}else{
				System.out.println("No hay pilotos.");
			}
		}
	}

	public void createPilot(Scanner scanner){
		System.out.println("Ingrese el nombre del piloto.");
		String pName = scanner.nextLine();
		System.out.println("Ingrese el apellido del piloto.");
		String pLastName = scanner.nextLine();
		System.out.println("Ingrese el dpi del piloto.");
		String pDpi = scanner.nextLine();
		pilots.add(new FiguraAccion(pName,  pLastName, pDpi));
	}

	public void createEmptyPlaneCatalog(Scanner scanner){
		System.out.println("Ingrese el nombre del dueno del primer avion.");
		String owner1 = scanner.nextLine();
		System.out.println("Ingrese el nombre del dueno del segundo avion.");
		String owner2 = scanner.nextLine();
		System.out.println("Ingrese el nombre del dueno del tercer avion.");
		String owner3 = scanner.nextLine();
		System.out.println("Ingrese el nombre del dueno del catalogo.");
		String ownerCatalog = scanner.nextLine();
		System.out.println("Ingrese el nombre del catalogo.");
		String nameCatalog = scanner.nextLine();
		String[] owners = new String[3];
		owners[0] = owner1;
		owners[1] = owner2;
		owners[2] = owner3;
		planesCatalogs.add(new CatalogoAviones(owners, nameCatalog, ownerCatalog));
	}
	public void createEmptyCarCatalog(Scanner scanner){
		System.out.println("Ingrese el nombre del dueno del primer carro.");
		String owner1 = scanner.nextLine();
		System.out.println("Ingrese el nombre del dueno del segundo carro.");
		String owner2 = scanner.nextLine();
		System.out.println("Ingrese el nombre del dueno del tercer carro.");
		String owner3 = scanner.nextLine();
		System.out.println("Ingrese el nombre del dueno del catalogo.");
		String ownerCatalog = scanner.nextLine();
		System.out.println("Ingrese el nombre del catalogo.");
		String nameCatalog = scanner.nextLine();
		String[] owners = new String[3];
		owners[0] = owner1;
		owners[1] = owner2;
		owners[2] = owner3;
		carCatalogs.add(new CatalogoCarros(owners, nameCatalog, ownerCatalog));
	}

	public void createCarCatalog(Scanner scanner){
		String[] owners = new String[3];
		String[] models = new String[3];
		String[] fabs = new String[3];
		Double[] reachs = new Double[3];
		int[] wheels = new int[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("Ingrese el fabricante " + i + ".");
			fabs[i] = scanner.nextLine();
			System.out.println("Ingrese el modelo " + i + ".");
			models[i] = scanner.nextLine();
			reachs[i] = Helpers.doubleInput(scanner, "Ingrese el alcance del carro " + i, "Ingrese un valor valido", 0.0);
			wheels[i] = Helpers.intPositiveInput(scanner, "Ingrese las llantas del carro " + i, "Ingrese un valor valido");
			System.out.println("Ingrese el nombre del dueno " + i + ".");
			owners[i] = scanner.nextLine();
		}
		System.out.println("Ingrese el nombre del dueno del catalogo.");
		String ownerCatalog = scanner.nextLine();
		System.out.println("Ingrese el nombre del catalogo.");
		String nameCatalog = scanner.nextLine();
		carCatalogs.add(new CatalogoCarros(fabs, models, reachs, owners , wheels,  nameCatalog,  ownerCatalog));
	}

	public void createPlaneCatalog(Scanner scanner){
		String[] owners = new String[3];
		String[] models = new String[3];
		String[] fabs = new String[3];
		Double[] reachs = new Double[3];
		int[] helices = new int[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("Ingrese el fabricante " + i + ".");
			fabs[i] = scanner.nextLine();
			System.out.println("Ingrese el modelo " + i + ".");
			models[i] = scanner.nextLine();
			reachs[i] = Helpers.doubleInput(scanner, "Ingrese el alcance del carro " + i, "Ingrese un valor valido", 0.0);
			helices[i] = Helpers.intPositiveInput(scanner, "Ingrese la cantidad de llantas del carro " + i, "Ingrese un valor valido");
			System.out.println("Ingrese el nombre del dueno " + i + ".");
			owners[i] = scanner.nextLine();
		}
		System.out.println("Ingrese el nombre del dueno del catalogo.");
		String ownerCatalog = scanner.nextLine();
		System.out.println("Ingrese el nombre del catalogo.");
		String nameCatalog = scanner.nextLine();
		planesCatalogs.add(new CatalogoAviones(fabs, models, reachs, owners , helices,  nameCatalog,  ownerCatalog));
	}

}