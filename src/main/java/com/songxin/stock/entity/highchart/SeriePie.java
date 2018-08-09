package com.songxin.stock.entity.highchart;
public class SeriePie {  
    // 系列名称  
    public String name;  
    // 封装饼状图数据  
    public Object data[][];  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public Object[][] getData() {  
        return data;  
    }  
    public void setData(Object[][] data) {  
        this.data = data;  
    }  
}  
