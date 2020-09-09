<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><c:out value="${dad.getNome()}" /> - Página pessoal</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel="stylesheet" href="${pageContext.request.getContextPath()}/css/estilos.css">
</head>
<body>
    <article>
        <h1><c:out value="${dad.getNome()}" /></h1>
        <header>
            <div class="avatar">
                <img src="${pageContext.request.getContextPath()}/${dad.getImgPath()}" alt="Imagem do perfil">
            </div>
            <div class="contato">
                <p><c:out value="${dad.getTelefone()}" /></p>
                <p><a href="mailto:${dad.getEmail()}"><c:out value="${dad.getEmail()}" /></a></p>
                <p>Data de nascimento: <c:out value="${dad.getDataNascimento()}" /></p>
            </div>    
        </header>
        <div>Acesso às <c:out value="${timeinfo}" /></div>
        <c:if test="${mobile == true}">
            <h3>ACESSO VIA DISPOSITIVO MÓVEL</h3>
        </c:if>
        <h4><c:out value="${userAgent}" /></h4>
    </article>
</body>
</html>
