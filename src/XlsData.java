import de.bezier.data.*;
import processing.core.PApplet;


public class XlsData {
	

	private PApplet p;
	private int rows;
	private int collums;
	private XlsReader reader;

	public XlsData(PApplet p) {
		this.p = p;
		
		reader = new XlsReader(p, "calendarData01.xls");
		
		reader.firstRow();  
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
	
private void createDataStructure(){
	
	
	
}	
	
public int getRows(){
	
	
	return rows;
}


public int getCollums(){
	
	
	return collums;
}
	
	
	
	

}
