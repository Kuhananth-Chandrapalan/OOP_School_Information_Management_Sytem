<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<%! @SuppressWarnings("unchecked") %>

<% List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");%>
<% AcademicStaff academicStaff = (AcademicStaff) request.getAttribute("academicStaff");%>

<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Modify Academic Staff" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Staff Management</h4>
              <h6>Modify Academic Staff Member</h6>
            </div>
          </div>

          <div class="card">
            <div class="card-body">
	            <form action="modify-academic-staff" method="post" enctype="multipart/form-data" class="was-validated">
	              <div class="row">
					<div class="col-lg-3 col-sm-6 col-12">
						<div class="form-group">
						  <label>Staff ID</label>
						  <input type="text" name="id" value="<%=academicStaff.getStaffId()%>" readonly/>
						</div>
					  </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>First Name</label>
	                    <input class="form-control is-invalid" type="text" name="firstName" required value="<%=academicStaff.getFirstName()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Last Name</label>
	                    <input class="form-control is-invalid" type="text" name="lastName" required value="<%=academicStaff.getLastName()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Email</label>
	                    <input class="form-control is-invalid" type="email" name="email" required value="<%=academicStaff.getEmail()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Password</label>
	                    <input class="form-control is-invalid" type="password" name="password" required value="<%=academicStaff.getPassword()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Phone</label>
	                    <input class="form-control is-invalid" type="text" name="phoneNumber" required value="<%=academicStaff.getPhoneNumber()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Subject</label>
	                    <select class="select" name="subjectId" required>
	                      <%for(Subject subject : subjects){
							if (subject.getSubjectId() == academicStaff.getSubjectId()) {%>
	                      		<option value="<%=subject.getSubjectId()%>" selected><%=subject.getSubjectName()%></option>
	                      	<%} else {%>
	                      		<option value="<%=subject.getSubjectId()%>"><%=subject.getSubjectName()%></option>
	                      	<%}
	                      }%>
	                    </select>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Role</label>
	                    <select class="select" name="role" required value="<%=academicStaff.getRole()%>">
	                      <option disabled>Choose Role</option>
						  <option value="Guest Teacher">Guest Teacher</option>
						  <option value="Teacher">Teacher</option>
						  <option value="Senior Teacher">Senior Teacher</option>
						  <option value="Head of Department">Head of Department</option>
						  <option value="Vice Principal">Vice Principal</option>
						  <option value="Principal">Principal</option>
	                    </select>
	                  </div>
	                </div>
	                <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Birth Date </label>
	                    <div class="input-groupicon">
	                      <input type="text" placeholder="YYYY-MM-DD" class="datetimepicker" name="dateOfBirth" required value="<%=academicStaff.getDateOfBirth()%>"/>
		                    <div class="addonset">
		                    	<img src="assets/img/icons/calendars.svg" alt="img">
		                  	</div>
	                	</div>
	                  </div>
	                </div>
	                <div class="col-lg-9">
	                  <div class="form-group">
	                    <label>Address</label>
	                    <input class="form-control is-invalid" type="text" name="address" required value="<%=academicStaff.getAddress()%>"/>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <div class="form-group">
	                    <label>Bio</label>
	                    <textarea class="form-control" name="bio" required><%=academicStaff.getBio()%></textarea>
	                  </div>
	                </div>
	                <div class="col-lg-12">
	                  <div class="form-group">
	                    <label>Picture</label>
	                    <input class="form-control is-invalid" type="file" name="profilePic"/>
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