package com.songxin.stock.entity.highchart;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DESC 这个类是用于HighStock中Series展示中的data结构
 * @author Administrator
 *
 */
public class TimeDataPair  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date  pairTime;
	
	private double  pairData;

	public Date getPairTime() {
		return pairTime;
	}

	public void setPairTime(Date pairTime) {
		this.pairTime = pairTime;
	}

	public double getPairData() {
		return pairData;
	}

	public void setPairData(double pairData) {
		this.pairData = pairData;
	}

}
