package com.songxin.stock.entity.highchart;
/**
 * DESC 对应highchart中的title属性
 * title下面有align，floating,margin等很多属性
 * @author Administrator
 *
 */
public class Title {
	
	private String text;
	
	//相对水平偏移量
	private int x;
	
//	//水平对齐方式,有“"left", "center" and "right"可选，分别对应“左对齐”、“居中对齐”、“右对齐”。
//	private String align;
	
	
		
	//是否浮动
	private Boolean floating;
//	//标题和图表区的间隔，当有副标题，表示标题和副标题之间的间隔。
//	private int margin;
//	
//	//标题样式。用于设置文字颜色、字体、字号，但是字体的对齐则使用algin、x和y元素。默认是： { "color": "#333333", "fontSize": "18px" }
//	//默认是： [object Object].
//	private Style style;
//	
//	//标题是否使用HTML渲染，是否解析html标签，设置解析后，可以使用例如 a 等 html 标签。
//	private Boolean useHtml;
//	//标题垂直对齐方式。有“top”，”middle“和“bottom” 可选，分别对应“顶对齐”、“居中对齐”、“底对齐”。并且当给定一个值后，该标题将表现为浮动。
//	private String verticalAlign;
//	
//	//相对竖直偏移量
//	private int y;
//	public String getAlign() {
//		return align;
//	}
//	public void setAlign(String align) {
//		this.align = align;
//	}
//	public Boolean getFloating() {
//		return floating;
//	}
//	public void setFloating(Boolean floating) {
//		this.floating = floating;
//	}
//	public int getMargin() {
//		return margin;
//	}
//	public void setMargin(int margin) {
//		this.margin = margin;
//	}
//	public Style getStyle() {
//		return style;
//	}
//	public void setStyle(Style style) {
//		this.style = style;
//	}
//	
//	public Boolean getUseHtml() {
//		return useHtml;
//	}
//	public void setUseHtml(Boolean useHtml) {
//		this.useHtml = useHtml;
//	}
//	public String getVerticalAlign() {
//		return verticalAlign;
//	}
//	public void setVerticalAlign(String verticalAlign) {
//		this.verticalAlign = verticalAlign;
//	}
//	
//	public int getY() {
//		return y;
//	}
//	public void setY(int y) {
//		this.y = y;
//	}
//	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	
	

}
