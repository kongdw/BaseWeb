<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    .menu {
        display: inline-block;
        position: absolute;
        z-index: 12;
    }

    .menu.fa-close {
        right: 1px;
        top: 3px;
    }

    .menu.fa-refresh {
        right: 1px;
        bottom: 4px;
    }

    .ui-tabs .ui-tabs-nav li.ui-tabs-active a {
        padding-right: 15px;
    }
</style>
<div id="page-tabs" style="padding: 0px;">
    <span class="ace-icon fa fa-chevron-left" style="display: none;"></span>
    <div class="ul-wrapper">
        <div class="sidebar h-sidebar">
            <ul style="padding-top: 3px;margin-left: 5px;">
                <li>
                    <a href="#tabs-0">欢迎使用</a>
                    <span class='menu' role='presentation'
                          style="display:inline-block;width: 14px;height: 14px;right: 1px;"></span>
                    <br/>
                    <span class='menu ace-icon fa fa-refresh' style="bottom: 10px;" role='presentation' title='刷新'></span>
                </li>
            </ul>
        </div>
    </div>
    <span class="ace-icon fa fa-chevron-right" style="display: none;"></span>
    <div id="tabs-0" data-index="0" data-url="${ctx}/index/welcome"
         style="border: none; padding: 0px; display: none;"></div>
</div>