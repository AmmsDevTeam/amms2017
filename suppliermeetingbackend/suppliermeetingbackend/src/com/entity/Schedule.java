package com.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Schedule {
	private static final long serialVersionUID = 1L;
	private String cell_phone_num;
	private String full_name;
	private String time_arrange;
	private String activation_place;
	private String activation_title;
	
	public String getCellPhoneNum() {
		return cell_phone_num;
	}

	public void setCellPhoneNum(String cell_phone_num) {
		this.cell_phone_num = cell_phone_num;
	}
	
	public String getFullName() {
		return full_name;
	}

	public void setFullName(String full_name) {
		this.full_name = full_name;
	}
	
	public String getTimeArrange() {
		return time_arrange;
	}

	public void setTimeArrange(String time_arrange) {
		this.time_arrange = time_arrange;
	}
	
	public String getActivationPlace() {
		return activation_place;
	}

	public void setActivationPlace(String activation_place) {
		this.activation_place = activation_place;
	}	
	
	public String getActivationTitle() {
		return activation_title;
	}

	public void setActivationTitle(String activation_title) {
		this.activation_title = activation_title;
	}
}
