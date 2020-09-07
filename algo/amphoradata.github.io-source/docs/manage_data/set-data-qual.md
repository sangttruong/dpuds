---
id: set-data-qual
title: Set data quality
sidebar_label: Set data quality
---
Estimating data quality is important.
> It ain’t what you don’t know that gets you into trouble. It’s what you know for sure that just ain’t so.

You can set the data quality for any of your own Amphora. Data quality is on a 1-4 scale where 4 is the best and 1 is the worst. Unknown data quality should not be scored. 

Data quality is scored across 4 dimensions
* Completeness
* Accuracy
* Reliability
* Granularity

## Set data quality through the SDK

You need to set the data quality through the SDK. The python command is 
```py
amphora_quality_set(amphora_id,quality)
```
Here `quality` is a dictionary with keys `completeness`, `accuracy`, `reliability`, `granularity`.

We are looking at expanding this functionality to the web app soon.

An example is
```py
amphora_quality_set("0fa0de57-d7b5-467e-a869-a79e318cb3ec",{completeness: 4, accuracy: 4, reliability: 1, granularity: 2})
```

## Use the reference framework for data quality where possible

#### Completeness

Completeness refers to how much data is there vs how much data there should be. 

For example, if you have a 5Ha image and only 4Ha of data is there, its 80% complete.

Standard scoring for Completeness is
* 4: Less than 0.1% of data is missing
* 3: Between 0.1% and 1% of data is missing
* 2: Between 1% and 10% of data is missing
* 1: More than 10% of data is missing

#### Accuracy

Accuracy refers to how good the data is at describing reality. We need to look at normalised accuracy, and its converse normalised error.

For example, if weather data is given in the nearest degree, nominal accuracy is +/- 0.5 degrees. Normalised accuracy is +/-0.5 / average temperature range of 25 degrees = 2%

Standard scoring for Accuracy is
* 4: Normalised error is less than 0.1%
* 3: Normalised error is between 0.1% and 1%
* 2: Normalised error is between 1% and 10%
* 1: Normalised error is more than 10%

> Don't score accuracy for untested models

#### Reliability

Reliability refers to how much variation there is in an output for a given input. Along with Accuracy, it measures the variation, error and stochasticity in the data. However Accuracy and Reliability are not the same. 

For example, if a model run with the same parameters has an output varying up to 5%, then the Realiability is 95%

Standard scoring for Reliability is
* 4: Output varies less than 0.1% for given input
* 3: Output varies between 0.1% and 1% for given input
* 2: Output varies between 1% and 10% for given input
* 1: Output varies more than 10% for given input

> A dataset can be highly accurate with low reliability and vice versa. 

#### Granularity

Granualarity refers to the smallest unit the data can resolve. 

For example, if you have a satellite image which can resolve 50cm objects, Granularity is 0.5M

>  Scoring for Granularity is given for both spatial and temporal Granularity

Standard scoring for spatial granularity is
* 4: Less than 1m resolution
* 3: Between 1m and 10m resolution
* 2: Between 10m and 100m resolution
* 1: More than 100m resolution

Standard scoring for temporal granularity is
* 4: Less than 1 minute resolution
* 3: Between 1 minute and 1 hour resolution
* 2: Between 1 hour and 1 day resolution
* 1: More than 1 day resolution

## Should I score the model or the data or the source?

You should score the worst option. For example, if a time-series model gives 1 second resolution but the data you are pulling only has 1 hr, score it as 1 hr.

## What should I do if these reference frameworks aren't appropraite?

You can make your own reference framework. Just add it to the description in the Amphora.

You can share your framework, and we can put it here, if you think others may benefit too.