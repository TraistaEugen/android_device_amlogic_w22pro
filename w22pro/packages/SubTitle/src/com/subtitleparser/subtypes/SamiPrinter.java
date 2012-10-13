package com.subtitleparser.subtypes;

import com.subtitleparser.SubtitleLine;
import com.subtitleparser.SubtitlePrinter;
import com.subtitleparser.SubtitleTime;
import com.subtitleparser.Subtitle;


/**
 * a .SRT subtitle printer.
 *
 * @author A. Ballatore
 */
public class SamiPrinter extends SubtitlePrinter{
	
	@Override
	public String print(SubtitleLine sl) throws Exception{
		String newLine=System.getProperty("line.separator");
		String tmpText;

		if (sl.isTextEmpty()){tmpText=newLine+newLine;}else tmpText=sl.getText();

		return sl.getSubN()+newLine+print(sl.getBegin())+" --> "+print(sl.getEnd())+newLine+tmpText+newLine;
	}
	
	
	@Override
	public String print(SubtitleTime st) throws Exception{
		String h,min,sec,mil;
		
		if(!st.getIsTimeSet()) throw new Exception("Time not set. I cannot write a correct .SRT subtitle.");
		
		h=Subtitle.format(st.getH(),2);
		min=Subtitle.format(st.getMin(),2);
		sec=Subtitle.format(st.getSec(),2);
		mil=Subtitle.format(st.getMil(),3);
		
		return h+":"+min+":"+sec+","+mil;
	}
	
}
