<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<k:header title="档案管理"/>
<style type="text/css">
  body{
    background-color: #fff;
  }
</style>
<div class="row">
  <div class="col-sm-12">
    <%@include file="searchForm.jsp" %>
  </div>
</div>
<div class="row">
  <div class="col-sm-12">
    <%@include file="listTable.jsp" %>
  </div>
</div>
<k:footer/>