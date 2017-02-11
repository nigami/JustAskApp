<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="author" content="Ila Nigam" />
        <meta name="company" content="JustAsk Website" />
        <meta name="abstract" content="Connecting Problems & Solutions." />
 
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <tiles:insertAttribute name="stylecss" />
</head>
<body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
        <tiles:insertAttribute name="scriptjs" />
</body>
</html>