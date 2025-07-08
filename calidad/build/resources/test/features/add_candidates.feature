Feature: Agregar un nuevo candidato
  Como reclutador,
  quiero agregar una nueva postulación con los campos obligatorios: nombre completo, email,
  para registrar candidatos.

  Scenario: Agregar un candidato con todos los campos obligatorios y opcionales
    Given que estoy en el modulo de "Recruitment" en la pestana "Candidates"
    When hago clic en el boton "Add"
    And completo el campo "First Name" con "Andrea"
    And completo el campo "Last Name" con "Sánchez"
    And ingreso el email "andrea.sanchez@email.com"
    And hago clic en el botonn "Save"
    Then el candidato se registra exitosamente y aparece en la lista de candidatos "Andrea Sánchez"


