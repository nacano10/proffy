<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt_br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proffy | Sua plataforma de estudos online</title>

    <link rel="stylesheet" href="/styles/main.css">
    <link rel="stylesheet" href="/styles/partials/header.css">
    <link rel="stylesheet" href="/styles/partials/forms.css">
    <link rel="stylesheet" href="/styles/partials/page-study.css">

    <link
        href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&amp;family=Poppins:wght@400;600&amp;display=swap"
        rel="stylesheet">
</head>

<body id="page-study">

    <div id="container">
        <header class="page-header">
            <div class="top-bar-container">
                <a href="/">
                    <img src="/images/icons/back.svg" alt="Voltar">
                </a>
                <img src="/images/logo.svg" alt="Proffy">
            </div>

            <div class="header-content">
                <strong>Esses são os proffys disponíveis</strong>
                <form id="search-teachers">
                    <div class="select-block">
                        <label for="subject">Matéria</label>
                        <select name="subject" id="subject">
                            <option value="" disabled="" hidden="">Selecione uma opção</option>

                            {%for subject in subjects %}
                                <option value="{{loop.index}}" {{ "selected" if filters.subject == loop.index}} >
                                    {{subject}}
                                </option>
                            {%endfor%}
                        </select>
                    </div>
                    <div class="select-block">
                        <label for="weekday">Dia da semana</label>
                        <select name="weekday" id="weekday">
                            <option value="" disabled="" hidden="">Selecione uma opção</option>
                            {%for weekday in weekdays %}
                                <option value="{{loop.index0}}" {{ "selected" if filters.weekday == loop.index0}} >
                                    {{weekday}}
                                </option>
                            {%endfor%}
                        </select>
                    </div>
                    <div class="input-block">
                        <label for="time">Hora</label>
                        <input name="time" id="time" type="time" value="{{filters.time}}" >
                    </div>
                    <button type="submit">Filtrar</button>
                </form>
            </div>
        </header>

        <main>
            {% if proffys == "" %}
                <p class="no-results">Nenhum professor encontrado com a sua pesquisa</p>
            {% else %}
                {%for proffy in proffys %}
                    <article class="teacher-item">
                        <header>
                            <img src="{{proffy.avatar}}" alt="{{proffy.name}}">
                            <div>
                                <strong>{{proffy.name}}</strong>
                                <span>{{proffy.subject}}</span>
                            </div>
                        </header>

                        <p>{{proffy.bio}}</p>

                        <footer>
                            <p>Preço/hora<strong>R$ {{proffy.cost}}</strong>
                            </p>
                            <a href="https://api.whatsapp.com/send?l=pt_BR&phone=55{{proffy.whatsapp}}&text=Tenho interesse na sua aula de {{proffy.subject}} {{proffy.name}}"
                                class="button" target="_blank">
                                <img src="/images/icons/whatsapp.svg" alt="Whatsapp">Entrar em contato
                            </a>
                        </footer>
                    </article>
                {%endfor%}
            {% endif %}




        </main>
    </div>

</body>

</html>