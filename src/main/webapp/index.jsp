<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh_CN">
<!--<![endif]-->
<head>
  <meta charset="utf-8"/>
  <title>用户登录</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <!-- BEGIN GLOBAL MANDATORY STYLES -->
  <link href="${ctx}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/assets/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/assets/plugins/uniform/css/uniform.default.min.css" rel="stylesheet" type="text/css"/>
  <!-- END GLOBAL MANDATORY STYLES -->
  <!-- BEGIN THEME STYLES -->
  <link href="${ctx}/assets/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/assets/css/plugins.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/assets/css/layout.css" rel="stylesheet" type="text/css"/>
  <link id="style_color" href="${ctx}/assets/css/themes/default.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/assets/css/custom.css" rel="stylesheet" type="text/css"/>
  <!-- END THEME STYLES -->
  <link rel="shortcut icon" href="favicon.ico"/>
  <link href="${ctx}/assets/plugins/select2/select2.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/assets/css/login-soft.css" rel="stylesheet" type="text/css"/>
</head>
<body class="login">
<div class="logo">
  <a href="#">
    <img src="${ctx}/assets/img/logo-big.png" alt=""/>
  </a>
</div>
<div class="menu-toggler sidebar-toggler">
</div>
<div class="content">
  <form class="login-form" action="#" method="post">
    <h3 class="form-title">系统登录</h3>

    <div class="alert alert-danger display-hide">
      <button class="close" data-close="alert"></button>
			<span>
			 请输入用户名和密码。
      </span>
    </div>
    <div class="form-group">
      <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
      <label class="control-label visible-ie8 visible-ie9">用户名</label>

      <div class="input-icon">
        <i class="fa fa-user"></i>
        <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">密码</label>

      <div class="input-icon">
        <i class="fa fa-lock"></i>
        <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password"/>
      </div>
    </div>
    <div class="form-actions">
      <label class="checkbox">
        <input type="checkbox" name="remember" value="1"/> 记住我 </label>
      <button type="submit" class="btn blue pull-right">
        登录 <i class="m-icon-swapright m-icon-white"></i>
      </button>
    </div>
  </form>
</div>
<!-- END LOGIN -->
<!-- BEGIN COPYRIGHT -->
<div class="copyright">
  2016 &copy; 中公网医疗信息技术有限公司
</div>
<script src="${ctx}/assets/plugins/respond.min.js"></script>
<script src="${ctx}/assets/plugins/excanvas.min.js"></script>
<script src="${ctx}/assets/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${ctx}/assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/select2/select2.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/assets/js/metronic.js" type="text/javascript"></script>
<script src="${ctx}/assets/js/layout.js" type="text/javascript"></script>
<script src="${ctx}/assets/js/demo.js" type="text/javascript"></script>
<script src="${ctx}/assets/js/login-soft.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/select2/select2.min.js" type="text/javascript"></script>
<script>
  jQuery(document).ready(function () {
    Metronic.init(); // init metronic core components
    Layout.init(); // init current layout
    Login.init();
    Demo.init();
    // init background slide images
    $.backstretch([
          "${ctx}/assets/img/bg/1.jpg",
          "${ctx}/assets/img/bg/2.jpg",
          "${ctx}/assets/img/bg/3.jpg",
          "${ctx}/assets/img/bg/4.jpg"
        ], {
          fade: 1000,
          duration: 8000
        }
    );
  });
</script>
</body>
</html>