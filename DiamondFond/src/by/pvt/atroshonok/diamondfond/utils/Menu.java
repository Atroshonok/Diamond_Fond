package by.pvt.atroshonok.diamondfond.utils;

import by.pvt.atroshonok.diamondfond.exceptions.IllegalMenuItemException;

public class Menu {
	private static int isCreatedPavilion;

	public static void drawMenu() {
		System.out.println("=================================================");
		System.out.println("\t<1> - Validate XML File.");
		System.out.println("\t<2> - Parse XML file by SAXParser.");
		System.out.println("\t<3> - Parse XML file by DOMParser.");
		System.out.println("\t<4> - Parse XML file by StAXParser.");
		System.out.println("\t<5> - Write pavilion data to JSONFile.");
		System.out.println("\t<6> - Transform XML file to HTML file.");
		System.out.println("\t<0> - Exit.");
		System.out.println("=================================================");
	}

	public static void performMenuItem(int menuItem) throws IllegalMenuItemException {
		switch (menuItem) {
		case 1:
			ProgrammManager.validateXMLFile();
			isCreatedPavilion++;
			break;
		case 2:
			ProgrammManager.createPavilionBySAXParser();
			isCreatedPavilion++;
			drawMenu();
			break;
		case 3:
			ProgrammManager.createPavilionByDOMParser();
			isCreatedPavilion++;
			drawMenu();
			break;
		case 4:
			ProgrammManager.createPavilionByStAXParser();
			isCreatedPavilion++;
			drawMenu();
			break;
		case 5:
			if (isCreatedPavilion != 0) {
				ProgrammManager.writePavilionDataToJSONFile();
				break;
			} else {
				System.out.println("Select please first next menu item: <2> or <3> or <4>.");
				break;
			}
		case 6:
			ProgrammManager.transformXMLToHTML();
			break;
		case 0:
			System.out.println("Exit.");
			break;
		default:
			throw new IllegalMenuItemException();
		}

	}

}
