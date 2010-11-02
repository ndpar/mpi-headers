<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<%@page import="flex.data.DataServiceTransaction"%>
<%@page import="examples.ObjectBuilder"%>
<html>
<body>

<%
    final String DESTINATION = "MyDestination";

    String action = request.getParameter("action") != null ? request.getParameter("action") : "";
    String id = request.getParameter("id") != null ? request.getParameter("id") : "";
    String msg = "";

    if (action.equals("update") || action.equals("add")) {
        DataServiceTransaction transaction = DataServiceTransaction.begin(false);

        if (action.equals("update")) {
            transaction.updateItem(DESTINATION, ObjectBuilder.buildDomainObject(Integer.decode(id)), null, null);
        } else {
            transaction.createItem(DESTINATION, ObjectBuilder.buildDomainObject(Integer.decode(id)));
        }
        transaction.commit();

        msg = action + " has been committed";
    }
%>

<%=msg%>

<form name="doform" action="./update.jsp" method="post">
    ID: <input type="text" name="id" value="<%=id%>">
    <input type="submit" name="action" value="update">
    <input type="submit" name="action" value="add">
</form>

</body>
</html>