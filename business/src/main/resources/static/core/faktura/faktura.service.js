'use strict';

angular.module('core.faktura')
	.service('FakturaService', function($http) {
		let prefix = 'http://localhost:8080/api';

		this.getAll = () => {
			return $http.get(`${prefix}/fakture`);
		};
		this.getAllFromGodina = (id) => {
			return $http.get(`${prefix}/fakture/${id}`);
		};
		this.getStavke = () => {
			return $http.get(`${prefix}/stavke`);
		};
		this.getPoslovneGodine = () => {
			return $http.get(`${prefix}/poslovnegodine`);
		};
		this.getPoslovniPartneri = () => {
			return $http.get(`${prefix}/partneri`);
		};
		this.getOne = (id) => {
			return $http.get(`${prefix}/export/fakture/${id}`);
		};
		this.order = (data) => {
			return $http.post(`${prefix}/fakture`, data);
		};
	});
