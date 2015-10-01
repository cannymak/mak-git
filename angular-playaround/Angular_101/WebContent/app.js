var myapp=angular.module('movieapp_db',[]);

myapp.controller('controller1', function($scope,$http){
	$scope.moviename="";
	
	$scope.movies=[];
	
	$scope.addMovie=function(){
		
		
		var url="http://www.omdbapi.com/?t="+$scope.moviename+"&y=&plot=short&r=json";
		
		//calling web service
		
		$http.get(url).success(function(data){
			$scope.movies.push(data);
		});
		
		
	};
	
	
	
	
	
	
});