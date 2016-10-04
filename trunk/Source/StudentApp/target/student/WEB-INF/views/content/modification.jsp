<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- my common function jsp -->
<%@ include file="../commons/commonjs.jsp" %>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<form:form action="modification.htm" modelAttribute="modification" class="form-horizontal" method="post" onsubmit="return validateModification();">
			
			<input type="hidden" name="app_id" id="app_id" value="${param['id']}"/>
			<input type="hidden" class="form-control" id="applicationReferenceNoModification" name="applicationReferenceNoModification"
				value="${modification.applicationReferenceNoModification}" placeholder="">
			<input type="hidden" class="form-control" id="versionIdMod" name="versionId" value="${modification.versionId}">
			<input type="hidden" class="form-control" id="modificationId" name="modificationId" value="${modification.modificationId}">
			<input type="hidden" class="form-control" id="createdDateTime" name="createdDateTime" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${modification.createdDateTime}" />" readonly placeholder="">
			<input type="hidden" class="form-control" id="createdUser" name="createdUser" value="${modification.createdUser}">
			
			<div class="row">
				<div class="x_panel">

					<div class="x_title">
						<h2>
							<spring:message code="application.form.label.modification" />
						</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<div class="form-group"></div>

						<div class="row">
						<div class="form-group">
							<label for="ownerName" class="col-md-2 control-label"><spring:message code="application.form.label.owner.name" /> :
							</label>
							<div class="col-md-10">
								<input type="text" class="form-control" id="ownerName" name="ownerName" value="${modification.ownerName}" placeholder="">
							</div>
							</div>

							<div class="form-group">
								<label for="address" class="col-md-2 control-label"><spring:message code="application.form.label.owner.address" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="address" name="address" value="${modification.address}" placeholder="">
								</div>
							</div>


							<div class="form-group">
								<label for="nic" class="col-md-2 control-label"><spring:message code="application.form.label.owner.nic" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="nic" name="nic" value="${modification.nic}" placeholder="">
								</div>
							</div>

							<div class="form-group">
								<label for="requestedDate" class="col-md-2 control-label"><spring:message
										code="application.form.label.date.requested" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="requestedDatemod" name="requestedDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${modification.requestedDate}" />" readonly placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="extendedDate" class="col-md-2 control-label"><spring:message
										code="application.form.lable.extended.date" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="extendedDatemod" name="extendedDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${modification.extendedDate}" />" readonly placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="landArea" class="col-md-2 control-label"><spring:message
										code="application.form.lable.land.area" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="landArea" name="landArea" value="${modification.landArea}"  placeholder="">
								</div>
							</div>
						</div>
					</div>

					<div class="x_title">
						<h5>
							<spring:message code="application.form.label.constructionInfo" />
						</h5>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<div class="form-group"></div>

						<div class="row">
						<div class="form-group">
							<label for="natureOfTheConstruction" class="col-md-2 control-label"><spring:message code="application.form.lable.nature" />:
							</label>
							<div class="col-md-10">
								<input type="text" class="form-control" id="natureOfTheConstruction" name="natureOfTheConstruction" value="${modification.natureOfTheConstruction}" placeholder="">
							</div>
							</div>

							<div class="form-group">
								<label for="constructionOwneraddress" class="col-md-2 control-label"><spring:message code="application.form.label.owner.address" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="constructionOwnerAddress" name="constructionOwnerAddress" value="${modification.constructionOwnerAddress}" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="noOfStairs" class="col-md-2 control-label"><spring:message code="application.form.lable.noOfStairs" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="noOfStairs" name="noOfStairs" value="${modification.noOfStairs}" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="surveyPlanNo" class="col-md-2 control-label"><spring:message code="application.form.lable.surveyPlanNo" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="surveyPlanNo" name="surveyPlanNo" value="${modification.surveyPlanNo}" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="extendedDate" class="col-md-2 control-label"><spring:message
										code="application.form.lable.date" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="constructionDate" name="constructionDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${modification.constructionDate}" />" readonly placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="surveysName" class="col-md-2 control-label"><spring:message
										code="application.form.lable.survey.name" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="surveysName" name="surveysName" value="${modification.surveysName}" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="regNo" class="col-md-2 control-label"><spring:message
										code="application.form.lable.reg.no" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="regNo" name="regNo" value="${modification.regNo}" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="other" class="col-md-2 control-label"><spring:message
										code="application.form.lable.other" />:
								</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="other" name="other" value="${modification.other}" placeholder="">
								</div>
							</div>
						</div>
					</div>

					<div class="x_title">
						<h5>
							<spring:message code="application.form.label.attachments" />
						</h5>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<div class="form-group"></div>

						<div class="row">
						<div class="form-group">
							<label for="natureOfTheConstruction" class="col-md-2 control-label"><spring:message code="application.form.lable.name" /> :
							</label>
							<div class="col-md-10">
								<input type="text" class="form-control" id="attachName" name="attachName" placeholder="">
							</div>
							<label for="applicationReceivedBy" class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message code="application.form.label.upload.file" />:</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="file" class="form-control" id="modificationAttachmentFile" name="modificationAttachmentFile" placeholder=""> 
							</div>
							<div class="col-md-1">
								<img onclick="modificationAttachTableEvent();"
									src="images/upload_button.png" height="40" style="cursor: pointer;" />
							</div>
							<div class="col-md-1">
								<img src="images/ajax-loader.gif" id="upload_modi_attach_progress" style="display: none;" />
							</div>
							<div class="col-md-1">
								<img src="images/right_green.jpg" id="upload_modi_attach_success" style="display: none;" />
							</div>
							
						</div>

						
						<div class="form-group">
						
							<div class="col-md-4"></div>
							<div class="col-md-6">
								<div class="table-responsive">
									<table id="attachmentTable" class="table table-bordered">
										<tr>
											<th><spring:message code="investigation.form.header.attachment.name" /></th>
											<th><spring:message code="investigation.form.header.attachment.attachments" /></th>
											<th></th>
										</tr>
										<c:forEach var="attachments" items="${modification.attachments}" varStatus="count">
											<tr>
