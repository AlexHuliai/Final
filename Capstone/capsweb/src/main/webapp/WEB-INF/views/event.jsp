
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="_profile" value="active"/>
<c:if test="${empty loggedInUser}">
    <%-- <jsp:forward page="login.jsp"/> --%>
    <%response.sendRedirect("login");%>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <!-- css -->
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


</head>

<body>

    <!-- end toggle top area -->
    <!-- start header -->
    <jsp:include page="header.jsp"/>
    <!-- end header -->
    <section id="inner-headline">
        <div class="container">
            <div class="row">
                <div class="span4">
                    <div class="inner-heading">
                        <h2>Login</h2>
                    </div>
                </div>
                <div class="span8">
                    <ul class="breadcrumb">
                        <li><a href="#"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
                        <li><a href="index">Home</a><i class="icon-angle-right"></i></li>
                        <li class="active">Register</li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <section id="content">
        <div class="container">
            <div class="row">
                <div class="span6">
                    <h3 class="text-center">

                    </h3>
            <c:if test="${not emptyloggedInUser.email}">
                    <form:form action="${action}"  modelAttribute="events" method="post" class="form-horizontal">
                        <h3 class="text-center">
                            <span class="text-success"> </span>
                            <span class="text-error text-center"></span>
<%--                        ${events.user_id}==${loggedInUser.user_id}--%>
                        </h3>
                        <div class="control-group">
                            <label class="control-label" for="street">Your Email*</label>
                            <div class="controls">
                                <form:input path="user_email" placeholder="Email" />

                            </div>

                        </div>
                        <div class="control-group">
                            <label class="control-label" for="street">Street*</label>
                            <div class="controls">
                                <form:input path="street" placeholder="Street" />

                            </div>

                        </div>


                        <div class="control-group">
                            <label class="control-label" for="state">State *</label>
                            <div class="controls">
                                <form:input path="state" placeholder="State" />

                            </div>

                        </div>

                        <div class="control-group">
                            <label class="control-label" for="zipcode">Zipcode*</label>
                            <div class="controls">
                                <form:input path="zipcode" placeholder="Zipcode" />

                            </div>

                        </div>


                        <div class="control-group">
                            <label class="control-label" for="time">When*</label>
                            <div class="controls">
                                <form:input path="time" type="datetime-local" placeholder="When" />

                            </div>

                        </div>

                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" id="submit" class="btn btn-danger">Submit</button>
                                <a href="login" class="btn btn-success">Cancel</a>

                            </div>

                        </div>
                    </form:form>
            </c:if>

                </div>
                <div class="span6">
                    <!-- start flexslider -->
                    <div class="flexslider">
                        <ul class="slides">
                            <li>
                                <img src="static/img/works/full/image-01-full.jpg" alt="" />
                            </li>
                            <li>
                                <img src="static/img/works/full/image-02-full.jpg" alt="" />
                            </li>
                            <li>
                                <img src="static/img/works/full/image-03-full.jpg" alt="" />
                            </li>
                        </ul>
                    </div>
                    <!-- end flexslider -->
                </div>
            </div>
            <!-- divider -->
            <div class="row">
                <div class="span12">
                    <div class="solidline">
                    </div>
                </div>
            </div>
            <!-- end divider -->

        </div>
    </section>
    <jsp:include page="footer.jsp"/>
</div>
<a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
<!-- javascript
  ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
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

