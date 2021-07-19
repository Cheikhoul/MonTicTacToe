package tic_tac_toe;

import java.util.ArrayList;

public class Board {
	
	private final int N;
	protected int[][] table;
	
	/**
	 * constructeur de Board.
	 * @param table Tableau pour reperer les différentes positions
	 * sur le platau. 
	 * 0 -> 'O'
	 * 1 -> 'X'
	 * -1 -> '' 
	 * */
	public Board(int[][] table) {
		N = table.length;
		this.table = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				this.table[i][j] = table[i][j];
			}
		}
	}
	
    /**
	 * max_score evalue les positions des pions du joueur max
	 * sur l'ensemble du plateau.
	 * @return le score du joueur max
	 */
	public int max_score() {
		int score = 0;
		int k = 0;
		int l = 0;
		//score de la 1ere a la 6e ligne
		for(int i = 0; i < N; i++) {
			k = 0;
			l = 0;
			for(int j = 0; j < N; j++) {
				if(table[i][j] == 1) {
					++k;
				}
				if(table[j][i] == 1) {
					++l;
				}
			}
			switch (k) {
			case 0 : score += 0;
			break;
			case 1 : score += 1;
			break;
			case 2 : score += 10;
			break;
			case 3 : score += 10000;
			break;
			}
			switch (l) {
			case 0 : score += 0;
			break;
			case 1 : score += 1;
			break;
			case 2 : score += 10;
			break;
			case 3 : score += 10000;
			break;
			}
		}
		//score sur la 7e ligne
		k = 0;
		for(int i = 0; i < N; i++) {
				if(table[i][i] == 1) {
					++k;
				}
		}
		switch (k) {
		case 0 : score += 0;
		break;
		case 1 : score += 1;
		break;
		case 2 : score += 10;
		break;
		case 3 : score += 10000;
		break;
		}
		//score sur la 8e ligne
		k=0;
		int j = 2;
		for(int i = 0; i < N; i++) {
			if(table[i][j] == 1) {
				++k;
			}
			j--;
		}
		switch (k) {
		case 0 : score += 0;
		break;
		case 1 : score += 1;
		break;
		case 2 : score += 10;
		break;
		case 3 : score += 10000;
		break;
		}
		if (score>=10000)
			score = 10000;
		return score;
	}
	
    /**
	 * min_score evalue les positions des pions du joueur min
	 * sur l'ensemble du plateau.
	 * @return le score du joueur min
	 */
	public int min_score() {
		int score = 0;
		int k = 0;
		int l = 0;
		//score de la 1ere a la 6e ligne
		for(int i = 0; i < N; i++) {
			k = 0;
			l = 0;
			for(int j = 0; j < N; j++) {
				if(table[i][j] == 0) {
					++k;
				}
				if(table[j][i] == 0) {
					++l;
				}
			}
			switch (k) {
			case 0 : score += 0;
			break;
			case 1 : score += 1;
			break;
			case 2 : score += 10;
			break;
			case 3 : score += 10000;
			break;
			}
			switch (l) {
			case 0 : score += 0;
			break;
			case 1 : score += 1;
			break;
			case 2 : score += 10;
			break;
			case 3 : score += 10000;
			break;
			}
		}
		//score sur la 7e ligne
		k = 0;
		for(int i = 0; i < N; i++) {
				if(table[i][i] == 0) {
					++k;
				}
		}
		switch (k) {
		case 0 : score += 0;
		break;
		case 1 : score += 1;
		break;
		case 2 : score += 10;
		break;
		case 3 : score += 10000;
		break;
		}
		//score sur la 8e ligne
		k=0;
		int j = 2;
		for(int i = 0; i < N; i++) {
			if(table[i][j] == 0) {
				++k;
			}
			j--;
		}
		switch (k) {
		case 0 : score += 0;
		break;
		case 1 : score += 1;
		break;
		case 2 : score += 10;
		break;
		case 3 : score += 10000;
		break;
		}
		if (score>=10000)
			score = 10000;
		return score;
	}
	
    /**
	 * eval evalue les positions des pions du joueur max
	 * et du joueur min sur l'ensemble du plateau. 
	 * @return l'evaluation du plateau utilisée  par l'algo du minmax
	 */
	int eval() {
		return (max_score() - min_score());
	}
	
    /**
	 * toString represente visuellement un Board quelconque
	 * @return une representation en chaine de de caractere du Board
	 */
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\n");
        s.append("--------------------------\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	if(this.table[i][j] == -1) {
            		s.append(String.format("   \t |" ));
            	}
            	else if (table[i][j]==1) {
            		s.append(String.format("  X\t |" )); 
                }
            	else {
            		s.append(String.format("  O\t |" )); 
            	}
            }
            s.append("\n");
            s.append("--------------------------\n");
         }
         s.append("\n");
         return s.toString();
	}
	
	/**
	 * initialtoString represente visuellement un Board ou les
	 * cases vides sont numérotés. 
	 * @return une representation spéciale en chaine de de caractere du Board
	 */
	public String initialtoString() {
        StringBuilder s = new StringBuilder();
        s.append("\n");
        s.append("Cette table ci dessous indique les numéros des différentes cases.\n");
        s.append("\n");
        s.append("--------------------------\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	if(this.table[i][j] == -1) {
            		s.append(String.format("   "+(3*i+1+j)+"\t |" ));
            	}
            	else if (table[i][j]==1) {
            		s.append(String.format("  X\t |" )); 
                }
            	else {
            		s.append(String.format("  O\t |" )); 
            	}
            }
            s.append("\n");
            s.append("--------------------------\n");
         }
         s.append("\n");
         s.append("Instructions :\n");
         s.append("1. Pour jouer, indiquez le numéro de la case ou vous souhaitez placer votre pion.\n");
         s.append("2. Faites attention à ne pas sortir de la plage [0,9] au risque d'abreger le jeu.\n");
         s.append("3. Jouer sur une case déjà prise entraine une pénalité : votre tour sera sauté.\n");
         s.append("4. Amusez vous bien au Morpion.\n");
         return s.toString();
	}
	
	/**
	 * max_move_neighbors met dans une liste l'ensemble des positions voisines
	 * du joueur X
	 * @return La liste des Boards voisins pour le prochain coup de X
	 */
	public Iterable<Board> max_move_neighbors() {
    	ArrayList<Board> l = new ArrayList<Board>();
    	for(int i = 0; i<N; i++) {
    		for(int j = 0; j<N; j++) {
    			if(this.table[i][j] == -1) {
    				Board e = new Board(table);
    				e.table[i][j] = 1;
    				l.add(e);   		
    			}
    		}
    	}
    	return l;
	}
	
	/**
	 * min_move_neighbors met dans une liste l'ensemble des positions voisines
	 * du joueur O
	 * @return La liste des Boards voisins pour le prochain coup de O
	 */
	public Iterable<Board> min_move_neighbors() {
    	ArrayList<Board> l = new ArrayList<Board>();
    	for(int i = 0; i<N; i++) {
    		for(int j = 0; j<N; j++) {
    			if(this.table[i][j] == -1) {
    				Board e = new Board(table);
    				e.table[i][j] = 0;
    				l.add(e); 
    			}
    		}
    	}
    	return l;
	}
	
	/**
	 * isOver rends true si la partie est finie et false sinon
	 * @return l'etat d'avancement de la partie - finie ou pas.
	 */
	public boolean isOver() {
		if (Xwins() || Owins()) {
			return true;
		}
		else {
			for(int i = 0; i<N; i++) {
	    		for(int j = 0; j<N; j++) {
	    			if(this.table[i][j] == -1) {
	    				return false;
	    			}
	    			else {
	    				continue;
	    			} 
	    		}
	    	}
		}
		return true;
	}
	
	/**
	 * Xwins rends true X a gangné et false sinon
	 * @return l'etat d'avancement de la partie de X - gagné ou pas.
	 */
	public boolean Xwins() {
		if (this.max_score() >= 10000) {
			return true;
		}
		else {
			return false;
			}
		}
	
	/**
	 * Owins rends true O a gangné et false sinon
	 * @return l'etat d'avancement de la partie de O - gagné ou pas.
	 */
	public boolean Owins() {
		if (this.min_score() >= 10000) {
			return true;
		}
		else {
			return false;
			}
		}
	
	/**
	 * Méthode main pour dérouler au complet le rendu de l'algorithme
	 * Minmax. Pour voir le rendu, consulter la classe Solver et 
	 * decommenter la méthode main ci dessous. Puis initialiser comme
	 * vous voulez le Board. Faites cependant attention à ce que le
	 * prochain coup à jouer soit pour le 'X'.
  	 */
	public static void main(String[] args) {
		
		Board initial = new Board(new int[][]{
			{-1, 0, -1},
			{-1, -1, -1},
			{-1, -1, -1}});
		
		Solver premierEssai;
		premierEssai = new Solver(initial);
		System.out.println("Nombre de Noeuds visités : "+premierEssai.nb_nodes+"\n");
		
	}
}

