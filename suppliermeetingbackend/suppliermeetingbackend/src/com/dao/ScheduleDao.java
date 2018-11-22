package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entity.Enrollment;
import com.entity.Schedule;

public class ScheduleDao {	
	public String insertSchedule(Schedule schedule)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.insertSchedule";
            sqlSession.insert(statement, schedule);
            sqlSession.commit();
        }
        catch (IOException e) 
        {        	
            e.printStackTrace();
        } 
        finally 
        {
            if (sqlSession != null) 
            {
                sqlSession.close();
            }
            if (inputStream != null)
            {
                try 
                {
                    inputStream.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        return "SUCCESS";
    }
	
	public List<Schedule> selectSchedule(String cellPhoneNum)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        List<Schedule> scheduleList = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.selectSchedule";
            scheduleList = sqlSession.selectList(statement, cellPhoneNum);
        }
        catch (IOException e) 
        {        	
            e.printStackTrace();
        } 
        finally 
        {
            if (sqlSession != null) 
            {
                sqlSession.close();
            }
            if (inputStream != null)
            {
                try 
                {
                    inputStream.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        return scheduleList;
    }

	public String deleteSchedule(String cellPhoneNum)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.deleteSchedule";
            sqlSession.delete(statement, cellPhoneNum);
            sqlSession.commit();
        }
        catch (IOException e) 
        {        	
            e.printStackTrace();
        } 
        finally 
        {
            if (sqlSession != null) 
            {
                sqlSession.close();
            }
            if (inputStream != null)
            {
                try 
                {
                    inputStream.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        return "SUCCESS";
    }
}
