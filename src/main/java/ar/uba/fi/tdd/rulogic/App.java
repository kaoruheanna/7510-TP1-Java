package ar.uba.fi.tdd.rulogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

/**
 * Console application.
 *
 */
public class App
{
	public static void main(String[] args) {
		System.out.println("I shall answer all your questions!");
		BufferedReader br = null;
		FileReader fr = null;
		String filePath = "src/main/resources/";
		
		System.out.println("Ingrese la db:");

		try {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
					
			fr = new FileReader(filePath+input);
			br = new BufferedReader(fr);

			// base
			KnowledgeBase base = new KnowledgeBase();
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				base.learn(sCurrentLine);
			}
			System.out.println("base cargada");
			
			input = scanner.nextLine();
			while (input != null){
				if (base.answer(input)) {
					System.out.println("SI");
				} else {
					System.out.println("NO");
				}
				input = scanner.nextLine();
			}

		} catch (IOException e) {
			e.printStackTrace();	
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    }
}
