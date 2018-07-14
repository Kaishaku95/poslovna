'use strict';

angular.module('jedinicaAdd')
	.component('myJedinicaAdd', {
		templateUrl: '/part/jedinica-add/jedinica-add.template.html',
		controller: function() {
			JedinicaMereService.getAll()
			.then( (response) => {
				this.jedinicaMere = response.data;
			});
			this.add = () => {
			JedinicaMereService.add(this.jedinicaMere)
			.then( () => {
				console.log(this.jedinicaMere);
				this.status = 'Uspesno dodato';
			}, () => {
				console.log(this.jedinicaMere);
				this.status = 'Greska';
			});
			};
		}
	});
