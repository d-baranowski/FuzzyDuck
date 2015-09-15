import java.util.Scanner;

public class FuzzyDuck {
	public static final String FD = "Fuzzy Duck";
	public static final String DF = "Ducky Fuzz";
	public static final String DH = "Does He?";
	public static final String HD = "He Does!";
	public static String input;
	public static Scanner keyboard = new Scanner(System.in);
	public static String normalEntry;
	public static String oppositeEntry;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		boolean proceed = false;
		
		System.out.println("Plase enter 'start' to start the game");
		while(!proceed){
			proceed = initialPoint(keyboard.nextLine());
		}
		
		proceed = false;
		
		while(!proceed){
			proceed = chooseStartingPoint(keyboard.nextLine());
		}
		
		while(true){
			proceed = false;
			
			while(!proceed){
				proceed = DoesHe(keyboard.nextLine());
			}
			
			proceed = false;
			
			while (!proceed){
				proceed = HeDoes(keyboard.nextLine());
			}
		}
	}
	
	public static boolean initialPoint(String input) {
		if (input.equals("start")){
			if (System.currentTimeMillis() % 2 == 0){
				System.out.println(FD);
			} else {
				System.out.println(DF);
			}
			return true;
		} else { 
			return false;
		}
	}
	
	public static boolean chooseStartingPoint(String input){	
		if (input.equals(FD)){
			normalEntry = FD;
			oppositeEntry = DF;
			return true;
		}
		
		if (input.equals(DF)){
			normalEntry = DF;
			oppositeEntry = FD;
			return true;
		}
		
		System.out.println(FD + " or " + DF + " !?");
		checkGo(input,FD + " or " + DF);
		return false;
	}
	
	public static boolean DoesHe(String input){		
		if (input.equals(DH)){
			return true;
		} else if (input.equals(normalEntry)){
			return false;
		} else {
			System.out.println("Wrong !");
			checkGo(input,normalEntry);
			return false;
		}
	}
	
	public static boolean HeDoes(String input){		
		if (input.equals(HD)){
			return true;
		} else if (input.equals(oppositeEntry)){
			return false;
		} else {
			System.out.println("Wrong !");
			checkGo(input,oppositeEntry);
			return false;
		}
	}
	
	public static void checkGo(String input,String validInput){
		if (input.equals("go")){
			System.out.println(validInput + " is valid");;
		}
	}
}
