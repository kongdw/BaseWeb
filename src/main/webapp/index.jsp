<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes-dynattr.tld" %>
<html>
<body>
<h2>Hello World!</h2>
<ul>
  <li><stripes:link beanclass="k0n9.module.sys.web.UserActionBean">users</stripes:link></li>
  <li><stripes:link beanclass="k0n9.module.sys.web.UserActionBean" event="ajaxList">ajax users</stripes:link></li>
</ul>
</body>
</html>
