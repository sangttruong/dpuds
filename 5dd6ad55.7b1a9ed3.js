(window.webpackJsonp=window.webpackJsonp||[]).push([[38],{153:function(e,t,a){"use strict";a.d(t,"a",(function(){return u})),a.d(t,"b",(function(){return m}));var n=a(0),l=a.n(n);function r(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function o(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,n)}return a}function i(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?o(Object(a),!0).forEach((function(t){r(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):o(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}function b(e,t){if(null==e)return{};var a,n,l=function(e,t){if(null==e)return{};var a,n,l={},r=Object.keys(e);for(n=0;n<r.length;n++)a=r[n],t.indexOf(a)>=0||(l[a]=e[a]);return l}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(n=0;n<r.length;n++)a=r[n],t.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(e,a)&&(l[a]=e[a])}return l}var c=l.a.createContext({}),p=function(e){var t=l.a.useContext(c),a=t;return e&&(a="function"==typeof e?e(t):i({},t,{},e)),a},u=function(e){var t=p(e.components);return l.a.createElement(c.Provider,{value:t},e.children)},d={inlineCode:"code",wrapper:function(e){var t=e.children;return l.a.createElement(l.a.Fragment,{},t)}},s=Object(n.forwardRef)((function(e,t){var a=e.components,n=e.mdxType,r=e.originalType,o=e.parentName,c=b(e,["components","mdxType","originalType","parentName"]),u=p(a),s=n,m=u["".concat(o,".").concat(s)]||u[s]||d[s]||r;return a?l.a.createElement(m,i({ref:t},c,{components:a})):l.a.createElement(m,i({ref:t},c))}));function m(e,t){var a=arguments,n=t&&t.mdxType;if("string"==typeof e||n){var r=a.length,o=new Array(r);o[0]=s;var i={};for(var b in t)hasOwnProperty.call(t,b)&&(i[b]=t[b]);i.originalType=e,i.mdxType="string"==typeof e?e:n,o[1]=i;for(var c=2;c<r;c++)o[c]=a[c];return l.a.createElement.apply(null,o)}return l.a.createElement.apply(null,a)}s.displayName="MDXCreateElement"},98:function(e,t,a){"use strict";a.r(t),a.d(t,"frontMatter",(function(){return o})),a.d(t,"metadata",(function(){return i})),a.d(t,"rightToc",(function(){return b})),a.d(t,"default",(function(){return p}));var n=a(1),l=a(6),r=(a(0),a(153)),o={id:"python-upload-file",title:"Uploading a file with Python",sidebar_label:"Upload a file"},i={unversionedId:"SDKs/python-upload-file",id:"SDKs/python-upload-file",isDocsHomePage:!1,title:"Uploading a file with Python",description:"You can upload flat files to an Amphora. A flat file could be an image, a table, a text file or anything!. You can upload multiple files to a single Amphora. You can upload flat files alongside signals as well if you like.",source:"@site/docs/SDKs/python-upload-file.md",permalink:"/docs/SDKs/python-upload-file",editUrl:"https://github.com/facebook/docusaurus/edit/master/website/docs/SDKs/python-upload-file.md",sidebar_label:"Upload a file",sidebar:"someSidebar",previous:{title:"Creating an Amphora with Python",permalink:"/docs/SDKs/python-create-amphora"},next:{title:"Creating and uploading signals with Python",permalink:"/docs/SDKs/python-upload-signal"}},b=[{value:"Upload a file",id:"upload-a-file",children:[]},{value:"View your file online",id:"view-your-file-online",children:[]},{value:"Download the file",id:"download-the-file",children:[]},{value:"Query the remote files",id:"query-the-remote-files",children:[{value:"File Query Options",id:"file-query-options",children:[]}]},{value:"Other tips and tricks",id:"other-tips-and-tricks",children:[]},{value:"Other code to get you started",id:"other-code-to-get-you-started",children:[]}],c={rightToc:b};function p(e){var t=e.components,a=Object(l.a)(e,["components"]);return Object(r.b)("wrapper",Object(n.a)({},c,a,{components:t,mdxType:"MDXLayout"}),Object(r.b)("p",null,"You can upload flat files to an Amphora. A flat file could be an image, a table, a text file or anything!. You can upload multiple files to a single Amphora. You can upload flat files alongside signals as well if you like."),Object(r.b)("h2",{id:"upload-a-file"},"Upload a file"),Object(r.b)("p",null,"Uploading a file is easy. Make sure you have the ",Object(r.b)("inlineCode",{parentName:"p"},"amphora_id")," of the Amphora that you want to upload a file to. To upload a file simple use the ",Object(r.b)("inlineCode",{parentName:"p"},"amphora.push_file")," as shown below. You can also override the filename if you like."),Object(r.b)("pre",null,Object(r.b)("code",Object(n.a)({parentName:"pre"},{className:"language-py"}),"name_override= \"replaces-the-name-when-uploaded\"\nattributes = {'label': 'value'} # use attributes to organise your files\nfile_path=\"path/to/your/local/file\" # the path to the file on your machine\n\n# upload to the amphora\namphora.push_file(file_path, file_name= name_override, attributes= attributes)\n")),Object(r.b)("p",null,"The file uploader extension wraps some fundamental SDK calls, and simply let's you upload a file from disk. "),Object(r.b)("blockquote",null,Object(r.b)("p",{parentName:"blockquote"},"Note: File Attribute keys must be purely alphabetical ")),Object(r.b)("h2",{id:"view-your-file-online"},"View your file online"),Object(r.b)("p",null,"Your file should now be available on Amphora Data, in the Amphora you just referenced. Replace the id in the link below to check your file exists."),Object(r.b)("p",null,Object(r.b)("inlineCode",{parentName:"p"},"https://app.amphoradata.com/Amphorae/Files?id=<YOUR AMPHORA ID>")),Object(r.b)("h2",{id:"download-the-file"},"Download the file"),Object(r.b)("p",null,"Downloading the file via the SDK is simple:"),Object(r.b)("pre",null,Object(r.b)("code",Object(n.a)({parentName:"pre"},{className:"language-py"}),'amphora.get_file(override_file_name).pull("a_local_file.txt") # downloads the file to your local machine\n')),Object(r.b)("h2",{id:"query-the-remote-files"},"Query the remote files"),Object(r.b)("p",null,"When there are many files in an Amphora, it's best to do some filtering on the server. For example, you can query by attributes like so:"),Object(r.b)("pre",null,Object(r.b)("code",Object(n.a)({parentName:"pre"},{className:"language-py"}),"# file_names only contains files with the attribute colour = green\nfile_names = amphora.get_files(attributes={'colour': 'green'})\n")),Object(r.b)("p",null,"See the table below for options on how to filter files."),Object(r.b)("h3",{id:"file-query-options"},"File Query Options"),Object(r.b)("table",null,Object(r.b)("thead",{parentName:"table"},Object(r.b)("tr",{parentName:"thead"},Object(r.b)("th",Object(n.a)({parentName:"tr"},{align:null}),"parameter"),Object(r.b)("th",Object(n.a)({parentName:"tr"},{align:null}),"default value"),Object(r.b)("th",Object(n.a)({parentName:"tr"},{align:null}),"type"),Object(r.b)("th",Object(n.a)({parentName:"tr"},{align:null}),"notes"))),Object(r.b)("tbody",{parentName:"table"},Object(r.b)("tr",{parentName:"tbody"},Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"take"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"64"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"integer"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"Must be > 0")),Object(r.b)("tr",{parentName:"tbody"},Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"skip"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"0"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"integer"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"Must be > 0")),Object(r.b)("tr",{parentName:"tbody"},Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"order_by"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"'Alphabetical'"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"string"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"Alphabetical or LastModified")),Object(r.b)("tr",{parentName:"tbody"},Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"attributes"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"dictionary"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"{}"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}))),Object(r.b)("tr",{parentName:"tbody"},Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"all_attributes"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"boolean"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"False"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"If true, files must have all attributes specified in attributes")),Object(r.b)("tr",{parentName:"tbody"},Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"prefix"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"null"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}),"string"),Object(r.b)("td",Object(n.a)({parentName:"tr"},{align:null}))))),Object(r.b)("h2",{id:"other-tips-and-tricks"},"Other tips and tricks"),Object(r.b)("p",null,"You can check your Amphora exists by looking at its metadata"),Object(r.b)("pre",null,Object(r.b)("code",Object(n.a)({parentName:"pre"},{className:"language-py"}),'amphora_id="00000000-0000-0000-0000-00000000000" # use the id of the amphora you created previously\n\namphora = client.get_amphora(amphora_id) # gets a reference to the Amphora\nprint(amphora.metadata) \n')),Object(r.b)("h2",{id:"other-code-to-get-you-started"},"Other code to get you started"),Object(r.b)("p",null,"You can get code to get you started ",Object(r.b)("a",Object(n.a)({parentName:"p"},{href:"https://github.com/amphoradata/samples/blob/master/generic_templates/Push_a_file.py"}),"here")," and ",Object(r.b)("a",Object(n.a)({parentName:"p"},{href:"https://github.com/amphoradata/samples/blob/master/generic_templates/Pull_a_file.py"}),"here")))}p.isMDXComponent=!0}}]);