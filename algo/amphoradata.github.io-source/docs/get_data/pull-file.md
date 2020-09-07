---
id: pull-file
title: Pull flat file from an Amphora
sidebar_label: Pull File
---

> You must have purchased an Amphora to consume it's data

Flat files are static files such as tables, images, graphs, and text. You can download Amphora Files, either via the web application, or by using the REST API or any Amphora Data client SDK.

## Get file on web app

To consume an Amphora file (static file typically .txt or .csv) select `Files` on the left of the Amphora page. You will then see a a list of all the files in the Amphora.

![Flat file download](/img/add_file_amphora.png)

Simply click `Download` next to the file you want.

> Note that not all Amphoras contain Signals.

## Get file programmatically

Most of the time you will want to consume data programmatically. You can check out the latest SDKs, sample code and tutorials at [GitHub](https://github.com/amphoradata). We provide a public Open API specification at [api.amphoradata.com/swagger](https://api.amphoradata.com/swagger/). We currently generate and provide a C# SDK, Node.js SDK, and Python SDK.

#### Python

You can pull a file with python using
```py
amphora.get_file(file_name).pull(destination_file_path)
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

# Pull file
amphora.get_file(file_name).pull(destination_file_path)
```
You can download this code from [GitHub](https://github.com/amphoradata/samples/blob/master/generic_templates/Pull_a_file.py).

#### C#
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/dotnet-sdk/tree/master/sample). We are expanding our docs for C# so stay tuned for more details.

#### Node.js
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/nodejs-sdk/tree/master/samples). We are expanding our docs for Node.js so stay tuned for more details.
