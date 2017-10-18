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
    <title>未授权用户</title>
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
        <!--body wrapper start-->
        <div class="wrapper">
          <div class="row">
            <div class="col-sm-12">
              <section class="panel">
                <header class="panel-heading">
                  授予管理员 &lt;${fn.f_name}&gt; 功能
                  <span class="pull-right">
                    <a href="javascript: void(0);" class="fa fa-mail-reply go-back" title="返回"></a>
                  </span>
                </header>
                <div class="panel-body">
                  <section>
                    <table class="table table-bordered table-striped table-condensed ungrantedes">
                      <thead>
                        <tr>
                          <th>MID</th>
                          <th>用户名</th>
                          <th>添加时间</th>
                          <th>添加者</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (list?? && list?size>0)>
                        <#list list as item>
                        <tr>
                          <td>${item.m_id}</td>
                          <td>${item.m_name}</td>
                          <td>${item.m_ctime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.m_cadmin}</td>
                          <td>
                            <a href="javascript: void(0)" class="grant" data-fid="${fn.f_id}" data-mid="${item.m_id}">给予</a>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                  </section>
                </div>
              </section>
            </div>
          </div>
        </div>
        <!--body wrapper end-->
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
    <script type="text/javascript">
      !function(){
        $('.ungrantedes').delegate('.grant', 'click', function(e){
          var fid = $(this).data('fid');
          var mid = $(this).data('mid');
          $.ajax({
              url: '/function/grant',
              type: 'POST',
              data: {mid:mid, fid:fid},
              dataType: 'json',
              error: function(xhr, errortext, errorstatus) {
                alert(errortext);
              },
              success: function(data, status) {
                if (data.status == 0) {
                  location.reload();
                } else {
                  alert(data.msg);
                }
              }
            });
        });
      }();
    </script>
  </body>
</html>
</#escape>