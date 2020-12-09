<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h4>Error Page</h4>

    ${requestScope.exception}

    <%--改名为ex才能用${requestScope.ex}--%>

</body>
</html>
