<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>One Sound - Admin - addSong</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">

</head>

<body>
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="lds-ellipsis">
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">
        <!-- Navbar Area -->
        <div class="oneMusic-main-menu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="oneMusicNav">

                        <!-- Nav brand -->
                        <a href="index.html" class="nav-brand"><img src="img/core-img/logo.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <!-- <div class="classynav">
                                <ul>
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="albums-store.html">Albums</a></li>
                                    <li><a href="#">Pages</a>
                                        <ul class="dropdown">
                                            <li><a href="index.html">Home</a></li>
                                            <li><a href="albums-store.html">Albums</a></li>
                                            <li><a href="event.html">Events</a></li>
                                            <li><a href="blog.html">News</a></li>
                                            <li><a href="contact.html">Contact</a></li>
                                            <li><a href="elements.html">Elements</a></li>
                                            <li><a href="login.html">Login</a></li>
                                            <li><a href="#">Dropdown</a>
                                                <ul class="dropdown">
                                                    <li><a href="#">Even Dropdown</a></li>
                                                    <li><a href="#">Even Dropdown</a></li>
                                                    <li><a href="#">Even Dropdown</a></li>
                                                    <li><a href="#">Even Dropdown</a>
                                                        <ul class="dropdown">
                                                            <li><a href="#">Deeply Dropdown</a></li>
                                                            <li><a href="#">Deeply Dropdown</a></li>
                                                            <li><a href="#">Deeply Dropdown</a></li>
                                                            <li><a href="#">Deeply Dropdown</a></li>
                                                            <li><a href="#">Deeply Dropdown</a></li>
                                                        </ul>
                                                    </li>
                                                    <li><a href="#">Even Dropdown</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="event.html">Events</a></li>
                                    <li><a href="blog.html">News</a></li>
                                    <li><a href="contact.html">Contact</a></li>
                                </ul> -->

                                <!-- Login/Register & Cart Button -->
                                <!-- <div class="login-register-cart-button d-flex align-items-center">
                                 
                                    <div class="login-register-btn mr-50">
                                        <a href="login.html" id="loginBtn">Login</a>
                                    </div> -->

                                    <!-- Cart Button -->
                                    <!-- <div class="cart-btn">
                                        <p><span class="icon-shopping-cart"></span> <span class="quantity">1</span></p>
                                    </div>
                                </div>
                            </div> -->
                            <!-- Nav End -->

                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Breadcumb Area Start ##### -->
   
    <!-- ##### Breadcumb Area End ##### -->

        <!-- ##### Header Area Start ##### -->
        <header class="header-area">
            <!-- Navbar Area -->
            <div class="oneMusic-main-menu">
                <div class="classy-nav-container breakpoint-off">
                    <div class="container">
                        <!-- Menu -->
                        <nav class="classy-navbar justify-content-between" id="oneMusicNav">
    
                            <!-- Nav brand -->
                            <a href="index.html" class="nav-brand"><img src="img/core-img/logo.png" alt=""></a>
    
                            <!-- Navbar Toggler -->
                            <div class="classy-navbar-toggler">
                                <span class="navbarToggler"><span></span><span></span><span></span></span>
                            </div>
    
                            <!-- Menu -->
                            <div class="classy-menu">
    
                                <!-- Close Button -->
                                <div class="classycloseIcon">
                                    <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                                </div>
    
                                <!-- Nav Start -->
                                <!-- <div class="classynav">
                                    <ul>
                                        <li><a href="index.html">Home</a></li>
                                        <li><a href="albums-store.html">Albums</a></li>
                                        <li><a href="#">Pages</a>
                                            <ul class="dropdown">
                                                <li><a href="index.html">Home</a></li>
                                                <li><a href="albums-store.html">Albums</a></li>
                                                <li><a href="event.html">Events</a></li>
                                                <li><a href="blog.html">News</a></li>
                                                <li><a href="contact.html">Contact</a></li>
                                                <li><a href="elements.html">Elements</a></li>
                                                <li><a href="login.html">Login</a></li>
                                                <li><a href="#">Dropdown</a>
                                                    <ul class="dropdown">
                                                        <li><a href="#">Even Dropdown</a></li>
                                                        <li><a href="#">Even Dropdown</a></li>
                                                        <li><a href="#">Even Dropdown</a></li>
                                                        <li><a href="#">Even Dropdown</a>
                                                            <ul class="dropdown">
                                                                <li><a href="#">Deeply Dropdown</a></li>
                                                                <li><a href="#">Deeply Dropdown</a></li>
                                                                <li><a href="#">Deeply Dropdown</a></li>
                                                                <li><a href="#">Deeply Dropdown</a></li>
                                                                <li><a href="#">Deeply Dropdown</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="#">Even Dropdown</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="event.html">Events</a></li>
                                        <li><a href="blog.html">News</a></li>
                                        <li><a href="contact.html">Contact</a></li>
                                    </ul> -->
    
                                    <!-- Login/Register & Cart Button -->
                                    <!-- <div class="login-register-cart-button d-flex align-items-center">
                                     
                                        <div class="login-register-btn mr-50">
                                            <a href="login.html" id="loginBtn">Login</a>
                                        </div> -->
    
                                        <!-- Cart Button -->
                                        <!-- <div class="cart-btn">
                                            <p><span class="icon-shopping-cart"></span> <span class="quantity">1</span></p>
                                        </div>
                                    </div>
                                </div> -->
                                <!-- Nav End -->
    
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- ##### Header Area End ##### -->
    
        <!-- ##### Breadcumb Area Start ##### -->
        <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb1.jpg);">
            <div class="bradcumbContent">
                <p>Add New Songs</p>
                <h2>Admin Add Song</h2>
            </div>
        </section>
        <!-- ##### Breadcumb Area End ##### -->
    
        <!-- ##### Login Area Start ##### -->
        <section class="login-area section-padding-100">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-8">
                        <div class="login-content">
                            <h3>Welcome to the ONE SOUND....</h3>
                            <!-- SignUp Form -->
                            <div class="login-form">
                                <form id="song-form" action="http://localhost:8090/OneSound/AdminServlet/insert" method="GET">
                                   
                                    <div class="form-group">
                                        <label for="artistid">Artist ID</label>
                                        <input type="text" class="form-control" id="artistid" name="artistid" value=1>
                                    </div>
    
                                    <div class="form-group">
                                        <label for="songname">Song Name</label>
                                        <input type="text" class="form-control" id="songname" name="songname" value="my song">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="duration">Duration</label>
                                        <input type="text" class="form-control" id="duration" name="duration" value="5">
                                        <!-- <small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small> -->
                                    </div>
    
                                    <div class="form-group">
                                        <label for="category">Category</label>
                                        <input type="text" class="form-control" id="category" name="category" value="Pop">
                                    </div>
                                    
    
    
    
    
    
                                    <button type="submit" class="btn oneMusic-btn mt-30">Submit</button>
                                </form>
                                
                                    <script>
                                    //this comment
                                    
            // Get a reference to the form element
            var form = document.getElementById("song-form");
    
            // Add an event listener to the form's submit event
            form.addEventListener("submit", function(event) {
                // Prevent the default form submission
                event.preventDefault();
    
                // Get the user input value
                var artistid = document.getElementById("artistid").value;
    
                // Perform some manipulation on the input value For example, converting to uppercase
    
                // Set the modified value back to the input field
                document.getElementById("artistid").value = artistid;
                // Get the user input value
                var songname = document.getElementById("songname").value;
    
                // Perform some manipulation on the input value
    
                // Set the modified value back to the input field
                document.getElementById("songname").value = songname;
                
                // Get the user input value
                var duration = document.getElementById("duration").value;
    
                // Perform some manipulation on the input value
    
                // Set the modified value back to the input field
                document.getElementById("duration").value =duration;
                
                // Get the user input value
                var category = document.getElementById("category").value;
    
    
                // Set the modified value back to the input field
                document.getElementById("category").value = category;
    
                // Now, you can submit the form programmatically if needed
                form.submit();
            });
        </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area">
    <div class="container">
        <div class="row d-flex flex-wrap align-items-center">
            <div class="col-12 col-md-6">
                <a href="#"><img src="img/core-img/logo.png" alt=""></a>
                <p class="copywrite-text">
                    <a href="#">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Designed by Group 2023/S2/MLB/WE/G36 <i class="fa fa-heart-o" aria-hidden="true"></i>  <a href="https://colorlib.com" target="_blank"></a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </a>
                </p>
            </div>
        </div>
    </div>
</footer>
<!-- ##### Footer Area Start ##### -->

<!-- ##### All Javascript Script ##### -->
<!-- jQuery-2.2.4 js -->
<script src="js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="js/bootstrap/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- All Plugins js -->
<script src="js/plugins/plugins.js"></script>
<!-- Active js -->
<script src="js/active.js"></script>
</body>
</html>
