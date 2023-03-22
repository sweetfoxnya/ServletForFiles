<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="container">
            <div class="regbox box">

<h1> Register Account</h1>
<form action="/registration" method="post">
                   <p>
Username</p>
<input type="text" placeholder="Username" name="name" required>
                   <p>
Useremail</p>
<input type="text" placeholder="Useremail" name="email" required>
                   <p>
Password</p>
<input type="password" placeholder="Password" name="password" required>
<p> <input type="submit" value="Register" </p>
</form>

</div>
</div>
</body>
</html>
