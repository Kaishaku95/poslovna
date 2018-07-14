'use strict';

angular.module('core.proizvod')
	.service('ProizvodService', function($http) {
		let prefix = 'http://localhost:8080/api/proizvod';

		this.getAll = () => {
			return $http.get(`${prefix}/`);
		};
		this.getAllJM = () => {
			return $http.get(`${prefix}/jedinice`);
		};
		this.getAllVP = () => {
			return $http.get(`${prefix}/vrste`);
		};
		this.getAllGR = () => {
			return $http.get(`${prefix}/grupe`);
		};
		this.add = (data) => {
			return $http.post(`${prefix}/`, data);
		};
	});