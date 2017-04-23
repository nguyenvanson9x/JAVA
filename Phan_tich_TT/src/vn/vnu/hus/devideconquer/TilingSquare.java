package vn.vnu.hus.devideconquer;

import java.util.*;

public class TilingSquare {

	private static int[][] grid;
	private int number;
	private static Scanner input;

	public TilingSquare(int size, int x, int y) {

		grid = new int[size][size];
		number = 1;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				grid[i][j] = 0;
			}
		}

		grid[x][y] = -1;
	}

	
	private void tileRec(int size, int topx, int topy) {

		if (size == 2) {

			for (int i = 0; i < size; i++) {

				for (int j = 0; j < size; j++) {

					if (grid[topx + i][topy + j] == 0) {

						grid[topx + i][topy + j] = number;
					}
				}
			}

			number++;
		} else {

			int holeX = topx, holeY = topy;
			// tim vi tri cua lo hong
			for (int x = topx; x < topx + size; x++) {
				for (int y = topy; y < topy + size; y++) {
					if (grid[x][y] == -1) {
						holeX = x;
						holeY = y;
					}
				}
			}

			if (holeX < topx + size / 2 && holeY < topy + size / 2) {
				// TH1: Lo hong o goc tren cung ben trai
				tileRec(size / 2, topx, topy);

				grid[topx + size / 2][topy + size / 2 - 1] = number;
				grid[topx + size / 2][topy + size / 2] = number;
				grid[topx + size / 2 - 1][topy + size / 2] = number;

				number++;

				tileRec(size / 2, topx, topy + size / 2);
				tileRec(size / 2, topx + size / 2, topy);
				tileRec(size / 2, topx + size / 2, topy + size / 2);

			} else if (holeX < topx + size / 2 && holeY >= topy + size / 2) {
				// TH2: Lo hong o goc tren cung ben phai
				tileRec(size / 2, topx, topy + size / 2);

				grid[topx + size / 2][topy + size / 2 - 1] = number;
				grid[topx + size / 2][topy + size / 2] = number;
				grid[topx + size / 2 - 1][topy + size / 2 - 1] = number;

				number++;

				tileRec(size / 2, topx, topy);
				tileRec(size / 2, topx + size / 2, topy);
				tileRec(size / 2, topx + size / 2, topy + size / 2);

			} else if (holeX >= topx + size / 2 && holeY < topy + size / 2) {
				// TH3: Lo hong o goc duoi ben trai
				tileRec(size / 2, topx + size / 2, topy);

				grid[topx + size / 2 - 1][topy + size / 2] = number;
				grid[topx + size / 2][topy + size / 2] = number;
				grid[topx + size / 2 - 1][topy + size / 2 - 1] = number;

				number++;

				tileRec(size / 2, topx, topy);
				tileRec(size / 2, topx, topy + size / 2);
				tileRec(size / 2, topx + size / 2, topy + size / 2);
			} else {
				// TH4: Lo hong o goc duoi ben phai
				tileRec(size / 2, topx + size / 2, topy + size / 2);

				grid[topx + size / 2 - 1][topy + size / 2] = number;
				grid[topx + size / 2][topy + size / 2 - 1] = number;
				grid[topx + size / 2 - 1][topy + size / 2 - 1] = number;

				number++;

				tileRec(size / 2, topx + size / 2, topy);
				tileRec(size / 2, topx, topy + size / 2);
				tileRec(size / 2, topx, topy);
			}

		}

	}

	public void printGrid() {

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + "\t");
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {

		input = new Scanner(System.in);

		System.out.println("Nhap vao kich thuoc cua san nha");
		System.out.println("So nhap vao la boi cua 2");
		int size = input.nextInt();

		System.out.println("Nhap vao vi tri cua o thoat nuoc");
		int x = input.nextInt();
		int y = input.nextInt();
		input.close();

		TilingSquare tiling = new TilingSquare(size, x, y);
		tiling.tileRec(grid.length, 0, 0);

		System.out.println("Cach lat gach\n");
		tiling.printGrid();
	}
}