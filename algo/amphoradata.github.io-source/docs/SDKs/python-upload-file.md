---
id: python-upload-file
title: Uploading a file with Python
sidebar_label: Upload a file
---

You can upload flat files to an Amphora. A flat file could be an image, a table, a text file or anything!. You can upload multiple files to a single Amphora. You can upload flat files alongside signals as well if you like.

## Upload a file
Uploading a file is easy. Make sure you have the ```amphora_id``` of the Amphora that you want to upload a file to. To upload a file simple use the ```amphora.push_file``` as shown below. You can also override the filename if you like.

```py
name_override= "replaces-the-name-when-uploaded"
attributes = {'label': 'value'} # use attributes to organise your files
file_path="path/to/your/local/file" # the path to the file on your machine

# upload to the amphora
amphora.push_file(file_path, file_name= name_override, attributes= attributes)
```
The file uploader extension wraps some fundamental SDK calls, and simply let's you upload a file from disk. 

> Note: File Attribute keys must be purely alphabetical 

## View your file online

Your file should now be available on Amphora Data, in the Amphora you just referenced. Replace the id in the link below to check your file exists.

`https://app.amphoradata.com/Amphorae/Files?id=<YOUR AMPHORA ID>`

## Download the file

Downloading the file via the SDK is simple:

```py
amphora.get_file(override_file_name).pull("a_local_file.txt") # downloads the file to your local machine
```

## Query the remote files

When there are many files in an Amphora, it's best to do some filtering on the server. For example, you can query by attributes like so:

```py
# file_names only contains files with the attribute colour = green
file_names = amphora.get_files(attributes={'colour': 'green'})
```

See the table below for options on how to filter files.

### File Query Options

| parameter      | default value  | type    | notes                                                           |
|----------------|----------------|---------|-----------------------------------------------------------------|
| take           | 64             | integer | Must be > 0                                                     |
| skip           | 0              | integer | Must be > 0                                                     |
| order_by       | 'Alphabetical' | string  | Alphabetical or LastModified                                    |
| attributes     | dictionary     | {}      |                                                                 |
| all_attributes | boolean        | False   | If true, files must have all attributes specified in attributes |
| prefix         | null           | string  |                                                                 |

## Other tips and tricks

You can check your Amphora exists by looking at its metadata
```py
amphora_id="00000000-0000-0000-0000-00000000000" # use the id of the amphora you created previously

amphora = client.get_amphora(amphora_id) # gets a reference to the Amphora
print(amphora.metadata) 
```

## Other code to get you started
You can get code to get you started [here](https://github.com/amphoradata/samples/blob/master/generic_templates/Push_a_file.py) and [here](https://github.com/amphoradata/samples/blob/master/generic_templates/Pull_a_file.py)
