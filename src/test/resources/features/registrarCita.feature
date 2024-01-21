Feature: Agendar Cita Veterinaria

  Scenario: El usuario agenda una cita para la mascota
    Given el usuario accede a la pagina de agendar citas
    When ingresa ID de mascota "2"
    And ingresa rut del dueno "123456789"
    And ingresa nombre de mascota "pepito"
    And ingresa hora "10:20"
    And ingresa fecha "01-01-2024"
    Then se muestra un mensaje de éxito "¡Tu Cita Está Confirmada!"