<template>
	<div>
		<el-row :gutter="20">
			<el-col :span="14">
				<el-card shadow="hover" class="mgb20" style="height: 260px">
					<img src="../assets/img/intro.png" style="height: 300px;">
				</el-card>
				<el-card shadow="hover" class="mgb20" style="height: 340px">
					<el-table :data="table1" border class="table" ref="multipleTable"  :header-cell-style="{color:'#606266'}">
						<el-table-column prop="month" label="Month"  align="center" width="80"></el-table-column>
						<el-table-column prop="total" label="Total Loans" align="center"></el-table-column>
						<el-table-column prop="yes" label="Credible Loans" align="center" color="green"></el-table-column>
						<el-table-column prop="no" label="Default Loans" align="center"></el-table-column>
						<el-table-column prop="rate" label="Default Rate" align="center" width="110"></el-table-column>
					</el-table>
				</el-card>
			</el-col>
			<el-col :span="10">
				<el-card shadow="hover" class="mgb20" style="height: 300px">
					<!-- <schart class="schart" canvasId="bar" :options="chart_loan" ></schart> -->
					<img src="../assets/img/chart1.png" style="width:440px;height: 300px;">
					
				</el-card>
				<el-card shadow="hover" class="mgb20" style="height: 300px">
					<!-- <schart class="schart" canvasId="line" :options="chart_line"></schart> -->
					
					<img src="../assets/img/chart2.png" style="width:440px;height: 300px;">
					
				</el-card>
			</el-col>
		</el-row>
		<!-- 图表 -->
		<!-- <el-row :gutter="20">
			<el-col :span="12">
				<el-card shadow="hover">

					<schart ref="bar" class="schart" canvasId="bar" :options="options"></schart>
				</el-card>
			</el-col>
			<el-col :span="12">
				<el-card shadow="hover">
					<schart ref="line" class="schart" canvasId="line" :options="options2"></schart>
				</el-card>
			</el-col>
		</el-row> -->
	</div>
</template>

<script setup lang="ts" name="LoanPreview">
import Schart from 'vue-schart';
import { reactive } from 'vue';
import imgurl from '../assets/img/img.jpg';

const name = localStorage.getItem('ms_username');
const role: string = name === 'admin' ? '超级管理员' : '普通用户';

const table1 = [
	{
		month: 2021.5,
		total: 8195,
		yes: 8018,
		no: 177,
		rate: "2.16%",
	},
	{
		month: 2021.6,
		total: 23767,
		yes: 23262,
		no: 505,
		rate: "2.12%",
	},
	{
		month: 2021.7,
		total: 19561,
		yes: 19164,
		no: 397,
		rate: "2.03%",
	},
	{
		month: 2021.8,
		total: 14586,
		yes: 14277,
		no: 309,
		rate: "2.12%",
	},
	{
		month: 2021.9,
		total: 7391,
		yes: 7236,
		no: 155,
		rate: "2.10%",
	},
];
const chart_loan = {
	type: 'bar',
	showValue:false,
	bgColor: '#fbfbfb',
	labels: ['2021.5', '2021.6', '2021.7', '2021.8', '2021.9'],
	datasets: [
		{
			label: 'Total Loans',
			// fillColor: 'rgba(241, 49, 74, 0.5)',
			data: [8195,23767,19561,14586,7391]
		},
		{
			label: 'Credible Loans',
			data: [8018,23262,19164,14277,7236]
		},
		{
			label: 'Default Rate',
			data: [177,505,397,309,155]
		}
	]
};

const chart_line = {
	type: 'line',
	bgColor: '#fbfbfb',
	labels: ['2021.5', '2021.6', '2021.7', '2021.8', '2021.9'],
	datasets: [
		{
			label: 'Default Rate',
			data: [2.16,2.12,2.03,2.12,2.10]
		},
		
	]
};
</script>

<style scoped>
.el-row {
	margin-bottom: 20px;
}

.grid-content {
	display: flex;
	align-items: center;
	height: 100px;
}

.grid-cont-right {
	flex: 1;
	text-align: center;
	font-size: 14px;
	color: #999;
}

.grid-num {
	font-size: 30px;
	font-weight: bold;
}

.grid-con-icon {
	font-size: 50px;
	width: 100px;
	height: 100px;
	text-align: center;
	line-height: 100px;
	color: #fff;
}

.grid-con-1 .grid-con-icon {
	background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
	color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
	background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
	color: rgb(100, 213, 114);
}

.grid-con-3 .grid-con-icon {
	background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
	color: rgb(242, 94, 67);
}

.user-info {
	display: flex;
	align-items: center;
	padding-bottom: 20px;
	border-bottom: 2px solid #ccc;
	margin-bottom: 20px;
}

.user-info-cont {
	padding-left: 50px;
	flex: 1;
	font-size: 14px;
	color: #999;
}

.user-info-cont div:first-child {
	font-size: 30px;
	color: #222;
}

.user-info-list {
	font-size: 14px;
	color: #999;
	line-height: 25px;
}

.user-info-list span {
	margin-left: 70px;
}

.mgb20 {
	margin-bottom: 20px;
}

.todo-item {
	font-size: 14px;
}

.todo-item-del {
	text-decoration: line-through;
	color: #999;
}

.schart {
	width: 100%;
	height: 300px;
}
</style>
