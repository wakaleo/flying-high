describe('MyAccountCtrl', function() {

	beforeEach(module('flying-high-app'));

	var scope,ctrl;

    beforeEach(inject(function($rootScope, $controller) {
      scope = $rootScope.$new();
      ctrl = $controller('MyAccountCtrl', {$scope: scope});
    }));	

	it('should retrieve account details', inject(function() {

		expect(1).toEqual(1);
		
	}));

});