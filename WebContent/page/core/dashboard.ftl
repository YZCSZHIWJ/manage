<#escape x as (x)!"">
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title>首页</title>
    <!--common-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="sticky-header">
    <section>
        <#include "left.ftl" />
        <!-- main content start-->
        <div class="main-content" >
            <#include "mainhead.ftl" />
        </div>
        <!-- main content end-->
    </section>
    <!-- Placed js at the end of the document so the pages load faster -->
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/modernizr.min.js"></script>
    <script src="/js/jquery.nicescroll.js"></script>
    <!--common scripts for all pages-->
    <script src="/js/scripts.js"></script>
  </body>
</html>
</#escape>