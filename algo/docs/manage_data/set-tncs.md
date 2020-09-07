---
id: set-tncs
title: Set terms and conditions
sidebar_label: Set your Terms and Conditions
---


## Overview
One of the major features of the Amphora Data platform is the ability to set and agree to Terms and Conditions for using data. To do this as a Amphora creator, we need to be able to create and use a libary of Terms and Conditions

## Create terms and conditions

We can create a new terms and conditions from the [Organisation page](https://app.amphoradata.com/Organisations/Detail). Select the `Terms and Conditions Libary` button on the left hand side.

Within the Terms and Conditions Library you can see all the documents your organisation has created. To create a new agreement, select `Create` from the top right hand corner. You will then be able to create new terms and conditions, with a name for all to see, and an ID so it can be accessed through API.

> The terms and conditions are legal documents so please take all neccessary steps to ensure your organisation is happy with any documents you post.

## Assign terms and conditions to Amphora

You can assign terms and conditions to an Amphora through two ways. 

The first is through the GUI as you create the Amphora. For this method, select the appropriate terms and conditions in appropriate field

![Create Amphora image](/img/CreateAmphora.jpg)

The second is through APIs. The latest python code for doing so can be found on GitHub and looks something like

```py
amphora_client.CreateAmphoraDto(terms_and_conditions_id = The_ID_of_the_appropriate_TnC).
```

