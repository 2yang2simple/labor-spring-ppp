
<a name="definitions"></a>
## Definitions

<a name="asample"></a>
### ASample

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="dictionary"></a>
### Dictionary

|Name|Description|Schema|
|---|---|---|
|**code**  <br>*optional*|**Example** : `"string"`|string|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**order**  <br>*optional*|**Example** : `0`|integer (int32)|
|**parentid**  <br>*optional*|**Example** : `0`|integer (int32)|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|
|**value1**  <br>*optional*|**Example** : `"string"`|string|
|**value2**  <br>*optional*|**Example** : `"string"`|string|
|**value3**  <br>*optional*|**Example** : `"string"`|string|
|**value4**  <br>*optional*|**Example** : `"string"`|string|
|**value5**  <br>*optional*|**Example** : `"string"`|string|


<a name="document"></a>
### Document

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**docStatus**  <br>*optional*|**Example** : `"string"`|string|
|**fileMd5**  <br>*optional*|**Example** : `"string"`|string|
|**filePath**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**namePinyin**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="documentcomment"></a>
### DocumentComment

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**creator**  <br>*optional*|**Example** : `"string"`|string|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**docId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**html**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**text**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="documentcontent"></a>
### DocumentContent

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**docId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**html**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**md5**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**text**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="documentdto"></a>
### DocumentDto

