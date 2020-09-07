(window.webpackJsonp=window.webpackJsonp||[]).push([[77],{133:function(e,r,t){"use strict";t.r(r),t.d(r,"frontMatter",(function(){return i})),t.d(r,"metadata",(function(){return c})),t.d(r,"rightToc",(function(){return l})),t.d(r,"default",(function(){return u}));var a=t(1),n=t(6),o=(t(0),t(153)),i={id:"email-amphora",title:"Share Amphora through email",sidebar_label:"Share Amphora through email"},c={unversionedId:"share_data/email-amphora",id:"share_data/email-amphora",isDocsHomePage:!1,title:"Share Amphora through email",description:"This feature will be deployed by end of April",source:"@site/docs/share_data/email-amphora.md",permalink:"/docs/share_data/email-amphora",editUrl:"https://github.com/facebook/docusaurus/edit/master/website/docs/share_data/email-amphora.md",sidebar_label:"Share Amphora through email",sidebar:"someSidebar",previous:{title:"Add a Time-Series (Signal) to your Amphora",permalink:"/docs/share_data/add-signal"},next:{title:"Edit an Amphora",permalink:"/docs/share_data/edit-amphora"}},l=[{value:"Description",id:"description",children:[]}],p={rightToc:l};function u(e){var r=e.components,t=Object(n.a)(e,["components"]);return Object(o.b)("wrapper",Object(a.a)({},p,t,{components:r,mdxType:"MDXLayout"}),Object(o.b)("blockquote",null,Object(o.b)("p",{parentName:"blockquote"},"This feature will be deployed by end of April")),Object(o.b)("h2",{id:"description"},"Description"),Object(o.b)("p",null,"You can easily share your favourite Amphora with any email address. Simply use"),Object(o.b)("pre",null,Object(o.b)("code",Object(a.a)({parentName:"pre"},{className:"language-py"}),'amphora = client.get_amphora("id-of-your-favourite-amphora")\namphora.share_with("my_friends_email@gmail.com")\n')),Object(o.b)("p",null,"Note this feature currently only works with the python SDK and will be released end of April."))}u.isMDXComponent=!0},153:function(e,r,t){"use strict";t.d(r,"a",(function(){return s})),t.d(r,"b",(function(){return b}));var a=t(0),n=t.n(a);function o(e,r,t){return r in e?Object.defineProperty(e,r,{value:t,enumerable:!0,configurable:!0,writable:!0}):e[r]=t,e}function i(e,r){var t=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);r&&(a=a.filter((function(r){return Object.getOwnPropertyDescriptor(e,r).enumerable}))),t.push.apply(t,a)}return t}function c(e){for(var r=1;r<arguments.length;r++){var t=null!=arguments[r]?arguments[r]:{};r%2?i(Object(t),!0).forEach((function(r){o(e,r,t[r])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(t)):i(Object(t)).forEach((function(r){Object.defineProperty(e,r,Object.getOwnPropertyDescriptor(t,r))}))}return e}function l(e,r){if(null==e)return{};var t,a,n=function(e,r){if(null==e)return{};var t,a,n={},o=Object.keys(e);for(a=0;a<o.length;a++)t=o[a],r.indexOf(t)>=0||(n[t]=e[t]);return n}(e,r);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(a=0;a<o.length;a++)t=o[a],r.indexOf(t)>=0||Object.prototype.propertyIsEnumerable.call(e,t)&&(n[t]=e[t])}return n}var p=n.a.createContext({}),u=function(e){var r=n.a.useContext(p),t=r;return e&&(t="function"==typeof e?e(r):c({},r,{},e)),t},s=function(e){var r=u(e.components);return n.a.createElement(p.Provider,{value:r},e.children)},m={inlineCode:"code",wrapper:function(e){var r=e.children;return n.a.createElement(n.a.Fragment,{},r)}},d=Object(a.forwardRef)((function(e,r){var t=e.components,a=e.mdxType,o=e.originalType,i=e.parentName,p=l(e,["components","mdxType","originalType","parentName"]),s=u(t),d=a,b=s["".concat(i,".").concat(d)]||s[d]||m[d]||o;return t?n.a.createElement(b,c({ref:r},p,{components:t})):n.a.createElement(b,c({ref:r},p))}));function b(e,r){var t=arguments,a=r&&r.mdxType;if("string"==typeof e||a){var o=t.length,i=new Array(o);i[0]=d;var c={};for(var l in r)hasOwnProperty.call(r,l)&&(c[l]=r[l]);c.originalType=e,c.mdxType="string"==typeof e?e:a,i[1]=c;for(var p=2;p<o;p++)i[p]=t[p];return n.a.createElement.apply(null,i)}return n.a.createElement.apply(null,t)}d.displayName="MDXCreateElement"}}]);