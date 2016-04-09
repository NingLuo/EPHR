(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("ClinicalSummariesCtrl", ClinicalSummariesCtrl);
	
	function ClinicalSummariesCtrl($http, $rootScope, $location) {
		var vm = this;
		var userId= $rootScope.currentUser.id;
		vm.summaries;
		vm.openDetail = openDetail;
		
		function init()	{
			$http
				.get("http://localhost:8080/EPHR/rest/patient/" + userId + "/clinicalSummaries")
				.then(
					function(response) {
						vm.summaries = response.data;
						console.log(vm.summaries);
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