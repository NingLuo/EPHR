(function(){
	"use strict";
	
	angular
		.module("EPHR")
		.controller("MedicationCtrl", MedicationCtrl);
	
	function MedicationCtrl($rootScope, $http) {
		var vm = this;
		var userId = $rootScope.currentUser.id;
		vm.medications;
		
		function init() {
			$http
			.get("http://localhost:8080/EPHR/rest/patient/" + userId + "/medications")
			.then(
				function(response) {
					vm.medications = response.data;
					console.log(vm.medications);
				},
				function(err) {
					console.log(err);
				}
			);
		}
		init();
		
//		function openDetail(test) {
//			$rootScope.testDetail = test;
//			$location.url("bloodTest");
//		}
	}
})();