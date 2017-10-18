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
    <title>浏览订单查询</title>
    <!--common-->
    <link rel="stylesheet" type="text/css" href="/js/fancybox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
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
                  浏览订单查询
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/order/flowlist" method="GET">
                    <div class="form-group">
                        <label for="id">订单ID：</label>
                        <input type="text" class="form-control" name="id" value="${id}">　
                    </div>
                    <div class="form-group">
                        <label for="tid">任务ID：</label>
                        <input type="text" class="form-control" name="tid" value="${tid}">　
                    </div>
                    <div class="form-group">
                      <label for="userid">买手ID：</label>
                      <input type="text" class="form-control" name="userid" value="${userid}">　
                    </div>
                    <div class="form-group">
                      <label for="sellerid">商家ID：</label>
                      <input type="text" class="form-control" name="sellerid" value="${sellerid}">　
                    </div>
                    <div class="form-group">
                      <label for="account">买手买号：</label>
                      <input type="text" class="form-control" name="account" value="${account}">　
                    </div>
                    <div class="form-group">
                      <label for="plat">平台：</label>
                      <select name="plat" class="form-control">
                        <option value="-1" <#if plat?? && plat=-1>selected</#if>>全部</option>
                        <option value="1" <#if plat?? && plat=1>selected</#if>>淘宝</option>
                        <option value="2" <#if plat?? && plat=2>selected</#if>>天猫</option>
                        <option value="3" <#if plat?? && plat=3>selected</#if>>京东</option>
                      </select>　
                    </div>
                    <div class="form-group">
                      <label for="device">操作设备：</label>
                      <select name="device" class="form-control">
                        <option value="-1" <#if device?? && device=-1>selected</#if>>全部</option>
                        <option value="1" <#if device?? && device=1>selected</#if>>手机</option>
                        <option value="2" <#if device?? && device=2>selected</#if>>电脑</option>
                      </select>　
                    </div>
                    <div class="form-group">
                      <label for="status">状态：</label>
                      <select name="status" class="form-control">
                        <option value="-1" <#if status?? && status=-1>selected</#if>>全部</option>
                        <option value="0" <#if status?? && status=0>selected</#if>>待操作</option>
                        <option value="1" <#if status?? && status=1>selected</#if>>待确认</option>
                        <option value="2" <#if status?? && status=2>selected</#if>>已完成</option>
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
                    <table class="table table-bordered table-striped table-condensed orderlist">
                      <thead>
                        <tr>
                          <th>订单ID</th>
                          <th>任务ID</th>
                          <th>买手ID</th>
                          <th>商家ID</th>
                          <th>买号</th>
                          <th>平台/设备</th>
                          <th>店铺名称</th>
                          <th>商品名称</th>
                          <th>商品主图</th>
                          <th>接手时间</th>
                          <th>可得佣金</th>
                          <th>类别</th>
                          <th>接单IP</th>
                          <th>设备号</th>
                          <th>状态</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td><a href="/order/flowlist/detail?id=${item.id}" target="_blank">${item.id}</a></td>
                          <td><a href="/task/flowlist/detail?id=${item.tid}" target="_blank">${item.tid}</a></td>
                          <td><a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a></td>
                          <td><a href="/user?userid=${item.sellerid}" target="_blank">${item.sellerid}</a></td>
                          <td>${item.account}</td>
                          <td><#switch item.plat><#case 1>淘宝<#break><#case 2>天猫<#break><#case 3>京东<#break></#switch><#if item.device=1>手机<#else>电脑</#if></td>
                          <td>${item.shopname}</td>
                          <td>${item.gname}</td>
                          <td>
                            <#if item.gpic??> 
                              <#if item.gpic?index_of(",") = -1> 
                                <#if item.gpic!=''>
                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${item.gpic}">
                                  <img src="${item.gpic}" width="60" height="60">
                                </a> 
                                </#if> 
                              <#else> 
                                <#list item.gpic?split(",") as img> 
                                  <#if img?? && img!=''>
                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                    <img src="${img}" width="60" height="60">
                                  </a> 
                                  </#if> 
                                </#list> 
                                </#if> 
                            </#if>
                          </td>
                          <td>${item.gettime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.commission}</td>
                          <td>
                            <#switch item.type>
                              <#case 0>普通浏览<#break>
                              <#case 1>收藏加购<#break>
                              <#case 5>淘口令<#break>
                              <#case 6>淘客秒拍<#break>
                              <#case 7>聚划算<#break>
                              <#case 8>淘金币<#break>
                              <#case 9>天天特价<#break>
                              <#case 10>淘抢购<#break>
                              <#case 20>其他渠道<#break>
                            </#switch>
                          </td>
                          <td>${item.ip}</td>
                          <td>${item.imei}</td>
                          <td><#switch item.status><#case 0>待操作<#break><#case 1>待确认<#break><#case 2>完成<#break></#switch></td>
                          <td>
                            <button class="btn btn-primary cancel-order" data-id="${item.id}" data-userid="${item.userid}">撤销订单</button> <br><br>
                            <button class="btn btn-primary cancel-order-task" data-id="${detail.id}" data-userid="${detail.userid}">撤销订单与任务</button>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/order/flowlist?<#if id??>id=${id}&</#if><#if tid??>tid=${tid}&</#if><#if userid??>userid=${userid}&</#if><#if sellerid??>sellerid=${sellerid}&</#if><#if plat??>plat=${plat}&</#if><#if device??>device=${device}&</#if><#if status??>status=${status}&</#if><#if account??>account=${account}&</#if>");
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
      !function(){
        $('.orderlist').delegate('.cancel-order', 'click', function(e){
          var id = $(this).data('id');
          var userid = $(this).data('userid');
          if (confirm('确认撤销')) {
            $.ajax({
              url:'/order/cancelflow',
              type:'POST',
              data:{id:id, userid:userid},
              dataType:'json',
              error: function(xhr, errortext, errorthrow) {
                $.prompt(errortext);
              },
              success: function(data, status) {
                if (data.status == 0) {
                  location.reload();
                } else {
                  $.prompt(data.msg);
                }
              }
            });
          }
        });
      }();
    </script>
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
    </script>
  </body>
</html>
</#escape>