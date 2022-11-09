<template>
    <div class="container">
        <el-tabs v-model="activeName">
            <el-tab-pane :label="`logistic regression`" name="first">
                <el-row :gutter="20">
                    <el-col :span="14">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Introduction</span>
                                </div>
                            </template>
                            <span>
                                Logistic regression is a generalized linear regression analysis model.
                                it is mainly used to solve the binary classification problem.
                                It is widely used in the field of credit risk identification, especially in LGD/PD modeling and prediction.
                            </span>
                        </el-card>
                    </el-col>
                    <el-col :span="10">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Performance</span>
                                </div>
                            </template>
                            Accuracy:
                            <el-progress :percentage="94.1" color="#42b983"></el-progress>
                            AUC:
                            <el-progress :percentage="54.7" color="#42b983"></el-progress>
                            F1-score:
                            <el-progress :percentage="49.3" color="#42b983"></el-progress>
                        </el-card>
                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`SVM`" name="second">
                <el-row :gutter="20">
                    <el-col :span="14">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Introduction</span>
                                </div>
                            </template>
                            <span>
                                Support vector machine (SVM) is a kind of generalized linear classifier that performs 
binary classification of data according to supervised learning method. 
Compared to logistic regression and neural networks, 
support vector machines provide a cleaner and more powerful way 
to learn complex nonlinear equations.
SVM has better application effects in financial time series prediction, 
credit risk assessment, and selection of high-quality stocks. So we use it to solve the Automatic Credit Modeling.

                            </span>
                        </el-card>
                    </el-col>
                    <el-col :span="10">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Performance</span>
                                </div>
                            </template>
                            Accuracy:
                            <el-progress :percentage="95.8" color="#42b983"></el-progress>
                            AUC:
                            <el-progress :percentage="56.7" color="#42b983"></el-progress>
                            F1-score
                            <el-progress :percentage="54.4" color="#42b983"></el-progress>
                        </el-card>
                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`MLP`" name="third">
                <el-row :gutter="20">
                    <el-col :span="14">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Introduction</span>
                                </div>
                            </template>
                            <span>
                                MLP tries to model the human brain, 
training neurons to classify different scenarios. 
Using MLP neural network for default prediction in the field of financial credit scorecard works well.
                            </span>
                        </el-card>
                    </el-col>
                    <el-col :span="10">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Performance</span>
                                </div>
                            </template>
                            Accuracy:
                            <el-progress :percentage="96.3" color="#42b983"></el-progress>
                            AUC:
                            <el-progress :percentage="53.9" color="#42b983"></el-progress>
                            F1-score
                            <el-progress :percentage="48.5" color="#42b983"></el-progress>
                        </el-card>
                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`LightGBM`" name="fourth">
                <el-row :gutter="20">
                    <el-col :span="14">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Introduction</span>
                                </div>
                            </template>
                            <span>
                                LightGBM is one of the most popular decision tree ensemble algorithms, 
its algorithm is fast and accurate. 
The algorithm is more effective in multi-dimensional and large-scale data prediction, 
and can effectively judge the user default risk of the platform.
                            </span>
                        </el-card>
                    </el-col>
                    <el-col :span="10">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Performance</span>
                                </div>
                            </template>
                            Accuracy:
                            <el-progress :percentage="98.4" color="#42b983"></el-progress>
                            AUC:
                            <el-progress :percentage="61.2" color="#42b983"></el-progress>
                            F1-score
                            <el-progress :percentage="51.6" color="#42b983"></el-progress>
                        </el-card>
                    </el-col>
                </el-row>

            </el-tab-pane>
            <el-tab-pane :label="`XGBoost`" name="fifth">
                <el-row :gutter="20">
                    <el-col :span="14">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Introduction</span>
                                </div>
                            </template>
                            <span>
                                XGBoost is an improved algorithm based on GBDT, 
