var dynamicApp= angular.module('dynamicViews', ['ngRoute']);


dynamicApp.config(function($routeProvider){
	$routeProvider
	
	
	.when('/stocks', {templateUrl:'stocks.html', controller:'stocksController'})
	.when('/graph', {templateUrl:'graph.html', controller:'graphController'})
	.when('/order', {templateUrl:'order.html', controller: 'orderController'});
	
	
});


dynamicApp.controller('stocksController', function($scope, $http){

	
	
});
	


dynamicApp.controller('graphController', function($scope, $http){

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

	
});

dynamicApp.controller('orderController', function($scope){

	$scope.mes2=" I am a Order Controller ";
	
});
