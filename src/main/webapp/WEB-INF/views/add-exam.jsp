<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<%! @SuppressWarnings("unchecked") %>
<%List<AcademicStaff> academicStaffs = (List<AcademicStaff>) request.getAttribute("academicStaffs"); %>
<%List<ClassX> classList = (List<ClassX>) request.getAttribute("classes");%>
<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Modify Exam" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/academic-staff-sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Exam Management</h4>
              <h6>Modify exam</h6>
            </div>
          </div>

          <div class="card">
            <div class="card-body">
              <form action="new-exam" method="post" class="was-validated">
                <div class="row">
                  <div class="col-lg-3 col-sm-6 col-12">
                    <div class="form-group">
                      <label>Exam Name</label>
                      <input class="form-control is-invalid" type="text" placeholder="Enter Exam Name" name="name" required/>
                    </div>
                  </div>
                  <div class="col-lg-3 col-sm-6 col-12">
	                  <div class="form-group">
	                    <label>Class</label>
	                    <select class="select" name="classId" required>
	                      <%for(ClassX classX : classList){%>
	                      <option value="<%=classX.getClassId()%>"><%=classX.getClassName()%></option>
	                      <%}%>
	                    </select>
	                  </div>
	                </div>
                  <div class="col-lg-3 col-sm-6 col-12">
                    <div class="form-group">
                      <label>Teacher</label>
                      <select class="select" name="academicStaffId" required>
                        <%for(AcademicStaff academicStaff : academicStaffs) {%>
                        <option value="<%=academicStaff.getStaffId()%>"><%=academicStaff.getFirstName()%> <%=academicStaff.getLastName()%></option>
                        <%}%>
                      </select>
                    </div>
                  </div>
                  <div class="col-lg-12">
                    <button type="submit" class="btn btn-submit me-2"
                      >Submit</button
                    >
                    <button type="reset" class="btn btn-cancel">Cancel</button>
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