/**
 * 此方法为通用的校验方法
 * @param object.name 需要校验的input标签的name
 * @param object.span 提示用的span的id
 * @param object.reg 正则表达式
 * @param object.errorMsg 错误的返回消息
 * @param object.emptyMsg 为空时的返回消息
 * @param object.isMust 是否必须填写 true必须验证 false可以不验证
 * @returns
 */
//校验的通用方法
function checkAction(object){
	var flag = false;
	//获取input标签 提示用的span标签
	var inputValue = $("input[name="+object.name+"]").val();
	var inputSpan = $("#"+object.span);
	var reg = object.reg;
	//判断是否是必须验证
	if(object.isMust == true){
		//判断是否为空
		if(inputValue != ""){
			//正则匹配
			if(reg.test(inputValue)){
				inputSpan.html("");
				flag = true;
			}else{
				inputSpan.html(object.errorMsg);
			}
		}else{
			inputSpan.html(object.emptyMsg);
		}
	}else{
		if(inputValue == ""){
			flag = true;
		}else{
			//正则匹配
			if(reg.test(inputValue)){
				inputSpan.html("");
				flag = true;
			}else{
				inputSpan.html(object.errorMsg);
			}
		}
	}
	return flag;
}

/**
 * 此方法为通用的校验方法
 * @param object.id 需要校验的对象id
 * @param object.span 提示用的span的id
 * @param object.reg 正则表达式
 * @param object.errorMsg 错误的返回消息
 * @returns
 */
//校验的通用方法 用于校验可以为空，且不能出现特殊字符的对象，如简介、备注等
function checkLongText(object) {
	var flag = false;
	//获取input标签 提示用的span标签
	var inputValue = $("#"+object.id).val();
	var inputSpan = $("#"+object.span);
	var reg = object.reg;
	// 判断是否为空
	if (inputValue != "" && inputValue.length != 0) {
		// 正则匹配
		if (reg.test(inputValue)) {
			inputSpan.html(object.errorMsg);
		} else {
			inputSpan.html("");
			flag = true;
		}
	} else {
		inputSpan.html("");
		flag = true;
	}
	return flag;
}