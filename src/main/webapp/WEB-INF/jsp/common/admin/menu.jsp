<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="k0n9" tagdir="/WEB-INF/tags" %>
<!-- BEGIN SIDEBAR MENU -->
<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
  <li class="start ">
    <a href="${ctx}/main">
      <i class="icon-home"></i>
      <span class="title">主页</span>
    </a>
  </li>
  <c:forEach items="${menus}" var="m">
    <k0n9:SubMenu menu="${m}"/>
  </c:forEach>
  <li>
    <a href="javascript:;">
      <i class="icon-basket"></i>
      <span class="title">eCommerce</span>
      <span class="arrow "></span>
    </a>
    <ul class="sub-menu">
      <li>
        <a href="ecommerce_index.html">
          <i class="icon-home"></i>
          Dashboard</a>
      </li>
      <li>
        <a href="ecommerce_orders.html">
          <i class="icon-basket"></i>
          Orders</a>
      </li>
      <li>
        <a href="ecommerce_orders_view.html">
          <i class="icon-tag"></i>
          Order View</a>
      </li>
      <li>
        <a href="ecommerce_products.html">
          <i class="icon-handbag"></i>
          Products</a>
      </li>
      <li>
        <a href="ecommerce_products_edit.html">
          <i class="icon-pencil"></i>
          Product Edit</a>
      </li>
    </ul>
  </li>
  <li class="active open">
    <a href="javascript:;">
      <i class="icon-rocket"></i>
      <span class="title">Page Layouts</span>
      <span class="selected"></span>
      <span class="arrow open"></span>
    </a>
    <ul class="sub-menu">
      <li>
        <a href="layout_fontawesome_icons.html">
          <span class="badge badge-roundless badge-danger">new</span>Layout with Fontawesome Icons</a>
      </li>
      <li>
        <a href="layout_glyphicons.html">
          Layout with Glyphicon</a>
      </li>
      <li>
        <a href="layout_full_height_content.html">
          <span class="badge badge-roundless badge-warning">new</span>Full Height Content</a>
      </li>
      <li>
        <a href="layout_sidebar_reversed.html">
          <span class="badge badge-roundless badge-warning">new</span>Right Sidebar Page</a>
      </li>
      <li>
        <a href="layout_sidebar_fixed.html">
          Sidebar Fixed Page</a>
      </li>
      <li>
        <a href="layout_sidebar_closed.html">
          Sidebar Closed Page</a>
      </li>
      <li>
        <a href="layout_ajax.html">
          Content Loading via Ajax</a>
      </li>
      <li>
        <a href="layout_disabled_menu.html">
          Disabled Menu Links</a>
      </li>
      <li>
        <a href="layout_blank_page.html">
          Blank Page</a>
      </li>
      <li class="active">
        <a href="layout_fluid_page.html">
          Fluid Page</a>
      </li>
      <li>
        <a href="layout_language_bar.html">
          Language Switch Bar</a>
      </li>
    </ul>
  </li>
  <li class="last ">
    <a href="javascript:;">
      <i class="icon-pointer"></i>
      <span class="title">Maps</span>
      <span class="arrow "></span>
    </a>
    <ul class="sub-menu">
      <li>
        <a href="maps_google.html">
          Google Maps</a>
      </li>
      <li>
        <a href="maps_vector.html">
          Vector Maps</a>
      </li>
    </ul>
  </li>
</ul>
<!-- END SIDEBAR MENU -->
