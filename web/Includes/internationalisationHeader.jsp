<%-- 
    Document   : internationalisationHeader
    Created on : 30-Apr-2019, 18:54:55
    Author     : zbo97
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //Retreive the appropriate Locale
    Locale clientLocale = (Locale) session.getAttribute("currentLocale");

    //If theres no set locale, it's their first time here or a new session
    if (clientLocale == null) {
        //get locale 
        clientLocale = request.getLocale();
        //save it
        session.setAttribute("currentLocale", clientLocale);
    }
%>
<form action="FrontController" method="post">
    <select name="language" onchange="this.form.submit()">
        <%
            String language = (String) session.getAttribute("language");
            if (language == null || language.equals("en")) {

        %>   
        <option value="en" selected>English</option>
        <option value="fr">Français</option>
        <%                                } else {
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
    if (dataBundle == null) {
        // Create a resource bundle based on the client's current locale settings
        dataBundle = ResourceBundle.getBundle("Properties.OnlyEat", clientLocale);

        // Store this resource bundle for future use
        session.setAttribute("dataBundle", dataBundle);
    }

%>
