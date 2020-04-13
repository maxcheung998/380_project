<%@include file="header.jsp" %>
<body>
    <br/><br/>
  <!--<input type ="button" onclick="history.back()" value="Back to previous"></input>-->
 <h3> Poll #${poll.id} <br> Question: <c:out value="${poll.question}" /></h3><h3>Total Votes: ${poll.total_count} </h3>
        <br />
        <b>Choice: </b>
        <ul>
            <c:if test="${(poll.choice_1 != null) && (poll.choice_1 != '')}">
            <li>
                <c:out value="${poll.choice_1}" />&nbsp&nbsp&nbsp&nbsp
                Votes: ${poll.VotesC1}
                   <br /><br />
            </li>
            </c:if>
            <c:if test="${(poll.choice_2 != null) && (poll.choice_2 != '')}">
            <li>
                <c:out value="${poll.choice_2}" />&nbsp&nbsp&nbsp&nbsp
                 Votes: ${poll.VotesC2}
                    <br /><br />
            </li>
            </c:if>
            <c:if test="${(poll.choice_3 != null) && (poll.choice_3 != '')}">
            <li>
                <c:out value="${poll.choice_3}" />&nbsp&nbsp&nbsp&nbsp
                 Votes: ${poll.VotesC3}
                    <br /><br />
            </li>
            </c:if>
            <c:if test="${(poll.choice_4 != null) && (poll.choice_4 != '')}">
            <li>
                <c:out value="${poll.choice_4}" />&nbsp&nbsp&nbsp&nbsp
                 Votes: ${poll.VotesC4}
                    <br /><br />
            </li>
            </c:if>
        </ul>    
        
     </body>