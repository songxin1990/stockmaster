package com.songxin.stock.entity.highchart;

import java.io.Serializable;
import java.util.List;

public class XAxis implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> categories;

	private Long tickInterval;
	// private Labels labels;
	
	public XAxis(){
		
	}
	
	public XAxis(List<String> categories) {
		this.categories = categories;
	}

	public XAxis(List<String> categories, Long tickInterval) {
		this.categories = categories;
		this.tickInterval = tickInterval;
	}

	
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Long getTickInterval() {
		return tickInterval;
	}

	public void setTickInterval(Long tickInterval) {
		this.tickInterval = tickInterval;
	}

}
