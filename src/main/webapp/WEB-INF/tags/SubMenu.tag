<%@tag pageEncoding="UTF-8" description="构建子菜单" %>
<%@ attribute name="menu" type="k0n9.module.sys.entity.Menu" required="true" description="当前菜单" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="k" tagdir="/WEB-INF/tags" %>
<c:choose>
  <c:when test="${!menu.hasChildren}">
    <li>
      <a href="#page<%=menuUrl(request, menu.getUrl())%>" data-url="page<%=menuUrl(request, menu.getUrl())%>">
        <i class="menu-icon fa <c:choose><c:when test="${not empty menu.icon}">${menu.icon}</c:when><c:otherwise>fa-caret-right</c:otherwise></c:choose>"></i>
        <span class="menu-text">${menu.name}</span>
        <b class="arrow"></b>
      </a>
    </li>
  </c:when>
  <c:otherwise>
    <li>
      <a href="#" class="dropdown-toggle">
        <i class="menu-icon fa <c:choose><c:when test="${not empty menu.icon}">${menu.icon}</c:when><c:otherwise>fa-caret-right</c:otherwise></c:choose>"></i>
        <span class="menu-text">${menu.name}</span>
        <b class="arrow fa fa-angle-down"></b>
      </a>
      <b class="arrow"></b>
      <ul class="submenu">
        <c:forEach items="${menu.children}" var="menu2">
          <k:SubMenu menu="${menu2}"/>
        </c:forEach>
      </ul>
    </li>
  </c:otherwise>
</c:choose>

<%!
  private static String menuUrl(HttpServletRequest request, String url) {
    if (url.startsWith("http")) {
      return url;
    }
    String ctx = request.getContextPath();

    if (url.startsWith(ctx) || url.startsWith("/" + ctx)) {
      return url;
    }

    if (!url.startsWith("/")) {
      url = url + "/";
    }
    return ctx + url;

  }
%>


