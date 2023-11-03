<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<%! @SuppressWarnings("unchecked") %>

<%List<ClassX> classList = (List<ClassX>) request.getAttribute("classes");%>
<%Student student = (Student) request.getAttribute("student");%>

<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Update Student" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Student Management</h4>
              <h6>Update student</h6>
            </div>
          </div>

          <div class="card">
            <div class="card-body">
	            <form action="modify-student" method="post" enctype="multipart/form-data" class="was-validated">
	              <div class="row">
					<div class="col-lg-3 col-sm-6 col-12">
						<div class="form-group">
						  <label>Student ID</label>
						  <input type="text" name="id" value="<%=student.getStudentId()%>" readonly/>
						</div>
					  </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>First Name</label>
	                    <input class="form-control is-invalid" type="text" name="firstName" required value="<%=student.getFirstName()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Last Name</label>
	                    <input class="form-control is-invalid" type="text" name="lastName" required value="<%=student.getLastName()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Email</label>
	                    <input class="form-control is-invalid" type="email" name="email" required value="<%=student.getEmail()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Password</label>
	                    <input class="form-control is-invalid" type="password" name="password" required value="<%=student.getPassword()%>"/>	
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Phone</label>
	                    <input class="form-control is-invalid" type="text" name="phone_number" required value="<%=student.getPhoneNumber()%>" pattern="[0-9]{10}"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Class</label>
	                    <select class="select" name="class_id" required>
	                      <%for(ClassX classX : classList){
							if(classX.getClassId() == student.getClassId()){
								%>
								<option value="<%=classX.getClassId()%>" selected><%=classX.getClassName()%></option>
								<%
							}else{
								%>
								<option value="<%=classX.getClassId()%>"><%=classX.getClassName()%></option>
							<% } %>
	                      <% } %>
	                    </select>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Gender</label>
	                    <select class="select" name="gender" required>
	                      <option>Choose Gender</option>
						  <%if(student.getGender() == "male") { %>
							<option selected>Male</option>
							<option>Female</option>
						  <% } else { %>
							<option>Male</option>
							<option selected>Female</option>
						  <% } %>
	                    </select>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Birth Date </label>
	                    <div class="input-groupicon">
	                      <input type="text" placeholder="YYYY-MM-DD" class="datetimepicker" name="date_of_birth" required value="<%=student.getDateOfBirth()%>"/>
		                    <div class="addonset">
		                    	<img src="assets/img/icons/calendars.svg" alt="img">
		                  	</div>
	                	</div>
	                  </div>
	                </div>
	                <div class="col-lg-9">
	                  <div class="form-group">
	                    <label>Address</label>
	                    <input class="form-control is-invalid" type="text" name="address" required value="<%=student.getAddress()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <div class="form-group">
	                    <label>Bio</label>
	                    <textarea class="form-control" name="bio" required><%=student.getBio()%></textarea>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <div class="form-group">
	                    <label>Picture</label>
	                    <input class="form-control is-invalid" type="file" name="profile_pic"/>
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