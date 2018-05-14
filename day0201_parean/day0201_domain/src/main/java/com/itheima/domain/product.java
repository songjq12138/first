package com.itheima.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class product {
	private String id; // 主键
	private String productNum; // 编号 唯一
	private String productName; // 名称
	private String cityName; // 出发城市
	private Date departureTime; // 出发时间
	private double productPrice; // 产品价格
	private String productDesc; // 产品描述
	private Integer productStatus; // 状态 0 关闭 1 开启
	
	//格式化时间类型转换为字符串
	public String getDepartureTimeStr() {
		return departureTime!=null?new SimpleDateFormat("yyyy-MM-dd HH:mm").format(departureTime):"时间不对";
	}
	
	//格式化状态
	public String getProductStatusStr() {
		return productStatus==0?"关闭":"开启";
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	@Override
	public String toString() {
		return "product [id=" + id + ", productNum=" + productNum + ", productName=" + productName + ", cityName="
				+ cityName + ", departureTime=" + departureTime + ", productPrice=" + productPrice + ", productDesc="
				+ productDesc + ", productStatus=" + productStatus + "]";
	}
	
	
}
