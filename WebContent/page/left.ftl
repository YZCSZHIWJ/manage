<!-- left side start-->
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="/dashboard"><img src="/images/logo.png" alt=""></a>
    </div>

    <div class="logo-icon text-center">
        <a href="/dashboard"><img src="/images/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->

    <div class="left-side-inner">

        <!-- visible to small devices only -->
        <div class="visible-xs hidden-sm hidden-md hidden-lg">
            <div class="media logged-user">
                <!-- <img alt="" src="/images/photos/user-avatar.png" class="media-object"> -->
                <div class="media-body">
                    <h4><a href="#">${master.m_cname}</a></h4>
                </div>
            </div>
            <ul class="nav nav-pills nav-stacked custom-nav">
              <li><a href="/common?setting&id=${master.m_id}"><i class="fa fa-cog"></i> <span>设置</span></a></li>
              <li><a href="/login"><i class="fa fa-sign-out"></i> <span>退出</span></a></li>
            </ul>
        </div>

        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li <#if g_id=0>class="active"</#if>><a href="/dashboard"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <#if leftnavlist??>
            <#list leftnavlist as navitem>
            <li class="menu-list <#if g_id=navitem.g_id>nav-active</#if>"><a href=""><i class="fa ${navitem.g_tag}"></i> <span>${navitem.g_name}</span></a>
                <#if (navitem.f_list?? && navitem.f_list?size>0)>
                <ul class="sub-menu-list">
                <#list navitem.f_list as fn>
                    <li <#if f_id=fn.f_id>class="active"</#if>><a href="${fn.f_uri}"> ${fn.f_name}</a></li>
                </#list>
                </ul>
                </#if>
            </li>
            </#list>
            </#if>
        </ul>
        <!--sidebar nav end-->
    </div>
</div>
<!-- left side end-->