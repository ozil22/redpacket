<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户权限</title>
</head>
<body>
	<script type="text/javascript">
	$(function(){
		//缓存要用到的组件
		var permissionDataGrid = $("#permissionDataGrid");//用户权限数据表格
		var permissionDialog = $("#permissionDialog");//录入窗口
		var permissionForm = $("#permissionForm");//录入表单
		var resourceCombobox = $("#resourceCombobox");//资源下拉框
		//初始化组件
		permissionDataGrid.datagrid({//初始化数据表格
			fit:true, 
			border:false,
			url:'permission/list',//数据地址
			singleSelect:true,
			fitColumns:true,
			striped:true,//隔行换色
			rownumbers:true,
			pagination:true,//分页条
			pageSize:20,
			pageList:[5,10,20,50],
			toolbar:'#permission_toolbar'//工具条
		});
		
		resourceCombobox.combobox({
			url:'resource/list',
		    valueField:'name',
		    textField:'name',
		    prompt:'请选择资源',
		    panelWidth:400
		});
		//创建cmdPermission管理所有操作函数
		var cmdPermission={
			permission_create:function(){
				//清空表单
				permissionForm.form("clear");
				//打开录入框
				permissionDialog.dialog("open");
			},
			//编辑权限
			permission_edit:function(){
				//获取选中行
				var row = permissionDataGrid.datagrid("getSelected");
				//判断用户是否有选中数据
				if(!row){
					$.messager.alert("温馨提示","你没有选中任何数据","info");
					return;
				}
				//清空录入表单
				permissionForm.form("clear");
				//打开录入窗口
				permissionDialog.dialog("open");
				//回显数据
				permissionForm.form("load",row);
			},
			//删除一条数据
			permission_del:function(){
				//获取选中行
				var row = permissionDataGrid.datagrid("getSelected");
				//判断用户是否有选中数据
				if(!row){
					$.messager.alert("温馨提示","你没有选中任何数据","info");
					return;
				}
				//提示用户是否删除
				$.messager.confirm("确认框","你确认删除这条数据吗？",function(b){
					if(b){
						//通过ajax传入需要删除数据的id
						var id = row.id;
						$.post("/permission/delete",{id:id},function(data){
							//data 响应数据
							if(data.success){
								//提示用户删除的结果
								$.messager.alert("温馨提示",data.message,"info");
								//表格重新加载数据
								permissionDataGrid.datagrid("reload");
							}else{
								$.messager.alert("温馨提示",data.message,"error");
							}
						});
					}
				});
			},
			//保存
			permission_save:function(){
				//form标签本身就是一个easyui-form组件，不需要在标签上面写class="easyui-form"；
				
				//进行一个提交操作;
				permissionForm.form("submit",{
					//提交地址
					url:"/permission/save",
					//提交之前，我们可以返回false,阻止提交；
					onSubmit:function(){
						//提交之前，完成自己的验证；
						return $(this).form('validate');
					},
					//数据提交成功后
					success:function(data){
						//data提交后响应的数据,注意是一个json字符串
						console.debug(data);
						data = $.parseJSON(data);//json字符串转化为json对象；
						if (data.success) {
							//关闭录入窗口
							permissionDialog.dialog("close");
							//保存
		            		$.messager.alert("温馨提示",data.message,"info",function(){
							//刷新表格
		            		permissionDataGrid.datagrid("reload");
		            		});
						}else{
							//关闭录入窗口
							permissionDialog.dialog("close");
							$.messager.alert("温馨提示",data.message,"warning");
						}
					}
				});
			},
			//刷新
			permission_refresh:function(){
				permissionDataGrid.datagrid("reload");
			},
			//取消编辑
			permission_cancle:function(){
				permissionDialog.dialog("close");
			},
			//显示所有
			permission_refreshAll:function(){
				//清空查询表单
				permissionQuery.form("clear");
				//传人空的参数加载数据
				permissionDataGrid.datagrid('load',{}); 
				
			}
		};
		//对页面上所有按钮做一次统一的监听
		$("a[data-cmd]").on("click",function(){
			//获取data-cmd属性的值
			var cmd = $(this).data("cmd");//data-key="value"其实就是一个{key:value}类型的数据
			if (cmd) {
				cmdPermission[cmd]();//执行对应的方法
			}
		});
	});
	</script>
	<!-- 数据表格 -->
	<table id="permissionDataGrid" >
		<!-- 定义表格的表头  -->
		<thead>
			<tr>
				<!-- field：指定需要显示列对应JSON数据属性 -->
				<th align="center" field="name" width="10">权限名称</th>
				<th align="center" field="type" width="10">权限类型</th>
				<th align="center" field="resource" width="80">资源名称</th>
			</tr>
		</thead>
	</table>
	<!-- 工具条 -->
	 <div id="permission_toolbar">
	 	<div>
			<a data-cmd="permission_create" class="easyui-linkbutton" iconCls="icon-add" plain="true">新建</a>
			<a data-cmd="permission_edit" class="easyui-linkbutton" iconCls="icon-edit" plain="true" >编辑</a>
			<a data-cmd="permission_del" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除</a>
			<a data-cmd="permission_refresh" class="easyui-linkbutton" iconCls="icon-reload" plain="true" >刷新</a>
	 	</div>
        <div>
       </div>
	</div>
	
	<!-- 录入窗口 -->
	<div id="permissionDialog" class="easyui-dialog" style="width: 300px;height: 200px;"
	data-options="modal:true,iconCls:'icon-edit',buttons:'#permission_bs',closed:true,title:'权限编辑'">
			<form id="permissionForm" method="post">
			<input type="hidden" name="id"></input>
				<div style="margin-top: 15px;margin-left: 35px" >
		 			权限名字：
		 			<input  name="name"  class="easyui-textbox" data-options="required:true" style="width: 150px">
				</div>		
				<div style="margin-top: 10px;margin-left: 35px" >
		 			权限类型：
		 			<input  name="type"  class="easyui-textbox" data-options="required:true" style="width: 150px">
				</div>		
				<div style="margin-top: 10px;;margin-left: 35px"">
			 		资源名称：
			 		<input id="resourceCombobox" name="resource" style="width: 150px">
			 	</div>
			</form>
	</div>
	<!-- 录入窗口按钮 -->
	<div id="permission_bs">
		<a class="easyui-linkbutton" iconCls="icon-save" data-cmd="permission_save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="permission_cancle">取消</a>
	</div>
</body>
</html>