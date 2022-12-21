@accounts
Feature: Accounts
	
@consultarContaSucesso
Scenario: Deve consultar conta com sucesso informando id valido
	Given que tenha informado id da conta valido <accounts>
	When consultar conta
	Then deve retornar as informacoes da conta
	
	Examples: 
    | accounts                   |
    | "62f87af90ba501353df77b95" | # scenario
    | "630932fc327fb162f0d8e72c" | # scenario
    | "630933566e9f1d5128cf4c00" | # scenario
    
@consultarContaErro
Scenario: Nao deve consultar conta informando id invalido
	Given que tenha informado id da conta invalido <accounts>
	When consultar conta
	Then deve retornar retornar erro 404
	
	Examples: 
    | accounts    |
    | "123456789" | # scenario
    | ""          | # scenario
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    