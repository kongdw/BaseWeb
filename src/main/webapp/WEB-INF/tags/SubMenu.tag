<%@tag pageEncoding="UTF-8" description="构建子菜单" %>
<%@ attribute name="menu" type="k0n9.module.sys.entity.Menu" required="true" description="当前菜单" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="k0n9" tagdir="/WEB-INF/tags" %>
<c:choose>
  <c:when test="${!menu.hasChildren}">
    <li>
      <a href="<%=menuUrl(request,menu.getUrl())%>">
        <i class="${menu.icon}"></i>
        <span class="title">${menu.name}</span>
      </a>
    </li>
  </c:when>
  <c:otherwise>
    <li>
      <a href="javascript:;">
        <i class="${menu.icon}"></i>
        <span class="title">${menu.name}</span>
        <span class="arrow"></span>
      </a>
      <ul class="sub-menu">
        <c:forEach items="${menu.children}" var="subMenu">
          <k0n9:SubMenu menu="${subMenu}"/>
        </c:forEach>
      </ul>
    </li>
  </c:otherwise>
</c:choose>

<%!
  private static String menuUrl(HttpServletRequest request, String url) {
    if(url.startsWith("http")) {
      return url;
    }
    String ctx = request.getContextPath();

    if(url.startsWith(ctx) || url.startsWith("/" + ctx  )) {
      return url;
    }

    if(!url.startsWith("/")) {
      url = url + "/";
    }
    return ctx + url;

  }
%>

