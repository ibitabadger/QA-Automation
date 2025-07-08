#Author: Andrea
#Language: en

  Feature: Filtrar candidatos por criterios específicos
  Como reclutador,
  quiero filtrar candidatos por título del cargo
  para visualizar solo aquellos perfiles que se ajustan a lo que estoy buscando

    Scenario: Filtrar candidatos por Job Title
      Given que estoy en el módulo de "Recruitment" en la pestaña "Candidates"
      When selecciono el campo "Job Title" con valor "Software Engineer" de la lista desplegable
      And hago clic en el botón "Search"
      Then la lista de candidatos se actualiza mostrando solo los perfiles con "Software Engineer" como Job Title







