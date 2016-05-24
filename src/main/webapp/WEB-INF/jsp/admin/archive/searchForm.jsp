<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="form-inline search-form">
    <label class="inline">
        <span class="lbl">年度:</span>
        <input name="search.year_eq" type="text" class="input-small" placeholder="年度">
    </label>
    <label class="inline">
        <span class="lbl">档案分类:</span>
        <select name="search.category.id_eq" class="input-sm">
            <option value="">请选择...</option>
            <c:forEach items="${actionBean.category}" var="item">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </select>
    </label>
    <label class="inline">
        <span class="lbl">标题:</span>
        <input name="search.title_like" type="text" class="input-medium" placeholder="标题">
    </label>
    <div class="pull-right">
        <button type="submit" class="btn btn-info btn-sm btn-search">
            <i class="ace-icon fa fa-search bigger-110"></i>查询
        </button>
        <button type="button" class="btn btn-info btn-sm btn-clear-search">
            <i class="ace-icon fa fa-undo bigger-110"></i>清空
        </button>
    </div>
</form>