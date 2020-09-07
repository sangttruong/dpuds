---
id: access-levels
title: Access Levels
sidebar_label: Access Levels
---

In Amphora, Access Levels express what actions a user is permitted to take in relation to an Amphora. Access Levels are an integer hierarchy, meaning that a higher access level is permitted to take all the actions of the level below.

The table below shows the meaning of each interger access level.

| Access Level | Permission      |
|--------------|-----------------|
| 0            | None            |
| 16           | Read            |
| 24           | Purchase        |
| 32           | Read Contents   |
| 48           | Create Entities |
| 64           | Write Contents  |
| 128          | Update          |
| 256          | Administer      |

