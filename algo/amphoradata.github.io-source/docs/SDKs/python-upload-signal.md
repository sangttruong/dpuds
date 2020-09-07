---
id: python-upload-signal
title: Creating and uploading signals with Python
sidebar_label: Upload a Signal
---

## What is a signal?

A signal is an updating time series. Examples of signals are weather forecasts, market prices, soil moisture, Covid infections e.t.c.

If you want to use flat files as well, check out how to [store an arbitrary file](./python-upload-file) here.

## Setup your client
First setup your client so you can access the Amphora Data platform
```py
from amphora.client import AmphoraDataRepositoryClient, Credentials

# provide your login credentials
credentials = Credentials(username="username", password="your password")
# create a client for interacting with the public Amphora Data Repository
client = AmphoraDataRepositoryClient(credentials)
```
If you are using a code repository, you may want to use 
```py
credentials = Credentials(username=os.getenv('username'), password=os.getenv('password'))
```

## Define signals on your Amphora

> Currently, Amphora are limited to 10 signals each.

Before you can upload data, you need to define the properties for which you'll be providing numeric values. A signal needs a name and units. You can also add other attributes or assign a different value type.
```py
amphora.create_signal("temperature", attributes={"units":"celcius", "custom":"any string"}) # units are a special attribute
amphora.create_signal("description", value_type="String") # override the default 'Numeric' value type

```

## Create a signal
A signal needs to be created as an array of dictionarys. Each dictionary item needs to have a ```datetime```, and a signal with a value.
The minimum definition for a signal is 
```py
signal = [dict(t = datetime.now(), temperature = 30)]
```
In general we want to create signals over multiple times. You can do this with specific definitions for different time points
```py
yesterday = datetime.now() + timedelta(hours=-24)
tomorrow = datetime.now() + timedelta(hours=24)

signals = [
    dict(
        t = yesterday, # use the 't' property to set a custom timestamp
        temperature = 27,
        description = 'Nice and Warm'
        ),
    dict(
        temperature = 17, # ignoring the timestamp means the values are interpreted as occurring now
        description = 'A Bit Chilly'
        ),
    dict(
        t = yesterday, # You can use times in the future
        temperature = 25 # properties are all optional
        )
]
```
You can also do this programatically like here
```py
signals = []
for t in range(T):
    signals.append(dict(t=datetimevariable[t], temperature = temp[t]))
```

## Push signal to your Amphora
Uploading your signal to the Amphora is very easy. Simply use the command below
```py
amphora.push_signals_dict_array(signals) # this sends the data to Amphora Data
```

## View your data at Amphora Data

You're data should now be live in the Amphora you specified. Replace the following id with your Amphora's id, and visit the link.

`https://app.amphoradata.com/Amphorae/Signals?id=<YOUR AMPHORA ID>`

Your data is now live!

## Use Pandas DataFrames

You can upload Signal data from Pandas DataFrames. By setting the column names, the SDK will automatically create the Signal definitions for you, by inferring the value type from the data.

```py
import pandas as pd

# make some timestamps
yesterday = datetime.now() + timedelta(hours=-24)
now = datetime.now()
tomorrow = datetime.now() + timedelta(hours=24)

# intialise data of lists.
data  = [['tom', 10], ['nick', 15], ['juli', 14]] 
df = pd.DataFrame(data, columns = ['name', 'age'])

amphora.push_signals_df(df, auto=True) # setting auto to true will automatically create the signal definitions for you.
```
## Other code to get you started
You can get code to get you started [here](https://github.com/amphoradata/samples/blob/master/generic_templates/Create_a_Signal.py) and [here](https://github.com/amphoradata/samples/blob/master/generic_templates/Update_a_signal.py)
