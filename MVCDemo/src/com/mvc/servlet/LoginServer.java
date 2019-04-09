package com.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mvc.dao.DAOUse;
import com.mvc.user.User;

public class LoginServer extends HttpServlet {
//用户登入
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取表单信息
			User user=new User();
			try {
				BeanUtils.populate(user, request.getParameterMap());
		//处理业务逻辑
			//获取的数据向DAOUse类中传递   并调用login方法查询数据库是否存在
				DAOUse dao=new DAOUse();
				//接受返回数据
				//从数据库验证返回的信息（u）
				User u=dao.login(user);
		//分发转向
				if(u!=null){
					request.setAttribute("u",user);
					request.getRequestDispatcher("/show.jsp").forward(request, response);
					
				}else{
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
