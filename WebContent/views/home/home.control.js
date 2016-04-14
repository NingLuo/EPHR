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
							console.log(response.data.username + " log in success!",response.data);
							$rootScope.currentUser = response.data;
							if($rootScope.currentUser.role == 0)
							$location.url("/profile");
							else
								$location.url("/provider");
						},
						function(err) {
							console.log(err);
						}
				);
		}
	}
})();