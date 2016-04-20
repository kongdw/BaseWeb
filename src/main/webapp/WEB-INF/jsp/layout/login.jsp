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
  <body class="login-layout light-login">
  <stripes:layout-component name="content"/>
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

        //invalidHandler: function (event, validator) { //display error alert on form submit
        //    $('.alert-danger', $('.login-form')).show();
        //},

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
</stripes:layout-definition>