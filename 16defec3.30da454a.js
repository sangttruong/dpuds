(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{153:function(e,t,n){"use strict";n.d(t,"a",(function(){return l})),n.d(t,"b",(function(){return b}));var a=n(0),r=n.n(a);function o(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function i(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function s(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?i(Object(n),!0).forEach((function(t){o(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):i(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function c(e,t){if(null==e)return{};var n,a,r=function(e,t){if(null==e)return{};var n,a,r={},o=Object.keys(e);for(a=0;a<o.length;a++)n=o[a],t.indexOf(n)>=0||(r[n]=e[n]);return r}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(a=0;a<o.length;a++)n=o[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(r[n]=e[n])}return r}var d=r.a.createContext({}),p=function(e){var t=r.a.useContext(d),n=t;return e&&(n="function"==typeof e?e(t):s({},t,{},e)),n},l=function(e){var t=p(e.components);return r.a.createElement(d.Provider,{value:t},e.children)},u={inlineCode:"code",wrapper:function(e){var t=e.children;return r.a.createElement(r.a.Fragment,{},t)}},m=Object(a.forwardRef)((function(e,t){var n=e.components,a=e.mdxType,o=e.originalType,i=e.parentName,d=c(e,["components","mdxType","originalType","parentName"]),l=p(n),m=a,b=l["".concat(i,".").concat(m)]||l[m]||u[m]||o;return n?r.a.createElement(b,s({ref:t},d,{components:n})):r.a.createElement(b,s({ref:t},d))}));function b(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var o=n.length,i=new Array(o);i[0]=m;var s={};for(var c in t)hasOwnProperty.call(t,c)&&(s[c]=t[c]);s.originalType=e,s.mdxType="string"==typeof e?e:a,i[1]=s;for(var d=2;d<o;d++)i[d]=n[d];return r.a.createElement.apply(null,i)}return r.a.createElement.apply(null,n)}m.displayName="MDXCreateElement"},72:function(e,t,n){"use strict";n.r(t),n.d(t,"frontMatter",(function(){return i})),n.d(t,"metadata",(function(){return s})),n.d(t,"rightToc",(function(){return c})),n.d(t,"default",(function(){return p}));var a=n(1),r=n(6),o=(n(0),n(153)),i={id:"set-tncs",title:"Set terms and conditions",sidebar_label:"Set your Terms and Conditions"},s={unversionedId:"manage_data/set-tncs",id:"manage_data/set-tncs",isDocsHomePage:!1,title:"Set terms and conditions",description:"Overview",source:"@site/docs/manage_data/set-tncs.md",permalink:"/docs/manage_data/set-tncs",editUrl:"https://github.com/facebook/docusaurus/edit/master/website/docs/manage_data/set-tncs.md",sidebar_label:"Set your Terms and Conditions",sidebar:"someSidebar",previous:{title:"Manage a listed Amphora",permalink:"/docs/manage_data/manage"},next:{title:"Restrict users for a specific Amphora",permalink:"/docs/manage_data/restict-users"}},c=[{value:"Overview",id:"overview",children:[]},{value:"Create terms and conditions",id:"create-terms-and-conditions",children:[]},{value:"Assign terms and conditions to Amphora",id:"assign-terms-and-conditions-to-amphora",children:[]}],d={rightToc:c};function p(e){var t=e.components,n=Object(r.a)(e,["components"]);return Object(o.b)("wrapper",Object(a.a)({},d,n,{components:t,mdxType:"MDXLayout"}),Object(o.b)("h2",{id:"overview"},"Overview"),Object(o.b)("p",null,"One of the major features of the Amphora Data platform is the ability to set and agree to Terms and Conditions for using data. To do this as a Amphora creator, we need to be able to create and use a libary of Terms and Conditions"),Object(o.b)("h2",{id:"create-terms-and-conditions"},"Create terms and conditions"),Object(o.b)("p",null,"We can create a new terms and conditions from the ",Object(o.b)("a",Object(a.a)({parentName:"p"},{href:"https://app.amphoradata.com/Organisations/Detail"}),"Organisation page"),". Select the ",Object(o.b)("inlineCode",{parentName:"p"},"Terms and Conditions Libary")," button on the left hand side."),Object(o.b)("p",null,"Within the Terms and Conditions Library you can see all the documents your organisation has created. To create a new agreement, select ",Object(o.b)("inlineCode",{parentName:"p"},"Create")," from the top right hand corner. You will then be able to create new terms and conditions, with a name for all to see, and an ID so it can be accessed through API."),Object(o.b)("blockquote",null,Object(o.b)("p",{parentName:"blockquote"},"The terms and conditions are legal documents so please take all neccessary steps to ensure your organisation is happy with any documents you post.")),Object(o.b)("h2",{id:"assign-terms-and-conditions-to-amphora"},"Assign terms and conditions to Amphora"),Object(o.b)("p",null,"You can assign terms and conditions to an Amphora through two ways. "),Object(o.b)("p",null,"The first is through the GUI as you create the Amphora. For this method, select the appropriate terms and conditions in appropriate field"),Object(o.b)("p",null,Object(o.b)("img",Object(a.a)({parentName:"p"},{src:"/img/CreateAmphora.jpg",alt:"Create Amphora image"}))),Object(o.b)("p",null,"The second is through APIs. The latest python code for doing so can be found on GitHub and looks something like"),Object(o.b)("pre",null,Object(o.b)("code",Object(a.a)({parentName:"pre"},{className:"language-py"}),"amphora_client.CreateAmphoraDto(terms_and_conditions_id = The_ID_of_the_appropriate_TnC).\n")))}p.isMDXComponent=!0}}]);