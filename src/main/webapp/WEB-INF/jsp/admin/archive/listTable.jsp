<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<div id="table-container">
<div class="row" style="background-color: #EFF3F8;">
  <div class="space-2"></div>
  <div class="col-xs-12">
    <div class="pull-left" style="padding-left: 5px;">
      <div class="btn-group">
        <button type="button" class="btn btn-white btn-info btn-sm btn-create">
          <i class="ace-icon glyphicon glyphicon-file"></i>
          添加
        </button>
        <button type="button" class="btn btn-white btn-info btn-sm btn-update">
          <i class="ace-icon glyphicon glyphicon-pencil"></i>
          修改
        </button>
        <button type="button" class="btn btn-white btn-info btn-sm btn-delete">
          <i class="ace-icon glyphicon glyphicon-trash"></i>
          删除
        </button>
      </div>
    </div>
    <div class="pull-right" style="padding-right: 5px;">
      <k:page page="${page}"/>
    </div>
  </div>
</div>
<table id="table" class="table table-striped table-bordered table-hover dataTable no-footer" data-async="true" data-url="${ctx}/archive">
  <thead>
  <tr role="row">
    <th class="center sorting_disabled">
      <label class="pos-rel">
        <input type="checkbox" class="ace">
        <span class="lbl"></span>
      </label>
    </th>
    <th sort="a.type">文件类别</th>
    <th sort="a.year">年度</th>
    <th>文件字号</th>
    <th sort="a.title">标题</th>
    <th>文件日期</th>
    <th>档案类别</th>
    <th>保管期限</th>
    <th>责任人</th>
    <th>公文种类</th>
    <th>柜号</th>
    <th>盒号</th>
    <th>份数</th>
    <th>页数</th>
    <th>保密级别</th>
    <th>紧急程度</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${actionBean.archives}" var="m">
    <tr role="row">
      <td class="center">
        <label class="pos-rel">
          <input type="checkbox" class="ace" name="archiveId" value="${m.id}">
          <span class="lbl"></span>
        </label>
      </td>
      <td>${m.type.name}</td>
      <td>${m.year}</td>
      <td>${m.docNo}</td>
      <td>${m.title}</td>
      <td><fmt:formatDate value="${m.docDate}" pattern="yyyy-MM-dd"/> </td>
      <td>${m.category.name}</td>
      <td>${m.deadLine.name}</td>
      <td>${m.responsible}</td>
      <td>${m.docClass.name}</td>
      <td>${m.forcerNo}</td>
      <td>${m.boxNo}</td>
      <td>${m.partNum}</td>
      <td>${m.pageNum}</td>
      <td>${m.privacyLevel.name}</td>
      <td>${m.urgentLevel.name}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
