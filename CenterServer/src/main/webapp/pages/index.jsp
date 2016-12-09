<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="by.center.data.entity.Candidate"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Statistic page</title>
    <style>
  	.caption {
			caption-side: bottom;
			text-align: right;
			padding: 10px 0; 
			font-size: 14px;			
		}		
		table {
		  font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
		  font-size: 14px;
		  background: white;
		  max-width: 70%;
		  width: 70%;
		  border-collapse: collapse;
		  text-align: left;
		}
		th {
		  font-size: 13px;
		  font-weight: normal;
		  background: #b9c9fe;
		  border-top: 4px solid #aabcfe;
		  border-bottom: 1px solid #fff;
		  color: #039;
		  padding: 8px;
		}
		td {
		  background: #e8edff;
		  border-bottom: 1px solid #fff;
		  color: #669;
		  border-top: 1px solid transparent;
		  padding: 8px;
		}
		tr:hover td {
		  background: #ccddff; 
		}
    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="/static/css/sticky-footer.css" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	  
	});
	</script>
	
</head>

<body>
    <div>
		<div>
			<h2>Statistic Server</h2>
		</div>		
		<div>
		<c:forEach items="${listSectors}" var="sectors">
			<table border-collapse: collapse;>
			   <caption>${sectors} участок голосования!Не голосуешь - В польше небось воруешь!!! </caption>
			      <tr>
			         <th>Кондидат</th><th>Сектор</th><th>кол-во голосов</th>			         			         
			      </tr>	
			      <c:forEach items="${listStatistics}" var="statistic">
			      <c:if test="${sectors==statistic.sector}">
 						<tr>
							<td>${statistic.candidate}</td>
							<td>${statistic.sector}</td>
							<td>${statistic.countVote}</td>							
						</tr>
				  </c:if>
			     </c:forEach>			 	
			</table>	
			</c:forEach>		
		</div>
	</div>
</body>
</html>
