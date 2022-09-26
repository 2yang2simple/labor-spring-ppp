
var publickey512="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJuUERa40BTJlWYw6OYgj57FYzhNaSGylkM7vxTv01WL4wt+OhoMgjBOHkrTqgqnPLdc2R3UKGA5R8w+Z+89lZ8CAwEAAQ==";
var publickey1024="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZR/nUftLb/IbwJTdZKVY/BQWbx3hVIcIi2BiRQN9/2d0+yTKxBVAP87sDkC81p/6x/7j6VCjPF60pIdnW94otBKncpmWZzuKITL9L3/wfoA7M4GMP0AKm7loFOAJQIBZfZs0MmZjsx9iy/xFffVgf6OxgpvITJsKDb6rFvmkWLQIDAQAB";
var e="de07c085bfe741caaef26e7b4adf0096";
var f="de07c085bfe741caaef26e7b4aed0096";
var jqxhr;
$.ajaxSetup({ 
    beforeSend:function(jqxhr, settings) {
        settings.url = getContextPath()+settings.url;
      	var timestamp = d();
      	var timestamptoken = timestamp+"."+md5(timestamp+e); 
      	//jqxhr.setRequestHeader("timestamp", timestamp);
      	jqxhr.setRequestHeader("timestamp-token", timestamptoken);
      	
    },
    complete:function(jqxhr){
        if("REDIRECT" == jqxhr.getResponseHeader("REDIRECT")){ 
            var win = window;
            while(win != win.top){
                win = win.top;
            }
            win.location.href = jqxhr.getResponseHeader("CONTENTPATH");
        }
    },
    error:function (jqxhr,text, error) {
		if("REDIRECT" == jqxhr.getResponseHeader("REDIRECT")){ 
            var win = window;
            while(win != win.top){
                win = win.top;
            }
            win.location.href = jqxhr.getResponseHeader("CONTENTPATH");
        }
		console.log("error: "+ JSON.stringify(jqxhr));
		console.log("error: "+ JSON.stringify(text));
		console.log("error: "+ JSON.stringify(error));
		//alert(JSON.stringify(message));
		//window.location.href = getContextPath()+"/public/error";
	}
});

//JQuery setting
function JQueryValidate(form,parameters){
	$.validator.setDefaults({
		errorContainer: $('.errorlistarea'),
		errorLabelContainer: $("ol", $('.errorlistarea')),
		wrapper: 'li'
	});
	return $(form).validate(parameters).form();
	//callback();
}

//for ajax url
function l(url){
  	return encodeURI(url);
}
function addToken(url,dstr){
	var pad2 = function _pad2(n) { return n < 10 ? '0' + n : n };
  	var gstr;
  	if(arguments.length == 1){
	  	var date = new Date();
	  	//gstr = date.getFullYear().toString() + pad2(date.getMonth() + 1) + pad2(date.getDate()) + pad2(date.getHours()) + pad2(date.getMinutes()) + pad2(date.getSeconds());
	  	gstr = date.getUTCFullYear().toString() + pad2(date.getUTCMonth() + 1) + pad2(date.getUTCDate()) + pad2(date.getUTCHours()) + pad2(date.getUTCMinutes()) + pad2(date.getUTCSeconds());
  	} else if(arguments.length == 2){
  		gstr = dstr;
  	}
  	var t = md5(gstr+e);
  	var params = "g="+gstr+"&t="+t;
  	
  	if(url.indexOf("?")==-1){
  		url = url + "?";
  	} else {
  		url = url + "&";
  	}
  	return encodeURI(url+params);

}
function resultErrorMsg(result){
	if(result!=null){
		if (result.code =='1'){
			$("#resultErrorMsg").html("");
		}else {
			console.log(result.code+":"+result.msg);
			$("#resultErrorMsg").html(result.code+":"+result.msg);
		}
	}
}
function getContextPath() {
//	return "";//if server.servlet.context-path is null;
    return document.location.pathname.substr(0, document.location.pathname.substr(1).indexOf("/")+1);
};
function gotoLoginPage(){
	window.location.href = getContextPath()+"/login";	
}
function gotoLogoutPage(){
	window.location.href = getContextPath()+"/logout";	
}
function gotoUserInfoPage(){
	window.location.href = getContextPath()+"/profile/user-info";	
}

function getQueryString(name)
{
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);//
	if(r!=null)return unescape(r[2]); return null;
}

