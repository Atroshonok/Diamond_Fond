package by.pvt.atroshonok.diamondfond.main;

import java.util.Scanner;

import by.pvt.atroshonok.diamondfond.utils.Menu;

public class ProgrammRunner {

	public static void main(String[] args) {

		boolean isExit = false;
		Menu.drawMenu();
		Scanner scanner =null;
		while (!isExit) {
			scanner = new Scanner(System.in);
			try {
				int menuItem = scanner.nextInt();
				Menu.performMenuItem(menuItem);
				if (menuItem == 0) {
					isExit = true;
				}
			} catch (Exception e) {
				System.out.println("Select correct menu item!!!");
			}
		}
		if (scanner != null) {
			scanner.close();
		}

	}
}
