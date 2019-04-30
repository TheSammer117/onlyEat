<%-- 
    Document   : rHeader
    Created on : 2019-3-12, 21:31:08
    Author     : 82509
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="Dtos.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //Retreive the appropriate Locale
    Locale clientLocale = (Locale) session.getAttribute("currentLocale");
    
    //If theres no set locale, it's their first time here or a new session
    if(clientLocale == null){
        //get locale 
        clientLocale = request.getLocale();
        //save it
        session.setAttribute("currentLocale", clientLocale);
    }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="Styles/bootstrap-4.3.1/css/custom.css">
        <link rel="stylesheet" href="Styles/main.css">
    </head>

    <body>
        <div class="container">
            <%             Restaurant loggedInUser = (Restaurant) session.getAttribute("loggedInRestaurant");
                if (loggedInUser != null) {
            %>
            <nav class="navbar navbar-expand-lg navbar-light " style="background-color: #e3f2fd;">
                <a class="navbar-brand"  href="restaurantIndex.jsp">
                    <img src="Images/Logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo"/> Only Eat
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active ml-lg-5">
                            <a class="nav-link" href="restaurantIndex.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active ml-2">
                            <a class="nav-link" href="restaurantMenu.jsp">View My Restaurant Menu</a>
                        </li>
                        <li class="nav-item  ml-lg-5">
                            <a class="nav-link" href="FrontController?action=restaurantLogout">Logout</a>
                        </li>
                    </ul>
                </div>
                <form action="FrontController" method="post">
                            <select name="language" onchange="this.form.submit()">
                                <%
                                    String language = (String) session.getAttribute("language");
                                    if (language == null || language.equals("en")) {

                                %>   
                                <option value="en" selected>English</option>
                                <option value="fr">Français</option>
                                <%
                                    }else{
                                %>
                                    <option value="en">English</option>
                                    <option value="fr" selected>Français</option>
                                <%        
                                    }
                                %>
                            </select>
                            <input type="hidden" name="action" value="changeLanguage"/>
                        </form>
                            
<%
    // Retrieve the resource bundle from the session
    ResourceBundle dataBundle = (ResourceBundle) session.getAttribute("dataBundle");
    // If there is no bundle stored (i.e. if this is the first time you're coming to the site)
    if(dataBundle == null){
        // Create a resource bundle based on the client's current locale settings
        dataBundle = ResourceBundle.getBundle("properties.ClassicModels", clientLocale);

        // Store this resource bundle for future use
        session.setAttribute("dataBundle", dataBundle);
    }

%>
            </nav>
            <%
            } else {
            %>
            <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
                <a class="navbar-brand" href="restaurantIndex.jsp">
                    <img src="Images/Logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo"/> Only Eat
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active ml-lg-5">
                            <a class="nav-link" href="restaurantIndex.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item ml-lg-5">
                            <a class="nav-link" href="restaurantLogin.jsp">Sign In</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="restaurantRegister.jsp">Register</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <%
                }
            %>
        </div>
    </body>
</html>
