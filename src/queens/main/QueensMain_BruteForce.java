package queens.main;

import java.util.*;

public class QueensMain_BruteForce {

	public static void main(String[] args) {
		
		//int row = 0; int col =0;
		Board chessBoard = new Board();
		Set<Integer> positions; 
		
		int a,b,c,d,e,f,g,h;
		long count=0;
		long gcount=0; 
		
		for(a=0; a<8; a++){
			for(b=0; b<8; b++){
				for(c=0; c<8; c++){
					for(d=0; d<8; d++){
						for(e=0; e<8; e++){
							for(f=0; f<8; f++){
								for(g=0; g<8; g++){
									for(h=0; h<8; h++){
										count++;
										chessBoard.cleanBoard();
										positions = new LinkedHashSet<Integer>();
										positions.clear();
										positions.add(a);
										positions.add(b);
										positions.add(c);
										positions.add(d);
										positions.add(e);
										positions.add(f);
										positions.add(g);
										positions.add(h);
										
										if(positions.size()==8){
											gcount++;
											chessBoard.setStack(0,a);
											chessBoard.setStack(1,b);
											chessBoard.setStack(2,c);
											chessBoard.setStack(3,d);
											chessBoard.setStack(4,e);
											chessBoard.setStack(5,f);
											chessBoard.setStack(6,g);
											chessBoard.setStack(7,h);
											
											if(chessBoard.isValid()){
												chessBoard.solutionCount++;
												chessBoard.printStack();
											}//end of if
										}										
									}//end of h
								}//end of g
							}//end of f
						}//end of e
					}//end of d
				}//end of c
			}//end of b
		}//end of a
		
		System.out.println("System had run "+count+" iterations of the chessBoard.");
		System.out.println("System had checked for "+gcount+" permutations.");
		System.out.println("End of Execution.");
	
	}//end of main
		
}//end of class
