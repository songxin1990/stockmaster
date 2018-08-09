package com.songxin.stock.entity.highchart;
import java.io.Serializable;
import java.util.List;

public class YAxis  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private YAxisTitle title;
	
	private List<PlotLine> plotLines;

	public YAxisTitle getTitle() {
		return title;
	}

	public void setTitle(YAxisTitle title) {
		this.title = title;
	}

	public List<PlotLine> getPlotLines() {
		return plotLines;
	}

	public void setPlotLines(List<PlotLine> plotLines) {
		this.plotLines = plotLines;
	}


	
	
	
	
	
	

}
