---
id: microprediction
title: Working with Microprediction
sidebar_label: Microprediction
---

Microprediction is a leading open platform to share and score time series models. Microprediction can

* Clean and enrich live data
* Alert you to outliers and anomalies
* Provide you short term forecasts
* Identify patterns in model residuals

We work together with Microprediction to offer Amphora Data as an inbuilt data storage and collaboration tool.

## Getting started

To get started using Amphora and Microprediction together you need to install the appropriate SDKs with
```py
pip install amphora
```
and 
```py
pip install microprediction
```
You will also need an Amphora Data username and password (register for free here) as well as a key for Microprediction

## Pandemic

You can use Amphora Data to store daily snap shots of all your agents and to share and use others pandemic data. This saves your computational cost, and gives you more data to train models on and research the dynamics of the system.

The latest code for using Amphora with Pandemic is on [GitHub](https://github.com/microprediction/pandemic/blob/master/pandemic/amphora.py)

Use the Amphora callback with
```py
from pandemic.amphora import amphora_callback
```
You will need to store your Amphora username and password as environment variables as well as the `amphora id` if you want to push your data to an existing Amphora

Full code for using Amphora with Microprediction is below
```py

from pandemic.amphora import amphora_callback
from pandemic.example_parameters import HOMESICK
from pandemic.simulation import simulate

import os


os.environ["amphora_username"] = your_username
os.environ["amphora_password"] = your_password
os.environ["amphora_id"] = existing_amphora_id (optional)


## Set up log metrics
N_S=1

# Choose parameter set
param_set = "HOMESICK"
params = HOMESICK
       
                         
## Run pandemic and push to Amphora
for n_s in range(N_S):
    amphora_run_id = n_s
    
    print("Starting Simulation...")
    print(n_s)
    os.environ["amphora_run_id"] = str(n_s)
    simulate(params, callback=amphora_callback)
    
    print("Finished run")

```
## General support

We are looking to offer broader support and integration with Microprediction. Please come back later for more details or let us know which packages are best to support