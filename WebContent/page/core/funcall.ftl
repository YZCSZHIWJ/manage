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
    <title>所有功能</title>
    <!--common-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="/js/pager.js"></script>
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
                  功能列表
                </header>
                <div class="panel-body">
                  <section>
                    <table class="table table-bordered table-striped table-condensed functiones">
                      <thead>
                        <tr>
                          <th>FID</th>
                          <th>功能名称</th>
                          <th>分组</th>
                          <th>功能说明</th>
                          <th>创建时间</th>
                          <th>创建者</th>
                          <th>操作  <a href="/function?add">添加新功能</a></th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as fn>
                        <tr>
                          <td>${fn.f_id}</td>
                          <td>${fn.f_name}</td>
                          <td>${fn.g_name}</td>
                          <td>${fn.f_remark}</td>
                          <td>${fn.f_ctime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${fn.f_cuser}</td>
                          <td>
                            <a class="update" href="/function?revise&f_id=${fn.f_id}">修改</a> | 
                            <a class="delete" href="javascript: void(0)" data-id="${fn.f_id}">删除</a> | 
                            <a href="/function?ungrantedlist&f_id=${fn.f_id}">授权用户</a> | 
                            <a href="/function?grantedlist&f_id=${fn.f_id}">权限回收</a>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber},${page.pageSize},${page.pageIndex}, ${page.total},'goPager',5,"/function" );
                      document.write(pageStr);
                    </script>
                  </section>
                </div>
              </section>
              <section class="panel">
                <header class="panel-heading">
                  分组列表
                </header>
                <div class="panel-body">
                  <section>
                    <table class="table table-bordered table-striped table-condensed groupes">
                      <thead>
                        <tr>
                          <th>GID</th>
                          <th>分组名称</th>
                          <th>分组说明</th>
                          <th>创建时间</th>
                          <th>创建者</th>
                          <th>操作  <a href="/function?addgroup">添加新分组</a></th>
                        </tr>
                      </thead>
                      <tbody>
                        <#if (funcgrouplist?? && funcgrouplist?size>0)>
                        <#list funcgrouplist as funcgroup>
                        <tr>
                          <td>${funcgroup.g_id}</td>
                          <td><i class="fa ${funcgroup.g_tag}"></i> ${funcgroup.g_name}</td>
                          <td>${funcgroup.g_remark}</td>
                          <td>${funcgroup.g_ctime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${funcgroup.g_cuser}</td>
                          <td>
                            <a href="/function?revisegroup&g_id=${funcgroup.g_id}">修改</a> | 
                            <a class="delete" href="javascript: void(0)" data-id="${funcgroup.g_id}">删除</a>
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
    </#if>
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
        $('.functiones').delegate('.delete', 'click', function(e){
          var id = $(this).data('id');
          if (confirm('确定删除功能')) {
            $.ajax({
              url: '/function/del',
              type: 'POST',
              data: {id:id},
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
          }
        });
        $('.groupes').delegate('.delete', 'click', function(e){
          var id = $(this).data('id');
          if (confirm('确认删除分组')) {
            $.ajax({
              url: '/function/delgroup',
              type: 'POST',
              data: {id:id},
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
          }
        });
      }();
    </script>
  </body>
</html>
</#escape>