function d(){
	var pad2 = function _pad2(n) { return n < 10 ? '0' + n : n };
	var date = new Date();
	return date.getUTCFullYear().toString() + pad2(date.getUTCMonth() + 1) + pad2(date.getUTCDate()) + pad2(date.getUTCHours()) + pad2(date.getUTCMinutes()) + pad2(date.getUTCSeconds());
}

var formatDateString = function (datestr) {
	if(isNaN(datestr)&&!isNaN(Date.parse(datestr))){
		var date = new Date(datestr);
	    var y = date.getFullYear();  
	    var m = date.getMonth() + 1;  
	    m = m < 10 ? ('0' + m) : m;  
	    var d = date.getDate();  
	    d = d < 10 ? ('0' + d) : d;  
	    var h = date.getHours();  
	    var minute = date.getMinutes();  
	    minute = minute < 10 ? ('0' + minute) : minute; 
	    var second= date.getSeconds();  
	    second = second < 10 ? ('0' + second) : second;  
	    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+ second;  
	} else {
		return datestr;
	}
}

function handleResultCode(result, successCallback){
	if (result!=null){
		if (result.code=='1'){
			successCallback(result);
		} else{
			hanldeFailureCode(result.code,result.msg);
		}
	} else {
		console.error("Result is null");
	}
}
function handleResultCodeDisplayError(errorElementId, result, successCallback){
	if (result!=null){
		if (result.code=='1'){
			successCallback(result);
		} else{
			if(errorElementId!=null){
				document.getElementById(errorElementId).innerText=result.code + "|" +result.msg;
			}
			hanldeFailureCode(result.code,result.msg);
		}
	} else {
		console.error("Result is null");
	}
}

function handleResultCodeDisplayErrorDefaultMsg(errorElementId, result, defaultMsg, successCallback){
	if (result!=null){
		if (result.code=='1'){
			successCallback(result);
		} else{
			var errormsg;
			if(defaultMsg!=null&&defaultMsg!=""&&defaultMsg!="undefined"){
				errormsg = defaultMsg;
			} else {
				errormsg = result.code + "|" +result.msg;
			}
			if(errorElementId!=null){
				document.getElementById(errorElementId).innerText=errormsg;
			}
			hanldeFailureCode(result.code,result.msg);
		}
	} else {
		console.error("Result is null");
	}
}
function hanldeFailureCode(code,msg){
	// no permission;
	if (code=="30001") {
		window.location.href = getContextPath() + "/public/noprivilege";
	}
	// shiro permission problem
	else if (code=="12000") {
		window.location.href = getContextPath() + "/public/noprivilege";
	}
	// html template problem
	else if (code=="50000") {
		window.location.href = getContextPath() + "/404";
	} 
	// data not found
	else if (code=="40002") {
		
	} 
	else {
		console.error(code + "|" +msg);
	}
}

function openPage(url){
	window.location.href = getContextPath()+url;
}
function openNewPage(url){
	window.open(getContextPath()+url);
}



function show4Permissions() {
	url = '/rest/feign/auth/logins/users/permissions/current';
	var pers = [];
	$.ajax({
		type : 'GET',
		url : url,
		contentType : "application/json; charset=utf-8",
		dataType: "json",
		success : function(result) {
  			//alert(JSON.stringify(data));
			handleResultCode(result, function (result) {
				pers = result.data;
				if (pers==null){
					//alert("per null");
				} else if (pers.length==1&&pers[0]=="*allpass*"){
					//alert(pers[0]);
					$("[permission]").each(function() {
						var per = $(this).attr("permission");
						$(this).show(0);
						$(this).removeClass("disabled");
					});
				} else {
					$("[permission]").each(function() {
						var per = $(this).attr("permission");
						//alert(per);
						//alert($.inArray(per, pers));
						if ($.inArray(per, pers) >= 0) {
							$(this).show(0);
							$(this).removeClass("disabled");
						}
					});
				}
			});
	
		}
	});
	return pers;
}
function show4CurrentUser(){
	$.ajax({
		type: "GET",
		url: '/rest/feign/auth/logins/users/current',
		contentType: "application/json;charset=utf-8",
		dataType: "json",
		success:function (result) {
			handleResultCode(result, function (result) {
				//$("#userinfohtml").html(result.data.userName);
				document.getElementById("headeruserinfo").innerText="["+result.data.userName+"]";
				document.getElementById('headerlogoutlink').style.display='block';	
			});
			if (result.code!="1"){
				document.getElementById('headerloginlink').style.display='block';	
			}
		}
	});
}