which achieves accurate classification effect through iterative calculation of weak classifiers. 
In credit risk prediction, the classification accuracy of XGBoost algorithm is excellent.
                            </span>
                        </el-card>
                    </el-col>
                    <el-col :span="10">
                        <el-card shadow="hover" class="mgb20" style="height: 200px">
                            <template #header>
                                <div class="clearfix">
                                    <span>Model Performance</span>
                                </div>
                            </template>
                            Accuracy:
                            <el-progress :percentage="96.7" color="#42b983" ></el-progress>
                            AUC:
                            <el-progress :percentage="54.3" color="#42b983" ></el-progress>
                            F1-score
                            <el-progress :percentage="52.4" color="#42b983" ></el-progress>
                        </el-card>
                    </el-col>
                </el-row>

            </el-tab-pane>
        </el-tabs>
    </div>
    <div style="margin-top: 20px;">
        <el-card shadow="hover" class="mgb20" style="height: 260px">
            <div style="display: flex;flex-direction:row;">
                <el-select v-model="infor.type" placeholder="Model"  class="handle-select mr10" style="margin-left:50px;width: 100px;">
                    <el-option key="1" label="logistic regression" value="logistic regression"></el-option>
                    <el-option key="2" label="SVM" value="SVM"></el-option>
                    <el-option key="3" label="MLP" value="MLP"></el-option>
                    <el-option key="4" label="LightGBM" value="LightGBM"></el-option>
                    <el-option key="5" label="XGBoost" value="XGBoost"></el-option>
                </el-select>
                <el-input v-model="infor.s1" placeholder="0.2" style="margin-left:300px;width: 100px;"></el-input>
                <el-input v-model="infor.s2" placeholder="0.4" style="margin-left:80px;width: 100px;"></el-input>
                <el-input v-model="infor.s3" placeholder="0.9" style="margin-left:60px;width: 100px;"></el-input>
            </div>
            
<div style="display: flex;flex-direction:row;">
    <el-button style="margin-left:50px;margin-top:50px" type="primary"  @click="handleSubmit()">submit</el-button>
    <img src="../assets/img/risk.png" style="height:100px;margin-left: 200px;">
</div>
        </el-card>
    </div>
</template>

<script setup lang="ts" name="tabs">
import { ref, reactive } from 'vue';
import { Delete, Edit, Search, Plus,Check } from '@element-plus/icons-vue';
import { ElMessage, ElMessageBox } from 'element-plus';
const activeName = ref("first");
const infor = reactive({
    type: '',
    s1:0.2,
    s2:0.6,
    s3:0.9
});
const state = reactive({
    unread: [
        {
            date: '2018-04-19 20:00:00',
            title: '【系统通知】该系统将于今晚凌晨2点到5点进行升级维护'
        },
        {
            date: '2018-04-19 21:00:00',
            title: '今晚12点整发大红包，先到先得'
        }
    ],
    read: [
        {
            date: '2018-04-19 20:00:00',
            title: '【系统通知】该系统将于今晚凌晨2点到5点进行升级维护'
        }
    ],
    recycle: [
        {
            date: '2018-04-19 20:00:00',
            title: '【系统通知】该系统将于今晚凌晨2点到5点进行升级维护'
        }
    ]
});
const submit = () =>{

}

const handleSubmit = () => {
    ElMessageBox.confirm('Are you sure you want to change the configuration? ', 'Warning', {
        type: 'warning'
    })
        .then(() => {
            ElMessage.success('Change successfully!');
        })
        .catch(() => { });
};
const handleRead = (index: number) => {
    const item = state.unread.splice(index, 1);
    state.read = item.concat(state.read);
};
const handleDel = (index: number) => {
    const item = state.read.splice(index, 1);
    state.recycle = item.concat(state.recycle);
};
const handleRestore = (index: number) => {
    const item = state.recycle.splice(index, 1);
    state.read = item.concat(state.read);
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
