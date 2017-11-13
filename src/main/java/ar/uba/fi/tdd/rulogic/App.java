package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

import java.util.Scanner;

/**
 * Console application.
 *
 */
public class App {
	public static void main(String[] args) {

        KnowledgeBase kb;
	    String in;

        Scanner sin = new Scanner (System.in);

		kb = new KnowledgeBase();

        System.out.println("Ingrese query a chequear.");
        System.out.println("Para salir ingrese Quit()");

        while(true){
            in = sin.nextLine ();
		    if(in.equals("Quit()")){
		        break;
            } else{
//                System.out.println(in);
                System.out.println(kb.answer(in));
            }
        }

        System.out.println("Programa terminado");

    }
}
