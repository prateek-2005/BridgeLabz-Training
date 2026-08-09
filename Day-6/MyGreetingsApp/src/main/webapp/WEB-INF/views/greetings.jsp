<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Greetings App</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f5f5f5;
        }

        .container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
        }

        h1 {
            text-align: center;
        }

        .create-form {
            margin-bottom: 30px;
        }

        input {
            padding: 10px;
            width: 60%;
        }

        button {
            padding: 10px 15px;
            cursor: pointer;
        }

        .greeting {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 15px 0;
            border-radius: 5px;
        }

        .update-form {
            display: inline;
        }

        .delete-form {
            display: inline;
            margin-left: 10px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Greetings App</h1>

    <!-- CREATE -->
    <h2>Create Greeting</h2>

    <form class="create-form"
          action="${pageContext.request.contextPath}/greetings"
          method="post">

        <input type="text"
               name="message"
               placeholder="Enter greeting"
               required>

        <button type="submit">
            Add Greeting
        </button>

    </form>

    <hr>

    <!-- READ -->
    <h2>All Greetings</h2>

    <c:choose>

        <c:when test="${empty greetings}">

            <p>No greetings found.</p>

        </c:when>

        <c:otherwise>

            <c:forEach var="greeting" items="${greetings}">

                <div class="greeting">

                    <p>
                        <strong>ID:</strong>
                        ${greeting.id}
                    </p>

                    <p>
                        <strong>Message:</strong>
                        ${greeting.message}
                    </p>

                    <!-- UPDATE -->
                    <form class="update-form"
                          action="${pageContext.request.contextPath}/greetings/${greeting.id}/update"
                          method="post">

                        <input type="text"
                               name="message"
                               value="${greeting.message}"
                               required>

                        <button type="submit">
                            Update
                        </button>

                    </form>

                    <!-- DELETE -->
                    <form class="delete-form"
                          action="${pageContext.request.contextPath}/greetings/${greeting.id}/delete"
                          method="post">

                        <button type="submit">
                            Delete
                        </button>

                    </form>

                </div>

            </c:forEach>

        </c:otherwise>

    </c:choose>

</div>

</body>
</html>