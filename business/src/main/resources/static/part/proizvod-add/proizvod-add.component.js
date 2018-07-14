'use strict';

angular.module('proizvodAdd')
	.component('myProizvodAdd', {
		templateUrl: '/part/proizvod-add/proizvod-add.template.html',
		controller: function(ProizvodService) {
			ProizvodService.getAllJM()
			.then( (response) => {
				this.jedinice = response.data;
			});
			ProizvodService.getAllVP()
			.then( (response) => {
				this.vrste = response.data;
			});
			ProizvodService.getAllGR()
			.then( (response) => {
				console.log(response.data);
				this.grupe = response.data;
			});
			this.add = () => {
			ProizvodService.add(this.proizvod)
			.then( () => {
				console.log(this.proizvod);
				this.status = 'Uspesno dodato';
			}, () => {
				console.log(this.proizvod);
				this.status = 'Greska';
			});
			};
		}
	});
