(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("BloodTestCtrl", BloodTestCtrl);
	
	function BloodTestCtrl($http, $rootScope, $location) {
		var vm = this;
		
		function init() {
			console.log("BloodTestCtrl start!");
			console.log($rootScope.testDetail);
		}
		init();
	}	
})();