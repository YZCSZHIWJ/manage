<#escape x as (x)!"">
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title>添加新功能</title>
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
        <!-- page heading start-->
        <div class="page-heading">
          <h3>
            添加新功能
          </h3>
        </div>
        <!-- page heading end-->
        <!--body wrapper start-->
        <section class="wrapper">
        <!-- page start-->
          <div class="row">
            <div class="col-lg-10 center">
              <section class="panel">
                <header class="panel-heading">
                  功能信息
                </header>
                <div class="panel-body">
                  <form id="form">
                    <div class="form-group">
                      <label for="f_name">功能名</label>
                      <input type="text" class="form-control" id="f_name" name="f_name" placeholder="功能名">
                    </div>
                    <div class="form-group">
                      <label for="f_uri">地址</label>
                      <input type="text" class="form-control" id="f_uri" name="f_uri" placeholder="地址">
                    </div>
                    <div class="form-group">
                      <label for="g_id">所属群组</label>
                      <select name="g_id" id="g_id" class="form-control">
                        <#if grouplist??>
                        <#list grouplist as group>
                        <option value="${group.g_id}">${group.g_name}</option>
                        </#list>
                        </#if> 
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="f_remark">描述</label>
                      <textarea name="f_remark" id="f_remark" cols="30" rows="10" class="form-control"></textarea>
                    </div>
                    <button class="btn btn-primary" id="sure">提交</button>
                  </form>
                </div>
              </section>
            </div>
          </div>
        <!-- page end-->
        </section>
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
          $('#sure').on('click', function(e){
              e.preventDefault();
              var param = $('#form').serialize();
              $.ajax({
                url: '/function/add',
                type: 'POST',
                data: param,
                dataType: 'json',
                error: function(xhr, errortext, errorstatus) {
                  alert(errortext);
                },
                success: function(data, status) {
                  if (data.status == 0) {
                    location = "/function";
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