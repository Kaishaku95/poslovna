'use strict';

angular.module('app')
	.config(function($stateProvider, $urlRouterProvider, $compileProvider) {
		$stateProvider
			.state({
				name: 'home',
				redirectTo: 'cenovnici',
				url: '/',
			})
			.state({
				name: 'cenovnici',
				url: '/cenovnici',
				component: 'myCenovnikList'
			})
			.state({
				name: 'proizvodi',
				url: '/proizvodi',
				component: 'myProizvodList'
			})
			.state({
				name: 'fakture',
				url: '/fakture',
				component: 'myFakturaList'
			})
			.state({
				name: 'kif',
				url: '/kif',
				component: 'myKif'
			})
			.state({
				name: 'error',
				url: '/error',
				template: '<h1>Error 404</h1>'
			});

		$urlRouterProvider
			.when('', '/')
			.otherwise('/error');

		$compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|s?ftp|mailto|tel|file|data):/);
	});
