---
id: python-create-amphora
title: Creating an Amphora with Python
sidebar_label: Create an Amphora
---

You can easily create an Amphora with the python SDK. We will first describe the Amphora that we want to create, then create it. 

Amphoras have standardised metadata. This enables you to quickly search, manage, and consume a variety of different datatypes.


## Describe Amphora
An Amphora needs a few key bits of metadata. This includes a name, description, and a price. We can create them with simple strings 
```py
# use meaningful name and descriptions for your Amphora
name = "Historical hay and feed yields"
description = "Hay yields over a 10 year period from 1999 - 2009.\n Data is stored in csv format, and all measurements are in kg."
# set a price you think is fair. It will be billed monthly.
price = 10 
```
We can also add some other metadata. This includes labels, location, data quality, e.t.c. We can do this as
```py
# use descriptive labels to appear on the Amphora such as data type, structure and other relevant information
labels = ["csv","timeseries","hay","yields"]

# set the correct location. These coordinates are Amphora Data's home office.
lat = -27.45714
lon = 153.07106
```
Then we need to import the right module from the SDK
```py
from amphora.client import AmphoraDataRepositoryClient
```
Finally, we can create our login client and create the Amphora
```py
client = AmphoraDataRepositoryClient(credentials)
amphora = client.create_amphora(name=name, description=desc, labels=labels, price=price, lat=lat, lon = lon)
```
You can check that your Amphora was created by printing its metadata
```py
print(amphora.metadata)
```

## Save the Id of your new Amphora

Amphora Data automatically creates unique identifiers for every new Amphora to prevent accidental duplications and inconsistencies. Its good practice to save the ids of new Amphora you create, so you can easily find them later.

```py
with open('amphora_id.txt', 'w') as f:
    f.write(f'{amphora.amphora_id}\n')
```
Your Amphora is created, and ready to fill with data!

## Other code to get you started
You can get code to get you started [here](https://github.com/amphoradata/samples/blob/master/generic_templates/Create_an_Amphora.py)
