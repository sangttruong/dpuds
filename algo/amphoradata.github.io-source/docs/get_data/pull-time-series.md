---
id: pull-time-series
title: Pull Time Series (Signal) from an Amphora
sidebar_label: Pull Time Series
---

> You must have purchased an Amphora to consume it's data

Signals are live time-series. You can view and download Signals, either via the web application, or by using the REST API or any Amphora Data client SDK.

## Get Signal on web app

To view an Amphora Signal click `Signals` on the left of the Amphora page. You will see a set of graphs similar to below.

![View signal image](/img/view_signal_amphora.png)

This is an exploratory dashboard and it enables you to discover the data in a simple format. You can choose different signals, different time boxes, and filter by specific values or properties.

You can download the selected timeseries by clicking the `...` button and selecting `Download`.

> Note that not all Amphoras contain Signals.

## Get Signal programmatically

Most of the time you will want to consume data programmatically. You can check out the latest SDKs, sample code and tutorials at [GitHub](https://github.com/amphoradata). We provide a public Open API specification at [api.amphoradata.com/swagger](https://api.amphoradata.com/swagger/). We currently generate and provide a C# SDK, Node.js SDK, and Python SDK.

#### Python

You can pull a file with python using
```py
amphora.get_signals()
```

The basic code to get started pulling files is
```py
# Import Amphora modules
from amphora.client import AmphoraDataRepositoryClient, Credentials

# Import non-Amphora modules
import os

# Login to amphoradata.com
credentials = Credentials(username=os.getenv('username'), password=os.getenv('password'))
client = AmphoraDataRepositoryClient(credentials)

# Get Amphora object
amphora = client.get_amphora(Amphora_id)

# Pull signal
signals = amphora.get_signals()
```
You can download this code from [GitHub](https://github.com/amphoradata/samples/blob/master/generic_templates/Pull_a_signal.py). You can watch a [tutorial video](https://www.youtube.com/watch?v=tvRC5bBfEsA) too. There is also more detailed docs in the Python SDK section.

#### C#
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/dotnet-sdk/tree/master/sample). We are expanding our docs for C# so stay tuned for more details.

#### Node.js
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/nodejs-sdk/tree/master/samples). We are expanding our docs for Node.js so stay tuned for more details.
