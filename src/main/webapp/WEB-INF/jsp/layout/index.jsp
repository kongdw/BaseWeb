<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<s:layout-definition>
  <!DOCTYPE html>
  <html lang="en">
  <head>
    <meta charset="utf-8"/>
    <title>${pageTitle}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <%@include file="/WEB-INF/jsp/common/import-css.jsp" %>
    <s:layout-component name="css"/>
  </head>
  <body class="no-skin">
  <div id="navbar" class="navbar navbar-default ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
      <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
        <span class="sr-only">Toggle sidebar</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <div class="navbar-header pull-left">
        <a href="#" class="navbar-brand">
          <small>
            <i class="fa fa-leaf"></i>
            &nbsp;&nbsp;档案管理系统
          </small>
        </a>
      </div>
      <div class="navbar-buttons navbar-header pull-right" role="navigation">
        <ul class="nav ace-nav">
          <li class="light-blue">
            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
              <img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo"/>
								<span class="user-info">
									<small>Welcome,</small>
									Jason
								</span>
              <i class="ace-icon fa fa-caret-down"></i>
            </a>
            <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
              <li>
                <a href="#">
                  <i class="ace-icon fa fa-cog"></i>
                  Settings
                </a>
              </li>

              <li>
                <a href="profile.html">
                  <i class="ace-icon fa fa-user"></i>
                  Profile
                </a>
              </li>

              <li class="divider"></li>

              <li>
                <a href="#">
                  <i class="ace-icon fa fa-power-off"></i>
                  Logout
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
      try {
        ace.settings.loadState('main-container')
      } catch (e) {
      }
    </script>
    <div id="sidebar" class="sidebar responsive ace-save-state">
      <script type="text/javascript">
        try {
          ace.settings.loadState('sidebar')
        } catch (e) {
        }
      </script>
      <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
          <button class="btn btn-success">
            <i class="ace-icon fa fa-signal"></i>
          </button>
          <button class="btn btn-info">
            <i class="ace-icon fa fa-pencil"></i>
          </button>
          <button class="btn btn-warning">
            <i class="ace-icon fa fa-users"></i>
          </button>
          <button class="btn btn-danger">
            <i class="ace-icon fa fa-cogs"></i>
          </button>
        </div>
        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
          <span class="btn btn-success"></span>
          <span class="btn btn-info"></span>
          <span class="btn btn-warning"></span>
          <span class="btn btn-danger"></span>
        </div>
      </div>
      <%@include file="/WEB-INF/jsp/common/admin/menu.jsp" %>
      <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
           data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
      </div>
    </div>
    <div class="main-content">
      <div class="main-content-inner">
        <%@include file="/WEB-INF/jsp/common/admin/breadcrumb.jsp" %>
        <div class="page-content">
          <%@include file="/WEB-INF/jsp/common/admin/settings.jsp" %>
          <div class="page-content-area" data-ajax-content="true">
            <%--<s:layout-component name="content"/>--%>
          </div>
        </div>
      </div>
    </div>
    <%@include file="/WEB-INF/jsp/common/admin/footer.jsp" %>
  </div>
  <%@include file="/WEB-INF/jsp/common/import-js.jsp" %>
  <s:layout-component name="js"/>
  <script type="text/javascript">
    jQuery(function(){
      ace.demo.init();
    })
  </script>
  </body>
  </html>
</s:layout-definition>