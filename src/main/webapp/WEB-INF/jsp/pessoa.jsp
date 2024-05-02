<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Desafio Java</title>
    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .card {
            margin-bottom: 20px;
        }

        .card-header {
            background-color: #007bff;
            color: white;
        }

        .card-title {
            margin-bottom: 0;
        }

        .table th, .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <div class="card">
        <div class="card-header">
            <h4 class="card-title mb-0">Lista de Pessoas</h4>
        </div>
        <div class="card-body">
            <form method="post" action="/adicionar-pessoa">
                <input type="submit" class="btn btn-primary" value="Nova Pessoa">
            </form>
            <div class="mt-3">
                <c:out value="${alerta.text}"/>
            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data de Nascimento</th>
                        <th>CPF</th>
                        <th>Funcionário</th>
                        <th>Gerente</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pessoa}" var="pessoa">
                        <tr>
                            <td>${pessoa.pessoaCol}</td>
                            <td>${pessoa.nome}</td>
                            <td><fmt:formatDate value="${pessoa.dataNascimento}" pattern="dd/MM/yyyy" /></td>
                            <td>${pessoa.cpf}</td>
                            <td>${pessoa.funcionario ? 'Sim' : 'Não'}</td>
                            <td>${pessoa.gerente ? 'Sim' : 'Não'}</td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Ações">
                                    <a href="/buscar-pessoa/${pessoa.id}" class="btn btn-success">Atualizar</a>
                                    <a href="/deletar-pessoa/${pessoa.id}" class="btn btn-warning">Excluir</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</body>
</html>
