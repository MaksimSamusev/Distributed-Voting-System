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

    <title>Vote page</title>
    
	<style>
		.center {
		    width: 1000px; /* РЁРёСЂРёРЅР° СЌР»РµРјРµРЅС‚Р° РІ РїРёРєСЃРµР»Р°С… */
		    padding: 10px; /* РџРѕР»СЏ РІРѕРєСЂСѓРі С‚РµРєСЃС‚Р° */
		    margin: auto; /* Р’С‹СЂР°РІРЅРёРІР°РµРј РїРѕ С†РµРЅС‚СЂСѓ */
		    background: #fc0; /* Р¦РІРµС‚ С„РѕРЅР° */
		     text-align: center;
		}
		.centervote{
		  width: 994px; /* РЁРёСЂРёРЅР° СЌР»РµРјРµРЅС‚Р° РІ РїРёРєСЃРµР»Р°С… */
		    padding: 10px; /* РџРѕР»СЏ РІРѕРєСЂСѓРі С‚РµРєСЃС‚Р° */
		    margin: auto; /* Р’С‹СЂР°РІРЅРёРІР°РµРј РїРѕ С†РµРЅС‚СЂСѓ */
		     box-shadow: 0 0 0 3px #fc0;		  
		     text-align: center;
		}
		.outer:before {
		  content: '';
		  display: inline-block;
		  height: 100%;
		  vertical-align: middle;
		}
		
		.inner {
		  display: inline-block;
		  vertical-align: middle;
		}
		.textcenter {
		   text-align: center;
		   }
		   * {
		    margin: 0;
		    padding: 0;
		}
				
		body, html {
		    height: 100%;
		}
		
		.container {
		
		    display: flex;
		    align-items: center;
		    justify-content: center;
		    height: 100%;
		}
		
		.container p {
		    width: 325px;
		    padding: 15px;
		}
	</style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="/static/css/sticky-footer.css" >
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    $("#create").click(function (e) {
	        var checked_option_radio = $('input:radio[name=check_candidate]:checked').val();
	        
	        if(checked_option_radio===undefined)
	            {
	                alert('Please select  options!');
	            }else{
	                $.ajax({
	                	url: '/VoteServer/create',
	                   	data: {check_candidate: checked_option_radio},
	                    method: 'POST',
	                        
	                    success: function (data) {	
	                        $('input:radio[name=check_candidate]:checked').prop('checked', false);
	                        alert('Голос Учтен');
	                    },
	                    error:  function(xhr, str){
	                        alert('Error' );
	                    }
	                });
	            }
	    });
	});
	</script>
	
</head>

<body>
    <div class="outer" style="height:200px; width: 100%;">
    	<div class="center">
			<h2 style="font-family:Lobster, cursive; Font-size:30px;">Голосование районного участка №1</h2>		
			
		</div>			
		<div class="centervote">
			<h4>Выберите одного из следующих кандидатов:</h4>
		
		
		
			<c:forEach items="${names}" var="name">
    			<p><input type="radio" name="check_candidate" value="${name}">${name}</p>
			</c:forEach>
		</div>
		<div>
			<p class="center"><input class="btn btn-lg btn-success btn-block" type="button" id="create" value="Отдать голос!"></p>

		</div>
	</div>
</body>
</html>
