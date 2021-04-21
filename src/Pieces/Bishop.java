package Pieces;

import Board.Board;

public class Bishop implements Piece {

	private boolean isWhite;
	private int row;
	private int col;
	private boolean moved;

	public Bishop(Boolean white, int c, int r) {
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
		if (Math.abs(r - row) != Math.abs(c - col)) {
			return false;
		} else {
			if (r < row && c < col) {
				for (int i = r + 1, j = c + 1; i < row && j < col; i++, j++) {
					if (board.isPiece(j, i)) {
						return false;
					}
				}
			} else if (r > row && c < col) {
				for (int i = row + 1, j = c + 1; i < r && j < col; i++, j++) {
					if (board.isPiece(j, i)) {
						return false;
					}
				}
			} else if (r < row && c > col) {
				for (int i = r + 1, j = col + 1; i < row && j < c; i++, j++) {
					if (board.isPiece(j, i)) {
						return false;
					}
				}
			} else if (r > row && c > col) {
				for (int i = row + 1, j = col + 1; i < r && j < c; i++, j++) {
					if (board.isPiece(j, i)) {
						return false;
					}
				}
			}

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
