/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.action;

import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.ORM.*;
import com.base.*;
import com.service.*;
import com.struts.form.MemberForm;

/** 
 * MyEclipse Struts
 * 
 * 
 * XDoclet definition:
 * @struts.action path="/mem" name="memberForm" input="/reg.jsp" parameter="method" scope="request" validate="true"
 */
public class MemAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward reg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MemberForm memberForm = (MemberForm) form;
		MemService service = new MemServiceImpl();
		ActionMessages msgs = new ActionMessages();
		try{
			Member mem = new Member();
			mem.setMemberlevel(service.loadMemberLevel(memberForm.getMemberlevel()));
			mem.setMemberName(memberForm.getMemberName().trim());
			mem.setLoginName(memberForm.getLoginName().trim());
			mem.setLoginPwd(memberForm.getLoginPwd().trim());
			mem.setLoginTimes(new Integer(0));
			mem.setRegDate(new Date());			
			mem.setLastDate(new Date());
			mem.setAddress(memberForm.getAddress().trim());
			mem.setPhone(memberForm.getPhone().trim());
			mem.setZip(memberForm.getZip().trim());
			if (memberForm.getEmail()!=null){
				mem.setEmail(memberForm.getEmail().trim());
			}			
			boolean status = service.addMember(mem);
			if (status){
				msgs.add("addMemStatus",new ActionMessage(Constants.MEMBER_REG_SUC_KEY));
			}else{				
				msgs.add("addMemStatus",new ActionMessage(Constants.MEMBER_REG_FAIL_KEY));
			}
			saveErrors(request, msgs);
		}catch(Exception ex){
			logger.info("在执行MemAction类中的reg方法时出错：\n");
			ex.printStackTrace();
		}
		return mapping.getInputForward();
	}
	
	public ActionForward browseWord(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List wordList = null;
		WordService service = new WordServiceImpl();
		int pageNo = 1; //页号
		int pageSize = 6; //每页记录数
		int totals = 0; //记录总数
		int totalPages = 0; //总页数
		if (request.getParameter("pageNo")!=null)pageNo = Integer.parseInt(request.getParameter("pageNo"));			
		try{
			wordList = service.browseWord(pageSize, pageNo);
			totals = service.countWord();
			if (wordList!=null&&wordList.size()>0)request.setAttribute("wordList", wordList);
			//设置总记录数、总页数、当前页号
			totalPages = totals / pageSize;
			if ((totals % pageSize)>0) totalPages++; 
			request.setAttribute("totals",new Integer(totals).toString());
			request.setAttribute("totalPages",new Integer(totalPages).toString());
			request.setAttribute("pageNo",new Integer(pageNo).toString());			
		}catch(Exception ex){
			logger.info("在执行MemAction类中的browseWord方法时出错：\n");
			ex.printStackTrace();
		}
		return mapping.findForward("browseWord");		
	}
	
	public ActionForward addWord(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionMessages msgs = new ActionMessages();
		List wordList = null;
		WordService service = new WordServiceImpl();
		int pageNo = 1; //页号
		int pageSize = 6; //每页记录数
		int totals = 0; //记录总数
		int totalPages = 0; //总页数
		if (request.getParameter("pageNo")!=null)pageNo = Integer.parseInt(request.getParameter("pageNo"));			
		try{
			//判断会员是否已成功登录
			Member mem = (Member)request.getSession().getAttribute("member");			
			if(mem==null){
				msgs.add("addWordStatus",new ActionMessage(Constants.WORD_ADD_WARNING_KEY));
			}else{
				boolean status = false;
				String title = request.getParameter("wordTitle");
				String content = request.getParameter("content");
				Leaveword word = new Leaveword();
				word.setMember(mem);
				word.setTitle(title.trim());
				word.setContent(content.trim());
				word.setLeaveDate(new Date());
				status = service.addWord(word);
				if (status){
					msgs.add("addWordStatus",new ActionMessage(Constants.WORD_ADD_SUC_KEY));
				}else{
					msgs.add("addWordStatus",new ActionMessage(Constants.WORD_ADD_FAIL_KEY));
				}
			}
			saveErrors(request, msgs);
			wordList = service.browseWord(pageSize, pageNo);
			totals = service.countWord();
			if (wordList!=null&&wordList.size()>0)request.setAttribute("wordList", wordList);
			//设置总记录数、总页数、当前页号
			totalPages = totals / pageSize;
			if ((totals % pageSize)>0) totalPages++; 
			request.setAttribute("totals",new Integer(totals).toString());
			request.setAttribute("totalPages",new Integer(totalPages).toString());
			request.setAttribute("pageNo",new Integer(pageNo).toString());			
		}catch(Exception ex){
			logger.info("在执行MemAction类中的addWord方法时出错：\n");
			ex.printStackTrace();
		}
		return mapping.findForward("browseWord");		
	}
	
	public ActionForward loadMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try{
			//判断会员是否已成功登录
			Member mem = (Member)request.getSession().getAttribute("member");			
			if(mem==null){
				forward = mapping.findForward("memSorry");
			}else{
				forward = mapping.findForward("loadMember");
			}
		}catch(Exception ex){
			logger.info("在执行MemAction类中的loadMember方法时出错：\n");
			ex.printStackTrace();
		}
		return forward;		
	}
	
	public ActionForward updateMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MemService service = new MemServiceImpl();
		ActionMessages msgs = new ActionMessages();
		try{
			Member mem = (Member)request.getSession().getAttribute("member");
			mem.setMemberName(request.getParameter("memberName").trim());
			mem.setLoginName(request.getParameter("loginName").trim());
			if(request.getParameter("loginPwd")!=null&&request.getParameter("loginPwd").length()>0){
				mem.setLoginPwd(request.getParameter("loginPwd").trim());
			}
			mem.setPhone(request.getParameter("phone").trim());
			mem.setAddress(request.getParameter("address").trim());
			mem.setZip(request.getParameter("zip").trim());
			if(request.getParameter("email")!=null&&request.getParameter("email").length()>0){
				mem.setEmail(request.getParameter("email").trim());
			}
			request.getSession().setAttribute("member",mem);
			boolean status = service.updateMember(mem);
			if (status){
				msgs.add("modiMemberStatus",new ActionMessage(Constants.MEMBER_MODI_SUC_KEY));
			}else{				
				msgs.add("modiMemberStatus",new ActionMessage(Constants.MEMBER_MODI_FAIL_KEY));
			}
			saveErrors(request, msgs);
		}catch(Exception ex){
			logger.info("在执行MemAction类中的updateMember方法时出错：\n");
			ex.printStackTrace();
		}
		return mapping.findForward("loadMember");		
	}
}