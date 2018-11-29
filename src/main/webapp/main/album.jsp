<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">

		//头部工具栏
		var toolbar =[{
			iconCls: 'icon-edit',
			text:"专辑详情",
			handler: function(){
				//alert("专辑详情");
                //填充用户选中的信息
                var row = $('#ttr').treegrid("getSelected");
            	if(row == null){
					alert("请先选中专辑");
				}else {
					if(row.score!=null){
						//展示专辑信息
						$('#album').dialog("open");
						$('#album_ff').form("load",row);
						$('#album_img').prop("src","${pageContext.request.contextPath}"+row.coverimg);
					}else{
						alert("请先选中专辑")
					}
				}
			},
		},'-',{
			iconCls: 'icon-help',
			text:"添加章节",
			handler: function(){
                //填充用户选中的信息
                var row = $('#ttr').treegrid("getSelected");
                if(row == null){
                    alert("请先选中专辑");
                }else {
                    if(row.score!=null){
                        $("#chapter_dd").dialog("open");
                        $("#pid").val(row.id);
                    }else{
                        alert("请先选中专辑")
                    }
                }
			}
		},'-',{
			iconCls: 'icon-help',
			text:"添加专辑",
			handler: function(){

			}
		},'-',{
			iconCls: 'icon-help',
			text:"下载音频",
			handler: function(){
				alert('下载音频')
			}
		}];
		//头部工具栏===END===

        //js懒加载
		$(function() {

            //构建 树状数据表格
            $('#ttr').treegrid({
                toolbar: toolbar,
                url:"${pageContext.request.contextPath}/album/getAlbumAll",
                idField:'id',
                pagination:true,
                treeField:'title',
                columns:[[
                    {field: 'title', title: '名字', width: 60},
                    {field: 'downpath', title: '路径', width: 60},
                    {field: 'size', title: '大小', width: 80},
                    {field: 'duration', title: '时长', width: 80}
                ]],
                fit: true,
                fitColumns: true,
            })
            //构建 树状数据表格===END===

            //数据详情
            $('#album').dialog({
                title: '专辑详情',
				width:400,
                closed: true,
            });
            //数据详情===END===

			//数据详情
            $('#chapter_dd').dialog({
                title: '添加专辑',
				width:400,
				height:400,
                closed: true,
                buttons:[{
                    text:'保存',
                    handler:function(){
                        addChapter();
                    }
                },{
                    text:'关闭',
                    handler:function(){
                        $('#chapter_dd').dialog("closed");
                    }
                }]
            });
            //数据详情===END===

        })
        //js懒加载===END===

        //添加专辑
        function addChapter() {
            $('#chapter_ff').form('submit',{
                url:"${pageContext.request.contextPath}/SectionController/addChapter"
            });
        }
        //添加专辑===END===

	</script>
	<%--构建数据表格--%>
	<table id="ttr"></table>
	<%--构建数据表格--%>

	<%--专辑详情--%>
	<div id="album">
		<form id="album_ff" method="post">
			<div>
				<input id="name" class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
			</div>

			<div>
				<input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
			</div>

			<div>
				<input class="easyui-validatebox" type="text" name="score" data-options="required:true"/>
			</div>

			<div>
				<input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
			</div>

			<div>
				<input class="easyui-validatebox" type="text" name="publishdate" data-options="required:true"/>
			</div>
			<div>
				<img src="" id="album_img">
			</div>
		</form>
	</div>
	<%--专辑详情--%>

	<%--添加专辑--%>
	<div id="chapter_dd">
		<form id="chapter_ff" method="post" enctype="multipart/form-data">
			<div>
				标题:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
			</div>
			<div>
				请选择:<input name="chapter" type="file" class="easyui-filebox" style="width:300px">
			</div>
			<div>
				<input type="hidden" id="pid" name="id">
			</div>
		</form>
	</div>
	<%--添加专辑--%>