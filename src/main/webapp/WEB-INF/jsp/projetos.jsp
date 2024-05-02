<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
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

        .description-cell {
            max-width: 200px;
            overflow: hidden;
            width: 114px;
            height: 112px;
            display: -webkit-box;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
        }

        #content:hover {
            overflow: visible;
            white-space: normal;
            width: auto;
            position: absolute;
            background-color: #FFF;
        }

        #content:hover + div {
            margin-top: 20px;
        }

    </style>
</head>
<body>
<div class="p-2 text-center bg-light">
    <h4 class="mb-1">Lista de Projetos</h4>
</div>
<div>
    <form method="post" action="/adicionar-projeto">
        <input type="submit" class="btn btn-primary btn-md text" value="NOVO PROJETO">
    </form>
</div>
<div class="container">
    <div class="text-left" style="margin:5px 5px 5px 5px;"></div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-body">
            <table class="table table-striped" id="pTabela">
                <thead>
                <tr>
                    <th width="10%">Nome</th>
                    <th width="10%">Data Início</th>
                    <th width="10%">Data Previsão Fim</th>
                    <th width="10%">Data Fim</th>
                    <th width="12%">Descrição</th>
                    <th width="12%">Status</th>
                    <th width="10%">Orçamento</th>
                    <th width="10%">Risco</th>
                    <th width="15%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projeto}" var="projeto">
                    <tr>
                        <td>${projeto.nome}</td>
                        <td>${projeto.dataInicio}</td>
                        <td>${projeto.dataPrevisaoFim}</td>
                        <td>${projeto.dataFim}</td>
                        <td id="content">${projeto.descricao}</td>
                        <td id="status">
                            <c:choose>
                                <c:when test="${projeto.status eq '1'}">EM ANÁLISE</c:when>
                                <c:when test="${projeto.status eq '2'}">ANÁLISE REALIZADA</c:when>
                                <c:when test="${projeto.status eq '3'}">ANÁLISE APROVADA</c:when>
                                <c:when test="${projeto.status eq '4'}">INICIADO</c:when>
                                <c:when test="${projeto.status eq '5'}">PLANEJADO</c:when>
                                <c:when test="${projeto.status eq '6'}">EM ANDAMENTO</c:when>
                                <c:when test="${projeto.status eq '7'}">ENCERRADO</c:when>
                                <c:when test="${projeto.status eq '8'}">CANCELADO</c:when>
                                <c:otherwise>Desconhecido</c:otherwise>
                            </c:choose>
                        </td>
                        <td><fmt:formatNumber value="${projeto.orcamento}" type="currency" currencyCode="BRL"/></td>
                        <td id="risco">
                            <c:choose>
                                <c:when test="${projeto.risco eq '1'}">BAIXO</c:when>
                                <c:when test="${projeto.risco eq '2'}">MÉDIO</c:when>
                                <c:when test="${projeto.risco eq '3'}">ALTO</c:when>
                                <c:otherwise>Desconhecido</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a type="button" class="btn btn-success" href="/atualizar-projeto/${projeto.id}">Atualizar</a>
                            <c:choose>
                                <c:when test="${projeto.status == 4 || projeto.status == 6 || projeto.status == 7}">
                                    <a type="button" class="btn btn-warning btnDelete" href="#" disabled>Excluir</a>
                                </c:when>
                                <c:otherwise>
                                    <a type="button" class="btn btn-warning btnDelete" href="/deletar-projeto/${projeto.id}">Excluir</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
<script>
    $(document).ready(function(){
        $(".btnDelete").on('click', function(){
            var currentRow = $(this).closest("tr");
            var statusCell = currentRow.find("td:eq(5)");
            var col = statusCell.text().trim();

            if(col === "INICIADO" || col === "EM ANDAMENTO" || col === "ENCERRADO"){
                $(this).prop('disabled', true);
                if(col === "INICIADO") {
                    alert("O status INICIADO não permite exclusão.");
                } else if(col === "EM ANDAMENTO") {
                    alert("O status EM ANDAMENTO não permite exclusão.");
                } else if(col === "ENCERRADO") {
                    alert("O status ENCERRADO não permite exclusão.");
                }
                return false;
            }
        });
    });
</script>