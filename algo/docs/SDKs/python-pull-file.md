---
id: python-download-file
title: Download a file with Python
sidebar_label: Download a file
---

You can download flat files from an Amphora. A flat file could be an image, a table, a text file or anything!. 

## Download a file
Downloading a file is easy. First login and get a client

```py
credentials = Credentials(username='your_username', password='your_password') 
client = AmphoraDataRepositoryClient(credentials)
```
Then simply get the Amphora object and use `get_file` and `pull` as shown here
```py
amphora = client.get_amphora(Amphora_id) 
amphora.get_file(file_name).pull(destination_file_path)
``` 

## Other code to get you started
You can get code to get you started [here](https://github.com/amphoradata/samples/blob/master/generic_templates/Pull_a_file.py)
