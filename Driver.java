import java.util.Scanner; 
import java.util.Arrays;
class Driver{
	static String[] principalMenu = {"Catalogos Aviones", "Catalogos Carros", "Pasajeros", "Cerrar Programa"};
	static String[] catalogMenu = {"Crear", "Ver"};
	static String[] catalogMenuCreation = {"0", "Todo"};
	static String[] pilotMenu = {"Mover", "Mover Con Pasajero"};
	static String[] answers = {"carro", "avion"};
	public static void main(String[] args){
		Scanner myScan = new Scanner(System.in);
		Boolean on = true;
		CatalogManager myManager = new CatalogManager();
		while (on)
		{
			String choosen = Helpers.selectOptions(myScan, principalMenu);
			if (choosen.equalsIgnoreCase(principalMenu[0])) {
				System.out.println("Ingrese que desea hacer\n");
				String choosen2 = Helpers.selectOptions(myScan, catalogMenu);
				// AVIONES
				if (choosen2.equalsIgnoreCase(catalogMenu[0])) {
					// CATALOG MENU
					String choosen3 = Helpers.selectOptions(myScan, catalogMenuCreation);
					if (choosen3.equalsIgnoreCase(catalogMenuCreation[0])) {
						myManager.createEmptyPlaneCatalog(myScan);
					}else{
						myManager.createPlaneCatalog(myScan);
					}
				}else{
					myManager.setCurrentCatalogPlane(myScan);
					myManager.showCatalogPlane();
				}
			}else if (choosen.equalsIgnoreCase(principalMenu[1])){
				System.out.println("Ingrese que desea hacer\n");
				String choosen2 = Helpers.selectOptions(myScan, catalogMenu);
				// Carros
				if (choosen2.equalsIgnoreCase(catalogMenu[0])) {
					// CATALOG MENU
					String choosen3 = Helpers.selectOptions(myScan, catalogMenuCreation);
					if (choosen3.equalsIgnoreCase(catalogMenuCreation[0])) {
						myManager.createEmptyCarCatalog(myScan);
					}else{
						myManager.createCarCatalog(myScan);
					}
				}else{
					myManager.setCurrentCatalogCar(myScan);
					myManager.showCatalogCar();
				}
			}else if (choosen.equalsIgnoreCase(principalMenu[2])){
				System.out.println("Ingrese que desea hacer\n");
				String choosen2 = Helpers.selectOptions(myScan, catalogMenu);
				// Pasajeros
				if (choosen2.equalsIgnoreCase(catalogMenu[0])) {
					myManager.createPilot(myScan);
				}else{
					System.out.println("Ingrese que desea hacer con el piloto\n");
					String choosen3 = Helpers.selectOptions(myScan, pilotMenu);
					System.out.println("Ingrese un en cual catalogo desea moverlo Carro o Avions\n");
					String choosen4 = Helpers.selectOptions(myScan, answers);
					if (choosen3.equalsIgnoreCase(pilotMenu[0])) {
						myManager.setPiloto(myScan, choosen4);
					}else{
						myManager.setPilotoWithPilot(myScan, choosen4);
					}
				}
			}else{
				System.out.println("Gracias por usar el programa");
				on = !on;
			}
		}
	}
}