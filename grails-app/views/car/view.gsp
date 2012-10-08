<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<portlet:actionURL var="addCarURL">
	<portlet:param name="action" value="addCar" />
</portlet:actionURL>

<portlet:actionURL var="view" portletMode="view"/>

<div>
	<h1 class="header">What cars do we have?</h1>
	<ul class="cars-list">
	<g:each in="${cars}" var="car">
		<li>${car.name} with ${car.color} color.</li>
	</g:each>
	</ul>
	<h1 class="header">Choose car to be removed!</h1>
	<form method="post" action="<%= view %>">
		<g:select name="id" from="${cars}" optionKey="id" optionValue="name"/>
		<input type="submit" value="Remove"/>
	</form>

	<h1 class="header">Add a car</h1>
	<form method="post" action="<%= addCarURL %>">
		<input placeholder="Enter car name..." name="name" />
		<input placeholder="Enter car color..." name="color">
		<input type="submit" value="Add" />
	</form>
</div>
