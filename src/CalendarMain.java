import java.awt.Point;

import processing.core.*;
import de.bezier.data.*; 

public class CalendarMain extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

	private XlsReader reader;
	private XlsData xlsData;
	private float cy;
	private float cx;
	private Grid grid;
	
	 public void setup() {
		    size(1400,1000);
		    
		    smooth();
		    
		    
			cx = width/2;
			cy = height/2;  //center
	
		    xlsData = new XlsData(this);

//		println(   xlsData.data.get(1).activities.get(7).startDay ) ;	
//		println( "for T: " + dataSheet.data.get(1).activities.get(9).endDay ) ;
		    
<<<<<<< Updated upstream
		    
		println( "Semester Days: " + xlsData.getSemesterDays() ) ;
		
			grid = new Grid(xlsData,this);

		
=======
		//  println( dataSheet.data.get(4).activities.size() );
>>>>>>> Stashed changes
		    
		    
		  }

		  public void draw() { // wird in jedem Frame aufgerufen, brauchen wir nur für zoom etc... 
			  background(100);
			  grid.drawGrid();
			  
			  println("draw");
			  
		  }
		  
		  
		  
		  
		  PVector coords(double angle, float radius){
			  
			  
			  double radian = (angle/180f) * Math.PI;
			  

			  double x = cx +  Math.cos(radian)*radius;
			  double y = cy +  Math.sin(radian)*radius;
			  
			  PVector c = new PVector();
			  c.x =(float) x;
			  c.y =(float) y;
			  
			  return new PVector();
			  
		  }
		  

}
