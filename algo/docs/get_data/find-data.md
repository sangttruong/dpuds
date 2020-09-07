---
id: find-data
title: Find Data
sidebar_label: Find Data
---

You need to search the Amphora Data Catalogue to find the data you want. You need to purchase the Amphora after you find the one you want.

## Search with web app

To find an Amphora, click Discover in the header. This will take you to a list of all Amphoras on the platform. 

You can search this list multiple ways 

![Data market search](/img/DataMarketSearch.jpg)

You can use the advanced search buttons to search for Amphora by 
1) Keywords
2) Location
3) Labels

#### Search with map

You can also view the data sets on a map if there is a specific location you are looking for.

## Search programmatically

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
