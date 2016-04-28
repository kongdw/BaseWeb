<%@tag pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/import-js.jsp" %>
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
  })
</script>
</body>
</html>