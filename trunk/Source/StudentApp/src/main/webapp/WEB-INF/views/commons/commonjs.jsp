<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript">

/* ----------------------------------------- create dynamic drop downs ------------------------------------------------- */

/*
$( document ).ready(function() {
  var lang='${sessionScope.SESSION_APP_LANG}'; 
  if(lang=='si'){
    convertLanguage('sinhala'); 
    }else if (lang=='ta'){
      convertLanguage('tamil'); 
      }else{
        convertLanguage('english');         
      }
    
});*/


function getLocalAuthorities(){

	var districtId = $("#districtId").val();
	
	$.ajax({
	  type: "GET",
	  contentType: "application/json",
      dataType: "json",
	  url: "getLocalAuthorityByDistrict.do",
	  data: {"districtId":districtId},
	  success: function(data){
		  //alert(response);
		  $("#localGovAuthoId option").remove();
		  $('#localGovAuthoId').append($("<option></option>").attr("value","0").text("<spring:message code='application.message.select.local.authority' />"));
		  for (var i=0; i<data.length; i++){
			  //alert(data[i].localAuthorityDesc);
			  $('#localGovAuthoId').append($("<option></option>")
		         .attr("value",data[i].localAuthorityId)
		         .text(data[i].localAuthorityDesc)); 
		  }
	  },
	  error: function(data){
	  	alert("error");
	  }
	});
	
	$.ajax({
	  type: "GET",
	  contentType: "application/json",
      dataType: "json",
	  url: "getDistrictSecretariatByDistrict.do",
	  data: {"districtId":districtId},
	  success: function(data){
		  //alert(response);
		  $("#divSecId option").remove();
		  $('#divSecId').append($("<option></option>").attr("value","0").text("<spring:message code='application.message.select.district.sectratariat' />"));
		  for (var i=0; i<data.length; i++){
			  //alert(data[i].localAuthorityDesc);
			  $('#divSecId').append($("<option></option>")
		         .attr("value",data[i].districtSecId)
		         .text(data[i].districtSec)); 
		  }
	  },
	  error: function(data){
	  	alert("error");
	  }
	});
}

function getGramaNiladaries(){

	var districtSecId = $("#divSecId").val();
	
	$.ajax({
	  type: "GET",
	  contentType: "application/json",
      dataType: "json",
	  url: "getGramaNiladariDivByDistrictSec.do",
	  data: {"districtSecId":districtSecId},
	  success: function(data){
		  //alert(response);
		  $("#gramaDivId option").remove();
		  $('#gramaDivId').append($("<option></option>").attr("value","0").text("<spring:message code='application.message.select.grama.niladari' />"));
		  for (var i=0; i<data.length; i++){
			  //alert(data[i].localAuthorityDesc);
			  $('#gramaDivId').append($("<option></option>")
		         .attr("value",data[i].gnDivId+"_"+data[i].gnDivNo)
		         .text(data[i].gnDivDesc)); 
		  }

		  $("#apGnDivisionId option").remove();
		  $('#apGnDivisionId').append($("<option></option>").attr("value","0").text("<spring:message code='application.message.select.grama.niladari' />"));
		  for (var i=0; i<data.length; i++){
			  //alert(data[i].localAuthorityDesc);
			  $('#apGnDivisionId').append($("<option></option>")
		         .attr("value",data[i].gnDivId+"_"+data[i].gnDivNo)
		         .text(data[i].gnDivDesc)); 
		  }
	  },
	  error: function(data){
	  	alert("error");
	  }
	});
}

function setGramaDivisionNo(){
	var value = $("#gramaDivId").val();
	var value_1 = $("#apGnDivisionId").val();

	$("#gramaNo").val(value.split("_")[1]);
	$("#apGnDivisionNo").val(value_1.split("_")[1]);
}


function getUserDesignation(selectFieldId,displayFieldId){
	var userID = $("#"+selectFieldId).val();	
	$.ajax({
	  type: "GET",
	  contentType: "application/json",
      dataType: "text",
	  url: "getUserDesignation.do",
	  data: {"userId":userID},
	  success: function(data){
		  // alert(data);
		  $("#"+displayFieldId).val(data);
	  },
	  error: function(data){
	  	alert("error");
	  }
	});
}

/* ----------------------------------------- upload files ajax ------------------------------------------------- */

