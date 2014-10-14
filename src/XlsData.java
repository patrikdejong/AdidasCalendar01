import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.bezier.data.*;
import processing.core.*;
import processing.data.JSONObject;
import processing.data.StringList;
import processing.data.Table;
import processing.data.TableRow;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class XlsData {
	

	private PApplet p;
	private int nrows    	= 0;
	private int ncells	 	= 0;
	private XlsReader reader;

	int cols;
	int rows;
	String[][] cells;
	
	String season;
	
	int[] yearAr 		={31,28,31,30,31,30,31,30,31,30,31,30};
	int[] leapYearAr 	={31,29,31,30,31,30,31,30,31,30,31,30};
	String[] nextLeapYears 	={"2016","2020", "2024","2028"	};

	public XlsData(PApplet p) {
		this.p = p;
		
		reader = new XlsReader(p, "calendarData02.xls");
		
		reader.showWarnings(false);
		
		getDocLength();
		
		cells = new String[rows][cols];
		
		createDataStructure();
		

	
		p.println(  convertDateToDay("30.12") ) ;
		
		
		
			
		//	cells.append(reader.getString());
			
			
		
		
		
		
		// store in Array
		
		
		

		
	}
	
private void buildChannelDescription(){
	
	
}	
	
private void getDocLength()	{
	
	reader.firstCell();	
	reader.firstRow();

	while(reader.hasMoreRows()){
		
		rows++;
		reader.nextRow();
	}

	while(reader.hasMoreCells()){
		
		cols++;
		reader.nextCell();
	}


	
	p.println("rows : " + rows + " ||||Ê cols : " + cols);
	
}	
	
private boolean checkForLeapYear(String yy){

	boolean result = false;
	for (int i = 0; i < nextLeapYears.length; i++) {
		if(yy.equals(nextLeapYears[i])) result = true;
	}
	
	return result;
}

private int convertDateToDay(String date){
	
	String[] seasonList = p.split(season, " ") ;
	String year 	= seasonList[2];
	String semester = seasonList[1]; 

	String[] dateList = p.split(date, ".") ;
	
	int monthDay = Integer.parseInt(dateList[1]);
	int curDay 	 = 0;
	
	int[] curYear = ( checkForLeapYear(year) ) ? leapYearAr : yearAr;    					// ---------------------> current  Year und Season zentral festlegen, im excel file
		
	for (int i = 0; i < monthDay-1; i++) {
		
		curDay += curYear[i];
		
	}
	
	curDay += Integer.parseInt(dateList[0]); 
	
	return curDay;
}


private void createDataStructure(){
	
	
	reader.firstCell();
	reader.firstRow();
	
	season =  reader.getString();
	
	while(reader.hasMoreRows()){

		nrows++;
	
		while(reader.hasMoreCells()){
			
			cells[nrows-1][reader.getCellNum()] = reader.getString();

			reader.nextCell();
			
			if(nrows == 2 )ncells++;
			
		}
	
		
		reader.nextRow();
	}
	
	
}	


public  void getChannel(String name){
	
	
}


	
public int getRows(){
	
	
	return nrows;
}


public int getCells(){
	
	
	return ncells;
}
	
	
	
	

}
