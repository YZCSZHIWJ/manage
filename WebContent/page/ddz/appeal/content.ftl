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
    <title>申诉详情</title>
    <!--common-->
    <link rel="stylesheet" href="/js/fancybox/source/jquery.fancybox.css?v=2.1.5" media="screen" type="text/css"/>
    <link rel="stylesheet" href="/css/style.css" >
    <link rel="stylesheet" href="/css/style-responsive.css">
    <link rel="stylesheet" href="/js/bootstrap-datepicker/css/datepicker-custom.css" type="text/css" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        .a-ct{padding-bottom: 8px;border-bottom: 1px solid #ccc;margin-bottom: 6px;}
    </style>
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
                                申诉详情
                            </header>
                            <div class="panel-body">
                                <div>
                                    <a href="/user?userid=${appealmain.userid}" target="_blank">${appealmain.userid}</a> 发起的申诉，平台<#if appealmain.plat_join_status=0>未<#else>已</#if>介入，订单编号：<a href="<#if appealmain.isflow=1>/order/flowlist/detail?id=${appealmain.orderid}</#if>" target="_blank">${appealmain.orderid}</a>，任务编号：<a href="<#if appealmain.isflow=1>/task/flowlist/detail?id=${appealmain.tid}</#if>" target="_blank">${appealmain.tid}</a>
                                    <br>
                                    <br>
                                    申诉原因：${appealmain.appeal_reason} <br>
                                    <#if appealmain.appeal_imges??> 
                                      <#if appealmain.appeal_imges?index_of(",") = -1> 
                                        <#if appealmain.appeal_imges!=''>
                                        <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${appealmain.appeal_imges}">
                                          <img src="${appealmain.appeal_imges}" width="200" height="200">
                                        </a> 
                                        </#if> 
                                      <#else> 
                                        <#list appealmain.appeal_imges?split(",") as img> 
                                          <#if img?? && img!=''>
                                          <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                            <img src="${img}" width="200" height="200">
                                          </a> 
                                          </#if> 
                                        </#list> 
                                        </#if> 
                                    </#if>
                                    <br>
                                    <br>
                                    发起时间：${appealmain.itime?string('yyyy-MM-dd HH:mm:ss')} <#if appealmain.plat_join_status=1>　申请介入时间：${appealmain.apply_join_time?string('yyyy-MM-dd HH:mm:ss')}</#if>
                                    <br>
                                </div>
                                <h3>申诉对话</h3>
                                <ul>
                                    <#if dialoglist??>
                                    <#list dialoglist as item>
                                    <li class="a-ct">
                                        <p>${item.itime}</p>
                                        <div>
                                            <#if item.role=1>申诉人(<a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a>)：
                                            <#elseif item.role=2>被申诉人(<a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a>)：
                                            <#else>${item.admin}：</#if>
                                            ${item.content}
                                        </div>
                                    </li>
                                    </#list>
                                    </#if>
                                </ul>
                                <div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <textarea class="form-control " id="backct" cols="30" rows="6" placeholder="输入回复内容..."></textarea>
                                    </div>
                                    <div class="form-group pull-right ">
                                        
                                        <button class="btn btn-primary " id="echo">回复</button>
                                        <#if (appealmain.status<2)>
                                        　　<button class="btn btn-primary" id="overappeal">完结</button>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </section>
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
    <script type="text/javascript" src="/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datepicker/js/bootstrap-datepicker.zh-CN.js"></script>
    <script src="/js/scripts.js"></script>
    <script type="text/javascript">
        !function(){
            var orderid = ${appealmain.orderid}, isflow = ${appealmain.isflow};
            $('#echo').on('click', function(e){
                var content = $('#backct').val();
                if (!content) {
                    $.prompt('内容不可为空');
                    $('#backct').focus();
                    return false;
                }
                $.showMask();
                $.ajax({
                    url: '/appeal/echo',
                    type: 'POST',
                    data: {orderid:orderid, isflow:isflow, content:content},
                    dataType: 'json',
                    error: function(xhr, errortext, errorstatus) {
                        $.prompt(errortext);
                        $.hideMask();
                    },
                    success: function(data, status) {
                        if (data.status == 0) {
                            location.reload();
                        } else {
                            $.prompt(data.msg);
                            $.hideMask();
                        }
                    }
                });
            });
            $('#overappeal').on('click', function(e){
                if (confirm('确认完结')) {
                  $.showMask();
                  $.ajax({
                    url:'/appeal/over',
                    type:'POST',
                    data:{orderid:orderid, isflow:isflow},
                    dataType:'json',
                    error: function(xhr, errortext, errorthrow) {
                      $.prompt(errortext);
                      $.hideMask();
                    },
                    success: function(data, status) {
                      if (data.status == 0) {
                        location.reload();
                      } else {
                        $.prompt(data.msg);
                        $.hideMask();
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
