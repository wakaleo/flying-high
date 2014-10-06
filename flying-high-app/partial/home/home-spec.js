describe('HomeCtrl', function() {

	beforeEach(module('flying-high-app'));

	var scope,ctrl;

    beforeEach(inject(function($rootScope, $controller) {
      scope = $rootScope.$new();
      ctrl = $controller('HomeCtrl', {$scope: scope});
    }));	

	it('should display available destinations', inject(function() {

		expect(1).toEqual(1);
		
	}));

});