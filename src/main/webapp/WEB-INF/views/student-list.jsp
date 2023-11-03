<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<%! @SuppressWarnings("unchecked") %>
<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Students" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
		<div id="msgbox-area" class="msgbox-area"></div>
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Student List</h4>
              <h6>Manage Students</h6>
            </div>
            <div class="page-btn">
              <a href="add-student" class="btn btn-added"
                ><img src="assets/img/icons/plus.svg" alt="img" />Add
                Student</a
              >
            </div>
          </div>

          <div class="card">
            <div class="card-body">
              <div class="table-top">
                <div class="search-set">
                  <div class="search-path">
                    <a class="btn btn-filter" id="filter_search">
                      <img src="assets/img/icons/filter.svg" alt="img" />
                      <span
                        ><img src="assets/img/icons/closes.svg" alt="img"
                      /></span>
                    </a>
                  </div>
                  <div class="search-input">
                    <a class="btn btn-searchset"
                      ><img src="assets/img/icons/search-white.svg" alt="img"
                    /></a>
                  </div>
                </div>
              </div>

              <div class="card" id="filter_inputs">
                <div class="card-body pb-0">
                  <div class="row">
                    <div class="col-lg-2 col-sm-6 col-12">
                      <div class="form-group">
                        <input type="text" placeholder="Enter Student Id" />
                      </div>
                    </div>
                    <div class="col-lg-2 col-sm-6 col-12">
                      <div class="form-group">
                        <input type="text" placeholder="Enter Student Name" />
                      </div>
                    </div>
                    <div class="col-lg-2 col-sm-6 col-12">
                      <div class="form-group">
                        <input type="text" placeholder="Enter Phone" />
                      </div>
                    </div>
                    <div class="col-lg-2 col-sm-6 col-12">
                      <div class="form-group">
                        <input type="text" placeholder="Enter Email" />
                      </div>
                    </div>
                    <div class="col-lg-1 col-sm-6 col-12 ms-auto">
                      <div class="form-group">
                        <a class="btn btn-filters ms-auto"
                          ><img
                            src="assets/img/icons/search-whites.svg"
                            alt="img"
                        /></a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="table-responsive">
                <table class="table datanew">
                  <thead>
                    <tr>
                      <th>Student ID</th>
                      <th>Student Name</th>
                      <th>Email</th>
                      <th>Phone</th>
                      <th>Address</th>
                      <th>DOB</th>
                      <th>Gender</th>
                      <th>Bio</th>
                      <th>Added At</th>
                      <th>Updated At</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% List<Student> students = (List<Student>)request.getAttribute("students");
								
                      for(Student student : students) {
                    %>
                    <tr>
                      <td><%=student.getStudentId()%></td>
                      <td class="productimgname">
                        <a href="javascript:void(0);" class="product-img">
                          <img
                            src="image/student/profile/<%=student.getProfilePic()%>"
                            alt="student"
                          />
                        </a>
                          <%=student.getFirstName()%> <%=student.getLastName()%>
                      </td>
                      <td><%=student.getEmail()%></td>
                      <td><%=student.getPhoneNumber()%></td>
                      <td><%=student.getAddress()%></td>
                      <td><%=student.getDateOfBirth()%></td>
                      <td><%=student.getGender()%></td>
                      <td><%=student.getBio()%></td>
                      <td><%=student.getCreatedAt()%></td>
                      <td><%=student.getUpdatedAt()%></td>
                      <td>
                        <a class="me-3" href="modify-student?id=<%=student.getStudentId()%>">
                          <img src="assets/img/icons/edit.svg" alt="img" />
                        </a>
                        <a class="me-3 confirm-text" href="delete-student?id=<%=student.getStudentId()%>" onclick="return confirm('Are you sure you want to delete this student?');">
                          <img src="assets/img/icons/delete.svg" alt="img" />
                        </a>
                      </td>
                    </tr>
                    <% } %>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

<!-- Include Footer -->
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
<script type="text/javascript">
	<%
	if(request.getParameter("delete") != null){
		String delete = request.getParameter("delete");
		if(delete.equals("success")) {
			out.print("msgboxbox.show('Successfully deleted from the database');");
		} else if(delete.equals("fail")) {
			out.print("msgboxbox.show('Failed to delete from the database');");
		}
	}
	if(request.getParameter("modify") != null){
		String modify = request.getParameter("modify");
		if(modify.equals("success")) {
			out.print("msgboxbox.show('Successfully modified');");
		} else if(modify.equals("fail")) {
			out.print("msgboxbox.show('Failed to modify');");
		}	
	}
	if(request.getParameter("add") != null){
		String add = request.getParameter("add");
		if(add.equals("success")) {
			out.print("msgboxbox.show('Successfully Added');");
		} else if(add.equals("fail")) {
			out.print("msgboxbox.show('Failed to add');");
		}
	}
	%>	
</script>