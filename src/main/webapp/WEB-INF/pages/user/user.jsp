<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<script type="text/javascript">
$(function(){
	//缓存要用到的组件
	var userSearchbox = $("#userSearchbox");//搜索框
	var userDataGrid = $("#userDataGrid");//数据表格
	var user_searchForm = $("#user_searchForm");//参数表单
	//搜索框
	userSearchbox.searchbox({
		prompt:'关键字',
		searcher:function(){ 
			var paramObj = {};
			var paramArr = user_searchForm.serializeArray();
			 $.each(paramArr,function(i,data){
				 paramObj[data.name] = data.value;
			 }); 
			 userDataGrid.datagrid("load",paramObj);
		}
	});
   //数据表格
    userDataGrid.datagrid({
    	fit:true,
		border:false,
		url:'user/query',
		singleSelect:true,
		fitColumns:true,
		striped:true,
		rownumbers:true,
		pagination:true,
		pageSize:20,
		pageList:[5,10,20,50],
		toolbar:'#user_toolbar'
	});
	
	//创建cmdType管理所有操作函数
	var cmdUser={
		
		//停用
		user_leave:function(){
			// 1.获取选中行信息
			var rowData = userDataGrid.datagrid("getSelected");
			// 2.判断
			if(!rowData){
				$.messager.alert("温馨提示","你没有选中任何数据","info");
				return;
			}
			if(rowData.status==0){
				$.messager.alert("温馨提示","请不要重复停用！！","warning");
				return;
			}
			var name = (rowData.nickname ==false ? rowData.username : rowData.nickname);
			$.messager.confirm("温馨提示","是否确认停用【"+name+"】账户??",function(yes){
				if(yes){
					// 获取数据的唯一标示
					var id = rowData.id;
					// 发送AJAX请求，修改ID对应数据状态
					$.get("/user/leave",{id:id},function(data){
						console.debug(data);
						if(data.success){
							$.messager.alert("温馨提示",data.message,"info",function(){
								userDataGrid.datagrid("reload");
							});
						}
					},"json");
				}
			});
		},
		//启用
		user_up:function(){
			// 1.获取选中行信息
			var rowData = userDataGrid.datagrid("getSelected");
			// 2.判断
			if(!rowData){
				$.messager.alert("温馨提示","你没有选中任何数据","info");
				return;
			}
			if(rowData.status==1){
				$.messager.alert("温馨提示","请不要重复启用！！","warning");
				return;
			}
			var name = (rowData.nickname ==false ? rowData.username : rowData.nickname);
			$.messager.confirm("温馨提示","是否确认启用【"+name+"】账户??",function(yes){
				if(yes){
					// 获取数据的唯一标示
					var id = rowData.id;
					// 发送AJAX请求，修改ID对应数据状态
					$.get("/user/up",{id:id},function(data){
						console.debug(data);
						if(data.success){
							$.messager.alert("温馨提示",data.message,"info",function(){
								userDataGrid.datagrid("reload");
							});
						}
					},"json");
				}
			});
		},
		
		//删除
		user_del:function(){
			// 1.获取选中行信息
			var rowData = userDataGrid.datagrid("getSelected");
			console.debug(rowData);
			// 2.判断
			if(!rowData){
				$.messager.alert("温馨提示","你没有选中任何数据","info");
				return;
			}
			//alert(rowData.status);
			//if(rowData.status!=0){
			//	$.messager.alert("温馨提示","不能删除未停用账户！！","warning");
			//	return;
			//}
			//提示用户是否删除
			var name = (rowData.nickname ==false ? rowData.username : rowData.nickname);
			$.messager.confirm("温馨提示","是否确认删除【"+name+"】账户??",function(yes){
				if(yes){
					// 获取数据的唯一标示
					var id = rowData.id;
					// 发送AJAX请求，修改ID对应数据状态
					$.get("/user/delete",{id:id},function(data){
						console.debug(data);
						if(data.success){
							$.messager.alert("温馨提示",data.message,"info",function(){
								userDataGrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.message,"error");
						}
					},"json");
				}
			});
			
		},
		
		//刷新
		user_refresh:function(){
			userDataGrid.datagrid("reload");
		},	
		//取消
		user_cancel:function(){
			userDialog.dialog("close");
		}
	}
	
	//对页面上所有按钮做一次统一的监听
	$("a[data-cmd]").on("click",function(){
		//获取data-cmd属性的值
		var cmd = $(this).data("cmd");//data-key="value"其实就是一个{key:value}类型的数据
		if (cmd) {
			console.debug(cmd);
			cmdUser[cmd]();//执行对应的方法
		}
	});
});
</script>
	<table id="userDataGrid" style="width: 600px;height: 300px;">
		<!--
			定义表格的表头 
		 -->
		<thead>
			<tr>
				<!-- field：指定需要显示列对应JSON数据属性 -->
				<th field="headImage"  width="10" align="center" data-options="formatter:formatImg">头像</th>
				<th field="username"   width="20" align="center">账号</th>
				<th field="nickname"   width="20" align="center">昵称</th>
<!-- 				<th field="email"      width="20">邮箱</th> -->
				<th field="myCode"   width="10" align="center">邀请码</th>
				<th field="useCode"   width="10" align="center">注册码</th>
				<th field="turnover"   width="10" align="center">成交量</th>
				<th field="amount"   width="10" align="center">成交金额</th>
				<th field="userType"   width="10" align="center" data-options="formatter:formatUserType">账户类型</th>
				<th field="store"   width="20" align="center" data-options="formatter:formatName">店铺</th>
				<th field="status"  width="10" align="center" data-options="formatter:formatUserStatus">状态</th>
			</tr>
		</thead>
	</table>
	
	 <div id="user_toolbar">
	 	<div>
		 	<form method="post" id="user_searchForm">
			<a class="easyui-linkbutton" iconCls="icon-redo"  data-cmd="user_up">启用</a>
			<a class="easyui-linkbutton" iconCls="icon-undo"  data-cmd="user_leave">停用</a>
			<a class="easyui-linkbutton" iconCls="icon-undo"  data-cmd="user_del">删除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload"  data-cmd="user_refresh">刷新</a>
		 
				<select class="easyui-combobox" name="status" style="width: 100px" prompt='状态'>
					<option value="-99" ></option>
					<option value="1">正常</option>
					<option value="0">停用</option>
				</select> 
				<select class="easyui-combobox" name="userType" style="width: 100px" prompt='类型'>
					<option value="-1" ></option>
					<option value="1">店铺</option>
					<option value="0">代理</option>
				</select> 
				<input id="userSearchbox" name="userName" style="width: 100px" ></input>
		 	</form>
		 </div> 
	</div>
	
	
</body>
</html>