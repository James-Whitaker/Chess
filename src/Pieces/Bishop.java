package Pieces;

import Board.Board;

public class Bishop implements Piece {

	private boolean isWhite;
	private int row;
	private int col;

	public Bishop(Boolean white, int c, int r) {
		this.isWhite = white;
		this.row = r;
		this.col = c;
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
		int c = pos[0];
		int r = pos[1];
		if (r == row && c == col) {
			System.out.println("Must move piece");
			return false;
		}
		if (r < 0 || r >= 8 || c < 0 || c >= 8) {
			System.out.println("Cannot move out of bounds");
			return false;
		}
		if (board.isPiece(c, r)) {
			Piece p = board.getPiece(c, r);
			if (p.isWhite() == this.isWhite) {
				System.out.println("Cannot take your own piece");
				return false;
			}
		}
		if (Math.abs(r - row) != Math.abs(c - col)) {
			System.out.println("Must move diagonally");
			return false;
		} else {
			if (r < row && c < col) {
				for (int i = row - 1, j = col - 1; i > r || j > c; i--, j--) {
					if (board.isPiece(j, i)) {
						System.out.println("Cannot jump over pieces");
						return false;
					}
				}
				return true;
			} else if (r > row && c < col) {
				for (int i = row + 1, j = col - 1; i < r || j > c; i++, j--) {
					if (board.isPiece(j, i)) {
						System.out.println("Cannot jump over pieces");
						return false;
					}
				}
				return true;
			} else if (r < row && c > col) {
				for (int i = row - 1, j = col + 1; i > r || j < c; i--, j++) {
					if (board.isPiece(j, i)) {
						System.out.println("Cannot jump over pieces");
						return false;
					}
				}
				return true;
			} else if (r > row && c > col) {
				for (int i = row + 1, j = col + 1; i < r || j < c; i++, j++) {
					if (board.isPiece(j, i)) {
						System.out.println("Cannot jump over pieces");
						return false;
					}
				}
				return true;
			}

		}
		System.out.println("Something's wrong");
		return false;
	}

	@Override
	public boolean isPiece() {
		return true;
	}

	@Override
	public char display() {
		if (isWhite) {
			return 'B';
		} else {
			return 'b';
		}
	}
	
	@Override
	public boolean isKing() {
		return false;
	}
}
