<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row" style="background-color: #EFF3F8;">
  <div class="space-2"></div>
  <div class="col-xs-12">
    <div class="pull-left" style="padding-left: 5px;">
      <div class="btn-group">
        <button type="button" class="btn btn-white btn-info btn-sm">
          <i class="ace-icon glyphicon glyphicon-file"></i>
          添加
        </button>
        <button type="button" class="btn btn-white btn-info btn-sm">
          <i class="ace-icon glyphicon glyphicon-pencil"></i>
          修改
        </button>
        <button type="button" class="btn btn-white btn-info btn-sm">
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
<table class="table table-striped table-bordered table-hover dataTable no-footer">
  <thead>
  <tr role="row">
    <th class="center sorting_disabled">
      <label class="pos-rel">
        <input type="checkbox" class="ace">
        <span class="lbl"></span>
      </label>
    </th>
    <th class="sorting_asc">年度</th>
    <th class="sorting">年度</th>
    <th class="sorting">年度</th>
    <th class="sorting">年度</th>
    <th class="sorting">年度</th>
    <th class="sorting">年度</th>
    <th class="sorting">年度</th>
  </tr>
  </thead>
  <tbody>
  <tr role="row">
    <td class="center">
      <label class="pos-rel">
        <input type="checkbox" class="ace">
        <span class="lbl"></span>
      </label>
    </td>
    <td>
      <a href="#">above.com</a>
    </td>
    <td>
      <a href="#">above.com</a>
    </td>
    <td>
      <a href="#">above.com</a>
    </td>
    <td>
      <a href="#">above.com</a>
    </td>
    <td>
      <a href="#">above.com</a>
    </td>
    <td>
      <a href="#">above.com</a>
    </td>
    <td>
      <a href="#">above.com</a>
    </td>
  </tr>
  </tbody>
</table>

