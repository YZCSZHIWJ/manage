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
    <title>店铺绑定审核</title>
    <!--common-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/js/fancybox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
    <script type="text/javascript" src="/js/pager.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="sticky-header">
    <div class="ui-dialog" id="refuse-reason-dialog">
      <div class="panel panel-primary">
        <div class="panel-heading">拒绝原因选择
          <span class="tools pull-right">
            <a href="javascript: void(0);" class="fa fa-times"></a>
          </span>
        </div>
        <div class="panel-body">
          <p>原因选择：</p>
          <ul class="list-group reason-list">
            <li class="list-group-item"><input type="checkbox" value="店铺未满3星"> 店铺未满3星</li>
            <li class="list-group-item"><input type="checkbox" value="店铺名称或旺旺名称错误，请修改后重新提交"> 店铺名称或旺旺名称错误，请修改后重新提交</li>
            <li class="list-group-item"><input type="checkbox" value="平台不支持虚拟店铺"> 平台不支持虚拟店铺</li>
            <li class="list-group-item"><input type="checkbox" value="店铺链接错误"> 店铺链接错误</li>
            <li class="list-group-item"><input type="checkbox" value="同个id下未绑定钻号店铺，不可以绑定2星以下店铺"> 同个id下未绑定钻号店铺，不可以绑定2星以下店铺</li>
          </ul>
          <textarea name="reason" class="form-control reason" cols="60" rows="5"></textarea>
          <br>
          <div class="opt">
            <button class="btn btn-primary pull-right sure">确定</button>
          </div>
        </div>
      </div>
    </div>
    <section>
    <#include "../left.ftl" />
    <!-- main content start-->
    <div class="main-content" >
        <#include "../mainhead.ftl" />
        <!--body wrapper start-->
        <div class="wrapper">
          <div class="row">
            <div class="col-xs-12">
              <section class="panel">
                <header class="panel-heading">
                  店铺绑定审核
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/selleraudit/shoplist" method="GET">
                    <div class="form-group">
                      <label for="userid">用户ID：</label>
                      <input type="text" class="form-control" name="userid" id="userid" value="${userid}">
                    </div>
                    <div class="form-group">
                        <label for="shopname">店铺名：</label>
                        <input type="text" class="form-control" name="shopname" id="cname" value="${shopname}">
                    </div>
                    <div class="form-group">
                      <label for="plat">平台：</label>
                      <select name="plat" class="form-control">
                        <option value="-1" <#if plat?? && plat='-1'>selected</#if>>全部</option>
                        <option value="1" <#if plat?? && plat='1'>selected</#if>>淘宝</option>
                        <option value="2" <#if plat?? && plat='2'>selected</#if>>天猫</option>
                        <option value="3" <#if plat?? && plat='3'>selected</#if>>京东</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="status">状态：</label>
                      <select name="status" class="form-control" id="status">
                        <option value="0" <#if status?? && status='0'>selected</#if>>待审核</option>
                        <option value="1" <#if status?? && status='1'>selected</#if>>通过</option>
                        <option value="2" <#if status?? && status='2'>selected</#if>>不通过</option>
                        <option value="2" <#if status?? && status='3'>selected</#if>>已冻结</option>
                      </select>
                    </div>
                    <button type="submit" class="btn btn-primary">确认</button>
                  </form>
                </div>
              </section>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-12">
              <section class="panel">
                <div class="panel-body">
                  <section>
                    <table class="table table-bordered table-striped table-condensed bindlist">
                      <thead>
                        <tr>
                          <th>用户ID</th>
                          <th>绑定时间</th>
                          <th>店铺名称</th>
                          <th>店铺ID</th>
                          <th>店铺首页网址</th>
                          <th>店铺截图</th>
                          <th>平台</th>
                          <th>发货地</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td><a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a></td>
                          <td>${item.bdtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.shopname}</td>
                          <td>${item.account}</td>
                          <td>
                            <#assign len=item.shopurl?length>
                            <#if (len>20)>
                              <a href="${item.shopurl}" target="_blank">${item.shopurl?substring(0,20)}</a>
                            <#else> 
                              <a href="${item.shopurl}" target="_blank">${item.shopurl}</a>
                            </#if>
                          </td>
                          <td>
                            <#if item.shopimges??> 
                              <#if item.shopimges?index_of(",") = -1> 
                                <#if item.shopimges!=''>
                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${item.shopimges}">
                                  <img src="${item.shopimges}" width="64" height="64">
                                </a> 
                                </#if> 
                              <#else> 
                                <#list item.shopimges?split(",") as img> 
                                  <#if img?? && img!=''>
                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                    <img src="${img}" width="64" height="64">
                                  </a> 
                                  </#if> 
                                </#list> 
                                </#if> 
                            </#if> 
                          </td>
                          <td><#if item.plat=1>淘宝<#elseif item.plat=2>天猫<#elseif item.plat=3>京东</#if></td>
                          <td>${item.province} ${item.city} ${item.county} ${item.address}</td>
                          <td>
                            <#if item.status=0> 
                            <button class="btn btn-danger refuse" data-id="${item.id}" data-userid="${item.userid}">拒绝</button>
                            <br>
                            <br>
                            <button class="btn btn-success pass" data-id="${item.id}" data-userid="${item.userid}">通过</button>
                            <#elseif item.status=1>
                              ${item.audit_admin}<br>
                              ${item.audit_time?string('yyyy-MM-dd HH:mm:ss')}
                            <#elseif item.status=2>
                              ${item.reason} <br>
                              ${item.audit_admin}<br>
                              ${item.audit_time?string('yyyy-MM-dd HH:mm:ss')}
                            </#if>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/selleraudit/shoplist?<#if userid??>userid=${userid}&</#if><#if shopname??>shopname=${shopname}&</#if><#if plat??>plat=${plat}&</#if><#if status??>status=${status}</#if>");
                      document.write(pageStr);
                    </script>
                    </#if>
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
    <script type="text/javascript" src="/js/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
    <!-- Add fancyBox main JS and CSS files -->
    <script type="text/javascript" src="/js/fancybox/source/jquery.fancybox.js?v=2.1.5"></script>  
    <script type="text/javascript" src="/js/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
    <!--common scripts for all pages-->
    <script src="/js/scripts.js"></script>
    <script type="text/javascript">
      $(".fancybox-effects-d").fancybox({
        padding: 0,
        openEffect : 'elastic',
        openSpeed  : 150,
        closeEffect : 'elastic',
        closeSpeed  : 150,
        closeClick : true,
        helpers : {
          overlay : null
        }
      });

      !function(){

        $('.bindlist').delegate('.pass', 'click', function(e){
          var userid = $(this).data('userid');
          var id = $(this).data('id');
          if (confirm('确定通过')) {
            $.showMask();
            $.ajax({
              url: '/selleraudit/auditshop',
              type: 'POST',
              data: {id:id, userid:userid, status:1},
              dataType: 'json',
              error: function(xhr, errortext, errorstatus) {
                $.hideMask();
                alert(errortext);
              },
              success: function(data, status) {
                if (data.status == 0) {
                  location.reload();
                } else {
                  $.hideMask();
                  alert(data.msg);
                }
              }
            });
          }
        });

        var $dialog = $('#refuse-reason-dialog');

        $('.bindlist').delegate('.refuse', 'click', function(e){
          var userid = $(this).data('userid');
          var id = $(this).data('id');
          $dialog.data('userid', userid);
          $dialog.data('id', id);
          $.showMask();
          $dialog.trigger('open');
        });

        $dialog.find('.sure').on('click', function(){
          var id = $dialog.data('id');
          var userid = $dialog.data('userid');
          var reason = $dialog.find('.reason').val();
          if (!reason) {
            $.prompt('请选择或输入拒绝原因');
            return false;
          }
          $dialog.hide();
          $.showBuffer();
          $.ajax({
            url: '/selleraudit/auditshop',
            type: 'POST',
            data: {id:id, userid:userid, status:2, reason:reason},
            dataType: 'json',
            error: function(xhr, errortext, errorstatus) {
              alert(errortext);
              $.hideBuffer();
              $.hideMask();
            },
            success: function(data, status) {
              if (data.status == 0) {
                location.reload();
              } else {
                $.hideBuffer();
                $.prompt(data.msg);
                $.hideMask();
              }
            }
          });
        });
      }();
    </script>
  </body>
</html>
</#escape>