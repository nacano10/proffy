<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="/styles/partials/page-study.css">

<link
	href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&amp;family=Poppins:wght@400;600&amp;display=swap"
	rel="stylesheet">
</head>

<body id="page-study">

	<div id="container">
		<header class="page-header">
			<div class="top-bar-container">
				<a href="/"> <img src="/images/icons/back.svg" alt="Voltar">
				</a> <img src="/images/logo.svg" alt="Proffy">
			</div>

			<div class="header-content">
				<strong>Esses são os proffys disponíveis</strong>
				<form id="search-teachers">
					<div class="select-block">
						<label for="subject">Matéria</label> 
						<select name="subject" id="subject">
							<option value="" hidden="">Selecione uma opção</option>
							<c:forEach items="${subjects}" var="subject">
								<option value="${subject.id}">${subject.subject}</option>
							</c:forEach>
						</select>
					</div>
					<div class="select-block">
						<label for="weekday">Dia da semana</label> 
						<select name="weekday" id="weekday">
							<option value="" >Selecione uma opção</option>
							<c:forEach items="${weekdays}" var="weekday">
								<option value="${weekday.id}">${weekday.day}</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-block">
						<label for="time">Hora</label>
						<input 
							name="time" 
							id="time"
							type="time" 
							value="{{filters.time}}">
					</div>
					<button type="submit">Filtrar</button>
				</form>
			</div>
		</header>

		<main>			
			<c:if test="${csv.size() == 0}">
				<p class="no-results">
					Nenhum professor encontrado com a sua pesquisa
				</p>
			</c:if>
				
			<c:if test="${csv.size() > 0}">

			<c:forEach items="${csv}" var="cs">
				<article class="teacher-item">
					<header>
						<img src="${cs.classes.proffy.avatar}" alt="${cs.classes.proffy.name}">
						<div>
							<strong>${cs.classes.proffy.name}</strong>

							<c:forEach items="${subjects}" var="subject">
								<c:set var="index" scope="session" value="${cs.classes.subject}" />
								<c:if test="${subject.id == index}">

									<span>${subject.subject}</span>

								</c:if>
							</c:forEach>

						</div>
					</header>

					<p>${cs.classes.proffy.bio}</p>

					<footer>
						<p>
							Preço/hora<strong>R$ ${cs.classes.cost}</strong>
						</p>
						<c:forEach items="${subjects}" var="subject">
							<c:set var="index" scope="session" value="${cs.classes.subject}" />
							<c:if test="${subject.id == index}">

								<a
									href="https://api.whatsapp.com/send?l=pt_BR&phone=55${cs.classes.proffy.whatsapp}&text=Tenho interesse na sua aula de ${subject.subject} ${cs.classes.proffy.name}"
									class="button" target="_blank"> <img
									src="/images/icons/whatsapp.svg" alt="Whatsapp">Entrar em
									contato
								</a>

							</c:if>
						</c:forEach>


					</footer>
				</article>
			</c:forEach>
			</c:if>




		</main>
	</div>

</body>

</html>