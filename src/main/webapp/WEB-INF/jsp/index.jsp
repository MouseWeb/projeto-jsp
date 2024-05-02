<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Desafio Java</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>">

    <!-- Estilos personalizados -->
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
</head>
<body>
<%@ include file="header.jsp" %>

<!-- Seção de destaque -->
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="display-4">Bem-vindo à Empresa XYZ</h1>
        <p class="lead">A solução para seus negócios.</p>
        <a href="#" class="btn btn-primary btn-lg">Saiba mais</a>
    </div>
</section>

<!-- Seção de serviços -->
<section class="py-5 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 mb-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h4 class="card-title">Serviço 1</h4>
                        <p class="card-text">Descrição do Serviço 1.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h4 class="card-title">Serviço 2</h4>
                        <p class="card-text">Descrição do Serviço 2.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h4 class="card-title">Serviço 3</h4>
                        <p class="card-text">Descrição do Serviço 3.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Seção de Contato -->
<section class="py-5">
    <div class="container">
        <h2 class="text-center mb-4">Entre em Contato</h2>
        <div class="row">
            <div class="col-lg-6 mx-auto">
                <form>
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                        <label for="mensagem">Mensagem</label>
                        <textarea class="form-control" id="mensagem" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </div>
        </div>
    </div>
</section>

<%@ include file="footer.jsp"%>

<!-- Bootstrap JS -->
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</body>
</html>
