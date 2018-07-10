'use strict';

angular.module('kif')
	.component('myKif', {
		templateUrl: '/part/kif/kif.template.html',
		controller: function(FakturaService) {
			this.getKif = () => {
				FakturaService.getKif(this.fromDate.getTime(), this.toDate.getTime())
					.then( (response) => {
						this.kif = response.data.report;
						this.status = 'Izveštaj izgenerisan uspešno';
					}, () => {
						this.kif = null;
						this.status = 'Greška';
					});
			};
		}
	});
