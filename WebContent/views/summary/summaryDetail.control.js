(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("SummaryDetailCtrl", SummaryDetailCtrl);
	
	function SummaryDetailCtrl($http, $rootScope, $location) {
		var vm = this;
		
		function init() {
			console.log($rootScope.summaryDetail);
		}
		init();
	}	
})();