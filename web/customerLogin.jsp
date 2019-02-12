<%-- 
    Document   : customerLogin
    Created on : 06-Feb-2019, 11:42:30
    Author     : zbo97
--%>

<%@page import="Dtos.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <script src="Jquery/jquery-3.3.1.js"></script>
    <script>
        $(function () {

            if (localStorage.chkbx && localStorage.chkbx != '') {
                $('#remember_me').attr('checked', 'checked');
                $('#username').val(localStorage.usrname);
                $('#pass').val(localStorage.pass);
            } else {
                $('#remember_me').removeAttr('checked');
                $('#username').val('');
                $('#pass').val('');
            }

            $('#remember_me').click(function () {

                if ($('#remember_me').is(':checked')) {
                    // save username and password
                    localStorage.usrname = $('#username').val();
                    localStorage.pass = $('#pass').val();
                    localStorage.chkbx = $('#remember_me').val();
                } else {
                    localStorage.usrname = '';
                    localStorage.pass = '';
                    localStorage.chkbx = '';
                }
            });
        });
    </script>
    <body>
        
        <form action="FrontController" method="post">
            <table>
                <tr><td>Username: </td><td><input name="username" required size=20 type="text" id="username"/> </td></tr>
                <tr><td>Password: </td><td> <input name="password" required size=50 type="password" id="pass"/> </td> </tr>
                <tr><td>Remember me</td><td><input name="remember-me" type="checkbox" value="remember-me" id="remember_me"/></td></tr>
            </table>
            <input type="submit" value="Login" />
            <input type="hidden" name ="action" value="customerLogin" />
        </form>
    </body>
</html>
