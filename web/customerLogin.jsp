<%-- 
    Document   : customerLogin
    Created on : 06-Feb-2019, 11:42:30
    Author     : zbo97
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <script>
        $(document).ready(function(){
        var str = getCookie("loginInfo");
                str = str.substring(1, str.length - 1);
                var username = str.split(",")[0];
                var password = str.split(",")[1];
                $("#userName").val(username);
                $("#pwd").val(password);
        }
        function getCookie(cname) {
        var name = cname + "=";
                var ca = document.cookie.split(';');
                for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
                while (c.charAt(0) == ' ') c = c.substring(1);
                if (c.indexOf(name) != - 1) return c.substring(name.length, c.length);
        }
        return "";
        }
        function remember(){
        var remFlag = $("input[type='checkbox']").is(':checked');
                if (remFlag == true){
        var conFlag = confirm("Do not remember username and password accessing public PCs, are you sure to remember?");
                if (conFlag){
        $("#remFlag").val("1");
        } else{
        $("input[type='checkbox']").removeAttr('checked');
                $("#remFlag").val("");
        }
        } else{
        $("#remFlag").val("");
        }
        }
    </script>
    <body>
        <form action="FrontController" method="post">
            <table>
                <tr><td>Username: </td><td><input name="username" required size=20 type="text" /> </td></tr>
                <tr><td>Password: </td><td> <input name="password" required size=50 type="password" /> </td> </tr>
                <tr><td>Remember me</td><td><input name="rememberMe" type="checkbox" onclick="remember();" /></td></tr>
            </table>
            <input type="submit" value="Login" />
            <input type="hidden" name ="action" value="customerLogin" />
        </form>
    </body>
</html>
