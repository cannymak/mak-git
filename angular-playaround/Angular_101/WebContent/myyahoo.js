var myapp=angular.module('yahooapp',['ngMap']);
myapp.controller('yahoocontroller',function($scope,$http)
{
	
$scope.zipcode="";
$scope.query="";
$scope.info=[];


$scope.addinfo= function()
{
	var url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20local.search%20where%20zip='"+$scope.zipcode+"'and%20query='"+$scope.query+"'&format=json&diagnostics=false&callback=";	
	$http.get(url).success(function(data)
	{
		$scope.info.push(data);
		$scope.zipcode="";
		$scope.query="";
		
		
		
		
	});
	
	
};






});
