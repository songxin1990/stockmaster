package com.songxin.stock.entity.highchart;
import java.io.Serializable;
import java.util.List;


/**
 * DESC 定义的这个类是映射highchart的属性的
 * @author Administrator
 *
 */
public class HighCharts implements Serializable{
	
	public HighCharts(){
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Title title;
	
	private Exporting exporting;
	
	private SubTitle subtitle;
	
	private XAxis xAxis;
	
	private YAxis yAxis;
	
	private Tooltip tooltip;
	
	private Legend legend;
	
//	private Series series;
	
	private List<Serie> series;

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Exporting getExporting() {
		return exporting;
	}

	public void setExporting(Exporting exporting) {
		this.exporting = exporting;
	}

	public SubTitle getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(SubTitle subtitle) {
		this.subtitle = subtitle;
	}

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}

	public YAxis getyAxis() {
		return yAxis;
	}

	public void setyAxis(YAxis yAxis) {
		this.yAxis = yAxis;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
