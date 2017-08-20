app.controller('UserController',function(UserService,$scope,$location,$rootScope,$cookieStore){
 
$scope.users=UserService.getAllUsers().then(function(response){
console.log(response.status)
$scope.users=response.data;
},function(response){
console.log(response.status)
})
 
$scope.save=function(){
	
UserService.saveuser($scope.user).then(function(response){
console.log(response.status)
console.log(response.data)
$location.path("/home")
},function(response){
console.log(response.status)
})
}

$scope.login=function(){
	UserService.login($scope.user).then(function(response){
	//	alert('success')
		$rootScope.currentUser=response.data
		$rootScope.loginstatus="logout"
		$rootScope.signinstatus="Sign Out"
		$cookieStore.put("currentUser",response.data)
		$location.path("/home")
	},
	function(response){
	//	alert('failed')
		$scope.error=response.data
		$location.path("/login")
	})
}

 


})