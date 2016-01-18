<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/import-taglib.jsp"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<stripes:layout-definition>
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
  <meta charset="utf-8"/>
  <title>${pageTitle}</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <stripes:layout-component name="css">
    <%@include file="/WEB-INF/jsp/common/import-css.jsp" %>
  </stripes:layout-component>
  <stripes:layout-component name="css_extend"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-container-bg-solid page-sidebar-closed-hide-logo page-header-fixed-mobile page-footer-fixed1">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
  <!-- BEGIN HEADER INNER -->
  <div class="page-header-inner">
    <!-- BEGIN LOGO -->
    <stripes:layout-component name="logo">
      <%@include file="/WEB-INF/jsp/common/admin/logo.jsp"%>
    </stripes:layout-component>
    <!-- END LOGO -->
    <!-- BEGIN RESPONSIVE MENU TOGGLER -->
    <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
    </a>
    <!-- END RESPONSIVE MENU TOGGLER -->
    <!-- BEGIN PAGE TOP -->
    <div class="page-top">
      <!-- BEGIN HEADER SEARCH BOX -->
      <!-- DOC: Apply "search-form-expanded" right after the "search-form" class to have half expanded search box -->
      <stripes:layout-component name="search-form">
        <%@include file="/WEB-INF/jsp/common/admin/search-form.jsp"%>
      </stripes:layout-component>
      <!-- END HEADER SEARCH BOX -->
      <!-- BEGIN TOP NAVIGATION MENU -->
      <stripes:layout-component name="top-menu">
        <%@include file="/WEB-INF/jsp/common/admin/top-menu.jsp"%>
      </stripes:layout-component>
      <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END PAGE TOP -->
  </div>
  <!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
  <!-- BEGIN SIDEBAR -->
  <div class="page-sidebar-wrapper">
    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
    <div class="page-sidebar navbar-collapse collapse">
     <stripes:layout-component name="menu">
       <%@include file="/WEB-INF/jsp/common/admin/menu.jsp"%>
     </stripes:layout-component>
    </div>
  </div>
  <!-- END SIDEBAR -->
  <!-- BEGIN CONTENT -->
  <div class="page-content-wrapper">
    <div class="page-content">
      <!-- BEGIN STYLE CUSTOMIZER -->
      <%--<stripes:layout-component name="theme-panel">--%>
        <%--<%@include file="/WEB-INF/jsp/common/admin/theme-panel.jsp"%>--%>
      <%--</stripes:layout-component>--%>
      <!-- END STYLE CUSTOMIZER -->
      <!-- BEGIN PAGE HEADER-->
      <%--<h3 class="page-title">--%>
        <%--Fluid Page <small>responsive boxed layout</small>--%>
      <%--</h3>--%>
      <div class="page-bar">
        <stripes:layout-component name="breadcrumb">
          <%@include file="/WEB-INF/jsp/common/admin/breadcrumb.jsp"%>
        </stripes:layout-component>
      </div>
      <!-- END PAGE HEADER-->
      <!-- BEGIN PAGE CONTENT-->
      <stripes:layout-component name="content"/>
      <!-- END PAGE CONTENT-->
    </div>
  </div>
  <!-- END CONTENT -->
  <!-- BEGIN QUICK SIDEBAR -->
  <!--Cooming Soon...-->
  <!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->
<stripes:layout-component name="footer">
  <%@include file="/WEB-INF/jsp/common/admin/footer.jsp" %>
</stripes:layout-component>
<stripes:layout-component name="js">
  <%@include file="/WEB-INF/jsp/common/import-js.jsp"%>
</stripes:layout-component>
<stripes:layout-component name="js-extend"/>
<script>
  jQuery(document).ready(function() {
    Metronic.init(); // init metronic core components
    Layout.init(); // init current layout
    Demo.init(); // init demo features
  });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
</stripes:layout-definition>