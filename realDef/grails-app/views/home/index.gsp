<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="home.page.title"/></title>
    <geolocation:resources/>
</head>
<body>
<geolocation:locateMe/>
<a href="${createLink(controller: 'home',action: 'nearByFoodTruck')}">Get near by food trucks</a>
</body>
</html>