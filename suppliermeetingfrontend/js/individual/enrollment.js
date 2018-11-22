$(document).ready(function()
{
	$('#submit_btn').click(function()
	{
		var supplierName = $('#supplier_name_txt').val();
		var attendeeName = $('#attendee_name_txt').val();
		var cellPhone = $('#cell_phone_txt').val();			
		var title = $('#title_txt').val();
		var gender = $("#gender option:selected").val();
		var arriveTime = "";
		var isDinner = "";
		var isVisited = $("#arrive_shuttle option:selected").val();
		var isSelfDrive = $("#is_self_drive option:selected").val();
		var shuttle = $("#leave_shuttle option:selected").val();
		var content = "{'cellPhoneNum':'"+cellPhone+"','fullName':'"+attendeeName+"','title':'"+title+"','gender':'"+gender+"','supplierCode':'"+isDinner+"','supplierName':'"+supplierName+"','estimateArriveTime':'"+arriveTime+"','isVisited':'"+isVisited+"','isSelfDrive':'"+isSelfDrive+"','shuttleDestination':'"+shuttle+"','meetingSeatNum':'','dinnerSeatNum':'','comment':''}";

		$.ajax(
		{
			async : false,
			cache: false,
			url: one_enrollment_url + "/" + cellPhone,
			type: 'GET',
			success : function(data, status, xhr)
			{
				var info = $(data).find("enrollment");
				if(info.length > 0)
				{
					$('#resultpanel').text(cellPhone + " 不能重复报名。");
				}
				else
				{
					insert_enrollment(content);
				}
			},
			error : function(xhr, status, error)
			{
				alert("Fail - " + xhr.statusText + " - " + xhr.status + " - " + error);
			}
		});
	});
});

function insert_enrollment(content)
{
	var attendeeName = $('#attendee_name_txt').val();
	$.ajax(
	{
		url: insert_enrollment_url,
		type: 'PUT',
		data: "content="+content,
		success: function(data)
		{
			if (data.length > 0)
			{
				if("SUCCESS" == data)
				{
					$('#resultpanel').text(attendeeName + " 本次报名成功！");
				}
				else
				{
					$('#resultpanel').text("本次签到失败，请重试一下。");
				}
			}
		}
	});
}