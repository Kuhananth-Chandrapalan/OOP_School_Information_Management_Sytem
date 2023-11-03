<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<%! @SuppressWarnings("unchecked") %>
<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Add Subject" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
		<div id="msgbox-area" class="msgbox-area"></div>
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Subject List</h4>
              <h6>Manage Subjects</h6>
            </div>
            <div class="page-btn">
              <a href="add-subject" class="btn btn-added"
                ><img src="assets/img/icons/plus.svg" alt="img" />Add
                Subject</a
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
                        <input type="text" placeholder="Enter Subject Id" />
                      </div>
                    </div>
                    <div class="col-lg-2 col-sm-6 col-12">
                      <div class="form-group">
                        <input type="text" placeholder="Enter Subject Name" />
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
                      <th>Subject Id</th>
                      <th>Subject Name</th>
                      <th>Subject Description</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");

                      for (Subject subject : subjects) {
                    %>
                    <tr>
                      <td><%=subject.getSubjectId()%></td>
                      <td><%=subject.getSubjectName()%></td>
                      <td><%=subject.getDescription()%></td>
                      <td>
                        <a class="me-3" href="modify-subject?id=<%=subject.getSubjectId()%>">
                          <img src="assets/img/icons/edit.svg" alt="img" />
                        </a>
                        <a class="me-3" href="delete-subject?id=<%=subject.getSubjectId()%>" onclick="return confirm('Are you sure you want to delete this subject?');">
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