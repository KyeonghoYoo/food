webpackJsonp([2],{"3azm":function(t,e){},TseL:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=a("1ihD"),n=a("0hZR"),o={name:"List",components:{DetailTable:n.a,ListTable:n.b,ButtonToggle:i.a,DateRange:i.b,SearchForm:i.c,PageHeader:n.d,SelectItems:i.d},data:function(){return{page:1,loading:!0,headers:[{text:"no",value:"num",sortable:!1},{text:"공지번호",value:"num",sortable:!1},{text:"제목",value:"string",sortable:!1},{text:"등록일",value:"string",sortable:!1},{text:"시작일",value:"string",sortable:!1},{text:"종료일",value:"string",sortable:!1}],total:""}},methods:{initPurchaseData:function(){var t=this;this.$axios.get("http://freshntech.cafe24.com/cuboarders").then(function(e){t.noticeData=e.data,t.total=e.data.length}).catch(function(t){console.log("Error : ",t)})},moveAppend:function(){this.$router.push("/notice/customer/append")}},created:function(){var t=this;setTimeout(function(){t.$set(t,"loading",!1)},780),this.initPurchaseData()}},s={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{staticStyle:{}},[a("page-header",{attrs:{title:"거래처 공지사항"}}),t._v(" "),t.loading?a("v-layout",{attrs:{row:""}},[a("v-flex",{staticStyle:{"text-align":"center"},attrs:{xs12:"",md12:""}},[a("br"),t._v(" "),a("v-progress-circular",{staticStyle:{width:"200px !important"},attrs:{value:80,width:2,size:50,color:"deep-orange lighten-2",indeterminate:""}}),t._v(" "),a("br"),t._v(" "),a("br"),t._v(" "),a("br")],1)],1):a("div",[a("v-layout",{staticClass:"middle-container",attrs:{row:"",wrap:""}},[a("v-flex",{staticStyle:{"text-align":"left"}},[a("span",[t._v("전체 "+t._s(t.total)+"건")])]),t._v(" "),a("v-flex",{attrs:{xs4:""}},[a("v-flex",{staticStyle:{"text-align":"right"}},[a("v-btn",{attrs:{outline:"",color:"indigo"},on:{click:function(e){t.moveAppend()}}},[a("v-icon",{attrs:{small:""}},[t._v("far fa-file-alt")]),t._v(" 공지사항 등록")],1)],1)],1)],1),t._v(" "),a("v-layout",{staticClass:"bottom-container"},[a("v-flex",{attrs:{xs12:""}},[a("v-data-table",{attrs:{headers:t.headers,items:t.noticeData,"hide-actions":""},scopedSlots:t._u([{key:"items",fn:function(e){return[a("tr",[a("td",{on:{click:function(a){t.$router.push("/notice/customer/detail/"+e.item.id)}}},[t._v(t._s(e.index+1))]),t._v(" "),a("td",{on:{click:function(a){t.$router.push("/notice/customer/detail/"+e.item.id)}}},[t._v(t._s(e.item.id))]),t._v(" "),a("td",{on:{click:function(a){t.$router.push("/notice/customer/detail/"+e.item.id)}}},[t._v(t._s(e.item.title))]),t._v(" "),a("td",{on:{click:function(a){t.$router.push("/notice/customer/detail/"+e.item.id)}}},[t._v(t._s(e.item.regDate))]),t._v(" "),a("td",{on:{click:function(a){t.$router.push("/notice/customer/detail/"+e.item.id)}}},[t._v(t._s(e.item.startDate))]),t._v(" "),a("td",{on:{click:function(a){t.$router.push("/notice/customer/detail/"+e.item.id)}}},[t._v(t._s(e.item.ednDate))])])]}}])})],1)],1),t._v(" "),a("v-layout",[a("v-flex",{staticClass:"text-xs-center",attrs:{xs12:""}},[a("v-pagination",{attrs:{length:1},model:{value:t.page,callback:function(e){t.page=e},expression:"page"}})],1)],1)],1)],1)},staticRenderFns:[]};var r=a("VU/8")(o,s,!1,function(t){a("3azm")},"data-v-f82baf98",null);e.default=r.exports}});
//# sourceMappingURL=2.c67559659d236ca131bf.js.map