package queens.main;

public class QueensMain_BackTracking {

	public static void main(String[] args) {
		
		int r = 0; int c =0;			// r and c are looping variables corresponding to a row and column respectively.
		Board board = new Board();
		boolean isPlaced = false; 		
		
		// isPlaced is used to track placing a queen on a given row. The critical logic is that a queen should be placed on each and every row. 
		// Hence, if isPlaced is false, it means that in the process of finding valid positions, one complete row had been left blank, which in turn shall not lead to a set of positions corresponding to a successful placement of queens.
		// Hence, this should then trigger a "backtrack"
				
		for(int start_row=0; start_row<8; start_row++){				// Surprisingly, after placing a queen at (start_row,start_col) and beginning to look from next row is not leading to any solutions when start_row>0
			for(int start_col=0; start_col<8; start_col++){
				board.cleanBoard();									// Initialing the board before placing first queen.		
				board.pushStack(start_row, start_col);				// Placing first queen at (start_row, start_col)	
				for(r=start_row+1; r<8 ; r++){
					if(isPlaced)									// System should check for valid positions from the beginning of the column only when a queen has been placed on the previous row.
						c=0;										// This if condition will avoid setting c to 0 in the case of a pop() invocation.
					isPlaced = false; 								// setting isPlaced for the current row-in the current iteration
					for(; c<8 && !isPlaced ; c++){					// Initialization of c is 
				      if(board.isValid(r,c))						// If the pair of r&c correspond to a safe position
				       {
				        board.pushStack(r, c); 						// pushing the currently found valid position to a stack
				        isPlaced = true; 							// set isPlaced to true to mark that queen has been placed for the current row
				       }
				    }//END OF c loop
				    if(isPlaced==false ){							// popStack is the method that will enforce the backtracking by one step. This will trigger backtracking - after arriving at an unsuccessful solution
				    	c=board.popStack(r-1);						// Redirecting flow of c to the last known valid location - column at which queen was placed on the previous row  
				    	r-=2;										// Redirecting flow of r to the last known valid location - previous row. Decrementing by two to account for r++ of the for loop for the next iteration
				    	if(c==-1){									// c = -1 from popStack means next pushStack will lead to IndexOutOfBounds
				    												// This implies the system has checked for all possible combinations with current pair of start_row & start_col and is about to go out of bounds of the stack
				    		isPlaced = true; 						// setting isPlaced to true will lead to executing (c=0) in the next iteration
				    		r=r+2; 									// Nullifying the r-=2;
				    	}				    	
				    }
				    else if(isPlaced==true && board.getQueens()==8){// popStack is the method that will enforce the backtracking by one step. This will trigger backtracking - after a successful solution has been found.
				    	c=board.popStack(r);						// Redirecting flow of c to the last known valid location - column at which queen was placed on the current row
				    	r--;										// Redirecting flow of r to the last known valid location - current row. Decrementing one to account for r++ of the for loop for the next iteration
				    	if(c==-1){									// Found one valid solution. Now trying for another solution with same start_row & start_col
				    												// This implies the system has checked for all possible combinations with current pair of start_row & start_col and is about to go out of bounds of the stack
				    		isPlaced = true;						// setting isPlaced to true will lead to executing (c=0) in next iteration
				    		r=r+1;									// Nullifying the r-=1;
				    	}				    	
				    	isPlaced=false;								// Setting isPlaced to false to avoid execution of (c=0) in the next iteration.
				    }
				}//END OF r loop
			}//end of start_col loop
		}//end of start_row loop

		System.out.println("\n"+board.solutionCount+" solutions found.");
		System.out.println("End of Execution.");		
	}//end of main
		
}//end of class
