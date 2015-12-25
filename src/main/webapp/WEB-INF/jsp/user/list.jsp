<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes-dynattr.tld" %>
<%--@elvariable id="actionBean" type="co.ds.stripes.SubscriberAction"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<stripes:useActionBean var="actionBean" beanclass="k0n9.module.sys.web.UserActionBean"/>
<html>
<head>
  <title>用户列表</title>
</head>
<body>
<table class="grid-list" cellspacing="0">
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
</body>
</html>
