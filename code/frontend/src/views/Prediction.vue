<template>
	<div class="container">
		<div style="display: flex;flex-direction:row">
			<el-upload class="upload-demo" drag action="http://localhost:9999/upload" multiple :on-success="handleOK"
				:on-error="handleError">
				<el-icon class="el-icon--upload">
					<upload-filled />
				</el-icon>
				<div class="el-upload__text">
					Drag the file here or
					<em>click to upload</em>
				</div>
				<template #tip>
					<div class="el-upload__tip">Please submit csv file</div>
				</template>
			</el-upload>
			<div v-show="showIt" style="margin-left:40px">
				<div style="display: flex;flex-direction:row;height: 100px;">
					<div style="font-size: 30px;width: 40%;">
						<div>Result:0.000003</div>
						<div> 
							<p>Level:</p>
							<p style="color: green;">&emsp;&emsp;&emsp; low risk</p>
						</div>
					</div>
					<div style="font-size: 15px;margin:10px;width: 60%;">
						&emsp;&emsp;As you can see in the figure, the contribution of each variable shows in color. Red stands for positive contribution and blue stands for negative contribution. All of them contributes to final prediction.
					</div>
				</div>
				<img src="../assets/img/model.png" style="width:100%;">
			</div>
		</div>

	</div>
</template>

<script setup lang="ts">
import { ElMessage, ElMessageBox } from 'element-plus';
import { ref } from 'vue';

var showIt = ref(false)

const handleError = (rawFile: any) => {
	ElMessage.success('Upload successfully!');
	showIt.value = !showIt.value
}
const handleOK = (response: any, rawFile: any) => {
	ElMessage.success('Upload successfully!');
	console.log("response" + response)
	showIt.value = !showIt.value
}
</script>

<style scoped>
.content-title {
	font-weight: 400;
	line-height: 50px;
	margin: 10px 0;
	font-size: 22px;
	color: #1f2f3d;
}

.pre-img {
	width: 100px;
	height: 100px;
	background: #f8f8f8;
	border: 1px solid #eee;
	border-radius: 5px;
}

.crop-demo {
	display: flex;
	align-items: flex-end;
}

.crop-demo-btn {
	position: relative;
	width: 100px;
	height: 40px;
	line-height: 40px;
	padding: 0 20px;
	margin-left: 30px;
	background-color: #409eff;
	color: #fff;
	font-size: 14px;
	border-radius: 4px;
	box-sizing: border-box;
}

.crop-input {
	position: absolute;
	width: 100px;
	height: 40px;
	left: 0;
	top: 0;
	opacity: 0;
	cursor: pointer;
}
</style>
