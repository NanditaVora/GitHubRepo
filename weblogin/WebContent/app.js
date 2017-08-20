//alert("app loaded");
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){

//alert($routeProvider);	
	
$routeProvider
.when('/home',{
templateUrl:'views/home.html'

})
.when('/login',{
	templateUrl:'views/loginpage.html',
	controller:'UserController'
})

.when('/getallusers',{
templateUrl:'views/users.html',
controller:'UserController'
})
.when('/saveuser',{
templateUrl:'views/userform.html',
controller:'UserController'
})
.otherwise({redirectTo: '/'});
 
})


app.run(function($rootScope,$location,UserService,$cookieStore){
	if($rootScope.currentUser==undefined)
		{
			$rootScope.currentUser=$cookieStore.get("currentUser")
			$rootScope.loginstatus="login"
			$rootScope.signinstatus="Sign In"
		}
	$rootScope.logout=function(){
		UserService.logout().then(function(response){
			$rootScope.message="loggedout successfully..."
			delete $rootScope.currentUser;
			$cookieStore.remove("currentUser");
			$location.path("/login")
			 
			$rootScope.signinstatus="Sign In"
		},function(response){
			console.log(response.status)
			$rootScope.message=response.data.message
			$location.path("/login")
			 
			$rootScope.signinstatus="Sign Out"
		})
	}
	
})