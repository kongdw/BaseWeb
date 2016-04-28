<%@tag pageEncoding="UTF-8"%>
<%@attribute name="title" type="java.lang.String" required="false" %>
<%@attribute name="index" type="java.lang.Boolean" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <title>${title}</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <%@include file="/WEB-INF/jsp/common/import-css.jsp" %>
  <script type="text/javascript">
    var currentURL = "${requestScope.currentURL}";
  </script>
</head>
<body <c:if test="${index eq true}">class="no-skin"</c:if>>