<template>
    <div class="container">
        <el-tabs v-model="activeName">
            <el-tab-pane :label="`logistic regression`" name="first">
                <el-row :gutter="20">
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Current Configuration:</span>
                        </div>
                        <el-table :data="table1" border class="table" ref="multipleTable"
                            header-cell-class-name="table-header">
                            <el-table-column prop="name" label="Parameter" width="200" align="center"></el-table-column>
                            <el-table-column prop="value" label="value" width="70" align="center">
                            </el-table-column>

                        </el-table>
                    </el-col>
                    <el-col :span="6">
                        <div style="margin-top: 20px;">
                        <img src="../assets/img/model1.png" style="width:100%;">
                        </div>
                        
                    </el-col>
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Update Configuration:</span>
                        </div>
                        <el-form  label-width="auto" style="margin-top:20px">
                            <el-form-item label="max_iteration" prop="name">
                                <el-input style="width: 100px;" v-model="input1.in1"></el-input>
                            </el-form-item>
                            <el-form-item label="C" prop="name">
                                <el-input style="width: 100px;" v-model="input1.in2"></el-input>
                            </el-form-item>
                            <el-form-item label="penalty" prop="name">
                                <el-input style="width: 100px;" v-model="input1.in3"></el-input>
                            </el-form-item>
                            <el-form-item label="solver" prop="name">
                                <el-input style="width: 100px;" v-model="input1.in4"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit1()">submit</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="6">

                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`SVM`" name="second">
                <el-row :gutter="20">
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Current Configuration:</span>
                        </div>
                        <el-table :data="table2" border class="table" ref="multipleTable"
                            header-cell-class-name="table-header">
                            <el-table-column prop="name" label="Parameter" width="200" align="center"></el-table-column>
                            <el-table-column prop="value" label="value" width="70" align="center">
                            </el-table-column>

                        </el-table>
                    </el-col>
                    <el-col :span="6">
                        <div style="margin-top: 20px;">
                            <img src="../assets/img/model2.png" style="width:100%;">
                        </div>
                        
                    </el-col>
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Update Configuration:</span>
                        </div>
                        <el-form  label-width="auto" style="margin-top:20px">
                            <el-form-item label="kernel" prop="name">
                                <el-input style="width: 100px;" v-model="input2.in1"></el-input>
                            </el-form-item>
                            <el-form-item label="max_iteration" prop="name">
                                <el-input style="width: 100px;" v-model="input2.in2"></el-input>
                            </el-form-item>
                            <el-form-item label="C" prop="name">
                                <el-input style="width: 100px;" v-model="input2.in3"></el-input>
                            </el-form-item>
                            <el-form-item label="gamma" prop="name">
                                <el-input style="width: 100px;" v-model="input2.in4"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit2()">submit</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="6">

                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`MLP`" name="third">
                <el-row :gutter="20">
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Current Configuration:</span>
                        </div>
                        <el-table :data="table3" border class="table" ref="multipleTable"
                            header-cell-class-name="table-header">
                            <el-table-column prop="name" label="Parameter" width="200" align="center"></el-table-column>
                            <el-table-column prop="value" label="value" width="70" align="center">
                            </el-table-column>

                        </el-table>
                    </el-col>
                    <el-col :span="6">
                        <div style="margin-top: 20px;">
                            <img src="../assets/img/model3.png" style="width:100%;">
                        </div>
                        
                    </el-col>
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Update Configuration:</span>
                        </div>
                        <el-form  label-width="auto" style="margin-top:20px">
                            <el-form-item label="hidden_layer_sizes" prop="name">
                                <el-input style="width: 100px;" v-model="input3.in1"></el-input>
                            </el-form-item>
                            <el-form-item label="max_iteration" prop="name">
                                <el-input style="width: 100px;" v-model="input3.in2"></el-input>
                            </el-form-item>
                            <el-form-item label="learning_rate" prop="name">
                                <el-input style="width: 100px;" v-model="input3.in3"></el-input>
                            </el-form-item>
                            <el-form-item label="alpha" prop="name">
                                <el-input style="width: 100px;" v-model="input3.in4"></el-input>
                            </el-form-item>
                            <el-form-item label="activation" prop="name">
                                <el-input style="width: 100px;" v-model="input3.in5"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit3()">submit</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="6">

                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`LightGBM`" name="fourth">
                <el-row :gutter="20">
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Current Configuration:</span>
                        </div>
                        <el-table :data="table4" border class="table" ref="multipleTable"
                            header-cell-class-name="table-header">
                            <el-table-column prop="name" label="Parameter" width="200" align="center"></el-table-column>
                            <el-table-column prop="value" label="value" width="70" align="center">
                            </el-table-column>

                        </el-table>
                    </el-col>
                    <el-col :span="6">
                        <div style="margin-top: 20px;"></div>
                        <img src="../assets/img/model4.png" style="width:100%;">
                    </el-col>
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Update Configuration:</span>
                        </div>
                        <el-form  label-width="auto" style="margin-top:20px">
                            <el-form-item label="num_leaves" prop="name">
                                <el-input style="width: 100px;" v-model="input4.in1"></el-input>
                            </el-form-item>
                            <el-form-item label="num_trees" prop="name">
                                <el-input style="width: 100px;" v-model="input4.in2"></el-input>
                            </el-form-item>
                            <el-form-item label="num_round" prop="name">
                                <el-input style="width: 100px;" v-model="input4.in3"></el-input>
                            </el-form-item>
                            <el-form-item label="learning_rate" prop="name">
                                <el-input style="width: 100px;" v-model="input4.in4"></el-input>
                            </el-form-item>
                            <el-form-item label="metric" prop="name">
                                <el-input style="width: 100px;" v-model="input4.in5"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit4()">submit</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="6">
                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`XGBoost`" name="fifth">
                <el-row :gutter="20">
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Current Configuration:</span>
                        </div>
                        <el-table :data="table5" border class="table" ref="multipleTable"
                            header-cell-class-name="table-header">
                            <el-table-column prop="name" label="Parameter" width="200" align="center"></el-table-column>
                            <el-table-column prop="value" label="value" width="70" align="center">
                            </el-table-column>

                        </el-table>
                    </el-col>
                    <el-col :span="6">
                        <div style="margin-top: 20px;"></div>
                        <img src="../assets/img/model5.png" style="width:100%;">
                    </el-col>
                    <el-col :span="6">
                        <div style="margin: 10px;">
                            <span>Update Configuration:</span>
                        </div>
                        <el-form  label-width="auto" style="margin-top:20px">
                            <el-form-item label="max_depth" prop="name">
                                <el-input style="width: 100px;" v-model="input5.in1"></el-input>
                            </el-form-item>
                            <el-form-item label="n_estimators" prop="name">
                                <el-input style="width: 100px;" v-model="input5.in2"></el-input>
                            </el-form-item>
                            <el-form-item label="min_child_weight" prop="name">
                                <el-input style="width: 100px;" v-model="input5.in3"></el-input>
                            </el-form-item>
                            <el-form-item label="learning_rate" prop="name">
                                <el-input style="width: 100px;" v-model="input5.in4"></el-input>
                            </el-form-item>
                            <el-form-item label="booster" prop="name">
                                <el-input style="width: 100px;" v-model="input5.in5"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit5()">submit</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="6">

                    </el-col>
                </el-row>

            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script setup lang="ts" name="advanced">
