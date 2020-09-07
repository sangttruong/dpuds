---
id: understand-applications
title: Understand Applications
sidebar_label: Understand
---

`Applications` are 3rd party apps, created by Amphora Data users, that enable the users of that 3rd party applications to login to Amphora Data and connect to their data sources.

> Custom applications are only available to Organisations on the Institution Plan.

# FAQ 

## Why use applications?

Different data need different presentation. At Amphora Data, we're agnostic about the best way to present your users with information. Applications give you all the power of the Amphora Data API and Identity system in your own application.

## How do users authenticate?

Users must sign in to to an Application to use any Amphora features. Amphora Data uses OAuth and Open ID Connect to securely authenticate users. By creating an Application in Amphora Data, you are enabling 2 required features:

* CORS requests. When you create an Application, you can specify a number of `Origins`. When a browser attempts to connect to the Amphora Data API or Identity services from that origin, ours CORS policies will tell the client browser it is able to connect.

[Learn more about CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)

* OAuth redirect url(s). When you create an Application, you are telling the Amphora Data Identity service to let Amphora users login to that application. 

> You won't be able to log into any 3rd party application if you have not registered first.