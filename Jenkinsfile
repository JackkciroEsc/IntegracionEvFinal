pipeline {
    agent any

    environment {
        SYSTEM_PATH = "C:\\Windows\\System32"
        MAVEN_PATH = "C:\\DEV\\apache-maven-3.9.6\\bin"
        PATH = "${SYSTEM_PATH};${MAVEN_PATH}"
    }

    stages {
        stage('Preparación del Proyecto') {
            steps {
                script {
                    // Clonar el repositorio remoto
                    checkout scml
                }
            }
        }

        stage('Construcción del Proyecto') {
            steps {
                script {
                    // Realizar la construcción del proyecto con Maven
                    bat 'mvn clean package'
                }
            }
        }

        stage('Pruebas y Generación de Reportes') {
            steps {
                script {
                    // Realizar las pruebas y guardar los resultados en un archivo XML con Maven
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            // Evidenciar el artefacto generado después de la compilación del proyecto
            archiveArtifacts artifacts: 'target/*.war', fingerprint: true
        }
    }
}
