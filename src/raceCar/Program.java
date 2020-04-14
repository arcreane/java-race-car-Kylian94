package raceCar;

import raceCar.Car;

import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Program {
	
	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		Scanner scan;
		Car firstCar = new Car("bleu", 100);
		Car secondCar = new Car("jaune", 50);
		Integer finish = 0;
		Integer time = 59;
		
		System.out.println(" ");
		System.out.println("*-----------------------------*");
		System.out.println("*-----------------------------*");
		System.out.println("*-         Race Car          -*");
		System.out.println("*-----------------------------*");
		System.out.println("*-----------------------------*");
		System.out.println(" ");
		System.out.println("Vous avez le choix :");
		System.out.println(" - Voiture Jaune : vitesse 100km/h mais qui risque de tomber en panne...");
		System.out.println(" - Voiture Bleue : vitesse 50km/h et qui possède des boosts pouvant aller jusqu'à 120km/h !");
		System.out.println(" ");
		System.out.println("Choisissez votre voiture et que le meilleur gagne !!");
		System.out.println(" ");
		System.out.println("Tapez 1 pour la voiture Jaune et 2 pour la voiture Bleue");
		scan = new Scanner(System.in);
		String response = scan.nextLine();
	
		if(response.equals("1")) {
			//System.out.println(firstCar.color);
			
			while(finish < 50) {
				
				for(int i=0; i <= time;i++ ) {
					
					Random rand = new Random();
					
					int percentBreak = rand.nextInt(100);
					
					if(percentBreak <= 60) {
						firstCar.repare();
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					time -= 1;
					firstCar.distance = firstCar.distance + (float) firstCar.speed/60;
					finish += Math.round(firstCar.distance);
					
					System.out.println(ansi().fg(YELLOW).a("Distance parcouru " + firstCar.distance + " km").reset());
				}
				
				int duration = 59-time;
				System.out.println(ansi().fg(YELLOW).a("Distance parcouru " + Math.round(firstCar.distance) + " km en " + duration + " minutes").reset());
		
			}
			
		} else {
			//System.out.println(secondCar.color);
			
			while(finish < 50) {
				
				for(int i=0; i <= time;i++ ) {
					
					Random rand = new Random();
					
					int percentBreak = rand.nextInt(100);
					
					if(percentBreak <= 30) {
						secondCar.boost();
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					time -= 1;					
					secondCar.distance += (float) secondCar.speed/60;
					finish += Math.round(secondCar.distance);
					
					System.out.println(ansi().fg(BLUE).a("Distance parcouru " + secondCar.distance + " km").reset());
				}
				
				int duration = 59-time;
				System.out.println(ansi().fg(BLUE).a("Distance parcouru " + Math.round(secondCar.distance) + " km en " + duration + " minutes").reset());	
			}
			
		} 
		
	}

}