<%-- 												<td> ${count.index+1}</td> --%>
												<td> 
													<input type="hidden" name="attachments[${count.index}].filePath" value="${attachments.filePath}" readonly/>
													<input type="text" name="attachments[${count.index}].documentName" value="${attachments.name}" readonly/>
													<input type="hidden" name="attachments[${count.index}].actualFileName" value="${attachments.actualFileName}" readonly/>
												  	<input type="hidden" name="attachments[${count.index}].versionId" value="${attachments.versionId}" readonly/>
												    <input type="hidden" name="attachments[${count.index}].fileId" value="${attachments.fileId}" readonly/>${attachmentFile.documentName}
												    <input type="hidden" name="attachments[${count.index}].attachmentType" value="${attachments.attachmentType}" readonly/>
												    
											     </td>
										      <td> <input type="text" name="attachments[${count.index}].actualFileName" value="${attachments.actualFileName}" readonly/></td>
<%-- 										      <td> <a target="_blank" href="fileDownload.htm?filePath=${attachments.filePath}">Download/View</a></td> --%>
										      <td><img src="images/remove_icon.png" onclick="deleteRow(this)" class="deleteCrossIcon" /></td>
											</tr>
										</c:forEach>
									</table>
								</div>
								<input type="hidden" name="noOfLocationMapAttachmentFiles" value="${size}" />
								<input type="hidden" name="tableListSize4" id="tableListSize4" value="${modification.attachments.size()}" />
								<input type="hidden" name="modificationAttachmentFilePath" id="modificationAttachmentFilePath" value="" />
							</div>
						
					</div>
							<div class="form-group">
							<div class="col-md-10">
								<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-8">
									<button class="btn btn-primary col-md-2 col-sm-2" type="submit">
										<i class="fa fa-refresh"></i>
										<spring:message code="application.form.btn.save" />
									</button>
									<button class="btn btn-primary col-md-2 col-sm-2" type="button" class="btn pull-right btn-success" onclick="clearLIValues()">
										<i class="fa fa-upload"></i>
										<spring:message code="application.form.btn.print" />
									</button>
									<button class="btn btn-primary col-md-2 col-sm-2" type="button" class="btn pull-right btn-success" onclick="clearLIValues()">
										<i class="fa fa-upload"></i>
										<spring:message code="application.form.btn.reset" />
									</button>

								</div>

							</div>
						</div>
						<div class="col-md-6">
								<div class="table-responsive">
									<table id="modificationTable" class="table table-bordered">
										<thead>
											<tr>
												<th>Ref No</th>
												<th>Owner Name</th>
												<th>Extended date</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="modifi" items="${modificationList}" varStatus="count">
														<tr>
															<td><input type="hidden" id="modifi[${count.index}].applicationReferenceNoModification" name="modifi[${count.index}].applicationReferenceNoModification" value="${modifi.applicationReferenceNoModification}"/>${modifi.applicationReferenceNoModification}</td>
															<td><input type="hidden" id="modifi[${count.index}].ownerName" name="modifi[${count.index}].ownerName" value="${modifi.ownerName}"/>${modifi.ownerName}</td>
															<td><input type="hidden" id="renewal[${count.index}].extendedDate" name="renewal[${count.index}].extendedDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${modifi.extendedDate}" />" /><fmt:formatDate pattern="dd/MM/yyyy" value="${modifi.extendedDate}" /></td>
															<td><a href="modification.htm?id=${param.id}&mid=${modifi.modificationId}"><img src="images/edit_icon.png" style="height:20px;"></a></td>
														</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					
				</div>

			</div>

			</form:form>
	</div>
