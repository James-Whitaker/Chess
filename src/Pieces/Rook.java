package Pieces;

import Board.Board;

public class Rook implements Piece {

	private boolean isWhite;
	private int row;
	private int col;
	private boolean moved;

	public Rook(Boolean white, int c, int r) {
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
		int c = pos[0];
		int r = pos[1];
		if (r == row && c == col)
			return false;
		if (r < 0 || r >= 8 || c < 0 || c >= 8) {
			return false;
		}
		if (board.isPiece(c, r)) {
			Piece p = board.getPiece(c, r);
			if (p.isWhite() == this.isWhite) {
				return false;
			}
		}
		if (r == row) {
			if (c < col) {
				for (int i = c + 1; i < col; i++) {
					if (board.isPiece(i, r)) {
						return false;
					}
				}
			} else {
				for (int i = col + 1; i < c; i++) {
					if (board.isPiece(i, r)) {
						return false;
					}
				}
			}
			return true;
		} else if (c == col) {
			if (r < row) {
				for (int i = r + 1; i < row; i++) {
					if (board.isPiece(c, i)) {
						return false;
					}
				}
			} else {
				for (int i = row + 1; i < r; i++) {
					if (board.isPiece(c, i)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isPiece() {
		return true;
	}

	@Override
	public char display() {
		if (isWhite) {
			return 'R';
		} else {
			return 'r';
		}
	}
	
	@Override
	public boolean isKing() {
		return false;
	}
}
