<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp"%>
<ul class="nav nav-list" id="menu">
  <c:forEach items="${actionBean.menus}" var="m">
    <c:choose>
      <c:when test="${m.hasChildren}">
        <li>
          <a href="#" class="dropdown-toggle">
            <i class="menu-icon fa <c:choose><c:when test="${not empty m.icon}">${m.icon}</c:when><c:otherwise>fa-caret-right</c:otherwise></c:choose>"></i>
            <span class="menu-text">${m.name}</span>
            <b class="arrow fa fa-angle-down"></b>
          </a>
          <b class="arrow"></b>
          <ul class="submenu">
            <c:forEach items="${m.children}" var="c">
              <k:SubMenu menu="${c}"/>
            </c:forEach>
          </ul>
        </li>
      </c:when>
      <c:otherwise>
        <li>
          <a href="${m.url}">
            <i class="menu-icon fa <c:choose><c:when test="${not empty m.icon}">${m.icon}</c:when><c:otherwise>fa-caret-right</c:otherwise></c:choose>"></i>
            <span class="menu-text">${m.name}</span>
          </a>
          <b class="arrow"></b>
        </li>
      </c:otherwise>
    </c:choose>
  </c:forEach>
</ul>
