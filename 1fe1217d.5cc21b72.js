(window.webpackJsonp=window.webpackJsonp||[]).push([[17],{143:function(e,a,t){"use strict";t.r(a),t.d(a,"default",(function(){return m}));var n=t(0),r=t.n(n),o=t(157),c=(t(154),t(156),t(159),t(50),t(161));const l="https://app.amphoradata.com/Discover",i=(e,a)=>`Q.OrgId=7b429e6c-2885-49cf-994d-4775ae170d64&Q.Labels=${e}&Q.Take=${a||100}&handler=MapView`,s=[{title:"Weather forecasts",imageUrl:"img/forecast_image.PNG",description:" 7 day weather forecasts for any location in Australia 100s of\n                locations available now for $2 per month. More available on\n                request.",link:`${l}?${i("Forecasts")}`},{title:"Weather Observations",imageUrl:"img/weather_actuals.PNG",description:" Real-time actuals of weather parameters for any location in\n                Australia 100s of locations available now for $2 per month. More\n                available on request.",link:`${l}?${i("observations")}`},{title:"Solar Irradiance",imageUrl:"img/solar_image.PNG",description:" Real-time actuals of solar irradiance for any location in\n                Australia Any location available on request for $2 per month.",link:`${l}?${i("solar")}`}];function m(){return r.a.createElement(o.a,{title:"Data Catalogue"},r.a.createElement(c.c,{tabs:c.b,heading:"Data Products",subheading:"Get the insights you need in 30 seconds"},r.a.createElement(c.a,{products:s})))}},158:function(e,a,t){"use strict";t.d(a,"a",(function(){return l}));var n=t(0),r=t.n(n),o=t(156),c=t.n(o);t(49);const l=({children:e,className:a})=>r.a.createElement("div",{className:c()("buttons",a)},e)},161:function(e,a,t){"use strict";t.d(a,"b",(function(){return i})),t.d(a,"a",(function(){return E})),t.d(a,"c",(function(){return u}));var n=t(0),r=t.n(n),o=t(154),c=t(156),l=t.n(c);t(49);const i=[{to:"/data/vegetation",name:"Vegetation"},{to:"/data/weather",name:"Weather"},{to:"/data/water",name:"Water"},{to:"/data/soil",name:"Soil"},{to:"/data/economic",name:"Economic"}],s="undefined"!=typeof window,m=e=>{let a="";return s&&window&&window.location&&window.location.pathname&&(a=window.location.pathname.replace(/\/$/,"")),r.a.createElement(r.a.Fragment,null,r.a.createElement("div",{className:l()("row row--no-gutters mt-4 text--center tabs_row")},e.tabs.map(e=>r.a.createElement("div",{key:e.to,className:"col"},r.a.createElement(o.a,{className:"font_medium_bold text--black",to:e.to},r.a.createElement("div",{className:l()("buttons_tab",e.to===a&&"tab_active")},e.name))))),e.children)};var d=t(158);const u=e=>r.a.createElement(r.a.Fragment,null,r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"row mt-12"},r.a.createElement("div",{className:"col col--8"},r.a.createElement("div",{className:"font_large_caps"},e.heading),r.a.createElement("div",{className:"font_large"},e.subheading)),r.a.createElement("div",{className:"col col--4"},e.button||r.a.createElement(o.a,{to:"https://identity.amphoradata.com/Register"},r.a.createElement(d.a,null,"Get Data")))),r.a.createElement(m,{tabs:e.tabs}),e.children));var p=t(1),f=t(159);t(51);const E=({products:e})=>r.a.createElement(r.a.Fragment,null,r.a.createElement("div",null,e&&e.length&&r.a.createElement("section",{className:"data-products"},r.a.createElement("div",{className:"container"},e.map((e,a)=>r.a.createElement(g,Object(p.a)({key:a},e)))))));function g({imageUrl:e,title:a,description:t,link:n}){const o=Object(f.a)(e);return r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col"},o&&r.a.createElement("div",{className:"text--center",style:{paddingLeft:"30px",paddingRight:"30px"}},r.a.createElement("img",{src:o,alt:a}))),r.a.createElement("div",{className:"col"},r.a.createElement("h3",{className:"font_large"},a),r.a.createElement("p",{className:"font_medium"},t),n&&r.a.createElement("a",{target:"_blank",href:n},"View Data")))}}}]);