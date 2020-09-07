(window.webpackJsonp=window.webpackJsonp||[]).push([[9],{153:function(e,t,r){"use strict";r.d(t,"a",(function(){return l})),r.d(t,"b",(function(){return b}));var n=r(0),a=r.n(n);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function i(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function c(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?i(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):i(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function s(e,t){if(null==e)return{};var r,n,a=function(e,t){if(null==e)return{};var r,n,a={},o=Object.keys(e);for(n=0;n<o.length;n++)r=o[n],t.indexOf(r)>=0||(a[r]=e[r]);return a}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(n=0;n<o.length;n++)r=o[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(a[r]=e[r])}return a}var p=a.a.createContext({}),u=function(e){var t=a.a.useContext(p),r=t;return e&&(r="function"==typeof e?e(t):c({},t,{},e)),r},l=function(e){var t=u(e.components);return a.a.createElement(p.Provider,{value:t},e.children)},d={inlineCode:"code",wrapper:function(e){var t=e.children;return a.a.createElement(a.a.Fragment,{},t)}},m=Object(n.forwardRef)((function(e,t){var r=e.components,n=e.mdxType,o=e.originalType,i=e.parentName,p=s(e,["components","mdxType","originalType","parentName"]),l=u(r),m=n,b=l["".concat(i,".").concat(m)]||l[m]||d[m]||o;return r?a.a.createElement(b,c({ref:t},p,{components:r})):a.a.createElement(b,c({ref:t},p))}));function b(e,t){var r=arguments,n=t&&t.mdxType;if("string"==typeof e||n){var o=r.length,i=new Array(o);i[0]=m;var c={};for(var s in t)hasOwnProperty.call(t,s)&&(c[s]=t[s]);c.originalType=e,c.mdxType="string"==typeof e?e:n,i[1]=c;for(var p=2;p<o;p++)i[p]=r[p];return a.a.createElement.apply(null,i)}return a.a.createElement.apply(null,r)}m.displayName="MDXCreateElement"},66:function(e,t,r){"use strict";r.r(t),r.d(t,"frontMatter",(function(){return i})),r.d(t,"metadata",(function(){return c})),r.d(t,"rightToc",(function(){return s})),r.d(t,"default",(function(){return u}));var n=r(1),a=r(6),o=(r(0),r(153)),i={id:"restict-users",title:"Restrict users for a specific Amphora",sidebar_label:"Restrict users for an Amphora"},c={unversionedId:"manage_data/restict-users",id:"manage_data/restict-users",isDocsHomePage:!1,title:"Restrict users for a specific Amphora",description:"Overview",source:"@site/docs/manage_data/restrict-users.md",permalink:"/docs/manage_data/restict-users",editUrl:"https://github.com/facebook/docusaurus/edit/master/website/docs/manage_data/restrict-users.md",sidebar_label:"Restrict users for an Amphora",sidebar:"someSidebar",previous:{title:"Set terms and conditions",permalink:"/docs/manage_data/set-tncs"},next:{title:"File Attributes",permalink:"/docs/files/attributes"}},s=[{value:"Overview",id:"overview",children:[]},{value:"Method",id:"method",children:[]}],p={rightToc:s};function u(e){var t=e.components,r=Object(a.a)(e,["components"]);return Object(o.b)("wrapper",Object(n.a)({},p,r,{components:t,mdxType:"MDXLayout"}),Object(o.b)("h2",{id:"overview"},"Overview"),Object(o.b)("p",null,"You can set specific restrictions on who can and who can't access data for your own Amphoras on the public data repository."),Object(o.b)("h2",{id:"method"},"Method"),Object(o.b)("p",null,"To do this, go to ",Object(o.b)("inlineCode",{parentName:"p"},"Options")," on the Amphora page."),Object(o.b)("p",null,"Then click ",Object(o.b)("inlineCode",{parentName:"p"},"Access Controls"),". You can restrict Organisations with their organisation id. The Priority indicates the importance of the restriction placed on an organisation."),Object(o.b)("p",null,Object(o.b)("img",Object(n.a)({parentName:"p"},{src:"/img/access_controls.png",alt:"Restrict Organisation"}))),Object(o.b)("p",null,"Note that you can only restrict existing organisations on the Amphora platform. If there is a specific organisation, e.g. close competitor, that is not yet on Amphora but you want to restrict, please email ",Object(o.b)("a",Object(n.a)({parentName:"p"},{href:"mailto:isaac@amphoradata.com"}),"isaac@amphoradata.com")))}u.isMDXComponent=!0}}]);