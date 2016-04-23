<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/import-taglib.jsp"%>
<s:layout-render name="/WEB-INF/jsp/layout/login.jsp">
  <s:layout-component name="content">
    <div class="main-container">
      <div class="main-content">
        <div class="row">
          <div class="col-sm-10 col-sm-offset-1">
            <div class="login-container">
              <div class="center">
                <h1>
                  <i class="ace-icon fa fa-leaf green"></i>
                  <span class="red">档案</span>
                  <span class="grey" id="id-text2">管理系统</span>
                </h1>
                <h4 class="blue" id="id-company-text">&copy; 中公网医疗信息技术有限公司</h4>
              </div>
              <div class="space-6"></div>
              <div class="position-relative">
                <div id="login-box" class="login-box visible widget-box no-border">
                  <div class="widget-body">
                    <div class="widget-main">
                      <h4 class="header blue lighter bigger">
                        <i class="ace-icon fa fa-coffee green"></i>
                        用户登录
                      </h4>
                      <s:errors/>
                      <div class="space-6"></div>
                      <s:form  class="login-form" action="${ctx}/login" method="post">
                        <fieldset>
                          <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="username" type="text" class="form-control" placeholder="用户名" />
															<i class="ace-icon fa fa-user"></i>
														</span>
                          </label>
                          <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="password" type="password" class="form-control" placeholder="密码" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
                          </label>
                          <div class="space"></div>
                          <div class="clearfix">
                            <label class="inline">
                              <input type="checkbox" class="ace" />
                              <span class="lbl"> 记住我</span>
                            </label>
                            <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                              <i class="ace-icon fa fa-key"></i>
                              <span class="bigger-110">登录</span>
                            </button>
                          </div>
                          <div class="space-4"></div>
                        </fieldset>
                      </s:form>
                    </div>
                    <div class="toolbar clearfix">
                      <div class="space-4"></div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="navbar-fixed-top align-right">
                <br />
                &nbsp;
                <a id="btn-login-dark" href="#">Dark</a>
                &nbsp;
                <span class="blue">/</span>
                &nbsp;
                <a id="btn-login-blur" href="#">Blur</a>
                &nbsp;
                <span class="blue">/</span>
                &nbsp;
                <a id="btn-login-light" href="#">Light</a>
                &nbsp; &nbsp; &nbsp;
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </s:layout-component>
</s:layout-render>
