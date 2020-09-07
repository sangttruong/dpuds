(window.webpackJsonp=window.webpackJsonp||[]).push([[31],{153:function(e,t,a){"use strict";a.d(t,"a",(function(){return b})),a.d(t,"b",(function(){return h}));var r=a(0),n=a.n(r);function o(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function i(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,r)}return a}function c(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?i(Object(a),!0).forEach((function(t){o(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):i(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}function l(e,t){if(null==e)return{};var a,r,n=function(e,t){if(null==e)return{};var a,r,n={},o=Object.keys(e);for(r=0;r<o.length;r++)a=o[r],t.indexOf(a)>=0||(n[a]=e[a]);return n}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(r=0;r<o.length;r++)a=o[r],t.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(e,a)&&(n[a]=e[a])}return n}var s=n.a.createContext({}),p=function(e){var t=n.a.useContext(s),a=t;return e&&(a="function"==typeof e?e(t):c({},t,{},e)),a},b=function(e){var t=p(e.components);return n.a.createElement(s.Provider,{value:t},e.children)},d={inlineCode:"code",wrapper:function(e){var t=e.children;return n.a.createElement(n.a.Fragment,{},t)}},u=Object(r.forwardRef)((function(e,t){var a=e.components,r=e.mdxType,o=e.originalType,i=e.parentName,s=l(e,["components","mdxType","originalType","parentName"]),b=p(a),u=r,h=b["".concat(i,".").concat(u)]||b[u]||d[u]||o;return a?n.a.createElement(h,c({ref:t},s,{components:a})):n.a.createElement(h,c({ref:t},s))}));function h(e,t){var a=arguments,r=t&&t.mdxType;if("string"==typeof e||r){var o=a.length,i=new Array(o);i[0]=u;var c={};for(var l in t)hasOwnProperty.call(t,l)&&(c[l]=t[l]);c.originalType=e,c.mdxType="string"==typeof e?e:r,i[1]=c;for(var s=2;s<o;s++)i[s]=a[s];return n.a.createElement.apply(null,i)}return n.a.createElement.apply(null,a)}u.displayName="MDXCreateElement"},92:function(e,t,a){"use strict";a.r(t),a.d(t,"frontMatter",(function(){return i})),a.d(t,"metadata",(function(){return c})),a.d(t,"rightToc",(function(){return l})),a.d(t,"default",(function(){return p}));var r=a(1),n=a(6),o=(a(0),a(153)),i={id:"create-amphora",title:"Create an Amphora",sidebar_label:"Create Amphora"},c={unversionedId:"share_data/create-amphora",id:"share_data/create-amphora",isDocsHomePage:!1,title:"Create an Amphora",description:"An Amphora is a standardised data container. To share your data, you need to create an Amphora then fill it with whatever data you want.",source:"@site/docs/share_data/create-amphora.md",permalink:"/docs/share_data/create-amphora",editUrl:"https://github.com/facebook/docusaurus/edit/master/website/docs/share_data/create-amphora.md",sidebar_label:"Create Amphora",sidebar:"someSidebar",previous:{title:"Raise an issue in GitHub",permalink:"/docs/get_data/github-issue"},next:{title:"Add File to Amphora",permalink:"/docs/share_data/add-file"}},l=[{value:"Create the Amphora",id:"create-the-amphora",children:[]},{value:"Set terms and conditions",id:"set-terms-and-conditions",children:[]},{value:"Tips for best practice",id:"tips-for-best-practice",children:[]}],s={rightToc:l};function p(e){var t=e.components,a=Object(n.a)(e,["components"]);return Object(o.b)("wrapper",Object(r.a)({},s,a,{components:t,mdxType:"MDXLayout"}),Object(o.b)("p",null,"An Amphora is a standardised data container. To share your data, you need to create an Amphora then fill it with whatever data you want."),Object(o.b)("h2",{id:"create-the-amphora"},"Create the Amphora"),Object(o.b)("p",null,"Navigate to the ",Object(o.b)("inlineCode",{parentName:"p"},"Share")," page, and you will get the screen below"),Object(o.b)("p",null,Object(o.b)("img",Object(r.a)({parentName:"p"},{src:"/img/nav_create_amphora.png",alt:"Nav create amphora"}))),Object(o.b)("blockquote",null,Object(o.b)("p",{parentName:"blockquote"},"At this stage, you can describe the Amphora, but ",Object(o.b)("em",{parentName:"p"},"not yet")," add any data. That comes later.")),Object(o.b)("p",null,"Give your Amphora a Name, Description, Price, and Geo-Location. You can search for locations, or just enter the Lat/Lon manually. These need to be entered into the fields below. You should also label it with data type, crop type etc and also select the appropriate Terms and Conditions."),Object(o.b)("p",null,"As Amphoras have standardised metadata, please ensure all fields are correct so others can find and use your Amphora."),Object(o.b)("h2",{id:"set-terms-and-conditions"},"Set terms and conditions"),Object(o.b)("p",null,"You can set the terms and conditions for each Amphora when you create it. You can either do this with the web interface or programatically with the API (just use the right ID)."),Object(o.b)("p",null,"If you need to create a new terms and conditions document, you can create it in your organisation page."),Object(o.b)("h2",{id:"tips-for-best-practice"},"Tips for best practice"),Object(o.b)("p",null,"There are several key features to include when creating a comprehensive and descriptive Amphora:"),Object(o.b)("h4",{id:"name"},"Name"),Object(o.b)("ul",null,Object(o.b)("li",{parentName:"ul"},Object(o.b)("p",{parentName:"li"},"Be descriptive but concise about the information contained in the Amphora")),Object(o.b)("li",{parentName:"ul"},Object(o.b)("p",{parentName:"li"},"Include the region, with state if applicable")),Object(o.b)("li",{parentName:"ul"},Object(o.b)("p",{parentName:"li"},"Try to avoid overly technical terms where possible*"))),Object(o.b)("h4",{id:"description"},"Description:"),Object(o.b)("ul",null,Object(o.b)("li",{parentName:"ul"},"Indicate where the data came from, including all sources, and what the target region is."),Object(o.b)("li",{parentName:"ul"},"Describe each signal contained in the Amphora including units.")),Object(o.b)("h4",{id:"price"},"Price:"),Object(o.b)("ul",null,Object(o.b)("li",{parentName:"ul"},"Be sure to put the correct monthly cost, or 0 for free data")),Object(o.b)("h4",{id:"labels"},"Labels:"),Object(o.b)("ul",null,Object(o.b)("li",{parentName:"ul"},Object(o.b)("p",{parentName:"li"},"You can add up to ",Object(o.b)("strong",{parentName:"p"},"10 labels"),", each with a maximum length of ",Object(o.b)("strong",{parentName:"p"},"12 characters"),".")),Object(o.b)("li",{parentName:"ul"},Object(o.b)("p",{parentName:"li"},"Use several semantically relevant labels, as they are indexed when searching. For example:"),Object(o.b)("ul",{parentName:"li"},Object(o.b)("li",{parentName:"ul"},"structure of the data (e.g. tabular, image, time series)"),Object(o.b)("li",{parentName:"ul"},"the data category (e.g. weather, NDVI)")))),Object(o.b)("h4",{id:"tscs"},"Ts&Cs:"),Object(o.b)("ul",null,Object(o.b)("li",{parentName:"ul"},Object(o.b)("p",{parentName:"li"},"Check documents associated with the data source and publish the data under the right terms and conditions")),Object(o.b)("li",{parentName:"ul"},Object(o.b)("p",{parentName:"li"},"Go to your organisation homepage and add new T&Cs if the required Ts&Cs aren't already listed"))),Object(o.b)("h4",{id:"geolocation"},"GeoLocation:"),Object(o.b)("ul",null,Object(o.b)("li",{parentName:"ul"},"Use the search bar or directly enter latitude and longitude of the region for which the data are aggregated"),Object(o.b)("li",{parentName:"ul"},"If there is no specific region for the Amphora then use the location of the body which generated the data (e.g. using the MLA office in North Sydney for their nation wide livestock data)")))}p.isMDXComponent=!0}}]);