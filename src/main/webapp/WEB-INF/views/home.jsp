<!--

    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<title>Jakarta MVC 1.0 DEMO</title>
</head>
<body>
    <jsp:include page="/templates/menu.jsp"></jsp:include>

    <h1 class="text-center">Be welcome!</h1>

    <div class="text-center">
        <img src="${pageContext.request.contextPath}/resources/images/jakaraMVC.png" class="img-responsive center-block" width="400" height="400"/>
    </div>
    <br/>
    <br/>
    <jsp:include page="/templates/footer.jsp"></jsp:include>
</body>
</html>