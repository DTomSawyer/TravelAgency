<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style><%@include file="/WEB-INF/resources/css/success.css"%></style>
<div class="container">
    <div class="successe__item">

        <h1 class="s_l">Success Login</h1>
        <div class="btn__sc">
            <form class="btn__item" action="/auth/logout" method="POST">
                <button class="btn" type="submit">Logout </button>
            </form>
            <form class="btn__item" action="/home/booking" method="GET">
                <button class="btn" type="submit">Booking </button>
            </form>
            <sec:authorize access="hasAuthority('developers:edit')">
                <form class="btn__item" action="/management/manage" method="GET">
                    <button class="btn" type="submit">Management </button>
                </form>
            </sec:authorize>
        </div>
    </div>

</div>

</div>
</div>