webpackJsonp([10],{bTVv:function(t,e){},ulei:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a("1ihD"),r=a("0hZR"),i={components:{SearchForm:n.c,ButtonToggle:n.a,SelectItems:n.d,PageHeader:r.d,ListTable:r.b,DetailTable:r.a,Modal:r.c},data:function(){return{menu:"",menu2:"",date:"",date2:"",modal:{taxbill:!1},loading:!0,notice:[],startDate:"",ednDate:""}},created:function(){var t=this;setTimeout(function(){t.$set(t,"loading",!1)},750)},methods:{saveNotice:function(){var t=this;this.$axios.post("http://freshntech.cafe24.com/deboarders",{title:this.notice.title,startDate:this.startDate,ednDate:this.ednDate,content:this.notice.content,remark1:this.notice.remark1,remark2:this.notice.remark2}).then(function(e){alert("저장되었습니다."),t.$router.push("/notice/delivery/list")}).catch(function(t){console.log("Error : ",t)})}}},l={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{staticStyle:{}},[a("page-header",{attrs:{title:"배송팀 공지사항 등록"}}),t._v(" "),a("br"),t._v(" "),t.loading?a("v-layout",{attrs:{row:""}},[a("v-flex",{staticStyle:{"text-align":"center"},attrs:{xs12:"",md12:""}},[a("br"),t._v(" "),a("v-progress-circular",{staticStyle:{width:"200px !important"},attrs:{value:80,width:2,size:50,color:"deep-orange lighten-2",indeterminate:""}}),t._v(" "),a("br"),t._v(" "),a("br"),t._v(" "),a("br")],1)],1):a("div",[a("div",{staticClass:"cardbox cardbox-header"},[a("h3",[t._v("기본정보")])]),t._v(" "),a("v-layout",{staticStyle:{padding:"0"},attrs:{row:"",cardbox:"","cardbox-body":""}},[a("v-flex",{attrs:{xs12:"",md12:""}},[a("table",{staticClass:"td-margin",staticStyle:{width:"94%"}},[a("colgroup",[a("col",{attrs:{width:"15%"}}),t._v(" "),a("col",{attrs:{width:"35%"}}),t._v(" "),a("col",{attrs:{width:"15%"}}),t._v(" "),a("col",{attrs:{width:"35%"}})]),t._v(" "),a("tr",[a("th",[a("h4",{staticClass:"center-align"},[t._v("공지제목 *")])]),t._v(" "),a("td",{attrs:{colspan:"3"}},[a("v-text-field",{attrs:{label:"공지제목을 입력해 주세요",required:""},model:{value:t.notice.title,callback:function(e){t.$set(t.notice,"title",e)},expression:"notice.title"}})],1)]),t._v(" "),a("tr",[a("th",[a("h4",{staticClass:"center-align"},[t._v("공지시작 일시 *")])]),t._v(" "),a("td",[a("v-menu",{ref:"menu",attrs:{"close-on-content-click":!1,"nudge-right":40,"return-value":t.date,lazy:"",transition:"scale-transition","offset-y":"","full-width":"","min-width":"290px"},on:{"update:returnValue":function(e){t.date=e}},model:{value:t.menu,callback:function(e){t.menu=e},expression:"menu"}},[a("v-text-field",{attrs:{slot:"activator",label:"시작 일자를 선택하세요","prepend-icon":"event",readonly:""},slot:"activator",model:{value:t.date,callback:function(e){t.date=e},expression:"date"}}),t._v(" "),a("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:t.startDate,callback:function(e){t.startDate=e},expression:"startDate"}},[a("v-spacer"),t._v(" "),a("v-btn",{attrs:{flat:"",color:"primary"},on:{click:function(e){t.menu=!1}}},[t._v("Cancel")]),t._v(" "),a("v-btn",{attrs:{flat:"",color:"primary"},on:{click:function(e){t.$refs.menu.save(t.startDate)}}},[t._v("OK")])],1)],1)],1),t._v(" "),a("th",[a("h4",{staticClass:"center-align"},[t._v("공지종료 일시 *")])]),t._v(" "),a("td",[a("v-menu",{ref:"menu2",attrs:{"close-on-content-click":!1,"nudge-right":40,"return-value":t.date2,lazy:"",transition:"scale-transition","offset-y":"","full-width":"","min-width":"290px"},on:{"update:returnValue":function(e){t.date2=e}},model:{value:t.menu2,callback:function(e){t.menu2=e},expression:"menu2"}},[a("v-text-field",{attrs:{slot:"activator",label:"종료 일자를 선택하세요","prepend-icon":"event",readonly:""},slot:"activator",model:{value:t.date2,callback:function(e){t.date2=e},expression:"date2"}}),t._v(" "),a("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:t.ednDate,callback:function(e){t.ednDate=e},expression:"ednDate"}},[a("v-spacer"),t._v(" "),a("v-btn",{attrs:{flat:"",color:"primary"},on:{click:function(e){t.menu2=!1}}},[t._v("Cancel")]),t._v(" "),a("v-btn",{attrs:{flat:"",color:"primary"},on:{click:function(e){t.$refs.menu2.save(t.ednDate)}}},[t._v("OK")])],1)],1)],1)]),t._v(" "),a("tr",[a("th",[a("h4",{staticClass:"center-align"},[t._v("공지내용 *")])]),t._v(" "),a("td",{attrs:{colspan:"3"}},[a("v-textarea",{attrs:{name:"input-7-4",label:"내용을 입력해주세요",required:"",rows:"20"},model:{value:t.notice.content,callback:function(e){t.$set(t.notice,"content",e)},expression:"notice.content"}})],1)]),t._v(" "),a("tr",[a("th",[a("h4",{staticClass:"center-align"},[t._v("비고")])]),t._v(" "),a("td",{attrs:{colspan:"3"}},[a("v-text-field",{attrs:{label:"내용을 입력해주세요",required:""},model:{value:t.notice.remark1,callback:function(e){t.$set(t.notice,"remark1",e)},expression:"notice.remark1"}})],1)]),t._v(" "),a("tr",[a("th",[a("h4",{staticClass:"center-align"},[t._v("비고2")])]),t._v(" "),a("td",{attrs:{colspan:"3"}},[a("v-text-field",{attrs:{label:"내용을 입력해주세요",required:""},model:{value:t.notice.remark2,callback:function(e){t.$set(t.notice,"remark2",e)},expression:"notice.remark2"}})],1)])])])],1),t._v(" "),a("br"),t._v(" "),a("v-layout",{staticStyle:{"text-align":"center"}},[a("v-flex",{staticStyle:{"text-align":"center"}},[a("v-btn",{on:{click:function(e){t.$router.push("/notice/customer/list")}}},[t._v("목록으로")]),t._v(" "),a("v-btn",{on:{click:function(e){t.saveNotice()}}},[t._v("등록하기")])],1)],1)],1)],1)},staticRenderFns:[]};var c=a("VU/8")(i,l,!1,function(t){a("bTVv")},null,null);e.default=c.exports}});
//# sourceMappingURL=10.20cfd7384c7bef105298.js.map