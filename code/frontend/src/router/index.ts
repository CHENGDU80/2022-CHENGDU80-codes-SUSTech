import {createRouter, createWebHashHistory, RouteRecordRaw} from "vue-router";
import { usePermissStore } from '../store/permiss'
import Home from "../views/home.vue";

const routes:RouteRecordRaw[] = [
    {
        path: '/',
        redirect: '/LoanPreview'
    }, {
        path: "/",
        name: "Home",
        component: Home,
        children: [
            {
                path: "/LoanPreview",
                name: "LoanPreview",
                meta: {
                    title: 'Loan Preview',
                    permiss: '1'
                },
                component: () => import ( /* webpackChunkName: "LoanPreview" */ "../views/LoanPreview.vue")
            }, {
                path: "/StatisticalAnalysis",
                name: "StatisticalAnalysis",
                meta: {
                    title: 'Statistical Analysis',
                    permiss: '2'
                },
                component: () => import ( /* webpackChunkName: "StatisticalAnalysis" */ "../views/StatisticalAnalysis.vue")
            },{
                path: "/ModelConfiguration",
                name: "ModelConfiguration",
                meta: {
                    title: 'Model Configuration',
                    permiss: '3'
                },
                component: () => import ( /* webpackChunkName: "ModelConfiguration" */ "../views/ModelConfiguration.vue")
            },{
                path: "/Prediction",
                name: "Prediction",
                meta: {
                    title: 'Prediction',
                    permiss: '4'
                },
                component: () => import ( /* webpackChunkName: "Prediction" */ "../views/Prediction.vue")
            },{
                path: "/Log",
                name: "Log",
                meta: {
                    title: 'Log',
                    permiss: '5'
                },
                component: () => import ( /* webpackChunkName: "Log" */ "../views/Log.vue")
            },{
                path: "/AdvancedConfiguration",
                name: "AdvancedConfiguration",
                meta: {
                    title: 'Advanced Configuration',
                    permiss: '6'
                },
                component: () => import ( /* webpackChunkName: "AdvancedConfiguration" */ "../views/AdvancedConfiguration.vue")
            },{
                path: "/donate",
                name: "AboutSecEye",
                meta: {
                    title: 'About SecEye',
                    permiss: '7'
                },
                component: () => import ( /* webpackChunkName: "donate" */ "../views/donate.vue")
            },
            // {
            //     path: "/table",
            //     name: "basetable",
            //     meta: {
            //         title: '??????',
            //         permiss: '2'
            //     },
            //     component: () => import ( /* webpackChunkName: "table" */ "../views/table.vue")
            // }, {
            //     path: "/charts",
            //     name: "basecharts",
            //     meta: {
            //         title: '??????',
            //         permiss: '11'
            //     },
            //     component: () => import ( /* webpackChunkName: "charts" */ "../views/charts.vue")
            // }, {
            //     path: "/form",
            //     name: "baseform",
            //     meta: {
            //         title: '??????',
            //         permiss: '5'
            //     },
            //     component: () => import ( /* webpackChunkName: "form" */ "../views/form.vue")
            // }, {
            //     path: "/tabs",
            //     name: "tabs",
            //     meta: {
            //         title: 'tab??????',
            //         permiss: '3'
            //     },
            //     component: () => import ( /* webpackChunkName: "tabs" */ "../views/tabs.vue")
            // },  {
            //     path: "/permission",
            //     name: "permission",
            //     meta: {
            //         title: '????????????',
            //         permiss: '13'
            //     },
            //     component: () => import ( /* webpackChunkName: "permission" */ "../views/permission.vue")
            // }, {
            //     path: "/upload",
            //     name: "upload",
            //     meta: {
            //         title: '????????????',
            //         permiss: '6'
            //     },
            //     component: () => import ( /* webpackChunkName: "upload" */ "../views/upload.vue")
            // }, {
            //     path: "/icon",
            //     name: "icon",
            //     meta: {
            //         title: '???????????????',
            //         permiss: '10'
            //     },
            //     component: () => import ( /* webpackChunkName: "icon" */ "../views/icon.vue")
            // },  {
            //     path: '/user',
            //     name: 'user',
            //     meta: {
            //         title: '????????????'
            //     },
            //     component: () => import (/* webpackChunkName: "user" */ '../views/user.vue')
            // }, {
            //     path: '/editor',
            //     name: 'editor',
            //     meta: {
            //         title: '??????????????????',
            //         permiss: '8'
            //     },
            //     component: () => import (/* webpackChunkName: "editor" */ '../views/editor.vue')
            // }, {
            //     path: '/markdown',
            //     name: 'markdown',
            //     meta: {
            //         title: 'markdown?????????',
            //         permiss: '9'
            //     },
            //     component: () => import (/* webpackChunkName: "markdown" */ '../views/markdown.vue')
            // }
        ]
    }, {
        path: "/login",
        name: "Login",
        meta: {
            title: '??????'
        },
        component: () => import ( /* webpackChunkName: "login" */ "../views/login.vue")
    }, {
        path: '/403',
        name: '403',
        meta: {
            title: '????????????'
        },
        component: () => import (/* webpackChunkName: "403" */ '../views/403.vue')
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | SecEye`;
    document.title = `SecEye`;
    const role = localStorage.getItem('ms_username');
    const permiss = usePermissStore();
    if (!role && to.path !== '/login') {
        next('/login');
    } else if (to.meta.permiss && !permiss.key.includes(to.meta.permiss)) {
        // ??????????????????????????????403
        next('/403');
    } else {
        next();
    }
});

export default router;