package Pieces;

import Board.Board;

public interface Piece {
	public boolean isWhite();

	public void setPosition(int c, int r);

	public int[] getPosition();

	public boolean isPiece();

	public boolean isValidMove(int[] pos, Board board);

	public char display();
	
	public boolean isKing();
}
