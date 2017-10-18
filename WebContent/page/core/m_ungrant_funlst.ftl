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
    <title>管理员未授予功能</title>
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
        <!-- header section start-->
        <#include "mainhead.ftl" />
        <!-- header section end-->
        <!--body wrapper start-->
        <div class="wrapper">
          <div class="row">
            <div class="col-sm-12">
              <section class="panel">
                <header class="panel-heading" style="text-transform: inherit;">
                  管理员 &lt;${user.m_name}&gt; 未授予功能列表
                  <span class="pull-right">
                    <a href="javascript: void(0);" class="fa fa-mail-reply go-back" title="返回"></a>
                  </span>
                </header>
                <div class="panel-body">
                  <section>
                    <table class="table table-bordered table-striped table-condensed funclist">
                      <thead>
                        <tr>
                          <th>FID</th>
                          <th>功能名称</th>
                          <th>功能描述</th>
                          <th>地址</th>
                          <th>功能创建时间</th>
                          <th>功能创建者</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (list?? && list?size>0)>
                        <#list list as item>
                        <tr>
                          <td>${item.f_id}</td>
                          <td>${item.f_name}</td>
                          <td>${item.f_remark}</td>
                          <td>${item.f_uri}</td>
                          <td>${item.f_ctime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.f_cuser}</td>
                          <td>
                            <a class="grant" href="javascript: void(0)" data-mid="${user.m_id}" data-fid="${item.f_id}">权限授予</a>
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
  <script src="js/jquery-1.10.2.min.js"></script>
  <script src="js/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/modernizr.min.js"></script>
  <script src="js/jquery.nicescroll.js"></script>
  <!--common scripts for all pages-->
  <script src="js/scripts.js"></script>
  <script type="text/javascript">
    !function(){
      $('.funclist').delegate('.grant', 'click', function(e){
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