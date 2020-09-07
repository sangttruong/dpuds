import React from "react";
import Head from "@docusaurus/Head";

export const CustomHead = (props) => (
    <Head>
        <meta charSet="utf-8" />
        <title>Amphora Data</title>

        <meta
            property="og:description"
            content="An advanced platform for sharing data and knowledge."
        />
        <meta
            property="og:image"
            content="https://www.amphoradata.com/img/logos/Amphora_Data_Cover.png"
        />
        <meta property="og:type" content="website" />
        <meta property="og:url" content="https://www.amphoradata.com/" />

        <link
            href="http://fonts.googleapis.com/css?family=Ropa+Sans"
            rel="stylesheet"
            type="text/css"
        ></link>
        <link
            href="http://fonts.googleapis.com/css?family=Roboto"
            rel="stylesheet"
            type="text/css"
        ></link>
        {props.children}
    </Head>
);
