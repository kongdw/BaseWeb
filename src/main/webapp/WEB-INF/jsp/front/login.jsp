<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<stripes:layout-definition>
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
    <stripes:layout-component name="css">
      <%@include file="/WEB-INF/jsp/common/import-css.jsp" %>
    </stripes:layout-component>
    <stripes:layout-component name="css-extend"/>
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
    <stripes:layout-component name="content"/>
  </div>
  <!-- END LOGIN -->
  <!-- BEGIN COPYRIGHT -->
  <div class="copyright">
    2016 &copy; 中公网医疗信息技术有限公司
  </div>
  <stripes:layout-component name="js">
    <%@include file="/WEB-INF/jsp/common/import-js.jsp" %>
  </stripes:layout-component>
  <stripes:layout-component name="js-extend"/>
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
</stripes:layout-definition>