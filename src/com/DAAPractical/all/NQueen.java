package com.DAAPractical.all;

public class NQueen {
	
	static void solve(int col, int n, int board[][]) {
		
		if(col == n) {
			for(int i=0; i<board.length; i++) {
				for(int j=0; j< board.length; j++) {
					System.out.print(" " + board[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		
		for(int row =0; row<n; row++) {
			
			if(issafe(row, col, n, board)) {
				
				board[row][col] = 1;
				
				solve(col+1, n, board);
				
				board[row][col] = 0;
			}
		}
	}
	
	
	static boolean issafe(int row, int col, int n, int board[][]) {
		
		int x = row;
		int y= col;
		
		while(y>=0) {
			if(board[x][y] == 1)
				return false;
			y--;
			
		}
		
		y = col;
		
		while(x>=0 && y>=0) {
			if(board[x][y] == 1) 
				return false;
			
			x--;
			y--;
		}
		
		x = row;
		y= col;
		
		while(x<n && y>=0) {
			if(board[x][y] == 1)
				return false;
			x++;
			y--;
		}
		
		return true;
		
	}
	

	public static void main(String[] args) {
		int n = 4;
		int board [][] = new int [n][n];
		
		solve(0, n, board);
	}

}
