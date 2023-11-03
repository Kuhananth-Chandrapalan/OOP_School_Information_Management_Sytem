<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% int studentsCount = (Integer) request.getAttribute("studentsCount"); %>
<% int teachersCount = (Integer) request.getAttribute("teachersCount"); %>
<% int classCount = (Integer) request.getAttribute("classCount"); %>
<% int subjectCount = (Integer) request.getAttribute("subjectCount"); %>
<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
        <div class="content">
          <div class="row">
            <div class="col-lg-3 col-sm-6 col-12 d-flex">
              <div class="dash-count">
                <div class="dash-counts">
                  <h4><%=studentsCount%></h4>
                  <h5>Students</h5>
                </div>
                <div class="dash-imgs">
                  <i data-feather="user"></i>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-sm-6 col-12 d-flex">
              <div class="dash-count das1">
                <div class="dash-counts">
                  <h4><%=teachersCount%></h4>
                  <h5>Teachers</h5>
                </div>
                <div class="dash-imgs">
                  <i data-feather="user-check"></i>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-sm-6 col-12 d-flex">
              <div class="dash-count das2">
                <div class="dash-counts">
                  <h4><%=classCount%></h4>
                  <h5>Classes</h5>
                </div>
                <div class="dash-imgs">
                  <i data-feather="file-text"></i>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-sm-6 col-12 d-flex">
              <div class="dash-count das3">
                <div class="dash-counts">
                  <h4><%=subjectCount%></h4>
                  <h5>Subjects</h5>
                </div>
                <div class="dash-imgs">
                  <i data-feather="file"></i>
                </div>
              </div>
            </div>
          </div>

          <div class="page-header card mb-0">
            <h1 class="text-center mt-5">Welcome to School Management System</h1>
            <h2 class="text-center mb-5">Admin Dashboard</h2>
            <h3 class="text-center">Developed by:</h3>
            <h4 class="text-center">Niranthari Mohanarajakumar </h4>
            <h4 class="text-center">Yashodini Soysa</h4>
            <h4 class="text-center">Chandrapalan Kuhananth</h4>
            <h4 class="text-center mb-5">Rajasoorie Dhinojjan</h4>
          </div>
        </div>
      </div>
    </div>

<!-- Include Footer -->
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>