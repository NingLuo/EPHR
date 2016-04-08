(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("HomeCtrl", HomeCtrl);
	
	function HomeCtrl($http, $rootScope, $location) {
		var vm = this;
		vm.login = login;
		
		function login(user) {
			$http
				.get("http://localhost:8080/EPHR/rest/user/login?username=" + user.username + "&password=" + user.password)
				.then(
						function(response) {
							console.log(response.data.username + " log in success!");
							$rootScope.currentUser = response.data;
							$location.url("/profile");
						},
						function(err) {
							console.log(err);
						}
				);
		}
	}
})();