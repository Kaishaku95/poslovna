'use strict';

angular.module('cenovnikList')
	.component('myCenovnikList', {
		templateUrl: '/part/cenovnik-list/cenovnik-list.template.html',
		controller: function(CenovnikService) {
			CenovnikService.getAll()
				.then( (response) => {
					this.cenovnici = response.data;
					this.selectedCenovnik = this.cenovnici[0];
					this.changeCenovnik();
				});
			this.changeCenovnik = () => {
				CenovnikService.getStavke(this.selectedCenovnik.id)
					.then( (response) => {
						this.stavke = response.data;
					});
			};

			this.first = () => {
				this.selected(this.stavke[0]);
			};
			this.previous = () => {
				let index = this.stavke.indexOf(this.selectedStavka);
				if(index === 0)
					index = this.stavke.length;
				this.selected(this.stavke[index - 1]);
			};
			this.next = () => {
				let index = this.stavke.indexOf(this.selectedStavka);
				if(index === this.stavke.length - 1)
					index = -1;
				this.selected(this.stavke[index + 1]);
			};
			this.last = () => {
				this.selected(this.stavke[this.stavke.length - 1]);
			};
			this.selected = (stavka) => {
				this.selectedStavka = stavka;
			};
		}
	});
