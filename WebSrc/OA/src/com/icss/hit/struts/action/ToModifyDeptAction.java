/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.icss.hit.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.icss.hit.bean.CheckPower;
import com.icss.hit.bean.DepartmentBean;
import com.icss.hit.bean.interfaces.Department;
import com.icss.hit.hibernate.vo.SysDept;
import com.icss.hit.struts.form.ModifyCardForm;

/** 
 * MyEclipse Struts
 * Creation date: 08-08-2009
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ToModifyDeptAction extends Action {
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
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// ��ǰ�û�ID
		long userId = -1;
		if( request.getSession().getAttribute("UserId") != null ){
			userId = Long.parseLong(request.getSession().getAttribute("UserId").toString());
		}else{
			return mapping.findForward("NullLogin");
		}
		// �ж��û�Ȩ��
		CheckPower check = new CheckPower(userId);
		check.getPower();
		if( !check.check(CheckPower.ADMIN_DEPT)){
			return mapping.findForward("NullLogin");
		}
		
		long sdid=1;

		//ͨ��urlȡ����Ƭ��id��ֵ
		String sdId = request.getParameter("sdId");
		try{
			if( sdId != null&&sdId.length()>0 ){
				 sdid = Long.parseLong(sdId);
			}
			else{
				sdid = ((ModifyCardForm)request.getAttribute("form")).getCd_id();
			}
		}catch( Exception e){
			return mapping.findForward("ToModifyDept.faild");
		}
		Department dt = new DepartmentBean();
		SysDept sd =dt.getDept(sdid);
		request.setAttribute("sysDept", sd);
		System.out.print("����3");
		return mapping.findForward("ToModifyDept.succeed");
	}
	}