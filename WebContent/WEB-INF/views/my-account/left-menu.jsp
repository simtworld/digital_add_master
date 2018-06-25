<%@page import="com.digitaladd.model.UserMO"%>
 <script type="text/javascript">
 $(function(){
	 <%UserMO user = null;	 	
	 	
	 	if(session != null){
	 		user = (UserMO)session.getAttribute("bean");	
	 	}else{
	 		user = new UserMO(); 
	 	}%>
 })
 </script>
<!-- <div class="wrapper"> -->
<div class="sidebar" data-active-color="rose" data-background-color="black" data-image="<%=request.getContextPath() %>/assets/img/sidebar-1.jpg">
            <!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->
            <div class="logo">
                <a href="javascript:void(0)" class="simple-text logo-normal" style="padding-left: 70px;">
                    Digital Add
                </a>
            </div>
            <div class="sidebar-wrapper">
                <div class="user">
                    <div class="photo">
                        <img src="<%=request.getContextPath() %>/assets/img/faces/avatar.jpg" />
                    </div>
                    <div class="info">
                        <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                            <span>
                                <%=user.getFirstName() != null ? user.getFirstName() : "" %>
                                <b class="caret"></b>
                            </span>
                        </a>
                        <div class="clearfix"></div>
                        <div class="collapse" id="collapseExample">
                            <ul class="nav">
                                <li>
                                    <a href="#" style="padding-left: 50px;">
                                        <span class="sidebar-normal">My Packages</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/my-profile" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">MP</span> -->
                                        <span class="sidebar-normal">My Profile</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/change-password" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">EP</span> -->
                                        <span class="sidebar-normal">Change Password</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/logout" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">S</span> -->
                                        <span class="sidebar-normal">Logout</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <ul class="nav">
                    <li class="active">
                        <a href="dashboard.html">
                            <i class="material-icons">dashboard</i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="collapse" href="#manageProducts">
                            <i class="material-icons">image</i>
                            <p>Manage Products <b class="caret"></b> </p>
                        </a>
                        <div class="collapse" id="manageProducts">
                            <ul class="nav">
                                <li>
                                    <a href="pages/pricing.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">AP</span> -->
                                        <span class="sidebar-normal">Add Product</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="pages/timeline.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">VAP</span> -->
                                        <span class="sidebar-normal">View All Products</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="material-icons">apps</i>
                            <p>Manage Users</p>
                        </a>                        
                    </li>
                    <li>
                        <a data-toggle="collapse" href="#managePlans">
                            <i class="material-icons">content_paste</i>
                            <p>Manage Plans <b class="caret"></b> </p>
                        </a>
                        <div class="collapse" id="managePlans">
                            <ul class="nav">
                                <li>
                                    <a href="forms/regular.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">AP</span> -->
                                        <span class="sidebar-normal">Add Plan</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="forms/extended.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">VAP</span> -->
                                        <span class="sidebar-normal">View All Plans</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a data-toggle="collapse" href="#manageReceivers">
                            <i class="material-icons">grid_on</i>
                            <p>Manage Receivers
                                <b class="caret"></b>
                            </p>
                        </a>
                        <div class="collapse" id="manageReceivers">
                            <ul class="nav">
                                <li>
                                    <a href="tables/regular.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">UPN</span> -->
                                        <span class="sidebar-normal">Upload Phone Numbers</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="tables/extended.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">UP</span> -->
                                        <span class="sidebar-normal">Upload Emails</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="tables/datatables.net.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">VAPN</span> -->
                                        <span class="sidebar-normal">View All phone numbers</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="tables/datatables.net.html" style="padding-left: 50px;">
                                        <!-- <span class="sidebar-mini">VAE</span> -->
                                        <span class="sidebar-normal">View All Emails</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        
        <div class="main-panel">
        <nav class="navbar navbar-transparent navbar-absolute">
                <div class="container-fluid">
                    <div class="navbar-minimize">
                        <button id="minimizeSidebar" class="btn btn-round btn-white btn-fill btn-just-icon">
                            <i class="material-icons visible-on-sidebar-regular">more_vert</i>
                            <i class="material-icons visible-on-sidebar-mini">view_list</i>
                        </button>
                    </div>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="<%=request.getContextPath() %>/dashboard"> Dashboard </a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <!-- <li>
                                <a href="#pablo" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="material-icons">dashboard</i>
                                    <p class="hidden-lg hidden-md">Dashboard</p>
                                </a>
                            </li> -->
                            <!-- <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="material-icons">notifications</i>
                                    <span class="notification">5</span>
                                    <p class="hidden-lg hidden-md">
                                        Notifications
                                        <b class="caret"></b>
                                    </p>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">Mike John responded to your email</a>
                                    </li>
                                    <li>
                                        <a href="#">You have 5 new tasks</a>
                                    </li>
                                    <li>
                                        <a href="#">You're now friend with Andrew</a>
                                    </li>
                                    <li>
                                        <a href="#">Another Notification</a>
                                    </li>
                                    <li>
                                        <a href="#">Another One</a>
                                    </li>
                                </ul>
                            </li> -->
                            <li>
                                <%-- <a href="<%=request.getContextPath() %>/logout" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="material-icons" title="logout">exit_to_app</i>
                                </a> --%>
                            </li>
                            <li class="separator hidden-lg hidden-md"></li>
                        </ul>
                        <!-- <form class="navbar-form navbar-right" role="search">
                            <div class="form-group form-search is-empty">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="material-input"></span>
                            </div>
                            <button type="submit" class="btn btn-white btn-round btn-just-icon">
                                <i class="material-icons">search</i>
                                <div class="ripple-container"></div>
                            </button>
                        </form> -->
                    </div>
                </div>
            </nav>
            </div>
 <!-- </div> -->