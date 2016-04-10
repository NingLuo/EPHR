(function(){
	angular.module("EPHR")
			.controller("providerController",providerController);
			
	function providerController($rootScope,$http,$location,$routeParams){
		var model = this;
		var providerId = $rootScope.currentUser.id;
		model.prescribe = prescribe;
		
		function init(){
			$http.get("/rest/provider/"+providerId)
				.then(function(response){
					model.provider = response.data;
					model.meds = response.data.getMedications;
			});
			/*$http.get("/rest/provider/"+providerId+"/medication")
			.then(function(response){
				model.meds = response.data;
			});*/
		}init();
		
		function prescribe(med){
			med.provider = providerId;
			$http.post("/rest/provider/medication",med)
			then(function(response){
				if(response)
					init();
			})
		}
	}
})();