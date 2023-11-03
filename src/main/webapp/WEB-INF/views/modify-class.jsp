<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<%! @SuppressWarnings("unchecked") %>
<%List<AcademicStaff> academicStaffs = (List<AcademicStaff>) request.getAttribute("academicStaffs"); %>
<%List<Subject> subjects = (List<Subject>) request.getAttribute("subjects"); %>
<% ClassX classX = (ClassX) request.getAttribute("classX"); %>
<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Modify Class" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Class Modify</h4>
              <h6>Modify class</h6>
            </div>
          </div>

          <div class="card">
            <div class="card-body">
              <form action="modify-class" method="post" class="was-validated">
                <div class="row">
                  <div class="col-lg-3 col-sm-6 col-9">
                    <div class="form-group">
                      <label>Class ID</label>
                      <input type="text" placeholder="Enter Class ID" name="classId" value="<%=classX.getClassId()%>" readonly/>
                    </div>
                  </div>
                  <div class="col-lg-3 col-sm-6 col-9">
                    <div class="form-group">
                      <label>Class Name</label>
                      <input class="form-control is-invalid" type="text" placeholder="Enter Class Name" name="className" value="<%=classX.getClassName()%>" required/>
                    </div>
                  </div>
                  <div class="col-lg-3 col-sm-6 col-9">
                    <div class="form-group">
                      <label>Teacher</label>
                      <select class="select" name="academicStaffId" required>
                        <%for(AcademicStaff academicStaff : academicStaffs) {%>
                          <% if(academicStaff.getStaffId() == classX.getAcademicStaffId()) {%>
                            <option value="<%=academicStaff.getStaffId()%>" selected><%=academicStaff.getFirstName()%> <%=academicStaff.getLastName()%></option>
                          <%} else {%>
                            <option value="<%=academicStaff.getStaffId()%>"><%=academicStaff.getFirstName()%> <%=academicStaff.getLastName()%></option>
                          <%}%>
                        <%}%>
                      </select>
                    </div>
                  </div>
                  <div class="col-lg-4 col-sm-6 col-9">
                      <div class="form-group">
                        <label>Subject</label>
                        <select class="select" name="subjectId" required>
                          <%for(Subject subject : subjects) {%>
                            <% if(subject.getSubjectId() == classX.getSubjectId()) {%>
                              <option value="<%=subject.getSubjectId()%>" selected><%=subject.getSubjectName()%></option>
                            <%} else {%>
                              <option value="<%=subject.getSubjectId()%>"><%=subject.getSubjectName()%></option>
                            <%}%>
                          <%}%>
                        </select>
                      </div>
                  </div>
                  <div class="col-lg-5">
                    <div class="form-group">
                      <label>Classroom</label>
                      <input class="form-control is-invalid" type="text" placeholder="Enter Classroom" name="allocatedClassroom" value="<%=classX.getAllocatedClassroom()%>" required/>
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