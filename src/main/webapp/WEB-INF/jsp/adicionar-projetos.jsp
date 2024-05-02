<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Novo Projeto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container-fluid bg-light py-3 text-center">
    <h4 class="mb-1">Novo Projeto</h4>
</div>

<div class="container mt-4">
    <form:form action="/adicionar-projeto" method="POST">
        <input type="hidden" path="id" name="id" id="id" value="${lastId}">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" path="nome" name="nome" class="form-control" id="nome" placeholder="Nome" value="${nome}" required>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="dataInicio">Data Início:</label>
                        <input type="text" path="dataInicio" name="dataInicio" class="form-control" id="dataInicio" placeholder="dd/MM/yyyy" value="${dataInicio}" required/>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataPrevisaoFim">Data Previsão Fim:</label>
                        <input type="text" path="dataPrevisaoFim" name="dataPrevisaoFim" class="form-control" id="dataPrevisaoFim" placeholder="dd/MM/yyyy" value="${dataPrevisaoFim}" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="dataFim">Data Fim:</label>
                    <input type="text" path="dataFim" name="dataFim" class="form-control" id="dataFim" placeholder="dd/MM/yyyy" value="${dataFim}" required/>
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea type="textarea" maxlength="5000" path="descricao" name="descricao" class="form-control" id="descricao" placeholder="Descrição" required>${descricao}</textarea>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="orcamento">Orçamento:</label>
                        <input type="text" path="orcamento" name="orcamento" class="form-control" id="orcamento" placeholder="R$" min="0.00" required/>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="risco">Risco:</label>
                        <select class="form-control" path="risco" name="risco" id="risco" required>
                            <option value="1">BAIXO</option>
                            <option value="2">MÉDIO</option>
                            <option value="3">ALTO</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" path="status" name="status" id="status" required>
                        <option value="1">EM ANÁLISE</option>
                        <option value="2">ANÁLISE REALIZADA</option>
                        <option value="3">ANÁLISE APROVADA</option>
                        <option value="4">INICIADO</option>
                        <option value="5">PLANEJADO</option>
                        <option value="6">EM ANDAMENTO</option>
                        <option value="7">ENCERRADO</option>
                        <option value="8">CANCELADO</option>
                    </select>
                </div>
                <div class="text-center">
                    <button type="submit" id="salvar" class="btn btn-primary">SALVAR</button>
                </div>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="footer.jsp"%>
<script>
    $("#salvar").click(function(){
        $.ajax({
            url: '/adicionar-projeto',
            method: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                nome: $("#nome").val(),
                dataInicio: $("#dataInicio").val(),
                dataFim: $("#dataFim").val(),
                dataPrevisaoFim: $("#dataPrevisaoFim").val(),
                descricao: $("#descricao").val(),
                status: $("#status").val(),
                orcamento: $("#orcamento").val(),
                risco: $("#risco").val()
            }),
            async: false,
            complete: function(data) {
                console.log(data);
            }
        });
    });
</script>
</body>
</html>