/*
 * Author: Mathis Dehez
 * Date: 8 janv. 2019
*/

public class Exercice4 {
	
		
		/*Expliquer pourquoi ce code ne compile pas
		*/
		public void m1() {
			foo();
		}
		
		public int foo() throws Exception {
			throw new Exception();
		}
		//Il manque le try pour lancer foo
		
		
		
		/*Expliquer pourquoi ce code n'est pas considéré comme bon
		*/
		public void m2() {
			try {
				//do stuff...
			} catch (Exception e) {
				
			}
			//car on a pas l'info sur le type d'exception levé
		}
		
		/*Expliquer pourquoi ce code ne compile pas
		*/
		public void m3() {
			try {
				//do stuff...
			} catch (Exception e) {
				
			} catch (NullPointerException e) {
				
			}
			//le catch 2 ne sera pas executé car NullPointerException extends Exception
		}
		
		/*Expliquer pourquoi ce code ne compile pas
		*/
		public void m4() {
			throw new CustomCheckedException();
		}
		//il manque le throws
		
		
		private class CustomCheckedException extends Exception {
			
			private static final long serialVersionUID = -7944813576443065516L;

			public CustomCheckedException() {
				//nothing
			}
			//Il manque le super
			
		}
		
		/*Expliquer pourquoi ce code ne compile pas
		*/
		public int m5() {
			int age;
			String s = "24";
			try {
				age = getAccessCode();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return age;
			//si throw error alors age n'est pas initialisée
		}
		
		public int getAccessCode() throws IllegalAccessException {
			throw new IllegalAccessException();
		}
		
		/*Expliquer pourquoi ce code COMPILE
		*/
		public void m6() {
			bar();
		}
		
		public int bar() {
			throw new RuntimeException();
		}
		//car les RunTimeException et les Errors n'ont pas besoin d'etre catch car elles aretent le programme
	}



