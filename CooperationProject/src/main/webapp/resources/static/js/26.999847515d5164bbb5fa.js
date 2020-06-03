webpackJsonp([26],{B95D:function(t,e){},YuUn:function(t,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=o("1ihD"),i=o("0hZR"),s={name:"Product",components:{DetailTable:i.a,ListTable:i.b,ButtonToggle:a.a,DateRange:a.b,SearchForm:a.c,PageHeader:i.d,SelectItems:a.d},data:function(){return{headers:[{text:"no",value:"num",sortable:!1},{text:"상품코드",value:"string",sortable:!1},{text:"상품명",value:"string",sortable:!1},{text:"규격(단위)",value:"string",sortable:!1},{text:"제조사(원산지)",value:"string",sortable:!1},{text:"배송단가",value:"string",sortable:!1},{text:"소지바가격",value:"string",sortable:!1},{text:"예비가격",value:"string",sortable:!1},{text:"재고량",value:"string",sortable:!1},{text:"판매상태",value:"string",sortable:!1}],products:[],category1:[],categoryList:[],category2:[],categoryList2:[],category:"",category_2:[],productState:"",allCount:""}},methods:{initProduct:function(){var t=this;this.$axios.get("http://freshntech.cafe24.com/item").then(function(e){t.category_2=null,t.products=e.data[0],t.categoryList=e.data[1];for(var o=0;o<e.data[1].length;o++)t.category1.push(t.categoryList[o].first);t.allCount=t.products.length}).catch(function(t){console.log("Error : ",t)})},moveOrderAppend:function(){this.$router.push("/product/apply")}},watch:{productState:function(){var t=this;this.$axios.post("http://freshntech.cafe24.com/item/search",{state:this.productState,first:this.category,second:this.category_2}).then(function(e){t.products=e.data}).catch(function(t){console.log("Error : ",t)})},category:function(){var t=this;this.category2=[];for(var e=0;e<this.categoryList.length;e++)if(this.category==this.categoryList[e].first)for(var o=0;o<this.categoryList[e].secondCategoryList.length;o++)this.category2.push(this.categoryList[e].secondCategoryList[o].second);this.$axios.post("http://freshntech.cafe24.com/item/search",{state:this.productState,first:this.category,second:this.category_2}).then(function(e){t.products=e.data}).catch(function(t){console.log("Error : ",t)})},category_2:function(){var t=this;this.$axios.post("http://freshntech.cafe24.com/item/search",{state:this.productState,first:this.category,second:this.category_2}).then(function(e){t.products=e.data}).catch(function(t){console.log("Error : ",t)})}},created:function(){this.initProduct()}},r={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("v-container",[o("page-header",{attrs:{title:"상품 관리"}}),t._v(" "),o("v-container",[o("v-layout",[o("v-flex",[o("detail-table",[o("tbody",{attrs:{slot:"contents"},slot:"contents"},[o("tr",[o("th",[t._v("즉시 검색")]),t._v(" "),o("td",{attrs:{colspan:"2"}},[o("v-container",[o("v-layout",[o("v-flex",{staticClass:"select-container",attrs:{xs3:""}},[o("v-select",{attrs:{items:["판매중","판매중지","재고부족"],label:"판매상태"},model:{value:t.productState,callback:function(e){t.productState=e},expression:"productState"}})],1),t._v(" "),o("v-flex",{staticClass:"select-container",attrs:{xs3:""}},[o("v-select",{attrs:{items:t.category1,label:"1차카테고리"},model:{value:t.category,callback:function(e){t.category=e},expression:"category"}})],1),t._v(" "),o("v-flex",{staticClass:"select-container",attrs:{xs3:""}},[o("v-select",{attrs:{items:t.category2,label:"2차카테고리"},model:{value:t.category_2,callback:function(e){t.category_2=e},expression:"category_2"}})],1)],1)],1)],1)])])])],1)],1)],1),t._v(" "),o("v-container",{staticClass:"middle-container"},[o("v-layout",[o("v-flex",[o("span",[t._v("전체 "+t._s(t.allCount)+"건")])]),t._v(" "),o("v-flex",{staticStyle:{"text-align":"right"}},[o("v-btn",{attrs:{outline:""}},[t._v("상품 일괄 수정")]),t._v(" "),o("v-btn",{attrs:{outline:""}},[t._v("상품 대량 등록")]),t._v(" "),o("v-btn",{attrs:{outline:"",color:"indigo"},on:{click:function(e){t.moveOrderAppend()}}},[o("v-icon",{attrs:{small:""}},[t._v("far fa-file-alt")]),t._v(" 상품 등록")],1)],1)],1)],1),t._v(" "),o("v-container",[o("v-layout",[o("v-flex",[o("v-data-table",{attrs:{headers:t.headers,items:t.products,"hide-actions":""},scopedSlots:t._u([{key:"items",fn:function(e){return[o("tr",[o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.index+1))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.id))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.itemName))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.unit))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.origin))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.price1))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.price2))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.price3))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.itemQTY))]),t._v(" "),o("td",{on:{click:function(o){t.$router.push("/product/list/detail/"+e.item.id)}}},[t._v(t._s(e.item.state))])])]}}])})],1)],1)],1),t._v(" "),o("v-container",[o("v-layout",[o("v-flex",{staticClass:"text-xs-center"},[o("v-pagination",{attrs:{length:1}})],1)],1)],1)],1)},staticRenderFns:[]};var c=o("VU/8")(s,r,!1,function(t){o("B95D")},"data-v-019bf564",null);e.default=c.exports}});
//# sourceMappingURL=26.999847515d5164bbb5fa.js.map