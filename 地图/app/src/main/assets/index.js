var map;
	  map = new AMap.Map("map",{
	    resizeEnable:true,
		zoom:8,
		center:[104.340817,25.595073]
	  });
	  AMap.plugin(["AMap.ToolBar","AMap.Scale","AMap.OverView"],function(){
	    map.addControl(new AMap.ToolBar());
	    map.addControl(new AMap.Scale());
	    map.addControl(new AMap.OverView({
		  isOpen:true
		}));
	  });
	  AMap.plugin('AMap.Autocomplete',function(){
	    var autoOptions={
		  city:"长春市",
		  input:"start"
		};
		autoOption=new AMap.Autocomplete(autoOptions);
	  });
	  AMap.plugin('AMap.Autocomplete',function(){
	    var autoOptions={
		  city:"长春市",
		  input:"end"
		};
		autoOption=new AMap.Autocomplete(autoOptions);
	  });
	  AMap.plugin('AMap.Autocomplete',function(){
	    var autoOptions={
		  city:"长春市",
		  input:"site"
		};
		autoOption=new AMap.Autocomplete(autoOptions);
	  });
	  function search(){
	    AMap.service(["AMap.Transfer"],function(){
		  var transOptions={
		    map:map,
			city:"长春市",
			panel:"panel",
			policy:AMap.TransferPolicy.LEAST_TIME
		  };
		  var trans=new AMap.Transfer(transOptions);
		  trans.search([{keyword:document.getElementById("start").value},
		  {keyword:document.getElementById("end").value}],function(status,result){
		  });
		});
	  }
	  function search1(){
	    var site=document.getElementById("site").value;
		AMap.service(["AMap.PlaceSearch"],function(){
		  var placeSearch=new AMap.PlaceSearch({
		    pageSize:5,
			pageIndex:1,
			city:"",
			map:map,
			panel:"panel"
		  });
		  placeSearch.search(site,function(status,panel){});
		});
	  }
      map.plugin('AMap.Geolocation',function(){
        geolocation = new AMap.Geolocation({
          enableHighAccuracy: true,//是否使用高精度定位，默认:true
          timeout: 10000,          //超过10秒后停止定位，默认：无穷大
          maximumAge: 0,           //定位结果缓存0毫秒，默认：0
          convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
          showButton: true,        //显示定位按钮，默认：true
          buttonPosition: 'LT',    //定位按钮停靠位置，默认：'LB'，左下角
          buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
          showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
          showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
          panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
          zoomToAccuracy:true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
      });
      map.addControl(geolocation);
      geolocation.getCurrentPosition();
      AMap.event.addListener(geolocation, 'complete',onComplete);//返回定位信息
      AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
      });
