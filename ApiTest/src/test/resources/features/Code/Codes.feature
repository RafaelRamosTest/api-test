@codes
Feature: Codes
	
@registrarCodeSucesso
Scenario: Deve registrar code com sucesso informando qrcode valido
	Given que tenha informado qrcode valido <qrcode>
	When registrar code
	Then deve retornar as informacoes do code
	
	Examples: 
    | qrcode                     																								 |
    | "00020126330014BR.GOV.BCB.PIX011170326165690520400005303986540510.005802BR5911Builders016002SP62150511PAGAMENTO0163044312" | # scenario
    | "00020126330014BR.GOV.BCB.PIX011170326165690520400005303986540520.005802BR5911Builders016002SP62150511PAGAMENTO0163044312" | # scenario
    | "00020126330014BR.GOV.BCB.PIX011170326165690520400005303986540550.005802BR5911Builders016002SP62150511PAGAMENTO0163044312" | # scenario
    | "00020126330014BR.GOV.BCB.PIX011170326165690520400005303986540550.005802BR5911Builders016002SP62150512PAGAMENTO0163044312" | # scenario
    
@registrarCodeErro
Scenario: Nao Deve registrar code informando qrcode invalido
	Given que tenha informado qrcode invalido <qrcode>
	When registrar code
	Then deve retornar erro 404 para codes
	
	Examples: 
    | qrcode |
    | "123"  | # scenario
