<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
        var toolbar =[{
            iconCls: 'icon-edit',
			text:"添加",
            handler: function(){
                $("#addDiv").dialog("open");
			},
        },'-',{
            iconCls: 'icon-help',
            text:"修改",
            handler: function(){
                //alert('修改')
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                //alert(row);
                if(row == null){
                    $.messager.show({
                        title:'警告',
                        msg:'请选中修改。',
                        showType:'show',
                        style:{
                            right:'',
                            top:document.body.scrollTop+document.documentElement.scrollTop,
                            bottom:''
                        }
                    });
                }else{
                    var index = $("#dg").edatagrid("getRowIndex",row);
                    $("#dg").edatagrid("editRow",index);
                }
            }
        },'-',{
            iconCls: 'icon-help',
            text:"删除",
            handler: function(){
                //alert('删除');
                //获取到所有选中行，通过datagrid的getSelections方法获取到
                var delRow=$("#dg").edatagrid("getSelected");
                alert(delRow.id);
                if(delRow==null){
                    //alert(0);
                    //alert("请选中要删除的数据");
                }else{
                    //确认是否删除
                    var isConfirm=confirm("确认删除吗？");
					alert(delRow);
                    if(isConfirm){
                        //执行删除操作
                        //获取到所有选中的id
                        //发送ajax请求到后台，执行删除操作
                        $.ajax({
                            url:"${pageContext.request.contextPath}/lideshow/deleteLideshow",
                            data:"delRow="+delRow.id,
                            success:function(data){
                                //后台响应回来数据做处理
                                //修改成功后把修改框关掉，并刷新datagrid
                                //alert(data);
                                if(data){
                                    //alert("删除成功");
                                    $("#dg").edatagrid("reload");
                                }else{
                                    alert("删除失败");
                                }
                            }
                        });
                    }
                }
            }
        },'-',{
            iconCls: 'icon-help',
            text:"保存",
            handler: function(){
                //alert('保存')
                $("#dg").edatagrid("saveRow");
            }
        }];

		$(function(){
            //构建数据表格
            $('#dg').edatagrid({
                updateUrl:"${pageContext.request.contextPath}/lideshow/updeteLideshow",
				toolbar: toolbar,
                url:"${pageContext.request.contextPath}/lideshow/getLideshowAll",
				columns:[[
                    {field:'id',title:'Code'},
                    {field:'title',title:'名字'},
                    {field:'status',title:'状态',editor:{
							type: "text",
                                  options:{
							    	required:true
								  }
						}},
                    {field:'imgpath',title:'路径'},
                    {field:'date',title:'时间'},
                ]],
                fit: true,
                fitColumns: true,
                pagination:true,
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0">' +
						'<img src="${pageContext.request.contextPath}' + rowData.imgpath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>时间: ' + rowData.date + '</p>' +
                        '<p>描述: ' + rowData.desc + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },
            });
			//构建数据表格===END===

            // 文件上传(文件域)的改变事件
            $(':file').change(function(event) {
                //  HTML5 js 对象的获取
                var files = event.target.files, file;

                if(files && files.length > 0){
                    // 获取目前上传的文件
                    file = files[0];
                    // 文件的限定类型什么的道理是一样的
                    if(file.size > 1024 * 1024 * 20) {
                        alert('图片大小不能超过 2MB!');
                        return false;
                    }
                    //file对象生成可用的图片
                    var URL = window.URL || window.webkitURL;
                    // 通过 file 生成目标 url
                    var imgURL = URL.createObjectURL(file);


                    // 用这个 URL 产生一个 <img> 将其显示出来
                    $("img").prop('src', imgURL);
                }
            });
            //文件上传（文件域）的改变事件

            //添加对话框
            $("#addDiv").dialog({
                title:"添加轮播图",
                /*width:280,
                height:150,*/
                closed:true
            });
            //添加对话框===END===


        });
        //添加对话框数据提交
        function doAdd(){
            //通过form的submit方法完成修改数据的提交
            $("#insertForm").form("submit",{
                url:"${pageContext.request.contextPath}/lideshow/addLideshow",
                //回调
                success:function(data){
                    //后台响应回来数据做处理
                    //修改成功后把修改框关掉，并刷新datagrid
                    //alert(data);
                    if(data=="true"){
                        alert("添加成功");
                        $("#addDiv").dialog("close");
                        $("#dg").edatagrid("reload");
                    }else{
                        alert("添加失败");
                    }
                }
            });
            //添加对话框数据提交===END===
        }
	</script>
	<%--构建数据表格--%>
	<table id="dg"></table>
	<%--构建数据表格--%>

	<!-- 添加对话框 -->
	<div id="addDiv">
		<form id="insertForm"  enctype="multipart/form-data" method="post">
			名字:<input id="name" type="text"  name="title"/><br/>
			描述:<input id="pwd"   name="desc"/><br/>
			<label>轮播图：</label>
			<div class="lf salebd"><a href="#"><img src="" width="100" height="100" /></a></div>
			<input name="pic" type="file" class="offset10 lf" />
			<input type="button" value="添加" onclick="doAdd()"/>
		</form>
	</div>
	<!-- 添加对话框===结束=== -->