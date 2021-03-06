
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
    <link href="static/skins/blue.css" rel="stylesheet" />
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
                    <h2>Change Password</h2>
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
                <div id="reset2" class="form-horizontal">

                    <div class="modal-body">
                        <form action="resetcode2" class="form-horizontal" method="post">
                            <div class="control-group">
                                <label class="control-label" for="email">Email</label>
                                <div class="controls">
                                    <input type="email" name="email" placeholder="Email">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="code">Reset Code</label>
                                <div class="controls">
                                    <input type="text" name="code" placeholder="Code">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="password">New Password</label>
                                <div class="controls">
                                    <input type="password" name="password" placeholder="Password">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="pass2">Repeat password</label>
                                <div class="controls">
                                    <input type="password" name="pass2" placeholder="Password">
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <button class="btn btn-green" type="submit"  >Submit</button>
                                    <button class="btn btn-danger" href="login"  >Cancel</button>
                                </div>



                            </div>
                        </form>
                    </div>
                </div>
            </div>
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

