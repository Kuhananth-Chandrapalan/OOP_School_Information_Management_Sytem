<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/academic-staff-sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
	   <div class="content">
		 <div class="row">
            <div class="col-lg-6 col-sm-6 col-12 d-flex">
              <div class="dash-count">
                <div class="dash-counts">
                  <h4>34</h4>
                  <h5>Students</h5>
                </div>
                <div class="dash-imgs">
                  <i data-feather="user"></i>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-sm-6 col-12 d-flex">
              <div class="dash-count das2">
                <div class="dash-counts">
                  <h4>23</h4>
                  <h5>Exams</h5>
                </div>
                <div class="dash-imgs">
                  <i data-feather="file-text"></i>
                </div>
              </div>
            </div>
          </div>
        <div class="content">
          <div class="page-header card mb-0">
            <h1 class="text-center mt-5">Welcome to School Management System</h1>
            <h2 class="text-center mb-5">Academic Staff Dashboard</h2>
          </div>
        </div>
      </div>
    </div>

<!-- Include Footer -->
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>