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
		while (b.isOngoing()) {
			String str = s.nextLine();
			if (str == "help" || str == "h") {
				System.out.println("White Pieces are capitalized");
				System.out.println(
						"To move a piece, type 'a1-a3' where a1 is the piece you wish to move and a3 is the destination");

				System.out.print(": ");
				str = s.nextLine();
			} else if (str == "print" || str == "board") {
				b.print();
				str = s.nextLine();
			} else {
				char col0 = str.charAt(0);
				char row0 = str.charAt(1);
				char col1 = str.charAt(3);
				char row1 = str.charAt(4);
				char prom = ' ';
				if(str.length() > 5) {
					prom = str.charAt(5);
				}
				int[] loc0 = new int[2];
				int[] loc1 = new int[2];
				loc0[0] = getCol(col0);
				loc0[1] = getRow(row0);
				loc1[0] = getCol(col1);
				loc1[1] = getRow(row1);
				if (loc0[0] == 8 || loc1[0] == 8 || loc0[1] == 8 || loc1[1] == 8) {
					System.out.println("Out of bounds or incorrect input");
				} else {
					b.move(loc0, loc1, prom);
				}
			}
		}

		s.close();
	}

	public static int getCol(char c) {
		int i = 0;
		String str = c + "";
		switch (str) {
		case "a":
			i = 0;
			break;
		case "b":
			i = 1;
			break;
		case "c":
			i = 2;
			break;
		case "d":
			i = 3;
			break;
		case "e":
			i = 4;
			break;
		case "f":
			i = 5;
			break;
		case "g":
			i = 6;
			break;
		case "h":
			i = 7;
			break;
		default:
			i = 8;
			break;
		}
		return i;
	}

	public static int getRow(char c) {
		int i = 0;
		switch (c) {
		case '1':
			i = 7;
			break;
		case '2':
			i = 6;
			break;
		case '3':
			i = 5;
			break;
		case '4':
			i = 4;
			break;
		case '5':
			i = 3;
			break;
		case '6':
			i = 2;
			break;
		case '7':
			i = 1;
			break;
		case '8':
			i = 0;
			break;
		default:
			i = 8;
			break;
		}
		return i;
	}

}
