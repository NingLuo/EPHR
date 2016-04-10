(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("ProfileCtrl", ProfileCtrl);
	
	
	function ProfileCtrl($rootScope, $http) {
		var vm = this;
		var userId = $rootScope.currentUser.id;
		vm.currentUser;
		
		function init() {
			$http
			.get("http://localhost:8080/EPHR/rest/user/" + userId)
			.then(
					function(response) {
						vm.currentUser = response.data;
					},
					function(err) {
						console.log(err);
					}
			);
		}
		init();
	}
})();