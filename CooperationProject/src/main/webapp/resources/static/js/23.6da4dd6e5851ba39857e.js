webpackJsonp([23],{RSTw:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s("1ihD"),i=s("0hZR"),r={name:"Append",components:{DetailTable:i.a,ListTable:i.b,ButtonToggle:a.a,DateRange:a.b,SearchForm:a.c,PageHeader:i.d,SelectItems:a.d},data:function(){return{menu:"",date:"",headers:[{text:"no",value:"num",sortable:!1},{text:"상품명",value:"string",sortable:!1},{text:"규격(단위)",value:"string",sortable:!1},{text:"제조사(원산지)",value:"string",sortable:!1},{text:"수량",value:"string",sortable:!1},{text:"배송 단가",value:"string",sortable:!1},{text:"소비자 가격",value:"string",sortable:!1},{text:"예비 가격",value:"string",sortable:!1},{text:"합계금액",value:"string",sortable:!1},{text:"삭제",value:"string",sortable:!1}],items:[],appendModalCheck:!1,productHeaders:[{text:"상품명",value:"strings",sortable:!1},{text:"재고량",value:"string",sortable:!1},{text:"배송 단가",value:"string",sortable:!1},{text:"소비자 가격",value:"string",sortable:!1},{text:"예비 가격",value:"string",sortable:!1},{text:"선택",value:"string",sortable:!1}],purchaseProducts:[],customerProducts:[],selectItems:[],count:1,purchaseItems:[],orderItems:[],shipping:[],allCount:0,payment:0,buyer:[]}},computed:{sumPrice:function(){var t=0;return this.selectItems.forEach(function(e){t+=Number(e.price2)}),this.payment=t*this.count,t*this.count}},methods:{initCustormer:function(){var t=this;this.$axios.get("http://freshntech.cafe24.com/order/setinsert").then(function(e){t.shippingManager=e.data[0];for(var s=0;s<t.shippingManager.length;s++)t.shipping.push(t.shippingManager[s].sManager)}).catch(function(t){console.log("Error : ",t)}),this.$axios.get("http://freshntech.cafe24.com/item").then(function(e){t.purchaseProducts=e.data[0]}).catch(function(t){console.log("Error : ",t)})},openAppendModal:function(){this.appendModalCheck=!this.appendModalCheck},selectProduct:function(t){t.qTY=this.count,t.amount=this.count*t.price2,this.selectItems.push(t),this.allCount++},countModify:function(t,e,s){"up"==t?(this.count+=1,console.log(s)):this.count-=1},defaultSelectItem:function(){this.selectItems=[],this.allCount=0},deleteOneItem:function(t){this.selectItems.forEach(function(e,s,a){e==t&&a.splice(s,1)}),this.allCount--},closeProductAppendModal:function(){this.selectItems=[],this.allCount=this.selectItems.length,this.appendModalCheck=!1},saveOrderItem:function(){for(var t=0;t<this.selectItems.length;t++)this.purchaseItems.push(this.selectItems[t]);this.selectItems=[],this.appendModalCheck=!1},deleteOneOrderItem:function(t){this.purchaseItems.forEach(function(e,s,a){e==t&&a.splice(s,1)}),this.allCount--},regOrder:function(){this.$axios.post("http://freshntech.cafe24.com/purchase",{bName:this.buyer.bName,bNumber:this.buyer.bNumber,bSector:this.buyer.bSector,chief:this.buyer.chief,manager:this.buyer.manager,tel:this.buyer.tel,fax:this.buyer.fax,email:this.buyer.email,mobile:this.buyer.mobile,postNo:this.buyer.postNo,address1:this.buyer.address1,address2:this.buyer.address2,address3:this.buyer.address3,remark1:this.buyer.remark1,id:this.buyer.id,insertProvierItemList:this.purchaseItems}).then(function(t){alert("등록이 완료 되었습니다.")}).catch(function(t){console.log("Error : ",t)}),this.$router.push("/purchase/buyerlist")}},created:function(){this.initCustormer()}},l={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("v-container",[s("page-header",{attrs:{title:"신규 매입처 등록"}}),t._v(" "),s("h3",{staticStyle:{"margin-top":"15px"}},[t._v("기본 정보")]),t._v(" "),s("v-layout",[s("v-flex",[s("detail-table",[s("tbody",{attrs:{slot:"contents"},slot:"contents"},[s("tr",{staticStyle:{height:"70px"}},[s("th",[t._v("매입처명*")]),t._v(" "),s("td",{staticStyle:{width:"35%"},attrs:{colspan:"3"}},[s("v-layout",[s("v-flex",{staticStyle:{padding:"0px"},attrs:{xs12:""}},[s("v-text-field",{attrs:{label:"매입처명을 입력해 주세요"},model:{value:t.buyer.bName,callback:function(e){t.$set(t.buyer,"bName",e)},expression:"buyer.bName"}})],1)],1)],1)]),t._v(" "),s("tr",[s("th",[t._v("사업자등록번호")]),t._v(" "),s("td",{staticStyle:{width:"35%"}},[s("v-layout",[s("v-flex",{staticStyle:{padding:"0px"},attrs:{xs12:""}},[s("v-text-field",{attrs:{label:"사업자등록번호를 입력해 주세요"},model:{value:t.buyer.bNumber,callback:function(e){t.$set(t.buyer,"bNumber",e)},expression:"buyer.bNumber"}})],1)],1)],1),t._v(" "),s("th",[t._v("대표자 명")]),t._v(" "),s("td",{staticStyle:{width:"35%"}},[s("v-layout",[s("v-flex",{staticStyle:{padding:"0px"},attrs:{xs12:""}},[s("v-text-field",{attrs:{label:"대표자 명을 입력해 주세요"},model:{value:t.buyer.chief,callback:function(e){t.$set(t.buyer,"chief",e)},expression:"buyer.chief"}})],1)],1)],1)]),t._v(" "),s("tr",[s("th",[t._v("대표 전화번호")]),t._v(" "),s("td",{staticStyle:{width:"35%"}},[s("v-layout",[s("v-flex",{staticStyle:{padding:"0px"},attrs:{xs12:""}},[s("v-text-field",{attrs:{label:"대표 전화번호를 입력해 주세요"},model:{value:t.buyer.tel,callback:function(e){t.$set(t.buyer,"tel",e)},expression:"buyer.tel"}})],1)],1)],1),t._v(" "),s("th",[t._v("업종/업태")]),t._v(" "),s("td",{staticStyle:{width:"35%"}},[s("v-layout",[s("v-flex",{staticStyle:{padding:"0px"},attrs:{xs12:""}},[s("v-text-field",{attrs:{label:"업종을 입력해 주세요"},model:{value:t.buyer.bSector,callback:function(e){t.$set(t.buyer,"bSector",e)},expression:"buyer.bSector"}})],1)],1)],1)]),t._v(" "),s("tr",[s("th",[t._v("FAX 번호")]),t._v(" "),s("td",{staticStyle:{width:"35%"},attrs:{colspan:"3"}},[s("v-layout",[s("v-flex",{staticStyle:{padding:"0px"},attrs:{xs5:""}},[s("v-text-field",{attrs:{label:"FAX 번호를 입력해 주세요"},model:{value:t.buyer.fax,callback:function(e){t.$set(t.buyer,"fax",e)},expression:"buyer.fax"}})],1)],1)],1)]),t._v(" "),s("tr"),s("tr",[s("th",[s("h4",{staticClass:"center-align"},[t._v("배송지")])]),t._v(" "),s("td",{attrs:{colspan:"3"}},[s("v-text-field",{staticStyle:{width:"50%"},attrs:{label:"우편번호를 입력해 주세요",required:""},model:{value:t.buyer.postNo,callback:function(e){t.$set(t.buyer,"postNo",e)},expression:"buyer.postNo"}}),t._v(" "),s("v-text-field",{staticStyle:{width:"50%"},attrs:{label:"광역시/도를 입력해 주세요",required:""},model:{value:t.buyer.address1,callback:function(e){t.$set(t.buyer,"address1",e)},expression:"buyer.address1"}}),t._v(" "),s("v-text-field",{staticStyle:{width:"50%"},attrs:{label:"도로명을 입력해 주세요",required:""},model:{value:t.buyer.address2,callback:function(e){t.$set(t.buyer,"address2",e)},expression:"buyer.address2"}}),t._v(" "),s("v-text-field",{staticStyle:{width:"50%"},attrs:{label:"상세주소를 입력해 주세요",required:""},model:{value:t.buyer.address3,callback:function(e){t.$set(t.buyer,"address3",e)},expression:"buyer.address3"}})],1)])])])],1)],1),t._v(" "),s("h3",{staticStyle:{"margin-top":"15px"}},[t._v("발주 목록")]),t._v(" "),s("v-layout",{staticStyle:{"padding-top":"20px"}},[s("v-flex",[t._v("\n      전체 "+t._s(t.allCount)+"건\n    ")]),t._v(" "),s("v-flex",{staticStyle:{"text-align":"right"}},[s("v-btn",{attrs:{color:"orange",outline:""},on:{click:function(e){t.openAppendModal()}}},[t._v("\n        상품 추가\n      ")])],1)],1),t._v(" "),s("v-layout",[s("v-flex",[s("v-data-table",{attrs:{headers:t.headers,items:t.purchaseItems,"hide-actions":""},scopedSlots:t._u([{key:"items",fn:function(e){return[s("td",[t._v("\n            "+t._s(e.index+1)+"\n          ")]),t._v(" "),s("td",[t._v(t._s(e.item.itemName))]),t._v(" "),s("td",[t._v(t._s(e.item.unit))]),t._v(" "),s("td",[t._v(t._s(e.item.manufacturer))]),t._v(" "),s("td",[t._v("1")]),t._v(" "),s("td",[t._v(t._s(e.item.price1))]),t._v(" "),s("td",[t._v(t._s(e.item.price2))]),t._v(" "),s("td",[t._v(t._s(e.item.price3))]),t._v(" "),s("td",[t._v(t._s(e.item.price1))]),t._v(" "),s("td",[s("v-btn",{attrs:{outline:""},on:{click:function(s){t.deleteOneOrderItem(e.item)}}},[t._v("삭제")])],1)]}}])})],1)],1),t._v(" "),s("v-layout",{staticStyle:{"margin-top":"20px"}},[s("v-flex",{staticStyle:{"text-align":"center"}},[s("v-btn",{on:{click:function(e){t.$router.push("/purchase/buyerList")}}},[t._v("목록으로")]),t._v(" "),s("v-btn",{on:{click:function(e){t.regOrder()}}},[t._v("등록하기")])],1)],1),t._v(" "),s("v-dialog",{attrs:{width:"70%"},model:{value:t.appendModalCheck,callback:function(e){t.appendModalCheck=e},expression:"appendModalCheck"}},[s("v-card",[s("div",{staticStyle:{padding:"10px","background-color":"#263238",color:"white",height:"48px"}},[s("h3",[t._v("직배송 상품 선택")])]),t._v(" "),s("v-container",[s("v-layout",[s("v-flex",{attrs:{xs3:""}},[s("h2",[t._v("직배송 상품 선택")])])],1),t._v(" "),s("v-layout",{staticStyle:{"margin-top":"15px"}},[s("v-flex",{staticStyle:{padding:"0px 5px"},attrs:{xs8:""}},[s("v-layout",[s("v-flex",[t._v("\n                *해당 거래처에서 자주 주문한 상품 순입니다.\n              ")]),t._v(" "),s("v-flex",[t._v("\n                전체 "+t._s(t.allCount)+"건\n              ")])],1),t._v(" "),s("v-layout",{staticStyle:{"margin-top":"10px"}},[s("v-flex",[s("v-data-table",{attrs:{headers:t.productHeaders,items:t.purchaseProducts,"hide-actions":""},scopedSlots:t._u([{key:"items",fn:function(e){return[s("td",[t._v(t._s(e.item.itemName))]),t._v(" "),s("td",[t._v(t._s(e.item.itemQTY))]),t._v(" "),s("td",[t._v(t._s(e.item.price1))]),t._v(" "),s("td",[t._v(t._s(e.item.price2))]),t._v(" "),s("td",[t._v(t._s(e.item.price3))]),t._v(" "),s("td",[s("v-btn",{attrs:{outline:""},on:{click:function(s){t.selectProduct(e.item)}}},[t._v("선택")])],1)]}}])})],1)],1)],1),t._v(" "),s("v-flex",{staticStyle:{padding:"0px 5px"},attrs:{xs4:""}},[s("v-layout",[s("v-flex",[s("span",[t._v("선택상품 목록(전체 "+t._s(t.allCount)+"건)")])]),t._v(" "),s("v-flex",{staticStyle:{"text-align":"right"}},[s("v-btn",{on:{click:function(e){t.defaultSelectItem()}}},[t._v("초기화")])],1)],1),t._v(" "),s("v-layout",{staticStyle:{"margin-top":"10px",border:"2px solid #cccccc","min-height":"600px"}},[s("v-flex",{attrs:{xs12:"",md12:"",sm12:""}},[s("v-data-table",{attrs:{"hide-headers":"","hide-actions":"",items:t.selectItems},scopedSlots:t._u([{key:"items",fn:function(e){return[s("td",[s("v-layout",[s("v-flex",{attrs:{xs11:""}},[t._v(t._s(e.item.itemName))]),t._v(" "),s("v-flex",{attrs:{xs1:""}},[s("span",{on:{click:function(s){t.deleteOneItem(e.item)}}},[s("span",{staticClass:"fas fa-times"})])])],1),t._v(" "),s("v-layout",[s("v-flex",[s("span",{on:{click:function(s){t.countModify("up",e.index,e.item)}}},[s("span",{staticClass:"fas fa-angle-up"})]),t._v(" "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.count,expression:"count"}],staticStyle:{width:"30px","text-align":"center"},attrs:{type:"text"},domProps:{value:t.count},on:{input:function(e){e.target.composing||(t.count=e.target.value)}}}),t._v(" "),s("span",{on:{click:function(s){t.countModify("down",e.item)}}},[s("span",{staticClass:"fas fa-angle-down"})])]),t._v(" "),s("v-flex",[s("input",{directives:[{name:"model",rawName:"v-model",value:e.item.price2,expression:"props.item.price2"}],staticStyle:{"text-align":"right"},attrs:{type:"text"},domProps:{value:e.item.price2},on:{input:function(s){s.target.composing||t.$set(e.item,"price2",s.target.value)}}}),t._v("원\n                        ")])],1)],1)]}}])},[s("template",{slot:"footer"},[s("td",[s("v-layout",[s("v-flex",[t._v("합계 금액")]),t._v(" "),s("v-flex",{staticStyle:{"text-align":"right"}},[t._v(t._s(t.sumPrice)+"원")])],1)],1)])],2)],1)],1)],1)],1),t._v(" "),s("v-layout",{staticStyle:{"text-align":"center"}},[s("v-flex",[s("v-btn",{on:{click:function(e){t.closeProductAppendModal()}}},[t._v("닫기")]),t._v(" "),s("v-btn",{on:{click:function(e){t.saveOrderItem()}}},[t._v("저장")])],1)],1)],1)],1)],1)],1)},staticRenderFns:[]};var n=s("VU/8")(r,l,!1,function(t){s("WY6I")},"data-v-168248ba",null);e.default=n.exports},WY6I:function(t,e){}});
//# sourceMappingURL=23.6da4dd6e5851ba39857e.js.map