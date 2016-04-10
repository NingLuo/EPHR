(function(){
	"use strict";
	
	angular
		.module("EPHR")
		.controller("SidebarCtrl", SidebarCtrl);
	
	function SidebarCtrl($rootScope, $location) {
		var vm = this;
		vm.logout = logout;
		vm.ProviderID = $rootScope.currentUser._id;
		
		function logout() {
			$rootScope.currentUser = null;
			console.log("user logged out");
			$location.url("/login")
		}
	}
})();