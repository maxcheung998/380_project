<%@include file="header.jsp" %>
<body>

    <h1>Welcome to Web Forum, ${poll.username}</h1>
    <a href="<c:url value="/lecture/list"/>"><h3>Lecture</h3></a>
    <a href="<c:url value="/lab/list" />"><h3>Lab</h3></a>
    <a href="<c:url value="/other/list" />"><h3>Other</h3></a>
    <a href="<c:url value="/poll" />"><h3>Poll History</h3></a>
    <c:choose>
        <c:when test="${fn:length(poll) == 0}">
            <h3><i>There are no poll  in the system.</i></h3>
        </c:when>
        <c:otherwise>
            <h3>Latest Poll #${poll.id} <br> Question: <c:out value="${poll.question}" /> <br> Total Votes: ${poll.total_count} </h3>
            <br />
            <b>Choice: </b>
            <ul>
                <c:if test="${(poll.choice_1 != null) && (poll.choice_1 != '')}">
                    <li>

                        <c:url var="link1" value="/poll/votePoll/${poll.id}/${poll.choice_1}" />
                        <form action="${link1}" method="post">
                            <c:out value="${poll.choice_1}" />&nbsp&nbsp&nbsp&nbsp
                            <security:authorize access="hasAnyRole('USER','ADMIN')">
                               <c:if test="${(poll.UserVoted == 'false')}">
                                <input type="submit" value="Vote" />&nbsp&nbsp&nbsp&nbsp
                                </c:if>
                            </security:authorize>
                            Votes: ${poll.VotesC1}
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form><br />
                    </li>
                </c:if>
                <c:if test="${(poll.choice_2 != null) && (poll.choice_2 != '')}">
                    <li>
                        <c:url var="link2" value="/poll/votePoll/${poll.id}/${poll.choice_2}" />
                        <form action="${link2}" method="post">
                            <c:out value="${poll.choice_2}" />&nbsp&nbsp&nbsp&nbsp
                            <security:authorize access="hasAnyRole('USER','ADMIN')">
                                <c:if test="${(poll.UserVoted == 'false')}">
                                <input type="submit" value="Vote" />&nbsp&nbsp&nbsp&nbsp
                                 </c:if>
                            </security:authorize>   
                            Votes: ${poll.VotesC2}
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form><br />
                    </li>
                </c:if>
                <c:if test="${(poll.choice_3 != null) && (poll.choice_3 != '')}">
                    <li>
                        <c:url var="link3" value="/poll/votePoll/${poll.id}/${poll.choice_3}" />
                        <form action="${link3}" method="post">
                            <c:out value="${poll.choice_3}" />&nbsp&nbsp&nbsp&nbsp
                            <security:authorize access="hasAnyRole('USER','ADMIN')">
                                <c:if test="${(poll.UserVoted == 'false')}">
                                <input type="submit" value="Vote" />&nbsp&nbsp&nbsp&nbsp
                                 </c:if>
                            </security:authorize>   
                            Votes: ${poll.VotesC3}
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form><br />
                    </li>
                </c:if>
                <c:if test="${(poll.choice_4 != null) && (poll.choice_4 != '')}">
                    <li>
                        <c:url var="link4" value="/poll/votePoll/${poll.id}/${poll.choice_4}" />
                        <form action="${link4}" method="post">
                            <c:out value="${poll.choice_4}" />&nbsp&nbsp&nbsp&nbsp
                            <security:authorize access="hasAnyRole('USER','ADMIN')">
                                <c:if test="${(poll.UserVoted == 'false')}">
                                <input type="submit" value="Vote" />&nbsp&nbsp&nbsp&nbsp
                                 </c:if>
                            </security:authorize>
                            Votes: ${poll.VotesC4}
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form><br />
                    </li>
                </c:if>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>
