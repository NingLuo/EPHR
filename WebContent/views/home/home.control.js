(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("HomeCtrl", HomeCtrl);
	
	function HomeCtrl($http) {
		var vm = this;
		vm.login = login;
		
		function login(user) {
			
		}
	}
})();