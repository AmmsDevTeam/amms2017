package com.tutorialspoint;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JsonHelper;

import com.dao.EnrollmentDao;
import com.dao.ScheduleDao;
import com.entity.Enrollment;
import com.entity.Schedule;

@Path("/SupplierService")
public class SupplierService
{
	EnrollmentDao dao = new EnrollmentDao();
	ScheduleDao scheduleDao = new ScheduleDao();
	
	@POST
    @Path("/enrollment/")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateEnrollment(@FormParam("content") String content, @Context HttpServletResponse servletResponse) throws IOException, JSONException, ParseException
	{    	
    	System.out.println("content : " + content);
    	Enrollment elt = new Enrollment();
        JsonHelper.toJavaBean(elt, content);
        return dao.updateEnrollment(elt);
	}
	
	@GET
	@Path("/enrollment/")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Enrollment> selectAllEnrollment()
	{
		return dao.selectAllEnrollment();
	}
	
	@PUT
    @Path("/enrollment/")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertEnrollment(@FormParam("content") String content, @Context HttpServletResponse servletResponse) throws IOException, JSONException, ParseException
	{    	
    	System.out.println("content : " + content);
    	Enrollment elt = new Enrollment();
        JsonHelper.toJavaBean(elt, content);
        return dao.insertEnrollment(elt);
	}
	
	@GET
	@Path("/enrollment/{cellPhoneNum}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Enrollment selectOneEnrollment(@PathParam("cellPhoneNum") String cellPhoneNum)
	{
		return dao.selectOneEnrollment(cellPhoneNum);
	}
	
	@GET
	@Path("/dinner/{dinnerDeskNum}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Enrollment> selectDinnerPartner(@PathParam("dinnerDeskNum") String dinnerDeskNum)
	{
		return dao.selectDinnerPartner(dinnerDeskNum);
	}
	
	@POST
    @Path("/checkin/")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String checkIn(@FormParam("content") String content, @Context HttpServletResponse servletResponse) throws IOException, JSONException, ParseException
	{    	
    	System.out.println("content : " + content);
    	Enrollment elt = new Enrollment();
        JsonHelper.toJavaBean(elt, content);
        return dao.checkIn(elt);
	}
	
	@PUT
    @Path("/schedule/")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertSchedule(@FormParam("content") String content, @Context HttpServletResponse servletResponse) throws IOException, JSONException, ParseException
	{    	
    	System.out.println("content : " + content);
    	Schedule sde = new Schedule();
        JsonHelper.toJavaBean(sde, content);
        return scheduleDao.insertSchedule(sde);
	}
	
	@GET
	@Path("/schedule/{cellPhoneNum}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Schedule> selectSchedule(@PathParam("cellPhoneNum") String cellPhoneNum)
	{
		return scheduleDao.selectSchedule(cellPhoneNum);
	}
	
	@GET
	@Path("/deleteschedule/{cellPhoneNum}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteSchedule(@PathParam("cellPhoneNum") String cellPhoneNum)
	{
		return scheduleDao.deleteSchedule(cellPhoneNum);
	}
}
