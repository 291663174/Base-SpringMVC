<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#testJson").click(function () {
                let url = this.href;
                let args = {};
                $.post(url, args, function (data) {
                    for (let i = 0; i < data.length; i++) {
                        let id = data[i].id;
                        let lastName = data[i].lastName;

                        alert(id + ": " + lastName);
                    }
                });
                return false;
            })
        })
    </script>
</head>
<body>

    <form action="testFileUpload" method="post" enctype="multipart/form-data">
        File: <input type="file" name="file"/>
        Desc: <input type="text" name="desc"/>
        <input type="submit" value="Submit"/>
    </form>
    <br><br>

    <a href="emps">list All Employees</a><br><br>

    <a href="testJson" id="testJson">Test Json</a><br><br>

    <form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
        File: <input type="file" name="file"/>
        Desc: <input type="text" name="desc"/>
        <input type="submit" value="Submit"/>
    </form>
    <br><br>

    <a href="testResponseEntity">Test ResponseEntity</a>

    <%--
    关于国际化：
      1.在页面上能够根据浏览器语言设置的清空对文本（不是内容），时间，数值进行本地化处理
      2.可以在bean中获取国际化资源文件Locale对应的消息
      3.可以通过超链接切换Locale，而不再依赖浏览器的语言设置情况

    解决：
      1.使用JSTL的fmt标签
      2.在bean中注入ResourceBundleMessageSource的示例，使用其对应的getMessage方法即可
      3.配置LocaleResolver和LocaleChangeInterceptor
    --%>
    <br><br>
    <a href="i18n">I18N PAGE</a>

    <br><br>
    <a href="testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>

    <br><br>
    <a href="testResponserStatusExceptionResolver?i=10">Test ResponserStatusExceptionResolver</a>

    <br><br>
    <a href="testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>

    <br><br>
    <a href="testSimpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>

</body>
</html>
