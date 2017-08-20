app.factory('UserService',function($http){
var userService={};

userService.getAllUsers=function(){
return $http.get("http://localhost:9025/login/getallusers")
}

userService.saveuser=function(user){
return $http.post("http://localhost:9025/login/saveuser",user)
}

userService.login=function(user){
	return $http.post("http://localhost:9025/login/login",user)
}

userService.logout=function(user){
	return $http.post("http://localhost:9025/login/logout",user)
}


return userService;
})