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
    <title>浏览订单详情</title>
    <!--common-->
    <link rel="stylesheet" type="text/css" href="/js/fancybox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
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
        <#include "../left.ftl" />
        <!-- main content start-->
        <div class="main-content" >
            <#include "../mainhead.ftl" />
            <div class="wrapper">
            	<div class="row">
            	    <div class="col-xs-12">
            	        <section class="panel">
            	            <header class="panel-heading">
            	                浏览订单详情
            	            </header>
            	            <div class="panel-body">
            	                <form class="form-inline" action="/order/flowlist/detail" method="POST">
            	                    <div class="form-group">
            	                        <label for="id">订单ID：</label>
            	                        <input type="text" class="form-control" name="id" value="${id}">
            	                    </div>
            	                    <button type="submit" class="btn btn-primary">确认</button>
            	                </form>
            	            </div>
            	        </section>
            	    </div>
            	</div>
            	<#if detail??>
                <div class="row">
                    <div class="col-xs-12">
                          <section class="panel">
                              <header class="panel-heading">基本信息</header>
                              <div class="panel-body">
                                <table class="table table-bordered">
                                    <tr>
                                        <td class="info">买手id</td>
                                        <td class="info">买手账号</td>
                                        <td class="info">任务平台</td>
                                        <td class="info">操作设备</td>
                                        <td class="info">店铺名</td>
                                        <td class="info">商家账号</td>
                                        <td class="info">商家id</td>
                                        <td class="info">任务id</td>
                                        <td class="info">商品id</td>
                                        <td class="info">商品名称</td>
                                    </tr>
                                    <tr>
                                        <td><a href="/user?userid=${detail.userid}" target="_blank">${detail.userid}</a></td>
                                        <td>${detail.account}</td>
                                        <td><#switch detail.plat><#case 1>淘宝<#break><#case 2>天猫<#break><#case 3>京东<#break></#switch></td>
                                        <td><#if detail.device=1>手机<#elseif detail.device=2>电脑</#if></td>
                                        <td>${detail.shopname}</td>
                                        <td>${detail.selleraccount}</td>
                                        <td><a href="/user?userid=${detail.sellerid}" target="_blank">${detail.sellerid}</a></td>
                                        <td><a href="/task/flowlist/detail?id=${detail.tid}" target="_blank">${detail.tid}</a></td>
                                        <td>${detail.gid}</td>
                                        <td>${detail.gname}</td>
                                    </tr>
                                    <tr>
                                        <td class="info">商品主图</td>
                                        <td class="info">搜索展示价格</td>
                                        <td class="info">接手时间</td>
                                        <td class="info">上传截图时间</td>
                                        <td class="info">完成时间</td>
                                        <td class="info">可得佣金</td>
                                        <td class="info">任务截图1</td>
                                        <td class="info">任务截图2</td>
                                        <td class="info">订单类别</td>
                                        <td class="info">过期时间</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <#if detail.gpic!=''>
                                            <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${detail.gpic}">
                                                <img src="${detail.gpic}" width="60" height="60">
                                            </a> 
                                            </#if>
                                        </td>
                                        <td>${detail.search_price}</td>
                                        <td>${detail.gettime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td>${detail.optime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td>${detail.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td>${detail.commission}</td>
                                        <td>
                                            <#if detail.screenshot_1??> 
                                              <#if detail.screenshot_1?index_of(",") = -1> 
                                                <#if detail.screenshot_1!=''>
                                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${detail.screenshot_1}">
                                                  <img src="${detail.screenshot_1}" width="60" height="60">
                                                </a> 
                                                </#if> 
                                              <#else> 
                                                <#list detail.screenshot_1?split(",") as img> 
                                                  <#if img?? && img!=''>
                                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                                    <img src="${img}" width="60" height="60">
                                                  </a> 
                                                  </#if> 
                                                </#list> 
                                                </#if> 
                                            </#if>
                                        </td>
                                        <td>
                                            <#if detail.screenshot_2??> 
                                              <#if detail.screenshot_2?index_of(",") = -1> 
                                                <#if detail.screenshot_2!=''>
                                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${detail.screenshot_2}">
                                                  <img src="${detail.screenshot_2}" width="60" height="60">
                                                </a> 
                                                </#if> 
                                              <#else> 
                                                <#list detail.screenshot_2?split(",") as img> 
                                                  <#if img?? && img!=''>
                                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                                    <img src="${img}" width="60" height="60">
                                                  </a> 
                                                  </#if> 
                                                </#list> 
                                                </#if> 
                                            </#if>
                                        </td>
                                        <td>
                                            <#switch detail.type>
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
                                        <td>
                                            ${detail.expirestime?string('yyyy-MM-dd HH:mm:ss')}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="info">接单IP</td>
                                        <td class="info">设备号</td>
                                        <td class="info">状态</td>
                                        <td class="info">特别任务类型</td>
                                        <td class="info">淘客、淘口令地址或其他</td>
                                        <td class="info">搜索关键词</td>
                                        <td class="info">排序说明</td>
                                        <td class="info">位置说明</td>
                                        <td class="info"></td>
                                        <td class="info"></td>
                                    </tr>
                                    <tr>
                                        <td>${detail.ip}</td>
                                        <td>${detail.imei}</td>
                                        <td><#switch detail.status><#case 0>待操作<#break><#case 1>待确认<#case 2>已完成<#break></#switch></td>
                                        <td>
                                            <#switch detail.special_type>
                                                <#case 0>普通任务<#break>
                                                <#case 5>淘口令<#break>
                                                <#case 6>淘客秒拍<#break>
                                                <#case 7>聚划算<#break>
                                                <#case 8>淘金币<#break>
                                                <#case 9>天天特价<#break>
                                                <#case 10>淘抢购<#break>
                                                <#case 20>其他渠道<#break>
                                            </#switch>
                                        </td>
                                        <td>
                                            ${detail.special_link}
                                        </td>
                                        <td>
                                            ${detail.keyword}
                                        </td>
                                        <td>${detail.sortmsg}</td>
                                        <td>${detail.position}</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    
                                </table>
                            </div>
                        </section>
                    </div>  
                </div>
                </#if>
            </div>
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
    </script>
  </body>
</html>
</#escape>