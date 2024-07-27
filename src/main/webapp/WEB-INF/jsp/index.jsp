<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Spring MVC CRUD Application</title>
      <style>
      table, th, td {
        border: 1px solid black;
      }
      </style>
        <script type="text/javascript">
              function checkAndSubmitForm() {
                  var idField = document.getElementById("id");

                  if (idField.value.trim() === "") {
                      idField.value = "0";
                  }

                  document.getElementById("bookForm").submit();
              }
          </script>
   </head>
   <body>
   <h2>Delete Book</h2>
   <form:form method="POST" action="${pageContext.request.contextPath}/deleteBook">
   <label for="id">Book ID</label>
   <input type="text" name="id">
   <button type="submit">Delete</button>
   </form:form>

    <h2>Add Book</h2>
   <form:form method="POST" action="${pageContext.request.contextPath}/addBook" modelAttribute="book" id="bookForm">
                    <table>
                                    <tr>
                                       <td><form:label path="id">ID</form:label></td>
                                       <td><form:input path="id" id="id"/></td>
                                       <td><form:errors path="id" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:label path="name">Name</form:label></td>
                                        <td><form:input path="name"/></td>
                                        <td><form:errors path="name" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:label path="author">Author</form:label></td>
                                        <td><form:input path="author"/></td>
                                        <td><form:errors path="author" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:label path="language">Language</form:label></td>
                                        <td><form:input path="language"/></td>
                                        <td><form:errors path="language" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><form:label path="numberOfPages">Number of pages</form:label></td>
                                        <td><form:input path="numberOfPages"/></td>
                                        <td><form:errors path="numberOfPages" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><button type="button" onClick="checkAndSubmitForm()">Add/Edit</button></td>
                                    </tr>
                    </table>
          </form:form>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
         <c:forEach items="${bookList}" var="book">
         <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.language}</td>
            <td>${book.numberOfPages}</td>
         </tr>
       </c:forEach>
       </table>


   </body>
</html>