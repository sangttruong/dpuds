(window.webpackJsonp=window.webpackJsonp||[]).push([[5],{153:function(e,r,n){"use strict";n.d(r,"a",(function(){return p})),n.d(r,"b",(function(){return f}));var t=n(0),o=n.n(t);function a(e,r,n){return r in e?Object.defineProperty(e,r,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[r]=n,e}function i(e,r){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var t=Object.getOwnPropertySymbols(e);r&&(t=t.filter((function(r){return Object.getOwnPropertyDescriptor(e,r).enumerable}))),n.push.apply(n,t)}return n}function s(e){for(var r=1;r<arguments.length;r++){var n=null!=arguments[r]?arguments[r]:{};r%2?i(Object(n),!0).forEach((function(r){a(e,r,n[r])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):i(Object(n)).forEach((function(r){Object.defineProperty(e,r,Object.getOwnPropertyDescriptor(n,r))}))}return e}function u(e,r){if(null==e)return{};var n,t,o=function(e,r){if(null==e)return{};var n,t,o={},a=Object.keys(e);for(t=0;t<a.length;t++)n=a[t],r.indexOf(n)>=0||(o[n]=e[n]);return o}(e,r);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(t=0;t<a.length;t++)n=a[t],r.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(o[n]=e[n])}return o}var c=o.a.createContext({}),l=function(e){var r=o.a.useContext(c),n=r;return e&&(n="function"==typeof e?e(r):s({},r,{},e)),n},p=function(e){var r=l(e.components);return o.a.createElement(c.Provider,{value:r},e.children)},b={inlineCode:"code",wrapper:function(e){var r=e.children;return o.a.createElement(o.a.Fragment,{},r)}},m=Object(t.forwardRef)((function(e,r){var n=e.components,t=e.mdxType,a=e.originalType,i=e.parentName,c=u(e,["components","mdxType","originalType","parentName"]),p=l(n),m=t,f=p["".concat(i,".").concat(m)]||p[m]||b[m]||a;return n?o.a.createElement(f,s({ref:r},c,{components:n})):o.a.createElement(f,s({ref:r},c))}));function f(e,r){var n=arguments,t=r&&r.mdxType;if("string"==typeof e||t){var a=n.length,i=new Array(a);i[0]=m;var s={};for(var u in r)hasOwnProperty.call(r,u)&&(s[u]=r[u]);s.originalType=e,s.mdxType="string"==typeof e?e:t,i[1]=s;for(var c=2;c<a;c++)i[c]=n[c];return o.a.createElement.apply(null,i)}return o.a.createElement.apply(null,n)}m.displayName="MDXCreateElement"},60:function(e,r,n){"use strict";n.r(r),n.d(r,"frontMatter",(function(){return i})),n.d(r,"metadata",(function(){return s})),n.d(r,"rightToc",(function(){return u})),n.d(r,"default",(function(){return l}));var t=n(1),o=n(6),a=(n(0),n(153)),i={id:"manage-users-in-org",title:"Manage users in your organisation",sidebar_label:"Manage users in your organisation"},s={unversionedId:"users_orgs/manage-users-in-org",id:"users_orgs/manage-users-in-org",isDocsHomePage:!1,title:"Manage users in your organisation",description:"Overview",source:"@site/docs/users_orgs/manage-users-in-org.md",permalink:"/docs/users_orgs/manage-users-in-org",editUrl:"https://github.com/facebook/docusaurus/edit/master/website/docs/users_orgs/manage-users-in-org.md",sidebar_label:"Manage users in your organisation",sidebar:"someSidebar",previous:{title:"How to invite a user into your organisation",permalink:"/docs/users_orgs/invite-to-organisation"},next:{title:"Personalise your url",permalink:"/docs/users_orgs/set-personalised-url"}},u=[{value:"Overview",id:"overview",children:[]}],c={rightToc:u};function l(e){var r=e.components,n=Object(o.a)(e,["components"]);return Object(a.b)("wrapper",Object(t.a)({},c,n,{components:r,mdxType:"MDXLayout"}),Object(a.b)("h2",{id:"overview"},"Overview"),Object(a.b)("p",null,"You can remove users in the ",Object(a.b)("inlineCode",{parentName:"p"},"Account")," tab if you are the administrator of your organisation. "),Object(a.b)("p",null,"Click ",Object(a.b)("inlineCode",{parentName:"p"},"Members")," to invite or remove members."),Object(a.b)("p",null,"We will release a programmatic way to do this in the future."))}l.isMDXComponent=!0}}]);