webpackJsonp([4],{SFL1:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=a("1ihD"),s=a("0hZR"),n=(new Date,{name:"List",components:{DetailTable:s.a,ListTable:s.b,ButtonToggle:r.a,DateRange:r.b,SearchForm:r.c,PageHeader:s.d,SelectItems:r.d},data:function(){return{page:1,loading:!0,headers:[{text:"no",value:"num",sortable:!1},{text:"생성일",value:"date",sortable:!1},{text:"담당자",value:"string",sortable:!1},{text:"담당거래처",value:"string",sortable:!1},{text:"아이디",value:"string",sortable:!1}],purchaseData:[],deliveryData:[],customerData:[],deliveryManagerList:[],salesManList:[],select:"",searchWord:"",orderState:"",deliveryManager:"",delivererData:[],salesMan:"",total:""}},methods:{initPurchaseData:function(){var t=this;this.$axios.get("http://freshntech.cafe24.com/deliverer").then(function(e){t.delivererData=e.data,t.total=e.data.length}).catch(function(t){console.log("Error : ",t)})},search:function(){var t=this;"담당자"===this.select?this.$axios.post("http://freshntech.cafe24.com/deliverer/search",{manager:this.searchWord}).then(function(e){t.delivererData=e.data}).catch(function(t){console.log("Error : ",t)}):"담당 거래처"===this.select&&this.$axios.post("http://freshntech.cafe24.com/deliverer/search",{bName:this.searchWord}).then(function(e){t.delivererData=e.data}).catch(function(t){console.log("Error : ",t)})},moveOrderAppend:function(){this.$router.push("/employee/append")}},created:function(){var t=this;setTimeout(function(){t.$set(t,"loading",!1)},780),this.initPurchaseData()}}),i={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{staticStyle:{}},[a("page-header",{attrs:{title:"배송팀 관리"}}),t._v(" "),t.loading?a("v-layout",{attrs:{row:""}},[a("v-flex",{staticStyle:{"text-align":"center"},attrs:{xs12:"",md12:""}},[a("br"),t._v(" "),a("v-progress-circular",{staticStyle:{width:"200px !important"},attrs:{value:80,width:2,size:50,color:"deep-orange lighten-2",indeterminate:""}}),t._v(" "),a("br"),t._v(" "),a("br"),t._v(" "),a("br")],1)],1):a("div",[a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",[a("detail-table",[a("tbody",{attrs:{slot:"contents"},slot:"contents"},[a("tr",[a("th",[t._v("키워드 검색")]),t._v(" "),a("td",[a("v-layout",{staticStyle:{"padding-top":"20px"}},[a("v-flex",{attrs:{xs2:""}},[a("select-items",{attrs:{items:["담당자","담당 거래처"]},model:{value:t.select,callback:function(e){t.select=e},expression:"select"}})],1),t._v(" "),a("v-flex",{staticStyle:{padding:"0px 20px"},attrs:{xs7:""}},[a("v-text-field",{attrs:{label:"검색어를 입력해 주세요"},model:{value:t.searchWord,callback:function(e){t.searchWord=e},expression:"searchWord"}})],1),t._v(" "),a("v-btn",{on:{click:function(e){t.search()}}},[t._v("검색")])],1)],1)])])])],1)],1),t._v(" "),a("v-layout",{staticClass:"middle-container",attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs12:""}},[a("v-flex",{staticStyle:{"text-align":"right"}},[a("v-btn",{attrs:{outline:"",color:"indigo"},on:{click:function(e){t.moveOrderAppend()}}},[a("v-icon",{attrs:{small:""}},[t._v("far fa-file-alt")]),t._v(" 배송팀 등록")],1)],1)],1)],1),t._v(" "),a("v-layout",[a("v-flex",{staticStyle:{"text-align":"left"}},[a("span",[t._v("전체 "+t._s(t.total)+"건")])])],1),t._v(" "),a("v-layout",{staticClass:"bottom-container"},[a("v-flex",{attrs:{xs12:""}},[a("v-data-table",{attrs:{headers:t.headers,items:t.delivererData,"hide-actions":""},scopedSlots:t._u([{key:"items",fn:function(e){return[a("tr",{on:{click:function(a){t.$router.push("/employee/list/detail/"+e.item.id)}}},[a("td",[t._v(t._s(e.index+1))]),t._v(" "),a("td",[t._v(t._s(e.item.regDate))]),t._v(" "),a("td",[t._v(t._s(e.item.manager))]),t._v(" "),a("td",[t._v(t._s(e.item.bName))]),t._v(" "),a("td",[t._v(t._s(e.item.userId))])])]}}])})],1)],1),t._v(" "),a("v-layout",[a("v-flex",{staticClass:"text-xs-center",attrs:{xs12:""}},[a("v-pagination",{attrs:{length:1},model:{value:t.page,callback:function(e){t.page=e},expression:"page"}})],1)],1)],1)],1)},staticRenderFns:[]};var l=a("VU/8")(n,i,!1,function(t){a("k/FR")},"data-v-dbb10ba0",null);e.default=l.exports},"k/FR":function(t,e){}});
//# sourceMappingURL=4.dd1c17576142ff61f421.js.map