import { ref, reactive } from 'vue';
import { Delete, Edit, Search, Plus, Check } from '@element-plus/icons-vue';
import { ElMessage, ElMessageBox } from 'element-plus';
import type { FormInstance, FormRules } from 'element-plus';
const activeName = ref("first");
var table1 = reactive(
    [
    {
        name: "max_iteration",
        value: 20,
    }, {
        name: "C",
        value: 1,
    }, {
        name: "penalty",
        value: "l2",
    }, {
        name: "solver",
        value: "saga",
    }
]
);
const input1 = reactive({
    in1: 20,
    in2: 1,
    in3: "l2",
    in4: "saga"
});
var table2 = reactive(
    [
    {
        name: "kernel",
        value: "rbf",
    }, {
        name: "max_iteration",
        value: 20,
    }, {
        name: "C",
        value: 1,
    }, {
        name: "gamma",
        value: "auto",
    }
]
);
const input2 = reactive({
    in1: "rbf",
    in2: 20,
    in3: 1,
    in4: "auto"
});
var table3 = reactive(
    [
    {
        name: "hidden_layer_sizes",
        value: "(1000,)",
    }, {
        name: "max_iteration",
        value: 100,
    }, {
        name: "learning_rate",
        value: 0.001,
    }, {
        name: "alpha",
        value: 0.00001,
    }, {
        name: "activation",
        value: "relu",
    }
]
);
const input3 = reactive({
    in1: "(1000,)",
    in2: 100,
    in3: 0.001,
    in4: 0.00001,
    in5: "relu"
});
var table4 = reactive(
    [
    {
        name: "num_leaves",
        value: 40,
    }, {
        name: "num_trees",
        value: 1600,
    }, {
        name: "num_round",
        value: 30,
    }, {
        name: "learning_rate",
        value: 0.001,
    }, {
        name: "metric",
        value: "AUC",
    }
]
);
const input4 = reactive({
    in1: 40,
    in2: 1600,
    in3: 30,
    in4: 0.001,
    in5: "AUC"
});

var table5 = reactive(
    [
    {
        name: "max_depth",
        value: 20,
    }, {
        name: "n_estimators",
        value: 200,
    }, {
        name: "min_child_weight",
        value: 3,
    }, {
        name: "learning_rate",
        value: 0.001,
    }, {
        name: "booster",
        value: "gbtree",
    }
]
);
const input5 = reactive({
    in1: 20,
    in2: 200,
    in3: 3,
    in4: 0.001,
    in5:"gbtree"
});

const onSubmit1 = () => {
    ElMessage.success('Change successfully！');
    table1[0].value = input1.in1
    table1[1].value = input1.in2
    table1[2].value = input1.in3
    table1[3].value = input1.in4
};
const onSubmit2 = () => {
    ElMessage.success('Change successfully！');
    table2[0].value = input2.in1
    table2[1].value = input2.in2
    table2[2].value = input2.in3
    table2[3].value = input2.in4
};
const onSubmit3 = () => {
    ElMessage.success('Change successfully！');
    table3[0].value = input3.in1
    table3[1].value = input3.in2
    table3[2].value = input3.in3
    table3[3].value = input3.in4
    table3[4].value = input3.in5
};
const onSubmit4 = () => {
    ElMessage.success('Change successfully！');
    table4[0].value = input4.in1
    table4[1].value = input4.in2
    table4[2].value = input4.in3
    table4[3].value = input4.in4
    table4[4].value = input4.in5
};
const onSubmit5 = () => {
    ElMessage.success('Change successfully！');
    table5[0].value = input5.in1
    table5[1].value = input5.in2
    table5[2].value = input5.in3
    table5[3].value = input5.in4
    table5[4].value = input5.in5
};
// 重置
const onReset = (formEl: FormInstance | undefined) => {
    if (!formEl) return;
    formEl.resetFields();
};
</script>

<style>
.message-title {
    cursor: pointer;
}

.handle-row {
    margin-top: 30px;
}
</style>
