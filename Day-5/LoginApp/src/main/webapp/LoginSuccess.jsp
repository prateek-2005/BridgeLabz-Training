<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Success</title>
</head>
<body>

    <h3>Hi <%= request.getAttribute("user") %>, Login successful.</h3>

    <a href="login.html">Login Page</a>

</body>
</html>