if(!self.define){let e,s={};const r=(r,i)=>(r=new URL(r+".js",i).href,s[r]||new Promise((s=>{if("document"in self){const e=document.createElement("script");e.src=r,e.onload=s,document.head.appendChild(e)}else e=r,importScripts(r),s()})).then((()=>{let e=s[r];if(!e)throw new Error(`Module ${r} didn’t register its module`);return e})));self.define=(i,n)=>{const o=e||("document"in self?document.currentScript.src:"")||location.href;if(s[o])return;let l={};const u=e=>r(e,o),c={module:{uri:o},exports:l,require:u};s[o]=Promise.all(i.map((e=>c[e]||u(e)))).then((e=>(n(...e),l)))}}define(["./workbox-db5fc017"],(function(e){"use strict";e.setCacheNameDetails({prefix:"api_subiter"}),self.addEventListener("message",(e=>{e.data&&"SKIP_WAITING"===e.data.type&&self.skipWaiting()})),e.precacheAndRoute([{url:"/css/about.bbbfe4bf.css",revision:null},{url:"/css/app.32651d20.css",revision:null},{url:"/css/chunk-vendors.b0c0bcba.css",revision:null},{url:"/img/Computer login-bro.4116b032.png",revision:null},{url:"/index.html",revision:"6a5b12fc7796f96887d7de84e0ce2b71"},{url:"/js/about.b157be2c.js",revision:null},{url:"/js/app.85cf2b34.js",revision:null},{url:"/js/chunk-vendors.86191f0b.js",revision:null},{url:"/manifest.json",revision:"46d5d51f83df43dd6d4be4c423885163"},{url:"/robots.txt",revision:"b6216d61c03e6ce0c9aea6ca7808f7ca"}],{})}));
//# sourceMappingURL=service-worker.js.map
