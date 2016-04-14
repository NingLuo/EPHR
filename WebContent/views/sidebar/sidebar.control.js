(function(){
	"use strict";
	
	angular
		.module("EPHR")
		.controller("SidebarCtrl", SidebarCtrl);
	
	function SidebarCtrl($rootScope, $location) {
		var vm = this;
		vm.logout = logout;
		
		function logout() {
			$rootScope.currentUser = null;
			console.log("user logged out");
			$location.url("/login")
		}
	}
})();