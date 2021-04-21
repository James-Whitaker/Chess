import java.util.Scanner;

import Board.Board;

public class Main {

	public static void main(String[] args) {
		Board game = new Board();
		playGame(game);

	}

	public static void playGame(Board b) {
		Scanner s = new Scanner(System.in);
		b.print();
		boolean moved;
		while (b.isOngoing()) {
			String str = s.nextLine();
			if(str == "help" || str == "h") {
				System.out.println("White Pieces are capitalized");
				System.out.println("To move a piece, type 'a1-a3' where a1 is the piece you wish to move and a3 is the destination");
				
				System.out.print(": ");
				str = s.nextLine();
			}
			char col0 = str.charAt(0);
			char row0 = str.charAt(1);
			char col1 = str.charAt(3);
			char row1 = str.charAt(4);

			int[] loc0 = new int[2];
			int[] loc1 = new int[2];
			loc0[0] = getCol(col0);
			loc0[1] = getRow(row0);
			loc1[0] = getCol(col1);
			loc1[1] = getRow(row1);
			moved = b.move(loc0, loc1);
			System.out.println(col0 + ", "+ row0 + "\t"+ col1 + ", "+ row1 );
			System.out.println(loc0[0]+ ", "+ loc0[1] + "\t"+ loc1[0]+ ", "+ loc1[1]);
			
			while(!moved) {
				
				str = s.nextLine();
				col0 = str.charAt(0);
				row0 = str.charAt(1);
				col1 = str.charAt(3);
				row1 = str.charAt(4);

				loc0 = new int[2];
				loc1 = new int[2];
				loc0[0] = getCol(col0);
				loc0[1] = getRow(row0);
				loc1[0] = getCol(col1);
				loc1[1] = getRow(row1);
				moved = b.move(loc0, loc1);
			}
			b.print();
		}
		s.close();
	}

	public static int getCol(char c) {
		int i = 0;
		String str = c + "";
		switch (str) {
		case "a":
			i = 0; break;
		case "b":
			i = 1; break;
		case "c":
			i = 2; break;
		case "d":
			i = 3; break;
		case "e":
			i = 4; break;
		case "f":
			i = 5; break;
		case "g":
			i = 6; break;
		case "h":
			i = 7; break;
		default:
			i = 8; break;
		}
		return i;
	}

	public static int getRow(char c) {
		int i = 0;
		switch (c) {
		case '1':
			i = 7; break;
		case '2':
			i = 6; break;
		case '3':
			i = 5; break;
		case '4':
			i = 4; break;
		case '5':
			i = 3; break;
		case '6':
			i = 2; break;
		case '7':
			i = 1; break;
		case '8':
			i = 0; break;
		default:
			i = 8; break;
		}
		return i;
	}

}
