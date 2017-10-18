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
    <title>浏览任务列表</title>
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
            <li class="list-group-item"><input type="checkbox" value="商品主图错误"> 商品主图错误</li>
            <li class="list-group-item"><input type="checkbox" value="备注内不得出现收藏、加购等词"> 备注内不得出现收藏、加购等词</li>
            <li class="list-group-item"><input type="checkbox" value="商品主图错误：不可以带有商品全称，旺旺号等店铺信息，避免买手直接搜索"> 商品主图错误：不可以带有商品全称，旺旺号等店铺信息，避免买手直接搜索</li>
            <li class="list-group-item"><input type="checkbox" value="商品链接错误"> 商品链接错误</li>
            <li class="list-group-item"><input type="checkbox" value="选错店铺"> 选错店铺</li>
            <li class="list-group-item"><input type="checkbox" value="备注不符合要求：要求收藏请发收藏任务"> 备注不符合要求：要求收藏请发收藏任务</li>
            <li class="list-group-item"><input type="checkbox" value="平台不支持虚拟商品任务"> 平台不支持虚拟商品任务</li>
            <li class="list-group-item"><input type="checkbox" value="根据你设置的搜索关键词和筛选条件，宝贝的排名太靠后，买手找不到宝贝的话后续会非常麻烦；建议使用以下方法修改任务，1 使用更精准的关键词 2 设置范围较小的价格区间  3 设置商品发货地 缩小商品范围后，重新提交审核，谢谢"> 根据你设置的搜索关键词和筛选条件，宝贝的排名太靠后，买手找不到宝贝的话后续会非常麻烦；建议使用以下方法修改任务，1 使用更精准的关键词 2 设置范围较小的价格区间  3 设置商品发货地 缩小商品范围后，重新提交审核，谢谢</li>
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
                  浏览任务列表
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/task/flowlist" method="GET">
                    <div class="form-group">
                        <label for="id">任务ID：</label>
                        <input type="text" class="form-control" name="id" value="${id}">
                    </div>
                    <div class="form-group">
                      <label for="userid">用户ID：</label>
                      <input type="text" class="form-control" name="userid" value="${userid}">
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
                      <label for="progress">任务进度：</label>
                      <select name="progress" class="form-control">
                        <option value="-1" <#if progress?? && progress=-1>selected</#if>>全部</option>
                        <option value="0" <#if progress?? && progress=0>selected</#if>>未接单</option>
                        <option value="1" <#if progress?? && progress=1>selected</#if>>待操作</option>
                        <option value="2" <#if progress?? && progress=2>selected</#if>>待确认</option>
                        <option value="3" <#if progress?? && progress=3>selected</#if>>已完成</option>
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
                          <th>任务ID</th>
                          <th>用户ID</th>
                          <th>平台</th>
                          <th>操作设备</th>
                          <th>店铺名称</th>
                          <th>店铺ID</th>
                          <th>商品名称</th>
                          <th>商品图片</th>
                          <th>订单总数</th>
                          <th>未接单数</th>
                          <th>已接单数</th>
                          <th>待操作数</th>
                          <th>待确认数</th>
                          <th>已完成数</th>
                          <th>已撤销数</th>
                          <th>任务状态</th>
                          <th>审核时间</th>
                          <th>审核管理员</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td><a href="/task/flowlist/detail?id=${item.id}" target="_blank">${item.id}</a></td>
                          <td><a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a></td>
                          <td><#switch item.plat><#case 1>淘宝<#break><#case 2>天猫<#break><#case 3>京东<#break></#switch></td>
                          <td><#if item.device=1>手机<#else>电脑</#if></td>
                          <td>${item.shopname}</td>
                          <td>${item.account}</td>
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
                          <td>${item.all_count}</td>
                          <td>${item.all_count - item.get_count}</td>
                          <td>${item.get_count}</td>
                          <td>${item.waitdo_count}</td>
                          <td>${item.waitsure_count}</td>
                          <td>${item.end_count}</td>
                          <td>${item.cancel_count}</td>
                          <td><#switch item.status><#case 1>已审核<#break><#case 2>已完成<#break><#case 3>不通过<#break><#case 4>被冻结<#break></#switch></td>
                          <td>${item.audittime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.auditadmin}</td>
                          <td>
                            <#if item.status=3>
                            不通过原因：${item.nopassreason}
                            </#if>
                            <#if item.status=4>
                            冻结原因：${item.freezereason} <br>
                            冻结时间：${item.freezetime?string('yyyy-MM-dd HH:mm:ss')} <br>
                            冻结操作者：${item.freezeadmin}
                            </#if>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/task/flowlist?<#if id??>id=${id}&</#if><#if userid??>userid=${userid}&</#if><#if plat??>plat=${plat}&</#if><#if progress??>progress=${progress}</#if>");
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
    </script>
  </body>
</html>
</#escape>