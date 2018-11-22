package com.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cell_phone_num;
	private String full_name;
	private String title;
	private String gender;
	private String supplier_code;
	private String supplier_name;
	private String estimate_arrive_time;
	private String is_visited;
	private String is_self_drive;
	private String shuttle_destination;
	private String meeting_seat_num;
	private String dinner_seat_num;
	private String comment;
	
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}	
	
	public String getSupplierCode() {
		return supplier_code;
	}

	public void setSupplierCode(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	
	public String getSupplierName() {
		return supplier_name;
	}

	public void setSupplierName(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	
	public String getEstimateArriveTime() {
		return estimate_arrive_time;
	}

	public void setEstimateArriveTime(String estimate_arrive_time) {
		this.estimate_arrive_time = estimate_arrive_time;
	}
	
	public String getIsVisited() {
		return is_visited;
	}

	public void setIsVisited(String is_visited) {
		this.is_visited = is_visited;
	}
	
	public String getIsSelfDrive() {
		return is_self_drive;
	}

	public void setIsSelfDrive(String is_self_drive) {
		this.is_self_drive = is_self_drive;
	}
	
	public String getShuttleDestination() {
		return shuttle_destination;
	}

	public void setShuttleDestination(String shuttle_destination) {
		this.shuttle_destination = shuttle_destination;
	}
	
	public String getMeetingSeatNum() {
		return meeting_seat_num;
	}

	public void setMeetingSeatNum(String meeting_seat_num) {
		this.meeting_seat_num = meeting_seat_num;
	}
	
	public String getDinnerSeatNum() {
		return dinner_seat_num;
	}

	public void setDinnerSeatNum(String dinner_seat_num) {
		this.dinner_seat_num = dinner_seat_num;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
