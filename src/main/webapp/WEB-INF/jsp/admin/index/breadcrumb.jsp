<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-tabs" style="padding: 0px;">
  <span class="ace-icon fa fa-chevron-left" style="display: none;"></span>
  <div class="ul-wrapper">
    <div class="sidebar h-sidebar">
      <ul style="padding-top: 3px;">
        <li style="padding-left: 10px;">
          <a href="#tabs-0">欢迎使用</a>
          <span class='menu' role='presentation' style="display:inline-block;width: 14px;height: 14px"></span>
          <br/>
          <span class='menu ace-icon fa fa-refresh' role='presentation' title='刷新'></span>
        </li>
      </ul>
    </div>
  </div>
  <span class="ace-icon fa fa-chevron-right" style="display: none;"></span>
  <div id="tabs-0" data-index="0"  data-url="${ctx}/admin/welcome" style="border: none; padding: 0px; display: none;"></div>
</div>