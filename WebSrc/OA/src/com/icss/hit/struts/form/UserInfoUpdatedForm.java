/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.icss.hit.struts.form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 07-30-2009
 * 
 * XDoclet definition:
 * @struts.form name="userInfoUpdatedForm"
 */
public class UserInfoUpdatedForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** su_hobby property */
	private String su_hobby;

	/** su_email property */
	private String su_email;

	/** su_cellphone property */
	private String su_cellphone;

	/** su_tel property */
	private String su_tel;

	/** su_info property */
	private String su_info;

	private long su_id;
	/*
	 * Generated Methods
	 */
	
	public long getSu_id() {
		return su_id;
	}

	public void setSu_id(long su_id) {
		this.su_id = su_id;
	}

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(su_email!=null&&su_email.length() > 100)
		{
				errors.add("su_email", new ActionMessage("UserInfoUpdate.EmailTooLong"));
			
		}
		if(su_tel!=null&&su_tel.length()>20)
		{
				errors.add("su_tel", new ActionMessage("UserInfoUpdate.TelTooLong"));
				
		
		}
		if(su_cellphone!=null&&su_cellphone.length()>20)
		{
				errors.add("su_cellphone", new ActionMessage("UserInfoUpdate.CellPhoneTooLong"));
		
		}
		if(su_email!=null&&su_email.length()>0)
		{
			if(!su_email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
			{
				errors.add("su_email", new ActionMessage("UserInfoUpdate.Emailillegal"));
			}
		}
		if(su_tel!=null&&su_tel.length()>0)
		{
			if(!su_tel.matches("1\\d{10}|\\d{3}-\\d{8}|\\d{4}-\\d{7,8}"))
			{
				errors.add("su_tel", new ActionMessage("UserInfoUpdate.Telillegal"));
			}
		}
		if(su_cellphone!=null&&su_cellphone.length()>0)
		{
			if(!su_cellphone.matches("1\\d{10}|\\d{3}-\\d{8}|\\d{4}-\\d{7}"))
			{
				errors.add("su_cellphone", new ActionMessage("UserInfoUpdate.Cellphoneillegal"));
			}
		}
		
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the su_hobby.
	 * @return String
	 */
	public String getSu_hobby() {
		return su_hobby;
	}

	/** 
	 * Set the su_hobby.
	 * @param su_hobby The su_hobby to set
	 */
	public void setSu_hobby(String su_hobby) {
		this.su_hobby = su_hobby;
	}

	/** 
	 * Returns the su_email.
	 * @return String
	 */
	public String getSu_email() {
		return su_email;
	}

	/** 
	 * Set the su_email.
	 * @param su_email The su_email to set
	 */
	public void setSu_email(String su_email) {
		this.su_email = su_email;
	}

	/** 
	 * Returns the su_cellphone.
	 * @return String
	 */
	public String getSu_cellphone() {
		return su_cellphone;
	}

	/** 
	 * Set the su_cellphone.
	 * @param su_cellphone The su_cellphone to set
	 */
	public void setSu_cellphone(String su_cellphone) {
		this.su_cellphone = su_cellphone;
	}

	/** 
	 * Returns the su_tel.
	 * @return String
	 */
	public String getSu_tel() {
		return su_tel;
	}

	/** 
	 * Set the su_tel.
	 * @param su_tel The su_tel to set
	 */
	public void setSu_tel(String su_tel) {
		this.su_tel = su_tel;
	}

	/** 
	 * Returns the su_info.
	 * @return String
	 */
	public String getSu_info() {
		return su_info;
	}

	/** 
	 * Set the su_info.
	 * @param su_info The su_info to set
	 */
	public void setSu_info(String su_info) {
		this.su_info = su_info;
	}
}