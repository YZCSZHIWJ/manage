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
    <title>浏览任务审核</title>
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
                  浏览任务审核
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/selleraudit/flowtasklst" method="GET">
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
                      <label for="status">状态：</label>
                      <select name="status" class="form-control" id="status">
                        <option value="0" <#if status?? && status=0>selected</#if>>待审核</option>
                        <option value="1" <#if status?? && status=1>selected</#if>>通过</option>
                        <option value="3" <#if status?? && status=3>selected</#if>>不通过</option>
                        <option value="4" <#if status?? && status=4>selected</#if>>已冻结</option>
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
                          <th>任务信息</th>
                          <th>商品信息</th>
                          <th>筛选信息</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td>
                            任务id：<a href="/task/flowdetail?id=${item.id}" target="_blank">${item.id}</a> <br><br>
                            商家id：<a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a> <br><br>
                            任务类型：<#if item.plat=1>淘宝<#elseif item.plat=2>天猫<#elseif item.plat=3>京东</#if> <#if item.device=1>手机<#else>电脑</#if> <#if item.isfavtask=0>普通浏览<#else>收藏加购浏览</#if> <br><br>
                            总单数：${item.all_count} <br><br>
                            备注：${item.remark} <br><br>
                            备注图片：
                            <#if item.remark_img??> 
                              <#if item.remark_img?index_of(",") = -1> 
                                <#if item.remark_img!=''>
                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${item.remark_img}">
                                  <img src="${item.remark_img}" width="60" height="60">
                                </a> 
                                </#if> 
                              <#else> 
                                <#list item.remark_img?split(",") as img> 
                                  <#if img?? && img!=''>
                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                    <img src="${img}" width="60" height="60">
                                  </a> 
                                  </#if> 
                                </#list> 
                                </#if> 
                            </#if> <br><br>
                            <#if item.issetime = 1>
                            定时设置：起始日期${item.ts_startdate?string('yyyy-MM-dd')}，每日${item.ts_starttime?string('HH:mm')} - ${item.ts_endtime?string('HH:mm')}，
                            每隔${item.interval_minute}分钟，放出${item.interval_num}单 <br><br>
                            </#if>
                            <#if item.is_add = 1>
                            <#if item.is_limit_province = 1>限制不能接地区：${item.limit_province}  <br><br></#if>
                            <#if item.is_limit_tblevel = 1> 仅限钻石买号  <br><br></#if>
                            <#if item.is_limit_sex=1> 仅男性可接 <br><br> <#elseif item.is_limit_sex=2> 仅女性可接 <br><br> </#if>
                            <#if item.is_limit_age!=0>年龄<#switch item.is_limit_age><#case 1>18~25岁<#break><#case 2>26~35岁<#break><#case 3>35岁以上<#break></#switch> <br><br></#if>
                            <#if item.is_limit_hb=1>仅限花呗用户可接</#if>
                            </#if>
                          </td>
                          <td>
                            <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${item.gpic}">
                              <img src="${item.gpic}" width="200" height="200">
                            </a> <br>
                            店铺名：${item.shopname} <br><br>
                            店铺ID：${item.account} <br><br>
                            商品名称：${item.gname} <br><br>
                            商品售价：${item.price} <br><br>
                            搜索价格：${item.search_price} <br><br>
                          </td>
                          <td>
                            价格区间：${item.minprice} - ${item.maxprice} <br><br>
                            所在地：${item.city} <br><br>
                            发布时间：${item.itime?string('yyyy-MM-dd HH:mm:ss')} <br><br>
                            支付时间：${item.paytime?string('yyyy-MM-dd HH:mm:ss')} <br><br>
                          </td>
                          <td>
                            <#if item.status=0> 
                            <button class="btn btn-danger refuse" data-id="${item.id}" data-userid="${item.userid}">拒绝</button>
                            <br>
                            <br>
                            <button class="btn btn-success pass" data-id="${item.id}" data-userid="${item.userid}">通过</button>
                            <#elseif item.status=1>
                              ${item.auditadmin}<br>
                              ${item.audittime?string('yyyy-MM-dd HH:mm:ss')}
                            <#elseif item.status=3>
                              ${item.nopassreason} <br>
                              ${item.auditadmin}<br>
                              ${item.audittime?string('yyyy-MM-dd HH:mm:ss')}
                            </#if>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/selleraudit/flowtasklst?<#if userid??>userid=${userid}&</#if><#if id??>id=${id}&</#if><#if plat??>plat=${plat}&</#if><#if status??>status=${status}</#if>");
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
              url: '/selleraudit/auditflowtask',
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
            url: '/selleraudit/auditflowtask',
            type: 'POST',
            data: {id:id, userid:userid, status:3, reason:reason},
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