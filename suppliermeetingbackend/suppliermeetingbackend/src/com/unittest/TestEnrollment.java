package com.unittest;

import java.util.List;

import com.dao.EnrollmentDao;
import com.entity.Enrollment;

public class TestEnrollment
{
	public static void main(String[] args)
	{
		TestEnrollment tester = new TestEnrollment();
		tester.selectAllEnrollment();
	}
	
 	private void updateEnrollment()
	{
 		EnrollmentDao dao = new EnrollmentDao();	
		Enrollment enrollment = new Enrollment();
		enrollment.setCellPhoneNum("13012345678");
		enrollment.setFullName("张总");
		enrollment.setTitle("总经理");
		enrollment.setGender("男");
		enrollment.setSupplierCode("100200");
		enrollment.setSupplierName("天津底盘厂");
		enrollment.setEstimateArriveTime("12月09日15点");
		enrollment.setIsVisited("是");
		enrollment.setIsSelfDrive("否");
		enrollment.setShuttleDestination("不坐班车");
		enrollment.setMeetingSeatNum("1区10排2座");
		enrollment.setDinnerSeatNum("5号桌");
		enrollment.setComment("已签到");
		
		dao.updateEnrollment(enrollment);
	}
	
	private void selectAllEnrollment()
	{
		EnrollmentDao ed = new EnrollmentDao();
		List<Enrollment> rtList = ed.selectAllEnrollment();
	}

 	private void insertEnrollment()
	{
 		EnrollmentDao dao = new EnrollmentDao();	
		Enrollment enrollment = new Enrollment();
		enrollment.setCellPhoneNum("13012345678");
		enrollment.setFullName("李总");
		enrollment.setTitle("总经理");
		enrollment.setGender("男");
		enrollment.setSupplierCode("100200");
		enrollment.setSupplierName("天津底盘厂");
		enrollment.setEstimateArriveTime("12月09日15点");
		enrollment.setIsVisited("是");
		enrollment.setIsSelfDrive("否");
		enrollment.setShuttleDestination("不坐班车");
		enrollment.setMeetingSeatNum("");
		enrollment.setDinnerSeatNum("");
		enrollment.setComment("");
		
		dao.insertEnrollment(enrollment);
	}
 	
 	private void selectOneEnrollment()
 	{
		EnrollmentDao ed = new EnrollmentDao();
		String cellPhoneNum = "13012345678";
		Enrollment enroll = ed.selectOneEnrollment(cellPhoneNum);
 	}
 	
 	private void selectDinnerPartner()
 	{	
		EnrollmentDao ed = new EnrollmentDao();
		List<Enrollment> rtList = ed.selectDinnerPartner("05");
 	}
 	
 	private void checkIn()
	{
 		EnrollmentDao dao = new EnrollmentDao();	
		Enrollment enrollment = new Enrollment();
		enrollment.setCellPhoneNum("13012345678");
		enrollment.setComment("已签到");
		
		dao.checkIn(enrollment);
	}
}
