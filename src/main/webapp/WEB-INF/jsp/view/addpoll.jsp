<%@include file="header.jsp" %>

        <h3>Create a Poll</h3>
        <form:form method="POST" modelAttribute="pollForm">
            
            <form:label path="question">Poll Question</form:label><br/>
            <form:input type="text" path="question" /><br/><br/>
            
            <form:label path="choice_1">Option 1</form:label><br/>
            <form:input type="text" path="choice_1" /><br/><br/>
            
            <form:label path="choice_2">Option 2</form:label><br/>
            <form:input type="text" path="choice_2" /><br/><br/>
            
            <form:label path="choice_3">Option 3</form:label><br/>
            <form:input type="text" path="choice_3" /><br/><br/>
            
            <form:label path="choice_4">Option 4</form:label><br/>
            <form:input type="text" path="choice_4" /><br/><br/>

            <input type="submit" value="Submit" />

        </form:form>
    </body>
</html>