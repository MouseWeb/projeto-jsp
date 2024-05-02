<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="UTF-8">
    <title>Atualizar Projeto</title>

    <style>
        .container {
            margin-top: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-atualizar {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col text-center bg-light py-3">
            <h4>Atualizar Projeto</h4>
        </div>
    </div>
    <form:form action="/atualizar-projeto/${id}" method="post">
        <input type="hidden" path="id" name="id" id="id" value="${id}">
        <div class="row">
            <div class="col-md-8">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" path="nome" name="nome" class="form-control" id="nome" placeholder="Nome" value="${projeto.nome}" required/>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="risco">Risco:</label>
                    <select class="form-control" path="risco" name="risco" id="risco" required>
                        <option value="1">BAIXO</option>
                        <option value="2">MÉDIO</option>
                        <option value="3">ALTO</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="form-group">
                    <label for="dataInicio">Data Início</label>
                    <input type="text" path="dataInicio" name="dataInicio" class="form-control" id="dataInicio" placeholder="dd/MM/yyyy" value="${projeto.dataInicio}" required/>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="dataPrevisaoFim">Data Previsão Fim</label>
                    <input type="text" path="dataPrevisaoFim" name="dataPrevisaoFim" class="form-control" id="dataPrevisaoFim" placeholder="dd/MM/yyyy" value="${projeto.dataPrevisaoFim}" required/>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="dataFim">Data Fim</label>
                    <input type="text" path="dataFim" name="dataFim" class="form-control" id="dataFim" placeholder="dd/MM/yyyy" value="${projeto.dataFim}" required/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea type="textarea" maxlength="5000" path="descricao" name="descricao" class="form-control" id="descricao" placeholder="Descrição" required>${projeto.descricao}</textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" path="status" name="status" id="status" required>
                        <option value="1" ${projeto.status == '1' ? 'selected' : ''}>EM ANÁLISE</option>
                        <option value="2" ${projeto.status == '2' ? 'selected' : ''}>ANÁLISE REALIZADA</option>
                        <option value="3" ${projeto.status == '3' ? 'selected' : ''}>ANÁLISE APROVADA</option>
                        <option value="4" ${projeto.status == '4' ? 'selected' : ''}>INICIADO</option>
                        <option value="5" ${projeto.status == '5' ? 'selected' : ''}>PLANEJADO</option>
                        <option value="6" ${projeto.status == '6' ? 'selected' : ''}>EM ANDAMENTO</option>
                        <option value="7" ${projeto.status == '7' ? 'selected' : ''}>ENCERRADO</option>
                        <option value="8" ${projeto.status == '8' ? 'selected' : ''}>CANCELADO</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="orcamento">Orçamento:</label>
                    <input type="number" path="orcamento" name="orcamento" class="form-control" id="orcamento" placeholder="R$" value="${projeto.orcamento}" min="0.00" required/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col text-center">
                <button type="submit" class="btn btn-primary btn-atualizar">ATUALIZAR</button>

            </div>
        </div>
    </form:form>
</div>
<%@ include file="footer.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $("#atualizar").click(function(e){
            e.preventDefault();
            var projetoId = $(this).data("id");
            var url = '/atualizar-projeto/' + projetoId;
            var projetoData = {
                nome: $("#nome").val(),
                dataInicio: $("#dataInicio").val(),
                dataFim: $("#dataFim").val(),
                dataPrevisaoFim: $("#dataPrevisaoFim").val(),
                descricao: $("#descricao").val(),
                status: $("#status").val(),
                orcamento: $("#orcamento").val(),
                risco: $("#risco").val()
            };

            $.ajax({
                url : url,
                method : 'POST',
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                data: projetoData,
                success : function(data) {
                    console.log(data);
                },
                error : function(xhr, status, error) {
                    console.error(xhr.responseText);
                }
            });
        });
    });
</script>
</body>
</html>