//function for check the upload is supported for using browser
function supportAjaxUploadWithProgress() {
	  return supportFileAPI() && supportAjaxUploadProgressEvents() && supportFormData();
	     function supportFileAPI() {
	       var fi = document.createElement('INPUT');
	       fi.type = 'file';
	       return 'files' in fi;
	     };
	    function supportAjaxUploadProgressEvents() {
	      var xhr = new XMLHttpRequest();
	     return !! (xhr && ('upload' in xhr) && ('onprogress' in xhr.upload));
	    };
	    function supportFormData() {
	      return !! window.FormData;
	    }
	}

//to upload the external reports for blanks
function uploadFile(fileId, hiddenId, htmlId, filePrefix){
	  //check the browser
	  if(!supportAjaxUploadWithProgress){
		  alert("Please update your browser to upload");
		  return false;
	  }
	
	  var xhr = new XMLHttpRequest();
	  var fileInput = document.getElementById(fileId);
	  var file = fileInput.files[0];
	  
	  //validate upload
	  var filePath = fileInput.value;
	  var extension = filePath.split(".").pop().trim();
	  if(filePath == ''){
	    showError("#"+fileId,"<spring:message code='application.message.empty.file.upload' />");
		  //alert("please select a file before upload");
		  return false;
	  }else if(file.size > 20*1024*1024){
	    showError("#"+fileId,"<spring:message code='application.message.file.size.is.large' />");
		//  alert("file size is too large to upload");
		  return false;
	  }
	  
	  //show ajax upload gif
	  $("#"+htmlId+"_progress").show(100);
	  
	  var formData = new FormData();
	  formData.append('reportFile', file);
	  formData.append('filePrefix', filePrefix);
	  xhr.open('POST', 'uploadFile.htm', true);
	  xhr.send(formData);
	  
	  xhr.onreadystatechange=function()
	  {
	  	if (xhr.readyState==4 && xhr.status==200)
	    {
	    	//alert(xhr.responseText);
			$("#"+hiddenId).val(xhr.responseText);
			$("#"+htmlId+"_progress").hide(100);
	    	$("#"+htmlId+"_success").show(200);
	    	$("#"+htmlId+"_delete").show(200);
	    }
	  }
	  
}

function deleteFile(fileId, fileName, hiddenId, versionId, divId) {

  //   var $el = $("#" + hiddenId);
   //  $el.wrap('<form>').closest('form').get(0).reset();
   //  $el.unwrap();
     $("#" + fileName).val("");
     $("#" + hiddenId).val("");
     $("#" + fileId).val("");   
     if ($("#" + versionId).val() == "") {
       $("#" + divId + "_success").hide()
       $("#" + divId + "_delete").hide()
     } else {
       $("#" + divId).hide();
     }
     $("#" + versionId).val("");
   }
