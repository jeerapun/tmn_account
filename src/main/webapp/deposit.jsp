<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>

<div class="span9">
    <h1>${account.code}:${account.name}</h1>
    <p>Current Balance: ${account.balance}</p>
    <form class="well" action="DepositController" method="POST">
        <input name="code" type="hidden" value="<c:out value="${requestScope.code}"/>" />
        <label>Amount</label>
        <input name="amount" type="text" class="span3" placeholder="0">
        <span class="help-block">Amount money to deposit</span>
        <button type="submit" class="btn">Submit</button>
    </form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Transaction Date:Time</th>
                <th>Transaction Type</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="history" items="${account.transactionHistory}">  
                <tr>
                    <td>#</td>
                    <td>${history.transactionDate}</td>
                    <td>${history.code}</td>
                    <td align="right"><fmt:formatNumber type="number" maxFractionDigits="2"  value="${history.amount}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div><!--/span-->
</div><!--/row-->

<hr>
<%@ include file="footer.jsp" %>
