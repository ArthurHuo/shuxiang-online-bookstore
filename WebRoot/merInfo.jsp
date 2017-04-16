<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/struts-html" prefix="html" %>
<%@ taglib uri="/struts-logic" prefix="logic" %>
<jsp:useBean id="JSONRPCBridge" scope="session" class="com.metaparadigm.jsonrpc.JSONRPCBridge"/>
<jsp:useBean id="ajax" class="com.base.AjaxBean"></jsp:useBean>
<%
	JSONRPCBridge.registerObject("ajax",ajax);
%>
<html>
<head>
<title><bean:message key="website.title"/></title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="JS/jsonrpc.js"></script>
</head>
<body class="body">
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:1px; border-style:solid; border-color:#888888">
  <tr>
    <td width="20">&nbsp;</td>
    <TD height="50" align="right" valign="bottom">
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0  background="images/headbg.gif">
         <TR align="center">
         <TD height="100">
			<IMG src="images/logo.png" align="absmiddle" width="90" height="90">
         </TD> 
         <TD>
			<IMG src="images/searchlogo.gif" align="absmiddle" width="25" height="25"> 
		   <INPUT id="qKey" name="qKey" value="��Ʒ�ؼ���" onClick="this.value=''"> 
           <select id="category">
          	<option value="0">������Ʒ</option>
	      	  <logic:present name="cateList">
		  	<logic:iterate id="cate" name="cateList" type="com.ORM.Category">
				<option value="${cate.id}">${cate.cateName}</option>					  		
		  	</logic:iterate>
		     </logic:present>	       	
           </select>		
		    <A href="javascript:QuickSearch()"><IMG src="images/icon_search.gif" align="absmiddle" border="0"></A>    	
         </TD> 
         </TR>
        </TABLE>
    </TD>
    <td width="20">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TR align="center">
          <TD valign="top" width="9"><IMG src="images/icon02.gif"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="mer.do?method=browseIndexMer"><span class="whiteTitle"><bean:message key="menu.item1"/></span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="cart.do?method=browseCart"><span class="whiteTitle"><bean:message key="menu.item2"/></span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="order.do?method=browseOrder"><span class="whiteTitle"><bean:message key="menu.item3"/></span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="mem.do?method=browseWord"><span class="whiteTitle"><bean:message key="menu.item4"/></span></A>
		  </TD>
          <TD background="images/Bule_06.gif" width="2"></TD>
          <TD class="header_menu" align="middle">
		  	<A href="mem.do?method=loadMember"><span class="whiteTitle"><bean:message key="menu.item5"/></span></A>
		  </TD>
          <TD vAlign=top width=7><IMG src="images/icon07.gif"></TD>
        </TR>
    </TABLE></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
		<table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
		  <tr>
			<td height="80" colspan="2"><IMG src="images/icon_goods.gif" width="150" height="29"></td>
		  </tr>
		  <tr>
			<td colspan="2"></td>
		  </tr>
		  <tr>
			<td height="40" colspan="2" align="left" class="text">
              	<logic:present name="mer" property="picture">
					<img src=".${mer.picture}" border="0" align="left" width="350" height="350">
				</logic:present><br><br>
				&nbsp;<bean:message key="mer.category"/>��${mer.category.cateName}<br>
				&nbsp;<bean:message key="mer.name"/>��${mer.merName}<br>
				&nbsp;<bean:message key="mer.model"/>��${mer.merModel}<br>
				&nbsp;<bean:message key="mer.price"/>����${mer.price}<br>
				<logic:equal name="mer" property="special" value="1">
					&nbsp;<font color="red"><b><bean:message key="mer.sprice"/>����${mer.sprice}</b></font><br>
				</logic:equal>				
				&nbsp;<bean:message key="mer.manufacturer"/>��${mer.manufacturer}<br>
				&nbsp;<bean:message key="mer.leaveFactoryDate"/>��${mer.leaveFactoryDate}<br>
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="cart.do?method=addCart&id=${mer.id}"><img src="images/icon_buy.gif" border=0 align="center"></a>
			
			</td>
		  </tr>
		   <tr>
		    
		   <td colspan="2" height="20" align="center">
			<!--	<a href="cart.do?method=addCart&id=${mer.id}"><img src="images/icon_buy.gif" border=0></a>-->
			</td>
		   
		   </tr>
		   <tr>
		   <td height="40" colspan="2" align="left" class="C_Goods_Border">

		   &nbsp;<bean:message key="mer.desc"/>��${mer.merDesc}<br>
		   </td>
		   </tr>
		 <!-- <tr>
			<td colspan="2" height="40" align="center">
				<a href="cart.do?method=addCart&id=${mer.id}"><img src="images/icon_buy.gif" border=0></a>
			</td>
		  </tr>-->
		</table>
	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="30">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="30" bgcolor="#1e0101" class="whiteText" align="center">
		<bean:message key="website.foot"/>	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="20">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<script language="javascript">
	//������Ʒ���������б�
	jsonrpc = new JSONRpcClient("JSON-RPC");
	var result = jsonrpc.ajax.getCategory();
	for (var i=0;i<result.length;i++){
		option =document.createElement("OPTION");
		option.value = result[i][0];
		option.text = result[i][1];
		document.all.category.options.add(option);
	}
	
	//������Ʒ
	function QuickSearch(){
		var url = "mer.do?method=searchMer&cateid="+document.all.category.value;
		var key = document.all.qKey.value;
		if (key !=null && key!="��Ʒ�ؼ���" && key.length>0)url = url+"&key="+key;
		window.location = url;
	}
</script>	
</body>
</html>