var dynamicApp= angular.module('dynamicViews', ['ngRoute']);


dynamicApp.config(function($routeProvider){
	$routeProvider
	
	
	.when('/stocks', {templateUrl:'stocks.html', controller:'stocksController'})
	.when('/graph', {templateUrl:'graph.html', controller:'graphController'})
	.when('/order', {templateUrl:'order.html', controller: 'orderController'});
	
	
});

dynamicApp.controller('mainController', function($scope){

	
	
});

dynamicApp.controller('stocksController', function($scope){

	$scope.mes=" I am a Stocks Controller ";
	
});


dynamicApp.controller('graphController', function($scope){

	$scope.mes1=" I am a Graph Controller ";
	
	
});

dynamicApp.controller('orderController', function($scope){

	$scope.mes2=" I am a Order Controller ";
	
});
