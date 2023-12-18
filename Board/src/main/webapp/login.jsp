<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HMTL 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-sm bg-secondary mx-auto p-4 border-bottom">
        <h4 class="text-center text-muted">Hello</h4><hr/>
        <form action="login.do" method="post">
        <table class="container table text-center table-bordered w-50 mx-auto table-dark shadow">
                <tr>
                    <td class="p-2 align-middle">Username</td>
                    <td align="left"><input type="text" name="id" class="w-75 rounded bg-light" placeholder="Enter username"/></td>
                </tr>
                <tr>
                    <td class="p-2 align-middle">Password</td>
                    <td align="left"><input type="password" name="password" class="w-75 rounded bg-light" placeholder="Enter password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-light w-25">Log in</button>
                    </td>
                </tr>
        </table>
        </form>
    </div>
</body>
</html>