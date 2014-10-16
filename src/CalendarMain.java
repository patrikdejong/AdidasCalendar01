import processing.core.*;
import de.bezier.data.*; 

public class CalendarMain extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

	private XlsReader reader;
	private XlsData dataSheet;
	
	 public void setup() {
		    size(1200,300);
		    background(0);
		    
		    
		   // reader = new XlsReader(this, "workbook.xls");
		    //reader = new XlsReader(this, "calendarData01.xls");
		    
		    dataSheet = new XlsData(this);
		    
		    
		    // derzeit geht data von 0-2 die ersten 3 campaigns
		    //
		println(   dataSheet.data.get(1).activities.get(7).campaign ) ;
		println(   dataSheet.data.get(1).activities.size() ) ;
		println(   dataSheet.data.get(2).activities.size() ) ;
		    
		    
		  }

		  public void draw() {
		    stroke(255);
		    if (mousePressed) {
		      line(mouseX,mouseY,pmouseX,pmouseY);
		    }
		  }

}
