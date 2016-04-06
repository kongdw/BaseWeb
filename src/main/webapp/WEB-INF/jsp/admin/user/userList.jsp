<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<stripes:useActionBean var="actionBean" beanclass="k0n9.module.sys.web.UserActionBean"/>
<html>
<head>
  <title>用户列表</title>
  <script src="${ctx}/static/assets/jquery.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  <link href="${ctx}/static/bootstrap/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div class="table-responsive">
        <table class="table">
          <thead>
          <tr>
            <th>
              <div>Name</div>
            </th>
            <th>
              <div>Email</div>
            </th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${actionBean.users}" var="users" varStatus="status">
            <c:set var="stateClass" value=""/>
            <tr data-id="${users.id}" class="subscriber-row">
              <td class="${stateClass}">${users.username}</td>
              <td class="center ${stateClass}">${users.email}</td>
            </tr>
          </c:forEach>
          </tbody>
          <tfoot>
          <tr>
            <td colspan="2">
              <div>&nbsp;</div>
            </td>
          </tr>
          </tfoot>
        </table>
      </div>
    </div>
  </div>
</div>

</body>
</html>
