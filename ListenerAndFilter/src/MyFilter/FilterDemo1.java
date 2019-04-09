package MyFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterDemo1 implements Filter{

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter执行了");
		String initParameter = filterConfig.getInitParameter("encoding");
//		System.out.println(initParameter);
		//统一编码过滤  utf-8
		request.setCharacterEncoding(initParameter);
		/*//通过post方式获取表单   并设置统一编码方式
		HttpServletRequest req=(HttpServletRequest)request;
		req.setCharacterEncoding("utf-8");*/
		//放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
