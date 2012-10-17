<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<portlet:actionURL var="addCarURL">
	<portlet:param name="action" value="addCar"/>
</portlet:actionURL>

<portlet:resourceURL var="ajaxCall">
	<portlet:param name="action" value="doSomethingAjaxy"/>
</portlet:resourceURL>

<portlet:actionURL var="view" portletMode="view"/>


<div>
	<h1 class="header">What cars do we have?</h1>
	<ul class="cars-list">
		<g:each in="${cars}" var="car">
			<li>${car.name} with ${car.color} color.</li>
		</g:each>
	</ul>

	<h1 class="header">Choose car to be removed!</h1>

	<form method="post" action="${view}">
		<g:select name="id" from="${cars}" optionKey="id" optionValue="name"/>
		<input type="submit" value="Remove"/>
	</form>

	<h1 class="header">Add a car</h1>

	<form method="post" action="${addCarURL}">
		<input placeholder="Enter car name..." name="name"/>
		<input placeholder="Enter car color..." name="color">
		<input type="submit" value="Add"/>
	</form>

	<a id="ajaxLink" href="#">Rent a car</a>

	<div id="rent">No content yet.</div>

	<script type="text/javascript">
		$(function () {
			$('#ajaxLink').on('click', function (e) {
				e.preventDefault();
				$.ajax({
					type:'GET',
					url:'<%=ajaxCall %>',
					dataType:'JSON',
					success:function (data) {
						$('#rent').text(data.success);
					}
				});
			});
		});
	</script>

</div>
