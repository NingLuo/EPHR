(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("ContactInfoCtrl", ContactInfoCtrl);
	
	function ContactInfoCtrl($http, $rootScope, $location) {
		var vm = this;
		var userId= $rootScope.currentUser.id;
		vm.contactInfoList;
		vm.update = update;
		
		function init()	{
			$http
				.get("http://localhost:8080/EPHR/rest/patient/" + userId + "/contactInfoList")
				.then(
						function(response) {
							console.log(response.data);
							vm.contactInfoList = response.data;
						},
						function(err) {
							console.log(err);
						}
				);
		}
		init();
		
		function update() {
			$http
			.put("http://localhost:8080/EPHR/rest/patient/" + userId + "/contactInfoList", vm.contactInfoList)
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