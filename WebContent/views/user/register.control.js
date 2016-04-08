(function() {
	"use strict";
	
	angular
		.module("EPHR")
		.controller("RegisterCtrl", RegisterCtrl);
	
	function RegisterCtrl($http) {
		var vm = this;
		vm.register = register;
		
		function register(user) {
			$http
				.post("http://localhost:8080/EPHR/rest/patient", user)
				.then(
						function(response) {
							console.log(response.data);
						},
						function(err) {
							console.log(err);
						}
				);
		}
	}
})();