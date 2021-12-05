package hangmangame;

public class Controller {
	
	static Menu menu= new Menu();
	static String category="";
	static Main main = new Main();
	
	
	public static void showMain() {
		main.setVisible(true);
		menu.setVisible(false);
	}
	
	public static void main(String[] args) {
		showMenu();
	}
	
	
	 public static void showMenu() {
		menu.setVisible(true); 
		 main.setVisible(false);
	 }	 
}