|Name|Description|Schema|
|---|---|---|
|**commentList**  <br>*optional*|**Example** : `[ "[documentcomment](#documentcomment)" ]`|< [DocumentComment](#documentcomment) > array|
|**content**  <br>*optional*|**Example** : `"[documentcontent](#documentcontent)"`|[DocumentContent](#documentcontent)|
|**contentList**  <br>*optional*|**Example** : `[ "[documentcontent](#documentcontent)" ]`|< [DocumentContent](#documentcontent) > array|
|**creator**  <br>*optional*|**Example** : `"[uservo](#uservo)"`|[UserVO](#uservo)|
|**docStatus**  <br>*optional*|**Example** : `"string"`|string|
|**document**  <br>*optional*|**Example** : `"[document](#document)"`|[Document](#document)|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**tagList**  <br>*optional*|**Example** : `[ "[documenttag](#documenttag)" ]`|< [DocumentTag](#documenttag) > array|
|**tagName**  <br>*optional*|**Example** : `"string"`|string|
|**tagType**  <br>*optional*|**Example** : `"string"`|string|
|**userList**  <br>*optional*|**Example** : `[ "[documentuser](#documentuser)" ]`|< [DocumentUser](#documentuser) > array|
|**userid**  <br>*optional*|**Example** : `"string"`|string|


<a name="documenttag"></a>
### DocumentTag

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**docId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**tagId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**tagName**  <br>*optional*|**Example** : `"string"`|string|
|**tagType**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="documentuser"></a>
### DocumentUser

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**docId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**userId**  <br>*optional*|**Example** : `0`|integer (int64)|
|**userName**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="file"></a>
### File

|Name|Description|Schema|
|---|---|---|
|**absolute**  <br>*optional*|**Example** : `true`|boolean|
|**absoluteFile**  <br>*optional*|**Example** : `"file"`|file|
|**absolutePath**  <br>*optional*|**Example** : `"string"`|string|
|**canonicalFile**  <br>*optional*|**Example** : `"file"`|file|
|**canonicalPath**  <br>*optional*|**Example** : `"string"`|string|
|**directory**  <br>*optional*|**Example** : `true`|boolean|
|**executable**  <br>*optional*|**Example** : `true`|boolean|
|**file**  <br>*optional*|**Example** : `true`|boolean|
|**freeSpace**  <br>*optional*|**Example** : `0`|integer (int64)|
|**hidden**  <br>*optional*|**Example** : `true`|boolean|
|**lastModified**  <br>*optional*|**Example** : `0`|integer (int64)|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**parent**  <br>*optional*|**Example** : `"string"`|string|
|**parentFile**  <br>*optional*|**Example** : `"file"`|file|
|**path**  <br>*optional*|**Example** : `"string"`|string|
|**readable**  <br>*optional*|**Example** : `true`|boolean|
|**totalSpace**  <br>*optional*|**Example** : `0`|integer (int64)|
|**usableSpace**  <br>*optional*|**Example** : `0`|integer (int64)|
|**writable**  <br>*optional*|**Example** : `true`|boolean|


<a name="gallery"></a>
### Gallery

|Name|Description|Schema|
|---|---|---|
|**caption**  <br>*optional*|**Example** : `"string"`|string|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**namePinyin**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="galleryimage"></a>
### GalleryImage

|Name|Description|Schema|
|---|---|---|
|**caption**  <br>*optional*|**Example** : `"string"`|string|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**fileName**  <br>*optional*|**Example** : `"string"`|string|
|**gaId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**namePinyin**  <br>*optional*|**Example** : `"string"`|string|
|**ohId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**order**  <br>*optional*|**Example** : `0`|integer (int32)|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**url**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="inputstream"></a>
### InputStream
*Type* : object


<a name="product"></a>
### Product

|Name|Description|Schema|
|---|---|---|
|**code**  <br>*optional*|**Example** : `"string"`|string|
|**color**  <br>*optional*|**Example** : `"string"`|string|
|**costPrice**  <br>*optional*|**Example** : `0.0`|number (float)|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**currency**  <br>*optional*|**Example** : `"string"`|string|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**itemNo**  <br>*optional*|**Example** : `"string"`|string|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**marketPrice**  <br>*optional*|**Example** : `0.0`|number (float)|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**namePinyin**  <br>*optional*|**Example** : `"string"`|string|
|**parentId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**price**  <br>*optional*|**Example** : `0.0`|number (float)|
|**productStatus**  <br>*optional*|**Example** : `"string"`|string|
|**size**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="project"></a>
### Project

|Name|Description|Schema|
|---|---|---|
|**amount**  <br>*optional*|**Example** : `0.0`|number (float)|
|**code**  <br>*optional*|**Example** : `"string"`|string|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**currency**  <br>*optional*|**Example** : `"string"`|string|
|**customer**  <br>*optional*|**Example** : `"string"`|string|
|**customerCode**  <br>*optional*|**Example** : `"string"`|string|
|**deliveryDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**manager**  <br>*optional*|**Example** : `"string"`|string|
|**managerUserid**  <br>*optional*|**Example** : `0`|integer (int32)|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**namePinyin**  <br>*optional*|**Example** : `"string"`|string|
|**parentId**  <br>*optional*|**Example** : `0`|integer (int32)|
|**projectStatus**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**supplier**  <br>*optional*|**Example** : `"string"`|string|
|**supplierCode**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="resource"></a>
### Resource

|Name|Description|Schema|
|---|---|---|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**file**  <br>*optional*|**Example** : `"file"`|file|
|**filename**  <br>*optional*|**Example** : `"string"`|string|
|**inputStream**  <br>*optional*|**Example** : `"[inputstream](#inputstream)"`|[InputStream](#inputstream)|
|**open**  <br>*optional*|**Example** : `true`|boolean|
|**readable**  <br>*optional*|**Example** : `true`|boolean|
|**uri**  <br>*optional*|**Example** : `"[uri](#uri)"`|[URI](#uri)|
|**url**  <br>*optional*|**Example** : `"[url](#url)"`|[URL](#url)|


<a name="result"></a>
### Result

|Name|Description|Schema|
|---|---|---|
|**code**  <br>*optional*|**Example** : `0`|integer (int32)|
|**data**  <br>*optional*|**Example** : `"object"`|object|
|**msg**  <br>*optional*|**Example** : `"string"`|string|


<a name="richtext"></a>
### Richtext

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**html**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int32)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**text**  <br>*optional*|**Example** : `"string"`|string|
|**url**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="role"></a>
### Role

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int64)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|


<a name="rolepermission"></a>
### RolePermission

|Name|Description|Schema|
|---|---|---|
|**id**  <br>*optional*|**Example** : `0`|integer (int64)|
|**perid**  <br>*optional*|**Example** : `0`|integer (int64)|
|**roleid**  <br>*optional*|**Example** : `0`|integer (int64)|


<a name="sysconfig"></a>
### Sysconfig

|Name|Description|Schema|
|---|---|---|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int64)|
|**key**  <br>*optional*|**Example** : `"string"`|string|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|
|**value**  <br>*optional*|**Example** : `"string"`|string|


<a name="uri"></a>
### URI

|Name|Description|Schema|
|---|---|---|
|**absolute**  <br>*optional*|**Example** : `true`|boolean|
|**authority**  <br>*optional*|**Example** : `"string"`|string|
|**fragment**  <br>*optional*|**Example** : `"string"`|string|
|**host**  <br>*optional*|**Example** : `"string"`|string|
|**opaque**  <br>*optional*|**Example** : `true`|boolean|
|**path**  <br>*optional*|**Example** : `"string"`|string|
|**port**  <br>*optional*|**Example** : `0`|integer (int32)|
|**query**  <br>*optional*|**Example** : `"string"`|string|
|**rawAuthority**  <br>*optional*|**Example** : `"string"`|string|
|**rawFragment**  <br>*optional*|**Example** : `"string"`|string|
|**rawPath**  <br>*optional*|**Example** : `"string"`|string|
|**rawQuery**  <br>*optional*|**Example** : `"string"`|string|
|**rawSchemeSpecificPart**  <br>*optional*|**Example** : `"string"`|string|
|**rawUserInfo**  <br>*optional*|**Example** : `"string"`|string|
|**scheme**  <br>*optional*|**Example** : `"string"`|string|
|**schemeSpecificPart**  <br>*optional*|**Example** : `"string"`|string|
|**userInfo**  <br>*optional*|**Example** : `"string"`|string|


<a name="url"></a>
### URL

|Name|Description|Schema|
|---|---|---|
|**authority**  <br>*optional*|**Example** : `"string"`|string|
|**content**  <br>*optional*|**Example** : `"object"`|object|
|**defaultPort**  <br>*optional*|**Example** : `0`|integer (int32)|
|**deserializedFields**  <br>*optional*|**Example** : `"[urlstreamhandler](#urlstreamhandler)"`|[URLStreamHandler](#urlstreamhandler)|
|**file**  <br>*optional*|**Example** : `"string"`|string|
|**host**  <br>*optional*|**Example** : `"string"`|string|
|**path**  <br>*optional*|**Example** : `"string"`|string|
|**port**  <br>*optional*|**Example** : `0`|integer (int32)|
|**protocol**  <br>*optional*|**Example** : `"string"`|string|
|**query**  <br>*optional*|**Example** : `"string"`|string|
|**ref**  <br>*optional*|**Example** : `"string"`|string|
|**serializedHashCode**  <br>*optional*|**Example** : `0`|integer (int32)|
|**userInfo**  <br>*optional*|**Example** : `"string"`|string|


<a name="urlstreamhandler"></a>
### URLStreamHandler
*Type* : object


<a name="user"></a>
### User

|Name|Description|Schema|
|---|---|---|
|**cellPhone**  <br>*optional*|**Example** : `"string"`|string|
|**createdBy**  <br>*optional*|**Example** : `"string"`|string|
|**creationDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**description**  <br>*optional*|**Example** : `"string"`|string|
|**email**  <br>*optional*|**Example** : `"string"`|string|
|**googleSecretKey**  <br>*optional*|**Example** : `"string"`|string|
|**id**  <br>*optional*|**Example** : `0`|integer (int64)|
|**lastUpdateDate**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**lastUpdatedBy**  <br>*optional*|**Example** : `"string"`|string|
|**name**  <br>*optional*|**Example** : `"string"`|string|
|**pwdmodify**  <br>*optional*|**Example** : `"string"`|string|
|**realName**  <br>*optional*|**Example** : `"string"`|string|
|**realNameEn**  <br>*optional*|**Example** : `"string"`|string|
|**sno**  <br>*optional*|**Example** : `"string"`|string|
|**status**  <br>*optional*|**Example** : `"string"`|string|
|**uuid**  <br>*optional*|**Example** : `"string"`|string|
|**weixin**  <br>*optional*|**Example** : `"string"`|string|


<a name="userrole"></a>
### UserRole

|Name|Description|Schema|
|---|---|---|
|**id**  <br>*optional*|**Example** : `0`|integer (int64)|
|**roleid**  <br>*optional*|**Example** : `0`|integer (int64)|
|**userid**  <br>*optional*|**Example** : `0`|integer (int64)|


<a name="uservo"></a>
### UserVO

|Name|Description|Schema|
|---|---|---|
|**userId**  <br>*optional*|**Example** : `0`|integer (int64)|
|**userName**  <br>*optional*|**Example** : `"string"`|string|
|**userRealName**  <br>*optional*|**Example** : `"string"`|string|
|**userUuid**  <br>*optional*|**Example** : `"string"`|string|



