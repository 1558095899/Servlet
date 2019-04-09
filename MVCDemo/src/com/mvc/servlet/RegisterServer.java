package com.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.mvc.dao.DAOUse;
import com.mvc.user.User;

public class RegisterServer extends HttpServlet {
	//用户注册
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//获取表单信息
		DAOUse dao = new DAOUse();
		User user=new User();
		try {
			//注册    user对象中存在Date（）类型
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			//获取表单以map集合存放到user对象中
			BeanUtils.populate(user, request.getParameterMap());
		//处理业务逻辑
			//把数据转到DAOUse类的logister方法并进行添加数据操作
			dao.logister(user);
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//分发转向
	}	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
