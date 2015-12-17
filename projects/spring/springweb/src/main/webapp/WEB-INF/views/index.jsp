<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Hello Spring </title>
</head>
<body>
Домашняя страница

<p>
${message}
</p>
<form method="post">
      <p>title</p>
      <input type="number" name="id">
      <input type="text" name="title">
      <input type="submit" value="Добавить">
    </form>
</body>
</html>