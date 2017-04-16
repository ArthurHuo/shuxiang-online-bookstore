package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 编码过滤器
 * 用于解决前台JSP页面和JAVA代码中使用了不同的字符集进行编码的时候就会出现的表单提交的数据或者上传/下载中文名称文件出现乱码的问题
 *  */
public class CharacterEncodingFilter implements Filter {

	String encoding = null;
	FilterConfig filterConfig = null;
	
	/** 初始化方法 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	/** 过滤处理方法 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (encoding!=null){
			//对请求进行编码设置
			request.setCharacterEncoding(encoding);
		}
		//将处理权转交给下一个处理器
		chain.doFilter(request,response);
	}

	/** 销毁方法 */
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

}