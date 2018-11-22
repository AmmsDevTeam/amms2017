package com.unittest;

import java.util.List;

import com.dao.ScheduleDao;
import com.entity.Schedule;

public class TestSchedule {
	public static void main(String[] args)
	{
		TestSchedule tester = new TestSchedule();
		tester.deleteSchedule();
	}
	
 	private void insertSchedule()
	{
 		ScheduleDao dao = new ScheduleDao();
 		Schedule schedule = new Schedule();
 		schedule.setCellPhoneNum("13012345678");
 		schedule.setFullName("李总");
 		schedule.setTimeArrange("09:00-10:30"); 		
 		schedule.setActivationPlace("一楼会议室1-108");
 		schedule.setActivationTitle("产能促进会");
		
		dao.insertSchedule(schedule);
		
 		Schedule s = new Schedule();
 		s.setCellPhoneNum("13012345678");
 		s.setFullName("李总");
 		s.setTimeArrange("10:45-11:30"); 		
 		s.setActivationPlace("车间、试制、表演场");
 		s.setActivationTitle("第3组参观");
		
		dao.insertSchedule(s);
	}
 	
    private void selectSchedule()
    {
    	ScheduleDao dao = new ScheduleDao();
    	String cellPhoneNum = "13012345678";
    	List<Schedule> scheduleList = dao.selectSchedule(cellPhoneNum);
    }
    
    private void deleteSchedule()
    {
    	ScheduleDao dao = new ScheduleDao();
    	String cellPhoneNum = "13012345678";
    	String result = dao.deleteSchedule(cellPhoneNum);
    }
}