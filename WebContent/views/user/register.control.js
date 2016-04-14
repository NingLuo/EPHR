(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("RegisterCtrl", RegisterCtrl);
	
	function RegisterCtrl($http, $location, $rootScope) {
		var vm = this;
		vm.register = register;
		
		function register(user) {
			if(user.role == 0){
				$http
				.post("http://localhost:8080/EPHR/rest/patient", user)
				.then(
						function(response) {
							$rootScope.currentUser = response.data;
							$location.url("/profile");
						},
						function(err) {
							console.log(err);
						}
				);
			}else{
				$http
				.post("http://localhost:8080/EPHR/rest/provider",user)
				.then(
						function(response) {
							$rootScope.currentUser = response.data;
							$location.url("/provider");
						},
						function(err) {
							console.log(err);
						}
				);
			}
		
		}
	}
})();