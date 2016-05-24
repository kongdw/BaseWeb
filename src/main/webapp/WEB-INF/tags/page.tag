<%@tag pageEncoding="UTF-8" description="分页" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="es" tagdir="/WEB-INF/tags" %>

<%@ attribute name="page" type="k0n9.common.entity.search.domain.Page" required="true" description="分页" %>
<%@ attribute name="pageSize" type="java.lang.Integer" required="false" description="每页大小" %>
<%@ attribute name="simple" type="java.lang.Boolean" required="false" description="是否简单风格" %>

<c:if test="${empty pageSize}">
    <c:set var="pageSize" value="${page.size}"/>
</c:if>

<c:set var="displaySize" value="2"/>
<c:set var="current" value="${page.number + 1}"/>

<c:set var="begin" value="${current - displaySize}"/>
<c:if test="${begin <= displaySize}">
    <c:set var="begin" value="${1}"/>
</c:if>

<c:set var="end" value="${current + displaySize}"/>
<c:if test="${end > page.totalPages - displaySize}">
    <c:set var="end" value="${page.totalPages - displaySize}"/>
</c:if>

<c:if test="${end < 0 or page.totalPages < displaySize * 4}">
    <c:set var="end" value="${page.totalPages}"/>
</c:if>
<div style="display: inline-block;">
    <div> 第
        <c:choose>
            <c:when test="${page.firstPage}">
                <a href="#" class="btn btn-white btn-info btn-sm disabled" title="首页"><i class="ace-icon fa fa-angle-double-left"></i></a>
                <a href="#" class="btn btn-white btn-info btn-sm prev disabled" title="上一页"><i class="ace-icon fa fa-angle-left"></i></a>
            </c:when>
            <c:otherwise>
                <a href="#" class="btn btn-white btn-info btn-sm" onclick="$.table.turnPage('${pageSize}', 1, this);" title="首页"><i class="ace-icon fa fa-angle-double-left"></i></a>
                <a href="#" class="btn btn-white btn-info btn-sm prev" onclick="$.table.turnPage('${pageSize}', ${current - 1}, this);" title="上一页"><i class="ace-icon fa fa-angle-left"></i></a>
            </c:otherwise>
        </c:choose>
        <form style="display: inline" class="pageField">
            <input type="text"
                   class="form-control input-small" style="height: 27px;width: 40px;"
                   value="${current}"
                   onblur="$.table.turnPage('${pageSize}', $(this).val(), this)"/>
        </form>
        <c:choose>
            <c:when test="${page.lastPage}">
                <a href="#" class="btn btn-white btn-info btn-sm next disabled" title="下一页"><i class="fa fa-angle-right"></i></a>
                <a href="#" class="btn btn-white btn-info btn-sm next disabled" title="尾页"><i class="fa fa-angle-double-right"></i></a>
            </c:when>
            <c:otherwise>
                <a href="#" class="btn btn-white btn-info btn-sm next" onclick="$.table.turnPage('${pageSize}', ${current + 1}, this);" title="下一页"><i class="ace-icon fa fa-angle-right"></i></a>
                <a href="#" class="btn btn-white btn-info btn-sm next" onclick="$.table.turnPage('${pageSize}', ${page.totalPages}, this);" title="尾页"><i class="ace-icon fa fa-angle-double-right"></i></a>
            </c:otherwise>
        </c:choose> 页
    </div>
</div>
<div style="display: inline-block;">
    <label>
        <span class="seperator">|</span> 每页
        <select class="form-control input-sm input-inline" style="height: 27px;" onchange="$.table.turnPage($(this).val(), ${current}, this);">
            <option value="10" <c:if test="${pageSize eq 10}">selected="selected" </c:if>>10</option>
            <option value="20" <c:if test="${pageSize eq 20}">selected="selected" </c:if>>20</option>
            <option value="30" <c:if test="${pageSize eq 30}">selected="selected" </c:if>>30</option>
            <option value="50" <c:if test="${pageSize eq 50}">selected="selected" </c:if>>50</option>
        </select> 条
    </label>
</div>

[共${page.totalPages}页/${page.totalElements}条]