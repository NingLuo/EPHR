(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("ProfileCtrl", ProfileCtrl);
	
	
	function ProfileCtrl($rootScope, $http) {
		var vm = this;
		var userId = $rootScope.currentUser.id;
		vm.currentUser;
		vm.contactInfoList;
		
		function init() {
			$http
			.get("http://localhost:8080/EPHR/rest/user/" + userId)
			.then(
					function(response) {
						vm.currentUser = response.data;
						return $http.get("http://localhost:8080/EPHR/rest/patient/" + userId + "/contactInfoList");
					},
					function(err) {
						console.log(err);
					}
			)
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
	}
})();