'use strict';

angular.module('vrstaAdd')
	.component('myVrstaAdd', {
		templateUrl: '/part/vrsta-add/vrsta-add.template.html',
		controller: function(VrstaProizvodaService) {
			VrstaProizvodaService.getAll()
			.then( (response) => {
				this.vrsteProizvoda = response.data;
			});
			this.add = () => {
			VrstaProizvodaService.add(this.vrstaProizvoda)
			.then( () => {
				console.log(this.vrstaProizvoda);
				location.reload();
				this.status = 'Uspesno dodato';
			}, () => {
				console.log(this.vrstaProizvoda);
				this.status = 'Greska';
			});
			};
		}
	});
