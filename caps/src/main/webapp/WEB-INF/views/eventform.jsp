<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
    <title>Event</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>

    <form:form enctype="multipart/form-data" action="createevent" method="POST" class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="street">Street*</label>
            <div class="controls">
                <form:input path="street" placeholder="Street" />

            </div>
            <div class="control-group">
                <label class="control-label" for="state">State*</label>
                <div class="controls">
                    <form:input path="state" placeholder="Stet" />

                </div>
                <div class="control-group">
                    <label class="control-label" for="city">City*</label>
                    <div class="controls">
                        <form:input path="city" placeholder="City" />

                    </div>
                    <div class="control-group">
                        <label class="control-label" for="zipcode">Zipcode*</label>
                        <div class="controls">
                            <form:input path="zipcode" placeholder="zipcode" />

                        </div>
                        <div class="control-group">
                            <label class="control-label" for="date">Date*</label>
                            <div class="controls">
                                <form:input path="dare" placeholder="dd/mm/year" />

                            </div>

                        </div>
                        <button type="submit" class="btn">Post</button>


    </form:form>


</div>





<jsp:include page="footer.jsp"/>
</body>
</html>
