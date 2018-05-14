package com.itheima.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class product {
	private String id; // ����
	private String productNum; // ��� Ψһ
	private String productName; // ����
	private String cityName; // ��������
	private Date departureTime; // ����ʱ��
	private double productPrice; // ��Ʒ�۸�
	private String productDesc; // ��Ʒ����
	private Integer productStatus; // ״̬ 0 �ر� 1 ����
	
	//��ʽ��ʱ������ת��Ϊ�ַ���
	public String getDepartureTimeStr() {
		return departureTime!=null?new SimpleDateFormat("yyyy-MM-dd HH:mm").format(departureTime):"ʱ�䲻��";
	}
	
	//��ʽ��״̬
	public String getProductStatusStr() {
		return productStatus==0?"�ر�":"����";
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
