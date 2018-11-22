$(document).ready(function(){
	var cellPhoneNum = "";
	$('#select_enrollment_btn').click(function(){		
		cellPhoneNum = $('#cell_phone_num_txt').val();
		if (cellPhoneNum.length > 0){
			$.get(one_enrollment_url+"/"+cellPhoneNum, function(data){
				var info = $(data).find("enrollment");
				if (info.length > 0){
					$('#cell_phone_num_label').text(info.children("cellPhoneNum").text());
					$('#full_name_label').text(info.children("fullName").text());
					$('#supplier_name_label').text(info.children("supplierName").text());
					$('#checkin_status_label').text(info.children("comment").text());
				}
			});
		}
	});
	
	$('#checkin_btn').click(function(){
		if (cellPhoneNum.length > 0){
			var content = "{'cellPhoneNum':'"+cellPhoneNum+"','fullName':'','title':'','gender':'','supplierCode':'','supplierName':'','estimateArriveTime':'','isVisited':'','isSelfDrive':'','shuttleDestination':'','meetingSeatNum':'','dinnerSeatNum':'','comment':'已签到'}";
			$.ajax(
			{
				url: checkin_url,
				type: "POST",
				data: "content="+content,
				success: function(data)
				{
					if (data.length > 0)
					{
						if("SUCCESS" == data)
						{
							$('#info').text("签到成功。");
						}
						else
						{
							alert("签到失败。");
						}
					}
				}
			});
		}
	});
});