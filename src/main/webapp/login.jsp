<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="container">
            <div class="regbox box">
                <h1> Log in to your account</h1>
                <form action="/login" method="post">

                <p>Username</p>
                <input type="text" placeholder="Username" name="name" required>

                <p>Password</p>
                <input type="password" placeholder="Password" name="password" required>

                <form method="POST" action="/login">
                            <button name="btnLogin" type="submit">
                                Login
                            </button>
                        </form>
                </form>

                <form name = "form1" method = "get" action = "/registration">
                <input type = "submit" value = "Register">
                </form>
                </p>
            </div>
        </div>
    </body>
</html>