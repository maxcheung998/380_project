<%@include file="header.jsp" %>
<body>

    <h2>Poll</h2>
    
         <c:choose>
            <c:when test="${fn:length(pollDatabase) == 0}">
                <i>There are no poll in the system.</i>
            </c:when>
            <c:otherwise>
                <c:out value="${null}" escapeXml="false">Total Poll: ${fn:length(pollDatabase)}</c:out>
                <table>
                    <tr>
                        <th>ID</th><th>Question</th>
                    </tr>
                    <c:forEach items="${pollDatabase}" var="poll">
                        <tr>
                            <td>${poll.id}</td>
                            <td><a href="<c:url value="/poll/view/${poll.id}" />">${poll.question}</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
</body>
</html>

