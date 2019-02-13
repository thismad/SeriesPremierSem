/*
 * Author: Mathis Dehez
 * Date: 7 janv. 2019
*/


	import java.util.Scanner;
	import java.util.ArrayList;

	class Exercice2 {
		
		private final static int NB_PROJECTS = 3;
		
		public static void main(String[] args) {
			ArrayList<Project> projects = new ArrayList<Project>();
			
			do {
				Project project = new Project();
				project.readProject();
				projects.add(project);
			} while (projects.size() < NB_PROJECTS);
		}

	}

	class Project {

		private String name = null;
		private String subject = null;
		private int duration = -1;

		public Project() {}

		private int readInt(Scanner scanner) throws WrongDurationException{
			String strNumber;
			int number;
			strNumber=scanner.nextLine();
			try {
				number=Integer.parseInt(strNumber);
			}
			catch (NumberFormatException e) {
				throw new WrongDurationException("Ce n'est pas un nombre entier!");
			}
			if (number<0) {
				throw new WrongDurationException();
			}
			return number;
		}

		private String readString(Scanner scanner) throws NameTooLongException{
			String string;
			string = scanner.nextLine();
			if (string.length()>50) {
				throw new NameTooLongException() ;
			}
			return string;
		}


		public void readProject() {
			Scanner scanner = new Scanner(System.in);
			do {
				System.out.println("Donnez le nom du projet : ");
				try {
					this.name=readString(scanner);
				}
				catch(NameTooLongException e) {
					System.out.println(e.getMessage());
				}
			} while (this.name == null);



			do {
				System.out.println("Donnez le sujet du projet : ");
				try { 
					subject=readString(scanner);	
				}
				catch(NameTooLongException e) {
					e.getMessage();
				}
			} while (this.subject==null);

			do {
				System.out.println("Donnez la durée du projet : ");
				try{
					duration = readInt(scanner);
				}
				catch(WrongDurationException e) {
					System.err.println(e.getMessage());
				}
			} while(this.duration==-1);

		}

		class WrongDurationException extends Exception{
			public WrongDurationException(String e) {
				super(e);
			}

			public WrongDurationException() {
				super("L'entier n'est pas positif!");
			}
		}

		class NameTooLongException extends Exception{
			public NameTooLongException(String e) {
				super(e);
			}

			public NameTooLongException() {
				super("Mot doit etre inférieur a 50 caractères!");
			}
		}

	}