</div>
<script>
$(function() {
  $("#requestedDatemod,#extendedDatemod,#constructionDate").datepicker({
    dateFormat: "dd/mm/yy",
    changeMonth: true,
    changeYear: true
    });
});


//add record to table and delete record
function deleteRow(btn) {
	var row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
  
}


var index = 0;
var tableNo = 1;
function insRow(id) {

  var name	 	= $("#attachName").val();
  var rootFile	= $("#modificationAttachmentFile").val();
  var filePath = $("#modificationAttachmentFilePath").val();
  console.log("+++++++++++++++++++++++++++"+filePath);

//   if (name == "") {
//     showError("#natureOfTheConstruction", "");
//     return false;
//   }
//   var index = document.getElementById("affectedPeopleListSize").value;
//   if(index==""){index=0}
//   document.getElementById("affectedPeopleListSize").value=parseInt(index)+1;

  var filas = document.getElementById(id).rows.length;
  var mod = document.getElementById(id).insertRow(filas);
  index = document.getElementById("attachmentTable").rows.length - 2;

  var nameAttach = mod.insertCell(0);
  var fileAttach = mod.insertCell(1);
  var del = mod.insertCell(2);
  
  nameAttach.innerHTML = "<input type='text' value='"+name+"' name='attachments["+index+"].name' class='form-control' readonly/>"
  fileAttach.innerHTML = "<input type='text' value = '"+ rootFile+"'  name='attachments["+index+"].actualFileName' class='form-control' readonly/>"
  del.innerHTML = '<img src="images/remove_icon.png" onclick="deleteRow(this)"  class="deleteCrossIcon"/>';

}

function validateModification() {

  var ownerName = $("#ownerName").val();

  if (ownerName == "") {
    showError("#ownerName", "<spring:message code='application.message.empty.name' />");
    return false;
  } 
  return true;
}

function modificationAttachTableEvent(){
  console.log("--------***");
  index = document.getElementById("attachmentTable").rows.length - 2;

	console.log("--------"+index);
  
  insRow('attachmentTable');
  uploadFile('modificationAttachmentFile', 'attachments_'+index+'_filePath', 'upload_modi_attach', 'MODI_ATTACH');
}


</script>







