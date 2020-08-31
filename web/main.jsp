<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>Login Form</title></head>
    <body>
        <div style="margin: 0 auto; width: 30%;">            
            <%if ((status != null) && !status.isSuccessful()) {%>
            <font color="red">There were problems processing your request:
            <ul><%Iterator errors = status.getExceptions();
                while (errors.hasNext()) {
                    Exception ex = (Exception) errors.next();%>
                <li><%= ex.getMessage()%><%}%></ul></font><%}%>

                <table border="0">
                    <form action="login" method="post">
                        <tr>
                            <td width="150" height="50">Login Select</td>
                            <td>
                                <input type="radio" name="usertype" value="unknown" checked="checked">None
                                <input type="radio" name="usertype" value="A">Administrator
                                <input type="radio" name="usertype" value="C">Customer
                            </td>
                        </tr>

                        <tr>
                            <td width="150" height="40">User Name</td>
                            <td><input type="text" name="username" size="37"></td>

                        </tr>

                        <tr>
                            <td width="150" height="40">Password</td>
                            <td><input type="password" name="password" size="38"></td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <input type="submit" value="LOGIN" style="width:400px; height:40px;">   
                            </td>  
                        </tr>                   
                    </form>  

                    <tr>
                        <td colspan="2">
                            <form action="join.jsp" method="post">
                                <input type="submit" value="JOIN" style="width:400px; height:40px;">
                            </form>
                        </td>  
                    </tr>                    
                </table>  
        </div>
                
    </body>
</html>