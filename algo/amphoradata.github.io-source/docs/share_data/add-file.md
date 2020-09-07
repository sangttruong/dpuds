---
id: add-file
title: Add File to Amphora
sidebar_label: Share File
---
Amphoras are standardised data containers. To share your data, you need to create an Amphora then fill it with whatever data you want.

## Add File with web app

> The max file size for uploading through the web interface is currently 10MB. There is no size limit for uploading files through the API

You can add any kind of file to an Amphora - images, text files, csv, word documents etc. To upload a file from your computer, click the `upload` button, select a file, then click `upload`.

![Add file amphora](/img/add_file_amphora.png)

> Note that you need a steady connection to upload files and some users have reported issues due to poor connection with their internet providers.

## Add File programmatically

#### Python

You can add a file with python using
```py
amphora.push_file(file_path)
```
The basic code to get started add files is
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

# Push file to amphora
file_path="path/to/your/file"
amphora.push_file(file_path)
```
You can download this code from [GitHub](https://github.com/amphoradata/samples/blob/master/generic_templates/Push_a_file.py). There is also more detailed docs in the Python SDK section.

#### C#
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/dotnet-sdk/tree/master/sample). We are expanding our docs for C# so stay tuned for more details.

#### Node.js
Code for pulling signals can be found on [GitHub](https://github.com/amphoradata/nodejs-sdk/tree/master/samples). We are expanding our docs for Node.js so stay tuned for more details.
