var rmFile = function(fileName){
	$ajax({
		type:"post",
		url:"rmFile.do",
		dataType:"json",
		async : false,
		data:fileName,
		success:function(data){
			
		}
	});
}