<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Calculadora</title>
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
    <h1>Bem vindo a calculadora, <%=request.getAttribute("login")%> </h1> 
    <div class="box">

        <form method="get" 
        action= "calculo.action">
        <p>Insira um número:</p> <input type = "text" name="op1"/><br/>
        <p><select name ="operacao"><br/></p>
            <option value = "+">(+)</option>
            <option value = "-">(-)</option>
            <option value = "*">(*)</option>
            <option value = "/">(/)</option>
            <option value = "pot">(pot)</option>
            <option value = "raiz">(raiz)</option>
        </select>
        <p>Insira outro número:</p> <input type = "text" name="op2"/><br/>
        <input type="submit">

    </form> 
    <br />
    <a href = historico.action> Historico </a>

</div>

</body>
</html>
