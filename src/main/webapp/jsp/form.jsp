<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
    <title>Login</title>
    <meta charset="utf-8">
</head>
<style type="text/css">
    body{
        background: #f2f2f2;
    }
    .box{
        background: #B0C4DE;
        width: 190px;
        height: 220px;
        padding: 50px;
        margin: 0 auto;
        border-radius: 20px;
        align-items: center;
        box-shadow: 10px 10px #d6d6d6;
    }
    input[type="submit" i]{
        display: flex;
        justify-content:center;
        padding: 3px 15px 3px 15px;
    }
    input{
        border-radius: 6px; 
        margin: 0 auto;
        display: flex;
        justify-content:center;
        border: 3px solid transparent;
    }
    p{
        text-align: center;
        font-size: 16px;
    }
    h1{
        text-align: center;
    }
</style>
<body>
    <h1>Login</h1>
    <div class="box">
        <form method="get" 
        action="login.action">
        <p>Usuario:</p><input name="usuario"/>
        <p>Senha:</p><input name="senha"/>
        <br />
        <input type="submit">
    </form>
</div>
</body>    
</html>