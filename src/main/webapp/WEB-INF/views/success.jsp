<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
    <h1>Success Login</h1>
    <form action="/auth/logout" method="POST">
        <button type="submit">Logout</button>
    </form>
    <form action="/home/booking" method="GET">
        <button type="submit">Booking</button>
    </form>

    <sec:authorize access="hasAuthority('developers:edit')">
        <form action="/management/manage" method="GET">
            <button type="submit">Management</button>
        </form>
    </sec:authorize>
</div>