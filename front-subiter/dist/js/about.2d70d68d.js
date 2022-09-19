"use strict";(self["webpackChunkfront_subiter"]=self["webpackChunkfront_subiter"]||[]).push([[443],{9875:function(e,t,n){n.r(t),n.d(t,{default:function(){return P}});var o=function(){var e=this,t=e._self._c;return t("div",{staticClass:"agendamentos"},[t("div",{staticClass:"sub-menu"},[t("SearchComponent",{attrs:{ph:"Pesquisar"}}),t("CriarButtonComponent",{attrs:{txt:"CRIAR AGENDAMENTOS"},nativeOn:{click:function(t){return e.formAgendamento()}}})],1),t("FormAgendamento"),t("AgendamentosView",{attrs:{agendamentos:e.agendamentos}})],1)},l=[],r=n(269),a=n(9662),s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"content"},[t("h2",[e._v("Lista de acesso aos Agendamentos")]),t("table",[e._m(0),e._l(e.agendamentos,(function(n,o){return t("tr",{key:o},[t("td",[e._v(e._s(n.id))]),t("td",[e._v(e._s(n.horario))]),t("td",[e._v(e._s(n.endereco))]),t("td",[e._v(e._s(n.cidade))]),t("td",[e._v(e._s(n.cep))]),t("td",[e._v(e._s(n.estado))])])}))],2)])},d=[function(){var e=this,t=e._self._c;return t("tr",[t("th",[e._v("Código")]),t("th",[e._v("Horario")]),t("th",[e._v("Endereço")]),t("th",[e._v("Cidade")]),t("th",[e._v("CEP")]),t("th",[e._v("Estado")])])}],i={name:"AgendamentosView",props:{agendamentos:Array}},c=i,u=n(1001),m=(0,u.Z)(c,s,d,!1,null,null,null),_=m.exports,v=n(6265),h=n.n(v),f=function(){var e=this,t=e._self._c;return t("div",{staticClass:"modal",attrs:{id:"modal"}},[t("div",{staticClass:"box"},[t("svg",{staticClass:"css-i6dzq1",attrs:{viewBox:"0 0 24 24",width:"24",height:"24",stroke:"currentColor","stroke-width":"2",fill:"none","stroke-linecap":"round","stroke-linejoin":"round"},on:{click:function(t){return e.closeModal()}}},[t("line",{attrs:{x1:"18",y1:"6",x2:"6",y2:"18"}}),t("line",{attrs:{x1:"6",y1:"6",x2:"18",y2:"18"}})]),t("h3",[e._v("Cadastro de Agendamento")]),e._m(0),e._m(1),e._m(2),e._m(3),t("div",{staticClass:"buttons"},[t("button",{attrs:{id:"cancelar"},on:{click:function(t){return e.closeModal()}}},[e._v("Cancelar")]),t("button",{attrs:{id:"criar"},on:{click:function(t){return e.createSchedule()}}},[e._v("Criar")])])])])},p=[function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Endereço")]),t("textarea",{attrs:{type:"text",placeholder:"",id:"addressSchedule"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Cidade")]),t("textarea",{attrs:{type:"text",placeholder:"",id:"citySchedule"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("CEP")]),t("textarea",{attrs:{type:"text",placeholder:"",id:"cepSchedule"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Estado")]),t("textarea",{attrs:{type:"text",placeholder:"",id:"stateSchedule"}})])}],C={name:"FormAgendamento",methods:{closeModal(){var e=document.getElementById("modal"),t=e.querySelectorAll("input, textarea");e.style.display="none",t.forEach((e=>{e.value=""}))},createSchedule(){var e=document.getElementById("addressSchedule").value,t=document.getElementById("citySchedule").value,n=document.getElementById("cepSchedule").value,o=document.getElementById("stateSchedule").value;h().post("/schedule",{endereco:e,cidade:t,cep:n,estado:o}).then((e=>{console.log(e)})).catch((e=>console.log(e)))}}},g=C,y=(0,u.Z)(g,f,p,!1,null,null,null),x=y.exports,E={name:"AgendamentosComponents",components:{SearchComponent:r.Z,CriarButtonComponent:a.Z,AgendamentosView:_,FormAgendamento:x},data(){return{agendamentos:[]}},methods:{formAgendamento(){var e=document.getElementById("modal");e.style.display="flex"},closeModal(){var e=document.getElementById("modal");e.style.display="flex"}},created(){h().get("/schedule").then((e=>{console.log(e.data),this.agendamentos=e.data})).catch((e=>console.log(e)))}},k=E,B=(0,u.Z)(k,o,l,!1,null,null,null),P=B.exports},7547:function(e,t,n){n.r(t),n.d(t,{default:function(){return P}});var o=function(){var e=this,t=e._self._c;return t("div",{staticClass:"clientes"},[t("div",{staticClass:"sub-menu"},[t("SearchComponent",{attrs:{ph:"Pesquisar"}}),t("CriarButtonComponent",{attrs:{txt:"CRIAR CLIENTE"},nativeOn:{click:function(t){return e.formCliente()}}})],1),t("FormCliente"),t("ClientesView",{attrs:{clientes:e.clientes}})],1)},l=[],r=n(269),a=n(9662),s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"content"},[t("h2",[e._v("Lista de acesso aos Clientes")]),t("table",[e._m(0),e._l(e.clientes,(function(n,o){return t("tr",{key:o},[t("td",[e._v(e._s(n.id))]),t("td",[e._v(e._s(n.nome))]),t("td",[e._v(e._s(n.email))]),t("td",[e._v(e._s(n.razaoSocial))]),t("td",[e._v(e._s(n.telefone))])])}))],2)])},d=[function(){var e=this,t=e._self._c;return t("tr",[t("th",[e._v("Código")]),t("th",[e._v("Nome")]),t("th",[e._v("E-mail")]),t("th",[e._v("Razão Social")]),t("th",[e._v("Telefone")])])}],i={name:"ClientesView",props:{clientes:Array}},c=i,u=n(1001),m=(0,u.Z)(c,s,d,!1,null,null,null),_=m.exports,v=function(){var e=this,t=e._self._c;return t("div",{staticClass:"modal",attrs:{id:"modal"}},[t("div",{staticClass:"box"},[t("svg",{staticClass:"css-i6dzq1",attrs:{viewBox:"0 0 24 24",width:"24",height:"24",stroke:"currentColor","stroke-width":"2",fill:"none","stroke-linecap":"round","stroke-linejoin":"round"},on:{click:function(t){return e.closeModal()}}},[t("line",{attrs:{x1:"18",y1:"6",x2:"6",y2:"18"}}),t("line",{attrs:{x1:"6",y1:"6",x2:"18",y2:"18"}})]),t("h3",[e._v("Cadastro de Cliente")]),e._m(0),e._m(1),e._m(2),e._m(3),e._m(4),t("div",{staticClass:"buttons"},[t("button",{attrs:{id:"cancelar"},on:{click:function(t){return e.closeModal()}}},[e._v("Cancelar")]),t("button",{attrs:{id:"criar"},on:{click:function(t){return e.createClient()}}},[e._v("Criar")])])])])},h=[function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Nome")]),t("input",{attrs:{type:"text",placeholder:"",id:"nomeClient"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Razão Social")]),t("input",{attrs:{type:"text",placeholder:"",id:"socialreasonClient"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("E-mail")]),t("input",{attrs:{type:"email",placeholder:"",id:"emailClient"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("CNPJ")]),t("input",{attrs:{type:"text",placeholder:"",id:"cnpjClient"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Telefone")]),t("input",{attrs:{type:"tel",placeholder:"",id:"telClient"}})])}],f=n(6265),p=n.n(f),C={name:"FormCliente",methods:{closeModal(){var e=document.getElementById("modal"),t=e.querySelectorAll("input, textarea");e.style.display="none",t.forEach((e=>{e.value=""}))},createClient(){var e=document.getElementById("nomeClient").value,t=document.getElementById("telClient").value,n=document.getElementById("emailClient").value,o=document.getElementById("socialreasonClient").value,l=document.getElementById("cnpjClient").value;p().post("/userCorp",{nome:e,telefone:t,email:n,acessType:"SUPPORT",razaoSocial:o,cnpj:l}).then((e=>{console.log(e)})).catch((e=>console.log(e)))}}},g=C,y=(0,u.Z)(g,v,h,!1,null,null,null),x=y.exports,E={name:"ClientesComponents",components:{SearchComponent:r.Z,CriarButtonComponent:a.Z,ClientesView:_,FormCliente:x},data(){return{clientes:[]}},methods:{formCliente(){var e=document.getElementById("modal");e.style.display="flex"},closeModal(){var e=document.getElementById("modal");e.style.display="flex"}},created(){p().get("/users").then((e=>{console.log(e.data),this.clientes=e.data})).catch((e=>console.log(e)))}},k=E,B=(0,u.Z)(k,o,l,!1,null,null,null),P=B.exports},9814:function(e,t,n){n.r(t),n.d(t,{default:function(){return P}});var o=function(){var e=this,t=e._self._c;return t("div",{staticClass:"produtos"},[t("div",{staticClass:"sub-menu"},[t("SearchComponent",{attrs:{ph:"Pesquisar"}}),t("CriarButtonComponent",{attrs:{txt:"CRIAR PRODUTO"},nativeOn:{click:function(t){return e.formProduto()}}})],1),t("FormProduto"),t("ProdutosView",{attrs:{produtos:e.produtos}})],1)},l=[],r=n(269),a=n(9662),s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"modal",attrs:{id:"modal"}},[t("div",{staticClass:"box"},[t("svg",{staticClass:"css-i6dzq1",attrs:{viewBox:"0 0 24 24",width:"24",height:"24",stroke:"currentColor","stroke-width":"2",fill:"none","stroke-linecap":"round","stroke-linejoin":"round"},on:{click:function(t){return e.closeModal()}}},[t("line",{attrs:{x1:"18",y1:"6",x2:"6",y2:"18"}}),t("line",{attrs:{x1:"6",y1:"6",x2:"18",y2:"18"}})]),t("h3",[e._v("Cadastro de Produtos")]),e._m(0),e._m(1),e._m(2),t("hr"),e._m(3),t("div",{staticClass:"buttons"},[t("button",{attrs:{id:"cancelar"},on:{click:function(t){return e.closeModal()}}},[e._v("Cancelar")]),t("button",{attrs:{id:"criar"},on:{click:function(t){return e.createProduct()}}},[e._v("Criar")])])])])},d=[function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Modelo do produto")]),t("input",{attrs:{type:"text",placeholder:"Exemplo: Embarcação",id:"modelProduct"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Número de série")]),t("input",{attrs:{type:"text",placeholder:"Exemplo: 11, 12, 13",id:"serialnumberProduct"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Descrição")]),t("textarea",{attrs:{type:"text",id:"descriptionProduct"}})])},function(){var e=this,t=e._self._c;return t("fieldset",[t("legend",[e._v("Data de fabricação")]),t("input",{attrs:{type:"date",id:"fabdateProduct"}})])}],i=n(6265),c=n.n(i),u={name:"FormProduto",methods:{closeModal(){var e=document.getElementById("modal"),t=e.querySelectorAll("input, textarea");e.style.display="none",t.forEach((e=>{e.value=""}))},createProduct(){var e=document.getElementById("modelProduct").value,t=document.getElementById("serialnumberProduct").value,n=document.getElementById("descriptionProduct").value;c().post("/products",{modelo:e,numeroDeSerie:t,descricao:n}).then((e=>{console.log(e)})).catch((e=>console.log(e)))}}},m=u,_=n(1001),v=(0,_.Z)(m,s,d,!1,null,null,null),h=v.exports,f=function(){var e=this,t=e._self._c;return t("div",{staticClass:"content"},[t("h2",[e._v("Lista de acesso aos Produtos")]),t("table",[e._m(0),e._l(e.produtos,(function(n,o){return t("tr",{key:o},[t("td",[e._v(e._s(n.id))]),t("td",[e._v(e._s(n.modelo))]),t("td",[e._v(e._s(n.numeroDeSerie))]),t("td",[e._v(e._s(n.descricao))]),t("td",[e._v(e._s(n.dataCadastro))])])}))],2)])},p=[function(){var e=this,t=e._self._c;return t("tr",[t("th",[e._v("Código")]),t("th",[e._v("Produto")]),t("th",[e._v("Núm. de Série")]),t("th",[e._v("Descrição")]),t("th",[e._v("Data de Fabricação")])])}],C={name:"ProdutosView",props:{produtos:Array}},g=C,y=(0,_.Z)(g,f,p,!1,null,null,null),x=y.exports,E={name:"ProdutosComponents",components:{SearchComponent:r.Z,CriarButtonComponent:a.Z,FormProduto:h,ProdutosView:x},data(){return{produtos:[]}},methods:{formProduto(){var e=document.getElementById("modal");e.style.display="flex"},closeModal(){var e=document.getElementById("modal");e.style.display="flex"}},created(){c().get("/products").then((e=>{console.log(e.data),this.produtos=e.data})).catch((e=>console.log(e)))}},k=E,B=(0,_.Z)(k,o,l,!1,null,null,null),P=B.exports}}]);
//# sourceMappingURL=about.2d70d68d.js.map