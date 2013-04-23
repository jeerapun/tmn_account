<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>


<div class="span9">
    <div class="hero-unit">
        <div class="alert alert-success"><h1>Account Info</h1></div>
        
        <p>
        <div class="alert alert-info">
            <b>Account Code:</b> ${account.code}
        </div>
        </p>
        <p>
        <div class="alert alert-info">
            <b>Account Code:</b> ${account.name}
        </div>
        </p>
        <p>
        <div class="alert alert-info">
            <b>Account Code:</b> ${account.balance}
        </div>
        </p>
        <p><a href="DepositController?code=${account.code}" class="btn btn-primary btn-large">Deposit</a>
            <a href="DepositController?code=${account.code}" class="btn btn-primary btn-large">Transfer</a>
            <a href="DepositController?code=${account.code}" class="btn btn-primary btn-large">Withdraw</a></p>
    </div>


</div><!--/span-->
</div><!--/row-->

<hr>

<%@ include file="footer.jsp" %>
