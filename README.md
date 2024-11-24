# About tado&ordm;, the tado API and this OpenAPI specification

![content](https://img.shields.io/badge/content-OpenAPI_specification-blue)
![open api version](https://img.shields.io/badge/open_api_version-3.0.0-blue)
[![release](https://img.shields.io/github/v/release/kritsel/tado-openapispec-v2)](https://github.com/kritsel/tado-openapispec-v2/releases)
[![last commit](https://img.shields.io/github/last-commit/kritsel/tado-openapispec-v2)](https://github.com/kritsel/tado-openapispec-v2/commits/main/)
[![repo stars](https://img.shields.io/github/stars/kritsel/tado-openapispec-v2?style=plastic)](https://github.com/kritsel/tado-openapispec-v2/stargazers)
![open for contributors](https://img.shields.io/badge/open_for_contributors-yes-blue)
[![contributors](https://img.shields.io/github/contributors/kritsel/tado-openapispec-v2)](https://github.com/kritsel/tado-openapispec-v2/graphs/contributors)

## tado&ordm;

https://www.tado.com/

tado&ordm; is a german based company which offers a smart thermostat solution
to control heating and air-conditioning in your home.

tado&ordm; sells hardware and subscription based add-on services.
These can be controlled via a mobile app or an on-line app on their website.

## tado API
The tado&ordm; website and mobile apps use the tado API which is available at
https://my.tado.com/api/v2.

tado&ordm; allows third-party developers to use their API as well, 
but they do not provide any kind of support or documentation. 

## tado OpenAPI specification

This repository contains a community managed OpenAPI specification for the
**tado API v2**.
It is based on the experience of software developers who are experimenting
with the API to create their own solutions. 

This API specification is not maintained or officially published by the tado&ordm; company.
The contents of this API specification is a best-effort product.
There are no guarantees that this API specification is a complete and 
correct representation of the actual API as provided by tado.

# Specification characteristics

## Versioning
As this is a community managed OpenAPI specification for an API which is 
actually controlled by another company (being tado&ordm;),
the specification grows and matures gradually based on the discoveries made by 
software developers who are reverse-engineering the API. 

The changes and releases of this *specification* do not represent the changes 
in the API itself. 
They merely represent the changes in our understanding of the API.

Because of this, a versioning scheme is adopted which expresses the date 
on which the *specification* was modified. 

The version format is `v2.<year>.<month>.<day>.<daily release number>`.

(the daily release number is basically always `0`, unless we are releasing
multiple versions on the same day)

## Swagger UI
Visit https://kritsel.github.io/tado-openapispec-v2/ to see a visual representation
of the API in a Swagger UI.

Unfortunately you cannot execute API requests via the Swagger UI, 
due to cross-site scripting protection:
the Swagger UI is basically a javascript application hosted by github.io,
and it is not allowed to make calls to the tado.com host.

## Limitations
Not all functionality in tado's webapp or mobile apps is supported via this tado API.

When you use the webapp while keeping an eye on Network traffic via your browser's
developer tools, you can see other tado APIs scrolling by as well.

* https://acme.tado.com : additional air comfort information (display texts, visuals to use, outdoor air quality)
* https://auth.tado.com/: manage your account information like name, email and password
* https://energy-insights.tado.com: functionality behind Energy IQ
* https://ivar.tado.com/graphql: retrieve brand and boiler model information to help the user select their boiler type
* https://nibbler.tado.com/graphql: registering new devices
* https://minder.tado.com: get incidents information
* https://susi.tado.com: get skill information (related to paid Auto-Assist subscription)
* https://tariff-experience.tado.com

# OAuth 2.0 authentication
The only authentication mechanism supported by the tado API is OAuth 2.0.

tado&ordm; only supports OAuth 2.0 authentication via their own authentication server;
the API does not support third party authentication methods.

There are several pieces of information you need to authenticate via OAuth 2.0:
* **client id**: `public-api-preview` (as mentioned in [1])
* **client secret**: `4HJGRffVR8xb3XdEUQpjgZ1VplJi6Xgw` 
(a publicly shared 'secret' as mentioned in [1])
* **authorization grant type**: password
* **token URI**: https://auth.tado.com/oauth/token
* **username**: the username of your tado account
* **password**: the password of your tado account

_(the tado OAuth 2.0 set-up does not use scopes)_

Here are some resources to help you to successfully authenticate to the tado API.

* [1] https://support.tado.com/en/articles/8565472-how-do-i-update-my-rest-api-authentication-method-to-oauth-2
* [2] https://shkspr.mobi/blog/2019/02/tado-api-guide-updated-for-2019/
* [3] https://blog.scphillips.com/posts/2017/01/the-tado-api-v2/
* [4] https://community.tado.com/en-gb/discussion/8/tado-api/p1

## About `client_id` and `client_secret`
Please note that the official tado article [1] explicitly states
"Also, feel free to share the client credentials with other developers.
That way we will be able to easily distinguish our own apps from
third party developers." 
So use the client id and client secret as provided on that page.

Article [2] mentions that you can visit https://my.tado.com/webapp/env.js to
obtain a valid `client_id` and `client_secret`. 
The approach described on that page will work, but it will not allow tado to 
distinguish the traffic from their own apps from other traffic.

# Using the OpenAPI specification

## Link to the specification .yaml file
If you need a direct link to the specification .yaml file
e.g. as input for a client code generator you can use the URL below.
Replace `<version tag>` with the proper version number or with `latest`.
(list of all released versions: https://github.com/kritsel/tado-openapispec-v2/releases)

`https://raw.githubusercontent.com/kritsel/tado-openapispec-v2/<version tag>/tado-openapispec-v2.yaml`

Examples:
* link to a specific version: https://raw.githubusercontent.com/kritsel/tado-openapispec-v2/v2.2024.08.01.3/tado-openapispec-v2.yaml
* link to latest version: https://raw.githubusercontent.com/kritsel/tado-openapispec-v2/latest/tado-openapispec-v2.yaml

## Example applications

* Kotlin demo application with generated API client code which uses this OpenAPI 
specification as input: https://github.com/kritsel/tado-api-demo-kotlin
* Java demo application with generated API client code which uses this OpenAPI
specification as input: https://github.com/kritsel/tado-api-demo-java

# Acknowledgments
Without the groundwork done by **Stephen C. Phillips** 
(https://blog.scphillips.com/posts/2017/01/the-tado-api-v2/)
and **Terence Eden** (https://shkspr.mobi/blog/2019/02/tado-api-guide-updated-for-2019/)
I would have never started experimenting with the tado API,
and this tado OpenAPI specification would have never seen the light of day.

Additionally, the following github repositories have been a great help:
 * https://github.com/mattdavis90/node-tado-client

# Contribute
Feel free to submit a PR or create an issue if you want to contribute to this
OpenAPI specification.