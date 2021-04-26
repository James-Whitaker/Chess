package Pieces;

import Board.Board;

public class Pawn implements Piece {

	private boolean isWhite;
	private int row;
	private int col;
	private boolean moved;

	public Pawn(Boolean white, int c, int r) {
		this.isWhite = white;
		this.row = r;
		this.col = c;
		this.moved = false;
	}

	public boolean isWhite() {
		return this.isWhite;
	}

	public void setPosition(int c, int r) {
		this.row = r;
		this.col = c;
	}

	@Override
	public int[] getPosition() {
		int[] pos = new int[2];
		pos[0] = this.row;
		pos[1] = this.col;
		return pos;
	}

	@Override
	public boolean isValidMove(int[] pos, Board board) {
		System.out.println("Checking move");
		int c = pos[0];
		int r = pos[1];
		boolean take = false;
		if (r < 0 || r >= 8 || c < 0 || c >= 8) {
			System.out.println("Out of Bounds");
			return false;
		}
		if (r == row && c == col) {
			System.out.println("Must move Piece");
			return false;
		}
		if (board.isPiece(c, r)) {
			Piece p = board.getPiece(c, r);
			System.out.println("Taking Piece");	
			take = true;
			if (p.isWhite() == this.isWhite) {
				System.out.println("Cannot take own piece");
				return false;
			}

		}
		if (isWhite) {
			if (c == col && !take) {
				if (row == r + 1) {
					return true;
				} else if (row == r + 2 && !moved) {
					return true;
				}
				System.out.println("Cannot move given distance");
				return false;
			} else if (Math.abs(c - col) == 1 && take) {
				if (row == r + 1) {
					return true;
				}
			}
			return false;
		} else {
			if (c == col && !take) {
				if (row == r - 1) {
					return true;
				} else if (row == r - 2 && !moved) {
					return true;
				}
				System.out.println("Cannot move given distance");
				return false;
			} else if (Math.abs(c - col) == 1 && take) {
				if (row == r - 1) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public boolean isPiece() {
		return true;
	}

	@Override
	public char display() {
		if (isWhite) {
			return 'P';
		} else {
			return 'p';
		}
	}
	
	
	@Override
	public boolean isKing() {
		return false;
	}
	
	@Override
	public boolean canPromote() {
		if(isWhite) {
			if(row == 0) {
				return true;
			}
		}
		else {
			if (row == 7){
				return true;
			}
		}
		return false;
	}
}
