Feature: Resetear filtros

Scenario: Restablecer filtros con el botón "Reset"
Given que estoy en el módulo "Recruitment" en la pestaña "Candidates"
And selecciono el campo "Job Title" de valor "Software Engineer" de la lista desplegable
When hago click en el botón "Reset"
Then los filtros de búsqueda se muestran en su estado inicial