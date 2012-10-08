%{--added.gsp--}%
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

Car was successfuly added!

<portlet:actionURL var="view" portletMode="view" />

<a href="<%= view %>">Back</a>

