package queens.main;

import java.util.ArrayList;
import java.util.List;

public class Board {
	public int solutionCount=0;
	private boolean[][] board = new boolean[8][8];
	private List<Integer> stack = new ArrayList<Integer>();
	
	public Integer getStack(int x) {
		board[x][stack.get(x)]=false;
		//printBoard();
		return stack.get(x);
	}
	
	public void setStack(Integer index, Integer element) {
		this.stack.add(index, element);
		board[index][element] = true;
		//printBoard();
	}
	
	public void cleanBoard(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				board[i][j] = false;
			}
		}
		this.stack.clear();
	}
	
	public boolean isValid(){
		int r=0, c=0;
		for(int x=0; x<8; x++){
				r=x;
				c=this.stack.get(x);
				 int i=0, j=0;
				 if (r<=7 && r>=0 && c<=7 && c>=0){
				  
				  //LEFT ROW
				  i= r;
				  for(j=0; j<c; j++){
				     if(board[i][j] == true)
				     {
				      //System.out.println("Found attacking queen on LEFT - ROW");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on LEFT - ROW");
				     }
				  }
				  
				  //RIGHT ROW
				  i= r;
				  for(j=c+1; j<8; j++){
				     if(board[i][j] == true)
				     {
				      //System.out.println("Found attacking queen on RIGHT - ROW");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on RIGHT - ROW");
				     }
				  }
				  
				  //TOP COLUMN
				  j=c;
				  for(i=0; i<r; i++){
				     if(board[i][j] == true)
				     {
				     // System.out.println("Found attacking queen on TOP - COLUMN");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on TOP - COLUMN");
				     }
				  }
				  
				  //BOTTOM COLUMN
				  j=c;
				  for(i=r+1; i<8; i++){
				     if(board[i][j] == true)
				     {
				      //System.out.println("Found attacking queen on BOTTOM - COLUMN");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on BOTTOM - COLUMN");
				     }
				  }
				  
				  //BOTTOM - RIGHT - DIAGONAL
				  for(i=r+1, j=c+1; (i<8 && j<8); i++, j++){
				     if(board[i][j] == true)
				     {
				      //System.out.println("Found attacking queen on BOTTOM - RIGHT - DIAGONAL");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on BOTTOM - RIGHT - DIAGONAL");
				     }
				  }
				  
				  //UPPER - LEFT - DIAGONAL
				  for(i=r-1, j=c-1; (i>=0 && j>=0); i--, j--){
				     if(board[i][j] == true)
				     {
				      //System.out.println("Found attacking queen on UPPER - LEFT - DIAGONAL");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on UPPER - LEFT - DIAGONAL");
				     }
				  }
				  
				  //UPPER - RIGHT - DIAGONAL
				  for(i=r-1, j=c+1; (i>=0 && j<8); i--, j++){
				     if(board[i][j] == true)
				     {
				      //System.out.println("Found attacking queen on UPPER - RIGHT - DIAGONAL");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on UPPER - RIGHT - DIAGONAL");
				     }
				  }
				  
				  //BOTTOM - LEFT - DIAGONAL
				  for(i=r+1, j=c-1; (i<8 && j>=0); i++, j--){
				     if(board[i][j] == true)
				     {
				      //System.out.println("Found attacking queen on BOTTOM - LEFT - DIAGONAL");
				      return false;
				     }
				     else{
				      //System.out.println("No attacking queen found on BOTTOM - LEFT - DIAGONAL");
				     }
				  }    
				   
				 }//end of if branch  
				 else
				  return false;
			}
		return true;
		}//end of isValid method


	public void printBoard(){
		System.out.println();
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
		System.out.println();	
		}
	}
	
	public void printStack(){
		System.out.println(this.solutionCount+". "+this.stack.toString());
	}
}
