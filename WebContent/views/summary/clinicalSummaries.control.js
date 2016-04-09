(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("ClinicalSummariesCtrl", ClinicalSummariesCtrl);
	
	function ClinicalSummariesCtrl($http, $rootScope, $location) {
		var vm = this;
		var userId= $rootScope.currentUser.id;
		
		function init()	{
			$http
				.get("http://localhost:8080/EPHR/rest/patient/" + userId + "/clinicalSummaries")
				.then(
					function(response) {
						console.log(response.data);
					},
					function(err) {
						console.log(err);
					}
				);
		}
		init();
		
	}	
})();