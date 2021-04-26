package Board;

import java.util.Scanner;

import Pieces.*;

public class Board {
	public Piece[][] pieces;
	Piece blank;
	boolean whiteTurn;
	boolean ongoing;

	public Board(Board b) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				b.pieces[i][j]
			}
		}
	}
	public Board() {
		whiteTurn = true;
		ongoing = true;
		pieces = new Piece[8][8];
		blank = new Blank();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				pieces[i][j] = blank;
			}
		}
		pieces[0][0] = new Rook(false, 0, 0);
		pieces[1][0] = new Knight(false, 1, 0);
		pieces[2][0] = new Bishop(false, 2, 0);
		pieces[3][0] = new Queen(false, 3, 0);
		pieces[4][0] = new King(false, 4, 0);
		pieces[5][0] = new Bishop(false, 5, 0);
		pieces[6][0] = new Knight(false, 6, 0);
		pieces[7][0] = new Rook(false, 7, 0);
		for (int i = 0; i < 8; i++) {
			pieces[i][1] = new Pawn(true, i, 1);
			pieces[i][6] = new Pawn(true, i, 6);
		}
		pieces[0][7] = new Rook(true, 0, 7);
		pieces[1][7] = new Knight(true, 1, 7);
		pieces[2][7] = new Bishop(true, 2, 7);
		pieces[3][7] = new Queen(true, 3, 7);
		pieces[4][7] = new King(true, 4, 7);
		pieces[5][7] = new Bishop(true, 5, 7);
		pieces[6][7] = new Knight(true, 6, 7);
		pieces[7][7] = new Rook(true, 7, 7);

	}

	public boolean isPiece(int col, int row) {
		return pieces[col][row].isPiece();
	}

	public Piece getPiece(int col, int row) {
		return pieces[col][row];
	}

	public boolean move(int[] old, int[] cur, char prom) {
		Board temp = this;
		int c0 = old[0];
		int r0 = old[1];
		int c1 = cur[0];
		int r1 = cur[1];
		if (!isPiece(c0, r0)) {
			System.out.println("No piece at the given location");
			System.out.print(": ");
			return false;
		}
		Piece p = getPiece(c0, r0);
		if (p.isWhite() != whiteTurn) {
			System.out.println("Cannot move opponent's pieces");
			System.out.print(": ");
			return false;
		}
		if (p.isValidMove(cur, this)) {
			if (isPiece(c1, r1)) {
				take(cur);
			}
			p.setPosition(c1, r1);
			pieces[c1][r1] = p;
			pieces[c0][r0] = blank;
			whiteTurn = !whiteTurn;
			promote(c1, r1, prom);
			print();
			check(!whiteTurn);
			return true;
		}
		System.out.println("Invalid Move");
		System.out.print(": ");
		return false;
	}

	public boolean take(int[] loc) {
		int c = loc[0];
		int r = loc[1];
		if (!isPiece(c, r)) {
			return false;
		}
		Piece p = getPiece(c, r);
		if (p.isKing()) {
			if (p.isWhite()) {
				System.out.println("Black Wins!");
			} else {
				System.out.println("White Wins!");
			}
			ongoing = false;
		}
		pieces[c][r] = blank;
		return true;
	}

	public void print() {
		System.out.println("   |a|b|c|d|e|f|g|h|");
		System.out.println("   |---------------|");
		System.out.println("8  |" + rowToString(0));
		System.out.println("7  |" + rowToString(1));
		System.out.println("6  |" + rowToString(2));
		System.out.println("5  |" + rowToString(3));
		System.out.println("4  |" + rowToString(4));
		System.out.println("3  |" + rowToString(5));
		System.out.println("2  |" + rowToString(6));
		System.out.println("1  |" + rowToString(7));
		System.out.println();
		if (this.whiteTurn) {
			System.out.println("White's turn");
		} else {
			System.out.println("Black's turn");
		}
		System.out.print(": ");
	}

	public String rowToString(int row) {
		String str = "";
		for (int i = 0; i < 8; i++) {
			str = str + pieces[i][row].display() + "|";
		}
		return str;
	}

	public boolean promote(int col, int row, char prom) {
		Piece p = pieces[col][row];
		if (p.canPromote()) {
			switch (prom) {
			case 'q':
				pieces[col][row] = new Queen(p.isWhite(), col, row);
				break;
			case 'r':
				pieces[col][row] = new Rook(p.isWhite(), col, row);
				break;
			case 'b':
				pieces[col][row] = new Bishop(p.isWhite(), col, row);
				break;
			case 'n':
				pieces[col][row] = new Knight(p.isWhite(), col, row);
				break;
			case 'Q':
				pieces[col][row] = new Queen(p.isWhite(), col, row);
				break;
			case 'R':
				pieces[col][row] = new Rook(p.isWhite(), col, row);
				break;
			case 'B':
				pieces[col][row] = new Bishop(p.isWhite(), col, row);
				break;
			case 'N':
				pieces[col][row] = new Knight(p.isWhite(), col, row);
				break;
			default:
				return false;
			}
		}
		return true;

	}
	public boolean check(boolean white) {
		int[] loc = findKing(white); 
		Piece p;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				p = pieces[i][j];
				if(p.isPiece() && p.isWhite() != white) {
					if(p.isValidMove(loc, this)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public int[] findKing(boolean white) {
		int[] loc = new int[2];
		loc[0] = 8;
		loc[1] = 8;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(pieces[i][j].isKing() && pieces[i][j].isWhite() == white) {
					loc[0] = i;
					loc[1] = j;
					return loc;
				}
			}
		}
		
		return loc;
	}
	public boolean isOngoing() {
		return ongoing;
	}
}
