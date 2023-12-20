<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete account</title>
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-sm bg-secondary mx-auto p-4 border-bottom">
        <h4 class="text-center text-muted">Delete account</h4><hr/>
        <form action="deleteAccount.do" method="post">
	        <table class="container table text-center table-bordered w-50 mx-auto table-dark shadow">
	                <tr>
	                    <td class="p-2 align-middle">Enter username</td>
	                    <td align="left"><input type="text" name="id" class="w-75 rounded bg-light" placeholder="Enter username"/></td>
	                </tr>
	                <tr>
	                    <td class="p-2 align-middle">Enter password</td>
	                    <td align="left"><input type="password" name="password" class="w-75 rounded bg-light" placeholder="Enter password"></td>
	                </tr>
	                <tr>
	                    <td colspan="2" align="center">
	                        <button type="submit" class="btn btn-light w-25">Delete account</button>
	                    </td>
	                </tr>
	        </table>
        </form>
    </div>
</body>

<script>
function checkDelete(){
	
}
</script>
</html>