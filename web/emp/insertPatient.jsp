<%-- 
    Document   : insertPatient
    Created on : Jul 1, 2017, 6:29:40 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Patient</title>
    </head>
    <body>
        <h1>Insert Patient</h1>
        <h4>Welcome <s:property value="#session.name"/></h4>
        <s:form action="insertPatientAction" method="post">
            <s:textfield name="username" label="Patient ID"/>
            <s:textfield name="name" label="Patient name"/>
            <s:checkbox name="isMale" label="Is Male"/>
            <s:date var="formatedDOB" format="yyyy-MM-dd" name="%{DOB}"/>
            <s:textfield type="date" name="DOB" value="%{formatedDOB}" label="Date Of Birth"/>
            <s:textfield name="address" label="Address"/>
            <s:textfield name="email" label="Email"/>
            <s:textfield name="phone" label="Phone"/>
            <s:textfield name="password" label="Password"/>
            <s:textfield name="status" label="Patient Status"/>
            <s:submit value="Insert"/>
        </s:form>
        <a href="search.jsp"><button>Back</button></a>
        
        <p style="color: green;">${request.success}</p>
        <p style="color: red;">${request.error}</p>
    </body>
</html>
