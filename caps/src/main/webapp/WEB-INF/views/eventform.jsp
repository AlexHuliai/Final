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
<link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
<link href="static/css/bootstrap.css" rel="stylesheet" />
<link href="static/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="static/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="static/css/jcarousel.css" rel="stylesheet" />
<link href="static/css/flexslider.css" rel="stylesheet" />
<link href="static/css/style.css" rel="stylesheet" />
<!-- Theme skin -->
<link href="static/skins/default.css" rel="stylesheet" />
<!-- boxed bg -->
<link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
<link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
<link rel="shortcut icon" href="ico/favicon.png" />

<jsp:include page="header.jsp"/>
<div>

    <form:form enctype="multipart/form-data" action="${eventform}" method="POST" modelAttribute="event" class="form-horizontal">
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
                                <form:input path="date" placeholder="dd/mm/year" />

                            </div>

                        </div>
                        <button type="submit" id="eventform" class="btn">Post</button>


    </form:form>


</div>





<jsp:include page="footer.jsp"/>
                    <script src="static/js/jquery.js"></script>
                    <script src="static/js/jquery.easing.1.3.js"></script>
                    <script src="static/js/bootstrap.js"></script>
                    <script src="static/js/jcarousel/jquery.jcarousel.min.js"></script>
                    <script src="static/js/jquery.fancybox.pack.js"></script>
                    <script src="static/js/jquery.fancybox-media.js"></script>
                    <script src="static/js/google-code-prettify/prettify.js"></script>
                    <script src="static/js/portfolio/jquery.quicksand.js"></script>
                    <script src="static/js/portfolio/setting.js"></script>
                    <script src="static/js/jquery.flexslider.js"></script>
                    <script src="static/js/jquery.nivo.slider.js"></script>
                    <script src="static/js/modernizr.custom.js"></script>
                    <script src="static/js/jquery.ba-cond.min.js"></script>
                    <script src="static/js/jquery.slitslider.js"></script>
                    <script src="static/js/animate.js"></script>

                    <!-- Template Custom JavaScript File -->
                    <script src="static/js/custom.js"></script>
</body>
</html>
