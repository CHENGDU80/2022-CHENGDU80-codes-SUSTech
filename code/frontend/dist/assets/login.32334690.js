import{d as y,Q as F,t as S,R as B,r as V,S as h,o as I,f as k,i as d,g as s,w as a,u as c,O as x,T as b,U as E,q as C,G as g,j as N,C as T,L as q,M as L,p as U,h as K,_ as M}from"./index.27e5f818.js";/* empty css                     *//* empty css                 */const O=n=>(U("data-v-e1206329"),n=n(),K(),n),R={class:"login-wrap"},$={class:"ms-login"},j=O(()=>d("div",{class:"ms-title"},"SecEye",-1)),D={class:"login-btn"},G=C("Log in"),J=y({__name:"login",setup(n){const f=F(),o=S({username:"manager",password:"123123"}),v={username:[{required:!0,message:"\u8BF7\u8F93\u5165\u7528\u6237\u540D",trigger:"blur"}],password:[{required:!0,message:"\u8BF7\u8F93\u5165\u5BC6\u7801",trigger:"blur"}]},p=B(),u=V(),i=l=>{!l||l.validate(e=>{if(e){g.success("\u767B\u5F55\u6210\u529F"),localStorage.setItem("ms_username",o.username);const t=p.defaultList[o.username];p.handleSet(t),localStorage.setItem("ms_keys",JSON.stringify(t)),f.push("/")}else return g.error("\u767B\u5F55\u6210\u529F"),!1})};return h().clearTags(),(l,e)=>{const t=N,m=T,_=q,w=L;return I(),k("div",R,[d("div",$,[j,s(w,{model:o,rules:v,ref_key:"login",ref:u,"label-width":"0px",class:"ms-content"},{default:a(()=>[s(_,{prop:"username"},{default:a(()=>[s(m,{modelValue:o.username,"onUpdate:modelValue":e[0]||(e[0]=r=>o.username=r),placeholder:"username"},{prepend:a(()=>[s(t,{icon:c(x)},null,8,["icon"])]),_:1},8,["modelValue"])]),_:1}),s(_,{prop:"password"},{default:a(()=>[s(m,{type:"password",placeholder:"password",modelValue:o.password,"onUpdate:modelValue":e[1]||(e[1]=r=>o.password=r),onKeyup:e[2]||(e[2]=b(r=>i(u.value),["enter"]))},{prepend:a(()=>[s(t,{icon:c(E)},null,8,["icon"])]),_:1},8,["modelValue"])]),_:1}),d("div",D,[s(t,{type:"primary",onClick:e[3]||(e[3]=r=>i(u.value))},{default:a(()=>[G]),_:1})])]),_:1},8,["model"])])])}}});const H=M(J,[["__scopeId","data-v-e1206329"]]);export{H as default};