package katareversi;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class kata_test {
	
	@Test
    public void startboardTest() {
    String[] inputlines={
                    "........",
                    "........",
                    "........",
                    "...BW...",
                    "...WB...",
                    "........",
                    "........",
                    "........",
                    "B"
    };
    
    File Inputfile=new File("startboard.rvs");
    writeinputfile(Inputfile,inputlines);
    kata_rev me=new kata_rev(Inputfile);

    //String outputline=me.getGridByLine();
    String[] output=me.getGridByLine();
    
    assertEquals(inputlines.length-1,output.length);
    
    for(int i=0;i<output.length;i++){
   
    	System.out.println(output[i]);
    	assertEquals(inputlines[i],output[i]);
        }

    }

	@Test
    public void possiblemoveSouthTest() {
    String[] inputlines={
                    "........",
                    "........",
                    "........",
                    "...WB...",
                    "...BW...",
                    "........",
                    "........",
                    "........",
                    "B"
    };

    
    File Inputfile=new File("startboard.rvs");
    writeinputfile(Inputfile,inputlines);
    kata_rev me=new kata_rev(Inputfile);

    boolean output=me.possibleMove(2,3);
    boolean expected=false;
    assertEquals(expected,output);
    
  

    }

private static void writeinputfile(File inputfFile,String[] lines){

try {
	BufferedWriter bw = new BufferedWriter(new FileWriter(inputfFile,false));
	for (String line:lines){
		bw.write(line);
		bw.newLine();
		}
		bw.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}
	
	}

