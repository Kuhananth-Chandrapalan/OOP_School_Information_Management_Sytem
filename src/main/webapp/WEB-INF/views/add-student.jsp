<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<%! @SuppressWarnings("unchecked") %>

<%List<ClassX> classList = (List<ClassX>) request.getAttribute("classes");%>

<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Add Supplier" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Student Management</h4>
              <h6>Add Student</h6>
            </div>
          </div>

          <div class="card">
            <div class="card-body">
	            <form action="add-student" method="post" enctype="multipart/form-data" class="was-validated">
	              <div class="row">
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>First Name</label>
	                    <input class="form-control is-invalid" type="text" name="firstName" required/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Last Name</label>
	                    <input class="form-control is-invalid" type="text" name="lastName" required/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Email</label>
	                    <input class="form-control is-invalid" type="email" name="email" required/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Password</label>
	                    <input class="form-control is-invalid" type="password" name="password" required/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Phone</label>
	                    <input class="form-control is-invalid" type="text" name="phone_number" required pattern="[0-9]{10}"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Class</label>
	                    <select class="select" name="class_id" required>
	                      <%for(ClassX classX : classList){%>
	                      <option value="<%=classX.getClassId()%>"><%=classX.getClassName()%></option>
	                      <%}%>
	                    </select>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Gender</label>
	                    <select class="select" name="gender" required>
	                      <option>Choose Gender</option>
	                      <option>Male</option>
	                      <option>Female</option>
	                    </select>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Birth Date </label>
	                    <div class="input-groupicon">
	                      <input type="text" placeholder="YYYY-MM-DD" class="datetimepicker" name="date_of_birth" required>
		                    <div class="addonset">
		                    	<img src="assets/img/icons/calendars.svg" alt="img">
		                  	</div>
	                	</div>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <div class="form-group">
	                    <label>Address</label>
	                    <input class="form-control is-invalid" type="text" name="address" required/>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <div class="form-group">
	                    <label>Bio</label>
	                    <textarea class="form-control" name="bio" required></textarea>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <div class="form-group">
	                    <label>Picture</label>
	                    <input class="form-control is-invalid" type="file" name="profile_pic" required/>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <button type="submit" class="btn btn-submit me-2"
	                    >Submit</button
	                  >
	                  <button type="reset" class="btn btn-cancel"
	                    >Cancel</button
	                  >
	                </div>
	              </div>
	            </form>
            </div>
          </div>
        </div>
      </div>
    </div>
<!-- Include Footer -->
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>