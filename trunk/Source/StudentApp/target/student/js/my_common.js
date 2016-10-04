function getLocalAuthorities() {

  var districtId = $("#districtId").val();

  $.ajax({
    type: "GET",
    contentType: "application/json",
    dataType: "json",
    url: "getLocalAuthorityByDistrict.do",
    data: {
      "districtId": districtId
    },
    success: function(data) {
      // alert(response);
      $("#localGovAuthoId option").remove();
      $('#localGovAuthoId').append(
              $("<option></option>").attr("value", "0").text(
                      "<spring:message code='application.message.select.local.authority' />"));
      for (var i = 0; i < data.length; i++) {
        // alert(data[i].localAuthorityDesc);
        $('#localGovAuthoId').append(
                $("<option></option>").attr("value", data[i].localAuthorityId).text(data[i].localAuthorityDesc));
      }
    },
    error: function(data) {
      alert("error");
    }
  });

  $.ajax({
    type: "GET",
    contentType: "application/json",
    dataType: "json",
    url: "getDistrictSecretariatByDistrict.do",
    data: {
      "districtId": districtId
    },
    success: function(data) {
      // alert(response);
      $("#divSecId option").remove();
      $('#divSecId').append(
              $("<option></option>").attr("value", "0").text(
                      "<spring:message code='application.message.select.district.sectratariat' />"));
      for (var i = 0; i < data.length; i++) {
        // alert(data[i].localAuthorityDesc);
        $('#divSecId').append($("<option></option>").attr("value", data[i].districtSecId).text(data[i].districtSec));
      }
    },
    error: function(data) {
      alert("error");
    }
  });
}

function getGramaNiladaries() {

  var districtSecId = $("#divSecId").val();

  $.ajax({
    type: "GET",
    contentType: "application/json",
    dataType: "json",
    url: "getGramaNiladariDivByDistrictSec.do",
    data: {
      "districtSecId": districtSecId
    },
    success: function(data) {
      // alert(response);
      $("#gramaDivId option").remove();
      $('#gramaDivId').append(
              $("<option></option>").attr("value", "0").text(
                      "<spring:message code='application.message.select.grama.niladari' />"));
      for (var i = 0; i < data.length; i++) {
        // alert(data[i].localAuthorityDesc);
        $('#gramaDivId').append($("<option></option>").attr("value", data[i].gnDivId).text(data[i].gnDivDesc));
      }
    },
    error: function(data) {
      alert("error");
    }
  });
}

function supportAjaxUploadWithProgress() {
  return supportFileAPI() && supportAjaxUploadProgressEvents() && supportFormData();
  function supportFileAPI() {
    var fi = document.createElement('INPUT');
    fi.type = 'file';
    return 'files' in fi;
  }
  ;
  function supportAjaxUploadProgressEvents() {
    var xhr = new XMLHttpRequest();
    return !!(xhr && ('upload' in xhr) && ('onprogress' in xhr.upload));
  }
  ;
  function supportFormData() {
    return !!window.FormData;
  }
}

// to upload the external reports for blanks
function uploadFile(fileId, hiddenId, htmlId, filePrefix) {
  // check the browser
  if (!supportAjaxUploadWithProgress) {
    alert("Please update your browser to upload");
    return false;
  }

  var xhr = new XMLHttpRequest();
  var fileInput = document.getElementById(fileId);
  var file = fileInput.files[0];

  // validate upload
  var filePath = fileInput.value;
  var extension = filePath.split(".").pop().trim();
  if (filePath == '') {
    alert("please select a file before upload");
    return false;
  } else if (file.size > 20 * 1024 * 1024) {
    alert("file size is too large to upload");
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
      $("#" + hiddenId).val(xhr.responseText);
      $("#" + htmlId + "_progress").hide(100);
      $("#" + htmlId + "_success").show(200);
    }
  }
  
}

//to upload the external reports for blanks
function uploadFileAttachments(fileId, hiddenId, htmlId, filePrefix) {
  // check the browser
  if (!supportAjaxUploadWithProgress) {
    alert("Please update your browser to upload");
    return false;
  }

  var xhr = new XMLHttpRequest();
  var fileInput = document.getElementById(fileId);
  var file = fileInput.files[0];

  // validate upload
  var filePath = fileInput.value;
  var extension = filePath.split(".").pop().trim();
  if (filePath == '') {
    alert("please select a file before upload");
    return false;
  } else if (file.size > 20 * 1024 * 1024) {
    alert("file size is too large to upload");
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
      $("#" + htmlId + "_progress").hide(100);
      $("#" + htmlId + "_success").show(200);
      
      var documentName = xhr.responseText;//document.getElementById('accessRootFilePath').value;
      var docName = fileInput;//document.getElementById('docName').value;
      var accessRootFile = document.getElementById('docName').value;
      if (documentName != '' || documentName != null) {
        var index = document.getElementById('documentsListTbl').rows.length - 1;

        var filas = document.getElementById('documentsListTbl').rows.length;
        var x = document.getElementById('documentsListTbl').insertRow(filas);
        var q = x.insertCell(0);
        var w = x.insertCell(1);
        var y = x.insertCell(2);
        var z = x.insertCell(3);

        //alert(value);
        q.innerHTML = index + 1;
        w.innerHTML = docName;
        y.innerHTML = '<input type="hidden" name="attachmentFileList['+index+'].filePath" value="'+documentName+'" readonly/>'
                + '<input type="hidden" name="attachmentFileList['+index+'].actualFileName" value="'+documentName+'" readonly/>'
                + '<input type="hidden" name="attachmentFileList['+index+'].documentName" value="'+docName+'" readonly/>'
                + '<input type="hidden" name="attachmentFileList['+index+'].versionId" value="" readonly/>'
                + '<input type="hidden" name="attachmentFileList['+index+'].fileId" value="" readonly/>'
                + '<a target="_blank" href="fileDownload.htm?filePath=' + documentName + '">Download/View</a>';
        z.innerHTML = '<button onclick="deleteRow(this)" class="btn btn-primary">Delete</button>';

        document.getElementById('accessRootFilePath').value = '';
      }
      
    }
  }  
}