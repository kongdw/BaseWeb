<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<k:header title="档案管理-添加"/>
<style type="text/css">
  body {
    background-color: #fff;
  }
</style>
<div class="row">
  <div class="col-xs-12">
    <h3 class="header smaller lighter blue">
      添加档案
    </h3>
    <s:errors globalErrorsOnly="true"/>
    <s:form class="form form-horizontal" role="form" action="${ctx}/archive">
      <s:hidden name="archive.id"/>
      <div class="row">
        <div class="col-sm-8">
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.type.id" name="文件类别"/>
            <div class="col-sm-9">
              <s:select name="archive.type.id" class="input-small">
                <s:option value="">请选择...</s:option>
                <s:options-collection collection="${actionBean.type}" label="name" value="id"/>
              </s:select>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.year" name="年度"/>
            <div class="col-sm-9">
              <s:text name="archive.year" class="input-small" placeholder="年度"/>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.docNo" name="文件字号"/>
            <div class="col-sm-9">
              <s:text name="archive.docNo" class="input-medium" placeholder="文件字号"/>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.title" name="标题"/>
            <div class="col-sm-9">
              <s:text name="archive.title" class="form-control" placeholder="标题"/>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.docDate" name="文件日期"/>
            <div class="col-sm-9">
              <s:text name="archive.docDate" class="input-medium" placeholder="文件日期"/>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.category.id" name="档案分类"/>
            <div class="col-sm-9">
              <s:select name="archive.category.id" class="input-small">
                <s:option value="">请选择...</s:option>
                <s:options-collection collection="${actionBean.category}" label="name" value="id"/>
              </s:select>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.deadLine.id" name="保管期限"/>
            <div class="col-sm-9">
              <s:select name="archive.deadLine.id" class="input-small">
                <s:option value="">请选择...</s:option>
                <s:options-collection collection="${actionBean.deadLine}" label="name" value="id"/>
              </s:select>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.responsible" name="责任人"/>
            <div class="col-sm-9">
              <s:text name="archive.responsible" class="input-small" placeholder="责任人"/>
            </div>
          </div>
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.remark" name="备注"/>
            <div class="col-sm-9">
              <s:textarea name="archive.remark" class="form-control" placeholder="备注"/>
            </div>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.docClass.id" name="公文种类"/>
            <div class="col-sm-9">
              <s:select name="archive.docClass.id" class="input-small">
                <s:option value="">请选择...</s:option>
                <s:options-collection collection="${actionBean.docClass}" label="name" value="id"/>
              </s:select>
            </div>
          </div>

          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.forcerNo" name="柜号"/>
            <div class="col-sm-9">
              <s:text name="archive.forcerNo" class="input-small" placeholder="柜号"/>
            </div>
          </div>

          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.boxNo" name="盒号"/>
            <div class="col-sm-9">
              <s:text name="archive.boxNo" class="input-small" placeholder="盒号"/>
            </div>
          </div>

          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.partNum" name="份数"/>
            <div class="col-sm-9">
              <s:text name="archive.partNum" class="input-small" placeholder="份数"/>
            </div>
          </div>

          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.pageNum" name="页数"/>
            <div class="col-sm-9">
              <s:text name="archive.pageNum" class="input-small" placeholder="页数"/>
            </div>
          </div>

          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.privacyLevel.id" name="保密级别"/>
            <div class="col-sm-9">
              <s:select name="archive.privacyLevel.id" class="input-small">
                <s:option value="">请选择...</s:option>
                <s:options-collection collection="${actionBean.privacyLevel}" label="name" value="id"/>
              </s:select>
            </div>
          </div>

          <div class="form-group">
            <s:label class="col-sm-3 control-label no-padding-right" for="archive.urgentLevel.id" name="紧急程度"/>
            <div class="col-sm-9">
              <s:select name="archive.urgentLevel.id" class="input-small">
                <s:option value="">请选择...</s:option>
                <s:options-collection collection="${actionBean.urgentLevel}" label="name" value="id"/>
              </s:select>
            </div>
          </div>
        </div>
      </div>
      <div class="clearfix form-actions">
        <div class="col-md-offset-3 col-md-9">
          <s:submit name="save" class="btn btn-info" value="保存"/>
          &nbsp; &nbsp; &nbsp;
          <s:submit name="cancel" class="btn" value="返回"/>
        </div>
      </div>
    </s:form>
  </div>
</div>
<k:footer/>