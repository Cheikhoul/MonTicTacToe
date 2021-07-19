package tic_tac_toe;

import java.util.ArrayList;

public class Noeud {

    protected Noeud pere;
    protected Noeud[] fils;
    protected int nbFils;
    protected Board board;
    protected double value;
    protected boolean turn;

    public Noeud(Board b, Noeud p, boolean joueur) {
        this.board = b;
        this.pere = p;
        this.turn =  joueur;
        if (joueur) { /*Si joueur = true c'est le joueur min qui a joué et au joueur max de jouer*/
            this.nbFils = ((ArrayList<Board>) b.max_move_neighbors()).size();
        } else { /*Si joueur = false c'est le joueur max qui a joué et au joueur min de jouer*/
            this.nbFils = ((ArrayList<Board>) b.min_move_neighbors()).size();
        }
        this.fils = new Noeud[nbFils];
        if (this.board.isOver()||(this.nbFils == 0)) {
            this.value = this.board.eval();
        }
    }
}
