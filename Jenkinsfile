pipeline {
    agent any

    environment {
        SYSTEM_PATH = "C:\\Windows\\System32"
        MAVEN_PATH = "C:\\DEV\\apache-maven-3.9.6\\bin"
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "${SYSTEM_PATH};${MAVEN_PATH};${JAVA_HOME}\\bin"
    }

    stages {
        stage('Preparación del proyecto') {
            steps {
                checkout scm
            }
        }
        
        stage('Construcción del proyecto') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Pruebas y resultados') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
    
    post {
        success {
            archiveArtifacts artifacts: '**/target/*.war', allowEmptyArchive: true
        }
    }
}
