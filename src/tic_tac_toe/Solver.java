package tic_tac_toe;

public class Solver {

    protected int nb_nodes = 0;			//profondeur de l'arbre du minmax
    protected final Board initialBoard; //Board à resoudre
    protected Noeud initialNode;		//Noeud racine de l'arbre du minmax
	private final double neginf = Double.NEGATIVE_INFINITY;
	private final double posinf = Double.POSITIVE_INFINITY;
	protected final Board nextBoard;	//Prochaine position à jouer
	private static Boolean lvl = true;	
    
	/**
	 * constructeur de Solver
	 * Permet de jouer contre l'IA du jeu avec :
	 * print_next_move_medium pour jouer à un niveau médium
	 * print_next_move_hard pour jouer à un niveau difficile. Décommenter
	 * la ligne 28 et commenter la ligne 27 et 29.
	 * Décommenter la ligne 29 pour dérouler l'ensemble des positions
	 * favorable du Minmax et commenter la ligne 27 et 28.
	 * @param initial Position initiale à résoudre 
	 * */
    public Solver(Board initial) {
    	this.initialBoard = initial; 
    	this.initialNode = new Noeud(initial, null, true);
        minmax(initialNode);
        nextBoard = print_nextmove_medium(initialNode);
        //nextBoard = print_nextmove_hard(initialNode);
        //print_nextmoves(initialNode);
    }
    
    /**
	 * minmax débute l'exploration de l'arbre
	 * Pour visualiser l'ensemble des positions explorées avec le 
	 * minmax décommenter les lignes 40 et 41. Pour jouer laisser les telles qu'elles. 
	 * @param a Noeud dont on doit explorer les descendants
	 */
    private void minmax(Noeud a) {
        nb_nodes = 0;
        //System.out.println(a.board.toString());
        //System.out.println(a.board.eval());
        max_value(a);
    }
    
    /**
	 * next_moves genere une liste qui contient l'ensemble des Boards voisins
	 * en fonction du tour de chaque joueur.
	 * @param a Noeud dont on doit explorer les descendants
	 * @return La liste contenant l'ensemble des Boards voisins
	 */
    protected Iterable<Board> next_moves(Noeud a) {

        if (a.turn) {   //Pour changer de joueur max il suffit de prendre comme condition la négation de celle ci
            return a.board.max_move_neighbors();
        } else {
            return a.board.min_move_neighbors();
        }
    }
    
    /**
	 * max_value attribue la valeur max parmi les valeurs des
	 * fils du noeud exploré a ce dernier. 
	 * @param n Noeud dont on doit explorer les descendants
	 * @return la valeur attribuée
	 */
    protected double max_value(Noeud n) {
        ++nb_nodes;
        int j = 0;
        if (n.board.isOver() || (n.nbFils == 0)) return n.value;
        else {
        		for (Board b : next_moves(n)) {
        			n.fils[j] = new Noeud(b, n, !n.turn);
        			j++;
        		}
        }
        double res = neginf;
        for (int i = 0; i < n.nbFils; i++) {
            res = Math.max(res, min_value(n.fils[i]));
        }
        n.value = res;
        return res;
    }
    
    /**
	 * min_value attribue la valeur min parmi les valeurs des
	 * fils du noeud exploré a ce dernier. 
	 * @param n Noeud dont on doit explorer les descendants
	 * @return la valeur attribuée
	 */
    protected double min_value(Noeud n) {
        int j = 0;
        ++nb_nodes;
        if (n.board.isOver() || (n.nbFils == 0)) return n.value;
        else {
        	//if (n.nbFils == 0) {
	            for (Board b : next_moves(n)) {
	                n.fils[j] = new Noeud(b, n, !n.turn);
	                j++;
	            }
        	//}
        }
        double res = posinf;
        for (int i = 0; i < n.nbFils; ++i) {
            res = Math.min(res, max_value(n.fils[i]));
        }
        n.value = res;
        return res;
    }
    
    /**
	 * print_nextmoves affiche la meilleure succession de position 
	 * que le joueur max peut esperer. 
	 * @param n Noeud dont on doit explorer les descendants
	 */
     protected void print_nextmoves(Noeud a) {
        int score = 0;
        if (a.board.isOver()) {
            return;
        }
        for (Noeud n : a.fils) {
            if (n.value == a.value) {
                System.out.println(n.board.toString());
                score = n.board.eval();
                System.out.println(score);
                print_nextmoves(n);
                break;
            }
        }
        
    }
     
     /**
 	 * print_nextmove_hard joue la prochaine meilleure position 
 	 * voisine que le joueur max peut esperer. 
 	 * @param n Noeud dont on doit explorer les descendants
 	 * @return la prochaine position à jouer
 	 */
     protected Board print_nextmove_hard(Noeud a) {
    	 Board next_move = a.board;
         if (a.board.isOver()) {
             return a.board;
         }
         for (Noeud n : a.fils) {
             if (n.value == a.value) {
            	 next_move = n.board;
             }
         }
         return next_move;
     }
     
     /**
  	 * print_nextmove_medium joue la prochaine meilleure position 
  	 * voisine que le joueur max peut esperer ou une position ou une position au hasard. 
  	 * @param n Noeud dont on doit explorer les descendants
  	 * @return la prochaine position à jouer
  	 */
     protected Board print_nextmove_medium(Noeud a) {
    	 Board next_move = a.board;
         if (a.board.isOver()) {
             return a.board;
         } 

         if (lvl) {
        	 for (Noeud n : a.fils) {
                 if (n.value == a.value) {
                	 next_move = n.board;
                 }
                 lvl = false;
        	 }
        	 lvl = false;
         }
         else {	 
	         int Min = 0; 
	         int Max =  a.nbFils; 
	         int j = (int) (Math.random() * ( Max - Min ));
	         Noeud n = a.fils[j];
	         next_move = n.board;
	         if (((Math.random() * a.nbFils)   % 3) == 0)
	        	 lvl = true;
         }

         return next_move;
     }
	 
}
	 
