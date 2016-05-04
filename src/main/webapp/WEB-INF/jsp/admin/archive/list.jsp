<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<k:header title="档案管理"/>
<div class="form-inline" data-table="table">
  <%@include file="searchForm.jsp" %>
  <div class="space-4"></div>
    <s:messages/>
  <%@include file="listTable.jsp" %>
</div>
<k:footer/>