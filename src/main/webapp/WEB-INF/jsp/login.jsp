<html>
<body>
<form action="jianli"  enctype="multipart/form-data" method="post">
name:<input type="text" name="name" /><br/>
<input accept="image/bmp, image/jpeg, image/x-png"  id="doc"  type="file" onchange="javascript:setImagePreview();">
<div id="localImag">
<img id="preview" width=-1 height=-1 style="diplay:none" />
</div>
<input type="submit" value="submit" />
</form>
</body>
<script> 
function setImagePreview() { 
var docObj=document.getElementById("doc"); 
var imgObjPreview=document.getElementById("preview"); 
if(docObj.files && docObj.files[0]){ 
//火狐下，直接设img属性 
imgObjPreview.style.display = 'block'; 
imgObjPreview.style.width = '300px'; 
imgObjPreview.style.height = '120px'; 
//imgObjPreview.src = docObj.files[0].getAsDataURL(); 
//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式 
imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]); 
}else{ 
//IE下，使用滤镜 
docObj.select(); 
var imgSrc = document.selection.createRange().text; 
var localImagId = document.getElementById("localImag"); 
//必须设置初始大小 
localImagId.style.width = "250px"; 
localImagId.style.height = "200px"; 
//图片异常的捕捉，防止用户修改后缀来伪造图片 
try{ 
localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
}catch(e){ 
alert("picture type error!"); 
return false; 
} 
imgObjPreview.style.display = 'none'; 
document.selection.empty(); 
} 
return true; 
} 
</script>
</html>
