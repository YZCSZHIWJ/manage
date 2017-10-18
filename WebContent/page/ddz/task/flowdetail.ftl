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
    <title>浏览任务详情</title>
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
            	                浏览任务详情
            	            </header>
            	            <div class="panel-body">
            	                <form class="form-inline" action="/task/flowlist/detail" method="POST">
            	                    <div class="form-group">
            	                        <label for="id">任务ID：</label>
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
                                        <td width="6.25%" class="info">商家ID</td>
                                        <td width="6.25%"><a href="/user?userid=${detail.userid}" target="_blank">${detail.userid}</a></td>
                                        <td width="6.25%" class="info">店铺ID</td>
                                        <td width="6.25%">${detail.account}</td>
                                        <td width="6.25%" class="info">店铺名</td>
                                        <td width="6.25%">${detail.shopname}</td>
                                        <td width="6.25%" class="info">平台</td>
                                        <td width="6.25%"><#switch detail.plat><#case 1>淘宝<#break><#case 2>天猫<#break><#case 3>京东<#break></#switch></td>
                                        <td width="6.25%" class="info">操作设备</td>
                                        <td width="6.25%"><#if detail.device=1>手机<#else>电脑</#if></td>
                                        <td width="6.25%" class="info">商品名称</td>
                                        <td width="6.25%">${detail.gname}</td>
                                        <td width="6.25%" class="info">商品链接地址</td>
                                        <td width="6.25%"><a href="${detail.glink}" target="_blank" rel="noreferrer">${detail.glink?substring(0,15)}</a></td>
                                        <td width="6.25%" class="info">商品主图</td>
                                        <td width="6.25%"><a href="${detail.gpic}" target="_blank" class="fancybox-effects-d" data-fancybox-group="gallery" ><img src="${detail.gpic}" width="80" height="80" /></a></td>
                                    </tr>
                                    <tr>
                                    	<td class="info">商品数字ID</td>
                                    	<td>${detail.gid}</td>
										<td class="info">单品售价</td>
										<td>${detail.price}</td>                                    	
										<td class="info">搜索页面展示价格</td>
										<td>${detail.search_price}</td>
										<td class="info">价格区间</td>
										<td>${detail.minprice} -- ${detail.maxprice}</td>
										<td class="info">商品所在城市</td>
										<td>${detail.city}</td>
										<td class="info">特别任务类型</td>
										<td><#if detail.special_type=0>非特别任务<#else><#switch detail.special_type><#case 5>淘口令<#break><#case 6>淘客秒拍<#break><#case 7>聚划算<#break><#case 8>淘金币<#break><#case 9>天天特价<#break><#case 10>淘抢购<#break><#default>其他<#break></#switch></#if></td>
                                        <td class="info">特别任务地址或其他</td>
                                        <td>${detail.地址或其他}</td>
                                        <td class="info">任务发布时间</td>
                                        <td>${detail.itime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                    </tr>
                                    <tr>
                                        <td class="info">每单加赏</td>
                                        <td>${detail.add_commission}</td>
                                        <td class="info">是否设置定时</td>
                                        <td><#if detail.issetime=1>是<#else>否</#if></td>
                                        <td class="info">是否收藏加购</td>
                                        <td><#if detail.isfavtask=1>是<#else>否</#if></td>
                                        <td class="info">支付状态</td>
                                        <td><#if detail.status=0>未支付<#else>已支付</#if></td>
                                        <td class="info">支付时间</td>
                                        <td>${detail.paytime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td class="info">发布总数</td>
                                        <td>${detail.all_count}</td>
                                        <td class="info">已接数</td>
                                        <td>${detail.get_count}</td>
                                        <td class="info">待操作数</td>
                                        <td>${detail.waitdo_count}</td>
                                    </tr>
                                    <tr>
                                        <td class="info">待确认数</td>
                                        <td>${detail.waitsure_count}</td>
                                        <td class="info">完成单数</td>
                                        <td>${detail.end_count}</td>
                                        <td class="info">撤销单数</td>
                                        <td>${detail.cancel_count}</td>
                                        <td class="info">兄弟任务id</td>
                                        <td>${detail.brother_tid}</td>
                                        <td class="info">特别任务过期时间</td>
                                        <td>${detail.expirestime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td class="info">任务全部完成时间</td>
                                        <td>${detail.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td class="info">任务是否免审</td>
                                        <td><#if detail.isfree=0>非免审<#else>免审</#if></td>
                                        <td class="info">任务状态</td>
                                        <td><#switch detail.status><#case 0>未审核<#break><#case 1>已审核<#break><#case 2>已完成<#break><#case 3>不通过<#break><#case 4>被冻结<#break></#switch></td>
                                    </tr>
                                    <tr>
                                        <td class="info">审核</td>
                                        <td colspan="4">
                                            ${detail.auditadmin} ${detail.audittime?string('yyyy-MM-dd HH:mm:ss')} <br>
                                            <#if detail.status=3>不通过原因：${detail.nopassreason} </#if>
                                        </td>
                                        <td class="info">商家备注</td>
                                        <td colspan="6">${detail.remark}</td>
                                        <td class="info">备注或特别任务图</td>
                                        <td colspan="3">
                                            <#if detail.remark_img??> 
                                              <#if detail.remark_img?index_of(",") = -1> 
                                                <#if detail.remark_img!=''>
                                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${detail.remark_img}">
                                                  <img src="${detail.remark_img}" width="60" height="60">
                                                </a> 
                                                </#if> 
                                              <#else> 
                                                <#list detail.remark_img?split(",") as img> 
                                                  <#if img?? && img!=''>
                                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                                    <img src="${img}" width="60" height="60">
                                                  </a> 
                                                  </#if> 
                                                </#list> 
                                                </#if> 
                                            </#if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <#if detail.status=4>
                                        <td class="info">冻结原因</td>
                                        <td colspan="10">
                                            ${detail.freezereason} <br>
                                        </td>
                                        <td class="info">冻结时间</td>
                                        <td>${detail.freezetime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td class="info">冻结管理员</td>
                                        <td colspan="2">${detail.freezeadmin}</td>
                                        </#if>
                                    </tr>
                                </table>
                            </div>
                        </section>
                    </div>  
                </div>
                </#if>
                <#if limit??>
                <div class="row">
                	<div class="col-xs-12">
                		<div class="panel">
                			<header class="panel-heading">接单限制</header>
                			<div class="panel-body">
                				<table class="table table-bordered">
                					<tr>
                						<td class="info">买手绑定账号、店铺间隔天数</td>
                						<td>${limit.limit_acc_shop}</td>
                						<td class="info">买手、店铺间隔天数</td>
                						<td>${limit.limit_buyer_shop}</td>
                						<td class="info">买手、商家间隔天数限制</td>
                						<td>${limit.limit_buyer_seller}</td>
                						<td class="info">是否限制不可接单地区</td>
                						<td><#if limit.is_limit_province=0>否<#else>${limit.limit_province}</#if></td>
                						<td class="info">淘宝帐号限制等级</td>
                						<td><#if limit.is_limit_tblevel=0>不限制<#else>钻石买号</#if></td>
                						<td class="info">接单性别限制</td>
                						<td><#if limit.is_limit_sex=0>不限制<#elseif limit.is_limit_sex=1>男性<#else>女性</#if></td>
                						<td class="info">接单年龄限制</td>
                						<td><#if limit.is_limit_age=0>不限制<#elseif limit.is_limit_age=1>18-25岁<#elseif limit.is_limit_age=2>26-35岁<#elseif limit.is_limit_age=3>35岁及以上</#if></td>
                						<td class="info">是否仅花呗用户可接</td>
                						<td><#if limit.is_limit_hb=0>否<#else>是</#if></td>
                					</tr>
                				</table>
                			</div>
                		</div>
                	</div>
                </div>
                </#if>
                <#if timeset??>
                <div class="row">
                	<div class="col-xs-12">
                		<div class="panel">
                			<header class="panel-heading">定时设置</header>
                			<div class="panel-body">
                				<table class="table table-bordered">
                					<thead>
                						<tr>
                							<th class="info">开始日期</th>
                							<th class="info">开始时间点</th>
                							<th class="info">结束时间点</th>
                							<th class="info">任务发布间隔时间(分钟)</th>
                							<th class="info">发布订单数量</th>
                							<th class="info">下次任务释放时间</th>
                							<th class="info">最后一次释放任务时间</th>
                							<th class="info">是否可以开始放单</th>
                							<th class="info">定时状态</th>
                						</tr>
                					</thead>
									<tbody>
										<tr>
											<td>${timeset.startdate?string('yyyy-MM-dd')}</td>
											<td>${timeset.starttime?string('HH:mm:ss')}</td>
											<td>${timeset.endtime?string('HH:mm:ss')}</td>
											<td>${timeset.interval_minute}</td>
											<td>${timeset.interval_num}</td>
											<td>${timeset.nexttime?string('HH:mm:ss')}</td>
											<td>${timeset.lasttime?string('yyyy-MM-dd HH:mm:ss')}</td>
											<td><#if timeset.canrelease=0>未开始<#else>已开始</#if></td>
											<td><#if timeset.status=0>未完成<#else>已完成</#if></td>
										</tr>
									</tbody>
                				</table>
                			</div>
                		</div>
                	</div>
                </div>
                </#if>
                <#if keywordes??>
				<div class="row">
					<div class="col-xs-12">
						<div class="panel">
							<header class="panel-heading">搜索关键词设置</header>
							<div class="panel-body">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th class="info">关键词ID</th>
											<th class="info">任务ID</th>
											<th class="info">支付ID</th>
											<th class="info">关键词</th>
											<th class="info">订单总数</th>
											<th class="info">已接单数</th>
											<th class="info">排序说明</th>
											<th class="info">位置说明</th>
											<th class="info">浏览收藏说明</th>
										</tr>
									</thead>
									<tbody>
										<#list keywordes as keyword>
										<tr>
											<td>${keyword.keyword_id}</td>
											<td>${keyword.tid}</td>
											<td>${keyword.pid}</td>
											<td>${keyword.keyword}</td>
											<td>${keyword.count}</td>
											<td>${keyword.getcount}</td>
											<td>${keyword.sortmsg}</td>
											<td>${keyword.position}</td>
											<td>${keyword.fav_message}</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
                </#if>
                <#if payinfo??>
                <div class="row">
                	<div class="col-xs-12">
                		<div class="panel">
                			<header class="panel-heading">支付信息</header>
                			<div class="panel-body">
                				<table class="table table-bordered">
                					<thead>
                						<tr>
                                            <th class="info">总单数</th>
                							<th class="info">待放出单数</th>
                							<th class="info">待接单数</th>
                							<th class="info">已接单数</th>
                							<th class="info">已完成单数</th>
                							<th class="info">支付类别</th>
                							<th class="info">支付状态</th>
                							<th class="info">支付时间</th>
                							<th class="info">每单基础佣金</th>
                							<th class="info">每单加赏佣金</th>
                							<th class="info">其他增值费用</th>
                							<th class="info">用户每单可以得到佣金(包括嘉赏)</th>
                                            <th class="info">系统每单可得到的佣金</th>
                							<th class="info">该任务需支付总佣金</th>
                						</tr>
                					</thead>
                					<tbody>
                						<tr>
                                            <td>${payinfo.allcount}</td>
                                            <td>${payinfo.allcount - payinfo.waitcount - payinfo.getcount}</td>                 
                                            <td>${payinfo.waitcount}</td>
                                            <td>${payinfo.getcount}</td>
                                            <td>${payinfo.endcount}</td>
                                            <td><#switch payinfo.type>
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
                                            <td><#if payinfo.paystatus=0>未支付<#else>已支付</#if></td>
                                            <td>${payinfo.paytime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                            <td>${payinfo.base_commission}</td>
                                            <td>${payinfo.add_commission}</td>
                                            <td>${payinfo.other_commission}</td>
                                            <td>${payinfo.user_get_commission}</td>
                                            <td>${payinfo.sys_get_commission}</td>
                                            <td>${payinfo.all_commission}</td>
                                        </tr>
                					</tbody>
                				</table>
                			</div>
                		</div>
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