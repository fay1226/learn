	function getTime(){
	  var date=new Date();
	  var hour=date.getHours();
	  var min=date.getMinutes();
	  if(hour<10) hour="0"+hour;
	  if(min<10) min="0"+min;
	  return hour+":"+min;
	}
	//初始事件(载入事件)
	window.onload=setTimeout(function(){
	  var hour=getTime().substring(0,2);
	  var log="";
	  if(hour>5&&hour<=11){
	    log="早上好！又是美好的一天。";
	  }else if(hour>11&&hour<=13){
	    log="中午好！在干嘛呢？！";
	  }else if(hour>13&&hour<=17){
	    log="下午好！工作、学习中,";
	  }else log="晚上好！夜生活开始了。";
  	  var htmls="<div class='left'><div id='tx1'><img src='file:///android_asset/images/tx1.gif' height='50px' width='50px'/></div><span class='time1'>"+getTime()+"</span><div class='left_qp'></div><div id='msg1' class='txt' onclick='copy(this)'>"+log+"有什么好玩的和我分享呢!</div></div>";
	  $(".content").append(htmls);
	},3000);

	//×事件
	function hide(){
	  $("#chatContent").toggle(1000);
	  setTimeout(function(){$("#hidden").css("display","block");},900);
	  setTimeout(function sir(){$("#hidden").css("transform","rotate(2deg)");},300);
	  setTimeout(sir(),300);
	};
	//图标事件
	function hideShow(){
	  var hs=document.getElementById("chatContent").style.display;
	  if(hs=="none"){
	    //document.getElementById("chatContent").style.display="block";
		$("#chatContent").show(1000);
		$("#hidden").css("box-shadow","0 0 50px black");
	    document.getElementById("chatContent").style.display="block";
	    setTimeout(function(){$("#hidden").css("display","none");},900);
	  }
	}
	//键盘事件
    window.onkeydown=function(e){
      var key=e.keyCode;
	  //alert(key);
	  if(key==13){
		window.event.returnValue = false;//取消默认的回车事件
	    $("#send").click();
	  }
    };
	function copy(obj){
      /*try{
         var txt =obj.innerText;
         window.clipboardData.setData('text', txt);
         alert('复制成功。');
      }catch(e){
          alert('你的浏览器不支持哦！');
      }*/
	  //var txt=obj.innerText;
	  var selection=window.getSelection();
	  var range=document.createRange();
	  range.selectNodeContents(obj);
	  selection.removeAllRanges();
	  selection.addRange(range);
	  //$("#massage").val(txt);
    };
