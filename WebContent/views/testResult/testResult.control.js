(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("TestResultCtrl", TestResultCtrl);
	
	function TestResultCtrl($http, $rootScope, $location) {
		var vm = this;
		var userId= $rootScope.currentUser.id;
		vm.testResults;
		vm.openDetail = openDetail;
		
		function init()	{
			$http
				.get("http://localhost:8080/EPHR/rest/patient/" + userId + "/testResults")
				.then(
					function(response) {
						vm.testResults = response.data;
						console.log(vm.testResults);
					},
					function(err) {
						console.log(err);
					}
				);
		}
		init();
		
		function openDetail(summary) {
			$rootScope.summaryDetail = summary;
			$location.url("/summary");
		}
	}	
})();