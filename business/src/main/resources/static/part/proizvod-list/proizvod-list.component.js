'use strict';

angular.module('proizvodList')
	.component('myProizvodList', {
		templateUrl: '/part/proizvod-list/proizvod-list.template.html',
		controller: function(FakturaService) {
			this.refresh = () => {
				FakturaService.getStavke()
					.then( (response) => {
						this.stavke = response.data;
						if(!this.selectedStavka)
							this.selectedStavka = this.stavke[0];
					});
			};
			this.refresh();

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

			this.add = () => {
				this.narudzbenica.stavke = this.stavke;
				FakturaService.order(this.narudzbenica)
					.then( (response) => {
						this.fakturaId = response.data;
						this.refresh();
						this.isAddMode = false;
						this.addStatus = '';
					}, () => {
						this.addStatus = 'Greška pri dodavanju narudžbenice';
					});
			};
		}
	});
