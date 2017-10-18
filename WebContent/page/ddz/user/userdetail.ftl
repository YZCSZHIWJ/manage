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
    <title>用户详情</title>
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
            <li class="list-group-item"><input type="checkbox" value="头像不真实"> 头像不真实</li>
            <li class="list-group-item"><input type="checkbox" value="身份证图片不清晰"> 身份证图片不清晰</li>
            <li class="list-group-item"><input type="checkbox" value="身份证姓名不匹配"> 身份证姓名不匹配</li>
            <li class="list-group-item"><input type="checkbox" value="身份证重复"> 身份证重复</li>
            <li class="list-group-item"><input type="checkbox" value="请上传清晰完整的实拍身份证正面照片"> 请上传清晰完整的实拍身份证正面照片</li>
            <li class="list-group-item"><input type="checkbox" value="未满19周岁"> 未满19周岁</li>
            <li class="list-group-item"><input type="checkbox" value="买手多次不按要求上传，视为恶意注册，账号暂时冻结"> 买手多次不按要求上传，视为恶意注册，账号暂时冻结</li>
            <li class="list-group-item"><input type="checkbox" value="1960及1960年前不符合注册要求"> 1960及1960年前不符合注册要求</li>
            <li class="list-group-item"><input type="checkbox" value="身份证姓名与绑定银行卡姓名不一致"> 身份证姓名与绑定银行卡姓名不一致</li>
            <li class="list-group-item"><input type="checkbox" value="非本人"> 非本人</li>
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
            <div class="wrapper">
            	<div class="row">
            	    <div class="col-xs-12">
            	        <section class="panel">
            	            <header class="panel-heading">
            	                用户信息查询
            	            </header>
            	            <div class="panel-body">
            	                <form class="form-inline" action="/user" method="GET">
            	                    <div class="form-group">
            	                        <label for="userid">用户ID：</label>
            	                        <input type="text" class="form-control" name="userid" id="userid" value="${userid}">
            	                    </div>
            	                    <div class="form-group">
            	                        <label for="mobile">手机号码：</label>
            	                        <input type="text" class="form-control" name="mobile" id="mobile" value="${mobile}">
            	                    </div>
            	                    <button type="submit" class="btn btn-primary">确认</button>
            	                </form>
            	            </div>
            	        </section>
            	    </div>
            	</div>
            	<#if user??>
                <div class="row">
                    <div class="col-xs-12">
                          <section class="panel">
                              <header class="panel-heading">基本信息</header>
                              <div class="panel-body">
                                <table class="table table-bordered">
                                    <tr>
                                        <td class="info">用户ID</td>
                                        <td>${user.userid}</td>
                                        <td class="info">手机号</td>
                                        <td>${user.mobile}</td>
                                        <td class="info">注册时间</td>
                                        <td>${user.regtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td class="info">注册ip</td>
                                        <td>${user.regip}</td>
                                        <td class="info">最后登录时间</td>
                                        <td>${user.lasttime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td class="info">最后登录ip</td>
                                        <td>${user.lastip}</td>
                                        <td class="info">QQ</td>
                                        <td>${user.qq}</td>
                                        <td class="info">Email</td>
                                        <td>${user.email}</td>
                                    </tr>
                                    <tr>
                                    	<td class="info">登录标识</td>
                                    	<td><#if user.sign=0>android<#elseif user.sign=1>ios<#else>pc</#if></td>
										<td class="info">imei</td>
										<td>${user.imei}</td>                                    	
										<td class="info">等级</td>
										<td>${user.level}</td>
										<td class="info">积分</td>
										<td>${user.score}</td>
										<td class="info">状态</td>
										<td><#if user.status=0>正常<#else>冻结</#if></td>
										<td class="info"></td>
										<td colspan="5"></td>
                                    </tr>
                                    <tr>
                                        <td class="info">操作</td>
                                        <td colspan="15"></td>
                                    </tr>
                                </table>
                            </div>
                        </section>
                    </div>  
                </div>
                </#if>
                <#if account??>
                <div class="row">
                	<div class="col-xs-12">
                		<div class="panel">
                			<header class="panel-heading">平台账户信息</header>
                			<div class="panel-body">
                				<table class="table table-bordered">
                					<tr>
                						<td class="info">本金</td>
                						<td><a href="/user/moneydetail?userid=${account.userid}&type=1" target="_blank">${account.money}</a></td>
                						<td class="info">佣金</td>
                						<td><a href="/user/moneydetail?userid=${account.userid}&type=2" target="_blank">${account.gold}</a></td>
                						<td class="info">冻结金</td>
                						<td><a href="/user/moneydetail?userid=${account.userid}&type=3" target="_blank">${account.fmoney}</a></td>
                						<td class="info">今日收入</td>
                						<td>${account.today_income}</td>
                						<td class="info">今日支出</td>
                						<td>${account.today_expense}</td>
                						<td class="info">总收入</td>
                						<td>${account.all_income}</td>
                						<td class="info">总支出</td>
                						<td>${account.all_expense}</td>
                						<td class="info">今日邀请总收入</td>
                						<td>${account.today_invite_income}</td>
                						<td class="info">商家折扣</td>
                						<td>${account.discount}</td>
                					</tr>
                				</table>
                			</div>
                		</div>
                	</div>
                </div>
                </#if>
                <#if bindbanklist??>
                <div class="row">
                	<div class="col-xs-12">
                		<div class="panel">
                			<header class="panel-heading">绑定银行</header>
                			<div class="panel-body">
                				<table class="table table-bordered">
                					<thead>
                						<tr>
                							<th class="info">账号类别</th>
                							<th class="info">账号</th>
                							<th class="info">姓名</th>
                							<th class="info">省份</th>
                							<th class="info">城市</th>
                							<th class="info">开户银行</th>
                							<th class="info">支行</th>
                							<th class="info">状态</th>
                							<th class="info">绑定时间</th>
                						</tr>
                					</thead>
									<tbody>
                					<#list bindbanklist as bindbank>
										<tr>
											<td><#if bindbank.type=1>支付宝<#elseif bindbank.type=1>财付通<#elseif bindbank.type=3>银行卡</#if></td>
											<td>${bindbank.bindaccount}</td>
											<td>${bindbank.cname}</td>
											<td>${bindbank.province}</td>
											<td>${bindbank.city}</td>
											<td>${bindbank.bankname}</td>
											<td>${bindbank.branchname}</td>
											<td><#if bindbank.status=0>正常<#else>异常</#if></td>
											<td>${bindbank.itime?string('yyyy-MM-dd HH:mm:ss')}</td>
										</tr>
                					</#list>
									</tbody>
                				</table>
                			</div>
                		</div>
                	</div>
                </div>
                </#if>
                <#if bindbuyerlist??>
				<div class="row">
					<div class="col-xs-12">
						<div class="panel">
							<header class="panel-heading">绑定账号</header>
							<div class="panel-body">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th class="info">平台</th>
											<th class="info">账号</th>
											<th class="info">绑定时间</th>
											<th class="info">性别</th>
											<th class="info">出生日期</th>
											<th class="info">收货人</th>
											<th class="info">收货人手机</th>
											<th class="info">收货地址</th>
											<th class="info">接单量(日，周，月，日浏览)</th>
											<th class="info">最后接单时间</th>
											<th class="info">账号审核状态</th>
											<th class="info">审核管理员</th>
											<th class="info">审核时间</th>
											<th class="info">信誉等级</th>
											<th class="info">花呗状态</th>
										</tr>
									</thead>
									<tbody>
										<#list bindbuyerlist as bindbuyer>
										<tr>
											<td><#if bindbuyer.plat=1>淘宝<#elseif bindbuyer.plat=2>京东</#if></td>
											<td>${bindbuyer.account}</td>
											<td>${bindbuyer.bdtime?string('yyyy-MM-dd HH:mm:ss')}</td>
											<td><#if bindbuyer.sex=1>男<#else>女</#if></td>
											<td>${bindbuyer.birthday?string('yyyy-MM-dd')}</td>
											<td>${bindbuyer.receiver}</td>
											<td>${bindbuyer.mobile}</td>
											<td>${bindbuyer.province} ${bindbuyer.city} ${bindbuyer.county} ${bindbuyer.address}</td>
											<td>${bindbuyer.daynum}, ${bindbuyer.weeknum}, ${bindbuyer.mouthnum}, ${bindbuyer.daynum_flow}</td>
											<td>${bindbuyer.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
											<td><#if bindbuyer.status=0>待审核<#elseif bindbuyer.status=1>通过<#elseif bindbuyer.status=2>拒绝<#elseif bindbuyer.status=3>冻结</#if></td>
											<td>${bindbuyer.auditadmin}</td>
											<td>${bindbuyer.audittime?string('yyyy-MM-dd HH:mm:ss')}</td>
											<td>
                                                <#switch bindbuyer.creditlevel><#case 1>3心<#break><#case 2>4心<#break><#case 3>5心<#break><#case 4>1钻<#break><#case 5>2钻<#break><#case 6>3钻及以上<#break></#switch>
											</td>
											<td><#if bindbuyer.hb_status=0>未提交<#elseif bindbuyer.hb_status=1>审核中<#elseif bindbuyer.hb_status=2>通过<#elseif bindbuyer.hb_status=3>不通过</#if></td>
										</tr>
										</#list>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
                </#if>
                <#if bindshoplist??>
                <div class="row">
                	<div class="col-xs-12">
                		<div class="panel">
                			<header class="panel-heading">绑定店铺</header>
                			<div class="panel-body">
                				<table class="table table-bordered">
                					<thead>
                						<tr>
                							<th class="info">平台类别</th>
                							<th class="info">店铺名称</th>
                							<th class="info">店铺账号</th>
                							<th class="info">店铺首页网址</th>
                							<th class="info">绑定时间</th>
                							<th class="info">发货地址</th>
                							<th class="info">状态</th>
                							<th class="info">审核时间</th>
                							<th class="info">审核管理员</th>
                							<th class="info">acc/buyer-shop，buyer-seller</th>
                							<th class="info">可发手返</th>
                							<th class="info">可发垫付</th>
                						</tr>
                					</thead>
                					<tbody>
                                        <#list bindshoplist as bindshop>
                						<tr>
                                            <td><#if bindshop.plat=1>淘宝<#elseif bindshop.plat=2>天猫<#elseif bindshop.plat=3>京东</#if></td>
                                            <td>${bindshop.shopname}</td>                 
                                            <td>${bindshop.account}</td>
                                            <td><div class="lim-w" style="max-width: 20em;"><a href="${bindshop.shopurl}" target="_blank" rel="noreferrer">${bindshop.shopurl}</a></div></td>
                                            <td>${bindshop.bdtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                            <td>${bindshop.province} ${bindshop.city} ${bindshop.county} ${bindshop.address}</td>
                                            <td><#if bindshop.status=0>待审核<#elseif bindshop.status=1>通过<#elseif bindshop.status=2>不通过<#elseif bindshop.status=3>冻结</#if></td>
                                            <td>${bindshop.audit_time?string('yyyy-MM-dd HH:mm:ss')}</td>
                                            <td>${bindshop.audit_admin}</td>
                                            <td>${bindshop.limit_acc_shop}/${bindshop.limit_buyer_shop}，${bindshop.limit_buyer_seller}</td>
                                            <td><#if bindshop.isselfback=0>yes<#else>no</#if></td>
                                            <td><#if bindshop.isdianfutask=0>yes<#else>no</#if></td>
                                        </tr>
                                        </#list>
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
    <!--common scripts for all pages-->
    <script src="/js/scripts.js"></script>
  </body>
</html>
</#escape>