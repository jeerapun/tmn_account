<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp" %>


<div class="span9"> 
    <table class="table table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Account Code</th>
                <th>Account Name</th>
                <th>Account Balance</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${allAccount}">  
                <tr>
                    <td>1</td>
                    <td><a href="./DepositController?code=${account.code}">${account.code}</a></td>
                    <td>${account.name}</td>
                    <td align="right"><fmt:formatNumber type="number" maxFractionDigits="2"  value="${account.balance}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div><!--/span-->
</div><!--/row-->

<hr>

<%@ include file="footer.jsp" %>
