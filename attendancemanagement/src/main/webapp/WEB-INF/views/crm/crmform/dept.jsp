<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department Upload</title>
</head>
<body>

<h1>Department Upload</h1>

<form action="uploadfile" method="post" enctype="multipart/form-data">

    <label>Upload File:</label>
    <input type="file" name="file" required>
    
    <button type="submit">Submit</button>
</form>

</body>
</html>
