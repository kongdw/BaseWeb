<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
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
      <%@include file="/WEB-INF/jsp/common/import-css.jsp" %>
  </head>
  <body class="login-layout light-login">
  <div class="main-container">
    <div class="main-content">
      <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
          <div class="login-container">
            <div class="center">
              <h1>
                <i class="ace-icon fa fa-leaf green"></i>
                <span class="red">档案</span>
                <span class="grey" id="id-text2">管理系统</span>
              </h1>
              <h4 class="blue" id="id-company-text">&copy; 中公网医疗信息技术有限公司</h4>
            </div>
            <div class="space-6"></div>
            <div class="position-relative">
              <div id="login-box" class="login-box visible widget-box no-border">
                <div class="widget-body">
                  <div class="widget-main">
                    <h4 class="header blue lighter bigger">
                      <i class="ace-icon fa fa-coffee green"></i>
                      用户登录
                    </h4>
                    <s:errors/>
                    <div class="space-6"></div>
                    <s:form  class="login-form" action="${ctx}/login/logging" method="post">
                      <fieldset>
                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="username" type="text" class="form-control" placeholder="用户名" />
															<i class="ace-icon fa fa-user"></i>
														</span>
                        </label>
                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="password" type="password" class="form-control" placeholder="密码" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
                        </label>
                        <div class="space"></div>
                        <div class="clearfix">
                          <label class="inline">
                            <input type="checkbox" class="ace" />
                            <span class="lbl"> 记住我</span>
                          </label>
                          <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-110">登录</span>
                          </button>
                        </div>
                        <div class="space-4"></div>
                      </fieldset>
                    </s:form>
                  </div>
                  <div class="toolbar clearfix">
                    <div class="space-4"></div>
                  </div>
                </div>
              </div>
            </div>
            <div class="navbar-fixed-top align-right">
              <br />
              &nbsp;
              <a id="btn-login-dark" href="#">Dark</a>
              &nbsp;
              <span class="blue">/</span>
              &nbsp;
              <a id="btn-login-blur" href="#">Blur</a>
              &nbsp;
              <span class="blue">/</span>
              &nbsp;
              <a id="btn-login-light" href="#">Light</a>
              &nbsp; &nbsp; &nbsp;
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--[if !IE]> -->
  <script src="${ctx}/assets/js/jquery.js"></script>
  <!-- <![endif]-->
  <!--[if IE]>
  <script src="${ctx}/assets/js/jquery1x.js"></script>
  <![endif]-->
  <script src="${ctx}/assets/js/jquery.validate.js"></script>
  <script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='${ctx}/assets/js/jquery.mobile.custom.js'>" + "<" + "/script>");
  </script>
  <!-- inline scripts related to this page -->
  <script type="text/javascript">
    jQuery(function ($) {
      $('#btn-login-dark').on('click', function (e) {
        $('body').attr('class', 'login-layout');
        $('#id-text2').attr('class', 'white');
        $('#id-company-text').attr('class', 'blue');
        e.preventDefault();
      });
      $('#btn-login-light').on('click', function (e) {
        $('body').attr('class', 'login-layout light-login');
        $('#id-text2').attr('class', 'grey');
        $('#id-company-text').attr('class', 'blue');
        e.preventDefault();
      });
      $('#btn-login-blur').on('click', function (e) {
        $('body').attr('class', 'login-layout blur-login');
        $('#id-text2').attr('class', 'white');
        $('#id-company-text').attr('class', 'light-blue');
        e.preventDefault();
      });
      handleLogin();
    });
    var handleLogin = function() {
      $('.login-form').validate({
        errorElement: 'span', //default input error message container
        errorClass: 'help-block', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        rules: {
          username: {
            required: true
          },
          password: {
            required: true
          },
          remember: {
            required: false
          }
        },

        messages: {
          username: {
            required: "用户名不能为空"
          },
          password: {
            required: "密码不能为空"
          }
        },
        highlight: function (element) { // hightlight error inputs
          $(element)
              .closest('label').addClass('has-error'); // set error class to the control group
        },

        success: function (label) {
          label.closest('label').removeClass('has-error');
          label.remove();
        },

        errorPlacement: function (error, element) {
          error.insertAfter(element.closest('.input-icon'));
        },

        submitHandler: function (form) {
          form.submit();
        }
      });

      $('.login-form input').keypress(function (e) {
        if (e.which == 13) {
          if ($('.login-form').validate().form()) {
            $('.login-form').submit();
          }
          return false;
        }
      });
    }
  </script>
  </body>
  </html>
