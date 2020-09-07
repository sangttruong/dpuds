---
id: add-signal
title: Add a Time-Series (Signal) to your Amphora
sidebar_label: Share Time-Series
---
Amphoras are standardised data containers. To share your data, you need to create an Amphora then fill it with whatever data you want.

## Add Signal on web app

Signals are numeric data that change over time. Add a signal by clicking `New Signal` and specify the property (i.e. the name of the signal), e.g. temperature.

![Add signal amphora](/img/add_signal_amphora.png)

Now you can submit a value for that signal (e.g. the current temperature) via the `New Values` button. Once submitted, you'll start seeing data on the graph.

> It may take up to a minute for the new value to be processed and to show on the graph.


## Add Signal programmatically
There are two steps to adding a signal. You first need to add the Signal object then add data to the object.

#### Python
The basic code for creating the signal is
```py
amphora.create_signal("signal_name", attributes={"units":"XYZ"})
```
and the basic code for updating a signal is
```py
amphora.push_signals_dict_array(Signals)
```
You can get started adding and updating Signals with the code
```py
# Import Amphora modules
from amphora.client import AmphoraDataRepositoryClient, Credentials

# Import non-Amphora modules
import os

# Login to amphoradata.com
credentials = Credentials(username=os.getenv('username'), password=os.getenv('password'))
client = AmphoraDataRepositoryClient(credentials)

# Create signal object. Update as often as you wish
Signals = [dict(t = datetime_value, signal_name = signal_value)]

# Get Amphora object
amphora = client.get_amphora(Amphora_id)

# Create signal
amphora.create_signal("signal_name", attributes={"units":"XYZ"})

# Create update signal
amphora.push_signals_dict_array(Signals)
```
You can download this code from [GitHub](https://github.com/amphoradata/samples/blob/master/generic_templates/Create_a_Signal.py). There is also more detailed docs in the Python SDK section. There is also a [tutorial video](https://www.youtube.com/watch?v=M6kW4Po1LmY) you can watch too.

#### C#
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/dotnet-sdk/tree/master/sample). We are expanding our docs for C# so stay tuned for more details.

#### Node.js
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/nodejs-sdk/tree/master/samples). We are expanding our docs for Node.js so stay tuned for more details.
