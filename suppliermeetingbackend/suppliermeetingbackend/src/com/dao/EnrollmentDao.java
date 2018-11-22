package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entity.Enrollment;

public class EnrollmentDao
{
	public String updateEnrollment(Enrollment enrollment)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.updateEnrollment";
            sqlSession.update(statement, enrollment);
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
	
	public List<Enrollment> selectAllEnrollment()
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        List<Enrollment> enrollList = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.selectAllEnrollment";
            enrollList = sqlSession.selectList(statement);
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
        return enrollList;
    }

	public String insertEnrollment(Enrollment enrollment)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.insertEnrollment";
            sqlSession.insert(statement, enrollment);
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
	
	public Enrollment selectOneEnrollment(String cellPhoneNum)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        Enrollment enroll = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.selectOneEnrollment";
            enroll = sqlSession.selectOne(statement, cellPhoneNum);
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
        
        return enroll;
    }
	
	public List<Enrollment> selectDinnerPartner(String dinnerDeskNum)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        List<Enrollment> enrollList = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.selectDinnerPartner";
            enrollList = sqlSession.selectList(statement, dinnerDeskNum);
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
        
        return enrollList;
    }
	
	public String checkIn(Enrollment enrollment)
	{
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try 
        {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String statement = "com.mapping.SupplierMapper.checkIn";
            sqlSession.update(statement, enrollment);
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
