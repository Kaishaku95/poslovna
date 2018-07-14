'use strict';

angular.module('vrstaAdd')
	.component('myVrstaAdd', {
		templateUrl: '/part/vrsta-add/vrsta-add.template.html',
		controller: function(VrstaProizvodaService) {
			VrstaProizvodaService.getAll()
			.then( (response) => {
				this.vrsteProizvoda = response.data;
			});
			
			VrstaProizvodaService.add(this.vrstaProizvoda)
			.then( () => {
				this.status = 'Uspesno dodato';
			}, () => {
				this.status = 'Greska';
			});
		}
	});