//bootstrap pagination
function createPaginationHtml(totalpages,totalelements,currentpage,topageaction){
	var ret = "";
	ret = ret + "<ul class='pagination'><li><span>Total:&nbsp;"+totalelements+"</span></li><li><a onclick='"+topageaction+"(0)'>|&lt;</a></li>";
	
	if (currentpage=='0'){
		ret = ret + "<li class='disabled'><span>&laquo;</span></li>";
	} else {
		ret = ret + "<li><a onclick='"+topageaction+"("+(currentpage-1)+")'>&laquo;</a></li>";
	}
	var displaypagecount=9;
	var front="";
	var middle="";
	var end="";
	var offset=0;
	var displaypages=totalpages;
	if (totalpages>displaypagecount){
		displaypages = displaypagecount;
		if (currentpage>=(displaypagecount-1)){
			offset = currentpage - displaypagecount + 2;
			front = "<li ><span>...</span></li>";
		}
		if (currentpage<(displaypagecount-1)){
			offset = 0;
		}
		if (currentpage<(totalpages-2)){
			end = "<li ><span>...</span></li>";
		}
		if(offset>(totalpages-displaypagecount)){
			offset=totalpages-displaypagecount;
		}
	}
	for (var i = 0; i < displaypages; i++) {
		var j = offset+i;
		if (j==currentpage){
			middle = middle + "<li class='active' ><a onclick='"+topageaction+"("+j+")'>"+(j+1)+"</a></li>";
		} else {
			middle = middle + "<li><a onclick='"+topageaction+"("+j+")'>"+(j+1)+"</a></li>";
		}
	}
	ret = ret + front + middle + end;
	if (currentpage==(totalpages-1)){
		ret = ret + "<li class='disabled'><span>&raquo;</span></li>";
	} else {
		ret = ret + "<li><a onclick='"+topageaction+"("+(currentpage+1)+")'>&raquo;</a></li>"; 
	}
	ret = ret + "<li><a onclick='"+topageaction+"("+(totalpages-1)+")'>&gt;|</a></li></ul>";
	return ret;
}


function ieversion() {
    // 取得浏览器的userAgent字符串
    var userAgent = navigator.userAgent;
    // 判断是否为小于IE11的浏览器
    var isLessIE11 = userAgent.indexOf('compatible') > -1 && userAgent.indexOf('MSIE') > -1;
    // 判断是否为IE的Edge浏览器
    var isEdge = userAgent.indexOf('Edge') > -1 && !isLessIE11;
    // 判断是否为IE11浏览器
    var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf('rv:11.0') > -1;
    if (isLessIE11) {
        var IEReg = new RegExp('MSIE (\\d+\\.\\d+);');
        // 正则表达式匹配浏览器的userAgent字符串中MSIE后的数字部分，，这一步不可省略！！！
        IEReg.test(userAgent);
        // 取正则表达式中第一个小括号里匹配到的值
        var IEVersionNum = parseFloat(RegExp['$1']);
        if (IEVersionNum === 7) {
            // IE7
            return 7
        } else if (IEVersionNum === 8) {
            // IE8
            return 8
        } else if (IEVersionNum === 9) {
            // IE9
            return 9
        } else if (IEVersionNum === 10) {
            // IE10
            return 10
        } else {
            // IE版本<7
            return 6
        }
    } else if (isEdge) {
        // edge
        return 'edge'
    } else if (isIE11) {
        // IE11
        return 11
    } else {
        // 不是ie浏览器
        return -1
    }
}







/*****************************************************************************************************
 * md5
 */
