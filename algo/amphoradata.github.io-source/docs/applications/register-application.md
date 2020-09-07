---
id: register-application
title: Register an Application
sidebar_label: Register an App
---

Registering an Application is required for users to login to a 3rd party application with their Amphora Data Identity.

> At this time, you can only register an application directly via the API.

> Applications are only available to Organisations on the Institution plan

## Register an Application using Python

Use the following code to register an application

> You need at least the amphoradata python SDK, version > 0.10.6

```py
import os
from amphora.client import AmphoraDataRepositoryClient, Credentials
from amphora_api_client import ApplicationsApi, CreateApplication, AppLocation

# provide your login credentials
credentials = Credentials(username=os.environ['username'],
                          password=os.environ['password'])
# create a client for interacting with the public Amphora Data Repository
client = AmphoraDataRepositoryClient(credentials)

# create an amphora
appApi = ApplicationsApi(client.apiClient)
appLocations = [
    AppLocation(origin="http://localhost:3000", allowed_redirect_paths=["/#/callback"])
]

app = appApi.applications_create_application(
    CreateApplication(
    name="react-amphora-dev", 
    locations=appLocations, 
    logout_url="http://localhost:3000/logout" ))

print(f'Your Application ID is {app.id}')
```