<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Novo Cargo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid bg-light py-3 text-center">
    <h4 class="mb-0">Novo Cargo</h4>
</div>

<div class="container mt-4">
    <form:form action="/adicionar-pessoa" method="POST">
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" path="id" name="id" id="id" value="${lastPessoaId}">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" path="nome" name="nome" class="form-control" id="nome" placeholder="Nome" value="${nome}" required>
                </div>
                <div class="form-group">
                    <label for="dataNascimento">Data Nascimento:</label>
                    <input type="text" path="dataNascimento" name="dataNascimento" class="form-control date-mask" id="dataNascimento" placeholder="dd/MM/yyyy" value="<fmt:formatDate value='${dataNascimento}' />" required>
                </div>
                <div class="form-group">
                    <label for="cpf">CPF:</label>
                    <input type="text" path="cpf" name="cpf" class="form-control cpf-mask" id="cpf" placeholder="000.000.000-00" value="${cpf}" required>
                </div>
                <div class="form-group">
                    <label for="funcionario">Funcionário:</label>
                    <select class="form-control" path="funcionario" name="funcionario" id="funcionario" required>
                        <option value="1" ${funcionario == 1 ? 'selected' : ''}>SIM</option>
                        <option value="0" ${funcionario == 0 ? 'selected' : ''}>NÃO</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="gerente">Gerente:</label>
                    <select class="form-control" path="gerente" name="gerente" id="gerente" required>
                        <option value="1" ${gerente == 1 ? 'selected' : ''}>SIM</option>
                        <option value="0" ${gerente == 0 ? 'selected' : ''}>NÃO</option>
                    </select>
                </div>
                <div class="text-center">
                    <button type="submit" id="salvar" class="btn btn-primary">SALVAR</button>
                </div>
            </div>
        </div>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
<script>
    $(document).ready(function() {
        $('.date-mask').mask('00/00/0000');
        $('.cpf-mask').mask('000.000.000-00');
    });
</script>

<%@ include file="footer.jsp"%>
</body>
</html>
