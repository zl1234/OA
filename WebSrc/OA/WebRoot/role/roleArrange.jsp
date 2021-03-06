<%@ page language="java" pageEncoding="UTF-8" import="com.icss.hit.bean.*" isELIgnored="false"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

  <head>
    
    <title>OA办公系统-角色分配</title>
    	<link href="favicon.ico" rel="shortcut icon" type="image/x-icon"/>
	<link href="favicon.ico" rel="icon" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link type="text/css" rel="stylesheet" rev="stylesheet" href="../css/general_style.css"/>
	<link type="text/css" rel="stylesheet" rev="stylesheet" href="../css/dtree.css"/>
	<script  type="text/javascript" src="./js/menu.js"></script>
	<script type="text/javascript" src="./js/tree.js"></script>
	<script type="text/javascript" src="./js/head.js"></script>
  </head>
  
  <body>
  
  	<div id="head">
  		<a href="../home/home.html" style="width:140px;">
  			<img id="headPicture" alt="转到首页" style="top: 0px; left: 20px; width: 140px; height: 120px; position:relative; border: 0px navy none;" src="./images/headHover2.jpg" onmouseover="changePicture();" onmouseout="backPicture();"></img>
  		</a>
  	</div>
	<div id="nav">
		<jsp:include page="../menu.jsp"></jsp:include>
	</div>
	<div id="content" style="font-size:13px;">
		<div style="color: #FFFFFF; padding-top: 6px;">
			<img alt="箭头" src="./images/arrow.gif" style=" position:relative; top: 3px; left: 6px;"/>
			<strong style="margin-left: 9px;">当前位置->系统角色分配</strong>
		</div>
		<hr class="line"/>
			
		<div class="left" id="leftPanel">
			<jsp:include page="../menu/sysMenu.jsp"></jsp:include>
		</div>

		<div id="middleButton">
			<a id="middleLink" style="height: 40px; width: 10px; cursor: pointer;" onclick="change();">
				<img style=" background-image:url('./images/middleButtonTiny1.jpg');  margin-top: 140px; border-style:none; width: 10px; height: 40px;" src="../images/middleButtonTiny1.jpg"/>
				<span class="popBox">单击这里打开/折叠左侧树状视图</span>
			</a>
		</div>
<%
	long userId = 1;
	if( request.getSession().getAttribute("UserId") != null ){
		userId = Long.parseLong(request.getSession().getAttribute("UserId").toString());
	}
	// 判断用户权限
	CheckPower check = new CheckPower(userId);
	check.getPower();

%>
		<div class="right" id="rightPanel">
  					
  					<table id="configWorkTable" class="shorterTable" cellspacing="0" width="100%">
  					<thead style="text-align:center; font-size: large; color: black; background-color: #dbdbda; font-family: 方正姚体;">系统角色分配</thead>
				<tr>
				<td colspan="7">
				请选择部门:
					<select name="suDept" id="suDept" onChange="window.location.href='roleArrange.do?dept='+this.options(this.selectedIndex).value">
					    <option value="0">-所有部门-</option>
					    <logic:present name="deptList">
							<logic:iterate id="dept" name="deptList" type="com.icss.hit.hibernate.vo.SysDept">
								<option value="<bean:write name="dept" property="sdId"/>" 
									<c:if test="${ requestScope.searchDept == dept.sdId }"> selected</c:if>>
								<bean:write name="dept" property="sdName"/>
						</option> 
					</logic:iterate>
					</logic:present>
					</select>
				</td>
				</tr>
				<logic:present name="allOtherUserInfoList">
				<tr>
					<td class="tableColumeHead" >员工号</td>
					<td class="tableColumeHead">姓名</td>
					<td class="tableColumeHead">部门</td>
					<td class="tableColumeHead">联系方式</td>
					<td class="tableColumeHead">系统角色</td>
					<%
						if( check.check(CheckPower.ADMIN_ROLE)){
					%>
					<td class="tableColumeHead">角色设置</td>
					<%
						}
						if( check.check(CheckPower.ADMIN_STUFF_INFO)){
					%>
					<td class="tableColumeHead">更改员工信息</td>
					<%
						}
					%>
					
				</tr>
			
				<logic:iterate id="allOtherUserInfo" name="allOtherUserInfoList" type="com.icss.hit.hibernate.vo.SysUser">
					<tr onmouseover="this.style.backgroundColor = '#ffffff';" onmouseout="this.style.backgroundColor = '#fefccc';">
					 <td >${ allOtherUserInfo.suUid } </td>
					 <td >${ allOtherUserInfo.suUsername}</td>
					 <td >${ allOtherUserInfo.sysDept.sdName }</td>
					 <td >${ allOtherUserInfo.suCellphone }</td>
					 <td >${ allOtherUserInfo.sysRole.srName }</td>
					 <%
						if( check.check(CheckPower.ADMIN_ROLE)){
					 %>
					 <td >
					 	<a href="setUpRole.do?suId=${ allOtherUserInfo.suId }&dept=${ requestScope.searchDept }&page=${ requestScope.pageNo }">设置 </a>
					 </td>
					 <%
						}
						if( check.check(CheckPower.ADMIN_STUFF_INFO)){
					 %>
					 <td style="padding: 2px 30px 2px 30px;">
						<a href="setUpInfo.do?suId=${ allOtherUserInfo.suId }&dept=${ requestScope.searchDept }&page=${ requestScope.pageNo }">修改 </a>
					 </td>
					 <%
					 	}
					 %>
					</tr>
				</logic:iterate>
				</logic:present>
			</table>
			<logic:present name="allOtherUserInfoList">
				${ requestScope.pageString }
			</logic:present>
			
			<logic:notPresent name="allOtherUserInfoList">
				<div class="notFound" align="center">
		    		<strong class="notFoundText">
		    			没有符合条件的员工
		    		</strong>
		    	</div>
			</logic:notPresent>
  					
    	</div>
    	</div>
    	<div id="bottom"></div>
  </body>
</html>




























