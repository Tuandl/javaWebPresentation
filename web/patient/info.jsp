<%-- 
    Document   : info
    Created on : Jul 1, 2017, 12:05:41 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Page</title>
    </head>
    <body>
        <h1>Update Profile</h1>
        <h4>Welcome <s:property value="#session.name"/></h4>
        <s:form action="updatePatientAction" method="post">
            <s:textfield name="username" value="%{username}" label="Patient ID" readonly="true"/>
            <s:textfield name="name" value="%{name}" label="Patient Name"/>
            <s:checkbox name="isMale" value="%{isMale}" label="Is Male" labelposition="left"/>
            <s:date name="DOB" format="yyyy-MM-dd" var="formatedDOB"/>
            <s:textfield type="date" name="DOB" label="Date Of Birth" value="%{#formatedDOB}"/>
            <s:textfield name="address" label="Address" value="%{address}"/>
            <s:textfield name="email" label="Email" value="%{email}"/>
            <s:textfield name="phone" label="Phone" value="%{phone}"/>
            <s:submit value="Update"/>
        </s:form>
        <p style="color: green"><s:property value="#request.success"/></p>
        <p style="color: red"><s:property value="#request.fail"/></p>
    </body>
</html>
