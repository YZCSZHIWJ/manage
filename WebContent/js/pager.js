
function nextPage(requesturl,pageIndex,pageNumber){
	
	if(pageIndex > 0 && pageIndex <= pageNumber){
	 pageIndex = pageIndex + 1;
	 gotoPager(requesturl,pageIndex,pageNumber);
		
	}
}

function proPage(requesturl,pageIndex,pageNumber){
	if(pageIndex > 0 && pageIndex <= pageNumber){
		pageIndex = pageIndex - 1;
		this.gotoPager(requesturl,pageIndex,pageNumber);
	}
	
}

function gotoPager(requesturl,pageIndex,pageNumber){

	if(pageIndex > 0 && pageIndex <= pageNumber){
		var url = requesturl;
		if(requesturl.indexOf("?") > -1){
			url = requesturl+"&pageIndex="+pageIndex;
		}else{
			url = requesturl+"?pageIndex="+pageIndex;
		}
		
		window.location.href = url;
	}
}

function goPager(requesturl,currentPageIndex,pageNumber){
	
	gotoPager(requesturl,currentPageIndex,pageNumber);
	
}
function createPageBar2(pageNumber,pageSize,pageIndex,total,callback,viewedNum,param){
	var sb = [];
	sb.push('<ul class="pagebar">共'+total+'条记录,每页'+pageSize+'条,当前第'+pageIndex+'页');
	if(pageNumber<=1){
		sb.push('</ul>');
		return sb.join('');
	}	
	if (param==null)
		param="";
	if(viewedNum==null)
		viewedNum = 5;
	var firstNumber = pageIndex-Math.floor(viewedNum/2);
	
	if(firstNumber<1)
		firstNumber = 1;
	var lastNumber = firstNumber+viewedNum-1;
	if(lastNumber>pageNumber)
		lastNumber = pageNumber;
	while(firstNumber>1 && (lastNumber-firstNumber+1)<viewedNum){
		firstNumber--;
	}
	var curl = '';
	if(pageIndex>1){
	    curl = callback + '(\''+param+'\',' + (1) + ',' + pageNumber+')';
	    sb.push('<li><a href="javascript:'+curl+'">首页</a></li>');
		curl = callback + '(\''+param+'\',' + (pageIndex-1) + ',' + pageNumber+')';
		sb.push('<li><a href="javascript:'+curl+'">上一页</a></li>');
	}
	for(var i=firstNumber;i<=lastNumber;i++){
		curl = callback + '(\''+param+'\',' + i + ',' + pageNumber+')';
		if(i==pageIndex){
			sb.push('<li class="ch"> <a href="javascript:'+curl+'">'+i+'</a></li>');
		}else{
			sb.push('<li> <a href="javascript:'+curl+'">'+i+'</a></li>');
		}
	}
	if(pageIndex<pageNumber){
		curl = callback + '(\''+param+'\',' + (pageIndex+1) + ',' + pageNumber+')';
		sb.push('<li><a href="javascript:'+curl+'">下一页</a></li>');
		curl = callback + '(\''+param+'\',' + (pageNumber) + ',' + pageNumber+')';
		sb.push('<li><a href="javascript:'+curl+'">末页</a></li>');
	}
    
	sb.push('<li>共' + pageNumber + '页，跳转至</li>'); 

	sb.push('<li><select id="pid"  onchange="javascript: ' + callback + '(\'' + param + '\', this.value, ' + pageNumber + ')" >');  		
	for(var i=1;i<=pageNumber;i++){	
	if(i==pageIndex){
		curl = callback + '(\''+param+'\',' + i + ',' + pageNumber+')';
		sb.push('<li> <option value="'+i+'"  selected="selected">'+i+'</option></li>');
	}else{
		curl = callback + '(\''+param+'\',' + i + ',' + pageNumber+')';
		sb.push('<li> <option value="'+i+'">'+i+'</option></li>');
	}
	}
	sb.push('</select></li>');  

	sb.push('</ul>');
	return sb.join('');
}
