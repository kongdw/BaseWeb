<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<k:header title="档案管理"/>
<style type="text/css">
  body {
    background-color: #fff;
  }
</style>
<div class="form-inline no-footer" data-table="table">
  <%@include file="searchForm.jsp" %>
  <div class="space-4"></div>
  <%@include file="listTable.jsp" %>
</div>
<k:footer/>