<!doctype html>
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Parlamentares</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <asset:link rel="shortcut icon" type="image/x-icon" href="../theme/img/favicon.ico"/>
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/bootstrap.min.css"/>
    <!-- font awesome CSS
		============================================ -->
    <asset:stylesheet href="../theme/ccss/font-awesome.min.css"/>
    <!-- owl.carousel CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/owl.carousel.css"/>

    <asset:stylesheet href="../theme/css/owl.theme.css"/>

    <asset:stylesheet href="../theme/css/owl.transitions.css"/>

    <!-- meanmenu CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/meanmenu/meanmenu.min.css"/>

    <!-- animate CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/animate.css"/>
    <!-- normalize CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/normalize.css"/>
    <!-- wave CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/wave/waves.min.css"/>

    <asset:stylesheet href="../theme/css/wave/button.css"/>

    <!-- mCustomScrollbar CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/scrollbar/jquery.mCustomScrollbar.min.css"/>

    <!-- Notika icon CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/notika-custom-icon.css"/>

    <!-- Data Table JS
		============================================ -->
    <asset:stylesheet href="../theme/css/jquery.dataTables.min.css"/>

    <!-- main CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/main.css"/>

    <!-- style CSS
		============================================ -->
    <asset:stylesheet href="../theme/style.css"/>

    <!-- responsive CSS
		============================================ -->
    <asset:stylesheet href="../theme/css/responsive.css"/>

    <!-- modernizr JS
		============================================ -->
    <asset:javascript src="../theme/js/vendor/modernizr-2.8.3.min.js"/>
</head>

<body>
<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
<!-- Start Header Top Area -->
<div class="header-top-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="logo-area">
                    VIBE PARLAMENTARES
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Header Top Area -->

<!-- Breadcomb area Start-->
<br>
<div class="breadcomb-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="breadcomb-list">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <div class="breadcomb-wp">
                                <div class="breadcomb-icon">
                                    <i class="notika-icon notika-windows"></i>
                                </div>
                                <div class="breadcomb-ctn">
                                    <h2>Parlamentares</h2>
                                    <p>Bem vindo ao <span class="bread-ntd">Vibe Parlamentares</span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <g:form action="listar" controller="parlamentar" name="pesquisa">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                                    <input type="text"
                                           name="pesquisa.nome"
                                           id="pesquisa.nome"
                                           class="form-control"
                                           placeholder="Nome"
                                           value="${pesquisa?.nome}"
                                           aria-label="Username"
                                           aria-describedby="basic-addon1">
                                </div>

                                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                                    <input type="text"
                                           id="pesquisa.partido"
                                           name="pesquisa.partido"
                                           class="form-control"
                                           placeholder="Sigla"
                                           value="${pesquisa?.partido}">
                                </div>

                                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                                    <input type="text"
                                           name="pesquisa.uf"
                                           id="pesquisa.uf"
                                           class="form-control"
                                           placeholder="Uf"
                                           value="${pesquisa?.uf}"
                                           aria-label="Username"
                                           aria-describedby="basic-addon1">
                                </div>

                                <button type="submit"
                                        id="bt-pesquisa"
                                        class="btn btn-success"
                                        data-toggle="modal">
                                    Pesquisar
                                </button>
                            </div>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcomb area End-->
<!-- Data Table area Start-->
<div class="data-table-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="data-table-list">
                    <div class="basic-tb-hd">
                        <h2>Parlamentares</h2>
                    </div>
                    <div class="table-responsive">
                        <table id="data-table-basic" class="table table-striped">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Partido</th>
                                <th>UF</th>
                                <th>Operação</th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${parlamentares}" var="p">
                                <tr>
                                    <td>${p.idCadastro}</td>
                                    <td>${p.nome}</td>
                                    <td>${p.partido.sigla}</td>
                                    <td>${p.uf}</td>
                                    <td>
                                        <button type="button"
                                                id="bt1"
                                                class="btn btn-success bt1"
                                                data-toggle="modal"
                                                data-url="<g:createLink controller="parlamentar" action="detalhes" params="[idCadastro: p.idCadastro, idLegislatura: p.idLegislatura]"/>">
                                            Detalhar
                                        </button>
                                    </td>
                                </tr>
                            </g:each>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Partido</th>
                                <th>UF</th>
                                <th>Operação</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="divModal"></div>

<!-- Data Table area End-->
<!-- Start Footer area-->
<div class="footer-copyright-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="footer-copy-right">
                    <p>Copyright © 2018
                    . All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Footer area-->
<!-- jquery
		============================================ -->

<asset:javascript src="../theme/js/vendor/jquery-1.12.4.min.js"/>
<asset:javascript src="vibe/listar.js"/>
<!-- bootstrap JS
		============================================ -->
<asset:javascript src="../theme/js/bootstrap.min.js"/>
<!-- wow JS
		============================================ -->
<asset:javascript src="../theme/js/wow.min.js"/>
<!-- price-slider JS
		============================================ -->
<asset:javascript src="../theme/js/jquery-price-slider.js"/>
<!-- owl.carousel JS
		============================================ -->
<asset:javascript src="../themejs/js/owl.carousel.min.js"/>
<!-- scrollUp JS
		============================================ -->
<asset:javascript src="../theme/js/jquery.scrollUp.min.js"/>
<!-- meanmenu JS
		============================================ -->
<asset:javascript src="../theme/js/meanmenu/jquery.meanmenu.js"/>
<!-- counterup JS
		============================================ -->
<asset:javascript src="../theme/js/counterup/jquery.counterup.min.js"/>
<asset:javascript src="../theme/js/counterup/waypoints.min.js"/>
<asset:javascript src="../theme/js/counterup/counterup-active.js"/>
<!-- mCustomScrollbar JS
		============================================ -->
<asset:javascript src="../theme/s/scrollbar/jquery.mCustomScrollbar.concat.min.js"/>
<!-- sparkline JS
		============================================ -->
<asset:javascript src="../theme/js/sparkline/jquery.sparkline.min.js"/>
<asset:javascript src="../theme/js/sparkline/sparkline-active.js"/>
<!-- flot JS
		============================================ -->
<asset:javascript src="../theme/js/flot/jquery.flot.js"/>
<asset:javascript src="../theme/js/flot/jquery.flot.resize.js"/>
<asset:javascript src="../theme/js/flot/flot-active.js"/>
<!-- knob JS
		============================================ -->
<asset:javascript src="../theme/js/knob/jquery.knob.js"/>
<asset:javascript src="../theme/js/knob/jquery.appear.js"/>
<asset:javascript src="../theme/js/knob/knob-active.js"/>
<!--  Chat JS
		============================================ -->
<asset:javascript src="../theme/js/chat/jquery.chat.js"/>
<!--  todo JS
		============================================ -->
<asset:javascript src="../theme/js/todo/jquery.todo.js"/>
<!--  wave JS
		============================================ -->
<asset:javascript src="../theme/js/wave/waves.min.js"/>
<asset:javascript src="../theme/js/wave/wave-active.js"/>
<!-- plugins JS
		============================================ -->
<asset:javascript src="../theme/js/plugins.js"/>
<!-- Data Table JS
		============================================ -->
<asset:javascript src="../theme/js/data-table/jquery.dataTables.min.js"/>
<asset:javascript src="../theme/js/data-table/data-table-act.js"/>
<!-- main JS
		============================================ -->
<asset:javascript src="../theme/js/main.js"/>
<!-- tawk chat JS
		============================================ -->
<asset:javascript src="../theme/js/tawk-chat.js"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.70/jquery.blockUI.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.70/jquery.blockUI.min.js"></script>


</body>

</html>
