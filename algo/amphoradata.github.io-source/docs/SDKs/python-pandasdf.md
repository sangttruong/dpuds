---
id: python-pandasdf
title: Converting Amphora Signals to a Pandas DataFrame
sidebar_label: Get Pandas DataFrame
---

## Pandas Data Frame

Pandas is a very popular Python package for working with data. [Pandas Data Frames](https://pandas.pydata.org/pandas-docs/stable/reference/api/pandas.DataFrame.html) form the core of Pandas. Many data scientists love working with Data Frames, and many tools can import from this standard.

## Import the required modules

The `amphoradata` package does not come with pandas or numpy. You *must* install them yourself to use this module.

```sh
pip install numpy
pip install pandas
```

## Convert Signals to a Pandas DataFrame
You can convert signals to Dataframes very easily. First get the signal from the Amphora you want.
```py
client = AmphoraDataRepositoryClient(credentials)

# get a reference to an Amphora
amphora = client.get_amphora("e6097df0-952c-46a6-84b0-ccc29bf1b0f7")

# get a reference to the Amphora's signals
signals = amphora.get_signals()
```
We can now convert this entire signal to a dataframe
```
# download some signals and convert to a pandas dataframe
df = signals.pull().to_pandas()
print(df)

#                            temperature  rainProb  windSpeed  windDirection  cloudCover  pressure  rainfallRate
# t                                                                                                             
# 2020-03-26 02:00:00+00:00         24.0       5.0       11.0          135.0        13.0    1024.6           0.0
# 2020-03-26 03:00:00+00:00         25.0       5.0       10.0          135.0        10.0    1023.9           0.0
# 2020-03-26 04:00:00+00:00         26.0       5.0        9.0          135.0        11.0    1023.2           0.0
# 2020-03-26 05:00:00+00:00         27.0       5.0        9.0          158.0        11.0    1022.6           0.0
# 2020-03-26 06:00:00+00:00         27.0       7.0        8.0          203.0        10.0    1022.0           0.0
# ...                                ...       ...        ...            ...         ...       ...           ...
# 2020-03-26 11:00:00+00:00         18.0       6.0        5.0           90.0        41.0    1023.7           0.0
# 2020-03-26 12:00:00+00:00         17.0       7.0        4.0           90.0        19.0    1023.9           0.0
# 2020-03-26 13:00:00+00:00         16.0       6.0        5.0           68.0        20.0    1024.0           0.0
# 2020-03-26 14:00:00+00:00         15.0       7.0        4.0           68.0        16.0    1024.2           0.0
# 2020-03-26 15:00:00+00:00         14.0       7.0        4.0           68.0        16.0    1024.1           0.0
```

> The Event Count will always contain NaN values.

## Query specific times
Sometimes you will only want data from a specific interval. This is very easy to do. First set your desired time range
```
time_range = DateTimeRange(_from=start_time, to=end_time)
```
Note that you will need to import another model
```
from amphora_api_client import DateTimeRange
```
Now simply add that time range into the pull signal command
```
df = signals.pull(date_time_range=time_range).to_pandas()
```

## Other tips and tricks
Sometimes the time column will counterintuitively not be titled ``` t ```. This is because ```t``` is treated as an index. You can solve this by passing an option into the ```to_pandas`` as
```
df = signals.pull().to_pandas(t_as_index=False)
```
This also works if you want to query specific times.

## Other code to get you started
You can get code to get you started [here](https://github.com/amphoradata/samples/blob/master/generic_templates/Pull_a_file.py) 
