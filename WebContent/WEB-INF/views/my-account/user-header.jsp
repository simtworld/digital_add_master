

<nav class="navbar navbar-inverse navbar-fixed-top " id="" style="padding-top: 0px;padding-bottom: 0px;"><!-- style="display: none;" -->
	        <div class="container">
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
	                    <span class="sr-only">Toggle navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand" href="<%=request.getContextPath() %>">Material Dashboard Pro</a>
	            </div>
	            <div class="collapse navbar-collapse" id="navbar">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a href="<%=request.getContextPath() %>/dashboard">
	                            <i class="material-icons">dashboard</i> Dashboard
	                        </a>
	                    </li>
	                    <li class="">
	                        <a href="<%=request.getContextPath() %>/logout">
	                            <i class="material-icons md-light">power_settings_new</i> Logout
	                        </a>
	                    </li>
	                    <li class="">
	                        <a href="lock.html">
	                            <i class="material-icons">lock_open</i> Lock
	                        </a>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </nav>
    <%-- </c:if> --%>
    
   <%--  <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
            <li class="header-title">Background Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <div class="togglebutton switch-sidebar-image">
                        <label>
                            <input type="checkbox" checked="">
                        </label>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger active-color" aria-expanded="false">
                    <p>Filters</p>
                    <div class="badge-colors pull-right">
                        <span class="badge filter active" data-color="black"></span>
                        <span class="badge filter badge-blue" data-color="blue"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple" data-color="purple"></span>
                        <span class="badge filter badge-rose" data-color="rose"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Background Images</li>
            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-1.jpg" data-src="<%=request.getContextPath()%>/assets/img/login.jpeg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-2.jpg" data-src="<%=request.getContextPath()%>/assets/img/lock.jpeg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-3.jpg" data-src="<%=request.getContextPath()%>/assets/img/header-doc.jpeg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-4.jpg" data-src="<%=request.getContextPath()%>/assets/img/bg-pricing.jpeg" alt="" />
                </a>
            </li>
        </ul>
    </div>
</div>
	
 --%>	
 
 
<div class="fixed-plugin" style="float:  left;position: fixed;background: #333333db;border-radius: 0px 8px 8px 0px;left: 0;">
    <div class="">
        <a href="#" onclick="open()">
            <i class="fa fa-bars fa-3x" style="color:white;padding:5px;"> </i>
        </a>
    </div>
</div>    
	