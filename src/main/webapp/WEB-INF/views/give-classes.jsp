<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<!DOCTYPE html>
<html lang="pt_br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proffy | Sua plataforma de estudos online</title>
    
    <link rel="shortcut icon" href="/images/favicon.png" type="image/png">

    <link rel="stylesheet" href="/styles/main.css">
    <link rel="stylesheet" href="/styles/partials/header.css">
    <link rel="stylesheet" href="/styles/partials/forms.css">
    <link rel="stylesheet" href="/styles/partials/page-give-classes.css">

    <link
        href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&amp;family=Poppins:wght@400;600&amp;display=swap"
        rel="stylesheet">

    <script src="/scripts/addField.js" defer></script>
   
</head>

<body id="page-give-classes">

    <div id="container">
        <header class="page-header">
            <div class="top-bar-container">
                <a href="/">
                    <img src="/images/icons/back.svg" alt="Voltar">
                </a>
                <img src="/images/logo.svg" alt="Proffy">
            </div>

            <div class="header-content">
                <strong>Que incrível que você quer dar aulas</strong>
                <p>O primeiro passo, é preencher esse formulário de inscrição</p>

            </div>
        </header>

        <main>
            <form action="/save-classes" id="create-class" method="POST">
                <fieldset>
                    <legend>Seus dados</legend>

                    <div class="input-block">
                        <label for="name">Nome completo</label>
                        <input name="name" id="name" >
                    </div>
                    <div class="input-block">
                        <label for="avatar">Link da sua foto <small>(comece com https://)</small></label>
                        <input name="avatar" id="avatar" type="url" >
                    </div>
                    <div class="input-block">
                        <label for="whatsapp">Whatsapp <small>(somente números)</small></label>
                        <input name="whatsapp" id="whatsapp" type="number" >
                    </div>
                    <div class="textarea-block">
                        <label for="bio">Biografia</label>
                        <textarea name="bio" id="bio" ></textarea>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>Sobre a aula</legend>
                    <div class="select-block">
                        <label for="subject">Matéria</label>
                        <select name="subject" id="subject" >
                            <option value="">Selecione uma opção</option>
                            <c:forEach	items="${subjects}" var="subject">
                                    <option value="${subject.id}">
                                        ${subject.subject}
                                    </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="input-block">
                        <label for="cost">
                            Custo da sua hora/aula
                            <small>(R$)</small>
                        </label>
                        <input name="cost" type="cost" id="cost" type="number" >
                    </div>
                </fieldset>

                <fieldset id="schedule-items">
                    <legend>
                        Horários disponíveis
                        <button type="button" id="add-time">+ Novo Horário</button>
                    </legend>

                    <div class="schedule-item">

                        <div class="select-block">
                            <label for="weekday">Dia da semana</label>
                            <select name="weekday_string" >
                                <option value="">Selecione um opção</option>
                                <c:forEach	items="${weekdays}" var="weekday">
                                    <option value="${weekday.id}">
                                        ${weekday.day}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="input-block">
                            <label for="time_from">Das</label>
                            <input type="time" name="time_from_string" >
                        </div>

                        <div class="input-block">
                            <label for="time_to">Até</label>
                            <input type="time" name="time_to_string" >
                        </div>
                    </div>
                </fieldset>
            </form>

            <footer>
                <p>
                    <img src="/images/icons/warning.svg" alt="Aviso importante">
                    Importante! <br> Preencha todos os dados
                </p>
                <button type="submit" form="create-class">Salvar cadastro</button>
            </footer>
        </main>
    </div>

</body>

</html>