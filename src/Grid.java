import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;



public class Grid {

	private XlsData xlsData;
	private float cx;
	private float cy;
	private float steps;
	private float radius;
	private PApplet p;
	private PFont font;

	public Grid(XlsData xlsData , PApplet p) {
		
		this.xlsData = xlsData;
		this.p = p;
		
		cx =(float) p.width/2;  // center of canvas
		cy =(float) p.height - 200;
		

		p.println(cx);	
		p.println(cy);
		
		radius = p.width/2 - 50;
		
		steps = 180f / this.xlsData.getSemesterDays();
		
		font = p.loadFont("AdihausDIN-Cn-12.vlw");
		
		drawGrid();
	}
	
	
	public void drawGrid(){
		
		float angle = 180;
		
		for (int i = 0; i < xlsData.getSemesterDays(); i++) {
			
			angle += steps;
		
			
			PVector pos = coords( angle,  radius);
					
			
			
			
			p.textFont(font);
			p.text(i, pos.x , pos.y );
			
		}
		
	}
	
	
	  PVector coords(float angle, float radius){
		  		  
		  double radian = (angle/180) * (double)Math.PI;

		 		  
		  double x = cx +  Math.cos(radian)*radius;
		  double y = cy +  Math.sin(radian)*radius;  
		 	  
		  PVector c = new PVector();
		  c.x =(float) x;
		  c.y =(float) y;
		  
		  
		  
		  return c;
		  
	  }
}
