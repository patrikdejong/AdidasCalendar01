import java.util.ArrayList;

import de.bezier.data.*;
import processing.core.*;
import processing.data.StringList;


public class XlsData {
	

	private PApplet p;
	private int rows    	= 0;
	private int cells	 	= 0;
	private XlsReader reader;
	StringList channels;
// channel index von bis
	// campaign row
	// channel rows
	// prios
	

	public XlsData(PApplet p) {
		this.p = p;
		
		reader = new XlsReader(p, "calendarData01.xls");
		
		getDocLength();
		
		reader.firstRow();  
		reader.firstCell();
		reader.nextCell();
		reader.nextCell();
		reader.nextCell();
		reader.nextRow();
		reader.nextRow();
		reader.nextRow();
		p.println(	reader.getString() + "--");
		reader.nextRow();
		p.println(	reader.getString() + "--");
		reader.nextRow();
		p.println(	reader.getString() + "--");
		reader.nextRow();
		p.println(	reader.getString() + "--");
		reader.nextRow();
		p.println(	reader.getString() + "--");
		
	}
	
private void buildChannelDescription(){
	
	
}	
	
private void getDocLength()	{
	
	while(reader.hasMoreRows()){
		rows++;
		reader.nextRow();
	}
	
	
	while(reader.hasMoreCells()){
		cells++;
		reader.nextCell();
	}
	
	p.print("rows : "+  rows + " -- cells : "  + cells);
}	
	
private void createDataStructure(){
	
	
	
}	
	
public int getRows(){
	
	
	return rows;
}


public int getCells(){
	
	
	return cells;
}
	
	
	
	

}
