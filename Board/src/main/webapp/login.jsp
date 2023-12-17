<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HMTL 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap: Latest compiled JavaScript -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-sm bg-light mx-auto p-4 border-bottom">
        <h4 class="text-center text-muted">Hello</h4>
        <form action="login.do" method="post">
        <table class="table text-center table-bordered w-75 mx-auto">
                <tr>
                    <td class=>Username</td>
                    <td><input type="text" name="id" class="w-100 border border-light" placeholder="Enter username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" class="w-100 border border-light" placeholder="Enter password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-primary w-25">Log in</button>
                    </td>
                </tr>
        </table>
        </form>
    </div>
</body>
</html>