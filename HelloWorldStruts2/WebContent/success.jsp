<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>States</title>
</head>
<body>
	<s:iterator value="my_states" status="statusVar">
		<p>
			<s:property />
		</p>
	</s:iterator>
</body>