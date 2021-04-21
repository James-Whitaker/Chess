package Pieces;

import Board.Board;

public class Blank implements Piece {

	@Override
	public boolean isWhite() {
		return false;
	}

	@Override
	public void setPosition(int r, int c) {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPiece() {
		return false;
	}

	@Override
	public boolean isValidMove(int[] pos, Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char display() {
		// TODO Auto-generated method stub
		return ' ';
	}
	
	@Override
	public boolean isKing() {
		return false;
	}

}
