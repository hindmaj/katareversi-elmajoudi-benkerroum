package katareversi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.StringValueHelper;

public class kata_rev {
        char[][] grid;
        char beyondEdge;
        int width, height;
        char currentPlayer;
        char possibleMove;
        char vacant;
        char white, black;

       public kata_rev(File gamefile) {
    	   beyondEdge = 'X';
    	   vacant = '.';
           possibleMove = 'O';
           white = 'W';
           black = 'B';

          loadgame(gamefile);
   }
       
       public void loadgame(File gamefile) {
           ArrayList<String> filelines=new ArrayList<String>();
           try {
			Scanner scan=new Scanner(gamefile);
			while(scan.hasNext())
			{
				filelines.add(scan.nextLine().toUpperCase());
			}
			width=filelines.get(0).length();
			height=filelines.size()-1;
			grid=new char[height][width];
			
			int y=0;
			for(String line:filelines)
			{
				line=line.trim();
				if(line.length()!=1){
					grid[y]=line.toCharArray();
					y++;
				}else
				{
					setCurrentPlayer(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
           
   }


	public String[] getGridByLine()
	{
		String[] resultGrid=new String[height];
		for(int y=0;y<height;y++)
		{
			resultGrid[y]="";
			for(char x:grid[y])
			{
				resultGrid[y]+=x;
				
			}
		}
		return resultGrid;
	}
	
	private void setCurrentPlayer(String line) {
		if(line.equals('W'))
			currentPlayer='W';
		else if(line.equals('B'));
		currentPlayer='B';
		
	}
	
public boolean possibleMove(int x, int y) {
		if(!vacant(y,x))
		return false;
		
		for(y=y+1;withinGrid(y,x);y++){
			if(vacant(y,x))
		return false;
			else if(occupedByCurrentPlayer(y,x))
				return true;
			}
		return false;
	}

private boolean occupedByCurrentPlayer(int y, int x) {
	
	return grid[y][x]==currentPlayer;
}

private boolean withinGrid(int y, int x) {
	
	return (x>=0 && x<width && y>=0 && y<height);
}

private boolean vacant(int y, int x) {
	return grid[y][x]==vacant;
		
	}
     



}
