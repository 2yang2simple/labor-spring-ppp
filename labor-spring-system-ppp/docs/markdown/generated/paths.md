
<a name="paths"></a>
## Resources

<a name="a-sample-rest-controller_resource"></a>
### A-sample-rest-controller
A Sample Rest Controller


<a name="createusingpost"></a>
#### create
```
POST /rest/core/samples
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**asample**  <br>*required*|asample|[ASample](#asample)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_1"></a>
#### findList
```
GET /rest/core/samples
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples
```


###### Request query
```
json :
{
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="aopandusingget"></a>
#### aopand
```
GET /rest/core/samples/aopand
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/aopand
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="aoporusingget"></a>
#### aopor
```
GET /rest/core/samples/aopor
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/aopor
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbynameusingget"></a>
#### findListByName
```
GET /rest/core/samples/namestart-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**namestart**  <br>*required*|namestart|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/namestart-page-list
```


###### Request query
```
json :
{
  "namestart" : "string",
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget"></a>
#### findList
```
GET /rest/core/samples/page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbystatususingget"></a>
#### findListByStatus
```
GET /rest/core/samples/status-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|
|**Query**|**status**  <br>*optional*|status|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/status-page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string",
  "status" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="testusingget"></a>
#### test
```
GET /rest/core/samples/test
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/test
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyuuidusingget"></a>
#### findByUuid
```
GET /rest/core/samples/uuid-{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/uuid-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput"></a>
#### update
```
PUT /rest/core/samples/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**asample**  <br>*required*|asample|[ASample](#asample)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/0
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatestatususingpatch"></a>
#### updateStatus
```
PATCH /rest/core/samples/{id}/status/{status}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Path**|**status**  <br>*required*|status|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/0/status/string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findsubslistbystatususingget"></a>
#### findSubsListByStatus
```
GET /rest/core/samples/{id}/subs
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Query**|**status**  <br>*optional*|status|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/samples/0/subs
```


###### Request query
```
json :
{
  "status" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="dictionary-rest-controller_resource"></a>
### Dictionary-rest-controller
Dictionary Rest Controller


<a name="createusingpost_1"></a>
#### create
```
POST /rest/core/dictionaries
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**dictionary**  <br>*required*|dictionary|[Dictionary](#dictionary)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/dictionaries
```


###### Request body
```
json :
{
  "code" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "order" : 0,
  "parentid" : 0,
  "status" : "string",
  "uuid" : "string",
  "value1" : "string",
  "value2" : "string",
  "value3" : "string",
  "value4" : "string",
  "value5" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findsubslistusingget"></a>
#### findSubsList
```
GET /rest/core/dictionaries/subs
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**code**  <br>*optional*|code|string|
|**Query**|**status**  <br>*optional*|status|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/dictionaries/subs
```


###### Request query
```
json :
{
  "code" : "string",
  "status" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findtopslistusingget"></a>
#### findTopsList
```
GET /rest/core/dictionaries/tops
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/dictionaries/tops
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createtopdictionarysusingpost"></a>
#### createTopDictionarys
```
POST /rest/core/dictionaries/tops-init
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/dictionaries/tops-init
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput_1"></a>
#### update
```
PUT /rest/core/dictionaries/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**dictionary**  <br>*required*|dictionary|[Dictionary](#dictionary)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/dictionaries/0
```


###### Request body
```
json :
{
  "code" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "order" : 0,
  "parentid" : 0,
  "status" : "string",
  "uuid" : "string",
  "value1" : "string",
  "value2" : "string",
  "value3" : "string",
  "value4" : "string",
  "value5" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatestatususingpatch_1"></a>
#### updateStatus
```
PATCH /rest/core/dictionaries/{id}/status/{status}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Path**|**status**  <br>*required*|status|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/dictionaries/0/status/string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="document-rest-controller_resource"></a>
### Document-rest-controller
Document Rest Controller


<a name="createusingpost_2"></a>
#### create
```
POST /rest/documents
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**documentDto**  <br>*required*|documentDto|[DocumentDto](#documentdto)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents
```


###### Request body
```
json :
{
  "commentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "creator" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "content" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  },
  "contentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "creator" : {
    "userId" : 0,
    "userName" : "string",
    "userRealName" : "string",
    "userUuid" : "string"
  },
  "docStatus" : "string",
  "document" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docStatus" : "string",
    "fileMd5" : "string",
    "filePath" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "name" : "string",
    "namePinyin" : "string",
    "status" : "string",
    "uuid" : "string"
  },
  "id" : 0,
  "name" : "string",
  "tagList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "tagId" : 0,
    "tagName" : "string",
    "tagType" : "string",
    "uuid" : "string"
  } ],
  "tagName" : "string",
  "tagType" : "string",
  "userList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "userId" : 0,
    "userName" : "string",
    "uuid" : "string"
  } ],
  "userid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_2"></a>
#### findList
```
GET /rest/documents
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents
```


###### Request query
```
json :
{
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="initdocumentsusingget"></a>
#### initDocuments
```
GET /rest/documents/init
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/init
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findmydocumentlistusingget"></a>
#### findMyDocumentList
```
GET /rest/documents/my-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/my-page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbynamelikeusingget"></a>
#### findListByNameLike
```
GET /rest/documents/name-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**name**  <br>*optional*|name|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/name-page-list
```


###### Request query
```
json :
{
  "name" : "string",
  "page" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbytagusingget"></a>
#### findListByTag
```
GET /rest/documents/tag-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"doc_id"`|
|**Query**|**tag**  <br>*optional*|tag|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/tag-page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "sortby" : "string",
  "tag" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findtaglistusingget"></a>
#### findTagList
```
GET /rest/documents/tags/name-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**name**  <br>*optional*|name|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/tags/name-page-list
```


###### Request query
```
json :
{
  "name" : "string",
  "page" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyuuidusingget_1"></a>
#### findByUuid
```
GET /rest/documents/uuid-{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|
|**Query**|**contentid**  <br>*optional*|contentid|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/uuid-string
```


###### Request query
```
json :
{
  "contentid" : 0
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput_2"></a>
#### update
```
PUT /rest/documents/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**documentDto**  <br>*required*|documentDto|[DocumentDto](#documentdto)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0
```


###### Request body
```
json :
{
  "commentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "creator" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "content" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  },
  "contentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "creator" : {
    "userId" : 0,
    "userName" : "string",
    "userRealName" : "string",
    "userUuid" : "string"
  },
  "docStatus" : "string",
  "document" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docStatus" : "string",
    "fileMd5" : "string",
    "filePath" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "name" : "string",
    "namePinyin" : "string",
    "status" : "string",
    "uuid" : "string"
  },
  "id" : 0,
  "name" : "string",
  "tagList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "tagId" : 0,
    "tagName" : "string",
    "tagType" : "string",
    "uuid" : "string"
  } ],
  "tagName" : "string",
  "tagType" : "string",
  "userList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "userId" : 0,
    "userName" : "string",
    "uuid" : "string"
  } ],
  "userid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createcommentusingpost"></a>
#### createComment
```
POST /rest/documents/{id}/comments
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**comment**  <br>*required*|comment|[DocumentComment](#documentcomment)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/comments
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "creator" : "string",
  "description" : "string",
  "docId" : 0,
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "status" : "string",
  "text" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findcommentlistbyidusingget"></a>
#### findCommentListById
```
GET /rest/documents/{id}/comments
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/comments
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createcontentusingpost"></a>
#### createContent
```
POST /rest/documents/{id}/contents
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**content**  <br>*required*|content|[DocumentContent](#documentcontent)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/contents
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "docId" : 0,
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "md5" : "string",
  "status" : "string",
  "text" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findcontentversionsbydocidusingget"></a>
#### findContentVersionsByDocid
```
GET /rest/documents/{id}/contents-versions
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/contents-versions
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findcontentbyidusingget"></a>
#### findContentById
```
GET /rest/documents/{id}/contents/{contentid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentid**  <br>*required*|contentid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/contents/0
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatecontentusingput"></a>
#### updateContent
```
PUT /rest/documents/{id}/contents/{contentid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentid**  <br>*required*|contentid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**content**  <br>*required*|content|[DocumentContent](#documentcontent)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/contents/0
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "docId" : 0,
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "md5" : "string",
  "status" : "string",
  "text" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createtagusingpost"></a>
#### createTag
```
POST /rest/documents/{id}/tags
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)||
|**Query**|**tagname**  <br>*required*|tagname|string||
|**Query**|**tagtype**  <br>*optional*|tagtype|string|`"10"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/tags
```


###### Request query
```
json :
{
  "tagname" : "string",
  "tagtype" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatetaglistusingpost"></a>
#### updateTagList
```
POST /rest/documents/{id}/tags/list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**tagList**  <br>*required*|tagList|< [DocumentTag](#documenttag) > array|
|**Body**|**tagType**  <br>*required*|tagType|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/tags/list
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateuserlistusingpost"></a>
#### updateUserList
```
POST /rest/documents/{id}/users/list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**userList**  <br>*required*|userList|< [DocumentUser](#documentuser) > array|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/0/users/list
```


###### Request body
```
json :
[ {
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "docId" : 0,
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "status" : "string",
  "userId" : 0,
  "userName" : "string",
  "uuid" : "string"
} ]
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findentitybyfilenameusingget"></a>
#### findEntityByFilename
```
GET /rest/documents/{uuid}/file
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/documents/string/file
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="feign-auth-rest-controller_resource"></a>
### Feign-auth-rest-controller
Feign Auth Rest Controller


<a name="logoutusingdelete"></a>
#### loggout
```
DELETE /rest/feign/auth/logins
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/auth/logins
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="deletecacheusingdelete"></a>
#### deleteCache
```
DELETE /rest/feign/auth/logins/cache
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/auth/logins/cache
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findusercurrentusingget"></a>
#### findUserCurrent
```
GET /rest/feign/auth/logins/users/current
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**fetch**  <br>*optional*|fetch|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/auth/logins/users/current
```


###### Request query
```
json :
{
  "fetch" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finduserpermissionscurrentusingget"></a>
#### findUserPermissionsCurrent
```
GET /rest/feign/auth/logins/users/permissions/current
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**fetch**  <br>*optional*|fetch|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/auth/logins/users/permissions/current
```


###### Request query
```
json :
{
  "fetch" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="requestusertokenusingpost"></a>
#### callback url registed in auth return a key for access token saved in cache. authCacheService.getTokenCache(key)
```
POST /rest/feign/auth/logins/users/tokens/keys
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**auth-code**  <br>*optional*|auth-code|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/auth/logins/users/tokens/keys
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="init2authusingget"></a>
#### init2auth
```
GET /rest/feign/auth/permissions/init2auth
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/auth/permissions/init2auth
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="feign-oss-rest-controller_resource"></a>
### Feign-oss-rest-controller
Feign OSS Rest Controller


<a name="createfileusingpost"></a>
#### createFile
```
POST /rest/feign/oss/files
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**FormData**|**file**  <br>*required*|file|file|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `multipart/form-data`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/oss/files
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findfilebyfilenameusingget"></a>
#### findFileByFilename
```
GET /rest/feign/oss/files/{filename}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/oss/files/string
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="createimageusingpost"></a>
#### createImage
```
POST /rest/feign/oss/images
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**FormData**|**file**  <br>*required*|file|file|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `multipart/form-data`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/oss/images
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findimagebyfilenameusingget"></a>
#### findImageByFilename
```
GET /rest/feign/oss/images/{filename}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/oss/images/string
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="findimagebyfilenamebyoriginusingget"></a>
#### findImageByFilenameByOrigin
```
GET /rest/feign/oss/images/{filename}/origin
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/oss/images/string/origin
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="findimagebyfilenamebysizeusingget"></a>
#### findImageByFilenameBySize
```
GET /rest/feign/oss/images/{filename}/size
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|
|**Query**|**accuracy**  <br>*optional*|accuracy|number (double)|
|**Query**|**height**  <br>*optional*|height|integer (int32)|
|**Query**|**width**  <br>*optional*|width|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/oss/images/string/size
```


###### Request query
```
json :
{
  "accuracy" : 0.0,
  "height" : 0,
  "width" : 0
}
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="qrcodeusingget"></a>
#### qrCode
```
GET /rest/feign/oss/qr-code
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**content**  <br>*optional*|content|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/feign/oss/qr-code
```


###### Request query
```
json :
{
  "content" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="fingerprint-rest-controller_resource"></a>
### Fingerprint-rest-controller
Fingerprint Rest Controller


<a name="findonlinelistusingget"></a>
#### findOnlineList
```
GET /rest/fingerprints/online/page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*required*|sortby|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/online/page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findonlinelistbyvalueusingget"></a>
#### findOnlineListByValue
```
GET /rest/fingerprints/online/valuestart-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*required*|sortby|string||
|**Query**|**valuestart**  <br>*required*|valuestart|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/online/valuestart-page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string",
  "valuestart" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="deleteonlineusingdelete"></a>
#### deleteOnline
```
DELETE /rest/fingerprints/online/{foid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**foid**  <br>*required*|foid|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/online/0
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_3"></a>
#### findList
```
GET /rest/fingerprints/sort-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**sortby**  <br>*required*|sortby|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/sort-list
```


###### Request query
```
json :
{
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_4"></a>
#### findList
```
GET /rest/fingerprints/sort-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*required*|sortby|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/sort-page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbyvalueusingget"></a>
#### findListByValue
```
GET /rest/fingerprints/valuestart-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**valuestart**  <br>*required*|valuestart|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/valuestart-list
```


###### Request query
```
json :
{
  "valuestart" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbyvalueusingget_1"></a>
#### findListByValue
```
GET /rest/fingerprints/valuestart-sort-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*required*|sortby|string||
|**Query**|**valuestart**  <br>*required*|valuestart|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/valuestart-sort-page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string",
  "valuestart" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatestatususingpatch_2"></a>
#### updateStatus
```
PATCH /rest/fingerprints/{id}/status/{status}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|
|**Path**|**status**  <br>*required*|status|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/fingerprints/0/status/string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="foreign-auth-rest-controller_resource"></a>
### Foreign-auth-rest-controller
Foreign Auth Rest Controller


<a name="logoutusingdelete_1"></a>
#### Loggout a user
```
DELETE /rest/foreign/logins
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**code**  <br>*optional*|access-token|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/logins
```


###### Request query
```
json :
{
  "code" : "string"
}
```


<a name="findloginuserusingget"></a>
#### Find a login user
```
GET /rest/foreign/logins/users
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**code**  <br>*optional*|access-token|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/logins/users
```


###### Request query
```
json :
{
  "code" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="fetchloginusertokenusingpost"></a>
#### Fetch a user access-token
```
POST /rest/foreign/logins/users/tokens
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**code**  <br>*optional*|auth-code,access-token|string|
|**Query**|**type**  <br>*optional*|request-token,refresh-token|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/logins/users/tokens
```


###### Request query
```
json :
{
  "code" : "string",
  "type" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatepermissionsusingput"></a>
#### Update permissions by type
```
PUT /rest/foreign/permissions/{client-key}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**client-key**  <br>*optional*|client name|string|
|**Query**|**permissions**  <br>*optional*|permissions list|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/permissions/{client-key}
```


###### Request query
```
json :
{
  "client-key" : "string",
  "permissions" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpermissionsusingget"></a>
#### Find user permissions
```
GET /rest/foreign/permissions/{client-key}/{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**client-key**  <br>*optional*|client name|string|
|**Query**|**uuid**  <br>*optional*|user uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/permissions/{client-key}/{uuid}
```


###### Request query
```
json :
{
  "client-key" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="foreign-oss-rest-controller_resource"></a>
### Foreign-oss-rest-controller
Foreign OSS Rest Controller


<a name="createfileusingpost_1"></a>
#### createFile
```
POST /rest/foreign/files
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**FormData**|**file**  <br>*required*|file|file|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `multipart/form-data`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/files
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findfilebyfilenameusingget_1"></a>
#### findFileByFilename
```
GET /rest/foreign/files/{filename}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/files/string
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="createimageusingpost_1"></a>
#### createImage
```
POST /rest/foreign/images
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**FormData**|**file**  <br>*required*|file|file|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `multipart/form-data`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/images
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createimagebybytesusingpost"></a>
#### createImageByBytes
```
POST /rest/foreign/images/bytes
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**filename**  <br>*required*|filename|string|
|**Body**|**filebytes**  <br>*required*|filebytes|string (byte)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/images/bytes
```


###### Request query
```
json :
{
  "filename" : "string"
}
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findimagebyfilenameusingget_1"></a>
#### findImageByFilename
```
GET /rest/foreign/images/{filename}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/images/string
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="findimagebyfilenamebyoriginusingget_1"></a>
#### findImageByFilenameByOrigin
```
GET /rest/foreign/images/{filename}/origin
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/images/string/origin
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="findimagebyfilenamebysizeusingget_1"></a>
#### findImageByFilenameBySize
```
GET /rest/foreign/images/{filename}/size
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**filename**  <br>*required*|filename|string|
|**Query**|**accuracy**  <br>*optional*|accuracy|number (double)|
|**Query**|**height**  <br>*optional*|height|integer (int32)|
|**Query**|**width**  <br>*optional*|width|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/images/string/size
```


###### Request query
```
json :
{
  "accuracy" : 0.0,
  "height" : 0,
  "width" : 0
}
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="qrcodeusingget_1"></a>
#### qrCode
```
GET /rest/foreign/qr-code
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**content**  <br>*optional*|content|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/foreign/qr-code
```


###### Request query
```
json :
{
  "content" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="gallery-rest-controller_resource"></a>
### Gallery-rest-controller
Gallery Rest Controller


<a name="createusingpost_3"></a>
#### create
```
POST /rest/galleries
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**gallery**  <br>*required*|gallery|[Gallery](#gallery)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries
```


###### Request body
```
json :
{
  "caption" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "namePinyin" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findimagebyuuidusingget"></a>
#### findImageByUuid
```
GET /rest/galleries/images/{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/images/string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findimageentityoriginbyuuidusingget"></a>
#### findImageEntityOriginByUuid
```
GET /rest/galleries/images/{uuid}/entity
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/images/string/entity
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="findimageentitythumbnailbyuuidusingget"></a>
#### findImageEntityThumbnailByUuid
```
GET /rest/galleries/images/{uuid}/entity/thumbnail
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|
|**Query**|**accuracy**  <br>*optional*|accuracy|number (double)|
|**Query**|**height**  <br>*optional*|height|integer (int32)|
|**Query**|**width**  <br>*optional*|width|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/images/string/entity/thumbnail
```


###### Request query
```
json :
{
  "accuracy" : 0.0,
  "height" : 0,
  "width" : 0
}
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="findlistbynamelikeusingget_1"></a>
#### findListByNameLike
```
GET /rest/galleries/name-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**name**  <br>*optional*|name|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|
|**Query**|**status**  <br>*optional*|status|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/name-page-list
```


###### Request query
```
json :
{
  "name" : "string",
  "page" : 0,
  "sortby" : "string",
  "status" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyuuidusingget_2"></a>
#### findByUuid
```
GET /rest/galleries/uuid-{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/uuid-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput_3"></a>
#### update
```
PUT /rest/galleries/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**gallery**  <br>*required*|gallery|[Gallery](#gallery)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/0
```


###### Request body
```
json :
{
  "caption" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "namePinyin" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createimagesusingpost"></a>
#### createImages
```
POST /rest/galleries/{id}/images
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)||
|**Query**|**startOrder**  <br>*optional*|startOrder|integer (int32)|`0`|
|**FormData**|**files**  <br>*required*|files|< file > array(multi)||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/0/images
```


###### Request query
```
json :
{
  "startOrder" : 0
}
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createimagesingleusingpost"></a>
#### createImageSingle
```
POST /rest/galleries/{id}/images/single
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**FormData**|**file**  <br>*required*|file|file|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `multipart/form-data`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/0/images/single
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateimageusingput"></a>
#### updateImage
```
PUT /rest/galleries/{id}/images/{galleryImageId}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**galleryImageId**  <br>*required*|galleryImageId|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**galleryImage**  <br>*required*|galleryImage|[GalleryImage](#galleryimage)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/0/images/0
```


###### Request body
```
json :
{
  "caption" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "fileName" : "string",
  "gaId" : 0,
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "namePinyin" : "string",
  "ohId" : 0,
  "order" : 0,
  "status" : "string",
  "url" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createimageusingpost_2"></a>
#### createImage
```
POST /rest/galleries/{id}/test
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**FormData**|**files**  <br>*required*|files|< file > array(multi)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/{id}/test
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createimage2usingpost"></a>
#### createImage2
```
POST /rest/galleries/{id}/test2
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**FormData**|**files**  <br>*required*|files|< file > array(multi)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/{id}/test2
```


###### Request formData
```
json :
"file"
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findcoverbyuuidusingget"></a>
#### findCoverByUuid
```
GET /rest/galleries/{uuid}/cover
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/string/cover
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="findimagelistbyuuidusingget_1"></a>
#### findImageListByUuid
```
GET /rest/galleries/{uuid}/images
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|
|**Query**|**capion**  <br>*optional*|capion|string|
|**Query**|**status**  <br>*optional*|status|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/string/images
```


###### Request query
```
json :
{
  "capion" : "string",
  "status" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findimagelistbyuuidusingget"></a>
#### findImageListByUuid
```
GET /rest/galleries/{uuid}/images/page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string||
|**Query**|**capion**  <br>*optional*|capion|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|
|**Query**|**status**  <br>*optional*|status|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/galleries/string/images/page-list
```


###### Request query
```
json :
{
  "capion" : "string",
  "page" : 0,
  "sortby" : "string",
  "status" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="labor-spring-rest-controller_resource"></a>
### Labor-spring-rest-controller
Labor Spring Rest Controller


<a name="infousingget"></a>
#### info
```
GET /rest
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="permission-rest-controller_resource"></a>
### Permission-rest-controller
Permission Rest Controller


<a name="findlistactivedusingget"></a>
#### findListActived
```
GET /rest/permissions/actived-list
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/permissions/actived-list
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="initializationusingpost"></a>
#### initialization
```
POST /rest/permissions/initialization
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/permissions/initialization
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="product-rest-controller_resource"></a>
### Product-rest-controller
Product Rest Controller


<a name="createusingpost_4"></a>
#### create
```
POST /rest/products
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**product**  <br>*required*|product|[Product](#product)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products
```


###### Request body
```
json :
{
  "code" : "string",
  "color" : "string",
  "costPrice" : 0.0,
  "createdBy" : "string",
  "creationDate" : "string",
  "currency" : "string",
  "description" : "string",
  "id" : 0,
  "itemNo" : "string",
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "marketPrice" : 0.0,
  "name" : "string",
  "namePinyin" : "string",
  "parentId" : 0,
  "price" : 0.0,
  "productStatus" : "string",
  "size" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="exportexcelusingget"></a>
#### exportExcel
```
GET /rest/products/excel
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/excel
```


<a name="findlistbynamelikeusingget_2"></a>
#### findListByNameLike
```
GET /rest/products/name-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**name**  <br>*optional*|name|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)||
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|
|**Query**|**status**  <br>*optional*|status|string||


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/name-page-list
```


###### Request query
```
json :
{
  "name" : "string",
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string",
  "status" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyuuidusingget_3"></a>
#### findByUuid
```
GET /rest/products/uuid-{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/uuid-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateproductusingput"></a>
#### updateProduct
```
PUT /rest/products/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**product**  <br>*required*|product|[Product](#product)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/0
```


###### Request body
```
json :
{
  "code" : "string",
  "color" : "string",
  "costPrice" : 0.0,
  "createdBy" : "string",
  "creationDate" : "string",
  "currency" : "string",
  "description" : "string",
  "id" : 0,
  "itemNo" : "string",
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "marketPrice" : 0.0,
  "name" : "string",
  "namePinyin" : "string",
  "parentId" : 0,
  "price" : 0.0,
  "productStatus" : "string",
  "size" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finddocumentlistusingget"></a>
#### findDocumentList
```
GET /rest/products/{id}/docs/page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"doc_id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/0/docs/page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findgallerylistusingget"></a>
#### findGalleryList
```
GET /rest/products/{id}/galleries/page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"ga_id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/0/galleries/page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findcoverbyuuidusingget_1"></a>
#### findCoverByUuid
```
GET /rest/products/{uuid}/cover
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/string/cover
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="createdocumentusingpost"></a>
#### createDocument
```
POST /rest/products/{uuid}/docs
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|
|**Body**|**documentDto**  <br>*required*|documentDto|[DocumentDto](#documentdto)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/string/docs
```


###### Request body
```
json :
{
  "commentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "creator" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "content" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  },
  "contentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "creator" : {
    "userId" : 0,
    "userName" : "string",
    "userRealName" : "string",
    "userUuid" : "string"
  },
  "docStatus" : "string",
  "document" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docStatus" : "string",
    "fileMd5" : "string",
    "filePath" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "name" : "string",
    "namePinyin" : "string",
    "status" : "string",
    "uuid" : "string"
  },
  "id" : 0,
  "name" : "string",
  "tagList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "tagId" : 0,
    "tagName" : "string",
    "tagType" : "string",
    "uuid" : "string"
  } ],
  "tagName" : "string",
  "tagType" : "string",
  "userList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "userId" : 0,
    "userName" : "string",
    "uuid" : "string"
  } ],
  "userid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="creategalleryusingpost"></a>
#### createGallery
```
POST /rest/products/{uuid}/galleries
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|
|**Body**|**gallery**  <br>*required*|gallery|[Gallery](#gallery)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/products/string/galleries
```


###### Request body
```
json :
{
  "caption" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "namePinyin" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="profile-rest-controller_resource"></a>
### Profile-rest-controller
Profile Rest Controller


<a name="updateuserpasswordusingpost"></a>
#### updateUserPassword
```
POST /rest/profiles/passwords
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**hm**  <br>*required*|hm|< string, string > map|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/passwords
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createqrcodeusingget"></a>
#### createQrCode
```
GET /rest/profiles/qr-code
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**content**  <br>*optional*|content|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< string (byte) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/qr-code
```


###### Request query
```
json :
{
  "content" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
[ "string" ]
```


<a name="signupusingpost"></a>
#### signup
```
POST /rest/profiles/signup
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**g**  <br>*required*|g|string|
|**Query**|**t**  <br>*required*|t|string|
|**Body**|**hm**  <br>*required*|hm|< string, string > map|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/signup
```


###### Request query
```
json :
{
  "g" : "string",
  "t" : "string"
}
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
"string"
```


<a name="signupcodeusingpost"></a>
#### signupCode
```
POST /rest/profiles/signup-code
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**g**  <br>*required*|g|string|
|**Query**|**t**  <br>*required*|t|string|
|**Body**|**hm**  <br>*required*|hm|< string, string > map|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/signup-code
```


###### Request query
```
json :
{
  "g" : "string",
  "t" : "string"
}
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="signupsuperusingpost"></a>
#### signupSuper
```
POST /rest/profiles/signup-super
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**hm**  <br>*required*|hm|< string, string > map|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/signup-super
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
"string"
```


<a name="findcurrentuserusingget"></a>
#### findCurrentUser
```
GET /rest/profiles/users/current
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/users/current
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatecurrentuserusingpatch"></a>
#### updateCurrentUser
```
PATCH /rest/profiles/users/current
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**puser**  <br>*required*|puser|[User](#user)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/users/current
```


###### Request body
```
json :
{
  "cellPhone" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "email" : "string",
  "googleSecretKey" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "pwdmodify" : "string",
  "realName" : "string",
  "realNameEn" : "string",
  "sno" : "string",
  "status" : "string",
  "uuid" : "string",
  "weixin" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findcurrentuserqrurlusingget"></a>
#### findCurrentUserQRUrl
```
GET /rest/profiles/users/current/qr-code-url
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/users/current/qr-code-url
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finduserpasswordsaltbyaccountusingget"></a>
#### findUserPasswordSaltByAccount
```
GET /rest/profiles/users/{account}/salt
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**account**  <br>*required*|account|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/users/string/salt
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finduserbypwdmodifypasswordusingget"></a>
#### findUserByPwdmodifyPassword
```
GET /rest/profiles/users/{pwdmodify}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**pwdmodify**  <br>*required*|pwdmodify|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/users/string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finduserqrurlbypwdmodifypasswordusingget"></a>
#### findUserQRUrlByPwdmodifyPassword
```
GET /rest/profiles/users/{pwdmodify}/auth-qr-code-url
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**pwdmodify**  <br>*required*|pwdmodify|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/profiles/users/string/auth-qr-code-url
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="project-rest-controller_resource"></a>
### Project-rest-controller
Project Rest Controller


<a name="createusingpost_5"></a>
#### create
```
POST /rest/projects
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**project**  <br>*required*|project|[Project](#project)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects
```


###### Request body
```
json :
{
  "amount" : 0.0,
  "code" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "currency" : "string",
  "customer" : "string",
  "customerCode" : "string",
  "deliveryDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "manager" : "string",
  "managerUserid" : 0,
  "name" : "string",
  "namePinyin" : "string",
  "parentId" : 0,
  "projectStatus" : "string",
  "status" : "string",
  "supplier" : "string",
  "supplierCode" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistnonclosedbynamelikeusingget"></a>
#### findListNonClosedByNameLike
```
GET /rest/projects/name-list-non-closed
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**name**  <br>*required*|name|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/name-list-non-closed
```


###### Request query
```
json :
{
  "name" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbynamelikeusingget_3"></a>
#### findListByNameLike
```
GET /rest/projects/name-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**name**  <br>*required*|name|string||
|**Query**|**notinstatus**  <br>*optional*|notinstatus|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)||
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/name-page-list
```


###### Request query
```
json :
{
  "name" : "string",
  "notinstatus" : "string",
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyuuidusingget_4"></a>
#### findByUuid
```
GET /rest/projects/uuid-{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/uuid-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateprojectusingput"></a>
#### updateProject
```
PUT /rest/projects/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**project**  <br>*required*|project|[Project](#project)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0
```


###### Request body
```
json :
{
  "amount" : 0.0,
  "code" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "currency" : "string",
  "customer" : "string",
  "customerCode" : "string",
  "deliveryDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "manager" : "string",
  "managerUserid" : 0,
  "name" : "string",
  "namePinyin" : "string",
  "parentId" : 0,
  "projectStatus" : "string",
  "status" : "string",
  "supplier" : "string",
  "supplierCode" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findtododocumentlistusingget"></a>
#### findTodoDocumentList
```
GET /rest/projects/{id}/docs/todo-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/todo-list
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findtododocumentlistopenedusingget"></a>
#### findTodoDocumentListOpened
```
GET /rest/projects/{id}/docs/todo-list-non-closed
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/todo-list-non-closed
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatetododocumentclosedusingpatch"></a>
#### updateTodoDocumentClosed
```
PATCH /rest/projects/{id}/docs/todo/{docid}/status/closed
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**docid**  <br>*required*|docid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/todo/0/status/closed
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatetododocumentopenedusingpatch"></a>
#### updateTodoDocumentOpened
```
PATCH /rest/projects/{id}/docs/todo/{docid}/status/opened
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**docid**  <br>*required*|docid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/todo/0/status/opened
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finddocumentbyuuidusingget"></a>
#### findDocumentByUuid
```
GET /rest/projects/{id}/docs/uuid-{docuuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**docuuid**  <br>*required*|docuuid|string|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/uuid-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createcommentusingpost_1"></a>
#### createComment
```
POST /rest/projects/{id}/docs/{docid}/comments
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**docid**  <br>*required*|docid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**comment**  <br>*required*|comment|[DocumentComment](#documentcomment)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/0/comments
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "creator" : "string",
  "description" : "string",
  "docId" : 0,
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "status" : "string",
  "text" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finddocumentcommentlistbyidusingget"></a>
#### findDocumentCommentListById
```
GET /rest/projects/{id}/docs/{docid}/comments
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**docid**  <br>*required*|docid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/0/comments
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createcontentusingpost_1"></a>
#### createContent
```
POST /rest/projects/{id}/docs/{docid}/contents
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**docid**  <br>*required*|docid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**content**  <br>*required*|content|[DocumentContent](#documentcontent)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/0/contents
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "docId" : 0,
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "md5" : "string",
  "status" : "string",
  "text" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="finddocumentcontentbyidusingget"></a>
#### findDocumentContentById
```
GET /rest/projects/{id}/docs/{docid}/contents/{contentid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentid**  <br>*required*|contentid|integer (int32)|
|**Path**|**docid**  <br>*required*|docid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/0/contents/0
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatecontentusingput_1"></a>
#### updateContent
```
PUT /rest/projects/{id}/docs/{docid}/contents/{contentid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**contentid**  <br>*required*|contentid|integer (int32)|
|**Path**|**docid**  <br>*required*|docid|integer (int32)|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**content**  <br>*required*|content|[DocumentContent](#documentcontent)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/docs/0/contents/0
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "docId" : 0,
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "md5" : "string",
  "status" : "string",
  "text" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateprojectclosedusingpatch"></a>
#### updateProjectClosed
```
PATCH /rest/projects/{id}/status/closed
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/status/closed
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateprojectopenedusingpatch"></a>
#### updateProjectOpened
```
PATCH /rest/projects/{id}/status/opened
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/0/status/opened
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createtododocumentusingpost"></a>
#### createTodoDocument
```
POST /rest/projects/{uuid}/docs/todo
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|
|**Body**|**documentDto**  <br>*required*|documentDto|[DocumentDto](#documentdto)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/projects/string/docs/todo
```


###### Request body
```
json :
{
  "commentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "creator" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "content" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  },
  "contentList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "html" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "md5" : "string",
    "status" : "string",
    "text" : "string",
    "uuid" : "string"
  } ],
  "creator" : {
    "userId" : 0,
    "userName" : "string",
    "userRealName" : "string",
    "userUuid" : "string"
  },
  "docStatus" : "string",
  "document" : {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docStatus" : "string",
    "fileMd5" : "string",
    "filePath" : "string",
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "name" : "string",
    "namePinyin" : "string",
    "status" : "string",
    "uuid" : "string"
  },
  "id" : 0,
  "name" : "string",
  "tagList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "tagId" : 0,
    "tagName" : "string",
    "tagType" : "string",
    "uuid" : "string"
  } ],
  "tagName" : "string",
  "tagType" : "string",
  "userList" : [ {
    "createdBy" : "string",
    "creationDate" : "string",
    "description" : "string",
    "docId" : 0,
    "id" : 0,
    "lastUpdateDate" : "string",
    "lastUpdatedBy" : "string",
    "status" : "string",
    "userId" : 0,
    "userName" : "string",
    "uuid" : "string"
  } ],
  "userid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="richtext-rest-controller_resource"></a>
### Richtext-rest-controller
Richtext Rest Controller


<a name="createusingpost_6"></a>
#### create
```
POST /rest/core/richtexts
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**richtext**  <br>*required*|richtext|[Richtext](#richtext)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/richtexts
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "status" : "string",
  "text" : "string",
  "url" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbynameusingget"></a>
#### findByName
```
GET /rest/core/richtexts/name-{name}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**name**  <br>*required*|name|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/richtexts/name-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbynameusingget_1"></a>
#### findListByName
```
GET /rest/core/richtexts/namestart-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**namestart**  <br>*required*|namestart|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/richtexts/namestart-list
```


###### Request query
```
json :
{
  "namestart" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_5"></a>
#### findList
```
GET /rest/core/richtexts/sort-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**sortby**  <br>*required*|sortby|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/richtexts/sort-list
```


###### Request query
```
json :
{
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyuuidusingget_5"></a>
#### findByUuid
```
GET /rest/core/richtexts/uuid-{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/richtexts/uuid-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput_4"></a>
#### update
```
PUT /rest/core/richtexts/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Body**|**richtext**  <br>*required*|richtext|[Richtext](#richtext)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/richtexts/0
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "html" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "status" : "string",
  "text" : "string",
  "url" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatestatususingpatch_3"></a>
#### updateStatus
```
PATCH /rest/core/richtexts/{id}/status/{status}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int32)|
|**Path**|**status**  <br>*required*|status|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/richtexts/0/status/string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="role-rest-controller_resource"></a>
### Role-rest-controller
Role Rest Controller


<a name="createusingpost_7"></a>
#### create
```
POST /rest/roles
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**role**  <br>*required*|role|[Role](#role)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistactivedusingget_1"></a>
#### findListActived
```
GET /rest/roles/actived-list
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles/actived-list
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbynameusingget_2"></a>
#### findListByName
```
GET /rest/roles/namestart-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**namestart**  <br>*required*|namestart|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles/namestart-list
```


###### Request query
```
json :
{
  "namestart" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_6"></a>
#### findList
```
GET /rest/roles/sort-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"status"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles/sort-list
```


###### Request query
```
json :
{
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyidusingget"></a>
#### findById
```
GET /rest/roles/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles/0
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput_5"></a>
#### update
```
PUT /rest/roles/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|
|**Body**|**role**  <br>*required*|role|[Role](#role)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles/0
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "status" : "string",
  "uuid" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createpermissionsusingpost"></a>
#### createPermissions
```
POST /rest/roles/{id}/permissions
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|
|**Body**|**list**  <br>*required*|list|< [RolePermission](#rolepermission) > array|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles/0/permissions
```


###### Request body
```
json :
[ {
  "id" : 0,
  "perid" : 0,
  "roleid" : 0
} ]
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpermissionlistbyroleidusingget"></a>
#### findPermissionListByRoleid
```
GET /rest/roles/{id}/permissions
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/roles/0/permissions
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="sso-rest-controller_resource"></a>
### Sso-rest-controller
SSO Rest Controller


<a name="logoutbycookieusingdelete"></a>
#### logoutByCookie
```
DELETE /rest/sso
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/sso
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="loginbycookieusingpost"></a>
#### loginByCookie
```
POST /rest/sso/cfmd5
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**cfmd5**  <br>*required*|cfmd5|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/sso/cfmd5
```


###### Request query
```
json :
{
  "cfmd5" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="loginbyvalidatingnameandcodeusingpost"></a>
#### loginByValidatingNameAndCode
```
POST /rest/sso/codes
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**hm**  <br>*required*|hm|< string, string > map|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/sso/codes
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="loginbyvalidatingnameandpasswordusingpost"></a>
#### return a key for access token saved in cache. authCacheService.getTokenCache(key)
```
POST /rest/sso/passwords
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**hm**  <br>*optional*|login data|[hashmap](#hashmap)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/sso/passwords
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="sysconfig-rest-controller_resource"></a>
### Sysconfig-rest-controller
Sysconfig Rest Controller


<a name="createusingpost_8"></a>
#### create
```
POST /rest/core/sysconfigs
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**sysconfig**  <br>*required*|sysconfig|[Sysconfig](#sysconfig)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/sysconfigs
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "key" : "string",
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "status" : "string",
  "uuid" : "string",
  "value" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createdefaultsusingpost"></a>
#### createDefaults
```
POST /rest/core/sysconfigs/defaults
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/sysconfigs/defaults
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="initializationusingget"></a>
#### initialization
```
GET /rest/core/sysconfigs/initialization
```


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/sysconfigs/initialization
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbykeyusingget"></a>
#### findListByKey
```
GET /rest/core/sysconfigs/keystart-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**keystart**  <br>*required*|keystart|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/sysconfigs/keystart-list
```


###### Request query
```
json :
{
  "keystart" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_7"></a>
#### findList
```
GET /rest/core/sysconfigs/sort-list
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**sortby**  <br>*required*|sortby|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/sysconfigs/sort-list
```


###### Request query
```
json :
{
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput_6"></a>
#### update
```
PUT /rest/core/sysconfigs/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|
|**Body**|**sysconfig**  <br>*required*|sysconfig|[Sysconfig](#sysconfig)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/core/sysconfigs/0
```


###### Request body
```
json :
{
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "id" : 0,
  "key" : "string",
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "status" : "string",
  "uuid" : "string",
  "value" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="user-rest-controller_resource"></a>
### User-rest-controller
User Rest Controller


<a name="createusingpost_9"></a>
#### create
```
POST /rest/users
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**hm**  <br>*required*|hm|< string, string > map|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users
```


###### Request body
```
json :
{ }
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistbynameusingget_3"></a>
#### findListByName
```
GET /rest/users/namestart-page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**namestart**  <br>*required*|namestart|string||
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/namestart-page-list
```


###### Request query
```
json :
{
  "namestart" : "string",
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findlistusingget_8"></a>
#### findList
```
GET /rest/users/page-list
```


##### Parameters

|Type|Name|Description|Schema|Default|
|---|---|---|---|---|
|**Query**|**page**  <br>*optional*|page|integer (int32)|`0`|
|**Query**|**pagesize**  <br>*optional*|pagesize|integer (int32)|`0`|
|**Query**|**sortby**  <br>*optional*|sortby|string|`"id"`|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/page-list
```


###### Request query
```
json :
{
  "page" : 0,
  "pagesize" : 0,
  "sortby" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyuuidusingget_6"></a>
#### findByUuid
```
GET /rest/users/uuid-{uuid}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/uuid-string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updateusingput_7"></a>
#### update
```
PUT /rest/users/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|
|**Body**|**user**  <br>*required*|user|[User](#user)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/0
```


###### Request body
```
json :
{
  "cellPhone" : "string",
  "createdBy" : "string",
  "creationDate" : "string",
  "description" : "string",
  "email" : "string",
  "googleSecretKey" : "string",
  "id" : 0,
  "lastUpdateDate" : "string",
  "lastUpdatedBy" : "string",
  "name" : "string",
  "pwdmodify" : "string",
  "realName" : "string",
  "realNameEn" : "string",
  "sno" : "string",
  "status" : "string",
  "uuid" : "string",
  "weixin" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createrolesusingpost"></a>
#### createRoles
```
POST /rest/users/{id}/roles
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|
|**Body**|**list**  <br>*required*|list|< [UserRole](#userrole) > array|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/0/roles
```


###### Request body
```
json :
[ {
  "id" : 0,
  "roleid" : 0,
  "userid" : 0
} ]
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findrolelistusingget"></a>
#### findRoleList
```
GET /rest/users/{id}/roles
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/0/roles
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="createpwdmodifybyuuidusingpatch"></a>
#### createPwdmodifyByUuid
```
PATCH /rest/users/{uuid}/pwdmodify
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/string/pwdmodify
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findqrurlbyuuidusingget"></a>
#### findQRUrlByUuid
```
GET /rest/users/{uuid}/qr-code-url
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/string/qr-code-url
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatestatususingpatch_4"></a>
#### updateStatus
```
PATCH /rest/users/{uuid}/status/{status}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**status**  <br>*required*|status|string|
|**Path**|**uuid**  <br>*required*|uuid|string|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/rest/users/string/status/string
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```



