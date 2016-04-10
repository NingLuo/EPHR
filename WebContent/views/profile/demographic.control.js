(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("DemographicCtrl", DemographicCtrl);
	
	function DemographicCtrl($http, $rootScope, $location) {
		var vm = this;
		var userId= $rootScope.currentUser.id;
		vm.user;
		vm.update = update;
		
		function init()	{
			$http
				.get("http://localhost:8080/EPHR/rest/user/" + userId)
				.then(
					function(response) {
						vm.user = response.data;
					},
					function(err) {
						console.log(err);
					}
				);
		}
		init();
		
		function update() {
			$http
			.put("http://localhost:8080/EPHR/rest/patient/" + userId, vm.user)
			.then(
				function(response) {
					console.log("Update Success");
					$location.url("/profile");
				},
				function(err) {
					console.log(err);
				}
			);
		}
	}
})();