'use strict';

angular.module('core.cenovnik')
	.service('CenovnikService', function($http) {
		let prefix = 'http://localhost:8080/api/cenovnik';

		this.getAll = () => {
			return $http.get(`${prefix}/`);
		};
		this.getOne = (id) => {
			return $http.get(`${prefix}/${id}`);
		};
		this.getStavke = (id) => {
			return $http.get(`${prefix}/stavke/${id}`);
		};
		this.add = (idOfCopy, data) => {
			return $http.post(`${prefix}/${idOfCopy}`, data);
		};
	});
