---
id: python-find-data
title: Find Data with python SDK
sidebar_label: Find Data
---

You need to search the Amphora Data Catalogue to find the data you want. You need to purchase the Amphora after you find the one you want.

You can search for Amphora with the python SDK (v0.10+). The command is
```py
search_for_amphorae
```
You can search for Amphora by labels, location, or a term. You can search with Boolean OR and AND operators too.

Full code for searching is below
```py
credentials = Credentials(username=your_username, password=your_password)
client = AmphoraDataRepositoryClient(credentials)

# Search by location
amphora_list = client.search_for_amphorae(lat = -28.641, lon = 153.445, dist = 50)

# Search by labels
amphora_list = client.search_for_amphorae(labels = 'forecast')

# Search by term
amphora_list = client.search_for_amphorae(term = 'rainfall')

# Search all together with OR
amphora_list = client.search_for_amphorae(lat = -28.641, lon = 153.445, dist = 50, labels = 'forecast', term = 'rainfall', search_term = 'OR')

# Search all together with AND
amphora_list = client.search_for_amphorae(lat = -28.641, lon = 153.445, dist = 50, labels = 'forecast', term = 'rainfall', search_term = 'AND')
```

#### Get your own Amphoras

You can also get the list of your own Amphoras with
```py
client.get_your_amphorae()
```

## Buy an Amphora

You can buy an Amphora with the python SDK. The command is 
```py
client.buy_amphora(amphora_id)
```
Note that you must accept the terms and conditions in the Amphora through the web app. You only need to do this once for each terms and conditions, not for each Amphora.