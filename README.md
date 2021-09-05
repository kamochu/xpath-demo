# XPATH Demo

A basic introduction to XPATH in java. In this tutorial, we will demonstrate  a few ways to extract and parse XML content. 

The XML content could be:
* An XML configuration for your application 
* A XML response from an API e.g. SOAP/XML integration 
* Data extracted into an XML file and you need to traverse the content to load into memory

## Lessons

* How to create your own XPATH expressions e.g. "/person/name"
* How to use text() function in your expression e.g. "/person/name/text()"
* How to use local-name() function in your expression e.g. /person/*[local-name() = 'test']
* How to get children nodes in an XML content e.g. "/person/contacts/child::*"

## Use Cases 
* System configurations can be saved in an XML file e.g. maven uses XML for the POM file, Hibernate supports XML configuration  
* Data storage - you can use XML to store some data that is loaded by the application during start up. This can be thought as a configuration too. 
* SOAP/XML integrations - when you get a headache dealing with XSDs and WSDL and generation of stubs, you can use raw HTTP request and extract the response via XPATH. You may need this when integrating to a legacy system. 
* Web Automation - automating web app testing using Selenium requires web testing

Any other use cases? You can contribute to the repo. 

## Note
This repo is created is to help someone get started with XPATH. XPATH is more than I have demostrated and there are many tutorials out there. You now have the power to read and practice.


