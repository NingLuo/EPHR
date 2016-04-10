(function(){
	angular.module("EPHR")
			.controller("providerController",providerController);
			
	function providerController($rootScope,$http,$location,$routeParams){
		var model = this;
		var providerName = $routeParams.providerName;
		model.prescribe = prescribe;
		function init(){
			$http.get("/rest/provider/"+providerName)
				.then(function(response){
					model.provider = response.data;
			});
			$http.get("/rest/provider/"+providerName+"/medication")
			.then(function(response){
				model.meds = response.data;
			});
		}init();
		
		function prescribe(med){
			$http.post("/rest/provider/"+providerName+"/medication",med)
			then(function(response){
				if(response)
					init();
			})
		}
	}
})();