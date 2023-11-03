<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=0"
    />
    <meta name="description" content="POS - Bootstrap Admin Template" />
    <meta
      name="keywords"
      content="admin, estimates, bootstrap, business, corporate, creative, invoice, html5, responsive, Projects"
    />
    <meta name="author" content="Dreamguys - Bootstrap Admin Template" />
    <meta name="robots" content="noindex, nofollow" />
    <title>Login - Academic Staff Dashboard</title>

    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="assets/img/favicon.png"
    />

    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />

    <link
      rel="stylesheet"
      href="assets/plugins/fontawesome/css/fontawesome.min.css"
    />
    <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css" />
    
    <link rel="styleSheet" href="assets/css/messagebox.css" />

    <link rel="stylesheet" href="assets/css/style.css" />
  </head>
  <body class="account-page">
    <div class="main-wrapper">
      <div class="account-content">
        <div class="login-wrapper">
          <div class="login-content">
            <div class="login-userset">
              <form action="academic-staff-login" method="post">
                <div class="signinform text-center">
                  <img src="assets/img/logo.png" alt="img" />
                </div>
                <div class="login-userheading">
                  <h3>Academic Staff Login</h3>
                  <h4>Please login to your account</h4>
                </div>
                <div class="form-login">
                  <label>Email</label>
                  <div class="form-addons">
                    <input
                      type="text"
                      placeholder="Enter your email address"
                      name="email"
                      required
                    />
                    <img src="assets/img/icons/mail.svg" alt="img" />
                  </div>
                </div>
                <div class="form-login">
                  <label>Password</label>
                  <div class="pass-group">
                    <input
                      type="password"
                      class="pass-input"
                      placeholder="Enter your password"
                      name="password"
                      required
                    />
                    <span class="fas toggle-password fa-eye-slash"></span>
                  </div>
                </div>
                <div class="form-login">
                  <button class="btn btn-login" type="submit">Sign In</button>
                </div>
                <div id="msgbox-area" class="msgbox-area"></div>
              </form>
            </div>
          </div>
          <div class="login-img">
            <img src="assets/img/login.jpg" alt="img" />
          </div>
        </div>
      </div>
    </div>

    <script src="assets/js/jquery-3.6.0.min.js"></script>

    <script src="assets/js/feather.min.js"></script>

    <script src="assets/js/bootstrap.bundle.min.js"></script>
    
    <script src="assets/js/messagebox.js"></script>

    <script src="assets/js/script.js"></script>
  </body>
</html>
<script type="text/javascript">
  <%
  if(request.getParameter("status") != null){
  	String status = request.getParameter("status");
  	if(status.equals("wrong")) {
  		out.print("msgboxbox.show('Invalid email or password');");
  	}
  }
  %>
</script>
