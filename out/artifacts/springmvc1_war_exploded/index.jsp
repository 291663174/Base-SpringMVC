<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>$Title$</title>
</head>

    <a href="/springmvc/testRedirect">Test Redirect</a>
    <br><br>

    <a href="/springmvc/testView">Test View</a>
    <br><br>

    <a href="/springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
    <br><br>

    <%--
        模拟修改操作
        1.原始数据为：1 ，Tom , 123456 , tom@wuhen.com , 12
        2.密码不能被修改
        3.表单回显，模拟操作直接在表单填写对应的属性值
    --%>
    <form action="/springmvc/testModelAttributes" method="post">
        <input type="hidden" name="id" value="1"/>
        usename: <input type="text" name="username" value="Tom"/><br>
        email: <input type="text" name="email" value="tom@wuhen.com"/><br>
        age: <input type="text" name="age" value="12"/><br>
        <input type="submit" value="Submit"/><br>
    </form>
    <br><br>

    <a href="/springmvc/testSessionAttributes">Test SessionAttributes</a>
    <br><br>

    <a href="/springmvc/testModelAndView">Test ModelAndView</a>
    <br><br>

    <a href="/springmvc/testServletAPI">Test ServletAPI</a>
    <br><br>

    <form action="/springmvc/testPojo" method="post">
        username: <input type="text" name="username"/><br>
        password:<input type="password" name="password"/><br>
        email:<input type="text" name="email"/><br>
        age:<input type="text" name="age"/><br>
        province:<input type="text" name="address.province"/><br>
        city:<input type="text" name="address.city"/><br>
        <input type="submit" value="Submit"/>
    </form>

    <a href="/springmvc/testCookieValue">Test CookieValue</a>
    <br><br>

    <a href="/springmvc/testRequestHeader">Test RequestHeader</a>
    <br><br>

    <a href="/springmvc/testRequestParam?username=wuhen&age=11">Test RequestParam</a>
    <br><br>

    <form action="springmvc/testRest/1" methods="post">
        <input type="hidden" name="_method" value="put"/>
        <input type="submit" value="TextRest PUT"/>
    </form>
    <br><br>

    <form action="springmvc/testRest/1" methods="post">
        <input type="hidden" name="_method" value="delete"/>
        <input type="submit" value="TextRest DELETE"/>
    </form>
    <br><br>

    <form action="springmvc/testRest/1" methods="post">
        <input type="submit" value="TextRest POST"/>
    </form>
    <br><br>

    <a href="springmvc/testRest/1">Test Rest Get</a>
    <br><br>

    <a href="springmvc/testPathVariable/1">Test PathVariable</a>
    <br><br>

    <a href="springmvc/testAntPath/mnzczhs/abc">Test AntPath</a>
    <br><br>

    <a href="/springmvc/testParamsAndHeaders?username=wuhen&age=11">Test ParamsAndHeaders</a>
    <br><br>

    <form action="/springmvc/testMethod" method="POST">
        <input type="submit"/>
    </form>

    <br><br>
    <a href="/springmvc/testMethod">Test Method</a>

    <br><br>
    <a href="/springmvc/testRequestMapping">Test RequestMapping</a>

    <br><br>
    <%--发送请求helloworld--%>
    <a href="helloworld">Hello World</a>
</body>
</html>