;(function($) {
  'use strict'

  /**
   * Add integers, wrapping at 2^32.
   * This uses 16-bit operations internally to work around bugs in interpreters.
   *
   * @param {number} x First integer
   * @param {number} y Second integer
   * @returns {number} Sum
   */
  function safeAdd(x, y) {
    var lsw = (x & 0xffff) + (y & 0xffff)
    var msw = (x >> 16) + (y >> 16) + (lsw >> 16)
    return (msw << 16) | (lsw & 0xffff)
  }

  /**
   * Bitwise rotate a 32-bit number to the left.
   *
   * @param {number} num 32-bit number
   * @param {number} cnt Rotation count
   * @returns {number} Rotated number
   */
  function bitRotateLeft(num, cnt) {
    return (num << cnt) | (num >>> (32 - cnt))
  }

  /**
   * Basic operation the algorithm uses.
   *
   * @param {number} q q
   * @param {number} a a
   * @param {number} b b
   * @param {number} x x
   * @param {number} s s
   * @param {number} t t
   * @returns {number} Result
   */
  function md5cmn(q, a, b, x, s, t) {
    return safeAdd(bitRotateLeft(safeAdd(safeAdd(a, q), safeAdd(x, t)), s), b)
  }
  /**
   * Basic operation the algorithm uses.
   *
   * @param {number} a a
   * @param {number} b b
   * @param {number} c c
   * @param {number} d d
   * @param {number} x x
   * @param {number} s s
   * @param {number} t t
   * @returns {number} Result
   */
  function md5ff(a, b, c, d, x, s, t) {
    return md5cmn((b & c) | (~b & d), a, b, x, s, t)
  }
  /**
   * Basic operation the algorithm uses.
   *
   * @param {number} a a
   * @param {number} b b
   * @param {number} c c
   * @param {number} d d
   * @param {number} x x
   * @param {number} s s
   * @param {number} t t
   * @returns {number} Result
   */
  function md5gg(a, b, c, d, x, s, t) {
    return md5cmn((b & d) | (c & ~d), a, b, x, s, t)
  }
  /**
   * Basic operation the algorithm uses.
   *
   * @param {number} a a
   * @param {number} b b
   * @param {number} c c
   * @param {number} d d
   * @param {number} x x
   * @param {number} s s
   * @param {number} t t
   * @returns {number} Result
   */
  function md5hh(a, b, c, d, x, s, t) {
    return md5cmn(b ^ c ^ d, a, b, x, s, t)
  }
  /**
   * Basic operation the algorithm uses.
   *
   * @param {number} a a
   * @param {number} b b
   * @param {number} c c
   * @param {number} d d
   * @param {number} x x
   * @param {number} s s
   * @param {number} t t
   * @returns {number} Result
   */
  function md5ii(a, b, c, d, x, s, t) {
    return md5cmn(c ^ (b | ~d), a, b, x, s, t)
  }

  /**
   * Calculate the MD5 of an array of little-endian words, and a bit length.
   *
   * @param {Array} x Array of little-endian words
   * @param {number} len Bit length
   * @returns {Array<number>} MD5 Array
   */
  function binlMD5(x, len) {
    /* append padding */
    x[len >> 5] |= 0x80 << len % 32
    x[(((len + 64) >>> 9) << 4) + 14] = len

    var i
    var olda
    var oldb
    var oldc
    var oldd
    var a = 1732584193
    var b = -271733879
    var c = -1732584194
    var d = 271733878

    for (i = 0; i < x.length; i += 16) {
      olda = a
      oldb = b
      oldc = c
      oldd = d

      a = md5ff(a, b, c, d, x[i], 7, -680876936)
      d = md5ff(d, a, b, c, x[i + 1], 12, -389564586)
      c = md5ff(c, d, a, b, x[i + 2], 17, 606105819)
      b = md5ff(b, c, d, a, x[i + 3], 22, -1044525330)
      a = md5ff(a, b, c, d, x[i + 4], 7, -176418897)
      d = md5ff(d, a, b, c, x[i + 5], 12, 1200080426)
      c = md5ff(c, d, a, b, x[i + 6], 17, -1473231341)
      b = md5ff(b, c, d, a, x[i + 7], 22, -45705983)
      a = md5ff(a, b, c, d, x[i + 8], 7, 1770035416)
      d = md5ff(d, a, b, c, x[i + 9], 12, -1958414417)
      c = md5ff(c, d, a, b, x[i + 10], 17, -42063)
      b = md5ff(b, c, d, a, x[i + 11], 22, -1990404162)
      a = md5ff(a, b, c, d, x[i + 12], 7, 1804603682)
      d = md5ff(d, a, b, c, x[i + 13], 12, -40341101)
      c = md5ff(c, d, a, b, x[i + 14], 17, -1502002290)
      b = md5ff(b, c, d, a, x[i + 15], 22, 1236535329)

      a = md5gg(a, b, c, d, x[i + 1], 5, -165796510)
      d = md5gg(d, a, b, c, x[i + 6], 9, -1069501632)
      c = md5gg(c, d, a, b, x[i + 11], 14, 643717713)
      b = md5gg(b, c, d, a, x[i], 20, -373897302)
      a = md5gg(a, b, c, d, x[i + 5], 5, -701558691)
      d = md5gg(d, a, b, c, x[i + 10], 9, 38016083)
      c = md5gg(c, d, a, b, x[i + 15], 14, -660478335)
      b = md5gg(b, c, d, a, x[i + 4], 20, -405537848)
      a = md5gg(a, b, c, d, x[i + 9], 5, 568446438)
      d = md5gg(d, a, b, c, x[i + 14], 9, -1019803690)
      c = md5gg(c, d, a, b, x[i + 3], 14, -187363961)
      b = md5gg(b, c, d, a, x[i + 8], 20, 1163531501)
      a = md5gg(a, b, c, d, x[i + 13], 5, -1444681467)
      d = md5gg(d, a, b, c, x[i + 2], 9, -51403784)
      c = md5gg(c, d, a, b, x[i + 7], 14, 1735328473)
      b = md5gg(b, c, d, a, x[i + 12], 20, -1926607734)

      a = md5hh(a, b, c, d, x[i + 5], 4, -378558)
      d = md5hh(d, a, b, c, x[i + 8], 11, -2022574463)
      c = md5hh(c, d, a, b, x[i + 11], 16, 1839030562)
      b = md5hh(b, c, d, a, x[i + 14], 23, -35309556)
      a = md5hh(a, b, c, d, x[i + 1], 4, -1530992060)
      d = md5hh(d, a, b, c, x[i + 4], 11, 1272893353)
      c = md5hh(c, d, a, b, x[i + 7], 16, -155497632)
      b = md5hh(b, c, d, a, x[i + 10], 23, -1094730640)
      a = md5hh(a, b, c, d, x[i + 13], 4, 681279174)
      d = md5hh(d, a, b, c, x[i], 11, -358537222)
      c = md5hh(c, d, a, b, x[i + 3], 16, -722521979)
      b = md5hh(b, c, d, a, x[i + 6], 23, 76029189)
      a = md5hh(a, b, c, d, x[i + 9], 4, -640364487)
      d = md5hh(d, a, b, c, x[i + 12], 11, -421815835)
      c = md5hh(c, d, a, b, x[i + 15], 16, 530742520)
      b = md5hh(b, c, d, a, x[i + 2], 23, -995338651)

      a = md5ii(a, b, c, d, x[i], 6, -198630844)
      d = md5ii(d, a, b, c, x[i + 7], 10, 1126891415)
      c = md5ii(c, d, a, b, x[i + 14], 15, -1416354905)
      b = md5ii(b, c, d, a, x[i + 5], 21, -57434055)
      a = md5ii(a, b, c, d, x[i + 12], 6, 1700485571)
      d = md5ii(d, a, b, c, x[i + 3], 10, -1894986606)
      c = md5ii(c, d, a, b, x[i + 10], 15, -1051523)
      b = md5ii(b, c, d, a, x[i + 1], 21, -2054922799)
      a = md5ii(a, b, c, d, x[i + 8], 6, 1873313359)
      d = md5ii(d, a, b, c, x[i + 15], 10, -30611744)
      c = md5ii(c, d, a, b, x[i + 6], 15, -1560198380)
      b = md5ii(b, c, d, a, x[i + 13], 21, 1309151649)
      a = md5ii(a, b, c, d, x[i + 4], 6, -145523070)
      d = md5ii(d, a, b, c, x[i + 11], 10, -1120210379)
      c = md5ii(c, d, a, b, x[i + 2], 15, 718787259)
      b = md5ii(b, c, d, a, x[i + 9], 21, -343485551)

      a = safeAdd(a, olda)
      b = safeAdd(b, oldb)
      c = safeAdd(c, oldc)
      d = safeAdd(d, oldd)
    }
    return [a, b, c, d]
  }

  /**
   * Convert an array of little-endian words to a string
   *
   * @param {Array<number>} input MD5 Array
   * @returns {string} MD5 string
   */
  function binl2rstr(input) {
    var i
    var output = ''
    var length32 = input.length * 32
    for (i = 0; i < length32; i += 8) {
      output += String.fromCharCode((input[i >> 5] >>> i % 32) & 0xff)
    }
    return output
  }

  /**
   * Convert a raw string to an array of little-endian words
   * Characters >255 have their high-byte silently ignored.
   *
   * @param {string} input Raw input string
   * @returns {Array<number>} Array of little-endian words
   */
  function rstr2binl(input) {
    var i
    var output = []
    output[(input.length >> 2) - 1] = undefined
    for (i = 0; i < output.length; i += 1) {
      output[i] = 0
    }
    var length8 = input.length * 8
    for (i = 0; i < length8; i += 8) {
      output[i >> 5] |= (input.charCodeAt(i / 8) & 0xff) << i % 32
    }
    return output
  }

  /**
   * Calculate the MD5 of a raw string
   *
   * @param {string} s Input string
   * @returns {string} Raw MD5 string
   */
  function rstrMD5(s) {
    return binl2rstr(binlMD5(rstr2binl(s), s.length * 8))
  }

  /**
   * Calculates the HMAC-MD5 of a key and some data (raw strings)
   *
   * @param {string} key HMAC key
   * @param {string} data Raw input string
   * @returns {string} Raw MD5 string
   */
  function rstrHMACMD5(key, data) {
    var i
    var bkey = rstr2binl(key)
    var ipad = []
    var opad = []
    var hash
    ipad[15] = opad[15] = undefined
    if (bkey.length > 16) {
      bkey = binlMD5(bkey, key.length * 8)
    }
    for (i = 0; i < 16; i += 1) {
      ipad[i] = bkey[i] ^ 0x36363636
      opad[i] = bkey[i] ^ 0x5c5c5c5c
    }
    hash = binlMD5(ipad.concat(rstr2binl(data)), 512 + data.length * 8)
    return binl2rstr(binlMD5(opad.concat(hash), 512 + 128))
  }

  /**
   * Convert a raw string to a hex string
   *
   * @param {string} input Raw input string
   * @returns {string} Hex encoded string
   */
  function rstr2hex(input) {
    var hexTab = '0123456789abcdef'
    var output = ''
    var x
    var i
    for (i = 0; i < input.length; i += 1) {
      x = input.charCodeAt(i)
      output += hexTab.charAt((x >>> 4) & 0x0f) + hexTab.charAt(x & 0x0f)
    }
    return output
  }

  /**
   * Encode a string as UTF-8
   *
   * @param {string} input Input string
   * @returns {string} UTF8 string
   */
  function str2rstrUTF8(input) {
    return unescape(encodeURIComponent(input))
  }

  /**
   * Encodes input string as raw MD5 string
   *
   * @param {string} s Input string
   * @returns {string} Raw MD5 string
   */
  function rawMD5(s) {
    return rstrMD5(str2rstrUTF8(s))
  }
  /**
   * Encodes input string as Hex encoded string
   *
   * @param {string} s Input string
   * @returns {string} Hex encoded string
   */
  function hexMD5(s) {
    return rstr2hex(rawMD5(s))
  }
  /**
   * Calculates the raw HMAC-MD5 for the given key and data
   *
   * @param {string} k HMAC key
   * @param {string} d Input string
   * @returns {string} Raw MD5 string
   */
  function rawHMACMD5(k, d) {
    return rstrHMACMD5(str2rstrUTF8(k), str2rstrUTF8(d))
  }
  /**
   * Calculates the Hex encoded HMAC-MD5 for the given key and data
   *
   * @param {string} k HMAC key
   * @param {string} d Input string
   * @returns {string} Raw MD5 string
   */
  function hexHMACMD5(k, d) {
    return rstr2hex(rawHMACMD5(k, d))
  }

  /**
   * Calculates MD5 value for a given string.
   * If a key is provided, calculates the HMAC-MD5 value.
   * Returns a Hex encoded string unless the raw argument is given.
   *
   * @param {string} string Input string
   * @param {string} [key] HMAC key
   * @param {boolean} raw Raw oytput switch
   * @returns {string} MD5 output
   */
  function md5(string, key, raw) {
	  if (!key) {
      if (!raw) {
        return hexMD5(string)
      }
      return rawMD5(string)
    }
    if (!raw) {
      return hexHMACMD5(key, string)
    }
    return rawHMACMD5(key, string)
  }

  if (typeof define === 'function' && define.amd) {
    define(function() {
      return md5
    })
  } else if (typeof module === 'object' && module.exports) {
    module.exports = md5
  } else {
    $.md5 = md5
  }
  
})(this)

