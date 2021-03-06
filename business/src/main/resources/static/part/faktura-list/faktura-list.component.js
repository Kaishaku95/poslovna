'use strict';

angular.module('fakturaList')
	.component('myFakturaList', {
		templateUrl: '/part/faktura-list/faktura-list.template.html',
		controller: function(FakturaService) {
			FakturaService.getPoslovneGodine()
				.then( (response) => {
					this.godine = response.data;
					this.selectedGodina = this.godine[0];
					this.changeGodina();
				});
			this.changeGodina = () => {
				FakturaService.getAllFromGodina(this.selectedGodina.id)
					.then( (response) => {
						this.fakture = response.data;
					});
			};

			this.first = () => {
				this.selected(this.fakture[0]);
			};
			this.previous = () => {
				let index = this.fakture.indexOf(this.selectedFaktura);
				if(index === 0)
					index = this.fakture.length;
				this.selected(this.fakture[index - 1]);
			};
			this.next = () => {
				let index = this.fakture.indexOf(this.selectedFaktura);
				if(index === this.fakture.length - 1)
					index = -1;
				this.selected(this.fakture[index + 1]);
			};
			this.last = () => {
				this.selected(this.fakture[this.fakture.length - 1]);
			};
			this.selected = (faktura) => {
				this.selectedFaktura = faktura;
			};

			this.report = (faktura) => {
				FakturaService.getReport(faktura.id)
					.then( (response) => {
						faktura.report = response.data.report;
					});
			};
			this.export = (faktura) => {
				FakturaService.getExport(faktura.id)
					.then( (response) => {
						faktura.export = response.data.faktura;
					});
			};
		}
	});
