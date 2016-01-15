<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/jsp/common/import-taglib.jspf"%>
<stripes:layout-render name="WEB-INF/jsp/front/login.jsp">
  <stripes:layout-component name="css-extend">
    <link href="${ctx}/assets/plugins/select2/select2.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/assets/css/login-soft.css" rel="stylesheet" type="text/css"/>
  </stripes:layout-component>
  <stripes:layout-component name="js-extend">
    <script src="${ctx}/assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
    <script src="${ctx}/assets/plugins/select2/select2.min.js" type="text/javascript"></script>
  </stripes:layout-component>
  <stripes:layout-component name="content">
    <stripes:form class="login-form" action="${ctx}/login" method="post">
      <h3 class="form-title">系统登录</h3>
      <stripes:errors/>
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
    </stripes:form>
  </stripes:layout-component>
</stripes:layout-render>
