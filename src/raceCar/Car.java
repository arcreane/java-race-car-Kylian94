package raceCar;




import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

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
		AnsiConsole.systemInstall();
		String[] pieces = {"ROUE", "MOTEUR", "FREIN", "VOLANT"};
		int randomNum = 0 + (int)(Math.random() * ((3 - 0) + 1));
		String reparePiece = pieces[randomNum];
		System.out.println(ansi().fg(YELLOW).a("Votre " + reparePiece  + " est hors service, réparez en ecrivant " + reparePiece + " !!!"));
		scan = new Scanner(System.in);
		String response = scan.nextLine();
		
		if(response.equals(reparePiece)) {
			System.out.println(ansi().fg(YELLOW).a("Bien jouer vous avez réparer votre voiture !!!").reset());
		}
		
	}
	 public void boost() {
		AnsiConsole.systemInstall();
		System.out.println(ansi().fg(BLUE).a("obtenez le boost, vite !!!").reset());
		scan = new Scanner(System.in);
		
		long startTyping = System.nanoTime();
		
		String response = scan.nextLine();
		
		long endTyping = System.nanoTime();
		
		long timeToType = (endTyping - startTyping)/1000000;
		
		
		if(timeToType < 3000 && response.equals("VITESSE")) {
			System.out.println(ansi().fg(BLUE).a("Bien joué vous allez plus vite !!!").reset());
			this.speed = 120;
		}
		 
	 }

}
