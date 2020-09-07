---
id: attributes
title: File Attributes
sidebar_label: Attributes
---

In addition to the data, Amphora Files each provide a mechanism to store associated metadata. These metadata are stored in the form of *attributes*. File attributes are key-value pairs, stored alongside the file. 

As the creator of a file, you have the permission to set as many attributes as you like. There are several limitations you should be aware of when setting attributes:

* An attribute key must be a valid HTTP header
* An attribute key must be a valid C# identifier.
* Attribute keys are *not* case sensitive. i.e. `ATTRIBUTE` is considered equivalent to `attribute`

In practice, this means you should only use alphanumeric keys beginning with a letter.

## Special Attributes

Some attributes have side effects. For example, setting the `ContentType` attribute allows you to control the way the file is rendered. For example, setting `ContentType = image/png` means the file will be rendered as an image. The content type should be a [valid MIME type](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types). Some MIME types may not render as expected, as the file rendering is the respnsibility of the user-facing application.