//to upload the external reports for blanks
function uploadFileAttachments(fileId,htmlId,fileldName, filePrefix,tableID,attachmentType,filetype,tableListSize) {
  // check the browser
  if (!supportAjaxUploadWithProgress) {
    alert("Please update your browser to upload");
    return false;
  }
	
  var xhr = new XMLHttpRequest();
  var fileInput = document.getElementById(fileId);
  
  var file = fileInput.files[0];

  // validate name
  var docName = document.getElementById(fileldName).value;
  if(docName.length<1){
    showError("#"+fileldName,"<spring:message code='application.message.empty.name' />");
    return false;
    }
   
  // validate upload
  var filePath = fileInput.value;
  var extension = filePath.split(".").pop().trim();
  
  if (filePath == '') {
    showError("#"+fileId,"<spring:message code='application.message.empty.file.upload' />");
   // alert("please select a file before upload");
    return false;
  } else if (file.size > 20 * 1024 * 1024) {
    showError("#"+fileId,"<spring:message code='application.message.file.size.is.large' />");
  //  alert("file size is too large to upload");
    return false;
  }

  // show ajax upload gif
  $("#" + htmlId + "_progress").show(100);

  var formData = new FormData();
  formData.append('reportFile', file);
  formData.append('filePrefix', filePrefix);
  xhr.open('POST', 'uploadFile.htm', true);
  xhr.send(formData);

  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      // alert(xhr.responseText);
//      $("#" + hiddenId).val(xhr.responseText);
   //   $("#" + htmlId + "_progress").hide(100);
     // $("#" + htmlId + "_success").show(200);
      
      var documentName = xhr.responseText;//document.getElementById('accessRootFilePath').value;
   //   var docName = document.getElementById(fileldName).value;
    //  var accessRootFile =  document.getElementById('docName').value;
      if (documentName != '' || documentName != null) {
        var index = document.getElementById(tableListSize).value;
        if(index==""){index=0}
        document.getElementById(tableListSize).value=parseInt(index)+1;
        var filas = document.getElementById(tableID).rows.length;
        var x = document.getElementById(tableID).insertRow(filas);
        var q = x.insertCell(0);
        var w = x.insertCell(1);
        var y = x.insertCell(2);
        //var z = x.insertCell(3);

        //alert(value);
       // q.innerHTML = parseInt(index) + 1;
        q.innerHTML = docName;
        w.innerHTML = '<input type="hidden" name="'+filetype+'['+index+'].filePath" value="'+documentName+'" readonly/>'
                + '<input type="hidden" name="'+filetype+'['+index+'].actualFileName" value="'+documentName+'" readonly/>'
                + '<input type="hidden" name="'+filetype+'['+index+'].documentName" value="'+docName+'" readonly/>'
                + '<input type="hidden" name="'+filetype+'['+index+'].versionId" value="" readonly/>'
                + '<input type="hidden" name="'+filetype+'['+index+'].fileId" value="" readonly/>'
                + '<input type="hidden" name="'+filetype+'['+index+'].attachmentType" value="'+attachmentType+'" readonly/>'
                + '<a target="_blank" href="fileDownload.htm?filePath=' + documentName + '">Download/View</a>';
        y.innerHTML = '<img src="images/remove_icon.png" onclick="deleteRow(this)"   class="deleteCrossIcon"/>';

        document.getElementById(fileId).value = '';
        document.getElementById(fileldName).value = '';
      }
      $("#" + htmlId + "_progress").hide(100);
      
    }
  }  
}

/* ----------------------------------------- validate numbers only ------------------------------------------------- */

$(function(){

	$(".numberOnly").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
	
});

/* ----------------------------------------- common redirects ------------------------------------------------- */

function redirect(location){
	window.location = location;
}

function openOnWindow(location){
  window.open(
    location,
    '_blank' ,
    "width=900, height=600"
  );
}

/* ----------------------------------------- validate styles ------------------------------------------------- */

$(function(){
  $("input").change(function(){
    $(this).removeClass("parsley-error");
  });
  $("select").change(function(){
    $(this).removeClass("parsley-error");
  });
  $("textarea").change(function(){
    $(this).removeClass("parsley-error");
  });
});

function showError(elementId, message){
  $(elementId).addClass("parsley-error");
  $(elementId).attr("placeholder", message);
  toastr.warning("<spring:message code='application.common.message.mandatory.field' />");
  $("html, body").delay(100).animate({scrollTop: $(elementId).offset().top }, 1500);
}

function showErrorBelow(elementId, message){
  $(elementId).addClass("parsley-error");
  $(elementId).after('<span class="parsley-error span-error" style="color:red;">'+message+'</span>');
  setTimeout(function() {
    $(".span-error").hide(500)
  }, 4000);
  toastr.warning("<spring:message code='application.common.message.mandatory.field' />");
  $("html, body").delay(100).animate({scrollTop: $(elementId).offset().top }, 1500);
}

function showTableError(elementId, message){
  $(elementId).addClass("parsley-error");
  $(elementId).html(message);
  toastr.warning("<spring:message code='application.common.message.mandatory.field' />");
  $("html, body").delay(100).animate({scrollTop: $(elementId).offset().top }, 1500);
}

function showAlreadyAdded(elementId, message){
	  $(elementId).addClass("parsley-error");
	  $(elementId).html(message);
	  toastr.warning("<spring:message code='application.common.message.field.already.added' />");
	  $("html, body").delay(100).animate({scrollTop: $(elementId).offset().top }, 1500);
	}
/* ----------------------------------------- messages - toasters ------------------------------------------------- */

$(function(){
	toastr.options = {
	  "closeButton": true,
	  "debug": false,
	  "newestOnTop": true,
	  "progressBar": false,
	  "positionClass": "toast-top-right",
	  "preventDuplicates": true,
	  "onclick": null,
	  "showDuration": "3000",
	  "hideDuration": "1000",
	  "timeOut": "8000",
	  "extendedTimeOut": "1000",
	  "showEasing": "swing",
	  "hideEasing": "linear",
	  "showMethod": "fadeIn",
	  "hideMethod": "fadeOut"
	}
});

