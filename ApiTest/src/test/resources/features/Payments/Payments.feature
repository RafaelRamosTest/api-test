@payments
Feature: Payments
	
@registrarPaymentsSucesso
Scenario: Deve registrar payments com sucesso informando valores validos
	Given que tenha informado valores validos
	When registrar payments
	Then deve retornar as informacoes de payments
	
@registrarPaymentsErro
Scenario: Nao deve registrar payments informando end_to_end invalido
	Given que tenha informado end_to_end invalido
	When registrar payments
	Then deve retornar erro 400 para payments
	And mensagem de erro end_to_end <mensagemErro>
	
	Examples: 
    | mensagemErro        |
    | "must not be blank" | # scenario
	
@registrarPaymentsErro2
Scenario: Nao deve registrar payments informando conciliation_id invalido
	Given que tenha informado conciliation_id invalido
	When registrar payments
	Then deve retornar erro 400 para payments
	And mensagem de erro conciliation_id <mensagemErro>
	
	Examples: 
    | mensagemErro        |
    | "must not be blank" | # scenario
	