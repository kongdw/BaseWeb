<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/import-taglib.jsp" %>
<k:header index="true" title="档案管理系统"/>
<div id="navbar" class="navbar navbar-default ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    &nbsp;&nbsp;档案管理系统
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo"/>
								<span class="user-info">
									<small>Welcome,</small>
									Jason
								</span>
                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>
                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-cog"></i>
                                Settings
                            </a>
                        </li>

                        <li>
                            <a href="profile.html">
                                <i class="ace-icon fa fa-user"></i>
                                Profile
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-power-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>
    <div id="sidebar" class="sidebar responsive ace-save-state">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>
        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>
                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>
                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>
                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>
            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>
                <span class="btn btn-info"></span>
                <span class="btn btn-warning"></span>
                <span class="btn btn-danger"></span>
            </div>
        </div>
        <%@include file="/WEB-INF/jsp/admin/index/menu.jsp" %>
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
               data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>
    <div class="main-content">
        <div class="main-content-inner">
            <%@include file="/WEB-INF/jsp/admin/index/breadcrumb.jsp" %>
            <div class="page-content">
                <%@include file="/WEB-INF/jsp/admin/index/settings.jsp" %>
                <div class="row">
                    <div id="iframe-container" class="col-xs-12">
                        <%--<iframe id="iframe-tabs-0" frameborder="0" scrolling="auto" src="${ctx}/index/welcome"></iframe>--%>
                        <iframe id="iframe-tabs-0" frameborder="0" style="width: 100%"
                                scrolling="no" src="${ctx}/archive/browse"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/jsp/admin/index/footer.jsp" %>
</div>
<k:footer/>
<script type="text/javascript">
    $.menus = {
        /**初始化菜单*/
        initMenu: function () {
            var menus = $("#menu");
            menus.find("a").each(function () {
                var a = $(this);
                var title = a.text();
                var href = a.attr("href");
                a.attr("href", "#");
                if (href == "#" || href == '') {
                    return;
                }
                var active = function (a, forceRefresh) {
                    console.log(href)
                    menus.find(".active").each(function () {
                        var $class = 'active open';
                        $(this).removeClass($class);
                        $(this).find(' > .submenu').css('display', '');
                    });
                    a.closest('li').addClass('active').parents('.nav li').addClass('active open');
                    menus.closest('.sidebar[data-sidebar-scroll=true]').each(function () {
                        var $this = $(this);
                        $this.ace_sidebar_scroll('reset');
                    });
                    var oldPanelIndex = a.data("panelIndex");
                    var activeMenuCallback = function (panelIndex) {
                        a.data("panelIndex", panelIndex);
                        a.attr("id", "menu-" + panelIndex);
                    }
//          $.tabs.activeTab(oldPanelIndex, title, href, forceRefresh, activeMenuCallback);
                    return false;
                };
                a.closest("li")
                        .click(function () {
                            active(a, false);
                            return false;
                        }).dblclick(function () {
                    active(a, true);//双击强制刷新
                    return false;
                });
            });
        }
    };
    jQuery(function () {
        ace.demo.init();
        $.menus.initMenu();
        $('#iframe-tabs-0').iframeAutoHeight({minHeight: 500, heightOffset: 10,animate: true,resetToMinHeight: true});
    })
</script>

