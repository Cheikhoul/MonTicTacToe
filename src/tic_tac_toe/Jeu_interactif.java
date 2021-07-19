package tic_tac_toe;
import java.util.Scanner;


/**
 * @author cheikhoul
 * 
 */
public class Jeu_interactif {

	/**
	 * Méthode main pour jouer contre l'ordinateur, Pour determiner le niveau
	 * de difficulté, consulter la classe Solver.
	 * 
  	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//La table de jeu qu'on va utiliser
		Board tableJeu = new Board(new int[][]{
			{-1, -1, -1},
			{-1, -1, -1},
			{-1, -1, -1}});
		
		//Les joueurs
		int p1 = 0; 
		int p2 = 1;
		int currentPlayer = p1;
		
		int c = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(tableJeu.initialtoString());
		
		while (!tableJeu.isOver()){
			
			if (currentPlayer == p1) {
				System.out.println("*************************************************************");
				System.out.println("Joueur " + currentPlayer +
						" - Tapez un nombre entre 1 et 9: \n" );
				
				c = scan.nextInt();
				try {
					if((c < 1) || (c > 9))
						break;
				}
				catch(Exception e){
					
				}
				switch (c) {
					case 1 : if (tableJeu.table[0][0] == -1) 
									tableJeu.table[0][0] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 2 : if (tableJeu.table[0][1] == -1 )
									tableJeu.table[0][1] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 3 : if (tableJeu.table[0][2] == -1 )
								tableJeu.table[0][2] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 4 : if (tableJeu.table[1][0] == -1) 
								tableJeu.table[1][0] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 5 : if (tableJeu.table[1][1] == -1 )
								tableJeu.table[1][1] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 6 :  if (tableJeu.table[1][2] == -1 )
								tableJeu.table[1][2] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 7 : if (tableJeu.table[2][0] == -1)
								tableJeu.table[2][0] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 8 : if(tableJeu.table[2][1] == -1 )
								tableJeu.table[2][1] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;
					case 9 : if(tableJeu.table[2][2] == -1 )
								tableJeu.table[2][2] = currentPlayer;
							else System.out.println("\nPosition illégalle ! Case déjà occupée ! \nPénalité - Vous sautez le tour !");
						break;	
					}
					
				System.out.println(tableJeu.toString());
				
				if (tableJeu.Owins()) {
					System.out.println("Félicitations ! Le joueur " + currentPlayer + " a gagné!" );
				}
				else if(!tableJeu.Xwins() && tableJeu.isOver()) {
					System.out.println("Réessayer une autre fois ! Vous y êtes presque !" );
				}
				
				currentPlayer = p2;
				//scan.close();	
			}
			else {
				System.out.println("Joueur " + currentPlayer +
						" - AUTO \n" );
				Solver IA = new Solver(tableJeu);
				tableJeu = IA.nextBoard; 
				System.out.println(tableJeu.toString());				
				if (tableJeu.Xwins()) {
					System.out.println("Dommage ! Le joueur " + currentPlayer + " a gagné!" );
				}
				else if(!tableJeu.Owins() && tableJeu.isOver()) {
					System.out.println("Réessayer une autre fois ! Vous y êtes presque !" );
				}
				
				currentPlayer = p1;
			}
				
		}
		scan.close();
	}

}
	
