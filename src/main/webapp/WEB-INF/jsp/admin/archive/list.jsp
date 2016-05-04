<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<k:header title="档案管理"/>
<style type="text/css">
  body {
    background-color: #fff;
  }
</style>
<div class="page-header">
  <h1>
    档案管理
    <small>
      <i class="ace-icon fa fa-angle-double-right"></i>
      档案列表
    </small>
  </h1>
</div><!-- /.page-header -->
<div class="form-inline no-footer" data-table="table">
  <%@include file="searchForm.jsp" %>
  <div class="space-4"></div>
    <s:messages/>
  <%@include file="listTable.jsp" %>
</div>
<k:footer/>