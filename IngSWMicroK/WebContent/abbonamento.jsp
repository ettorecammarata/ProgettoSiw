<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>MicroK - Pricing</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/pricing/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Custom styles for this template -->
    <link href="css/abbonamento.css" rel="stylesheet">
  </head>
  <body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
  <h5 class="my-0 mr-md-auto font-weight-normal">MicroK Music Store</h5>
  <a class="btn btn-outline-primary" href="index.html">Torna indietro </a>
</div>
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">Scegli il tuo Piano </h1>
  <p class="lead">Scegli uno dei seguenti piani e inizia ad ascoltare tutta la tua musica </p>
</div>
<div class="container">
  <div class="card-deck mb-3 text-center">
	 <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Abbonamento Mensile </h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">3 euro <small class="text-muted"></small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>Accesso allo Store per 30 giorni</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href='Home.jsp'">Seleziona</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Abbonamento Trimestrale</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">5 euro <small class="text-muted"></small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>Accesso allo Store per 90 giorni</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href='Home.jsp'">Seleziona</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Abbonamento Semestrale</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">8 euro <small class="text-muted"></small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>Accesso allo Store per 180 giorni</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href='Home.jsp'">Seleziona</button>
      </div>
    </div>
  </div>
</div>


</body>
</html>