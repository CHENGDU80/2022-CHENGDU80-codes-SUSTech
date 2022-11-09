<template>
    <div>
        <div class="container">
            <div class="handle-box">
                <el-select v-model="query.type" placeholder="Type" @change="update()" class="handle-select mr10" style="width: 200px;">
                    <el-option key="1" label="All" value="All"></el-option>
                    <el-option key="1" label="Change Model" value="Change Model"></el-option>
                    <el-option key="2" label="Query" value="Query"></el-option>
                    <el-option key="3" label="Change Config" value="Change Config"></el-option>
                </el-select>

            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="id" label="ID" width="80" align="center"></el-table-column>
                <el-table-column prop="operation" label="Operation" width="150" align="center"></el-table-column>
                <el-table-column prop="time" label="Time" width="150" align="center"></el-table-column>
                <el-table-column prop="operator" label="Operator" width="150" align="center"></el-table-column>
                <el-table-column prop="detail" label="Detail" width="250" align="center"></el-table-column>
                <el-table-column label="Operation" width="350" align="center">
                    <template #default="scope">
                        <el-button text :icon="User" class="blue"  >
                            Operator Information
                        </el-button>
                        <el-button text :icon="Switch" class="blue" @click="handleRevert(scope.$index)" >
                            Revert
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!-- <div class="pagination">
                <el-pagination background layout="total, prev, pager, next" :current-page="1" :page-size="1"
                    :total="3" @current-change="handlePageChange"></el-pagination>
            </div> -->
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" v-model="editVisible" width="30%">
            <el-form label-width="70px">
                <el-form-item label="用户名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="地址">
                    <el-input v-model="form.address"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editVisible = false">取 消</el-button>
                    <el-button type="primary" @click="saveEdit">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script setup lang="ts" name="Log">
import { ref, reactive } from 'vue';
import { ElMessage, ElMessageBox } from 'element-plus';
import { Delete, Edit, Search, Plus, Switch, User } from '@element-plus/icons-vue';
import { getLogs } from '../api/index';
import { getLog } from '../api/index';

interface TableItem {
    id: number;
    name: string;
    money: string;
    state: string;
    date: string;
    address: string;
}

const query = reactive({
    type: '',
});
const tableData = ref<TableItem[]>([]);
const pageTotal = ref(0);
// 获取初始日志
const getData = (val: string) => {
    if (val === "All") {
        getLogs().then(res => {
            tableData.value = res.data.result;
        });
    } else {
        getLog(val).then(res => {
            tableData.value = res.data.result;
        });
    }
    console.log(tableData.value)

};
getData("All");

// 分页导航
const handlePageChange = (val: number) => {

};

const update = () => {
    getData(query.type)
    // if(query.type==="All"){

    // }else if(query.type==="Change Model"){

    // }else if(query.type==="Change Config"){

    // }else if(query.type==="Query"){

    // }else{
    //     console.log("Wrong type:"+query.type)
    // }

};
// 删除操作
const handleRevert = (index: number) => {
    ElMessageBox.confirm('Are you sure you want to revert?', 'Warning', {
        type: 'warning'
    })
        .then(() => {
            ElMessage.success('Revert successfully!');
        })
        .catch(() => { });
};

// 表格编辑时弹窗和保存
const editVisible = ref(false);
let form = reactive({
    name: '',
    address: ''
});
let idx: number = -1;
const handleInfor = (index: number, row: any) => {
    idx = index;
    form.name = row.name;
    form.address = row.address;
    editVisible.value = true;
};
const saveEdit = () => {
    editVisible.value = false;
    ElMessage.success(`修改第 ${idx + 1} 行成功`);
    tableData.value[idx].name = form.name;
    tableData.value[idx].address = form.address;
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
}

.table {
    width: 100%;
    font-size: 14px;
}

.blue {
    color: #0cc0e9;
}

.mr10 {
    margin-right: 10px;
}

.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
