package raceCar;


import java.util.*;

public class Car {
	
	String color;
	Integer speed;
	Integer resist = 100;
	Float distance = (float) 0;
	Scanner scan;
	
	public Car(String color, Integer speed) {
		this.color = color;
		this.speed = speed;
	}
	
	public void repare() {
		String[] pieces = {"ROUE", "MOTEUR", "FREIN", "VOLANT"};
		int randomNum = 0 + (int)(Math.random() * ((3 - 0) + 1));
		String reparePiece = pieces[randomNum];
		System.out.println("Votre " + reparePiece  + " est hors service, réparez en ecrivant " + reparePiece + " !!!");
		scan = new Scanner(System.in);
		String response = scan.nextLine();
		
		if(response.equals(reparePiece)) {
			System.out.println("Bien jouer vous avez réparer votre voiture !!!");
		}
		
	}
	 public void boost() {
		 
		System.out.println("obtenez le boost, vite !!!");
		scan = new Scanner(System.in);
		
		long startTyping = System.nanoTime();
		
		String response = scan.nextLine();
		
		long endTyping = System.nanoTime();
		
		long timeToType = (endTyping - startTyping)/1000000;
		
		
		if(timeToType < 3000 && response.equals("VITESSE")) {
			System.out.println("Bien joué vous allez plus vite !!!");
			this.speed = 120;
		}
		 
	 }

}
