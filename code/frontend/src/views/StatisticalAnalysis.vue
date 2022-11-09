<template>

    <div>
        <el-card shadow="hover" class="mgb20" style="height: 450px" v-model="showIt">
            <div>
                <el-button style=" margin-bottom: 10px;" type="primary" @click="change()">filter</el-button>
                
            </div>
            <div v-show="showIt">
                <el-table :data="table1Data.slice((index1 - 1) * 50, index1 * 50)" border class="table"
                    ref="multipleTable " :header-cell-style="{ color: '#606266' }" height="250">
                    <el-table-column prop="Variables" label="Name" align="center" width="100"></el-table-column>
                    <el-table-column prop="Nan Count" label="Missing Value Number" align="center" width="200">
                    </el-table-column>
                    <el-table-column prop="Nan Rate" label="Missing Rate" align="center" width="200"></el-table-column>
                    <el-table-column prop="PSI" label="PSI" align="center" width="100"></el-table-column>
                    <el-table-column prop="WOE_shape" label="WOE" align="center" width="100"></el-table-column>
                    <el-table-column prop="IV" label="IV" align="center" width="100"></el-table-column>
                </el-table>
                <div class="pagination">
                    <el-pagination background layout="total, prev, pager, next" :current-page="index1" :page-size="50"
                        :total="1000" @current-change="handlePageChange1"></el-pagination>
                </div>
            </div>
            <div v-show="!showIt">
                <el-table :data="table2Data.slice((index2 - 1) * 50, index2 * 50)" border class="table"
                    ref="multipleTable" :header-cell-style="{ color: '#606266' }" height="250">
                    <el-table-column prop="Variables" label="Name" align="center" width="100"></el-table-column>
                    <el-table-column prop="Nan Count" label="Missing Value Number" align="center" width="200">
                    </el-table-column>
                    <el-table-column prop="Nan Rate" label="Missing Rate" align="center" width="200">
                    </el-table-column>
                    <el-table-column prop="PSI" label="PSI" align="center" width="100"></el-table-column>
                    <el-table-column prop="WOE_shape" label="WOE" align="center" width="100"></el-table-column>
                    <el-table-column prop="IV" label="IV" align="center" width="100"></el-table-column>
                    <el-table-column prop="max" label="Maximum" align="center" width="100"></el-table-column>
                    <el-table-column prop="min" label="Minimum" align="center" width="100"></el-table-column>
                    <el-table-column prop="mean" label="Mean" align="center" width="100"></el-table-column>
                    <el-table-column prop="25%" label="25%quantile" align="center" width="120"></el-table-column>
                    <el-table-column prop="50%" label="50%quantile" align="center" width="120"></el-table-column>
                    <el-table-column prop="75%" label="75%quantile" align="center" width="120"></el-table-column>
                    <el-table-column prop="default_mean" label="Mean in Default Case" align="center" width="200">
                    </el-table-column>
                    <el-table-column prop="normal_mean" label="Mean in Normal Case" align="center" width="200">
                    </el-table-column>
                    <el-table-column prop="default_std" label="Variance in Default Case" align="center" width="200">
                    </el-table-column>
                    <el-table-column prop="normal_std" label="Variance in Normal Case" align="center" width="200">
                    </el-table-column>
                </el-table>
                <div class="pagination">
                    <el-pagination background layout="total, prev, pager, next" :current-page="index2" :page-size="50"
                        :total="185" @current-change="handlePageChange2"></el-pagination>
                </div>
            </div>
            <div style="display: flex;flex-direction: row;">
                <el-tooltip class="item" effect="dark"
                    content="WOE describes the relationship between a predictive variable and a binary target variable. Select variables with a single increase trend, a single decrease trend, or a Ushape trend."
                    placement="top-start">
                    <div style="font-size:5px">WOE :Weight of Evidence</div>
                </el-tooltip>
                <div style="margin-left: 20px;">
                    <el-tooltip class="item" effect="dark"
                        content="IV assesses the predictive power of the variables. The reasonable range is 0.02-0.5."
                        placement="top-start">
                        <div style="font-size:5px">IV :Information Value</div>
                    </el-tooltip>
                </div>
                <div style="margin-left: 20px;">
                    <el-tooltip class="item" effect="dark"
                    content="PSI measures the stability of variables and models. The reasonable range is 0-0.25."
                    placement="top-start">
                    <div style="font-size:5px">PSI :Population Stability Index</div>
                </el-tooltip>
                </div>
                <div style="margin-left: 20px;">
                    <el-tooltip class="item" effect="dark" content="Missing rate measures the proportion of missing data in a variable. Eliminate
                variables with a missing rate of over 80%." placement="top-start">
                        <div style="font-size:5px">Missing Rate</div>
                    </el-tooltip>
                </div>
            </div>
        </el-card>


    </div>
</template>

<script setup lang="ts" name="StatisticalAnalysis">
import Schart from 'vue-schart';
import imgurl from '../assets/img/img.jpg';
import { Delete, Edit, Search, Plus } from '@element-plus/icons-vue';
import { ElMessage, ElMessageBox } from 'element-plus';
import { getDataPreview } from '../api/index'
import { getDataSelect } from '../api/index'
import { ref } from 'vue';
var showIt = ref(true)
var hintIt = ref(false)
var index1 = ref(1)
var index2 = ref(1)
interface Table1Item {
    id: string;
    iv: string;
    misscnt: string;
    missrate: string;
    name: string;
    psi: string;
    woe: string;
}
const table1Data = ref<Table1Item[]>([]);
const table2Data = ref<Table1Item[]>([]);
const get1 = () => {
    getDataPreview().then(res => {
        table1Data.value = res.data;
    });

};
get1();
const get2 = () => {
    getDataSelect().then(res => {
        table2Data.value = res.data;
    });

};
get2();
const change = () => {
    showIt.value = !showIt.value;
};
const hint = () => {
    ElMessageBox.confirm(
        'WOE (Weight of Evidence): WOE describes the relationship between a predictive variable and a binary target variable. Select variables with a single increase trend, a single decrease trend, or a Ushape trend.',
        {
            type: 'info'
        }
    )
};
const handlePageChange1 = () => {
    index1.value = index1.value + 1
}
const handlePageChange2 = () => {
    index2.value = index2.value + 1
}
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
