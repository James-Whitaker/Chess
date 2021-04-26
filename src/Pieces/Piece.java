package Pieces;

import Board.Board;
/*
 * Interface for the pieces
 */
public interface Piece {
	//Piece color
	public boolean isWhite();

	//changes the pieces location
	public void setPosition(int c, int r);

	//returns the position of the piece
	public int[] getPosition();

	//only used to confirm the spot isn't blank
	public boolean isPiece();

	//checks if the piece can move to the give location
	public boolean isValidMove(int[] pos, Board board);

	//returns the character representing the piece
	public char display();
	
	//used for check
	public boolean isKing();
	
	//used for pawn
	public boolean canPromote();
}
