<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<stripes:layout-render name="/WEB-INF/jsp/layout/index.jsp">
  <stripes:layout-component name="content">
    hello world! ${requestScope.currentURL}
  </stripes:layout-component>
</stripes:layout-render>
