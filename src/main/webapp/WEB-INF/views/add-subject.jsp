<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.model.*"%>
<%@page import="com.servlet.*"%>
<%@page import="com.util.*"%>
<!-- Include Header -->
<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param value="Add Subject" name="title"/>
</jsp:include>
<!-- Include Sidebar -->
<jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>

	<div class="page-wrapper">
        <div class="content">
          <div class="page-header">
            <div class="page-title">
              <h4>Subject ADD</h4>
              <h6>Create new subject</h6>
            </div>
          </div>

          <div class="card">
            <div class="card-body">
              <form action="add-subject" method="post" class="was-validated">
                <div class="row">
                  <div class="col-lg-9 col-sm-6 col-12">
                    <div class="form-group">
                      <label>Subject Name</label>
                      <input class="form-control is-invalid" type="text" placeholder="Enter Class Name" name="name" required/>
                    </div>
                  </div>
                  <div class="col-lg-9">
                    <div class="form-group">
                      <label>Subject Description</label>
                      <textarea class="form-control" placeholder="Enter Class Description" name="description" required></textarea>
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