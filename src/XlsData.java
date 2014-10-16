
import de.bezier.data.*;
import processing.core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	
	public ArrayList<Campaign>  data  = new ArrayList<Campaign>();
	
	

	public XlsData(PApplet p) {
		this.p = p;
		
		reader = new XlsReader(p, "calendarData02.xls");
		
		reader.showWarnings(false);
		
		getDocLength();
		
		cells = new String[rows][cols];
		
		createDataStructure();
		

	
		//p.println(  convertDateToDay(" 01.5 ") ) ;
		
		
		buildCampaignData();
			
		//	cells.append(reader.getString());
			
			
		
		
		
		
		// store in Array
		
		
		

		
	}
	

private void buildCampaignData(){
	
	
	
	
	
	
	for (int i = 4; i < cells.length; i++) {
		
		Campaign campaign = new Campaign();

		
		for (int j = 3; j < cells[i].length;j++) {
			
			CampaignActivity activity = new CampaignActivity();

			

			if( cells[i][j].length() > 1 ) {
				
				activity.channel  = cells[2][j];  // -----------   > fill all fields when parsing
						
				activity.campaign = cells[i][1];
				
				activity.category = cells[i][0];
				
				if(cells[i][j].indexOf("-") > 0 && j >= 3  && cells[i][j].length() > 0){  // von bis date
					activity.dateString = cells[i][j];
					String[] dates 	  = p.split(activity.dateString, "-") ;
									
					
					activity.startDay =  this.convertDateToDay(dates[0]) ;
					activity.endDay   =  this.convertDateToDay(dates[1]) ;
					
	
				}else if(cells[i][j].length() > 2  &&  j >= 3){ // single day
				
					activity.dateString = cells[i][j];
					
				
					
					activity.startDay =  this.convertDateToDay(cells[i][j]) ;
					activity.endDay   =  this.convertDateToDay(cells[i][j]) + 1 ;
				
				}
				
				campaign.activities.add(activity);
			}
			
			
			
			
			}
		
		data.add(campaign);
		
	}
	
	//p.println( data.get(4).activities.get(20).channel );
	//p.println( data.get(1).activities.get(30).startDay );
	
	
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
	
	int monthDay = Integer.parseInt(dateList[1].replaceAll("\\s+","") );
	int curDay 	 = 0;
	
	int[] curYear = ( checkForLeapYear(year) ) ? leapYearAr : yearAr;    					
		
	for (int i = 0; i < monthDay-1; i++) {
		
		curDay += curYear[i];
		
	}
	
	curDay += Integer.parseInt(dateList[0].replaceAll("\\s+","")); 
	//if(semester.indexOf("FW")>-1 ) curDay -= ( checkForLeapYear(year) ) ? 366/2 : 356/2;
	return curDay;
}


private void createDataStructure(){
	
	
	reader.firstCell();
	reader.firstRow();
	
	season =  reader.getString();
	
	String lastString = "";
	
	while(reader.hasMoreRows()){

		nrows++;
	
		while(reader.hasMoreCells()){
			
			cells[nrows-1][reader.getCellNum()] = reader.getString();
			
			
			
			if(nrows == 4){
				
				if (reader.getString().length() > 0) lastString = reader.getString();
//				p.println(reader.getString());
				cells[nrows-1][reader.getCellNum()] = lastString;
			//	p.println(lastString);
			}

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