function showIsuruToast(){
	toastr.info('Are you the six fingered man?');
	toastr.warning('My name is Inigo Montoya. You Killed my father, prepare to die!');
	toastr.success('Have fun storming the castle!', 'Miracle Max Says');
	toastr.error('I do not think that word means what you think it means.', 'Inconceivable!');
}

function getParam(name){
  var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
  if (results==null){
     return null;
  }
  else{
     return results[1] || 0;
  }
}

$(function(){
  if(getParam("msg") == "suc"){
    toastr.success("<spring:message code='application.common.message.success.save' />");
  }else if(getParam("msg") == "err"){
    toastr.error("<spring:message code='application.common.message.error.save.message' />", "<spring:message code='application.common.message.error.save.title' />");
  }
});

function validatePhone (txtPhone,massage) { 
  var a = document.getElementById(txtPhone).value;  
  var filter = /^[0-9-+]+$/;  
  if (filter.test(a)) { 
      return true; 
  } 
  else {     
    document.getElementById(txtPhone).value="";
    $("#"+txtPhone).addClass("parsley-error");
    $("#"+txtPhone).attr("placeholder",massage); 
    toastr.warning(massage+"<br/><spring:message code='application.common.message.mandatory.field' />");
    $("html, body").delay(100).animate({scrollTop: $("#"+txtPhone).offset().top }, 1500); 
    return false;  
  } 
}


function validateNumber(txtPhone,massage) { 
  var a = document.getElementById(txtPhone).value;  
  var filter = /^\d{0,10000}(\.\d{0,2})?$/;  
  if (filter.test(a)) { 
      return true; 
  } 
  else {     
    document.getElementById(txtPhone).value="";
    $("#"+txtPhone).addClass("parsley-error");
    $("#"+txtPhone).attr("placeholder",massage); 
    toastr.warning(massage+"<br/><spring:message code='application.common.message.mandatory.field' />");
    $("html, body").delay(100).animate({scrollTop: $("#"+txtPhone).offset().top }, 1500); 
    return false;  
  } 
}

function currencyFormat(n) {
  return  parseFloat(n).toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,");
}
function currencyFormatR(n) {
  return  parseFloat(n).toFixed(2).replace(/(\d)(?=(\d{3})+)/g, "1");
}

function clearField(fieldId){
  $('#'+fieldId).val('');
}
/*
function convertLanguage(lang){
  if(lang == "sinhala"){
   /// $("input,textarea").removeClass( "TamilFont SinhalaFont" ).addClass( "SinhalaFont" );
  }else if(lang == "tamil"){
    $("input,textarea").removeClass( "TamilFont SinhalaFont" ).addClass( "TamilFont" );
  }else{
    $("input,textarea").removeClass( "SinhalaFont TamilFont" ); 
  }
  //alert(lang);
}
*/

function getParameterByName(name, url) {
  if (!url) url = window.location.href;
  name = name.replace(/[\[\]]/g, "\\$&");
  var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
      results = regex.exec(url);
  if (!results) return null;
  if (!results[2]) return '';
  return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function changeSystemLanguage(lang){ 	 

     	$.ajax({
    	  type: "GET",
    	  contentType: "application/json",
          dataType: "text",
    	  url: "changeLanguage.do",
    	  data: {"langType":lang},
    	  success: function(data){	
    	     var url=window.location.href  ;
           var res = url.split("id=");
           if(res.length>1){
          	 var val=res[1].split("&");       
             window.location="?id="+val[0]+"&lang="+lang; 
             }else{
    	    window.location="?lang="+lang; 
             }
    	  },
    	  error: function(data){
    	  	alert("error");
    	  }
    	});
       
}

function changeLanguage(lang){

  var id =getParameterByName(id);

  
	$.ajax({
	  type: "GET",
	  contentType: "application/json",
      dataType: "text",
	  url: "changeLanguage.do",
	  data: {"langType":lang},
	  success: function(data){	
	    if(id== null){
	      window.location="?lang="+data;
	    }else{
	      window.location="?id="+id+"&lang="+data;
	    }	 
	   
	  },
	  error: function(data){
	  	alert("error");
	  }
	});
}
</script>