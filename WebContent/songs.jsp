<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<h1>List of Songs:</h1>
<ul>
    <c:forEach var="song" items="${requestScope.songs}">
    
        <li>Review ID: ${song.getreviewId() }, 
        Artist ID: ${song.getArtistId() }, 
        Song Name: ${song. getsongName()}, 
        Category: ${song.getCategory() }, 
        Duration: ${song.getDuration()}</li>
    </c:forEach>
</ul>

</body>
</html>