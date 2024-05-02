<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Desafio Java</title>
    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .footer {
            color: white;
            height: 25px;
            text-align: center;
            bottom: 0;
            width: 100%;
            background-color: #525a59;
            text-shadow: 0.1em 0.1em 0.2em black;
            position: fixed;
            left: 0;
            line-height: 25px; /* Adicionado para garantir que a altura do texto do rodapé seja a mesma que a altura do rodapé */
        }

        .footer p {
            margin: 0;
            display: inline; /* Alterado para inline para evitar quebras de linha */
        }

        .footer ul {
            margin: 0;
            padding: 0;
            list-style: none;
            display: inline; /* Alterado para inline para evitar quebras de linha */
        }

        .footer ul li {
            display: inline-block;
            margin-right: 10px;
        }

        .footer ul li a {
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="footer">
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <p>&copy; 2024 Todos os direitos reservados.</p>
                </div>
                <div class="col-md-6">
                    <ul class="list-inline text-md-right">
                        <li class="list-inline-item"><a href="#">Termos de Uso</a></li>
                        <li class="list-inline-item"><a href="#">Política de Privacidade</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</div>
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</body>
</html>
