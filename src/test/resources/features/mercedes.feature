# language: pt
@mercedes
Funcionalidade: Validar opcoes da mercedes

  Cenario: Testar iframe na pagina da mercedes
    Dado que eu acesse a pagina da mercedes e click em hatchbacks
    Quando selecionar o modelo A-class
    E selecionar a opcao build your car
    E filtrar por combustivel disel
    Então crio e salvo o print
