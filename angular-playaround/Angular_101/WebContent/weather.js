var weatherapp=angular.module("weather_app", ['ngMap']);

weatherapp.controller("controller2", function($scope, $http){
	
	$scope.location="";
		
	$scope.locations=[];
	
	$scope.addReport=function(){
		
		var url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20location=" + $scope.location + "&format=json&diagnostics=true&callback=";
		
		
		$http.get(url).success(function(data){
			
			$scope.locations.push(data);
		}).error(function(data){
			$scope.window.alert("Enter ZipCode is invalid");
		});

	};
	
	$scope.addMap=function(){
		
		var url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20local.search%20where%20zip=%27" + $scope.location "%27and%20query=%27pizza%27&format=json&diagnostics=false&callback=";
	
		$http.get(url).success(function(data){
		
			
			$scope.locations.push(data);
			
		});
		
	};
	
	
});